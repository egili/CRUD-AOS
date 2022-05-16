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

    public static Integer getDDDdoCidadao(String telefone){

        String operacao;
        Integer ret = null;

        try{
            operacao = telefone.substring(0,2);
           ret = Integer.valueOf(operacao);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    public static Integer getNumerodoCidadao(String telefone){

        String operacao;
        Integer ret = null;

        try{
            operacao = telefone.substring(2,11);
            ret = Integer.valueOf(operacao);
        }catch(Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    public static String getGeneroAsCharSize(String genero){

        String ret = null;

        try{
            ret = genero.substring(0,1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }
}
