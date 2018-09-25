package trabs.com.meuquiz.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import trabs.com.meuquiz.pojo.Questao;
import trabs.com.meuquiz.pojo.Resposta;

public class QuestaoDAO {

    private String TABLE_QUESTAO = "Questao";
    private DbGateway gw;

    public QuestaoDAO(Context ctx) {
        gw = DbGateway.getInstance(ctx);
    }

    public void salvarPergunta(int id, String pergunta) {
        ContentValues cv = new ContentValues();
        cv.put("ID", id);
        cv.put("PERGUNTA", pergunta);
        gw.getDatabase().insert(TABLE_QUESTAO, null, cv);
    }

    public void salvarResposta(int idQuestao, String resposta, int respostaCerta) {
        ContentValues cv = new ContentValues();
        cv.put("IDQUESTAO", idQuestao);
        cv.put("RESPOSTA", resposta);
        cv.put("RESPOSTACERTA", respostaCerta);
        gw.getDatabase().insert("Resposta", null, cv);
    }

    public Questao retornarUm(int id) {
        Questao questao = new Questao();
        List<Resposta> respostas = null;
        String queryResposta = "SELECT * FROM Resposta WHERE IDQUESTAO =";

        Cursor cp = gw.getDatabase().rawQuery("SELECT * FROM Questao WHERE ID ="+id, null);

        while (cp.moveToNext()) {
            respostas = new ArrayList<>();

            questao.setId(cp.getInt(cp.getColumnIndex("ID")));
            questao.setPergunta(cp.getString(cp.getColumnIndex("PERGUNTA")));

            Cursor cr = gw.getDatabase().rawQuery(queryResposta + questao.getId(), null);

            while (cr.moveToNext()) {
                Resposta resp = new Resposta();

                resp.setIdQuestao(cr.getInt(cr.getColumnIndex("IDQUESTAO")));
                resp.setResposta(cr.getString(cr.getColumnIndex("RESPOSTA")));
                resp.setRespostaCerta(cr.getInt(cr.getColumnIndex("RESPOSTACERTA")));
                System.out.println(resp.getResposta());
                respostas.add(resp);
            }
            cr.close();
            questao.setResposta(respostas);
        }
        cp.close();
        return questao;

    }


    public List<Questao> retornarTodos() {
        List<Questao> questoes = new ArrayList<>();
        List<Resposta> respostas = null;
        Cursor cp = gw.getDatabase().rawQuery("SELECT * FROM Questao", null);
        String queryResposta = "SELECT * FROM Resposta WHERE IDQUESTAO =";

        while (cp.moveToNext()) {
            respostas = new ArrayList<>();
            Questao questao = new Questao();

            questao.setId(cp.getInt(cp.getColumnIndex("ID")));
            questao.setPergunta(cp.getString(cp.getColumnIndex("PERGUNTA")));

            Cursor cr = gw.getDatabase().rawQuery(queryResposta + questao.getId(), null);

            while (cr.moveToNext()) {
                Resposta resp = new Resposta();

                resp.setIdQuestao(cr.getInt(cr.getColumnIndex("IDQUESTAO")));
                resp.setResposta(cr.getString(cr.getColumnIndex("RESPOSTA")));
                resp.setRespostaCerta(cr.getInt(cr.getColumnIndex("RESPOSTACERTA")));
                System.out.println(resp.getResposta());
                respostas.add(resp);
            }
            cr.close();
            questao.setResposta(respostas);
            questoes.add(questao);
        }
        cp.close();
        return questoes;
    }

}
