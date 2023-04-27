public class StringManipulatorTest{
    public static void main(String[] args) {
        StringManipulator manipulador = new StringManipulator();
        System.out.println("----- Prueba trimAndConcat-----");
        System.out.println(manipulador.trimAndConcat("      Hola        ", "        Mundo       "));

        System.out.println("----- Prueba getIndexOrNull-----");
        char letter = 'n';
        int a = manipulador.getIndexOrNull("Coding", letter);
        int b = manipulador.getIndexOrNull("Hola Mundo", letter);
        int c = manipulador.getIndexOrNull("Saludar", letter);
        System.out.println(a); // 4
        System.out.println(b); // 7
        System.out.println(c); // -1

        System.out.println("----- Prueba getIndexOrNull with only Strings-----");
        String word = "Hola";
        String subString = "la";
        String notSubString = "mundo";
        int firstResult = manipulador.getIndexOrNull(word, subString);
        int secondResult = manipulador.getIndexOrNull(word, notSubString);
        System.out.println(firstResult); // 2
        System.out.println(secondResult); // -1

        System.out.println("----- Prueba concatSubstring-----");
        String world = manipulador.concatSubstring("Hola", 1, 3, "mundo");
        System.out.println(world);
    }
}