package trabs.com.meuquiz.pojo;

import java.io.Serializable;
import java.util.List;

public class Resposta implements Serializable {

    private String resposta;
    private int respostaCerta;
    private int idQuestao;


    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(int respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }
}
