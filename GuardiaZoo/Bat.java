public class Bat extends Mammal{

	public Bat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bat(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub
	}
	public void fly() {
		System.out.println("sonido de murcielago volando");
		super.setEnergyLevel(getEnergyLevel()-50);
	}
	public void eatHumans() {
		System.out.println("bueno, no importa");
		super.setEnergyLevel(getEnergyLevel()+25);
	}
	public void attackTown() {
		System.out.println("sonido de ciudad en llamas");
		super.setEnergyLevel(getEnergyLevel()-100);
	}
	@Override
	public int displayEnergy() {
		System.out.println("el nivel de energia del murcielago es: " + getEnergyLevel());
		return getEnergyLevel();
	}
	
}
