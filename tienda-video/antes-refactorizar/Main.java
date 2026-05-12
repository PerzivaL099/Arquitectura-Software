public class Main {
    public static void main(String[] args) { // 'main' en minúscula
        // Prueba para una pelicula (Usando 'Movie' con mayúscula)
        Movie miPelicula = new Movie("El Padrino", Movie.NEW_RELEASE);

        // Renta de 3 dias para la pelicula (Usando 'Rental' con mayúscula)
        Rental miRenta = new Rental(miPelicula, 3); // miPelicula coincide exactamente

        // Print los datos en consola
        System.out.println("Pelicula rentada: " + miRenta.getMovie().getTitle());
        System.out.println("Dias rentados: " + miRenta.getDaysRented());
    }
}