import org.example.Conta;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaTest {
    @Test
    void testImprimeExtrato() {
        Conta conta = new Conta(123, "Agência", "Cliente", BigDecimal.valueOf(1000));
        String expected = "Olá Cliente, obrigado por criar uma conta em nosso banco, sua agência é Agência, conta 123 e seu saldo 1000 já está disponível para saque";
        assertEquals(expected, conta.imprimeExtrato());
    }
}
