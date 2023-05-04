public class Human {
	protected int strength = 3;
	protected int intelligence = 3;
	protected int stealth = 3;
	protected int health = 100;
	static int id = 0;
	
	public void attack(Human humano) {
		humano.health -= this.strength;
	}
	public void displayHealth() {
		System.out.println("la salud del humano es: " + this.health);
	}
}