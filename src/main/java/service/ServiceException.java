package main.java.service;

public class ServiceException extends RuntimeException {
    public ServiceException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    public ServiceException(String mensagem) {
        super(mensagem);
    }
}
