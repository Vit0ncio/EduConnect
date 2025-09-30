package main.test.util;

public class ValidacaoUtil {
    
    public static boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    public static boolean validarSenha(String senha) {
        if (senha == null || senha.length() < 6) {
            return false;
        }
        return senha.matches(".*[A-Za-z].*") && senha.matches(".*\\d.*");
    }
    
    public static boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty() && nome.length() >= 2;
    }
    
    public static double calcularMedia(double... notas) {
        if (notas.length == 0) {
            return 0.0;
        }
        
        double soma = 0.0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }
}