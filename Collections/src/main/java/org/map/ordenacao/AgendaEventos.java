package org.map.ordenacao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nomeEvento, String nomeAtracao) {
        eventosMap.put(data, new Evento(nomeEvento, nomeAtracao));
    }

    public void exibirAgenda() {
        // Por ser um TreeMap que tem a LocalDate como key, e a LocalDate por sua vez implementa ChronoLocalDate
        // que por sua vez extende da Comparable a LocalDate já sabe como ordenar seus elementos em ordem crescente.
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {
        LocalDate dataAgora = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap); // Eventos ordenados de maneira crescente
        for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()) {
            if (entry.getKey().isEqual(dataAgora) || entry.getKey().isAfter(dataAgora)) {
                System.out.println("O proximo evento eh " + entry.getValue().getNomeEvento() + " e acontecera em " + entry.getKey());
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agenda = new AgendaEventos();
        agenda.adicionarEvento(LocalDate.of(2024, 7, 1), "Conferência de Tecnologia", "Dr. Tech");
        agenda.adicionarEvento(LocalDate.of(2024, 7, 29), "Workshop de IA", "Prof. AI");
        agenda.adicionarEvento(LocalDate.of(2024, 8, 5), "Feira de Inovação", "Innovators");

        System.out.println("Agenda de Eventos:");
        agenda.exibirAgenda();

        agenda.obterProximoEvento();
    }
}
