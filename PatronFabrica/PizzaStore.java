package PatronFabrica;

// Clase abstracta PizzaStore
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;

        // El método de fábrica es llamado aquí
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // Este es el "Factory Method"
    protected abstract Pizza createPizza(String type);
}