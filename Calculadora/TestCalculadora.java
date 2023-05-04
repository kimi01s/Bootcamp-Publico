public class TestCalculadora {
    public static void main(String[] args) {
        Calculadora sumar = new Calculadora();
        sumar.setOperandOne(10.5);
        sumar.setOperation('+');
        sumar.setOperandOTwo(5.2);
        sumar.perfomOperation();
        System.out.println(sumar.getResult());
    }
}