package eckert.claudio.acs;
/*
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class Lista extends AppCompatActivity{

    EditText edt



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_geral);

        //Início da mascara de entrada
        //Data de nascimento
        SimpleMaskFormatter dataNascimento = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtwDataNascimento = new MaskTextWatcher(txtListaDataNascimento,dataNascimento);
        txtListaDataNascimento.addTextChangedListener(mtwDataNascimento);
        //Fim
        //Cartão Sus
        SimpleMaskFormatter cartaoSus = new SimpleMaskFormatter("NNN-NNNN-NNNN-NNNN");
        MaskTextWatcher mtwCartaoSus = new MaskTextWatcher(edtCartaoSus,cartaoSus);
        edtCartaoSus.addTextChangedListener(mtwCartaoSus);
        //Fim
        //Fim da mascara


    }
}
/*
public class Lista {
    private int numeroFamilia;
    private String nomeChefeFamilia;
    private String cartaoSusChefeFamilia;
    private String datNascimentoChefeFamilia;

    public Lista(int numeroFamilia, String nomeChefeFamilia, String cartaoSusChefeFamilia, String datNascimentoChefeFamilia) {
        this.numeroFamilia = numeroFamilia;
        this.nomeChefeFamilia = nomeChefeFamilia;
        this.cartaoSusChefeFamilia = cartaoSusChefeFamilia;
        this.datNascimentoChefeFamilia = datNascimentoChefeFamilia;
    }

    public int getNumeroFamilia() {
        return numeroFamilia;
    }

    public void setNumeroFamilia(int numeroFamilia) {
        this.numeroFamilia = numeroFamilia;
    }

    public String getNomeChefeFamilia() {
        return nomeChefeFamilia;
    }

    public void setNomeChefeFamilia(String nomeChefeFamilia) {
        this.nomeChefeFamilia = nomeChefeFamilia;
    }

    public String getCartaoSusChefeFamilia() {
        return cartaoSusChefeFamilia;
    }

    public void setCartaoSusChefeFamilia(String cartaoSusChefeFamilia) {
        this.cartaoSusChefeFamilia = cartaoSusChefeFamilia;
    }

    public String getDatNascimentoChefeFamilia() {
        return datNascimentoChefeFamilia;
    }

    public void setDatNascimentoChefeFamilia(String datNascimentoChefeFamilia) {
        this.datNascimentoChefeFamilia = datNascimentoChefeFamilia;
    }
}
*/