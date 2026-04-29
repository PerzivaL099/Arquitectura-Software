import java.util.Arrays;

public class MainIterator {

    public static void main(String[] args) {
        System.out.println("\n################################################################");
        System.out.println("  PATRON ITERADOR — Encapsula la iteracion de colecciones");
        System.out.println("################################################################");

        PancakeHouseMenu pancakeMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(Arrays.asList(pancakeMenu, dinerMenu));

        waitress.printMenu();
        waitress.printVegetarianMenu();

        System.out.println("\n--- Consulta individual ---");
        System.out.println("¿Es 'Hotdog' vegetariano?    -> " + waitress.isItemVegetarian("Hotdog"));
        System.out.println("¿Son 'Waffles' vegetarianos? -> " + waitress.isItemVegetarian("Waffles"));
    }
}
