package DBOs;

import project.Telefone;

public class Aluno {

    private int RA;
    private String nome;
    private Telefone telefone;

    public Aluno(int ra, String nome, int ddd, long numero) throws Exception {
        setRa(ra);
        setNome(nome);
        this.telefone = new Telefone(ddd, numero);
    }

    public void setRa(int ra) throws Exception{

        if(ra < 0)
            throw new Exception("o RA precisa ter o valor de um numero positivo");

        RA = ra;
    }
    public int getRA(){
        return RA;
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
        return "Nome: " + getNome() + "\n RA: " + getRA() + " \n telefone: " + getTelefone();
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != Aluno.class)
            return false;

        Aluno aluno = (Aluno) obj;

        if(this.RA != aluno.RA)
            return false;
        if(this.nome != aluno.nome)
            return false;
        if(this.telefone != aluno.telefone)
            return false;

        return true;
    }

    @Override
    public int hashCode() {

        int ret = 31;
        ret = ret * 13 + Integer.valueOf(RA).hashCode();
        ret = ret * 13 + String.valueOf(nome).hashCode();
        ret = ret * 13 + telefone.hashCode();

        return ret < 0 ? -ret : ret;
    }
}