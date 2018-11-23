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
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.ArrayList;

public class CadastrarPessoas extends AppCompatActivity {

    EditText edtNomeCadastrarPessoas, edtNumeroEnderecoCadastrarPessoas, edtComplementoCadastrarPessoas, edtTelefoneResidencialCadastrarPessoas, edtTelefoneCelular1CadastrarPessoas, edtTelefoneCelular2CadastrarPessoas, edtTelefoneCelular3CadastrarPessoas, edtDataNscimentoCadastrarPessoas, edtCartaoSusCadastrarPessoas, edtNumeroResponsavelFamiliarCadastrarPessoas;
    RadioButton rdbMasculinoCadastrarPessoas, rdbFemininoCadastrarPessoas, rdbOutrosCadastrarPessoas, rdbAtivoCadastrarPessoas, rdbInativoCadastrarPessoas;
    Spinner spResponsavelFamiliarCadastrarPessoas, spRuaCadastrarPessoas, spBairroCadastrarPessoas;
    CheckBox cbHipertencaoArterialCadastrarPessoas, cbDiabeticoCadastrarPessoas, cbDomiciliadoCadastrarPessoas, cbAcamadoCadastrarPessoas, cbFumanteCadastrarPessoas, cbCancerCadastrarPessoas, cbDeficienteCadastrarPessoas, cbGestanteCadastrarPessoas, cbResponsavelCadastrarPessoas, cbFalecidoCadastrarPessoas;
    Button btnExcluir, btnNovoRegistro, btnSalvarCadastrarPessoas, btnCadastrarEnderecoCadastrarPessoas, btnCadastrarBairroCadastrarPessoas;
    RadioGroup rdgSexo;

