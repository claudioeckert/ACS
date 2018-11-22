package eckert.claudio.acs;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        // Buscar dados
        buscarDados();

        // Setar dados
        criarListagem();

    }


    private void buscarDados(){
        try{
            db = openOrCreateDatabase("bd_acs", Context.MODE_PRIVATE,null);
            cursor = db.rawQuery("SELECT _id, idResponsavel, nome, cartaoSus, dataNascimento FROM tb_pessoas WHERE responsavelFamiliar = '1'", null, null);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Erro ao buscar dados", Toast.LENGTH_SHORT).show();
        }

    }

    private void criarListagem(){

        try {

            if (cursor != null) {
                cursor.moveToFirst();
            }
            //pega o listView que conterá os dados
            listViewGeral = findViewById(R.id.lvResponsavelFamiliar);

            String[] from = {"idResponsavel", "nome", "cartaoSus", "dataNascimento"};//campos da tabela

            int[] to = {R.id.txtListaIdFamilia, R.id.txtListaNomeResponsavelFamilia, R.id.txtListaCartaoSus, R.id.txtListaDataNascimento}; //campos da lista modelo
            ad = new SimpleCursorAdapter(getApplicationContext(), R.layout.lista_geral, cursor, from, to,0);
            listViewGeral.setAdapter(ad);
           // db.close();
        }catch (Exception e){
            //db.close();
            Toast.makeText(getApplicationContext(), "Erro criarListagem: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }

    //Abrir activity Cadastrar Pessoa
    public void abrirActivityCadastrarPessoa (View v){
        startActivity(new Intent(getBaseContext(),CadastrarPessoas.class));
    }
    //Fim

}
