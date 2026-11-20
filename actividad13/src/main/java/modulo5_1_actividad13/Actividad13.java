package modulo5_1_actividad13;

public class Actividad13 {
    public static void main(String[] args) {
        int age = 16;
        // TODO: valida el acceso. 
        //Muestra Access granted si age es al menos 18 y Access denied en caso contrario.
        if (age < 18) {
        	System.out.println("Access denied");
        } else {
            System.out.println("Access granted");
        }
    }
}
