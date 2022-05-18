package DAOs;

public class CRUDHelper { // essa classe nao foi utilizada na versao final do projeto

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
