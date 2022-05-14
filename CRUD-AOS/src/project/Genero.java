package project;

import DBOs.Cidadao;

public class Genero implements Cloneable {

    private String generoDaPessoa;
    private Character genero;
    //Aqui ele recbe o M or F or O



    public Genero(Genero g) throws Exception {

            if (g == null)
                throw new Exception("Genero inexistente");

            this.genero = g.genero;
    }

    public Character getGenero(){
        return genero;
    }


    @Override
    public boolean equals(Object obj) {

        if(this == obj)
            return true;
        if(obj == null)
            return false;

       if (obj.getClass() != Genero.class) return false;

        if(this.genero !=((Genero)obj).genero)
            return false;

        return true;
    }

    @Override
    public int hashCode() {

        int ret = 31;
        ret = ret * 13 + Character.valueOf(genero).hashCode();

        return ret < 0 ? -ret : ret;
    }

    public  Object clone () {
        Genero ret = null;
        try {
            ret = new Genero (this);
        }
        catch (Exception erro)
        {}
        return  ret;
    }
}
