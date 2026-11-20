package modulo5_1_actividad12;

public class Actividad12 {
    public static void main(String[] args) {
        int quantity = 2;
        double price = 3.5;
        String s ="";
        String itemName = "cuaderno";
        boolean outOfStock = false;
        // TODO: muestra el estado del carrito.
        //Si outOfStock es true, muestra Sin stock. Si no, muestra la cantidad y 
        //el nombre del artículo (en plural, añadiendo una s, si quantity es distinto de 1) y
        //el total (quantity * price).
        if (outOfStock) {
        	System.out.println("Sin stock");
        } else {
        	if (quantity != 1) s="s";
        	System.out.println(quantity+" cuaderno"+s+"\nTotal: "+ (quantity*price));
        }
    }
}
