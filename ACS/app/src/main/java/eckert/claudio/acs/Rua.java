package eckert.claudio.acs;

public class Rua {
    int _id;
    String rua;

    @Override
    public String toString() {
        return "Rua{" +
                "rua='" + rua + '\'' +
                '}';
    }

    public Rua(String rua) {
        this.rua = rua;
    }

    public Rua(int id, String nomeRua) {
        this._id = id;
        this.rua = nomeRua;
    }


    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}


