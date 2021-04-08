import java.util.HashMap;

/**
 *  File: Interprete.java
 *
 * Es el interprete como tal, junta las demas clases para hacer que funcione el programa.
 * @author Rudik Roberto Rompich
 * @since 8-04-2021
 * @version 1.0

 */
public class Interprete {

    public static String lisp;
    public static Stack<String> stack;
    public static HashMap<String, Stack<String>> funciones;
    public static HashMap<String,String> diccionario;

    /**
     * @param input El string de lisp
     */
    public Interprete(String input){
        lisp = input;
        diccionario = new HashMap<>();
        diccionario.put("T", "True");
        funciones = new HashMap<>();
        stack = tokenizadorfinal();
    }


    /**
     * Lo que imprime los comandos y resultados.
     */
    public void interpret(){
        Condiciones ejecutar = new Condiciones();
        while (!stack.empty()) System.out.println(ejecutar.nombres(stack));
    }


    /**
     * @return Un stack tokenizado.
     */
    public Stack<String> tokenizadorfinal(){
        String[] comando_lisp;
        Tokenizador tokenis = new Tokenizador();
        comando_lisp = tokenis.stringtokenizado(lisp, diccionario, funciones);
        Stack<String> tokenizado = new Istack<>();
        int i=comando_lisp.length-1;
        while (i>=0) {
            tokenizado.push(comando_lisp[i]);
            i--;
        }
        return tokenizado;
    }


}