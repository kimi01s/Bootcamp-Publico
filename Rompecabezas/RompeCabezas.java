import java.util.ArrayList;

public class RompeCabezas {

    public ArrayList<Integer> sumaTodos(ArrayList<Integer> elementos){
        // System.out.println(elementos +  " nos llega el arreglo ");
        int suma = 0;
        ArrayList<Integer> numerosMayores =  new ArrayList<Integer>();
        // for (int i = 0; i<elementos.size(); i++){
        //     suma = suma + elementos.get(i);   
        // }
        for( int i : elementos){
            System.out.println(i);
            // suma = suma + elementos.get(i);  // QUES ES i en este tipo iterador'
            suma += i;
            if( i > 10 ){
                numerosMayores.add(i);
            }
        }

        System.out.println("La suma total del arreglo es: " + suma);

        return numerosMayores;

    }

    
}