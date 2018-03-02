package br.com.prot.ormpersistence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fredericom on 02/03/2018.
 */

public class ContatosAdapter extends BaseAdapter {

    private List<Contatos> contatos;
    private Context context;
    private LayoutInflater inflater = null;

    public ContatosAdapter(List<Contatos> contatos, Context context) {
        this.contatos = contatos;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        View rowView = convertView;
        rowView = inflater.inflate(R.layout.item_list, null);

        holder.txtNome = (TextView) rowView.findViewById(R.id.txt_nome);
        holder.txtEmail = (TextView) rowView.findViewById(R.id.txt_email);

        holder.txtNome.setText(contatos.get(position).getNome());
        holder.txtEmail.setText(contatos.get(position).getEmail());

        return rowView;
    }

    public class ViewHolder{
        TextView txtNome;
        TextView txtEmail;
    }
}
