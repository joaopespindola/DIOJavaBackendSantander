package org.mockito;

import lombok.Getter;

@Getter
public class DadosLocalizacao {

    private String uf;
    private String cidade;
    private String logradouro;
    private String complemento;
    private String bairro;

    public DadosLocalizacao(final String uf, final String cidade, final String logradouro, final String complemento, final String bairro) {
        this.uf = uf;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
    }
}
