package org.example.service;

import java.util.Scanner;

public class RodizioService {

    private static final Scanner sc = new Scanner(System.in);

    public static char[] getRestricaoByNumDiaDaSemana() {
        System.out.println("Digite o dia da semana:");
        System.out.println("1 - Segunda-feira\n2 - Terça-feira\n3 - Quarta-feira\n4 - Quinta-feira\n5 - Sexta-feira");
        System.out.print("Opção: ");
        int day = sc.nextInt();
        sc.nextLine();

        return switch (day) {
            case 1 -> new char[]{'1', '2'};
            case 2 -> new char[]{'3', '4'};
            case 3 -> new char[]{'5', '6'};
            case 4 -> new char[]{'7', '8'};
            case 5 -> new char[]{'9', '0'};
            default -> null;
        };
    }

    public static char[] getFilterByFinalPlaca() {
        System.out.println("Digite o Final da Placa:");
        Integer finalPlaca = sc.nextInt();
        sc.nextLine();

        if (finalPlaca > 10 || finalPlaca < 0) {
            return null;
        }

        return new char[]{finalPlaca.toString().charAt(0), finalPlaca.toString().charAt(0)};
    }
}
