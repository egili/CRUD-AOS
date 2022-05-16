package DAOs;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Cidadaos {
    public static void incluir (Cidadaos cidadaos) throws Exception
    {
        if (cidadaos==null)
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

            BDSQLServer.COMANDO.setLong   (1, cidadaos.getCPF());
            BDSQLServer.COMANDO.setString (2, cidadaos.getNome());
            BDSQLServer.COMANDO.setLong   (3, cidadaos.getTelefone());
            BDSQLServer.COMANDO.setInt    (4, cidadaos.getCEP());
            BDSQLServer.COMANDO.setString (5, cidadaos.getGenero());

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
