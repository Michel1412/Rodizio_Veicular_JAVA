package org.example.domain;

public class Veiculo {

    private String placa;
    private String modelo;
    private String marca;
    private String combustivel;
    private String permissao;

    public Veiculo(String placa, String marca, String modelo, String combustivel, String permissao) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.combustivel = combustivel;
        this.permissao = permissao;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getCombustivel() {
        return this.combustivel;
    }

    @Override
    public String toString() {
        return String.format("Placa: %s, Modelo: %s, Marca: %s, Combustível: %s Permissao para rodar: %s",
                this.placa, this.modelo, this.marca, this.combustivel, this.permissao);
    }
}
