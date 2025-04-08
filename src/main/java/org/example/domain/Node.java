package org.example.domain;

public class Node {

    private Veiculo veiculo;

    private Node prox;

    public Node(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setProx(Node prox) {
        this.prox = prox;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Node getProx() {
        return prox;
    }
}
