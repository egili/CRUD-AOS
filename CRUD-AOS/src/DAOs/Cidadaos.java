package DAOs;

import DBOs.Cidadao;
import bd.BDSQLServer;
import java.sql.SQLException;

public class Cidadaos {
    public static void incluir (Cidadao cidadao) throws Exception
    {
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

            BDSQLServer.COMANDO.setLong   (1, cidadao.getCPF());
            BDSQLServer.COMANDO.setString (2, cidadao.getNome());
            BDSQLServer.COMANDO.setLong   (3, Long.parseLong(cidadao.getTelefone()));
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
}
