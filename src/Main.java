public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El silencio","Pedro","nose",12,2);
        Libro libro2 = new Libro("Invadio todas las casas","Maria","nose",17,4);
        Libro libro3 = new Libro("De italia","Ana","nose",15,3);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        biblioteca.mostrarLibros();

        biblioteca.serializarLibros();

        biblioteca.desserializarLibros();
    }
}
