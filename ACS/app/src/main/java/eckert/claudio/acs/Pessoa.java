package eckert.claudio.acs;

public class Pessoa {
    int _id;
    String idResponsavel;
    String nome;
    String endereco;
    String numero;
    String complemento;
    String bairro;
    String telRes;
    String teLCel1;
    String telCel2;
    String telCel3;
    String dataNascimento;
    String cartaoSus;
    String sexo;
    String hArterial;
    String diabetico;
    String domiciliado;
    String acamado;
    String fumante;
    String cancer;
    String deficiente;
    String gestante;
    String responsavelFamiliar;
    String falecido;
    String ativoInativo;
//-------------------------


    public Pessoa(String idResponsavel, String nome, String endereco, String numero, String complemento, String bairro, String telRes, String teLCel1, String telCel2, String telCel3, String dataNascimento, String cartaoSus, String sexo, String hArterial, String diabetico, String domiciliado, String acamado, String fumante, String cancer, String deficiente, String gestante, String responsavelFamiliar, String falecido, String ativoInativo) {
        this.idResponsavel = idResponsavel;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.telRes = telRes;
        this.teLCel1 = teLCel1;
        this.telCel2 = telCel2;
        this.telCel3 = telCel3;
        this.dataNascimento = dataNascimento;
        this.cartaoSus = cartaoSus;
        this.sexo = sexo;
        this.hArterial = hArterial;
        this.diabetico = diabetico;
        this.domiciliado = domiciliado;
        this.acamado = acamado;
        this.fumante = fumante;
        this.cancer = cancer;
        this.deficiente = deficiente;
        this.gestante = gestante;
        this.responsavelFamiliar = responsavelFamiliar;
        this.falecido = falecido;
        this.ativoInativo = ativoInativo;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(String idResponsavel) {
        this.idResponsavel = idResponsavel;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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

    public String getTelRes() {
        return telRes;
    }

    public void setTelRes(String telRes) {
        this.telRes = telRes;
    }

    public String getTeLCel1() {
        return teLCel1;
    }

    public void setTeLCel1(String teLCel1) {
        this.teLCel1 = teLCel1;
    }

    public String getTelCel2() {
        return telCel2;
    }

    public void setTelCel2(String telCel2) {
        this.telCel2 = telCel2;
    }

    public String getTelCel3() {
        return telCel3;
    }

    public void setTelCel3(String telCel3) {
        this.telCel3 = telCel3;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String gethArterial() {
        return hArterial;
    }

    public void sethArterial(String hArterial) {
        this.hArterial = hArterial;
    }

    public String getDiabetico() {
        return diabetico;
    }

    public void setDiabetico(String diabetico) {
        this.diabetico = diabetico;
    }

    public String getDomiciliado() {
        return domiciliado;
    }

    public void setDomiciliado(String domiciliado) {
        this.domiciliado = domiciliado;
    }

    public String getAcamado() {
        return acamado;
    }

    public void setAcamado(String acamado) {
        this.acamado = acamado;
    }

    public String getFumante() {
        return fumante;
    }

    public void setFumante(String fumante) {
        this.fumante = fumante;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    public String getDeficiente() {
        return deficiente;
    }

    public void setDeficiente(String deficiente) {
        this.deficiente = deficiente;
    }

    public String getGestante() {
        return gestante;
    }

    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    public String getResponsavelFamiliar() {
        return responsavelFamiliar;
    }

    public void setResponsavelFamiliar(String responsavelFamiliar) {
        this.responsavelFamiliar = responsavelFamiliar;
    }

    public String getFalecido() {
        return falecido;
    }

    public void setFalecido(String falecido) {
        this.falecido = falecido;
    }

    public String getAtivoInativo() {
        return ativoInativo;
    }

    public void setAtivoInativo(String ativoInativo) {
        this.ativoInativo = ativoInativo;
    }
}

