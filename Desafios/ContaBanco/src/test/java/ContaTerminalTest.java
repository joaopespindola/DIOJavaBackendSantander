import org.example.ContaTerminal;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaTerminalTest {

    @Test
    void testCriarContaDoUsuarioComEntradaInvalida() {
        String input = "\nJoao Pedro\nAgência\n-123\n1000";
        InputStream in = new ByteArrayInputStream(input.getBytes()); //Para simular o fluxo de entrada
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThrows(RuntimeException.class, () -> ContaTerminal.criarContaDoUsuario(scanner));
    }
}
