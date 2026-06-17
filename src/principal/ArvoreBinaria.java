package principal;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean inserir(Contato contato) {
        if (raiz == null) {
            raiz = new No(contato);
            return true;
        }

        return inserir(raiz, contato);
    }

    private boolean inserir(No atual, Contato contato) {
        int comparacao = comparar(contato.getNome(), atual.getContato().getNome());

        if (comparacao == 0) {
            return false;
        }

        if (comparacao < 0) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(new No(contato));
                return true;
            }

            return inserir(atual.getEsquerda(), contato);
        }

        if (atual.getDireita() == null) {
            atual.setDireita(new No(contato));
            return true;
        }

        return inserir(atual.getDireita(), contato);
    }

    public Contato buscar(String nome) {
        return buscar(raiz, nome);
    }

    private Contato buscar(No atual, String nome) {
        if (atual == null) {
            return null;
        }

        int comparacao = comparar(nome, atual.getContato().getNome());

        if (comparacao == 0) {
            return atual.getContato();
        }

        if (comparacao < 0) {
            return buscar(atual.getEsquerda(), nome);
        }

        return buscar(atual.getDireita(), nome);
    }

    public boolean remover(String nome) {
        if (buscar(nome) == null) {
            return false;
        }

        raiz = remover(raiz, nome);
        return true;
    }

    private No remover(No atual, String nome) {
        if (atual == null) {
            return null;
        }

        int comparacao = comparar(nome, atual.getContato().getNome());

        if (comparacao < 0) {
            atual.setEsquerda(remover(atual.getEsquerda(), nome));
            return atual;
        }

        if (comparacao > 0) {
            atual.setDireita(remover(atual.getDireita(), nome));
            return atual;
        }

        if (atual.getEsquerda() == null) {
            return atual.getDireita();
        }

        if (atual.getDireita() == null) {
            return atual.getEsquerda();
        }

        No sucessor = menorNo(atual.getDireita());
        atual.setContato(sucessor.getContato());
        atual.setDireita(remover(atual.getDireita(), sucessor.getContato().getNome()));
        return atual;
    }

    public void exibirEmOrdem() {
        if (raiz == null) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        exibirEmOrdem(raiz);
    }

    private void exibirEmOrdem(No atual) {
        if (atual != null) {
            exibirEmOrdem(atual.getEsquerda());
            imprimirContato(atual.getContato());
            exibirEmOrdem(atual.getDireita());
        }
    }

    public void exibirPreOrdem() {
        if (raiz == null) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        exibirPreOrdem(raiz);
    }

    private void exibirPreOrdem(No atual) {
        if (atual != null) {
            imprimirContato(atual.getContato());
            exibirPreOrdem(atual.getEsquerda());
            exibirPreOrdem(atual.getDireita());
        }
    }

    public void exibirPosOrdem() {
        if (raiz == null) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        exibirPosOrdem(raiz);
    }

    private void exibirPosOrdem(No atual) {
        if (atual != null) {
            exibirPosOrdem(atual.getEsquerda());
            exibirPosOrdem(atual.getDireita());
            imprimirContato(atual.getContato());
        }
    }

    public Contato primeiroContato() {
        No menor = menorNo(raiz);

        if (menor == null) {
            return null;
        }

        return menor.getContato();
    }

    public Contato ultimoContato() {
        No maior = maiorNo(raiz);

        if (maior == null) {
            return null;
        }

        return maior.getContato();
    }

    private No menorNo(No atual) {
        if (atual == null) {
            return null;
        }

        if (atual.getEsquerda() == null) {
            return atual;
        }

        return menorNo(atual.getEsquerda());
    }

    private No maiorNo(No atual) {
        if (atual == null) {
            return null;
        }

        if (atual.getDireita() == null) {
            return atual;
        }

        return maiorNo(atual.getDireita());
    }

    public int quantidade() {
        return quantidade(raiz);
    }

    private int quantidade(No atual) {
        if (atual == null) {
            return 0;
        }

        return 1 + quantidade(atual.getEsquerda()) + quantidade(atual.getDireita());
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(No atual) {
        if (atual == null) {
            return 0;
        }

        int alturaEsquerda = altura(atual.getEsquerda());
        int alturaDireita = altura(atual.getDireita());

        if (alturaEsquerda > alturaDireita) {
            return alturaEsquerda + 1;
        }

        return alturaDireita + 1;
    }

    private int comparar(String primeiroNome, String segundoNome) {
        return primeiroNome.compareToIgnoreCase(segundoNome);
    }

    private void imprimirContato(Contato contato) {
        System.out.println(contato);
        System.out.println("------------------------------");
    }
}
