// Clase abstracta base - Patrón Método Plantilla
public abstract class CaffeineBeverage {

    // Método plantilla: define el algoritmo, no puede sobreescribirse
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Pasos concretos compartidos por todas las bebidas
    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Pasos que cada subclase debe implementar (Principio de Hollywood)
    abstract void brew();
    abstract void addCondiments();
}
