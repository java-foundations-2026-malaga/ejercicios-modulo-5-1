package modulo5_1_actividad14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class Actividad14Test {
  @Test
  void salidaEsperada() throws Exception {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
    try {
      Actividad14.main(new String[0]);
    } finally {
      System.setOut(originalOut);
    }
    String salida = buffer.toString(StandardCharsets.UTF_8).replace("\r\n", "\n").trim();
    assertEquals("12 es mayor que 7", salida);
  }
}
