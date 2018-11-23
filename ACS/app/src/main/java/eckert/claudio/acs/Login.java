package eckert.claudio.acs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends Activity {

    TextView txtNaoTemConta;
    EditText edtUsuarioLogin, edtSenhaLogin;
    Button btnEntrar;

    BDSqliteHelper db = new BDSqliteHelper(this);
    SQLiteDatabase dbSql;
    Cursor cursor;
    SimpleCursorAdapter adSC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtNaoTemConta = findViewById(R.id.txtNaoTemConta);
        edtUsuarioLogin = findViewById(R.id.edtLoginLogin);
        edtSenhaLogin = findViewById(R.id.edtSenhaLogin);

        btnEntrar = findViewById(R.id.btnEntrar);

    }

    public void LogarUsuario(View view){

        String textoUsuario = edtUsuarioLogin.getText().toString();
        String textoSenha = edtSenhaLogin.getText().toString();

        if (!textoUsuario.isEmpty()){//verifica usuario
            if (!textoSenha.isEmpty()){//verifica senha
                try {
                    dbSql = openOrCreateDatabase("bd_acs", Context.MODE_PRIVATE, null);
                    cursor = dbSql.rawQuery("SELECT usuario, senha FROM tb_usuario WHERE usuario = '"+textoUsuario+"' AND senha = '"+textoSenha+"'",null, null);
                        if (cursor != null && cursor.moveToFirst()) {
                            //do {
                                String usua = cursor.getString(0);
                                String pass = cursor.getString(1);
                                if (textoUsuario.equals(usua)&& textoSenha.equals(pass)){
                                    startActivity(new Intent(getBaseContext(),Geral.class));
                                    edtUsuarioLogin.setText("");
                                    edtSenhaLogin.setText("");
                                }else{
                                    Toast.makeText(getApplicationContext(),"Usuário e/ou Senha incorretos!!",Toast.LENGTH_LONG).show();
                                    edtUsuarioLogin.setText("");
                                    edtSenhaLogin.setText("");
                                    edtUsuarioLogin.requestFocus();
                                }
                            //} while (cursor.moveToNext());
                        }else{
                            Toast.makeText(getApplicationContext(),"Usuário e/ou Senha incorretos!",Toast.LENGTH_LONG).show();
                            edtUsuarioLogin.setText("");
                            edtSenhaLogin.setText("");
                            edtUsuarioLogin.requestFocus();
                        }
                        cursor.close();
                        db.close();
                        //Toast.makeText(getApplicationContext(), "Erro ao buscar ruas " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    //Fim
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Erro ao buscar usuários cadastrados!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            }else{
                Toast.makeText(getApplicationContext(), "Preencha o campo senha!", Toast.LENGTH_LONG).show();
                this.edtSenhaLogin.requestFocus();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo usuário!", Toast.LENGTH_SHORT).show();
            this.edtUsuarioLogin.requestFocus();
        }
    }

    //Fim

    //Abrir Activity Login
    public void abrirActivityLogin (View v) {
        startActivity(new Intent(getBaseContext(), Login.class));
    }
    //Fim





    public void abrirActivityGeral (View v){
        startActivity(new Intent(getBaseContext(),Geral.class));
    }

    public void abrirActivityCadastro (View v) {
        startActivity(new Intent(getBaseContext(), CadastrarUsuarioActivity.class));
        //txtNaoTemConta.setTextColor(Color.rgb(6,48,82));
        //txtNaoTemConta.getResources().getColor(R.color.colorPrimary);
    }

}
