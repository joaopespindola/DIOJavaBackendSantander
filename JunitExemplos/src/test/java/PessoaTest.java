import org.junit.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PessoaTest {

    @Test
    void deveCalcularIdadeCorretamente() {
        Pessoa joao = new Pessoa("Joao", LocalDate.of(2000, 9, 6));
        Assertions.assertEquals(24, joao.getIdade());
    }

    @Test
    void deveRetornarSeEhMaiorDeIdade() {
        Pessoa joao = new Pessoa("Joao", LocalDate.of(2000, 9, 6));
        Assertions.assertTrue(joao.ehMaiorDeIdade());
    }
}
