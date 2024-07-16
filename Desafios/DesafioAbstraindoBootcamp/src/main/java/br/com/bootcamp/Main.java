package br.com.bootcamp;

import br.com.bootcamp.dominio.*;
import br.com.bootcamp.exceptions.BootcampNotFoundException;
import br.com.bootcamp.exceptions.ContentNotFoundException;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bootcamp bootcamp = null;
        Set<Programador> programadoresAdicionados = new LinkedHashSet<>();

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Criar Bootcamp");
            System.out.println("2. Adicionar Programador");
            System.out.println("3. Cadastrar Programador no Bootcamp");
            System.out.println("4. Progredir Programador no Bootcamp");
            System.out.println("5. Exibir Programadores Inscritos no Bootcamp");
            System.out.println("6. Exibir Status do Programador no Bootcamp");
            System.out.println("7. Exibir Programadores Adicionados na Plataforma");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do Bootcamp: ");
                        String nomeBootcamp = scanner.nextLine();
                        System.out.print("Digite a descrição do Bootcamp: ");
                        String descricaoBootcamp = scanner.nextLine();
                        LinkedHashSet<Conteudo> conteudos = new LinkedHashSet<>();
                        Curso curso = Curso.builder()
                                .titulo("Java")
                                .descricao("Curso de Java")
                                .cargaHoraria(40)
                                .build();
                        conteudos.add(curso);
                        Mentoria mentoria = Mentoria.builder()
                                .titulo("MentoriaJava")
                                .descricao("Tire suas duvidas sobre Java")
                                .data(LocalDate.now())
                                .build();
                        conteudos.add(mentoria);
                        bootcamp = new Bootcamp(nomeBootcamp, descricaoBootcamp, conteudos);
                        System.out.println("Bootcamp criado com sucesso!");
                        break;
                    case 2:
                        if (bootcamp == null) {
                            throw new BootcampNotFoundException("Por favor, crie um Bootcamp primeiro.");
                        }
                        System.out.print("Digite o nome do Programador: ");
                        String nomeProgramador = scanner.nextLine();
                        Programador programador = new Programador();
                        programador.setNome(nomeProgramador);
                        programadoresAdicionados.add(programador);
                        System.out.println("Programador adicionado com sucesso!");
                        break;
                    case 3:
                        if (bootcamp == null) {
                            throw new BootcampNotFoundException("Por favor, crie um Bootcamp primeiro.");
                        }
                        System.out.print("Digite o nome do Programador: ");
                        nomeProgramador = scanner.nextLine();
                        programador = encontrarProgramador(programadoresAdicionados, nomeProgramador);
                        if (programador != null) {
                            programador.inscreverBootcamp(bootcamp);
                            programadoresAdicionados.remove(programador);
                            System.out.println("Programador inscrito com sucesso!");
                        } else {
                            throw new ContentNotFoundException("Programador não encontrado.");
                        }
                        break;
                    case 4:
                        if (bootcamp == null) {
                            throw new BootcampNotFoundException("Por favor, crie um Bootcamp primeiro.");
                        }
                        System.out.print("Digite o nome do Programador: ");
                        nomeProgramador = scanner.nextLine();
                        programador = encontrarProgramador(bootcamp.getProgramadoresInscritos(), nomeProgramador);
                        if (programador != null) {
                            programador.progredir();
                            System.out.println("Programador progrediu com sucesso!");
                        } else {
                            throw new ContentNotFoundException("Programador não encontrado.");
                        }
                        break;
                    case 5:
                        if (bootcamp == null) {
                            throw new BootcampNotFoundException("Por favor, crie um Bootcamp primeiro.");
                        }
                        System.out.println("Programadores Inscritos:");
                        for (Programador p : bootcamp.getProgramadoresInscritos()) {
                            System.out.println(" - " + p.getNome());
                        }
                        break;
                    case 6:
                        if (bootcamp == null) {
                            throw new BootcampNotFoundException("Por favor, crie um Bootcamp primeiro.");
                        }
                        System.out.print("Digite o nome do Programador: ");
                        nomeProgramador = scanner.nextLine();
                        programador = encontrarProgramador(bootcamp.getProgramadoresInscritos(), nomeProgramador);
                        if (programador != null) {
                            System.out.println("Programador: " + programador.getNome());
                            System.out.println("Conteúdos Inscritos:");
                            for (Conteudo conteudo : programador.getConteudosInscritos()) {
                                System.out.println(" - " + conteudo.getTitulo());
                            }
                            System.out.println("Conteúdos Concluídos: ");
                            for (Conteudo conteudo : programador.getConteudosConcluidos()) {
                                System.out.println(" - " + conteudo.getTitulo());
                            }
                            System.out.println("Total XP: " + programador.calcularTotalXp());
                        } else {
                            throw new ContentNotFoundException("Programador não encontrado.");
                        }
                        break;
                    case 7:
                        if (bootcamp == null) {
                            throw new BootcampNotFoundException("Por favor, crie um Bootcamp primeiro.");
                        }else if(programadoresAdicionados.isEmpty()){
                            System.out.println("Nenhum programador escrito na plataforma.");
                            break;
                        }
                        System.out.println("Programadores Na Plataforma:");
                        for (Programador p : programadoresAdicionados) {
                            System.out.println(" - " + p.getNome());
                        }
                        break;
                    case 8:
                        System.out.println("Saindo...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static Programador encontrarProgramador(Set<Programador> programadores, String nome) {
        return programadores.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
    }
}
