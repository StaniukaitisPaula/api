package br.com.fiap.acolher.infra.exception;

public class UniqueException extends RuntimeException {
    public UniqueException(String mensagem) {
        super(mensagem);
    }
}
