package DAOs;

import DBOs.Cidadao;
import bd.BDSQLServer;
import bd.core.MeuResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Cidadaos {

    public static boolean cadastrado(String cpf) throws Exception{
        var ret = false;

        try{
            String sql;

            sql = "SELECT * " +
                    "FROM cidadao " +
                    "WHERE cid_cpf = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, cpf);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            ret = resultado.first();

        } catch (SQLException err){
            throw new Exception("erro ao procurar cidadao");
        }
        return ret;
    }

    public static void create (Cidadao cidadao) throws Exception{
        if (cidadao==null)
            throw new Exception ("Cidadao nao inserido");

        try
        {
            String sql;

            sql = "INSERT INTO cidadao " +
                  "(cid_cpf, cid_nome, cid_telefone, cid_numeroDaCasa, cid_complemento, cid_cep) " +
                  "VALUES " +
                  "(?,?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString(1, cidadao.getCPF());
            BDSQLServer.COMANDO.setString(2, cidadao.getNome());
            BDSQLServer.COMANDO.setString(3, cidadao.getTelefone());
            BDSQLServer.COMANDO.setInt(4, cidadao.getNumeroCasa());
            BDSQLServer.COMANDO.setString(5, cidadao.getComplemento());
            BDSQLServer.COMANDO.setInt(6, cidadao.getCEP());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao cadastrar cidadao");
        }
    }

    public static Cidadao read(String cpf) throws Exception{
        Cidadao cidadao = null;

        try {
            String sql;

            sql = "SELECT * " +
                    "FROM cidadao" +
                    "WHERE cid_cpf = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setString(1, cpf);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            if(!resultado.first())
                throw new Exception("sem dados correspondemtes ao parametro informado");

            cidadao = new Cidadao(resultado.getString("cid_cpf"),
                    resultado.getString("cid_nome"),
                    resultado.getString("cid_telefone"),
                    resultado.getInt("cid_numeroDaCasa"),
                    resultado.getString("cid_complemento"),
                    resultado.getInt("cid_cep"));

        } catch (SQLException erro){
            BDSQLServer.COMANDO.rollback();
            throw new Exception("erro ao procurar o cidadao");
        }
        return cidadao;
    }

    public static List<Cidadao> readAll() throws Exception{
        MeuResultSet meuResultSet = null;
        List<Cidadao> cidadaoList = new ArrayList<Cidadao>();
        Cidadao cidadao = null;
        String cpf, nome, telefone, complemento;
        int numeroCasa, cep;

        try{
            String sql;

            sql = "SELECT * " + "FROM cidadao";

            BDSQLServer.COMANDO.prepareStatement(sql);

            meuResultSet = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            while (meuResultSet.next()){

                cpf = meuResultSet.getString("cid_cpf");
                nome = meuResultSet.getString("cid_nome");
                telefone = meuResultSet.getString("cid_telefone");
                numeroCasa = meuResultSet.getInt("cid_numeroDaCasa");
                complemento = meuResultSet.getString("cid_complemento");
                cep = meuResultSet.getInt("cid_cep");

                cidadao = new Cidadao(cpf, nome, telefone, numeroCasa, complemento, cep);

                cidadaoList.add(cidadao);
            }
        } catch(SQLException err){
            BDSQLServer.COMANDO.rollback();
            throw new Exception("erro ao recuperar os dados dos cidadaos");
        }
        return cidadaoList;
    }

    public static void update(Cidadao cidadao) throws Exception{
        if(cidadao == null)
            throw new Exception("cidadao nao fornecido");
        if(!cadastrado(cidadao.getCPF()))
            throw new Exception("cidadao nao cadastrado");

        try {
            String sql;

            sql = "UPDATE cidadao " +
                    "SET cid_nome = ? " +
                    "SET cid_telefone = ? " +
                    "SET cid_numeroDaCasa = ? " +
                    "SET cid_complemento = ? " +
                    "SET cid_cep = ? " +
                    "WHERE cid_cpf = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString(1, cidadao.getCPF());
            BDSQLServer.COMANDO.setString(2, cidadao.getNome());
            BDSQLServer.COMANDO.setString(3, cidadao.getTelefone());
            BDSQLServer.COMANDO.setInt(4, cidadao.getNumeroCasa());
            BDSQLServer.COMANDO.setString(5, cidadao.getComplemento());
            BDSQLServer.COMANDO.setInt(6, cidadao.getCEP());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();

        } catch (SQLException err){
            BDSQLServer.COMANDO.rollback();
            throw new Exception("erro ao atualizar dados do cidadao");
        }
    }

    public static void delete(String cpf) throws Exception{
        if(!cadastrado(cpf))
            throw new Exception("nao cadastrado");

        try{
            String sql;

            sql = "DELETE FROM cidadao " +
                    "WHERE cid_cpf = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, cpf);

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();

        } catch (SQLException err){
            BDSQLServer.COMANDO.rollback();
            throw new Exception("erro ao deletar o cidadao");
        }
    }
}
