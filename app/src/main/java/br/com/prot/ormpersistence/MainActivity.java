package br.com.prot.ormpersistence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome, edtEmail;
    private Button btnSalvar;
    private ListView listaContatos;

    private ContatosDAO dao;
    private ContatosAdapter adapter;
    private List<Contatos> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dao = new ContatosDAO(this);
        initUi();
    }

    @Override
    protected void onResume() {
        super.onResume();

        verificaLista();

        this.btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edtNome.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();

                if(!nome.equals("") && !email.equals("")){
                    salvar(nome, email);
                }
            }
        });

        this.listaContatos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dao.delete(new Contatos(contatos.get(position).getNome(), contatos.get(position).getEmail()));
                contatos.remove(adapter.getItem(position));
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void initUi(){
        this.edtNome = (EditText) findViewById(R.id.edt_nome);
        this.edtEmail = (EditText) findViewById(R.id.edt_email);
        this.btnSalvar = (Button) findViewById(R.id.btn_salvar);
        this.listaContatos = (ListView) findViewById(R.id.lista_contatos);
    }

    private void salvar(String nome, String email){
        this.dao.insert(new Contatos(nome, email));
        clearinputs();
        carregaLista();
    }

    private void clearinputs(){
        this.edtNome.setText("");
        this.edtEmail.setText("");
        this.edtNome.requestFocus();
    }

    private void verificaLista(){
        if(this.dao.getAll().size() > 0){
            carregaLista();
        }
    }

    private void carregaLista(){
        contatos = this.dao.getAll();
        this.adapter = new ContatosAdapter(contatos, this);
        this.listaContatos.setAdapter(adapter);
    }
}
