// Clase abstracta con gancho (hook) - Principio de Hollywood
public abstract class CaffeineBeverageWithHook {

    // Método plantilla: la clase base dirige la ejecución
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        // El gancho decide si se añaden condimentos
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // Pasos concretos compartidos
    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Pasos abstractos que las subclases deben implementar
    abstract void brew();
    abstract void addCondiments();

    // Gancho (hook): implementación por defecto, las subclases pueden sobreescribirlo
    boolean customerWantsCondiments() {
        return true;
    }
}
