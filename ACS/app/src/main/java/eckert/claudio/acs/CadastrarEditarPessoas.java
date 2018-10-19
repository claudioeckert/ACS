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

public class CadastrarEditarPessoas extends AppCompatActivity {

    EditText edtNome, edtEndereco, edtNumeroEndereco, edtComplemento, edtBairro,edtTelefone, edtDataNscimento, edtCartaoSus;
    RadioButton rdbMasculino, rdbFeminino, rdbOutros;
    CheckBox cbtHipertencaoArterial, cbtDiabetico, cbtDomiciliado, cbtAcamado, cbtFumante, cbtCancer, cbtDeficiente, cbtGestante;
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

        cbtHipertencaoArterial = findViewById(R.id.cbHipertencaoArterial);
        cbtDiabetico = findViewById(R.id.cbDiabetico);
        cbtDomiciliado = findViewById(R.id.cbDomiciliado);
        cbtAcamado = findViewById(R.id.cbAcamado);
        cbtFumante = findViewById(R.id.cbFumante);
        cbtCancer = findViewById(R.id.cbCancer);
        cbtDeficiente = findViewById(R.id.cbDeficiente);
        cbtGestante = findViewById(R.id.cbGestante);

        btnExcluir = findViewById(R.id.btnExcluir);
        btnNovoRegistro = findViewById(R.id.btnNovoRegistro);
        btnSalvar = findViewById(R.id.btnSalvar);

        //---Teste do CRUD--

        //db.addPessoa(new Pessoa("Claudio Eckert","General Câmara",55,"Fundos","Odila",991685321,"17051985",123456789,1,1,1,1,1,1,1,1,1));
        db.addPessoa(new Pessoa(1,"Claudio Eckert","General Câmara",55,"Fundos","Odila",991685321,"17051985",123456789,1,1,1,1,1,1,1,1,1));



        Toast.makeText(CadastrarEditarPessoas.this,"Salvo com sucesso",Toast.LENGTH_LONG).show();
        }
    }

