/**
 *  File: Stack.java
 *
 * Es la implemetacion que se utilizara en el stack del programa.
 * @author Rudik Roberto Rompich
 * @since 8-04-2021
 * @version 1.0
 *
 * @param <E> Hace referencia a la forma en la que lo quier definir el usuario
 */
public interface Stack<E>{


    /**
     * @author Rudik Roberto Rompich
     * @since 8-04-2021
     * @param item acorde a lo que lo defina el usuario se definira el item. Pero consite simplemente en agregar un elemento.
     */
    void push(E item);

    /**
     * @author Rudik Roberto Rompich
     * @since 8-04-2021
     * @return se le quita un elemento al stack.
     */
    E pop();


    /**
     * @author Rudik Roberto Rompich
     * @since 8-04-2021
     * @return un elemento booleano si el stack esta vacio.
     */
    boolean empty();

    /**
     * @author Rudik Roberto Rompich
     * @since 8-04-2021
     * @return el tamaño del Stack
     */
    int size();
}