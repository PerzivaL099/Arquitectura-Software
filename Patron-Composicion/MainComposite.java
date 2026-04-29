public class MainComposite {

    public static void main(String[] args) {
        System.out.println("\n################################################################");
        System.out.println("  PATRON COMPOSICION — Arbol de menus y submenus");
        System.out.println("################################################################");

        CompositeMenu allMenus = new CompositeMenu("Restaurante Fusionado", "Nuestro menu completo");

        // Desayunos
        CompositeMenu breakfast = new CompositeMenu("Desayunos", "Pancake House — hasta las 11am");
        breakfast.add(new MenuItemLeaf("K&B's Pancake Breakfast",
                "Pancakes con huevos revueltos", true, 2.99));
        breakfast.add(new MenuItemLeaf("Regular Pancake Breakfast",
                "Pancakes con huevos fritos y salchichas", false, 2.99));
        breakfast.add(new MenuItemLeaf("Blueberry Pancakes",
                "Pancakes con moras frescas", true, 3.49));

        // Almuerzos con submenu de postres
        CompositeMenu lunch = new CompositeMenu("Almuerzos", "Diner — de 11am a 3pm");
        lunch.add(new MenuItemLeaf("Vegetarian BLT",
                "Tocino de soya con lechuga y tomate", true, 2.99));
        lunch.add(new MenuItemLeaf("BLT",
                "Tocino con lechuga y tomate", false, 2.99));
        lunch.add(new MenuItemLeaf("Soup of the Day",
                "Sopa del dia con ensalada de papa", false, 3.29));
        lunch.add(new MenuItemLeaf("Pasta",
                "Pasta con salsa marinara", true, 3.89));

        CompositeMenu desserts = new CompositeMenu("Postres", "Prueba nuestros postres!");
        desserts.add(new MenuItemLeaf("Apple Pie",
                "Pay de manzana con helado de vainilla", true, 1.59));
        desserts.add(new MenuItemLeaf("Cheesecake",
                "Cheesecake cremoso con fresas", true, 1.99));
        desserts.add(new MenuItemLeaf("Sorbet",
                "Sorbete de limon, bajo en calorias", true, 1.49));

        lunch.add(desserts); // submenu anidado

        // Cenas
        CompositeMenu dinner = new CompositeMenu("Cenas", "Diner — de 3pm en adelante");
        dinner.add(new MenuItemLeaf("Pasta Especial",
                "Pasta fresca con salsa de la casa", true, 8.99));
        dinner.add(new MenuItemLeaf("Ribeye Steak",
                "Corte Ribeye con papas y ensalada", false, 14.99));

        allMenus.add(breakfast);
        allMenus.add(lunch);
        allMenus.add(dinner);

        CompositeWaitress waitress = new CompositeWaitress(allMenus);
        waitress.printMenu();
    }
}
