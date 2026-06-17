package principal;

import java.util.Scanner;

public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static ArvoreBinaria agenda = new ArvoreBinaria();

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();
            opcao = lerInteiro("Escolha uma opcao: ");
            executarOpcao(opcao);
        } while (opcao != 11);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("===== SISTEMA DE AGENDA TELEFONICA =====");
        System.out.println("1. Inserir contato");
        System.out.println("2. Buscar contato");
        System.out.println("3. Remover contato");
        System.out.println("4. Exibir contatos em ordem alfabetica");
        System.out.println("5. Exibir contatos em pre-ordem");
        System.out.println("6. Exibir contatos em pos-ordem");
        System.out.println("7. Mostrar primeiro contato alfabeticamente");
        System.out.println("8. Mostrar ultimo contato alfabeticamente");
        System.out.println("9. Mostrar quantidade de contatos");
        System.out.println("10. Mostrar altura da arvore");
        System.out.println("11. Encerrar sistema");
    }

    private static void executarOpcao(int opcao) {
        System.out.println();

        switch (opcao) {
            case 1:
                inserirContato();
                break;
            case 2:
                buscarContato();
                break;
            case 3:
                removerContato();
                break;
            case 4:
                agenda.exibirEmOrdem();
                break;
            case 5:
                agenda.exibirPreOrdem();
                break;
            case 6:
                agenda.exibirPosOrdem();
                break;
            case 7:
                mostrarContatoEspecial(agenda.primeiroContato(), "Primeiro contato alfabeticamente:");
                break;
            case 8:
                mostrarContatoEspecial(agenda.ultimoContato(), "Ultimo contato alfabeticamente:");
                break;
            case 9:
                System.out.println("Quantidade de contatos: " + agenda.quantidade());
                break;
            case 10:
                System.out.println("Altura da arvore: " + agenda.altura());
                break;
            case 11:
                System.out.println("Sistema encerrado.");
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    private static void inserirContato() {
        String nome = lerTextoObrigatorio("Nome: ");
        String telefone = lerTextoObrigatorio("Telefone: ");
        String email = lerTextoObrigatorio("E-mail: ");
        String cidade = lerTextoObrigatorio("Cidade: ");

        Contato contato = new Contato(nome, telefone, email, cidade);
        boolean inseriu = agenda.inserir(contato);

        if (inseriu) {
            System.out.println("Contato inserido com sucesso.");
        } else {
            System.out.println("Ja existe um contato cadastrado com esse nome.");
        }
    }

    private static void buscarContato() {
        String nome = lerTextoObrigatorio("Nome do contato para buscar: ");
        Contato contato = agenda.buscar(nome);

        if (contato == null) {
            System.out.println("Contato nao encontrado.");
        } else {
            System.out.println("Contato encontrado:");
            System.out.println(contato);
        }
    }

    private static void removerContato() {
        String nome = lerTextoObrigatorio("Nome do contato para remover: ");
        boolean removeu = agenda.remover(nome);

        if (removeu) {
            System.out.println("Contato removido com sucesso.");
        } else {
            System.out.println("Contato nao encontrado.");
        }
    }

    private static void mostrarContatoEspecial(Contato contato, String titulo) {
        if (contato == null) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            System.out.println(titulo);
            System.out.println(contato);
        }
    }

    private static String lerTextoObrigatorio(String mensagem) {
        String texto;

        do {
            System.out.print(mensagem);
            texto = scanner.nextLine().trim();

            if (texto.length() == 0) {
                System.out.println("Campo obrigatorio.");
            }
        } while (texto.length() == 0);

        return texto;
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();

            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException erro) {
                System.out.println("Digite um numero valido.");
            }
        }
    }
}
