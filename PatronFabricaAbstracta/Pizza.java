package PatronFabricaAbstracta;
import java.util.ArrayList;

// Pizza abstracta actualizada para Patrón Fábrica Abstracta
// Los campos de ingredientes ahora son de tipo interfaz, no String
public abstract class Pizza {
    String name;

    Dough dough;
    Sauce sauce;
    Cheese cheese;
    Veggies veggies[];
    Pepperoni pepperoni;
    Clams clam;

    abstract void prepare();

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("---- " + name + " ----\n");
        if (dough != null)      result.append(dough + "\n");
        if (sauce != null)      result.append(sauce + "\n");
        if (cheese != null)     result.append(cheese + "\n");
        if (veggies != null) {
            for (int i = 0; i < veggies.length; i++) {
                result.append(veggies[i]);
                if (i < veggies.length - 1) result.append(", ");
            }
            result.append("\n");
        }
        if (clam != null)       result.append(clam + "\n");
        if (pepperoni != null)  result.append(pepperoni + "\n");
        return result.toString();
    }
}