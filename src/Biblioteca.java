import java.io.*;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
        }
    }

    public void serializarLibros() {
        try(FileOutputStream fileOut = new FileOutputStream("libros.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            if (libros.isEmpty()) {
                System.out.println("No hay libros");
            } else {
                for (Libro libro : libros) {
                    objectOut.writeObject(libro);
                }
                System.out.println("Libros agregados al archivo libros.ser");
            }

        } catch(IOException e) {
            System.out.println("Fallo output");
        }
    }

    public void desserializarLibros() {
        try(FileInputStream fileIn = new FileInputStream("libros.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Libro libro = (Libro) objectIn.readObject();
                    System.out.println("\nInformacion de libro: ");
                    System.out.println(libro.toString());
                }catch (EOFException e) {
                    System.err.println("Alcanzado el final del archivo");
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e ) {
            System.out.println("Fallo input");
        }
    }
}
