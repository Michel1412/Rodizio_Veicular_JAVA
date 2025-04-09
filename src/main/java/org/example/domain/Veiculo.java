package org.example.domain;

public class Veiculo {

    private String placa;
    private String modelo;
    private String marca;
    private String combustivel;

    public Veiculo(String placa, String marca, String modelo, String combustivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.combustivel = combustivel;
    }

    @Override
    public String toString() {
        return String.format("Placa: %s, Modelo: %s, Marca: %s, Combustível: %s",
                this.placa, this.modelo, this.marca, this.combustivel);
    }
}
