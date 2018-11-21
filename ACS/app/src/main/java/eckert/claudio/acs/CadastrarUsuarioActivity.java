package eckert.claudio.acs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class CadastrarUsuarioActivity extends AppCompatActivity {

    EditText edtNomeCadastro, edtUsuarioCadastro, edtSenhaCadastro, edtSenhaConfirmadaCadastro;
    Button btnCadastrarCadastro;

    BDSqliteHelper db = new BDSqliteHelper(this);
    SQLiteDatabase dbSql;
    Cursor cursor;
    SimpleCursorAdapter adSC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        edtNomeCadastro = findViewById(R.id.edtNomeCadastro);
        edtUsuarioCadastro = findViewById(R.id.edtUsuarioCadastro);
        edtSenhaCadastro = findViewById(R.id.edtSenhaCadastro);
        edtSenhaConfirmadaCadastro = findViewById(R.id.edtSenhaConfirmadaCadastro);

        btnCadastrarCadastro = findViewById(R.id.btnCadastrarCadastro);
    }

    //Cadastrar usuário
    public void CadastrarUsuario(View view){
        //Trocar cor do botão ao clicar
        //btnCadastrarCadastro.setBackgroundResource(R.color.colorAccent);
        //btnCadastrarCadastro.setTextColor(Color.GREEN);
        //btnCadastrarCadastro.setBackgroundResource(R.color.colorPrimaryDark);
        //Recuperar textos dos campos
        String textoNome = edtNomeCadastro.getText().toString();
        String textoUsuario = edtUsuarioCadastro.getText().toString();
        String textoSenha = edtSenhaCadastro.getText().toString();
        String textoSenhaConfirmada = edtSenhaConfirmadaCadastro.getText().toString();

        if (!textoNome.isEmpty()){//verifica nome
            if (!textoUsuario.isEmpty()){//verifica usuario
                if (!textoSenha.isEmpty()){//verifica senha
                    if (!textoSenhaConfirmada.isEmpty()){//verifica senha confirmada
                        if (textoSenha.equals(textoSenhaConfirmada)){//verifica se campos senha e senha confirmada são iguais
                            //colocar aqui a rotina para salvar no banco
                            try {
                                db.addUsuario(new Usuario(textoNome, textoUsuario, textoSenha));
                                Toast.makeText(getApplicationContext(), "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                                edtNomeCadastro.setText("");
                                edtUsuarioCadastro.setText("");
                                edtSenhaCadastro.setText("");
                                edtSenhaConfirmadaCadastro.setText("");
                            }catch (Exception e){
                                Toast.makeText(getApplicationContext(), "Erro ao cadastrar usuário!", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Os campos devem ser IGUAIS!!", Toast.LENGTH_LONG).show();
                            this.edtSenhaCadastro.setText("");
                            this.edtSenhaConfirmadaCadastro.setText("");
                            this.edtSenhaCadastro.requestFocus();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Preencha o campo confirmar senha!", Toast.LENGTH_SHORT).show();
                        this.edtSenhaConfirmadaCadastro.requestFocus();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Preencha o campo senha!", Toast.LENGTH_SHORT).show();
                    this.edtSenhaCadastro.requestFocus();
                }
            }else {
                Toast.makeText(getApplicationContext(), "Preencha o campo usuário!", Toast.LENGTH_SHORT).show();
                this.edtUsuarioCadastro.requestFocus();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo nome!", Toast.LENGTH_SHORT).show();
            this.edtNomeCadastro.requestFocus();
        }

    }
    //Fim

    //Abrir Activity Login
    public void abrirActivityLogin (View v) {
        startActivity(new Intent(getBaseContext(), Login.class));
    }
    //Fim


}
