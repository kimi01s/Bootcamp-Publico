import java.util.HashMap;
import java.util.ArrayList;
public class HashMatique{
    public static void main(String[] args) {
        HashMap<String, String> canciones = new HashMap<String, String>();
        canciones.put("Katy Perry", "I kissed a girl");
        canciones.put("Jesse y Joy", "chocolate");
        canciones.put("BTS", "Not today");
        canciones.put("Everglow", "LA DI DA");
        canciones.put("MAMAMOO", "Chico malo");
        canciones.put("MAMAMOO+", "GGBB");
        // System.out.println(canciones.get("BTS"));
        
        canciones.forEach((x,v)->{
            System.out.println("key: " + x + " " + "value: " +v );
        });

        //Ejemplo excepciones
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hola Mundo");
        myList.add(48);
        myList.add("Adios Mundo");
        myList.add(true);
        System.out.println(myList);

        for (int i = 0; i < myList.size(); i++) {
            try {
                int convertirDato = (int) myList.get(i);
                System.out.println("si se pudo convertir " + convertirDato);
            } catch (Exception e) {
                System.out.println("no pude convertir el siguiente valor: " + myList.get(i));
            }
        }
    }
}