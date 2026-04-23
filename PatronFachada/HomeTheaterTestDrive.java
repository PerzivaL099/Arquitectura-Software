/**
 * HomeTheaterTestDrive - Cliente de prueba del Patrón Fachada
 *
 * Principio de Mínimo Conocimiento (Law of Demeter):
 * Una vez creada la fachada, el cliente SOLO interactúa con ella.
 * No llama directamente a amp, dvd, projector, etc.
 */
public class HomeTheaterTestDrive {

    public static void main(String[] args) {

        // 1. Instanciar cada componente del subsistema
        Amplifier     amp      = new Amplifier("Top-O-Line Amplifier");
        DvdPlayer     dvd      = new DvdPlayer("Top-O-Line DVD Player");
        Projector     projector= new Projector("Top-O-Line Projector");
        TheaterLights lights   = new TheaterLights("Theater Ceiling Lights");
        Screen        screen   = new Screen("Theater Screen");
        PopcornPopper popper   = new PopcornPopper("Popcorn Popper");

        // 2. Crear la fachada inyectando los componentes
        HomeTheaterFacade homeTheater =
                new HomeTheaterFacade(amp, dvd, projector, lights, screen, popper);

        // 3. Usar únicamente la fachada — Principio de Mínimo Conocimiento
        homeTheater.watchMovie("Inception");

        System.out.println();

        homeTheater.endMovie();
    }
}
