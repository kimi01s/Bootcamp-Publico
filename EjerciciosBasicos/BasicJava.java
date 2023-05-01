import java.util.ArrayList;
import java.util.Collections;

public class BasicJava {
    public void printNumber(){
        for (int i = 1; i <= 255; i++) {
            System.out.println("el numero es: " + i);
        }
    }
    public void printImpares(){
        for (int i = 1; i <= 255; i++) {
            if(i%3==0){ 
                System.out.println("el numero es: " + i);
            }
        }
    }
    public void printSuma(){
        for (int i = 1; i <=255; i++) {
            System.out.println("nuevo numero: " + i +" Suma: "+(i+i-1));
        }
    }
    public void recorrerArreglo(){
        ArrayList<Integer> listaArreglos = new ArrayList<>();
        listaArreglos.add(1);
        listaArreglos.add(3);
        listaArreglos.add(5);
        listaArreglos.add(7);
        listaArreglos.add(9);
        listaArreglos.add(13);

        for (Integer i : listaArreglos) {
            System.out.println(i);
        }
    }
    public void findMax(){
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(3);
        array.add(2);
        array.add(-3);
        array.add(-5);
        array.add(-7);

        System.out.println("el numero mayor del array es: "+Collections.max(array));
    }
    public void promedio(){
        //[2,10,3]
        ArrayList<Integer> arrayPromedio = new ArrayList<>();
        arrayPromedio.add(2);
        arrayPromedio.add(10);
        arrayPromedio.add(3);
        int suma = 0;
        for (Integer i : arrayPromedio) {
            suma +=i;
        }
        float promedio = (suma / arrayPromedio.size());
        System.out.printf("Suma: %d. Promedio: %f", suma , promedio);
    }

    public void arregloImpares(){
        ArrayList<Integer> arrayImpares = new ArrayList<>();
        for (int i = 1; i <= 255; i++) {
            if(i%3==0){ 
                arrayImpares.add(i);
            }
        }
        System.out.println(arrayImpares);
    }
    public void mayorQue(){
        ArrayList<Integer> findMayor = new ArrayList<>();
        int count = 0;
        findMayor.add(1);
        findMayor.add(3);
        findMayor.add(5);
        findMayor.add(7);
        
        for (Integer integer : findMayor) {
            if (integer>3) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void valoresCuadrados(){
        ArrayList<Integer> arrayNums = new ArrayList<>();
        ArrayList<Integer> arrayCuadrado = new ArrayList<>();

        arrayNums.add(1);
        arrayNums.add(5);
        arrayNums.add(10);
        arrayNums.add(-2);

        for (Integer i : arrayNums) {
            int result = i*i;
            arrayCuadrado.add(result);
        }
        System.out.println(arrayCuadrado);
    }

    public void deleteNegative(){
        ArrayList<Integer> arrayNums = new ArrayList<>();
        arrayNums.add(1);
        arrayNums.add(5);
        arrayNums.add(10);
        arrayNums.add(-2);

        for (Integer i : arrayNums) {
            if(i<0){
                arrayNums.set(arrayNums.indexOf(i), 0);
            }
        }
        System.out.println(arrayNums);
    }
    public void minMaxProm(){
        ArrayList<Integer> arrayNums = new ArrayList<>();
        ArrayList<Integer> arrayMinMaxProm = new ArrayList<>();
        arrayNums.add(1);
        arrayNums.add(5);
        arrayNums.add(10);
        arrayNums.add(-2);
        int sum = 0;
        for (Integer i : arrayNums) {
            sum += i; 
        }  
        arrayMinMaxProm.add(Collections.min(arrayNums));
        arrayMinMaxProm.add(Collections.max(arrayNums));
        arrayMinMaxProm.add(sum/arrayNums.size());
        System.out.println(arrayMinMaxProm);
    }
}
