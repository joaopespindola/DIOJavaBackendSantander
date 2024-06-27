package org.set.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadosSet;

    public ConjuntoConvidados() {
        convidadosSet = new HashSet<>() {
        };
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidadosSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Convidado convidadoParaRemover = null;

        for(Convidado convidado : convidadosSet){
            if(convidado.getCodigoConvite() == codigoConvite){
                convidadoParaRemover = convidado;
                break; // Pois nao tera outro com o mesmo "coidgoConvite" por se tratar de um set
            }
        }
        convidadosSet.remove(convidadoParaRemover);
    }

    public int contarConvidados(){
        return convidadosSet.size();
    }

    public void exibirConvidados(){
        for(Convidado convidado : convidadosSet){
            System.out.println(convidado);
        }
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoSet = new ConjuntoConvidados();
        conjuntoSet.adicionarConvidado("Gabriel", 1);
        conjuntoSet.adicionarConvidado("Joao", 2);
        conjuntoSet.adicionarConvidado("Daniel", 3);
        conjuntoSet.adicionarConvidado("Josue", 3);// Josue nao deve ser inserido pois tem o mesmo codigoConvite

        conjuntoSet.exibirConvidados();
        conjuntoSet.removerConvidadoPorCodigoConvite(2);
        conjuntoSet.exibirConvidados();
        System.out.println(conjuntoSet.contarConvidados());
    }
}
