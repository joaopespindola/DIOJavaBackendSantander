import org.junit.BancoDeDados;
import org.junit.Pessoa;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class ConsultarDadosPessoaTest {

    @BeforeAll
    static void configurarConexao() {
        BancoDeDados.iniciarConexao();
    }

    @BeforeEach
    void insereDadosParaTeste() {
        BancoDeDados.insereDados(new Pessoa("Joao", LocalDate.of(2000, 5, 12)));
    }

    @AfterEach
    void removeDadosDoTeste() {
        BancoDeDados.removeDados(new Pessoa("Joao", LocalDate.of(2000, 5, 12)));
    }

    @Test
    void validarDadosDeRetorno() {
        Assertions.assertTrue(true);
    }

    @Test
    void validarDadosDeRetorno2() {
        Assertions.assertNull(null);
    }

    @AfterAll
    static void fecharConexao() {
        BancoDeDados.finalizarConexao();
    }


}
