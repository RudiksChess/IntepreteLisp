import static java.lang.Double.parseDouble;
import static java.lang.String.*;

public class Condiciones {
    public String nombres(Stack<String> stackito){

        String valor = "";

        String pop = stackito.pop();

        switch (pop) {
            case "ATOM":
                try {
                    valor = valueOf(parseDouble(stackito.pop()));
                } catch (Exception e) {
                    valor = " ";
                }
                break;
            case "WRITE":
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
            case "EQUAL":
                valor = valueOf(nombres(stackito).equals((nombres(stackito))));
                break;

            case "COND":
                if (nombres(stackito).equals("true")) {
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
