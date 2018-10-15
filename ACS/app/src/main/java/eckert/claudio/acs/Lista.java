package eckert.claudio.acs;

import java.util.Date;

public class Lista {
    private int numeroFamilia;
    private String nomeChefeFamilia;
    private int cartaoSusChefeFamilia;
    private Date datNascimentoChefeFamilia;

    public Lista(int numeroFamilia, String nomeChefeFamilia, int cartaoSusChefeFamilia, Date datNascimentoChefeFamilia) {
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

    public int getCartaoSusChefeFamilia() {
        return cartaoSusChefeFamilia;
    }

    public void setCartaoSusChefeFamilia(int cartaoSusChefeFamilia) {
        this.cartaoSusChefeFamilia = cartaoSusChefeFamilia;
    }

    public Date getDatNascimentoChefeFamilia() {
        return datNascimentoChefeFamilia;
    }

    public void setDatNascimentoChefeFamilia(Date datNascimentoChefeFamilia) {
        this.datNascimentoChefeFamilia = datNascimentoChefeFamilia;
    }
}
