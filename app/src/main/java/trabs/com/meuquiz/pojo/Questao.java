package trabs.com.meuquiz.pojo;

import java.util.List;

public class Questao {
    private int id;
    private String pergunta;
    private List<Resposta> resposta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public List<Resposta> getResposta() {
        return resposta;
    }

    public void setResposta(List<Resposta> resposta) {
        this.resposta = resposta;
    }

    @Override
    public boolean equals(Object o) {
        return this.id == ((Questao) o).id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }


}
