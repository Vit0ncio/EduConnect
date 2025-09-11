package main.java.data;

public class ForumPost {
    private int id;
    private Forum forum;
    private Pessoa autor;
    private String titulo;
    private String descricao;
    private boolean fixado;
    private int upvotes;
    private boolean favoritado;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public Forum getForum() { return forum; }
    public void setForum(Forum forum) { this.forum = forum; }
    
    public Pessoa getAutor() { return autor; }
    public void setAutor(Pessoa autor) { this.autor = autor; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public boolean isFixado() { return fixado; }
    public void setFixado(boolean fixado) { this.fixado = fixado; }
        
    public int getUpvotes() { return upvotes; }
    public void setUpvotes(int upvotes) { this.upvotes = upvotes; }
        
    public boolean isFavoritado() { return favoritado; }
    public void setFavoritado(boolean favoritado) { this.favoritado = favoritado; }
}