public class Gorila extends Mammal {
	
	//CONSTRUCTOR
	public Gorila() {
		super();
	}
	public Gorila(int energyLevel) {
		super(energyLevel);
	}
	
	//METODOS
	public void throwSomething() {
		System.out.println("Gorila lanza barril");
//		displayEnergy();
		super.setEnergyLevel(getEnergyLevel()-5);
	}

	public void eatBananas() {
		System.out.println("el Gorila come bananas");
		super.setEnergyLevel(getEnergyLevel() + 10);
	}

	public void climb() {
		super.setEnergyLevel(getEnergyLevel()-10);
	}
	@Override
	public int displayEnergy() {
		System.out.println("el nivel de energia del Gorila es: " + getEnergyLevel());
		return getEnergyLevel();
	}
}