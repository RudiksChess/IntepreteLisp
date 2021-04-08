import static java.lang.Double.parseDouble;

public class Condiciones {
    public String nombres(Stack<String> a){

        String val = "";

        String pop = a.pop();

        switch (pop) {
            case "ATOM":
                try {
                    val = String.valueOf(parseDouble(a.pop()));
                } catch (Exception e) {
                    val = " ";
                }
                break;
            case "WRITE":
                System.out.println(nombres(a));
                break;
            case "SETQ":
                Interprete.diccionario.put(a.pop(), nombres(a));
                break;

            case "-":
                val = String.valueOf(parseDouble(nombres(a)) - parseDouble(nombres(a)));
                break;
            case "+":
                val = String.valueOf(parseDouble(nombres(a)) + parseDouble(nombres(a)));
                break;
            case "/":
                try {
                    val = String.valueOf(parseDouble(nombres(a)) / parseDouble(nombres(a)));
                } catch (Exception e) {
                    System.out.println("Indefinido como tu genero xd - " + e.getMessage());
                    return "0";
                }

                break;
            case "*":
                val = String.valueOf(parseDouble(nombres(a)) * parseDouble(nombres(a)));
                break;
            case "<":
                val = String.valueOf(parseDouble(nombres(a)) < parseDouble(nombres(a)));
                break;
            case ">":
                val = String.valueOf(parseDouble(nombres(a)) > parseDouble(nombres(a)));
                break;
            case "EQUAL":
                val = String.valueOf(nombres(a).equals((nombres(a))));
                break;

            case "COND":
                if (nombres(a).equals("true")) {
                    val = nombres(a);
                } else {
                    val = "";
                }
                break;
            default:
                if (Interprete.diccionario.containsKey(pop)) {
                    val = Interprete.diccionario.get(pop);
                } else if (Interprete.funciones.containsKey(pop)) {
                    Interprete.diccionario.put(pop + "def", nombres(a));
                    val = nombres(Interprete.funciones.get(pop));
                } else {
                    val = pop;
                }
                break;
        }
        Interprete.stack = a;
        return val;
    }
    
}
