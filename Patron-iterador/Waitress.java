import java.util.List;

public class Waitress {

    List<Menu> menus;

    public Waitress(List<Menu> menus) {
        this.menus = menus;
    }

    public void printMenu() {
        System.out.println("\n============================================================");
        System.out.println("       MENU DEL RESTAURANTE FUSIONADO");
        System.out.println("============================================================");
        for (Menu menu : menus) {
            printSingleMenu(menu);
        }
    }

    private void printSingleMenu(Menu menu) {
        System.out.println("\n-- " + menu.getMenuName() + " --");
        Iterator iterator = menu.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void printVegetarianMenu() {
        System.out.println("\n============================================================");
        System.out.println("       MENU VEGETARIANO");
        System.out.println("============================================================");
        for (Menu menu : menus) {
            System.out.println("\n-- " + menu.getMenuName() + " --");
            Iterator iterator = menu.createIterator();
            while (iterator.hasNext()) {
                MenuItem item = iterator.next();
                if (item.isVegetarian()) {
                    System.out.println(item);
                }
            }
        }
    }

    public boolean isItemVegetarian(String name) {
        for (Menu menu : menus) {
            Iterator iterator = menu.createIterator();
            while (iterator.hasNext()) {
                MenuItem item = iterator.next();
                if (item.getName().equalsIgnoreCase(name)) {
                    return item.isVegetarian();
                }
            }
        }
        return false;
    }
}
