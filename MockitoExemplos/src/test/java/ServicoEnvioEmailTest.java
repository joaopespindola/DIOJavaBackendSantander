import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTest {

    @Mock
    private PlataformaDeEnvio plataforma;

    @InjectMocks
    private ServicoEnvioEmail servico;

    @Captor
    private ArgumentCaptor<Email> emailCaptor;

    @Test
    public void validaSeEmailEstaComDadosCorretos() {

        String email = "joao@ufu.br";
        String mensagem = "teste";

        servico.enviaEmail(email, mensagem, true);
        Mockito.verify(plataforma).enviaEmail(emailCaptor.capture());

        Email emailCapturado = emailCaptor.getValue();
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(email, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(Formato.HTML, emailCapturado.getFormato());
    }

}
