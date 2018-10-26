package eckert.claudio.acs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class CadastrarEditarPessoas extends AppCompatActivity {

    EditText edtNome, edtEndereco, edtNumeroEndereco, edtComplemento, edtBairro,edtTelefone, edtDataNscimento, edtCartaoSus;
    RadioButton rdbMasculino, rdbFeminino, rdbOutros, rdbAtivo, rdbInativo;
    Spinner spResponsavelFamiliar;
    CheckBox cbHipertencaoArterial, cbDiabetico, cbDomiciliado, cbAcamado, cbFumante, cbCancer, cbDeficiente, cbGestante, cbResponsavel, cbFalecido;
    Button btnExcluir, btnNovoRegistro, btnSalvar;

    BDSqliteHelper db = new BDSqliteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_editar_pessoas);

        edtNome = findViewById(R.id.edtNome);
        edtEndereco = findViewById(R.id.edtEndereco);
        edtNumeroEndereco = findViewById(R.id.edtNumeroEndereco);
        edtComplemento = findViewById(R.id.edtComplemento);
        edtBairro = findViewById(R.id.edtBairro);
        edtTelefone = findViewById(R.id.edtTelefone);
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

        btnExcluir = findViewById(R.id.btnExcluir);
        btnNovoRegistro = findViewById(R.id.btnNovoRegistro);
        btnSalvar = findViewById(R.id.btnSalvar);

        //Mascara de entrada para os campos
        //Telefone
        SimpleMaskFormatter telefone = new SimpleMaskFormatter("(NN)N-NNNN-NNNN");
        MaskTextWatcher mtwTelefone = new MaskTextWatcher(edtTelefone,telefone);
        edtTelefone.addTextChangedListener(mtwTelefone);
        //Fim
        //Data de nascimento
        SimpleMaskFormatter dataNascimento = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtwDataNascimento = new MaskTextWatcher(edtDataNscimento,dataNascimento);
        edtDataNscimento.addTextChangedListener(mtwDataNascimento);
        //Fim
        //Cartão Sus
        SimpleMaskFormatter cartaoSus = new SimpleMaskFormatter("NNN-NNNN-NNNN-NNNN");
        MaskTextWatcher mtwCartaoSus = new MaskTextWatcher(edtCartaoSus,cartaoSus);
        edtCartaoSus.addTextChangedListener(mtwCartaoSus);
        //Fim
        //Fim da mascara




        //---Teste do CRUD--

        //db.addPessoa(new Pessoa("Claudio Eckert","General Câmara",55,"Fundos","Odila",991685321,"17051985",123456789,1,1,1,1,1,1,1,1,1));
        db.addPessoa(new Pessoa(2,"Claudio Jorge Eckert Junior","General Câmara","55","Fundos","Odila","991685321","17051985","700704982545772","1","0","0","0","0","0","0","0","0","1","0","0"));
        db.addPessoa(new Pessoa(0,"Aline Beatris Braatz Eckert","General Câmara","55","Fundos APTO 51","Odila","991685321","17051985","700704982","0","0","0","0","0","0","0","0","0","0","0","0"));
        db.addPessoa(new Pessoa(0,"José da Silva Sauros Ramos Trento","General Câmara","55","Fundos","Odila","991580666","18121979","700704982","1","0","0","0","0","0","0","0","0","1","0","0"));
        db.addPessoa(new Pessoa(0,"Maria da Silva","General Câmara","55","Fundos","Odila","991685321","17051985","700704982","0","0","0","0","0","0","0","0","0","1","0","0"));
        db.addPessoa(new Pessoa(4,"Mateus José Junior","General Câmara","55","Fundos","Odila","991685321","17051985","700704982","1","0","0","0","0","0","0","0","0","0","0","0"));
        db.addPessoa(new Pessoa(0,"Iasmin Braatz Both","General Câmara","55","Fundos","Odila","991685321","17051985","700704982","0","0","0","0","0","0","0","0","0","1","0","0"));
        db.addPessoa(new Pessoa(6,"Bernardo Augusto Braatz Both","General Câmara","55","Fundos","Odila","991685321","17051985","700704982","1","0","0","0","0","0","0","0","0","0","0","0"));
        db.addPessoa(new Pessoa(6,"Erich Somer","General Câmara","55","Fundos","Odila","991685321","17051985","700704982","0","0","1","0","0","0","0","0","0","0","0","0"));
        db.addPessoa(new Pessoa(0,"Armin Braatz","General Câmara","55","Fundos","Odila","991685321","17051985","700704982","0","0","1","0","0","0","0","0","0","1","0","0"));
        db.addPessoa(new Pessoa(3,"Marlize Scharowsky","General Câmara","55","Fundos","Odila","991685321","17051985","700704982","0","0","0","0","0","0","0","0","0","0","0","0"));


        Toast.makeText(CadastrarEditarPessoas.this,"Salvo com sucesso",Toast.LENGTH_LONG).show();
        }



        //Botão teste para abrir a tela Geral

    public void abrirActivityGeral (View v2){
        startActivity(new Intent(getBaseContext(),Geral.class));

        }

    //Fim do botão
    }

