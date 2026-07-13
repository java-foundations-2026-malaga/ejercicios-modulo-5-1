package modulo5_1_actividad15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class Actividad15Test {
  @Test
  void salidaEsperada() throws Exception {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
    try {
      Actividad15.main(new String[0]);
    } finally {
      System.setOut(originalOut);
    }
    String salida = buffer.toString(StandardCharsets.UTF_8).replace("\r\n", "\n").trim();
    assertEquals("You are the king of rock and roll", salida);
  }
}
