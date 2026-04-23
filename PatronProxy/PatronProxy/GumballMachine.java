import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;

/**
 * GumballMachine adaptada para ser un Objeto Remoto RMI.
 *
 * Pasos para convertir una clase en objeto remoto:
 *  1. Implementar la interfaz remota (GumballMachineRemote).
 *  2. Extender UnicastRemoteObject (maneja la infraestructura de red de RMI).
 *  3. Declarar que el constructor lanza RemoteException.
 *  4. Registrar la instancia en el RMI registry con Naming.rebind().
 *
 * Con estos pasos, RMI genera automáticamente el STUB (Proxy Remoto)
 * que el cliente recibirá cuando haga Naming.lookup().
 */
public class GumballMachine
        extends UnicastRemoteObject   // <-- paso 2: infraestructura RMI
        implements GumballMachineRemote { // <-- paso 1: interfaz remota

    private static final long serialVersionUID = 1L;

    // ---------------------------------------------------------------
    // Estados disponibles
    // ---------------------------------------------------------------
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state;       // estado actual
    int count = 0;     // chicles disponibles
    String location;   // identificador / ciudad de la máquina

    // ---------------------------------------------------------------
    // Constructor: lanza RemoteException porque UnicastRemoteObject
    // lo requiere (abre sockets de red internamente).
    // ---------------------------------------------------------------
    public GumballMachine(String location, int numberGumballs)
            throws RemoteException { // <-- paso 3: declarar excepción

        this.location = location;
        this.count = numberGumballs;

        soldOutState    = new SoldOutState(this);
        noQuarterState  = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState       = new SoldState(this);

        state = (count > 0) ? noQuarterState : soldOutState;
    }

    // ---------------------------------------------------------------
    // Métodos de la interfaz remota
    // (el cliente los llama a través del Proxy/Stub sin saberlo)
    // ---------------------------------------------------------------

    @Override
    public int getCount() throws RemoteException {
        return count;
    }

    @Override
    public String getLocation() throws RemoteException {
        return location;
    }

    @Override
    public State getState() throws RemoteException {
        return state;
    }

    // ---------------------------------------------------------------
    // Métodos de acceso a estados (uso interno del servidor)
    // ---------------------------------------------------------------
    public void setState(State state)       { this.state = state; }
    public State getSoldOutState()          { return soldOutState; }
    public State getNoQuarterState()        { return noQuarterState; }
    public State getHasQuarterState()       { return hasQuarterState; }
    public State getSoldState()             { return soldState; }

    // ---------------------------------------------------------------
    // Operaciones de la máquina
    // ---------------------------------------------------------------
    public void insertQuarter()  { state.insertQuarter(); }
    public void ejectQuarter()   { state.ejectQuarter(); }
    public void turnCrank()      { state.turnCrank(); state.dispense(); }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) count--;
    }

    @Override
    public String toString() {
        return "\n--- Gumball Machine [" + location + "] ---\n"
             + "Inventory: " + count + " gumball(s)\n"
             + "State    : " + state + "\n";
    }

    // ---------------------------------------------------------------
    // PUNTO DE ENTRADA DEL SERVIDOR
    // Paso 4: registrar la máquina en el RMI registry.
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: GumballMachine <location> <count>");
            System.exit(1);
        }

        String location = args[0];
        int count = Integer.parseInt(args[1]);

        try {
            GumballMachine machine = new GumballMachine(location, count);

            // Naming.rebind() publica el objeto bajo un nombre en el
            // registry local (puerto 1099 por defecto).
            // El cliente usará ese mismo nombre para hacer lookup.
            Naming.rebind("rmi://localhost/gumballmachine", machine);

            System.out.println("Gumball Machine server ready at: " + location);
            System.out.println("Registered as: rmi://localhost/gumballmachine");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}