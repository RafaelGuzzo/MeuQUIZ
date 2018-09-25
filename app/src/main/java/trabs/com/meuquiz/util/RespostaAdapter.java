package trabs.com.meuquiz.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

import trabs.com.meuquiz.R;
import trabs.com.meuquiz.pojo.Resposta;


public class RespostaAdapter extends RecyclerView.Adapter<RespostaAdapter.RecyclerViewHolder> {

    private Context mContext;
    private List<Resposta> mList;
    private int ultPosicaoSele = -1, resp = 0;

    //recebe o contexto, e uma lista de resposta
    public RespostaAdapter(Context context, List<Resposta> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_lista, parent, false);
        return new RecyclerViewHolder(view);
    }


    //metodo que carrega as respostas e atribui as posições
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Resposta resposta = mList.get(position);
        this.resp = resposta.getRespostaCerta();
        holder.rbResposta.setText(resposta.getResposta());
        holder.rbResposta.setChecked(ultPosicaoSele == position);
        //Toast.makeText(mContext," bbb "+ resposta.getRespostaCerta(),Toast.LENGTH_LONG).show();
    }

    public int getResposta(){
        return this.mList.get(ultPosicaoSele).getRespostaCerta();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected class RecyclerViewHolder
            extends RecyclerView.ViewHolder {

        public RadioButton rbResposta;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            rbResposta = itemView.findViewById(R.id.resp);
            //fica ecutando qual vai ser clicado para alterar o valor da ultima posição
            //usado para marcar o check box
            rbResposta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ultPosicaoSele = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });

        }
    }
}
