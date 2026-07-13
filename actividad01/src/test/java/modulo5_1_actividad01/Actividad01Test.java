package modulo5_1_actividad01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class Actividad01Test {
  @Test
  void salidaEsperada() throws Exception {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
    try {
      Actividad01.main(new String[0]);
    } finally {
      System.setOut(originalOut);
    }
    String salida = buffer.toString(StandardCharsets.UTF_8).replace("\r\n", "\n").trim();
    assertEquals("passed: true\nactive: true", salida);
  }
}
