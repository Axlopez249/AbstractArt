package pintores;

import java.util.ArrayList;
import java.util.Iterator;

import pintoresInterface.IPintorProduct;

public class Iterador implements Iterator{
	private int indice = 0;
	private ArrayList<IPintorProduct> pintores;
	
	public Iterador(ArrayList<IPintorProduct> pintores) {
		this.pintores = pintores;
	}

	@Override
	public boolean hasNext() {
		return indice < pintores.size();
	}

	@Override
	public IPintorProduct next() {
		if (hasNext()) {
			
			IPintorProduct pintor = pintores.get(indice);
			indice++;
			return pintor;
		}else {
			indice = 0;
			return pintores.get(indice);
		}
		
	}
	
	public IPintorProduct last() {
		if (indice == 0) {
			return pintores.get(pintores.size() - 1);
		}else {
			return pintores.get(indice-1);
		}
		
		
	}

}
