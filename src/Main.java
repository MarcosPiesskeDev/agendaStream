
import util.Functions;

public class Main {

    public static void main(String args[]) {
        Functions f = new Functions();

        System.out.println("Bem vindo à minha agenda de contatos! :D");
        try {
            f.initWindow();
        }catch (Exception e){
         System.out.println("Erro na main: " +e);
        }
    }
}
