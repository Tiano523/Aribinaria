package principal;

public class No {
    private Contato contato;
    private No esquerda;
    private No direita;

    public No(Contato contato) {
        this.contato = contato;
        this.esquerda = null;
        this.direita = null;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}
