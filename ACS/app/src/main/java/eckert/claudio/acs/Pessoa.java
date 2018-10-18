package eckert.claudio.acs;

public class Pessoa {
    int id;
    String nome;
    String endereco;
    int numero;
    String complemento;
    String bairro;
    int telefone;
    String dataNascimento;
    int cartaoSus;
    int hArterial;
    int diabetico;
    int domiciliado;
    int acamado;
    int fumante;
    int cancer;
    int deficiente;
    int gestante;

    public Pessoa(){

    }
    //Update
    public Pessoa(int _id, String _nome, String _endereco, int _numero, String _complemento, String _bairro, int _telefone, String _dataNascimento, int _cartaoSus, int _hArterial, int _diabetico, int _domiciliado, int _acamado, int _fumante, int _cancer, int _deficiente, int _gestante) {
        this.id = _id;
        this.nome = _nome;
        this.endereco = _endereco;
        this.numero = _numero;
        this.complemento = _complemento;
        this.bairro = _bairro;
        this.telefone = _telefone;
        this.dataNascimento = _dataNascimento;
        this.cartaoSus = _cartaoSus;
        this.hArterial = _hArterial;
        this.diabetico = _diabetico;
        this.domiciliado = _domiciliado;
        this.acamado = _acamado;
        this.fumante = _fumante;
        this.cancer = _cancer;
        this.deficiente = _deficiente;
        this.gestante = _gestante;
    }
    //Inserir
    public Pessoa( String _nome, String _endereco, int _numero, String _complemento, String _bairro, int _telefone, String _dataNascimento, int _cartaoSus, int _hArterial, int _diabetico, int _domiciliado, int _acamado, int _fumante, int _cancer, int _deficiente, int _gestante) {
        this.nome = _nome;
        this.endereco = _endereco;
        this.numero = _numero;
        this.complemento = _complemento;
        this.bairro = _bairro;
        this.telefone = _telefone;
        this.dataNascimento = _dataNascimento;
        this.cartaoSus = _cartaoSus;
        this.hArterial = _hArterial;
        this.diabetico = _diabetico;
        this.domiciliado = _domiciliado;
        this.acamado = _acamado;
        this.fumante = _fumante;
        this.cancer = _cancer;
        this.deficiente = _deficiente;
        this.gestante = _gestante;
    }
    //-----------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(int cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public int gethArterial() {
        return hArterial;
    }

    public void sethArterial(int hArterial) {
        this.hArterial = hArterial;
    }

    public int getDiabetico() {
        return diabetico;
    }

    public void setDiabetico(int diabetico) {
        this.diabetico = diabetico;
    }

    public int getDomiciliado() {
        return domiciliado;
    }

    public void setDomiciliado(int domiciliado) {
        this.domiciliado = domiciliado;
    }

    public int getAcamado() {
        return acamado;
    }

    public void setAcamado(int acamado) {
        this.acamado = acamado;
    }

    public int getFumante() {
        return fumante;
    }

    public void setFumante(int fumante) {
        this.fumante = fumante;
    }

    public int getCancer() {
        return cancer;
    }

    public void setCancer(int cancer) {
        this.cancer = cancer;
    }

    public int getDeficiente() {
        return deficiente;
    }

    public void setDeficiente(int deficiente) {
        this.deficiente = deficiente;
    }

    public int getGestante() {
        return gestante;
    }

    public void setGestante(int gestante) {
        this.gestante = gestante;
    }
}
