package eckert.claudio.acs;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CadastrarEditarPessoas extends AppCompatActivity {

    EditText edtNome, edtNumeroEndereco, edtComplemento, edtTelefoneResidencial, edtTelefoneCelular1, edtTelefoneCelular2, edtTelefoneCelular3, edtDataNscimento, edtCartaoSus, edtResponsavelFamiliar;
    RadioButton rdbMasculino, rdbFeminino, rdbOutros, rdbAtivo, rdbInativo;
    Spinner spResponsavelFamiliar, spRua, spBairro;
    CheckBox cbHipertencaoArterial, cbDiabetico, cbDomiciliado, cbAcamado, cbFumante, cbCancer, cbDeficiente, cbGestante, cbResponsavel, cbFalecido;
    Button btnExcluir, btnNovoRegistro, btnSalvar, btnCadastrarEndereco, btnCadastrarBairro;

    BDSqliteHelper db = new BDSqliteHelper(this);
    SQLiteDatabase dbSql;
    Cursor cursor;
    SimpleCursorAdapter adSC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_editar_pessoas);

        edtNome = findViewById(R.id.edtNome);
        edtNumeroEndereco = findViewById(R.id.edtNumeroEndereco);
        edtComplemento = findViewById(R.id.edtComplemento);
        edtResponsavelFamiliar = findViewById(R.id.edtResponsavelFamiliar);

        edtTelefoneResidencial = findViewById(R.id.edtTelefoneResidencial);
        edtTelefoneCelular1 = findViewById(R.id.edtTelefoneCelular1);
        edtTelefoneCelular2 = findViewById(R.id.edtTelefoneCelular2);
        edtTelefoneCelular3 = findViewById(R.id.edtTelefoneCelular3);
        edtDataNscimento = findViewById(R.id.edtDataNscimento);
        edtCartaoSus = findViewById(R.id.edtCartaoSus);

        rdbMasculino = findViewById(R.id.rdbMasculino);
        rdbFeminino = findViewById(R.id.rdbFeminino);
        rdbOutros = findViewById(R.id.rdbOutros);
        rdbAtivo = findViewById(R.id.rdbAtivo);
        rdbInativo = findViewById(R.id.rdbInativo);

        cbHipertencaoArterial = findViewById(R.id.cbHipertencaoArterial);
        cbDiabetico = findViewById(R.id.cbDiabetico);
        cbDomiciliado = findViewById(R.id.cbDomiciliado);
        cbAcamado = findViewById(R.id.cbAcamado);
        cbFumante = findViewById(R.id.cbFumante);
        cbCancer = findViewById(R.id.cbCancer);
        cbDeficiente = findViewById(R.id.cbDeficiente);
        cbGestante = findViewById(R.id.cbGestante);
        cbResponsavel = findViewById(R.id.cbResponsavel);
        cbFalecido = findViewById(R.id.cbFalecido);

        spResponsavelFamiliar = findViewById(R.id.spResponsavelFamiliar);
        spRua = findViewById(R.id.spRua);
        spBairro = findViewById(R.id.spBairro);

        btnExcluir = findViewById(R.id.btnExcluir);
        btnNovoRegistro = findViewById(R.id.btnNovoRegistro);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnCadastrarEndereco = findViewById(R.id.btnCadastrarEndereco);
        btnCadastrarBairro = findViewById(R.id.btnCadastrarBairro);

        //Mascara de entrada para os campos
        //Telefones
        SimpleMaskFormatter telefoneR = new SimpleMaskFormatter("(NN)NNNN-NNNN");
        MaskTextWatcher mtwTelefoneR = new MaskTextWatcher(edtTelefoneResidencial, telefoneR);
        edtTelefoneResidencial.addTextChangedListener(mtwTelefoneR);

        SimpleMaskFormatter telefoneC1 = new SimpleMaskFormatter("(NN)N-NNNN-NNNN");
        MaskTextWatcher mtwTelefoneC1 = new MaskTextWatcher(edtTelefoneCelular1, telefoneC1);
        edtTelefoneCelular1.addTextChangedListener(mtwTelefoneC1);

        SimpleMaskFormatter telefoneC2 = new SimpleMaskFormatter("(NN)N-NNNN-NNNN");
        MaskTextWatcher mtwTelefoneC2 = new MaskTextWatcher(edtTelefoneCelular2, telefoneC2);
        edtTelefoneCelular2.addTextChangedListener(mtwTelefoneC2);

        SimpleMaskFormatter telefoneC3 = new SimpleMaskFormatter("(NN)N-NNNN-NNNN");
        MaskTextWatcher mtwTelefoneC3 = new MaskTextWatcher(edtTelefoneCelular3, telefoneC3);
        edtTelefoneCelular3.addTextChangedListener(mtwTelefoneC3);
        //Fim

        //Data de nascimento
        SimpleMaskFormatter dataNascimento = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtwDataNascimento = new MaskTextWatcher(edtDataNscimento, dataNascimento);
        edtDataNscimento.addTextChangedListener(mtwDataNascimento);
        //Fim
        //Cartão Sus
        SimpleMaskFormatter cartaoSus = new SimpleMaskFormatter("NNN-NNNN-NNNN-NNNN");
        MaskTextWatcher mtwCartaoSus = new MaskTextWatcher(edtCartaoSus, cartaoSus);
        edtCartaoSus.addTextChangedListener(mtwCartaoSus);
        //Fim
        //Número da família
        SimpleMaskFormatter idResponsavelFamiliar = new SimpleMaskFormatter("NNN");
        MaskTextWatcher mtwIdResponsavelFamiliar = new MaskTextWatcher(edtResponsavelFamiliar, idResponsavelFamiliar);
        edtResponsavelFamiliar.addTextChangedListener(mtwIdResponsavelFamiliar);
        //Fim
        //Fim da mascara


        //---Teste do CRUD--

        try {//Não está funcionando o try catch pois o campo idResponsável não pode ser repitido
            db.addPessoa(new Pessoa(80, "Claudio Jorge Eckert Junior", "General Câmara", "55", "Fundos", "Odila", "991685321", "17051985", "700704982545772", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0"));
            db.addPessoa(new Pessoa(130, "Aline Beatris Braatz Eckert", "General Câmara", "55", "Fundos APTO 51", "Odila", "991685321", "17051985", "700704982", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0"));
            db.addPessoa(new Pessoa(25, "José da Silva Sauros Ramos Trento", "General Câmara", "55", "Fundos", "Odila", "991580666", "18121979", "700704982", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0"));
            db.addPessoa(new Pessoa(65, "Maria da Silva", "General Câmara", "55", "Fundos", "Odila", "991685321", "17051985", "700704982", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0"));
            db.addPessoa(new Pessoa(42, "Mateus José Junior", "General Câmara", "55", "Fundos", "Odila", "991685321", "17051985", "700704982", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0"));

            db.addRua(new Rua("General Câmara"));
            db.addRua(new Rua("Flores da Cunha"));
            db.addRua(new Rua("João Thiesen"));

            db.addBairro(new Bairro("Centro"));
            db.addBairro(new Bairro("Odila"));


            Toast.makeText(CadastrarEditarPessoas.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro ao salvar dados: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        //Populando spinner Ruas
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,getRuas());
        spRua.setAdapter(adapter);
        //Fim

        //Populando spinner Bairros
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,getBairros());
        spBairro.setAdapter(adapter2);
        //Fim

        //Populando spinner ResponsavelFamiliar
        ArrayAdapter<String> adapter3 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,getResponsaveis());
        spResponsavelFamiliar.setAdapter(adapter3);
        //Fim

        //Fim CRUD

        //Pode obter a turma selecionada no Spinner desta forma:
            //Turma turmaSelecionada = ((Turma)spinner.getSelectedItem());

    }//----------------------Fecha o onCreate-----------------------------------------------------
        //Spinner Ruas
        public ArrayList<String> getRuas() {
        ArrayList<String> ruas = new ArrayList<String>();
        dbSql = openOrCreateDatabase("bd_acs", Context.MODE_PRIVATE, null);
        cursor = dbSql.rawQuery("SELECT rua FROM tb_rua", null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                //Integer id = cursor.getInt(0);
                String nomeRua = cursor.getString(0);
                String rua = new String(nomeRua);
                ruas.add(rua);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ruas;
        //Toast.makeText(getApplicationContext(), "Erro ao buscar ruas " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
    //Fim

    //Spínner Bairros spBairro
    public ArrayList<String> getBairros() {
        ArrayList<String> bairros = new ArrayList<String>();
        dbSql = openOrCreateDatabase("bd_acs", Context.MODE_PRIVATE, null);
        cursor = dbSql.rawQuery("SELECT bairro FROM tb_bairro", null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                //Integer id = cursor.getInt(0);
                String nomeBairro = cursor.getString(0);
                String bairro = new String(nomeBairro);
                bairros.add(bairro);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return bairros;
        //Toast.makeText(getApplicationContext(), "Erro ao buscar ruas " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
    //Fim

    //Spínner Bairros spBairro
    public ArrayList<String> getResponsaveis() {
        ArrayList<String> responsaveis = new ArrayList<String>();
        dbSql = openOrCreateDatabase("bd_acs", Context.MODE_PRIVATE, null);
        cursor = dbSql.rawQuery("SELECT nome FROM tb_pessoas WHERE responsavelFamiliar = '1'", null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                //Integer id = cursor.getInt(0);
                String nomeresponsavel = cursor.getString(0);
                String responsavel = new String(nomeresponsavel);
                responsaveis.add(responsavel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return responsaveis;
        //Toast.makeText(getApplicationContext(), "Erro ao buscar ruas " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
    //Fim




    //Botão teste para abrir a tela Geral

    public void abrirActivityGeral(View v2) {
        startActivity(new Intent(getBaseContext(), Geral.class));

    }

//Fim do botão
}