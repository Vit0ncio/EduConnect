package main.java.data;

public class Aluno extends Pessoa {
    private boolean presenca;

    public Aluno(int id, String nome, int idade, String email, String senha) {
        super(id, nome, idade, email, senha);
    }

    public boolean isPresenca() {
        return presenca;
    }
    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }
}
