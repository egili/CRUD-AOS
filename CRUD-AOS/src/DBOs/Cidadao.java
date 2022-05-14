package DBOs;

import project.Telefone;

import java.util.Objects;

public class Cidadao implements Cloneable{

    private long CPF;
    private String nome;
    private Telefone telefone;
    private int CEP;
    private char genero;

    public Cidadao(long cpf, String nome, int ddd, long numero, int cep, char genero) throws Exception {
        setCPF(cpf);
        setNome(nome);
        setTelefone(ddd, numero);
        setCEP(cep);
        this.genero = genero;
    }
    public Cidadao(Cidadao c) throws Exception {

        if(c == null)
            throw new Exception("aluno inexistente");

        setCPF(c.CPF);
        setNome(c.nome);
        this.telefone = new Telefone(c.telefone);
    }

    public void setCPF(long cpf) throws Exception{

        if(cpf < 0)
            throw new Exception("o CPF precisa ter o valor de um numero positivo");

        CPF = cpf;
    }
    public long getCPF(){
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

    public void setTelefone(int ddd, long numero) throws Exception {
        this.telefone = new Telefone(ddd, numero);
    }
    public String getTelefone() {
        return telefone.getTelefone();
    }

    public void setCEP(int cep) throws Exception{
        if(cep < 0)
            throw new Exception();

        CEP = cep;
    }
    public int getCEP(){
        return CEP;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n CPF: " + getCPF() + " \n telefone: " + getTelefone() + "\n CEP: " + getCEP();
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
        if(!Objects.equals(this.nome, cidadao.nome))
            return false;
        if(this.telefone != cidadao.telefone)
            return false;
        if(this.CEP != cidadao.CEP)
            return false;

        return this.genero == cidadao.genero;
    }

    @Override
    public int hashCode() {

        int ret = 31;
        ret = ret * 13 + Long.valueOf(CPF).hashCode();
        ret = ret * 13 + String.valueOf(nome).hashCode();
        ret = ret * 13 + telefone.hashCode();
        ret = ret * 13 + Integer.valueOf(CEP).hashCode();
        ret = ret * 13 + genero;

        return ret < 0 ? -ret : ret;
    }

    public Object clone() {

        Cidadao c = null;

        try{
            c = new Cidadao(this);
        } catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }
}