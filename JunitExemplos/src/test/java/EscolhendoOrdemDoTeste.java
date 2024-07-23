import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EscolhendoOrdemDoTeste {

    @Order(3)
    @Test
    void validaFluxoA() {
        assertTrue(true);
    }

    @Order(2)
    @Test
    void validaFluxoB() {
        assertTrue(true);
    }

    @Order(1)
    @Test
    void validaFluxoC() {
        assertTrue(true);
    }
}
