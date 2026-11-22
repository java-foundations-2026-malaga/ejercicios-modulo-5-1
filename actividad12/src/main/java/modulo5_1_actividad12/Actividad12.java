package modulo5_1_actividad12;

public class Actividad12 {
    public static void main(String[] args) {
        int quantity = 2;
        double price = 3.5;
        String itemName = "cuaderno";
        boolean outOfStock = false;

        if (outOfStock) {
            System.out.println("Sin stock");
        } else {
            String plural = quantity != 1 ? "s" : "";

            System.out.println(quantity + " " + itemName + plural);
            System.out.println("Total: " + (quantity * price));
        }
    }
}
