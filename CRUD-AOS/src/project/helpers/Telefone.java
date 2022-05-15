package project.helpers;

public class Telefone implements Cloneable {

    private final int ddd;
    private final long numero;

    public Telefone(int ddd, long numero) throws Exception {

        if (ddd < 0 || numero < 0)
            throw new Exception("os dados do telefone precisam ser numero maiores do que zero");

        this.ddd = ddd;
        this.numero = numero;
    }

    public Telefone(Telefone t) throws Exception {

        if (t == null)
            throw new Exception("telefone inexistente");

        this.ddd = t.ddd;
        this.numero = t.numero;
    }

    @Override
    public String toString() {
        return "telefone: " + ddd + numero;
    }

    public String getTelefone() {
        return this.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != Telefone.class)
            return false;

        Telefone telefone = (Telefone) obj;

        if (this.ddd != telefone.ddd)
            return false;

        return this.numero == telefone.numero;
    }

    @Override
    public int hashCode() {

        int ret = 31;
        ret = ret * 13 + Integer.valueOf(this.ddd).hashCode();
        ret = ret * 13 + Long.valueOf(this.numero).hashCode();

        return ret < 0 ? -ret : ret;
    }

    public Object clone() {
        Telefone tel = null;

        try {
            tel = new Telefone(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tel;
    }
}
