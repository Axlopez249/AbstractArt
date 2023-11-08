package pintores;

import java.util.ArrayList;

import pintoresInterface.IObserver;
import pintoresInterface.IPintorProduct;

public class SujetoObserver implements IObserver{
	private ArrayList<IPintorProduct> pintores;

	public SujetoObserver(ArrayList<IPintorProduct> pintores) {
		this.pintores = pintores;
		actualizar();
	}
	@Override
	public void actualizar() {
		//Comienzo a actualizar y definir aquel que será el siguiente que tiene el turno
		
	}

}
