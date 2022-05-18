package project;

import DAOs.Cidadaos;
import DBOs.Cidadao;
import project.helpers.Teclado;

public class Programa {
    public static void main(String[] args) {

        char opcao = 0;
        String cpf , nome, telefone, complemento;
        int cep, numeroCasa;
        Cidadao cidadao = null;

        System.out.println("CRUD AOS - Java + SQL Server \n");

        System.out.println("qual operacao deseja realizar? \n");
        System.out.println("digite [C] para cadastrar dados\n");
        System.out.println("digite [R] para ler dados cadastrados\n");
        System.out.println("digite [U] para atualizar dados\n");
        System.out.println("digite [D] para deletar algum dado\n");

        try{
            opcao = Teclado.getUmChar();
        } catch (Exception e) {}

        if(Character.toUpperCase(opcao) == 'C'){
            try{
                System.out.println("digite o CPF do cidadao: " );
                cpf = Teclado.getUmString();

                System.out.println("digite o nome do cidadao: ");
                nome = Teclado.getUmString();

                System.out.println("digite o telefone do cidadao: ");
                telefone = Teclado.getUmString();

                System.out.println("digite o numeroCasa da casa do cidadao: ");
                numeroCasa = Teclado.getUmInt();

                System.out.println("digite o complemento do cidadao: ");
                complemento = Teclado.getUmString();

                System.out.println("digite o CEP do cidadao: ");
                cep = Teclado.getUmInt();

                Cidadaos.create(new Cidadao(cpf, nome, telefone, numeroCasa, complemento, cep));

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (Character.toUpperCase(opcao) == 'R') {
            try {
                System.out.println("\n Deseja fazer uma consulta nos dados de todos os cidadaos cadastrados? [S] Sim ou [N] Não: ");

                if (Character.toUpperCase(opcao) == 'S') {
                    System.out.println("Lista dos dados cadastrados: ");
                    cpf = Teclado.getUmString();
                    nome = Teclado.getUmString();
                    telefone = Teclado.getUmString();
                    cep = Teclado.getUmInt();
                    numeroCasa = Teclado.getUmInt();
                    complemento = Teclado.getUmString();
                    System.out.println(cpf);
                    System.out.println(nome);
                    System.out.println(telefone);
                    System.out.println(cep);
                    System.out.println(numeroCasa);
                    System.out.println(complemento);
                /* Aqui é apenas um esboço dos dados que serão retornados,
                 já que é necessário retirar esses
                  dados do banco de dados */
                }

                else{
                    System.out.println("Digite o CPF do cidadao que deseja consultar: ");

                    try {
                        cpf = Teclado.getUmString();

                        cidadao = Cidadaos.read(cpf);

                        System.out.println("\n nome do cidadao: " + cidadao.getNome());
                        System.out.println("\n telefone do cidadao: " + cidadao.getTelefone());
                        System.out.println("\n numero da casa do cidadao: " + cidadao.getNumeroCasa());
                        System.out.println("\n complemento da casa do cidadao: " + cidadao.getComplemento());
                        System.out.println("\n numero do CEP do cidadao: " + cidadao.getCEP());

                    }catch (Exception e){
                        e.printStackTrace();
                        e.getMessage();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                e.getMessage();
            }

        } else if (Character.toUpperCase(opcao) == 'U') {
            try {
                System.out.println("Digite o CPF do cidadao que deseja atualizar os dados: ");

                /* Aqui vai mostrar os dados do cidadão escolhido */

                System.out.println("Qual informação deseja alterar?: ");

                /* Vai escolher a informação */
                cpf = Teclado.getUmString();
                nome = Teclado.getUmString();
                telefone = Teclado.getUmString();
                cep = Teclado.getUmString();
                numeroCasa = Teclado.getUmString();
                complemento = Teclado.getUmString();

                System.out.println("Digite a nova informação: ");

            /* Vai ser feita a alteração da informação
             e depois basta fazer a consulta para verificar a alteração */

            }catch (Exception e){
             e.printStackTrace();
            }

        } else if (Character.toUpperCase(opcao) == 'D') {

                System.out.println("Digite o CPF do cidadao que deseja deletar: ");
                cpf = Teclado.getUmString();

                System.out.println("Selecione o dado que deseja deletar: ");
                cpf = Teclado.getUmString();
                nome = Teclado.getUmString();
                telefone = Teclado.getUmString();
                cep = Teclado.getUmString();
                numeroCasa = Teclado.getUmString();
                complemento = Teclado.getUmString();

                /* Vai ser feita a exclusão do dado selecionado */

        } else {
            System.out.println("opcao invalida");
            System.exit(0);
        }
    }
}
