package DBOs;

import project.Telefone;

public class Aluno {

    private int RA;
    private String nome;
    private Telefone telefone;

    public Aluno(int ra, String nome, Telefone telefone) throws Exception {
        setRa(ra);
        setNome(nome);
        this.telefone = telefone;
    }

    public void setRa(int ra) throws Exception{
        if(ra < 0)
            throw new Exception("o ra precisa ter o valor de um numero positivo");
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
}