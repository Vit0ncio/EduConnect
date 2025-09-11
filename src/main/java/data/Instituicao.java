package main.java.data;

public class Instituicao extends Pessoa {
    private String cnpj;

    public Instituicao(int id, String nome, int idade, String email, String senha, String cnpj) {
        super(id, nome, idade, email, senha);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}