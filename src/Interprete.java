import java.util.HashMap;
public class Interprete {

    public static String lisp;
    public static Stack<String> stack;
    public static HashMap<String,String> diccionario;
    public static HashMap<String, Stack<String>> funciones;


    public Interprete(String input){
        lisp = input;
        diccionario = new HashMap<>();
        diccionario.put("T", "True");
        funciones = new HashMap<>();
        stack = tokenize();
    }


    public void interpret(){
        Condiciones execute = new Condiciones();
        while (!stack.empty()) System.out.println(execute.nombres(stack));
    }


    public Stack<String> tokenize(){
        String[] initialCode;
        Tokenizador tokenis = new Tokenizador();
        initialCode = tokenis.stringtokenizado(lisp, diccionario, funciones);
        Stack<String> tokenized = new Istack<>();
        int i=initialCode.length-1;
        while (i>=0) {
            tokenized.push(initialCode[i]);
            i--;
        }
        return tokenized;
    }


}