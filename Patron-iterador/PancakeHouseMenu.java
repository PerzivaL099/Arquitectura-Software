import java.util.ArrayList;

public class PancakeHouseMenu implements Menu {

    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addItem("K&B's Pancake Breakfast",
                "Pancakes con huevos revueltos y tostadas", true, 2.99);
        addItem("Regular Pancake Breakfast",
                "Pancakes con huevos fritos y salchichas", false, 2.99);
        addItem("Blueberry Pancakes",
                "Pancakes hechos con moras frescas y jarabe", true, 3.49);
        addItem("Waffles",
                "Waffles con fresas o moras a elegir", true, 3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.add(new MenuItem(name, description, vegetarian, price));
    }

    @Override
    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }

    @Override
    public String getMenuName() {
        return "DESAYUNOS — Objectville Pancake House";
    }
}
