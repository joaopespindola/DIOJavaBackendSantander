package org.mockito;

import lombok.Getter;

@Getter
public class Email {

    private String enderecoEmail;

    private String mensagem;

    private Formato formato;

    public Email(String enderecoEmail, String mensagem, Formato formato) {
        this.enderecoEmail = enderecoEmail;
        this.mensagem = mensagem;
        this.formato = formato;
    }

}
