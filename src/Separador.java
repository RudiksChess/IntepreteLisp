import java.util.*;
import java.util.function.Predicate;

public class Separador {
    public List<String> tokens (String input){
        String condiciones = "\\s(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)|(?<=\\()|(?=\\))|(?<=\\))|(?=\\()";
        String[] separado = input.split(condiciones);
        String[] token = Arrays.stream(separado).map(String::trim).filter(Predicate.isEqual("").negate()).toArray(String[]::new);
        List<String> tokens = new ArrayList<String>();
        Collections.addAll(tokens, token);
        return tokens;
    }


}