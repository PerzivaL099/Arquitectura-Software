public class StarbuzzCoffee {

    public static void main(String[] args) {

        // --- Pedido 1: Espresso solo ---
        Beverage beverage1 = new Espresso();
        System.out.println(beverage1.getDescription()
                + " $" + String.format("%.2f", beverage1.cost()));

        // --- Pedido 2: DarkRoast con doble Mocha y Whip ---
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()
                + " $" + String.format("%.2f", beverage2.cost()));

        // --- Pedido 3: HouseBlend con Soy, Mocha y Whip ---
        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription()
                + " $" + String.format("%.2f", beverage3.cost()));

        // --- Pedido 4: Decaf con SteamedMilk ---
        Beverage beverage4 = new Decaf();
        beverage4 = new SteamedMilk(beverage4);
        System.out.println(beverage4.getDescription()
                + " $" + String.format("%.2f", beverage4.cost()));
    }
}
