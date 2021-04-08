import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Tokenizador {

    public String[] Tokensbebe (String input){
        String condiciones = "\\s(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)|(?<=\\()|(?=\\))|(?<=\\))|(?=\\()";
        String[] separado = input.split(condiciones);
        return Arrays.stream(separado).map(String::trim).filter(Predicate.isEqual("").negate()).toArray(String[]::new);
    }

    public String[] Tokenpapa(String[] stringseparados, HashMap<String,String> diccionario_general, HashMap<String, Stack<String>> funciones_definidas){
        AtomicInteger pares_parentesis = new AtomicInteger();
        Istack<String> funciones = new Istack<>();

        int i=0;
        while (i<stringseparados.length) {
            String token = stringseparados[i];
            if("DEFUN".equals(token)) pares_parentesis.set(1);
            if(0 < pares_parentesis.get()){
                if("(".equals(token)) pares_parentesis.getAndIncrement();
                else if(")".equals(token)) pares_parentesis.getAndDecrement();
                else funciones.push(token);
                stringseparados[i] = "null";
            }
            i++;
        }

        StringBuilder string_nulo = new StringBuilder("null");
        for (String s : stringseparados) string_nulo.append(s).append(" ");
        string_nulo = new StringBuilder(string_nulo.toString().replaceAll("null", ""));

        try {
            funciones.shift();
            String funcionombre = funciones.shift();

            String parametro = funciones.shift();

            diccionario_general.put(funcionombre+"def", "0");

            Istack<String> FuncionFinal = new Istack<>();
            if (funciones.size() > 0) {
                String token = funciones.pop();
                if (token.equals(parametro)) FuncionFinal.push(funcionombre + "def");
                else FuncionFinal.push(token);
                while (funciones.size() > 0) {
                    token = funciones.pop();
                    if (token.equals(parametro)) FuncionFinal.push(funcionombre + "def");
                    else FuncionFinal.push(token);
                }
            }
            funciones_definidas.put(funcionombre, FuncionFinal);
        } catch (Exception ignored) {}

        return string_nulo.toString().replace("( ","").replace(" )","").split(" ");
    }

    public String[] stringtokenizado(String tokenbebe, HashMap<String,String> comandos, HashMap<String, Stack<String>> funciones){
        String[] primertoken = Tokensbebe(tokenbebe);
        return Tokenpapa(primertoken,comandos,funciones);
    }

}