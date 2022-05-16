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

            sql = "INSERT INTO CIDADAOS " +
                  "(CPF,NOME,TELEFONE,CEP,GENERO) " +
                  "VALUES " +
                  "(?,?,?,?,?)";  //Marcando o lugar aonde mais tarde vai
                                  //entrar os valores inseridos

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setLong   (1, cidadao.getCPF());
            BDSQLServer.COMANDO.setString (2, cidadao.getNome());
            BDSQLServer.COMANDO.setLong   (3, cidadao.getTelefone());
            BDSQLServer.COMANDO.setInt    (4, cidadao.getCEP());
            BDSQLServer.COMANDO.setString (5, cidadao.getGenero());

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
