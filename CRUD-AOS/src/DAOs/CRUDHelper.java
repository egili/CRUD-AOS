package DAOs;

import bd.BDSQLServer;
import bd.core.MeuResultSet;
import java.sql.SQLException;

public class CRUDHelper {

    public static boolean cadastrado(int cpf) throws Exception{

        boolean ret = false;

        try{
            String sql;

            sql = "SELECT * " +
                    "FROM cidadao " +
                    "WHERE cid_cpf = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, cpf);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            ret = resultado.first();
        } catch (SQLException err){
            throw new Exception("erro ao procurar cidadao");
        }
        return ret;
    }
}
