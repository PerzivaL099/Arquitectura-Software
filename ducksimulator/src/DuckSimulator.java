public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        // Abstract Factory: use the counting factory to guarantee all ducks are decorated
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {

        // --- Abstract Factory creates Quackables (decorated with QuackCounter) ---
        Quackable redheadDuck  = duckFactory.createRedheadDuck();
        Quackable duckCall     = duckFactory.createDuckCall();
        Quackable rubberDuck   = duckFactory.createRubberDuck();

        // --- Adapter: wrap a Goose so it can play with Quackables ---
        Quackable gooseDuck    = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator: With Composite - Flocks");

        // --- Composite: build a flock of mixed Quackables ---
        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        // Sub-flock of Mallards
        Flock flockOfMallards = new Flock();
        Quackable mallardOne   = duckFactory.createMallardDuck();
        Quackable mallardTwo   = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour  = duckFactory.createMallardDuck();
        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        // Add the sub-flock into the main flock
        flockOfDucks.add(flockOfMallards);

        // --- Observer: register a Quackologist to watch the whole flock ---
        System.out.println("\nDuck Simulator: With Observer");
        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        // Simulate the whole flock
        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);

        // Simulate just the mallard sub-flock
        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulate(flockOfMallards);

        // Quackologist data
        System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    // Polymorphism: works for any Quackable, including Flock composites
    void simulate(Quackable duck) {
        duck.quack();
    }
}
