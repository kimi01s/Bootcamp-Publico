public class Ninja extends Human{
	public Ninja() {
		stealth = 10;
	}
	public void steal(Human humano) {
		humano.health -= this.stealth;
		this.health += this.stealth;
	}
	public void runAway() {
		this.health -= 10;
	}
	@Override
	public void displayHealth() {
		System.out.println("la salud del ninja es: " + this.health);
	}
}