    BDSqliteHelper db = new BDSqliteHelper(this);
    SQLiteDatabase dbSql;
    Cursor cursor;
    SimpleCursorAdapter adSC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_pessoas);

        edtNomeCadastrarPessoas = findViewById(R.id.edtNomeCadastrarPessoas);
        edtNumeroEnderecoCadastrarPessoas = findViewById(R.id.edtNumeroEnderecoCadastrarPessoas);
        edtComplementoCadastrarPessoas = findViewById(R.id.edtComplementoCadastrarPessoas);
        edtNumeroResponsavelFamiliarCadastrarPessoas = findViewById(R.id.edtNumeroResponsavelFamiliarCadastrarPessoas);

        edtTelefoneResidencialCadastrarPessoas = findViewById(R.id.edtTelefoneResidencialCadastrarPessoas);
        edtTelefoneCelular1CadastrarPessoas = findViewById(R.id.edtTelefoneCelular1CadastrarPessoas);
        edtTelefoneCelular2CadastrarPessoas = findViewById(R.id.edtTelefoneCelular2CadastrarPessoas);
        edtTelefoneCelular3CadastrarPessoas = findViewById(R.id.edtTelefoneCelular3CadastrarPessoas);
        edtDataNscimentoCadastrarPessoas = findViewById(R.id.edtDataNscimentoCadastrarPessoas);
        edtCartaoSusCadastrarPessoas = findViewById(R.id.edtCartaoSusCadastrarPessoas);

        rdbMasculinoCadastrarPessoas = findViewById(R.id.rdbMasculinoCadastrarPessoas);
        rdbFemininoCadastrarPessoas = findViewById(R.id.rdbFemininoCadastrarPessoas);
        rdbOutrosCadastrarPessoas = findViewById(R.id.rdbOutrosCadastrarPessoas);
        rdbAtivoCadastrarPessoas = findViewById(R.id.rdbAtivoCadastrarPessoas);
        rdbInativoCadastrarPessoas = findViewById(R.id.rdbInativoCadastrarPessoas);
        rdgSexo = findViewById(R.id.rdgSexo);

        cbHipertencaoArterialCadastrarPessoas = findViewById(R.id.cbHipertencaoArterialCadastrarPessoas);
        cbDiabeticoCadastrarPessoas = findViewById(R.id.cbDiabeticoCadastrarPessoas);
        cbDomiciliadoCadastrarPessoas = findViewById(R.id.cbDomiciliadoCadastrarPessoas);
        cbAcamadoCadastrarPessoas = findViewById(R.id.cbAcamadoCadastrarPessoas);
        cbFumanteCadastrarPessoas = findViewById(R.id.cbFumanteCadastrarPessoas);
        cbCancerCadastrarPessoas = findViewById(R.id.cbCancerCadastrarPessoas);
        cbDeficienteCadastrarPessoas = findViewById(R.id.cbDeficienteCadastrarPessoas);
        cbGestanteCadastrarPessoas = findViewById(R.id.cbGestanteCadastrarPessoas);
        cbResponsavelCadastrarPessoas = findViewById(R.id.cbResponsavelCadastrarPessoas);
        cbFalecidoCadastrarPessoas = findViewById(R.id.cbFalecidoCadastrarPessoas);

        spResponsavelFamiliarCadastrarPessoas = findViewById(R.id.spResponsavelFamiliarCadastrarPessoas);
        spRuaCadastrarPessoas = findViewById(R.id.spRuaCadastrarPessoas);
        spBairroCadastrarPessoas = findViewById(R.id.spBairroCadastrarPessoas);

        btnExcluir = findViewById(R.id.btnExcluir);
        btnNovoRegistro = findViewById(R.id.btnNovoRegistro);
        btnSalvarCadastrarPessoas = findViewById(R.id.btnSalvarCadastrarPessoas);
        btnCadastrarEnderecoCadastrarPessoas = findViewById(R.id.btnCadastrarEnderecoCadastrarPessoas);
        btnCadastrarBairroCadastrarPessoas = findViewById(R.id.btnCadastrarBairroCadastrarPessoas);

        //Mascara de entrada para os campos
        //Telefones
        SimpleMaskFormatter telefoneR = new SimpleMaskFormatter("(NN)NNNN-NNNN");
        MaskTextWatcher mtwTelefoneR = new MaskTextWatcher(edtTelefoneResidencialCadastrarPessoas, telefoneR);
        edtTelefoneResidencialCadastrarPessoas.addTextChangedListener(mtwTelefoneR);

        SimpleMaskFormatter telefoneC1 = new SimpleMaskFormatter("(NN)N-NNNN-NNNN");
        MaskTextWatcher mtwTelefoneC1 = new MaskTextWatcher(edtTelefoneCelular1CadastrarPessoas, telefoneC1);
        edtTelefoneCelular1CadastrarPessoas.addTextChangedListener(mtwTelefoneC1);

        SimpleMaskFormatter telefoneC2 = new SimpleMaskFormatter("(NN)N-NNNN-NNNN");
        MaskTextWatcher mtwTelefoneC2 = new MaskTextWatcher(edtTelefoneCelular2CadastrarPessoas, telefoneC2);
        edtTelefoneCelular2CadastrarPessoas.addTextChangedListener(mtwTelefoneC2);

        SimpleMaskFormatter telefoneC3 = new SimpleMaskFormatter("(NN)N-NNNN-NNNN");
        MaskTextWatcher mtwTelefoneC3 = new MaskTextWatcher(edtTelefoneCelular3CadastrarPessoas, telefoneC3);
        edtTelefoneCelular3CadastrarPessoas.addTextChangedListener(mtwTelefoneC3);
        //Fim

        //Data de nascimento
        SimpleMaskFormatter dataNascimento = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtwDataNascimento = new MaskTextWatcher(edtDataNscimentoCadastrarPessoas, dataNascimento);
        edtDataNscimentoCadastrarPessoas.addTextChangedListener(mtwDataNascimento);
        //Fim
        //Cartão Sus
        SimpleMaskFormatter cartaoSus = new SimpleMaskFormatter("NNN-NNNN-NNNN-NNNN");
        MaskTextWatcher mtwCartaoSus = new MaskTextWatcher(edtCartaoSusCadastrarPessoas, cartaoSus);
        edtCartaoSusCadastrarPessoas.addTextChangedListener(mtwCartaoSus);
        //Fim
        //Número da família
        SimpleMaskFormatter idResponsavelFamiliar = new SimpleMaskFormatter("NNN");
        MaskTextWatcher mtwIdResponsavelFamiliar = new MaskTextWatcher(edtNumeroResponsavelFamiliarCadastrarPessoas, idResponsavelFamiliar);
        edtNumeroResponsavelFamiliarCadastrarPessoas.addTextChangedListener(mtwIdResponsavelFamiliar);
        //Fim
        //Fim da mascara


        //---Teste do CRUD--

        try {//Não está funcionando o try catch pois o campo idResponsável não pode ser repitido
            //db.addPessoa(new Pessoa(80, "Claudio Jorge Eckert Junior", "General Câmara", "55", "Fundos", "Odila", "991685321", "17051985", "700704982545772", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0"));
            //db.addPessoa(new Pessoa(130, "Aline Beatris Braatz Eckert", "General Câmara", "55", "Fundos APTO 51", "Odila", "991685321", "17051985", "700704982", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0"));
            //db.addPessoa(new Pessoa(25, "José da Silva Sauros Ramos Trento", "General Câmara", "55", "Fundos", "Odila", "991580666", "18121979", "700704982", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0"));
            //db.addPessoa(new Pessoa(65, "Maria da Silva", "General Câmara", "55", "Fundos", "Odila", "991685321", "17051985", "700704982", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0"));
            //db.addPessoa(new Pessoa(42, "Mateus José Junior", "General Câmara", "55", "Fundos", "Odila", "991685321", "17051985", "700704982", "1", "0", "0", "0", "0", "0", "0", "0", "0", "1", "0", "0"));

            db.addRua(new Rua("General Câmara"));
            db.addRua(new Rua("Flores da Cunha"));
            db.addRua(new Rua("João Thiesen"));

            db.addBairro(new Bairro("Centro"));
            db.addBairro(new Bairro("Odila"));


            Toast.makeText(CadastrarPessoas.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro ao salvar dados: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        // Fim do CRUD-----------


        //Populando spinner Ruas
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,getRuas());
        spRuaCadastrarPessoas.setAdapter(adapter);
        //Fim

        //Populando spinner Bairros
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,getBairros());
        spBairroCadastrarPessoas.setAdapter(adapter2);
        //Fim

        //Populando spinner ResponsavelFamiliar
        ArrayAdapter<String> adapter3 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,getResponsaveis());
        spResponsavelFamiliarCadastrarPessoas.setAdapter(adapter3);
        //Fim

        //Pode obter a turma selecionada no Spinner desta forma:
            //Turma turmaSelecionada = ((Turma)spinner.getSelectedItem());


        spResponsavelFamiliarCadastrarPessoas.setEnabled(false);

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
        }else{
            inativarBotaoSalvar();
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
        }else{
            inativarBotaoSalvar();
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
        }else{

        }
        cursor.close();
        db.close();
        return responsaveis;
        //Toast.makeText(getApplicationContext(), "Erro ao buscar ruas " + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
    //Fim

    //Abrir activity Geral
    public void abrirActivityGeral (View v){
        startActivity(new Intent(getBaseContext(),Geral.class));
    }
    //Fim

    public void inativarBotaoSalvar(){
        btnSalvarCadastrarPessoas.setEnabled(false);
    }


    //Variaveis temporárias para cadastrar no banco
    String tempNome,tempRua,tempComplemento,tempNumero,tempBairro,tempFoneRes,tempCel1,tempCel2,tempCel3,tempDtNas,tempCartSus,tempRBSexo
            ,tempCbHArt,tempCbDiabet,tempCbDomici,tempCbAcam,tempCbFum,tempCbCanc,tempCbDefic,tempCbGest,tempCbRespFam,tempNumFam,tempRespFam
            ,tempRBAtivoInativo,tempCbFalec;
    //Fim

    //Cadastrar pessoa
    public void CadastrarPessoa(View view) {
        //Trocar cor do botão ao clicar
        //btnCadastrarCadastro.setBackgroundResource(R.color.colorAccent);
        //btnCadastrarCadastro.setTextColor(Color.GREEN);
        //btnCadastrarCadastro.setBackgroundResource(R.color.colorPrimaryDark);
        //Recuperar textos dos campos
        String textoNome = edtNomeCadastrarPessoas.getText().toString();
        String textoRua = (String) spRuaCadastrarPessoas.getSelectedItem();
        String textoComplemento = edtComplementoCadastrarPessoas.getText().toString();
        String textoNumero = edtNumeroEnderecoCadastrarPessoas.getText().toString();
        String textoBairro = (String) spBairroCadastrarPessoas.getSelectedItem();
        String textoFoneRes = edtTelefoneResidencialCadastrarPessoas.getText().toString();
        String textoFoneCel1 = edtTelefoneCelular1CadastrarPessoas.getText().toString();
        String textoFoneCel2 = edtTelefoneCelular2CadastrarPessoas.getText().toString();
        String textoFoneCel3 = edtTelefoneCelular3CadastrarPessoas.getText().toString();
        String textoDtNascimento = edtDataNscimentoCadastrarPessoas.getText().toString();
        String textoCartaoSus = edtCartaoSusCadastrarPessoas.getText().toString();
        //boolean radioGroup = rdgSexo.isSelected();
        boolean radioButtonSexoMasculino = rdbMasculinoCadastrarPessoas.isSelected();
        boolean radioButotnSexoFeminino = rdbFemininoCadastrarPessoas.isSelected();
        boolean radioButtonSexoOutros = rdbOutrosCadastrarPessoas.isSelected();
        boolean checkBoxHArterial = cbHipertencaoArterialCadastrarPessoas.isChecked();
        boolean checkBoxDiabetico = cbDiabeticoCadastrarPessoas.isChecked();
        boolean checkBoxDomiciliado = cbDomiciliadoCadastrarPessoas.isChecked();
        boolean checkBoxAcamado = cbAcamadoCadastrarPessoas.isChecked();
        boolean checkBoxFumante = cbFumanteCadastrarPessoas.isChecked();
        boolean checkBoxCancer = cbCancerCadastrarPessoas.isChecked();
        boolean checkBoxDeficiente = cbDeficienteCadastrarPessoas.isChecked();
        boolean checkBoxGestante = cbGestanteCadastrarPessoas.isChecked();
        boolean checkBoxResponsavelFamiliar = cbResponsavelCadastrarPessoas.isChecked();
        String textoNumeroDaFamilia = edtNumeroResponsavelFamiliarCadastrarPessoas.getText().toString();
        String textoResponsavelFamiliar = (String) spResponsavelFamiliarCadastrarPessoas.getSelectedItem();
        boolean radioButtonAtivo = rdbAtivoCadastrarPessoas.isSelected();
        boolean radioButtonInativo = rdbInativoCadastrarPessoas.isSelected();
        boolean checkBoxFalecido = cbFalecidoCadastrarPessoas.isChecked();

        boolean ok = false;


        if (!textoNome.isEmpty()) {//verifica nome
            if (!textoRua.isEmpty()) {//verifica rua / endereço
                  if (!textoNumero.isEmpty()){//verifica numero
                        if (!textoBairro.isEmpty()) {//verifica bairro
                            if (!textoDtNascimento.isEmpty()) {//verifica data de nascimento
                                if (!textoCartaoSus.isEmpty()) {//Verifica cartão sus
                                    ok = true;
                                    tempNome = textoNome;
                                    tempRua = textoRua;
                                    tempComplemento = textoComplemento;//não tem teste pois não é obrigatório
                                    tempNumero = textoNumero;
                                    tempBairro = textoBairro;
                                    tempDtNas = textoDtNascimento;
                                    tempCartSus = textoCartaoSus;


                                    //Teste radio button sexo
                                    if (radioButtonSexoMasculino == true){
                                        tempRBSexo = "m";
                                    }
                                    if (radioButotnSexoFeminino == true){
                                        tempRBSexo = "f";
                                    }
                                    if (radioButtonSexoOutros == true){
                                        tempRBSexo = "o";
                                    }//Fim

                                    //Teste condicionalidades
                                    //H Arterial
                                    if (checkBoxHArterial == true){
                                        tempCbHArt = "1";
                                    }else{
                                        tempCbHArt = "0";
                                    }

                                    //Diabético
                                    if (checkBoxDiabetico == true){
                                        tempCbDiabet = "1";
                                    }else{
                                        tempCbDiabet = "0";
                                    }

                                    //Domiciliado
                                    if (checkBoxDomiciliado == true){
                                        tempCbDomici = "1";
                                    }else{
                                        tempCbDomici = "0";
                                    }

                                    //Acamado
                                    if (checkBoxAcamado == true){
                                        tempCbAcam = "1";
                                    }else{
                                        tempCbAcam = "0";
                                    }

                                    //Fumante
                                    if (checkBoxFumante == true){
                                        tempCbFum = "1";
                                    }else{
                                        tempCbFum = "0";
                                    }

                                    //Câncer
                                    if (checkBoxCancer == true){
                                        tempCbCanc = "1";
                                    }else{
                                        tempCbCanc = "0";
                                    }

                                    //Deficiente
                                    if (checkBoxDeficiente == true){
                                        tempCbDefic = "1";
                                    }else{
                                        tempCbDefic = "0";
                                    }

                                    //Diabético
                                    if (checkBoxGestante == true){
                                        tempCbGest = "1";
                                    }else{
                                        tempCbGest = "0";
                                    }
                                    //Fim condicionalidades

                                    //Teste responsável familiar checkbox
                                    if (checkBoxResponsavelFamiliar == true){
                                        tempCbRespFam = "1";
                                    }else{
                                        tempCbRespFam = "0";
                                    }//fim

                                    //Numero responsavel familiar
                                    if (!textoNumeroDaFamilia.isEmpty()){
                                        tempNumFam = textoNumeroDaFamilia;
                                    }//Fim

                                    //Responsável familiar, pega o id
                                    if (!textoResponsavelFamiliar.isEmpty()){
                                        tempRespFam = textoResponsavelFamiliar;
                                    }//Fim

                                    //RadioButton Ativo inativo
                                    if (radioButtonAtivo == true){
                                        tempRBAtivoInativo = "a";
                                    }else{
                                        tempRBAtivoInativo = "i";
                                    }//Fim

                                    //Falecido
                                    if (checkBoxFalecido == true){
                                        tempCbFalec = "1";
                                    }else{
                                        tempCbFalec = "0";
                                    }//Fim

                                    //Colocar aqui o add pessoa
                                    db.addPessoa(new Pessoa(80, tempNome, tempRua, tempNumero, tempComplemento, tempBairro, tempFoneRes, tempDtNas, tempCartSus, tempRBSexo, tempCbHArt, tempCbDiabet, tempCbDomici, tempCbAcam, tempCbFum, tempCbCanc, tempCbDefic, tempCbGest, tempRespFam, tempCbFalec, tempRBAtivoInativo));


                                }else{
                                    Toast.makeText(getApplicationContext(), "Preencha o campo cartão sus!", Toast.LENGTH_SHORT).show();
                                    this.edtCartaoSusCadastrarPessoas.requestFocus();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Preencha o campo data de nascimento!", Toast.LENGTH_SHORT).show();
                                this.edtDataNscimentoCadastrarPessoas.requestFocus();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Selecione um item bairro ou cadastre!", Toast.LENGTH_SHORT).show();
                            //this.spBairroCadastrarPessoas.requestFocus();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Preencha o número!", Toast.LENGTH_SHORT).show();
                        this.edtNumeroEnderecoCadastrarPessoas.requestFocus();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Selecione um item rua ou cadastre!", Toast.LENGTH_SHORT).show();
                //this.spRuaCadastrarPessoas.requestFocus();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Preencha o campo nome!", Toast.LENGTH_SHORT).show();
            this.edtNomeCadastrarPessoas.requestFocus();
        }
        //Fim primeiros testes






    }//Fim do metodo cadastrar pessoa

    //Metodo ativar/desativar numero da família e spinner responsável familiar
    public void respFamiliar (View view){
        if (cbResponsavelCadastrarPessoas.isChecked()){
            edtNumeroResponsavelFamiliarCadastrarPessoas.setEnabled(true);
            spResponsavelFamiliarCadastrarPessoas.setEnabled(false);

        }else{
            edtNumeroResponsavelFamiliarCadastrarPessoas.setText("");
            edtNumeroResponsavelFamiliarCadastrarPessoas.setEnabled(false);
            spResponsavelFamiliarCadastrarPessoas.setEnabled(true);
        }
    }//Fim




}





