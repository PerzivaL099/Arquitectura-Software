public class DinerMenu implements Menu {

    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT",
                "Tocino de soya con lechuga y tomate en pan integral", true, 2.99);
        addItem("BLT",
                "Tocino con lechuga y tomate en pan integral", false, 2.99);
        addItem("Soup of the Day",
                "Sopa del dia con ensalada de papa", false, 3.29);
        addItem("Hotdog",
                "Hotdog con chucrut, cebolla y queso", false, 3.05);
        addItem("Steamed Veggies and Brown Rice",
                "Mezcla de verduras al vapor con arroz integral", true, 3.99);
        addItem("Pasta",
                "Pasta con salsa marinara, pan de ajo incluido", true, 3.89);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Lo sentimos, el menu esta lleno. No se puede agregar mas items.");
        } else {
            menuItems[numberOfItems] = new MenuItem(name, description, vegetarian, price);
            numberOfItems++;
        }
    }

    @Override
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems, numberOfItems);
    }

    @Override
    public String getMenuName() {
        return "ALMUERZOS — Objectville Diner";
    }
}
