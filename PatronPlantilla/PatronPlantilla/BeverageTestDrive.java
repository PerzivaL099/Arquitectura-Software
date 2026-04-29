
public class BeverageTestDrive {

    public static void main(String[] args) {

        // --- Preparar Té con gancho ---
        TeaWithHook teaHook = new TeaWithHook();
        System.out.println("\nMaking tea...");
        teaHook.prepareRecipe();

        // --- Preparar Café con gancho ---
        CoffeeWithHook coffeeHook = new CoffeeWithHook();
        System.out.println("\nMaking coffee...");
        coffeeHook.prepareRecipe();
    }
}
