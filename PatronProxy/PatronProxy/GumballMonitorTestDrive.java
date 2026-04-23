import java.rmi.Naming;

public class GumballMonitorTestDrive {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("GumballMonitor");
            System.out.println("Usage  : java GumballMonitorTestDrive <url> [<url2> ...]");
            System.out.println("Example: java GumballMonitorTestDrive rmi://localhost/gumballmachine");
            System.exit(1);
        }

        GumballMonitor[] monitors = new GumballMonitor[args.length];

        // ── Fase 1: Conectar a cada máquina remota ──────────────────────────

        for (int i = 0; i < args.length; i++) {
            String location = args[i];
            try {
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location);

                monitors[i] = new GumballMonitor(machine);

            } catch (java.rmi.NotBoundException e) {
                System.err.println("[WARN] Not found in registry: " + location);
                monitors[i] = null;
            } catch (java.net.MalformedURLException e) {
                System.err.println("[WARN] Invalid URL: " + location);
                monitors[i] = null;
            } catch (java.rmi.RemoteException e) {
                System.err.println("[WARN] Cannot connect to: " + location
                        + " -> " + e.getMessage());
                monitors[i] = null;
            }
        }

        // ── Fase 2: Reportar el estado de cada máquina ──────────────────────

        for (GumballMonitor monitor : monitors) {
            if (monitor != null) {
                monitor.report();
                System.out.println(); // línea en blanco entre máquinas
            }
        }
    }
}
