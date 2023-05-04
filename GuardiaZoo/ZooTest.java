public class ZooTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorila gorila1 = new Gorila(100);
		gorila1.throwSomething();
		gorila1.throwSomething();
		gorila1.throwSomething();
		gorila1.eatBananas();
		gorila1.eatBananas();
		gorila1.climb();
		gorila1.displayEnergy();
		System.out.println("\n");
		Bat bat1 = new Bat(300);
		bat1.attackTown();
		bat1.attackTown();
		bat1.attackTown();
		bat1.eatHumans();
		bat1.eatHumans();
		bat1.fly();
		bat1.fly();
		bat1.displayEnergy();
	}

}
