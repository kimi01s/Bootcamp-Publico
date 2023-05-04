public class Samurai extends Human{
	public Samurai() {
		health = 200;
		id++;
	}
	public void deadBlow(Human humano) {
		humano.health = 0;
		System.out.println("el humano ha muerto");
		this.health -= this.health/2;
	}
	public void meditate() {
		this.health += this.health/2;
	}
	public void howMany() {
		System.out.println("el id del samurai es: "+Samurai.id);
	}
	
	public void displayHealth() {
		System.out.println("la salud del samurai es: " + this.health);
	}
	
}
