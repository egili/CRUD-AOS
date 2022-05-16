package DAOs;

import DBOs.Cidadao;
import bd.BDSQLServer;
import bd.core.MeuResultSet;
import java.sql.SQLException;

public class Read {

    public static Cidadao read(int cpf) throws Exception{

        Cidadao cidadao = null;

        try {
            String sql;

            sql = "SELECT * " +
                    "FROM cidadao" +
                    "WHERE cid_cpf = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, cpf);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            if(!resultado.first())
                throw new Exception("sem dados correspondemtes ao parametro informado");

            cidadao = New Cidadao(); // FIXME: dados do Cidadao
        } catch (SQLException erro){
            throw new Exception("erro ao procurar o cidadao");
        } finally {
            return cidadao;
        }
    }

    public static MeuResultSet readAll() throws Exception{

        MeuResultSet ret = null;

        try{
            String sql;

            sql = "SELECT * " + "FROM cidadao";

            BDSQLServer.COMANDO.prepareStatement(sql);

            ret = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
        } catch(SQLException err){
            throw new Exception("erro ao ler os dados dos cidadaos");
        }
        return ret;

    }
}
