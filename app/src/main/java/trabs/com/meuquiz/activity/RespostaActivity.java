package trabs.com.meuquiz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import trabs.com.meuquiz.R;

public class RespostaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);
        getSupportActionBar().hide();

        ImageView imgResposta = (ImageView) findViewById(R.id.imgResposta);
        TextView resposta = (TextView) findViewById(R.id.resposta);
        Button btnJogarNovamente = (Button) findViewById(R.id.btnJogarNovamente);

        Intent intent = getIntent();
        int pontos = intent.getIntExtra("pontos", 0);

        if (intent.hasExtra("resp")) {
            btnJogarNovamente.setVisibility(View.INVISIBLE);
            boolean acertou = intent.getBooleanExtra("acertou", false);
            if (acertou) {
                imgResposta.setImageResource(R.drawable.ic_checked);
                resposta.setText("Acertou! Seus pontos:" + pontos);
            } else {
                imgResposta.setImageResource(R.drawable.ic_cancel);
                resposta.setText("Errou! Seus pontos:" + pontos);
            }

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            });
            thread.start();
        } else {
            btnJogarNovamente.setVisibility(View.VISIBLE);

            if (pontos >= 4 && pontos < 7 ) {
                imgResposta.setImageResource(R.drawable.ic_superman);
                resposta.setText("Você está proximo de se tornar um novo Super Heroi!" +
                        "Fez " + pontos + " pontos!");

            } else if(pontos >= 7){
                imgResposta.setImageResource(R.drawable.ic_avengers);
                resposta.setText("Você já ouviu falar da iniciativa Vingadores?\n" +
                        "Seu " + pontos + " pontos ");

            }else{
                imgResposta.setImageResource(R.drawable.ic_hero);
                resposta.setText("Não fique Triste! Você está no caminho certo\n" +
                        "Seus " + pontos + " pontos!");


            }

        }

    }

    public void btnJogarNovamenteOnClick(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
        finish();
    }
}
