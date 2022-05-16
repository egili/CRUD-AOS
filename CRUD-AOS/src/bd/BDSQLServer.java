package bd;

import bd.core.*;
import DAOs.*;

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
                            "jdbc:sqlserver://SERVIDOR:1433;databasename=BD",
                            //apagar SERVIDOR e colocar nome da máquina onde roda o gerenciador do BD, no caso localhost ou IP
                            //apagar BD descobrir o nome do meu banco de dados e escrever alii
                            "USUARIO", "SENHA");
            // USUARIO substitui pelo usaurio do banco e SENHA em senha
            // tem que implementar a pasta core
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }

        COMANDO = comando;
    }
}