package eckert.claudio.acs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class CadastrarEditarPessoas extends AppCompatActivity {

    EditText edtNome, edtEndereco, edtNumeroEndereco, edtComplemento, edtBairro,edtTelefone, edtDataNscimento, edtCartaoSus;
    RadioButton rdbMasculino, rdbFeminino, rdbOutros, rdbAtivo, rdbInativo;
    CheckBox cbtHipertencaoArterial, cbtDiabetico, cbtDomiciliado, cbtAcamado, cbtFumante, cbtCancer, cbtDeficiente, cbtGestante, cbResponsavel, cbFalecido;
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

        cbtHipertencaoArterial = findViewById(R.id.cbHipertencaoArterial);
        cbtDiabetico = findViewById(R.id.cbDiabetico);
        cbtDomiciliado = findViewById(R.id.cbDomiciliado);
        cbtAcamado = findViewById(R.id.cbAcamado);
        cbtFumante = findViewById(R.id.cbFumante);
        cbtCancer = findViewById(R.id.cbCancer);
        cbtDeficiente = findViewById(R.id.cbDeficiente);
        cbtGestante = findViewById(R.id.cbGestante);
        cbResponsavel = findViewById(R.id.cbResponsavel);
        cbFalecido = findViewById(R.id.cbFalecido);

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
        db.addPessoa(new Pessoa(1,"Claudio Eckert","General Câmara",55,"Fundos","Odila",991685321,"17051985",123456789,1,1,1,1,1,1,1,1,1));



        Toast.makeText(CadastrarEditarPessoas.this,"Salvo com sucesso",Toast.LENGTH_LONG).show();
        }
    }

