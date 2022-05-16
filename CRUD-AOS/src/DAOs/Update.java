package DAOs;

import DBOs.Cidadao;
import bd.BDSQLServer;
import java.sql.SQLException;

public class Update {

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
}
