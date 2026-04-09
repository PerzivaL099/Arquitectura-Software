package PatronFabricaAbstracta;
// VeggiePizza - "ciega" a la región, solo llama a la fábrica
public class VeggiePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    void prepare() {
        System.out.println("Preparing " + name);
        dough   = ingredientFactory.createDough();
        sauce   = ingredientFactory.createSauce();
        cheese  = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
    }
}
