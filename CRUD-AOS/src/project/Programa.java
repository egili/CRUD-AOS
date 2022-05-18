package project;

import DAOs.CRUDHelper;
import bd.BDSQLServer;
import bd.core.MeuResultSet;
import project.helpers.Teclado;

public class Programa {
    public static void main(String[] args) {

        char opcao = 0;
        String cpf;
        String nome;
        String telefone;
        String cep;
        String numero;
        String complemento;

        System.out.println("CRUD AOS - Java + SQL Server \n");

        System.out.println("qual operacao deseja realizar? \n");
        System.out.println("digite [C] para cadastrar alguns dados\n");
        System.out.println("digite [R] para ler os dados cadastrados\n");
        System.out.println("digite [U] para atualizar os dados\n");
        System.out.println("digite [D] para deletar algum dado\n");

        try{
            opcao = Teclado.getUmChar();
        } catch (Exception e) {}

        if(Character.toUpperCase(opcao) == 'C'){
            try{
                System.out.println("digite o CPF do cidadão: " );
                cpf = Teclado.getUmString();

                System.out.println("digite o nome do cidadão: ");
                nome = Teclado.getUmString();

                System.out.println("digite o telefone do cidadão: ");
                telefone = Teclado.getUmString();

                System.out.println("digite o CEP do cidadão: ");
                cep = Teclado.getUmString();

                System.out.println("digite o número da casa do cidadão: ");
                numero = Teclado.getUmString();

                System.out.println("digite o complemento do cidadão: ");
                complemento = Teclado.getUmString();

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (Character.toUpperCase(opcao) == 'R') {
            try {
                System.out.println("Deseja fazer uma consulta nos dados cadastrados? [S] Sim ou [N] Não: ");

                if (Character.toUpperCase(opcao) == 'S') {
                    System.out.println("Lista dos dados cadastrados: ");
                    cpf = Teclado.getUmString();
                    nome = Teclado.getUmString();
                    telefone = Teclado.getUmString();
                    cep = Teclado.getUmString();
                    numero = Teclado.getUmString();
                    complemento = Teclado.getUmString();
                    System.out.println(cpf);
                    System.out.println(nome);
                    System.out.println(telefone);
                    System.out.println(cep);
                    System.out.println(numero);
                    System.out.println(complemento);
                /* Aqui é apenas um esboço dos dados que serão retornados,
                 já que é necessário retirar esses
                  dados do banco de dados */
                }

                else{
                    System.out.println("Digite o CPF do cidadão que deseja consultar: ");


                    /* Aqui vai retornar os dados apenas do cidadao que foi
                    digitado o cpf

                 MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
                 resultado.getString("cid_nome"),
                 resultado.getInt(CRUDHelper.getDDDdoCidadao("cid_telefone")),
                 resultado.getLong(CRUDHelper.getNumerodoCidadao("cid_telefone")),
                 resultado.getString(CRUDHelper.getGeneroAsCharSize("cid_genero")),
                 resultado.getInt("cid_cep"));
                    */

                }
            }catch (Exception e){
             e.printStackTrace();
            }

        } else if (Character.toUpperCase(opcao) == 'U') {
            try {
                System.out.println("Digite o CPF do cidadão que deseja atualizar os dados: ");

                /* Aqui vai mostrar os dados do cidadão escolhido */

                System.out.println("Qual informação deseja alterar?: ");

                /* Vai escolher a informação */
                cpf = Teclado.getUmString();
                nome = Teclado.getUmString();
                telefone = Teclado.getUmString();
                cep = Teclado.getUmString();
                numero = Teclado.getUmString();
                complemento = Teclado.getUmString();

                System.out.println("Digite a nova informação: ");

            /* Vai ser feita a alteração da informação
             e depois basta fazer a consulta para verificar a alteração */

            }catch (Exception e){
             e.printStackTrace();
            }

        } else if (Character.toUpperCase(opcao) == 'D') {

                System.out.println("Digite o CPF do cidadão que deseja deletar os dados: ");
                cpf = Teclado.getUmString();

                System.out.println("Selecione o dado que deseja deletar: ");
                cpf = Teclado.getUmString();
                nome = Teclado.getUmString();
                telefone = Teclado.getUmString();
                cep = Teclado.getUmString();
                numero = Teclado.getUmString();
                complemento = Teclado.getUmString();

                /* Vai ser feita a exclusão do dado selecionado */

        } else {

        }
    }
}
