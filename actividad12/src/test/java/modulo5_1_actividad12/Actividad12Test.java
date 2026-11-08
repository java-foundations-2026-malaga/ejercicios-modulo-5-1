package modulo5_1_actividad12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class Actividad12Test {

    @Test
    void salidaEsperada() throws Exception {
        String salida = ejecutar();
        assertSalidaNumerica("2 cuadernos\nTotal: 7.0", salida);
    }

    @Test
    void compruebaCodigo() throws Exception {
        String codigo = leerCodigo();
        assertTrue(contiene(codigo, "\\boutOfStock\\b(?s:.*)\\boutOfStock\\b"), "Debe comprobarse outOfStock");
        assertTrue(contiene(codigo, "\\bquantity\\s*(==|!=|[<>]=?)|(==|!=|[<>]=?)\\s*quantity\\b"), "Debe compararse quantity con un operador relacional");
        assertTrue(contiene(codigo, "\\bquantity\\s*\\*\\s*price\\b|\\bprice\\s*\\*\\s*quantity\\b"), "El total debe calcularse con quantity * price");
    }

    private static String ejecutar() throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        Locale originalLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
        try {
            Actividad12.main(new String[0]);
        } finally {
            System.setOut(originalOut);
            Locale.setDefault(originalLocale);
        }
        String texto = buffer.toString(StandardCharsets.UTF_8).replace("\r\n", "\n").replace('\r', '\n');
        StringBuilder salida = new StringBuilder();
        for (String linea : texto.split("\n")) {
            salida.append(linea.strip()).append("\n");
        }
        return salida.toString().strip();
    }

    private static void assertSalidaNumerica(String esperada, String salida) {
        String[] lineasEsperadas = esperada.split("\n");
        String[] lineas = salida.split("\n");
        assertEquals(lineasEsperadas.length, lineas.length, "Número de líneas incorrecto. Salida obtenida:\n" + salida);
        Pattern numero = Pattern.compile("(.*?)(-?\\d+(\\.\\d+)?)");
        for (int i = 0; i < lineas.length; i++) {
            Matcher e = numero.matcher(lineasEsperadas[i]);
            Matcher a = numero.matcher(lineas[i]);
            if (e.matches() && a.matches() && e.group(1).equals(a.group(1))) {
                assertEquals(Double.parseDouble(e.group(2)), Double.parseDouble(a.group(2)), 1e-9,
                        "Valor incorrecto en la línea: " + lineas[i]);
            } else {
                assertEquals(lineasEsperadas[i], lineas[i]);
            }
        }
    }

    private static String leerCodigo() throws Exception {
        String codigo = Files.readString(Path.of("src/main/java/modulo5_1_actividad12/Actividad12.java"));
        return codigo.replaceAll("(?s)/\\*.*?\\*/", "").replaceAll("//[^\n]*", "");
    }

    private static boolean contiene(String codigo, String regex) {
        return Pattern.compile(regex).matcher(codigo).find();
    }
}
