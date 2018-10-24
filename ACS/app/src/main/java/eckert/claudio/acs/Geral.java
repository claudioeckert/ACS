package eckert.claudio.acs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class Geral extends AppCompatActivity implements AdapterView.OnItemClickListener {

    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter ad;
    ListView listViewGeral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geral);

        //ListView listaGeral = findViewById(R.id.lvGeral);


        // Buscar dados
        buscarDados();

        // Setar dados
        criarListagem();

    }


    private void buscarDados(){
        try{
            db = openOrCreateDatabase("bd_acs", Context.MODE_PRIVATE,null);
            cursor = db.rawQuery("SELECT * FROM tb_pessoa WHERE responsavelFamiliar = 1", null);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_SHORT).show();
        }

    }

    private void criarListagem(){
        //pega o listView que conterá os dados
        listViewGeral = findViewById(R.id.lvResponsavelFamiliar);

        String[] from = {"id","idResponsavel","nome","cartaoSus","dataNascimento"};//campos da tabela
        int[] to = {R.id.txtIdFamilia, R.id.txtNomeResponsavelFamilia, R.id.txtCartaoSus, R.id.txtDataNascimento}; //campos da lista modelo
        ad = new SimpleCursorAdapter(getApplicationContext(),R.layout.lista_geral,cursor,from,to);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
