package org.example;
import org.example.domain.Veiculo;
import org.example.service.ArquivoService;
import org.example.service.ListaCircularService;
import org.example.service.RodizioService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCircularService listaVeiculos = new ListaCircularService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o dia da semana:");
        System.out.println("1 - Segunda-feira\n2 - Terça-feira\n3 - Quarta-feira\n4 - Quinta-feira\n5 - Sexta-feira");
        System.out.print("Opção: ");
        int day = scanner.nextInt();
        scanner.nextLine();

        char[] restricaoPlacas = RodizioService.getRestricaoByNumDiaDaSemana(day);

        if (restricaoPlacas == null) {
            System.out.println("Dia inválido.");
            return;
        }

        ArquivoService.carregarVeiculos(ArquivoService.absolutPath, listaVeiculos, restricaoPlacas);

        if (listaVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo está afetado pelo rodízio.");
            return;
        }

        boolean exit = false;

        while (!exit) {
            Veiculo veiculoAtual = listaVeiculos.getAtual();
            System.out.println(veiculoAtual);
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Próximo veículo\n2 - Anterior\n0 - Sair");

            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    listaVeiculos.getProx();
                    break;
                case 2:
                    listaVeiculos.getAnterior();
                    break;
                default:
                    if (option != 0) {
                        System.out.println("Opção inválida. Saido do programa.");
                    }
                    exit = true;
            }
        }
    }
}
