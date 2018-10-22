package eckert.claudio.acs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDSqliteHelper extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String NOME_BANCO = "bd_acs";

    //Tabela pessoas
    private static final String TABELA_PESSOA = "tb_pessoas";

    private static final String C_ID = "id";
    private static final String C_NOME = "nome";
    private static final String C_ENDERECO = "endereco";
    private static final String C_COMPLEMENTO = "complemento";
    private static final String C_BAIRRO = "bairro";
    private static final String C_NUMERO = "numero";
    private static final String C_TELEFONE = "telefone";
    private static final String C_DATANASCIMENTO = "dataNascimento";
    private static final String C_CARTAOSUS = "cartaoSus";
    private static final String C_SEXO = "sexo";
    private static final String C_HARTERIAL = "hArterial";
    private static final String C_DIABETICO = "diabetico";
    private static final String C_DOMICILIADO = "domiciliado";
    private static final String C_ACAMADO = "acamado";
    private static final String C_FUMANTE = "fumante";
    private static final String C_CANCER = "cancer";
    private static final String C_DEFICIENTE = "deficiente";
    private static final String C_GESTANTE = "gestante";
    private static final String C_RESPONSAVELFAMILIAR = "responsavelFamiliar";
    private static final String C_FALECIDO = "falecido";
    private static final String C_ATIVOINATIVO = "ativoInativo";

    public BDSqliteHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABELA_PESSOA + "("
                + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + C_NOME + " TEXT,"
                + C_ENDERECO + " TEXT,"
                + C_COMPLEMENTO + " TEXT,"
                + C_BAIRRO + " TEXT,"
                + C_NUMERO + " INTEGER,"
                + C_TELEFONE + " INTEGER,"
                + C_DATANASCIMENTO + " TEXT,"
                + C_CARTAOSUS + " INTEGER,"
                + C_SEXO + " INTEGER,"
                + C_HARTERIAL + " INTEGER,"
                + C_DIABETICO + " INTEGER,"
                + C_DOMICILIADO + " INTEGER,"
                + C_ACAMADO + " INTEGER,"
                + C_FUMANTE + " INTEGER,"
                + C_CANCER + " INTEGER,"
                + C_DEFICIENTE + " INTEGER,"
                + C_GESTANTE + " INTEGER,"
                + C_RESPONSAVELFAMILIAR + "INTEGER,"
                + C_FALECIDO + "INTEGER,"
                + C_ATIVOINATIVO + "INTEGER)";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //CRUD
    void addPessoa(Pessoa pessoa){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(C_NOME, pessoa.getNome());
        values.put(C_ENDERECO, pessoa.getEndereco());
        values.put(C_COMPLEMENTO, pessoa.getComplemento());
        values.put(C_BAIRRO, pessoa.getBairro());
        values.put(C_NUMERO, pessoa.getNumero());
        values.put(C_TELEFONE, pessoa.getTelefone());
        values.put(C_DATANASCIMENTO, pessoa.getDataNascimento());
        values.put(C_CARTAOSUS, pessoa.getCartaoSus());
        values.put(C_SEXO, pessoa.getSexo());
        values.put(C_HARTERIAL, pessoa.gethArterial());
        values.put(C_DIABETICO, pessoa.getDiabetico());
        values.put(C_DOMICILIADO, pessoa.getDomiciliado());
        values.put(C_ACAMADO, pessoa.getAcamado());
        values.put(C_FUMANTE, pessoa.getFumante());
        values.put(C_CANCER, pessoa.getCancer());
        values.put(C_DEFICIENTE, pessoa.getDeficiente());
        values.put(C_GESTANTE, pessoa.getGestante());
        values.put(C_RESPONSAVELFAMILIAR, pessoa.getResponsavelFamiliar());
        values.put(C_FALECIDO, pessoa.getFalecido());
        values.put(C_ATIVOINATIVO, pessoa.getAtivoInativo());


        db.insert(TABELA_PESSOA, null, values);
        db.close();
    }

}
