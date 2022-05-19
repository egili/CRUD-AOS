package bd;
import bd.core.*;
//import DAOs.* Não consigo fazer o import
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
                            "jdbc:sqlserver://192.168.15.26:1433;databasename=BancoAna",
                            "Proj.Mag", "Proj.Mag");
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0);
        }

        COMANDO = comando;
    }
}
