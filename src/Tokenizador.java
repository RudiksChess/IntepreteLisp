import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * File: Tokenizador.java
 *
 * Esta es una clase que tiene la funcionalidad de tokenizar los Strings ingresados en el programa.
 * @author Rudik Roberto Rompich
 * @since 8-04-2021
 * @version 1.0
 *
 */
public class Tokenizador {

    /**
     * @author Rudik Roberto Rompich
     * @since 8-04-2021
     * @version 1.0
     * @param input el string de lisp a secas.
     * @return un array string bonito sin espacios ni nada, ordenados en un array.
     */
    public String[] Tokensbebe (String input){
        String condiciones = "\\s(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)|(?<=\\()|(?=\\))|(?<=\\))|(?=\\()";
        String[] separado = input.split(condiciones);
        return Arrays.stream(separado).map(String::trim).filter(Predicate.isEqual("").negate()).toArray(String[]::new);
    }

    /**
     * @author Rudik Roberto Rompich, Github: wsaldana.
     * @since 8-04-2021
     * @version 1.0
     * @param stringseparados el string que recibe de Tokensbebe.
     * @param diccionario_general un hashmap para almacer los términos conocidos.
     * @param funciones_definidas un hashmapa para almacer lost términos asignados por el usuario.
     * @return un string con los espacios correspondientes para que los analice Condiciones.java
     */
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
            if (0 < funciones.size()) {
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
        String nulidad = string_nulo.toString();

        return nulidad.replace("( ","").replace(" )","").split(" ");
    }

    /**
     * @author Rudik Roberto Rompich
     * @since 8-04-2021
     * @version 1.0
     * @param tokenbebe un string en lisp si nada desarrollado
     * @param comandos el hashmap de las definiciones
     * @param funciones el hashmap de las definiciones hechas por el usuario.
     * @return un string con los espacios correspondientes para que los analice Condiciones.java
     */
    public String[] stringtokenizado(String tokenbebe, HashMap<String,String> comandos, HashMap<String, Stack<String>> funciones){
        String[] primertoken = Tokensbebe(tokenbebe);
        return Tokenpapa(primertoken,comandos,funciones);
    }

}