package modulo5_1_actividad14;

public class Actividad14 {
    public static void main(String[] args) {
        int first = 12;
        int second = 7;
        // TODO: compara ambos valores.
        //Indica el mayor (X es mayor que Y) o, si ambos son iguales, muestra Los dos números son iguales.
        if (first > second) {
        	System.out.println(first+" es mayor que "+second);
        }else {
        	if (first < second) {
        		System.out.println(first+" es menor que "+second);
        	} else {
        		System.out.println("Los dos números son iguales");
        	}
        }
    }
}
