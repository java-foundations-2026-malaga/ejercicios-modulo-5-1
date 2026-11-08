package modulo5_1_actividad14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class Actividad14Test {

    @Test
    void salidaEsperada() throws Exception {
        String salida = ejecutar();
        assertEquals("12 es mayor que 7", salida);
    }

    @Test
    void compruebaCodigo() throws Exception {
        String codigo = leerCodigo();
        assertTrue(contiene(codigo, "\\bfirst\\s*[<>]=?\\s*second\\b|\\bsecond\\s*[<>]=?\\s*first\\b"), "Debe compararse first con second");
        assertTrue(contiene(codigo, "\\belse\\b"), "Debe usarse else para los otros casos");
    }

    private static String ejecutar() throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        Locale originalLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
        try {
            Actividad14.main(new String[0]);
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

    private static String leerCodigo() throws Exception {
        String codigo = Files.readString(Path.of("src/main/java/modulo5_1_actividad14/Actividad14.java"));
        return codigo.replaceAll("(?s)/\\*.*?\\*/", "").replaceAll("//[^\n]*", "");
    }

    private static boolean contiene(String codigo, String regex) {
        return Pattern.compile(regex).matcher(codigo).find();
    }
}
