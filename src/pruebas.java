

public class pruebas {

    public static void main(String[] args) {
        //String prubas = "(- 30 (+(* 5 4) 2)";
        //String prubas = "(+ (- 5 4) 2)";
        //String prubas = "(SETQ X 5) (X)";
        String prubas = "(DEFUN CUADRADO (N) (* N N)) (PRINT (CUADRADO 5))";
        Interprete decode = new Interprete(prubas);
        decode.interpret();
    }

}


