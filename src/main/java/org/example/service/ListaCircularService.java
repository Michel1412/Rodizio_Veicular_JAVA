package org.example.service;

import org.example.domain.Node;
import org.example.domain.Veiculo;

public class ListaCircularService {

    private Node inicio = null;
    private Node fim = null;
    private Node atual = null;

    public void inserir_fim(Veiculo vehicle) {
        Node novo = new Node(vehicle);

        if (this.inicio == null) {
            this.inicio = novo;
            this.fim = novo;
            novo.setProx(this.inicio);

        } else {
            this.fim.setProx(novo);
            this.fim = novo;
            this.fim.setProx(this.inicio);
        }

        this.atual = this.inicio;
    }

    public Veiculo getAtual() {
        return this.atual != null ? this.atual.getVeiculo() : null;
    }

    public Veiculo getProx() {
        if (this.atual != null) {
            this.atual = this.atual.getProx();
            return this.atual.getVeiculo();
        }

        return null;
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public Veiculo getAnterior() {
        if (this.atual == null) {
            return null;
        }

        if (this.atual == this.inicio) {
            this.atual = this.fim;
        } else {
            Node aux = this.inicio;

            while (this.atual != aux.getProx()) {
                aux = aux.getProx();
            }

            this.atual = aux;
        }

        return this.atual.getVeiculo();
    }
}
