package br.com.bluesoft.desafio.representation;

public class ErroRepresentation {
    
    private final String mensagem;

    public ErroRepresentation(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
