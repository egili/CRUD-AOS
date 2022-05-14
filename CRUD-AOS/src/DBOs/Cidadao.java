package DBOs;

import project.Telefone;

//TODO : esta classe esta incompleta !!
public class Cidadao implements Cloneable{

    private int CPF;
    private String nome;
    private Telefone telefone;
    private int CEP;
    private char genero;

    public Cidadao(int ra, String nome, int ddd, long numero) throws Exception {
        setRa(ra);
        setNome(nome);
        this.telefone = new Telefone(ddd, numero);
    }
    public Cidadao(Cidadao a) throws Exception {

        if(a == null)
            throw new Exception("aluno inexistente");

        this.nome = a.nome;
        this.CPF = a.CPF;
        this.telefone = a.telefone;
    }

    public void setRa(int ra) throws Exception{

        if(ra < 0)
            throw new Exception("o RA precisa ter o valor de um numero positivo");

        CPF = ra;
    }
    public int getCPF(){
        return CPF;
    }

    public void setNome(String nome) throws Exception{
        if(nome == null)
            throw new Exception("o nome nao pode ser nulo");

        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
    public Telefone getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n RA: " + getCPF() + " \n telefone: " + getTelefone();
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != Cidadao.class)
            return false;

        Cidadao cidadao = (Cidadao) obj;

        if(this.CPF != cidadao.CPF)
            return false;
        if(this.nome != cidadao.nome)
            return false;
        if(this.telefone != cidadao.telefone)
            return false;

        return true;
    }

    @Override
    public int hashCode() {

        int ret = 31;
        ret = ret * 13 + Integer.valueOf(CPF).hashCode();
        ret = ret * 13 + String.valueOf(nome).hashCode();
        ret = ret * 13 + telefone.hashCode();

        return ret < 0 ? -ret : ret;
    }

    public Object clone() {

        Cidadao a = null;

        try{
            a = new Cidadao(this);
        } catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }
}