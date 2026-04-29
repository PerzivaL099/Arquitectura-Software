public class MenuItemLeaf extends MenuComponent {

    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItemLeaf(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public double getPrice() { return price; }

    @Override
    public boolean isVegetarian() { return vegetarian; }

    @Override
    public void print(int indent) {
        String pad = "  ".repeat(indent);
        String veg = vegetarian ? "(V)" : "   ";
        System.out.printf("%s  %s %-32s $%.2f%n", pad, veg, name, price);
        System.out.printf("%s       %s%n", pad, description);
    }
}
