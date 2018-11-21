package eckert.claudio.acs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends Activity {

    TextView txtNaoTemConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtNaoTemConta = findViewById(R.id.txtNaoTemConta);

    }

    public void abrirActivityGeral (View v){
        startActivity(new Intent(getBaseContext(),Geral.class));
    }

    public void abrirActivityCadastro (View v) {
        startActivity(new Intent(getBaseContext(), CadastrarUsuarioActivity.class));
        //txtNaoTemConta.setTextColor(Color.rgb(6,48,82));
        //txtNaoTemConta.getResources().getColor(R.color.colorPrimary);
    }

}
