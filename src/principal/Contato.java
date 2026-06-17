package principal;

public class Contato {
    private String nome;
    private String telefone;
    private String email;
    private String cidade;

    public Contato(String nome, String telefone, String email, String cidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCidade() {
        return cidade;
    }

    public String toString() {
        return "Nome: " + nome + "\nTelefone: " + telefone + "\nE-mail: " + email + "\nCidade: " + cidade;
    }
}
