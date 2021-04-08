import static java.lang.Double.parseDouble;
import static java.lang.String.*;

/**
 * File: Condiciones.java
 *
 * Esta es una clase que tiene las instrucciones de las funciones aritmeticas y primitivas. Ademas, se comunica con la clase de Interprete.java para ejecutar
 * los comandos necesarios. Es la clase de mayor utilidad, ya que puede ser modificada para almacer mas funciones del interprete.
 * @author Rudik Roberto Rompich
 * @since 8-04-2021
 * @version 1.0
 *
 */
public class Condiciones {
    /**
     * @author Rudik Roberto Rompich, Github: wsaldana.
     * @since 8-04-2021
     * @version 1.0
     * @param stackito es un String stack basado en la implementacion de de Istack.java, el parametro ya es un stack sin parentesis y ordenado.
     * @return un String con el resultado luego de evaluar todas las operaciones.
     */
    public String nombres(Stack<String> stackito){

        String valor = "";

        String pop = stackito.pop();

        switch (pop) {
            case "QUOTE":
            case "ATOM":
                try {
                    valor = valueOf(parseDouble(stackito.pop()));
                } catch (Exception e) {
                    valor = " ";
                }
                break;
            case "WRITE":
            case "PRINT":
                System.out.println(nombres(stackito));
                break;
            case "SETQ":
                Interprete.diccionario.put(stackito.pop(), nombres(stackito));
                break;

            case "-":
                valor = valueOf(parseDouble(nombres(stackito)) - parseDouble(nombres(stackito)));
                break;
            case "+":
                valor = valueOf(parseDouble(nombres(stackito)) + parseDouble(nombres(stackito)));
                break;
            case "/":
                try {
                    valor = valueOf(parseDouble(nombres(stackito)) / parseDouble(nombres(stackito)));
                } catch (Exception e) {
                    System.out.println("Indefinido como tu genero xd - " + e.getMessage());
                    return "0";
                }

                break;
            case "*":
                valor = valueOf(parseDouble(nombres(stackito)) * parseDouble(nombres(stackito)));
                break;
            case "<":
                valor = valueOf(parseDouble(nombres(stackito)) < parseDouble(nombres(stackito)));
                break;
            case ">":
                valor = valueOf(parseDouble(nombres(stackito)) > parseDouble(nombres(stackito)));
                break;
            case "EQ":
            case "=":
            case "EQUAL":
                valor = valueOf(nombres(stackito).equals((nombres(stackito))));
                break;

            case "COND":
                if (nombres(stackito).equals("True")) {
                    valor = nombres(stackito);
                } else {
                    valor = "";
                }
                break;
            default:
                if (Interprete.diccionario.containsKey(pop)) {
                    valor = Interprete.diccionario.get(pop);
                } else if (Interprete.funciones.containsKey(pop)) {
                    Interprete.diccionario.put(pop + "def", nombres(stackito));
                    valor = nombres(Interprete.funciones.get(pop));
                } else {
                    valor = pop;
                }
                break;
        }
        Interprete.stack = stackito;
        return valor;
    }
    
}
