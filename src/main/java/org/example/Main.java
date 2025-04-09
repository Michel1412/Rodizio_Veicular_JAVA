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

        System.out.print("Deseja caregar com base em:\n1 - Dia da semana\n2 - Final da Placa\nOpcao: ");
        int filter = scanner.nextInt();
        scanner.nextLine();

        switch (filter) {
            case 1:
                char[] filtroPlacas = RodizioService.getRestricaoByNumDiaDaSemana();

                if (filtroPlacas == null) {
                    System.out.println("Dia inválido.");
                    return;
                }

                ArquivoService.carregarVeiculos(ArquivoService.absolutPath, listaVeiculos, filtroPlacas);
                break;
            case 2:
                char[] filtroFinalPlacas = RodizioService.getFilterByFinalPlaca();

                if (filtroFinalPlacas == null) {
                    System.out.println("Final da placa Invalido.");
                    return;
                }

                ArquivoService.carregarVeiculos(ArquivoService.absolutPath, listaVeiculos, filtroFinalPlacas);
                break;
            default:
                System.out.println("Opcao Invalida.");

        }


        if (listaVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo está afetado pelo rodízio.");
            return;
        }

        boolean exit = false;

        while (!exit) {
            Veiculo veiculoAtual = listaVeiculos.getAtual();
            System.out.println(veiculoAtual);
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Próximo veículo\n0 - Sair");

            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    listaVeiculos.getProx();
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
