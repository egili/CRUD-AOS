package project.helpers;

import java.util.Objects;

public class Genero implements Cloneable {

    private String genero;

    public Genero(String g) throws Exception {

        if (g == null)
            throw new Exception("Genero invalido");
        if(g.length() > 1)
            throw new Exception("apenas 1 caracter eh aceito na definicao de genero");

        setGenero(g);
    }

//    private String setGeneroOLD(Character c) throws Exception {
//        String ret = "";
//        var a = Character.toUpperCase(c);
//
//        if (a != 'M' || a != 'F' || a != 'O')
//            throw new Exception("Genero invalido");
//
//        if (a == 'M')
//            ret = "Masculino";
//        else if(a == 'F')
//            ret = "Feminino";
//        else if(a == 'O')
//            ret = "Outro";
//
//        return ret;
//    }
//
    public String setGenero(String generoDoCidadao) throws Exception{

        String ret = generoDoCidadao.toUpperCase();

        return ret.equals("M") ? "Masculino" : ret.equals("F") ? "Feminino" : "Outro";
    }
    public String getGenero() throws Exception {
        return setGenero(genero);
    }

    @Override
    public String toString(){
        return "genero: " + genero;
    }
    @Override
    public boolean equals(Object obj) {

        if(this == obj)
            return true;
        if(obj == null)
            return false;

       if (obj.getClass() != Genero.class)
           return false;

       return Objects.equals(this.genero, ((Genero) obj).genero);
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

    @Override
    public Object clone () {
        Genero ret = null;
        try {
            ret = new Genero (this);
        }
        catch (Exception ignored)
        {}
        return  ret;
    }
}
