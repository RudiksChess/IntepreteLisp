
import java.util.ArrayList;
/**
 *  File: Istack.java
 *
 * Es la implemetacion que se utilizara en el stack del programa.
 * @author Rudik Roberto Rompich
 * @since 8-04-2021
 * @version 1.0
 *
 * @param <E> Hace referencia a la forma en la que lo quier definir el usuario
 */
public class Istack<E> implements Stack<E>{

	protected ArrayList<E> data;


	/**
	 * El constructor del Stack
	 */
	public Istack(){
		data = new ArrayList<>();
	}

	/**
	 * @return Quita el primer elemento del ArraList
	 */
	public E shift(){
		E value = data.get(0);
		data.remove(0);
		return value;
	}

	/**
	 * @param item acorde a lo que lo defina el usuario se definira el item. Pero consite simplemente en agregar un elemento.
	 */
	@Override
	public void push(E item){
		data.add(item);
	}


	/**
	 * @return elimina un elemento del stack
	 */
	@Override
	public E pop(){
		return data.remove(size()-1);
	}


	/**
	 * @return tamano del stack
	 */
	@Override
	public int size(){
		return data.size();
	}


	/**
	 * @return verifica si el stack esta vacio
	 */
    @Override
	public boolean empty(){
        return !(data.size() > 0);
    }

	/**
	 * @return convierte el arraylist en texto
	 */
    public String toString(){
        return data.toString();
    }

}
