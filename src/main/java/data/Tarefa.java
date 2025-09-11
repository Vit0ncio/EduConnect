package main.java.data;

public class Tarefa {
    private String titulo;
    private String descricao;
    private String data;
    private boolean concluido;
    private String feedback;

    public Tarefa(String titulo, String descricao, String data, boolean concluido, String feedback) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.concluido = concluido;
        this.feedback = feedback;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public boolean isConcluido() {
        return concluido;
    }
    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
