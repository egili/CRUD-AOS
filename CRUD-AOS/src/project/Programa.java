package project;

import DAOs.Cidadaos;
import DBOs.Cidadao;
import project.helpers.Teclado;
import project.template.ClienteWS;
import project.template.Logradouro;

import java.util.List;

public class Programa {
    public static void main(String[] args) {

        char opcao = 0;
        String cpf , nome, telefone, complemento;
        int cep, numeroCasa;
        Cidadao cidadao = null;

        System.out.println("CRUD AOS - Java + SQL Server");

        System.out.println("Qual operação deseja realizar?\n");
        System.out.println("Digite [C] para cadastrar dados");
        System.out.println("Digite [R] para ler dados cadastrados");
        System.out.println("Digite [U] para atualizar dados");
        System.out.println("Digite [D] para deletar algum dado");

        try{
            opcao = Teclado.getUmChar();
        } catch (Exception ignored) {}

        if(Character.toUpperCase(opcao) == 'C'){
            try{
                System.out.println("Digite o CPF do cidadao: ");
                cpf = Teclado.getUmString();

                System.out.println("Digite o nome do cidadao: ");
                nome = Teclado.getUmString();

                System.out.println("Digite o telefone do cidadao: ");
                telefone = Teclado.getUmString();

                System.out.println("Digite o numero da casa do cidadao: ");
                numeroCasa = Teclado.getUmInt();

                System.out.println("Digite o complemento da casa do cidadao: ");
                complemento = Teclado.getUmString();

                System.out.println("Digite o CEP do cidadao: ");
                cep = Teclado.getUmInt();

                Cidadaos.create(new Cidadao(cpf, nome, telefone, numeroCasa, complemento, cep));

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (Character.toUpperCase(opcao) == 'R') {
            try {
                System.out.println("Deseja fazer uma consulta nos dados de TODOS os cidadaos cadastrados? [S] Sim ou [N] Nao: ");
                opcao = Teclado.getUmChar();

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

                        System.out.println("Nome do cidadao: " + cidadao.getNome());
                        System.out.println("Telefone do cidadao: " + cidadao.getTelefone());
                        System.out.println("Numero da casa do cidadao: " + cidadao.getNumeroCasa());
                        System.out.println("Complemento da casa do cidadao: " + cidadao.getComplemento());
                        System.out.println("Numero do CEP do cidadao: " + cidadao.getCEP());

                        System.out.println("\n Agora os dados do endereco deste cidadao: ");
                        Logradouro logradouro = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", String.valueOf(cidadao.getCEP()));
                        System.out.println(logradouro);

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
                    System.out.println("Digite o cpf do cidadao a atualizar:");
                    cpf = Teclado.getUmString();

                }while(!Cidadaos.cadastrado(cpf));

                System.out.println("Digite o nome do cidadao a atualizar: ");
                nome = Teclado.getUmString();

                System.out.println("Digite o telefone do cidadao a atualizar: ");
                telefone = Teclado.getUmString();

                System.out.println("Digite o numeroCasa da casa do cidadao a atualizar: ");
                numeroCasa = Teclado.getUmInt();

                System.out.println("Digite o complemento do cidadao a atualizar: ");
                complemento = Teclado.getUmString();

                System.out.println("Digite o CEP do cidadao a atualizar: ");
                cep = Teclado.getUmInt();

                Cidadaos.update(new Cidadao(cpf, nome, telefone, numeroCasa, complemento, cep));

            }catch (Exception e){
             e.printStackTrace();
            }

        } else if (Character.toUpperCase(opcao) == 'D') {

            try {
                do {
                    System.out.println("Digite o cpf do cidadao a ser deletado: ");
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