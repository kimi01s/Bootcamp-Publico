public class FizzBuzz{
    public static void main(String[] args) {
        FizzBuzzTest fizzTest = new FizzBuzzTest();
        String salida1 = fizzTest.fizzBuzz(2);
        String salida2 = fizzTest.fizzBuzz(3);
        String salida3 = fizzTest.fizzBuzz(5);
        String salida4 = fizzTest.fizzBuzz(15);
        System.out.println(salida1+"|"+salida2+"|"+salida3+"|"+salida4);
    }
}