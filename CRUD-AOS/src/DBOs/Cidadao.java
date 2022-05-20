package DBOs;

public class Cidadao implements Cloneable {

    private String CPF;
    private String nome;
    private String telefone;
    private int numeroCasa;
    private String complemento;
    private String CEP;

    public Cidadao(String cpf, String nome, String numeroComDDD,int numeroCasa, String complemento, String cep) throws Exception {
        setCPF(cpf);
        setNome(nome);
        setTelefone(numeroComDDD);
        setNumeroCasa(numeroCasa);
        setComplemento(complemento);
        setCEP(cep);
    }

    public Cidadao(Cidadao c) throws Exception {

        if (c == null)
            throw new Exception("aluno inexistente");

        setCPF(c.CPF);
        setNome(c.nome);
        setTelefone(c.telefone);
        setNumeroCasa(c.numeroCasa);
        setComplemento(c.complemento);
        setCEP(c.CEP);
    }

    public void setCPF(String cpf) throws Exception {
        if (cpf == null)
            throw new Exception("o CPF precisa ter valor");

        CPF = cpf;
    }

    public String getCPF() {
        return CPF;
    }

    public void setNome(String nome) throws Exception {
        if (nome == null)
            throw new Exception("o nome nao pode ser nulo");

        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setTelefone(String numeroComDDD) throws Exception {
        if(numeroComDDD.length() > 11)
            throw new Exception("o numero de telefone com o ddd nao pode ultrapassar 11 digitos");

        telefone = numeroComDDD;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNumeroCasa(int numeroCasa) throws Exception{
        if(numeroCasa < 0)
            throw new Exception("nao existe numero de cada que seja negativo");
        this.numeroCasa = numeroCasa;
    }
    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setComplemento(String complemento) { // nao lanca excecao pois o complemento nao eh not null no bd
        this.complemento = complemento;
    }
    public String getComplemento() {
        return complemento;
    }

    public void setCEP(String cep) throws Exception {
        if (cep ==null)
            throw new Exception();

        CEP = cep;
    }

    public String getCEP() {
        return CEP;
    }
    
    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n CPF: " + getCPF() + " \n telefone: " + getTelefone() + "\n numero da casa: " + getNumeroCasa() + "\n complemento: " + getComplemento() + "\n CEP: " + getCEP();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != Cidadao.class)
            return false;

        Cidadao cidadao = (Cidadao) obj;

        if (!this.CPF.equals(cidadao.CPF))
            return false;
        if (!this.nome.equals(cidadao.nome))
            return false;
        if (!this.telefone.equals(cidadao.telefone))
            return false;
        if (this.numeroCasa != cidadao.numeroCasa)
            return false;
        if (!this.complemento.equals(cidadao.complemento))
            return false;
        if (this.CEP != cidadao.CEP)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        var ret = 31;
        ret = ret * 13 + String.valueOf(CPF).hashCode();
        ret = ret * 13 + String.valueOf(nome).hashCode();
        ret = ret * 13 + String.valueOf(telefone).hashCode();
        ret = ret * 13 + Integer.valueOf(numeroCasa).hashCode();
        ret = ret * 13 + String.valueOf(complemento).hashCode();
        ret = ret * 13 + Integer.valueOf(CEP).hashCode();

        return ret < 0 ? -ret : ret;
    }

    @Override
    public Object clone() {
        Cidadao c = null;

        try {
            c = new Cidadao(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}