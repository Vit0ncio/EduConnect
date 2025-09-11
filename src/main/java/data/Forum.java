package main.java.data;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private int id;
    private final String topico;
    private List<ForumPost> posts = new ArrayList<>();
    
    public Forum(String topico) {
        this.topico = topico;
        this.posts = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;   
    }
    
    public List<ForumPost> getPosts() {
        return posts;
    }
    public void setPosts(List<ForumPost> posts) {
        this.posts = posts;
    }
    
    public String getTopico() {
        return topico;
    }
    
    public void addPost(ForumPost post) {
        posts.add(post);
    }
}