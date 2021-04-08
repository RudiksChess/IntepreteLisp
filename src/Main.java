
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        while(true){
            System.out.println("-------- PROGRAMA INICIADO  ------");
            System.out.println(">>>");
            String name = entrada.nextLine();
            Interprete ElonMusk = new Interprete(name);
            System.out.println(">>>");
            ElonMusk.interpret();
        }
    }
}