package modulo5_1_actividad11;

public class Actividad11 {
    public static void main(String[] args) {
        double temperature = 30.5;
        // TODO: calcula forecast. Guarda en forecast SNOW si temperature es menor o igual que 32
        //(grados Fahrenheit) o RAIN en caso contrario, y muéstralo.
        String forecast = "";
        if (temperature <= 32) {
        	forecast = "SNOW";
        } else {
        	forecast = "RAIN";
        }
        System.out.println("Forecast: " + forecast);
    }
}
