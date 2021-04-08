import java.util.HashMap;
public class Interprete {

    public static String lisp;
    public static Stack<String> stack;
    public static HashMap<String, Stack<String>> funciones;
    public static HashMap<String,String> diccionario;

    public Interprete(String input){
        lisp = input;
        diccionario = new HashMap<>();
        diccionario.put("T", "True");
        funciones = new HashMap<>();
        stack = tokenizadorfinal();
    }


    public void interpret(){
        Condiciones ejecutar = new Condiciones();
        while (!stack.empty()) System.out.println(ejecutar.nombres(stack));
    }


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