package eckert.claudio.acs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class CadastrarEditarPessoas extends AppCompatActivity {

    EditText edtNome, edtEndereco, edtNumeroEndereco, edtComplemento, edtBairro,edtTelefone, edtDataNscimento, edtCartaoSus;
    RadioButton rdbMasculino, rdbFeminino, rdbOutros;
    Switch swtHipertencaoArterial, swtDiabetico, swtDomiciliado, swtAcamado, swtFumante, swtCancer, swtDeficiente, swtGestante;
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

        swtHipertencaoArterial = findViewById(R.id.swtHipertencaoArterial);
        swtDiabetico = findViewById(R.id.swtDiabetico);
        swtDomiciliado = findViewById(R.id.swtDomiciliado);
        swtAcamado = findViewById(R.id.swtAcamado);
        swtFumante = findViewById(R.id.swtFumante);
        swtCancer = findViewById(R.id.swtCancer);
        swtDeficiente = findViewById(R.id.swtDeficiente);
        swtGestante = findViewById(R.id.swtGestante);

        btnExcluir = findViewById(R.id.btnExcluir);
        btnNovoRegistro = findViewById(R.id.btnNovoRegistro);
        btnSalvar = findViewById(R.id.btnSalvar);

        //---Teste do CRUD--

        //db.addPessoa(new Pessoa("Claudio Eckert","General Câmara",55,"Fundos","Odila",991685321,"17051985",123456789,1,1,1,1,1,1,1,1,1));
        db.addPessoa(new Pessoa(1,"Claudio Eckert","General Câmara",55,"Fundos","Odila",991685321,"17051985",123456789,1,1,1,1,1,1,1,1,1));



        Toast.makeText(CadastrarEditarPessoas.this,"Salvo com sucesso",Toast.LENGTH_LONG).show();
        }
    }

