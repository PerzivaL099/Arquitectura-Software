public class CompositeWaitress {

    MenuComponent allMenus;

    public CompositeWaitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        System.out.println("\n============================================================");
        System.out.println("    MENU COMPLETO — ESTRUCTURA JERARQUICA (Composite)");
        System.out.println("============================================================");
        allMenus.print(0);
    }
}
