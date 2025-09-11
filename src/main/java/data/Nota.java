package main.java.data;

public class Nota {
    private int id;
    private String materia;
    private int semestre;
    private double valor;
    private Pessoa aluno;

    public Nota(int id, String materia, int semestre, double valor, Pessoa aluno) {
        this.id = id;
        this.materia = materia;
        this.semestre = semestre;
        this.valor = valor;
        this.aluno = aluno;
    }

    public int getId() { return id; }
    public String getMateria() { return materia; }
    public int getSemestre() { return semestre; }
    public double getValor() { return valor; }
    public Pessoa getAluno() { return aluno; }

    public void setValor(double valor) { this.valor = valor; }
}
