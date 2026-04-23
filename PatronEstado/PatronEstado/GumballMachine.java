public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state;
    int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState    = new SoldOutState(this);
        noQuarterState  = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState       = new SoldState(this);
        winnerState     = new WinnerState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    // Delegación al estado actual
    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    // Cambio de estado
    public void setState(State state) {
        this.state = state;
    }

    // Liberar un chicle
    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    // Getters de estados
    public State getSoldOutState()    { return soldOutState; }
    public State getNoQuarterState()  { return noQuarterState; }
    public State getHasQuarterState() { return hasQuarterState; }
    public State getSoldState()       { return soldState; }
    public State getWinnerState()     { return winnerState; }

    // Getter del inventario
    public int getCount() { return count; }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) result.append("s");
        result.append("\n");
        if (state == noQuarterState) {
            result.append("Machine is waiting for quarter\n");
        } else if (state == hasQuarterState) {
            result.append("Machine is waiting for turn of crank\n");
        } else if (state == soldState) {
            result.append("Machine is delivering a gumball\n");
        } else if (state == soldOutState) {
            result.append("Machine is sold out\n");
        } else if (state == winnerState) {
            result.append("Machine is delivering two gumballs\n");
        }
        return result.toString();
    }
}