public class Mammal {
	//si el atributo es privado, se necesita
	//get y set para consumirlos.
	
	//si el atributo es protected entones
	// no se necesita get y set para consumirlo
	// sin embargo la clase debe heredar
	// para poder consumir los atributos.
	private int energyLevel = 100;
	
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	//Constructores
	public Mammal() {
	}

	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	//Métodos
	public int displayEnergy() {
		System.out.println("Su nivel de energia es: " + energyLevel);
		return energyLevel;
	}
}