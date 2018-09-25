package trabs.com.meuquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import trabs.com.meuquiz.activity.QuizActivity;
import trabs.com.meuquiz.apiUtil.RestRequest;
import trabs.com.meuquiz.banco.QuestaoDAO;
import trabs.com.meuquiz.pojo.Pessoa;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instancia a classe resposavel pela comunicação com o banco
        QuestaoDAO dao = new QuestaoDAO(getBaseContext());

        //verifica se o banco esta vazio, para evitar inserções duplicadas
        if (dao.retornarTodos().isEmpty()) {
            dao.salvarPergunta(1, "Em guia do Mochileiro das Galáxias, qual a resposta para a vida e o universo e tudo mais?");
            dao.salvarResposta(1, "Não existe", 0);
            dao.salvarResposta(1, "Amor", 0);
            dao.salvarResposta(1, "Um sabre de Luz", 0);
            dao.salvarResposta(1, "42", 1);
            dao.salvarResposta(1, "785,44", 0);

            dao.salvarPergunta(2, "Quantos episódios tem a saga Star-Wars até o momento (2018)?");
            dao.salvarResposta(2, "8", 1);
            dao.salvarResposta(2, "6", 0);
            dao.salvarResposta(2, "5", 0);
            dao.salvarResposta(2, "3 e uma edição bônus", 1);
            dao.salvarResposta(2, "7", 0);

            dao.salvarPergunta(3, "Quais as cores de sabre de luz existentes até o momento em Star-Wars?");
            dao.salvarResposta(3, "Laranja, azul, preto, vermelho e roxo", 0);
            dao.salvarResposta(3, "Azul, vermelho, verde e rosa", 0);
            dao.salvarResposta(3, "Vermelho, Preto e azul", 0);
            dao.salvarResposta(3, "Vermelho, Azul, Roxo e Verde", 1);
            dao.salvarResposta(3, "Preto, Branco e Ômega(Roxo+vermelho+laranja)", 0);

            dao.salvarPergunta(4, "Qual o planeta natal de Spock, o ser lógico da série e saga de filmes 'Star Trek'?");
            dao.salvarResposta(4, "Vulcano", 1);
            dao.salvarResposta(4, "Terra", 0);
            dao.salvarResposta(4, "Asgard", 0);
            dao.salvarResposta(4, "Spocklândia", 0);
            dao.salvarResposta(4, "Ele nasceu na Nava Enterprise, filho de tripulantes.", 0);

            dao.salvarPergunta(5, "Qual a cor da Meta-anfetamina de Heisenberg em Breaking Bad?");
            dao.salvarResposta(5, "Branca", 0);
            dao.salvarResposta(5, "Transparente", 0);
            dao.salvarResposta(5, "Amarelo", 0);
            dao.salvarResposta(5, "Azul cobalto", 0);
            dao.salvarResposta(5, "Azul-", 1);

            dao.salvarPergunta(6, "Qual das alternativas contêm apenas personagens da Marvel?");
            dao.salvarResposta(6, "Homem de Ferro, Pantera-Negra, Flash e Hulk", 0);
            dao.salvarResposta(6, "Hulk, Thor, Lobo e Batman", 0);
            dao.salvarResposta(6, "Motoqueiro Fantasma, Homem-aranha, Superman e Flash", 0);
            dao.salvarResposta(6, "Feiticeira Escarlate, Hulk, Wolverine e Star-Lord", 1);
            dao.salvarResposta(6, "Rocket-Raccoon, Groot Hulk e Batman", 0);

            dao.salvarPergunta(7, "Qual desses não é orfão?");
            dao.salvarResposta(7, "Super-man", 0);
            dao.salvarResposta(7, "Batman", 0);
            dao.salvarResposta(7, "Arqueiro Verde", 0);
            dao.salvarResposta(7, "Homem-Aranha", 0);
            dao.salvarResposta(7, "Cable", 1);

            dao.salvarPergunta(8, "Qual é o real nome de revistas desenhadas em quadros de heróis ou personagens em geral?");
            dao.salvarResposta(8, "Manga", 0);
            dao.salvarResposta(8, "HQ's", 1);
            dao.salvarResposta(8, "Gibi", 0);
            dao.salvarResposta(8, "Livrinho", 0);
            dao.salvarResposta(8, "Revistas Infantis", 0);

            dao.salvarPergunta(9, "Em que reino Thor nasceu?");
            dao.salvarResposta(9, "Asgard", 1);
            dao.salvarResposta(9, "Eisgard (pronuncia-se Aisgard)", 0);
            dao.salvarResposta(9, "Midgard", 0);
            dao.salvarResposta(9, "Millygard", 0);

            dao.salvarPergunta(10, "O reino de Midgard é que planeta?");
            dao.salvarResposta(10, "Marte", 0);
            dao.salvarResposta(10, "Terra", 1);
            dao.salvarResposta(10, "Reino de Odim (onde Thor nasceu)", 0);
            dao.salvarResposta(10, "Júpiter, o planeta dos Anelídeos (inimigos de Thor)", 0);

            dao.salvarPergunta(11, "Como é o nome do ajudante digital do Homem de Ferro?");
            dao.salvarResposta(11, "Jarbas", 0);
            dao.salvarResposta(11, "Stark Mobile", 0);
            dao.salvarResposta(11, "Jarvis", 1);
            dao.salvarResposta(11, "Alfred", 0);

            dao.salvarPergunta(12, "No filme 'Os Vingadores', Loki, ao enfrentar Tony Stark, disse: Nos temos um exercito. Como respondeu Tony?");
            dao.salvarResposta(12, "Nós temos o Hulk", 1);
            dao.salvarResposta(12, "Nos temos o Thor, seu irmão mais poderoso do que você", 0);
            dao.salvarResposta(12, "Nos temos Os Vingadores", 0);
            dao.salvarResposta(12, "Nos temos varias armaduras minhas", 0);

            dao.salvarPergunta(13, "Por que Bruce Wayne virou o Batman?");
            dao.salvarResposta(13, "Para se vingar de Coringa, o causador das mortes em Gotham City", 0);
            dao.salvarResposta(13, "Para vingar a morte de Alfred", 0);
            dao.salvarResposta(13, "Para vingar a morte de seus pais", 1);
            dao.salvarResposta(13, "Para acabar com bandidos e comer de graça nos restaurantes de Gotham.", 0);

            dao.salvarPergunta(14, "O que Super Homem e Thor tem em comum?");
            dao.salvarResposta(14, "São de Asgard", 0);
            dao.salvarResposta(14, "São de Midgard", 0);
            dao.salvarResposta(14, "Controlam os trovões", 0);
            dao.salvarResposta(14, "Não são mortais", 1);
            dao.salvarResposta(14, "Sabem voar", 0);

            dao.salvarPergunta(15, "Quem matou Asa Noturna em uma HQ do Batman?");
            dao.salvarResposta(15, "Mulher Gato", 0);
            dao.salvarResposta(15, "Arlequina", 0);
            dao.salvarResposta(15, "Era Venenosa", 1);
            dao.salvarResposta(15, "Coringa", 0);
            dao.salvarResposta(15, "O próprio Batman", 0);

            dao.salvarPergunta(16, "Porque Super Homem era zoado na escola?");
            dao.salvarResposta(16, "Pois ele tinha uns arrepios estranhos", 1);
            dao.salvarResposta(16, "Pois ele matou um menino que roubou seu lanche", 0);
            dao.salvarResposta(16, "Pois ele só tirava 0 nas provas", 0);
            dao.salvarResposta(16, "Pois ele tropeçou na escada e caiu de boca na mesa do professor", 0);


            dao.salvarPergunta(17, "Thor e Capitão América são de que grupo?");
            dao.salvarResposta(17, "Os Vingativos", 0);
            dao.salvarResposta(17, "Liga da Justiça", 0);
            dao.salvarResposta(17, "Liga da Injustiça", 0);
            dao.salvarResposta(17, "Os Vingadores", 1);
            dao.salvarResposta(17, "X-Men", 0);

            dao.salvarPergunta(18, "A 'Marvel Universe' fez uma aliança com um canal de televisão, somente disponível em TV's como Sky e TVA. Que canal é esse?");
            dao.salvarResposta(18, "Cartoon Network", 0);
            dao.salvarResposta(18, "Disney Channel", 1);
            dao.salvarResposta(18, "Nickelodeon", 0);
            dao.salvarResposta(18, "Fox", 0);
            dao.salvarResposta(18, "Discovery Kids", 0);

            dao.salvarPergunta(19, "A 'DC Universe' fez uma aliança com uma empresa. Que empresa é essa?");
            dao.salvarResposta(19, "Marvel Universe", 0);
            dao.salvarResposta(19, "Disney", 1);
            dao.salvarResposta(19, "Time Warner-X", 0);
            dao.salvarResposta(19, "Warner Bross", 0);
            dao.salvarResposta(19, "Fox", 0);

            dao.salvarPergunta(20, "Quais são os cinco vilões principais de Batman?");
            dao.salvarResposta(20, "Era Venenosa, Asa Noturna, Mulher-Gato, Coringa, Arlequina e Duas Caras", 0);
            dao.salvarResposta(20, "Era Venenosa, Bane, Duas Caras, Coringa, Arlequina e Mulher-Gato", 1);
            dao.salvarResposta(20, "Era Venenosa, Bane, Coringa, Mandarim, Mulher-Gato e Arlequina", 0);

            dao.salvarPergunta(21, "Qual o novo nome do Homem Formiga?");
            dao.salvarResposta(21, "Vespa 2", 0);
            dao.salvarResposta(21, "Homem Vespa", 0);
            dao.salvarResposta(21, "Jaqueta Amarela", 1);
            dao.salvarResposta(21, "Formatum Mutantus", 0);


            dao.salvarPergunta(22, "Em setembro de 2013 existia uma série de HQ's sobre a morte de um herói da DC Universe. Que herói é esse?");
            dao.salvarResposta(22, "Batman", 1);
            dao.salvarResposta(22, "Zatanna", 0);
            dao.salvarResposta(22, "Homem de Ferro", 0);
            dao.salvarResposta(22, "Super-Man", 0);

            dao.salvarPergunta(23, "Qual é a mulher mágica da Marvel Universe?");
            dao.salvarResposta(23, "Feitissus", 0);
            dao.salvarResposta(23, "Feiticeira Escalante", 0);
            dao.salvarResposta(23, "Feiticeira Escalasse", 0);
            dao.salvarResposta(23, "Feituçuss", 0);
            dao.salvarResposta(23, "Nenhuma das alternativas", 1);

            dao.salvarPergunta(24, "Qual é o sobrenome de Zatanna, a mulher mágica da Liga da Justiça?");
            dao.salvarResposta(24, "Zatanes", 0);
            dao.salvarResposta(24, "Zatara", 1);
            dao.salvarResposta(24, "Zatâvez", 0);
            dao.salvarResposta(24, "Zatarra", 0);
            dao.salvarResposta(24, "Zorthea", 0);


            dao.salvarPergunta(25, "Qual o nome inteiro de Arlequina, a vilã de Batman e capacho de Coringa?");
            dao.salvarResposta(25, "Dr. Arle Quina", 0);
            dao.salvarResposta(25, "Dr. Harley Quinzel", 0);
            dao.salvarResposta(25, "Dr. Harleen Quinzel", 1);
            dao.salvarResposta(25, "Dr. Harley Quina", 0);
            dao.salvarResposta(25, "Nenhuma das alternativas", 0);

            dao.salvarPergunta(26, "Qual o nome do ator que fez Steve Rogers, vugo Capitão América no filme 'Os Vingadores'?");
            dao.salvarResposta(26, "Chris Evans", 1);
            dao.salvarResposta(26, "Chris Brown", 0);
            dao.salvarResposta(26, "Chris Hemsworth", 0);
            dao.salvarResposta(26, "Criss Angel", 0);
            dao.salvarResposta(26, "Liam Jason Singuel", 0);

            dao.salvarPergunta(27, "Nos filmes 'Quarteto Fantástico' e 'Quarteto Fantástico e o Surfista Prateado' Chris Evans atuou como um personagem. No filme 'Os Vingadores' ele atuou como outro personagem. Que personagens são esses?");
            dao.salvarResposta(27, "Tocha Humana e Thor", 0);
            dao.salvarResposta(27, "Coisa e Thor", 0);
            dao.salvarResposta(27, "Sr. Fantástico e Capitão America", 0);
            dao.salvarResposta(27, "Sr. Fantástico e Thor", 0);
            dao.salvarResposta(27, "Tocha Humana e Capitão América", 1);

            dao.salvarPergunta(28, "Qual o nome do irmão de Thor, o vilão do filme 'Os Vingadores'?");
            dao.salvarResposta(28, "Loki", 1);
            dao.salvarResposta(28, "Loqui", 0);
            dao.salvarResposta(28, "Cock", 0);
            dao.salvarResposta(28, "Koqui", 0);

            dao.salvarPergunta(29, "Em qual filme do Homem-Aranha, Dr. Octopus ataca?");
            dao.salvarResposta(29, "Homem-Aranha 2", 1);
            dao.salvarResposta(29, "Homem-Aranha 1", 0);
            dao.salvarResposta(29, "Homem-Aranha 3", 0);
            dao.salvarResposta(29, "O espetacular Homem-Aranha", 0);

            dao.salvarPergunta(30, "Como Hulk se transforma?");
            dao.salvarResposta(30, "Picado por uma aranha radioativa", 0);
            dao.salvarResposta(30, "Ele foi exposto a raios gama", 1);
            dao.salvarResposta(30, "Poderes que apareceram de repente", 0);
            dao.salvarResposta(30, "Caiu no lixo tóxico", 0);

            dao.salvarPergunta(31, "Quem é o parceiro do Batman?");
            dao.salvarResposta(31, "Super Homem", 0);
            dao.salvarResposta(31, "Lanterna Verde", 0);
            dao.salvarResposta(31, "Robin", 1);
            dao.salvarResposta(31, "Hulk", 0);
            dao.salvarResposta(31, "Wolverine", 0);

            dao.salvarPergunta(32, "Qual o maior inimigo do Homem-Aranha?");
            dao.salvarResposta(32, "Magneto", 0);
            dao.salvarResposta(32, "Dr. Caveira", 0);
            dao.salvarResposta(32, "Loki", 0);
            dao.salvarResposta(32, "Venon", 1);
            dao.salvarResposta(32, "Hulk Vermelho", 0);

            dao.salvarPergunta(33, "Qual foi o primeiro herói da América?");
            dao.salvarResposta(33, "Homem de Ferro", 0);
            dao.salvarResposta(33, "Hulk", 0);
            dao.salvarResposta(33, "Thor", 0);
            dao.salvarResposta(33, "Homem-Aranha", 0);
            dao.salvarResposta(33, "Capitão América", 1);

        }

    }

    //botão jogar, chamando o Quiz
    public void btnJogarOnClick(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}
