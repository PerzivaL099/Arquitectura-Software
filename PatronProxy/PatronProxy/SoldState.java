public class SoldState implements State {
    private static final long serialVersionUID = 1L;

    transient GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter()  { System.out.println("Please wait, we're already giving you a gumball."); }

    @Override
    public void ejectQuarter()   { System.out.println("Sorry, you already turned the crank."); }

    @Override
    public void turnCrank()      { System.out.println("Turning twice doesn't get you another gumball."); }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        try {
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        } catch (java.rmi.RemoteException e) {
            // En el servidor, getCount() es local, pero la interfaz
            // lo declara como remoto. Esta excepción no ocurrirá
            // en la llamada local, pero debemos satisfacer el compilador.
            System.err.println("Unexpected error reading count: " + e.getMessage());
        }
    }

    @Override
    public String toString()     { return "dispensing a gumball"; }
}
