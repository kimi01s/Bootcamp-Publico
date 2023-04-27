import java.lang.Math;
public class Pitagoras {
    public double calcularHipotenusa(double catetoA, double catetoB) {
//         //La hipotenusa es el lado opuesto del ángulo recto.
//         //Calcular el valor de c dados los valores catetoA y catetoB
        double resultado;
        double operacion = (Math.abs(catetoA * catetoA) + Math.abs(catetoB * catetoB));
        resultado = Math.sqrt(operacion);
        return resultado;

    }
}

