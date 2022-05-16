package DAOs;

import DBOs.Cidadao;
import bd.BDSQLServer;
import bd.core.MeuResultSet;

import java.sql.SQLException;

public class Cidadaos {

    public static void create (Cidadao cidadao) throws Exception{
        if (cidadao==null)
            throw new Exception ("Cidadao nao inserido");

        try
        {
            String sql;

            sql = "INSERT INTO cidadao " +
                  "(cid_cpf, cid_nome, cid_telefone, cid_genero, cid_cep) " +
                  "VALUES " +
                  "(?,?,?,?,?)";  //Marcando o lugar aonde mais tarde vai
                                  //entrar os valores inseridos

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, String.valueOf(cidadao.getCPF()));
            BDSQLServer.COMANDO.setString (2, cidadao.getNome());
            BDSQLServer.COMANDO.setString (3, String.valueOf(Long.parseLong(cidadao.getTelefone())));
            BDSQLServer.COMANDO.setString (5, String.valueOf(cidadao.getGenero()));
            BDSQLServer.COMANDO.setInt    (4, cidadao.getCEP());

            BDSQLServer.COMANDO.executeUpdate (); //comando pra atualizar o banco
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao inserir cidadao");
        }
    }

    public static Cidadao read(int cpf) throws Exception{

        Cidadao cidadao = null;

        try {
            String sql;

            sql = "SELECT * " +
                    "FROM cidadao" +
                    "WHERE cid_cpf = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, cpf);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            if(!resultado.first())
                throw new Exception("sem dados correspondemtes ao parametro informado");

            cidadao = new Cidadao(resultado.getLong(Math.toIntExact(Long.parseLong("cid_cpf"))),
                    resultado.getString("cid_nome"),
                    resultado.getInt(CRUDHelper.getDDDdoCidadao("cid_telefone")), //ddd
                    resultado.getLong(CRUDHelper.getNumerodoCidadao("cid_telefone")), // numero de telefone
                    resultado.getString(CRUDHelper.getGeneroAsCharSize("cid_genero")),
                    resultado.getInt("cid_cep"));

        } catch (SQLException erro){
            throw new Exception("erro ao procurar o cidadao");
        }
        return cidadao;
    }

    public static MeuResultSet readAll() throws Exception{

        MeuResultSet ret = null;

        try{
            String sql;

            sql = "SELECT * " + "FROM cidadao";

            BDSQLServer.COMANDO.prepareStatement(sql);

            ret = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
        } catch(SQLException err){
            throw new Exception("erro ao ler os dados dos cidadaos");
        }
        return ret;
    }

    public static void update(Cidadao cidadao) throws Exception{

        if(cidadao == null)
            throw new Exception("cidadao nao fornecido");
        if(!CRUDHelper.cadastrado((int) cidadao.getCPF()))
            throw new Exception("nao cadastrado");

        try {
            String sql;

            sql = "UPDATE cidadao " +
                    "SET " + // TODO: set pra cada atributo do cidadao
                    "WHERE cid_cpf = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt(3, (int) cidadao.getCPF());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (SQLException err){
            BDSQLServer.COMANDO.rollback();
            throw new Exception("erro ao atualizar dados do cidadao");
        }
    }

    public static void delete(int cpf) throws Exception{

        if(!CRUDHelper.cadastrado(cpf))
            throw new Exception("nao cadastrado");

        try{
            String sql;

            sql = "DELETE FROM cidadao " +
                    "WHERE cid_cpf = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, cpf);

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (SQLException err){
            BDSQLServer.COMANDO.rollback();
            throw new Exception("erro ao deletar o cidadao");
        }
    }
}
