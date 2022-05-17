package project;

import project.helpers.Teclado;

public class Programa {
    public static void main(String[] args) {

        char opcao = 0;
        String cpf;
        String nome;
        String telefone;

        System.out.println("CRUD AOS - Java + SQL Server");

        System.out.println("qual operacao deseja realizar?");
        System.out.println("digite [C] para cadastrar alguma dados\n");
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
                System.out.println(cpf);

                System.out.println("digite o nome do cidadao: ");
                nome = Teclado.getUmString();

                System.out.println("digite o telefone do cidadao: ");
                telefone = Teclado.();
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (Character.toUpperCase(opcao) == 'R') {

        } else if (Character.toUpperCase(opcao) == 'U') {

        } else if (Character.toUpperCase(opcao) == 'D') {

        } else {

        }
    }
}
