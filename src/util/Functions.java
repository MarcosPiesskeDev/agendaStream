package util;

import model.Contact;

import java.beans.ExceptionListener;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Functions {
    List<Contact> contacts = new ArrayList<>();

    public void initWindow(){

        System.out.println("Insira os números: \n 1 - Para registrar um novo contato; \n 2 - Para remover um contato; \n 3 - Para mostrar a lista de contatos; \n 4 - Para listar os contatos pela letra inicial. \n");

        try {
            Scanner sc = new Scanner(System.in);
            int tipoAgenda = sc.nextInt();

            switch (tipoAgenda){
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    getContacts();
                case 4:
                    searchContact();
                default:
                    System.out.println("Insira um valor de 1 a 4");
                    System.out.println();
                    initWindow();
            }

        }catch (InputMismatchException eI){
            System.out.println("Insira um valor numérico e tente novamente;");
            System.out.println();
            initWindow();
        }
    }

    public void backInitp(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Deseja voltar à página inicial? [y/n]");
            String answerIn = sc.next();
            switch (answerIn.toLowerCase()){
                case "yes":
                case "y":
                    initWindow();
                    break;
                case "no":
                case "n":
                    sc.close();
                    break;
                default:
                    System.out.println("Escreva 'yes' ou 'no' ");
                    backInitp();
            }
        }catch (NoSuchElementException ns){
            System.out.println("Finalizado!");
        }
    }

    public void addContact() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Informe quantos contatos desejas registrar: ");
            int nContatos = sc.nextInt();
            for (int i = 1; i <= nContatos; i++) {
                WindowU limpaTela = new WindowU();
                System.out.print("Insira o nome do seu " + i + "º" + " contato : ");
                String nome = sc.next();
                System.out.print("Insira o sobrenome do seu " + i + "º" + " contato : ");
                String sobreNome = sc.next();
                System.out.print("Insira o e-mail do seu " + i + "º" + " contato : ");
                String email = sc.next();
                System.out.print("Insira o telefone do seu " + i + "º" + " contato : ");
                Long nTelefone = sc.nextLong();
                contacts.add(new Contact(nome, sobreNome, email, nTelefone));
                limpaTela.clearConsole();
            }
            System.out.println("Contatos adicionados com sucesso!");
            backInitp();
        } catch (InputMismatchException e) {
            System.out.println("Você deve inserir um valor numérico, tente novamente; ");
            System.out.println();
            addContact();
        }
    }

    public void removeContact() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Escreva o 'id' do contato que deseja remover da sua lista");
            int removeId = sc.nextInt();
            contacts.remove(removeId);
            System.out.println("Contato removido com sucesso!");
            backInitp();
        } catch (IndexOutOfBoundsException indexE) {
             System.out.println("Não existe um contato com este 'id', por favor tente novamente, ou adicione um novo contato [t/b]: \n Selecione 't' - Tentar novamente; \n Selecione 'b' - Voltar para o menu inicial.");
             String choseBack = sc.next();
             switch (choseBack.toLowerCase()){
                 case "t":
                     removeContact();
                     break;
                 case "b":
                     initWindow();
                     break;
                 default:
                     System.out.print("Escreva 't' ou 'b' e tente novamente: ");
             }
             backInitp();
        }catch (Exception e){
            System.out.println("Erro ao remover o contato: "+e);
        }
    }

    public void getContacts(){
      for(Contact contact : contacts){
          System.out.println("----------------------------------------------------------------------------------------------------------");
          System.out.println(
                  "| id: "+String.format("%-4s", contacts.indexOf(contact))+
                          "| Nome: "+String.format("%-10s", contact.getFirstName())+
                          " | Sobrenome: "+String.format("%-10s", contact.getLastName())+
                          " | E-mail: "+String.format("%-14s", contact.getEmail())+
                          " | Telefone: "+String.format("%-14s", contact.getTelefone())+" |");
          System.out.println("----------------------------------------------------------------------------------------------------------");
      }
        backInitp();
    }

    public void searchContact() {
        System.out.print("Insira a inicial dos contatos que deseja procurar, ou podes escrever o nome: ");
        try {
            Scanner sc = new Scanner(System.in);

            String contactName = sc.next();
            Boolean nameExists = contacts.stream().anyMatch((contact) ->
                    contact.getFirstName().toLowerCase().contains(contactName) || contact.getFirstName().toUpperCase().contains(contactName));

            if (nameExists) {
                for (Contact contact : contacts) {
                    if (contact.getFirstName().toLowerCase().contains(contactName) || contact.getFirstName().toUpperCase().contains(contactName)) {
                        System.out.println("----------------------------------------------------------------------------------------------------------");
                        System.out.println(
                                "| id: " + String.format("%-4s", contacts.indexOf(contact)) +
                                        "| Nome: " + String.format("%-10s", contact.getFirstName()) +
                                        " | Sobrenome: " + String.format("%-10s", contact.getLastName()) +
                                        " | E-mail: " + String.format("%-14s", contact.getEmail()) +
                                        " | Telefone: " + String.format("%-14s", contact.getTelefone()) + " |");
                        System.out.println("----------------------------------------------------------------------------------------------------------");
                    }
                }
            } else {
                System.out.println("Não temos um " + contactName);
            }
            backInitp();
        }catch (Exception e){
            System.out.println("Erro ao apresentar o nome: "+e);
        }
    }
}
