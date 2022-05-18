package project;

import DAOs.Cidadaos;
import DBOs.Cidadao;
import project.helpers.Teclado;

import java.util.List;

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
        } catch (Exception ignored) {}

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

                List<Cidadao> cidadaoList;

                if (Character.toUpperCase(opcao) == 'S') {

                   cidadaoList = Cidadaos.readAll();

                    System.out.println("Lista dos dados cadastrados: ");

                    for (Cidadao c : cidadaoList) {
                        System.out.println(c.toString());
                    }
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
                System.out.println("Digite os dados que deseja atualizar \n");
                do{
                    System.out.println("digite o cpf do cidadao a atualizar:");
                    cpf = Teclado.getUmString();

                }while(!Cidadaos.cadastrado(cpf));

                System.out.println("digite o nome do cidadao a atualizar: ");
                nome = Teclado.getUmString();

                System.out.println("digite o telefone do cidadao a atualizar: ");
                telefone = Teclado.getUmString();

                System.out.println("digite o numeroCasa da casa do cidadao a atualizar: ");
                numeroCasa = Teclado.getUmInt();

                System.out.println("digite o complemento do cidadao a atualizar: ");
                complemento = Teclado.getUmString();

                System.out.println("digite o CEP do cidadao a atualizar: ");
                cep = Teclado.getUmInt();

                Cidadaos.update(new Cidadao(cpf, nome, telefone, numeroCasa, complemento, cep));


            }catch (Exception e){
             e.printStackTrace();
            }

        } else if (Character.toUpperCase(opcao) == 'D') {

            try {
                do {
                    System.out.println("digite o cpf do cidadao a ser deletado:");
                    cpf = Teclado.getUmString();

                } while (!Cidadaos.cadastrado(cpf));

                Cidadaos.delete(cpf);

            }catch (Exception e){
                e.getMessage();
                e.printStackTrace();
            }
        } else {
            System.out.println("opcao invalida");
            System.exit(0);
        }
    }
}
