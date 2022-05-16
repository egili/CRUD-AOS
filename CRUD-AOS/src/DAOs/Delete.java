package DAOs;

import bd.BDSQLServer;
import java.sql.SQLException;

public class Delete {

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
