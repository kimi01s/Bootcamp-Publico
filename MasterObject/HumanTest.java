public class HumanTest {

	public static void main(String[] args) {
        
		Human persona1 = new Human();
		Human persona2 = new Human();
		persona1.attack(persona2);
		persona2.displayHealth();
		System.out.println("\n");
		
		Wizzard mago1 = new Wizzard();
		mago1.heal(persona1);
		persona1.displayHealth();
		
		System.out.println("\n");
		
		mago1.fireball(persona1);
		persona1.displayHealth();
		
		System.out.println("\n");
		
		Ninja ninja1 = new Ninja();
		ninja1.steal(persona2);
		persona2.displayHealth();
		
		System.out.println("\n");
		
		ninja1.displayHealth();
		ninja1.runAway();
		ninja1.displayHealth();
		
		System.out.println("\n");
		
		Samurai samurai1 = new Samurai();
		samurai1.deadBlow(persona1);
		persona1.displayHealth();
		
		samurai1.meditate();
		samurai1.displayHealth();
		samurai1.howMany();
		System.out.println("\n");
		
		Samurai samu2 = new Samurai();
		samu2.displayHealth();
		samu2.howMany();
		
		Samurai samurai3 = new Samurai();
		samurai3.howMany();
	}

}