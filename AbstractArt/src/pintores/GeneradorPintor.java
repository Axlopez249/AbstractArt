package pintores;

import pintoresInterface.*;

public class GeneradorPintor implements IGenerador{

	@Override
	public PintorPoligono getPintorPoligono() {
		PintorPoligono pintorPoligono = new PintorPoligono(2);
		return pintorPoligono;
				
	}

	@Override
	public PintorPunto getPintorPunto() {
		PintorPunto pintorPunto = new PintorPunto(4);
		return pintorPunto;
	}

	@Override
	public PintorRaya getPintorRaya() {
		PintorRaya pintorRaya = new PintorRaya(3);
		return pintorRaya;
	}

}
