public class StringManipulator {
    public String trimAndConcat(String primerString, String segundoString){
        String nuevoString = primerString.trim() + segundoString.trim();
        return nuevoString;
    }
    public int getIndexOrNull(String texto, char textoABuscar){
        int i = texto.indexOf(textoABuscar);
        return i;
    }
    public int getIndexOrNull(String texto, String textoABuscar){
        int i = texto.indexOf(textoABuscar);
        return i;
    }
    public String concatSubstring(String firstString, int firstNumber, int secondNumber, String secondString){

        String primeraPalabra = firstString.substring(firstNumber, secondNumber);
        String palabraFinal = primeraPalabra.concat(secondString);
        return palabraFinal;
    }
}
