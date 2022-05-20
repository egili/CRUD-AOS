package bd;

import bd.core.*;

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
                            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
                            "jdbc:sqlserver://127.0.0.1:1433;databasename=cidadaoBD",
                            "Proj.Mag", "Proj.Mag");
            System.out.println("FUNCIONOU!!");
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0);
        }

        COMANDO = comando;
    }
}
