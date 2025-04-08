package org.example.service;

public class RodizioService {

    public static char[] getRestricaoByNumDiaDaSemana(int day) {
        return switch (day) {
            case 1 -> new char[]{'1', '2'};
            case 2 -> new char[]{'3', '4'};
            case 3 -> new char[]{'5', '6'};
            case 4 -> new char[]{'7', '8'};
            case 5 -> new char[]{'9', '0'};
            default -> null;
        };
    }
}
