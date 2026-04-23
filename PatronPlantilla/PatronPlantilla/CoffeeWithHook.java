import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Clase concreta Café con gancho - Patrón Método Plantilla
// Principio de Hollywood: la superclase llama a esta clase, no al revés
public class CoffeeWithHook extends CaffeineBeverageWithHook {

    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    @Override
    public boolean customerWantsCondiments() {
        String answer = getUserInput();
        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        System.out.print("Would you like milk and sugar with your coffee (y/n)? ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            return in.readLine();
        } catch (IOException e) {
            System.err.println("IO error reading user input: " + e.getMessage());
            return "no"; // valor seguro por defecto ante un error
        }
    }
}
