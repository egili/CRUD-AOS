package bd;

import bd.core.MeuPreparedStatement;

public class BDSQLServer
{
    public static final MeuPreparedStatement COMANDO;

    static
    {
        MeuPreparedStatement comando = null;

        try
        {
            comando =
                    new MeuPreparedStatement (
                            "com.microsoft.sqlserver.jdbc.SQLServerDriver", //especifica o driver
                            "jdbc:sqlserver://192.168.15.26:1433;databasename=LAPTOP-7PBQ2CA8\\SQLEXPRESS",
                            "Proj.Mag", "Proj.Mag");
            // tem que implementar a pasta core
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0);
        }

        COMANDO = comando;
    }
}