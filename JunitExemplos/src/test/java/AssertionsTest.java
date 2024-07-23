import org.junit.Pessoa;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void validarLancamentos() {
        int[] primeiroLancamento = {0, 5, 10, 15};
        int[] segundoLancamento = {0, 5, 10, 15};

        assertArrayEquals(primeiroLancamento, segundoLancamento);
    }

    @Test
    void validarSeObjetoEhNulo() {
        Pessoa pessoa = null;
        assertNull(pessoa);

        pessoa = new Pessoa("Ciclano", LocalDate.now());
        assertNotNull(pessoa);
    }

}
