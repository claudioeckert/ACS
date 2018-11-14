package eckert.claudio.acs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void abrirActivityGeral (View v){
        startActivity(new Intent(getBaseContext(),Geral.class));

    }


}
