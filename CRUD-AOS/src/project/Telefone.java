package project;

public class Telefone {

    private int ddd;
    private long numero;

    public Telefone(int ddd, long numero) throws Exception{
        this.ddd = ddd;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "telefone: " + ddd + numero;
    }

    public String getTelefone(){
        return this.toString();
    }

    @Override
    public boolean equals(Object obj){

        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != Telefone.class)
            return false;

        Telefone telefone = (Telefone) obj;

        if(this.ddd != telefone.ddd)
            return false;
        if(this.numero != telefone.numero)
            return false;

        return true;
    }

    @Override
    public int hashCode() {

        int ret = 31;
        ret = ret * 13 + Integer.valueOf(this.ddd).hashCode();
        ret = ret * 13 + Long.valueOf(this.numero).hashCode();

        return ret < 0 ? -ret : ret;
    }
}
