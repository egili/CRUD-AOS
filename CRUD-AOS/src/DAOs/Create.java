package DAOs;

import DBOs.Cidadao;
import bd.BDSQLServer;

public class Create {

    public static void create(Cidadao cidadao) throws Exception{

        if(cidadao == null)
            throw new Exception("cidadao nao foranecido");

        try{
            String sql;
            sql = "INSERT INTO cidadao" +
                    "(cid_cpf, cid_nome, cid_sobrenome, cid_telefone, cid_genero, cid_cep)" +
                    "VALUES" +
                    "(?,?,?,?,?)";
        } catch (Exception erro){
            BDSQLServer.COMANDO.rollback();
            throw new Exception("erro ao cadastrar o cidadao");
        }
    }
}
