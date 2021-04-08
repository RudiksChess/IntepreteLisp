
import java.util.ArrayList;

public class Istack<E> implements Stack<E>{

	protected ArrayList<E> data;


	public Istack(){
		data = new ArrayList<>();
	}
	public E shift(){
		E value = data.get(0);
		data.remove(0);
		return value;
	}

	@Override
	public void push(E item){
		data.add(item);
	}


	@Override
	public E pop(){
		return data.remove(size()-1);
	}


	@Override
	public int size(){
		return data.size();
	}


    @Override
	public boolean empty(){
        return !(data.size() > 0);
    }

    public String toString(){
        return data.toString();
    }

}
