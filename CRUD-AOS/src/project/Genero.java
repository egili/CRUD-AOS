package project;

import DBOs.Cidadao;

public class Genero implements Cloneable {

    private Character genero;

    public Genero(Character g) throws Exception {

        if (g == null)
            throw new Exception("Genero inválido");

        this.genero = g;
    }

    public String getGenero(Character c) throws Exception
    {
        String ret = "";
        char a = Character.toUpperCase(c);

        if (a != 'M' || a != 'F' || a != 'O')
            throw new Exception("Genero inválido");

        if (a == 'M')
            ret = "Masculino";
        else if(a == 'F')
            ret = "Feminino";
        else if(a == 'O')
            ret = "Outro";

        return ret;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj)
            return true;
        if(obj == null)
            return false;

       if (obj.getClass() != Genero.class)
           return false;

       if(this.genero != ((Genero)obj).genero)
            return false;

       return true;
    }

    @Override
    public int hashCode() {

        int ret = 31;
        ret = ret * 13 + genero.hashCode();

        return ret < 0 ? -ret : ret;
    }

    public Genero (Genero g) throws Exception{
        if (g == null)
            throw new Exception("Genero inexistente");
        this.genero = g.genero;
    }

    public  Object clone () {
        Genero ret = null;
        try {
            ret = new Genero (this);
        }
        catch (Exception ignored)
        {}
        return  ret;
    }
}
