import java.util.ArrayList;
import java.util.Random;

public class TestRompeCabezas {
    
    public static void main(String[] args){
        
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(3);
        numeros.add(5);
        numeros.add(1);
        numeros.add(2);
        numeros.add(7);
        numeros.add(8);
        numeros.add(9);
        numeros.add(31);
        numeros.add(25);

        System.out.println(numeros + " que tienes esto");
        
        // Random r = new Random();
        // System.out.println(r.nextInt());  Sin límites
        // System.out.println(r.nextInt(5)); // Con límites entre 0 y 5

        // Instanicia de Rompecabezas
        RompeCabezas rompeCabezas = new RompeCabezas();
        
        ArrayList<Integer> numerosMayores = rompeCabezas.sumaTodos(numeros);
        System.out.println("Los numeros mayores del arreglo son: "+numerosMayores);
    }
}