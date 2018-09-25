package trabs.com.meuquiz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import trabs.com.meuquiz.R;
import trabs.com.meuquiz.banco.QuestaoDAO;
import trabs.com.meuquiz.pojo.Questao;
import trabs.com.meuquiz.pojo.Resposta;
import trabs.com.meuquiz.util.RespostaAdapter;

public class QuizActivity extends AppCompatActivity {

    List<Questao> questoes = new ArrayList<>(); ;
    List<Resposta> respostas =  new ArrayList<>();

    RecyclerView recyclerView;
    RespostaAdapter adapter;
    TextView pergunta;

    int respostaCerta = 0, pontos = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        pergunta = (TextView) findViewById(R.id.pergunta);

        QuestaoDAO dao = new QuestaoDAO(this);

        //pega a quantidade de questões
        int tamanho = dao.retornarTodos().size();
        int numero;
        int[] num = new int[10];
        Random r = new Random();

        //faz um random para pegar numeros aleatorios nao repetidos
        for(int i=0; i<num.length; i++){
            numero = r.nextInt(tamanho) + 1;
            for(int j=0; j<num.length; j++){
                if(numero == num[j] && j != i){
                    numero = r.nextInt(tamanho) + 1;
                }else{
                    num[i] = numero;
                }
            }
        }
        //faz a busca e adiciona a questao a um array de questoes
        for(int i=0; i<num.length; i++){
            questoes.add(dao.retornarUm(num[i]));
        }


        carregarQuestao();
        configurarRecycler();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        carregarQuestao();
        configurarRecycler();
    }


    //verifica se a lista de questoes nao esta vazia e seta no TextView a pergunta
    private void carregarQuestao() {
        if (questoes.size() > 0) {
            Questao q = questoes.remove(0);
            pergunta.setText(q.getPergunta());

            //carrega a lista de resposta da questao para um novo arraylist
            this.respostas = q.getResposta();

        } else {
            Intent intent = new Intent(this, RespostaActivity.class);
            intent.putExtra("pontos", pontos);
            startActivity(intent);
            finish();
        }

    }

    public void btnResponderOnClick(View view) {

        Intent intent = new Intent(this, RespostaActivity.class);


        //recupera do adapter a resposta selecionada para verificar se e a correta
        //1 - certa, 0 - errada
        respostaCerta = adapter.getResposta();

        if (respostaCerta == 1) {
            intent.putExtra("resp", true);
            intent.putExtra("acertou", true);
            pontos++;
        } else {
            intent.putExtra("resp", true);
        }

        intent.putExtra("pontos", pontos);
        startActivity(intent);

    }


    //lista de resposta
    private void configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //cria um adapter, passando a lista de respostas carregada anteriormente
        adapter = new RespostaAdapter(this, respostas);

        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}