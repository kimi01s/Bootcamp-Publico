public class Wizzard extends Human{

	public Wizzard() {
		health = 50;
		intelligence = 8;
	}
	public void heal(Human humano) {
		humano.health += this.intelligence;
	}
	public void fireball(Human humano) {
		humano.health -= this.intelligence*3;
	}
}