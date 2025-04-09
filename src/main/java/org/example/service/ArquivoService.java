package org.example.service;

import org.example.domain.Veiculo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoService {

    public static final String absolutPath = "D:\\Faculdade (2°semestre)\\EPOD - Estrutura 2\\Projetos-JAVA\\Rodizio_Veicular\\Rodizio_Veicular\\src\\main\\java\\org\\example\\in_memory_bucket\\rodizio_de_veiculos.txt";

    public static void carregarVeiculos(String filename, ListaCircularService listaVeiculos, char[] restricaoPlacas) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linha;
            br.readLine(); // Ignorar o cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] data = linha.split(",");

                if (data.length == 4) {
                    String placa = data[0].trim();
                    String marca = data[1].trim();
                    String modelo = data[2].trim();
                    String combustivel = data[3].trim();

                    char ultimoNum = placa.charAt(placa.length() - 1);
                    System.out.println("Placa: " + placa + " Final: " + ultimoNum);
                    System.out.println("Restricao[0]: " + restricaoPlacas[0] + " Restricao[1]: " + restricaoPlacas[1]);

                    if (ultimoNum == restricaoPlacas[0] || ultimoNum == restricaoPlacas[1]) {
                        System.out.println("Carregando veiculo...");
                        listaVeiculos.inserir_fim(new Veiculo(placa, marca, modelo, combustivel));
                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
