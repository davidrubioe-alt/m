public class Biblioteca {
    private Libro[] catalogo;
    private int contadorLibros;

    public Biblioteca(int capacidad) {
        this.catalogo = new Libro[capacidad];
        this.contadorLibros = 0;
    }

    public void registrarLibro(String titulo, String autor, String isbn, int copias) {
        if (copias < 0) {
            System.out.println("[Error] La cantidad de copias no puede ser negativa.");
            return;
        }
        if (buscarPorIsbn(isbn) != null) {
            System.out.println("[Error] Ya existe un libro registrado con el ISBN: " + isbn);
            return;
        }
        if (contadorLibros < catalogo.length) {
            catalogo[contadorLibros] = new Libro(titulo, autor, isbn, copias);
            contadorLibros++;
            System.out.println("[Log] Libro registrado exitosamente.");
        } else {
            System.out.println("[Error] La biblioteca ha alcanzado el límite máximo de almacenamiento.");
        }
    }

    public Libro buscarPorIsbn(String isbn) {
        for (int i = 0; i < contadorLibros; i++) {
            if (catalogo[i].getIsbn().equalsIgnoreCase(isbn)) {
                return catalogo[i];
            }
        }
        return null;
    }

    public void prestarLibro(String isbn) {
        Libro libro = buscarPorIsbn(isbn);
        if (libro == null) {
            System.out.println("[Error] El libro con ISBN " + isbn + " no existe.");
        } else if (libro.prestar()) {
            System.out.println("[Log] Préstamo realizado con éxito.");
        } else {
            System.out.println("[Error] No hay copias disponibles para préstamo.");
        }
    }

    public void devolverLibro(String isbn) {
        Libro libro = buscarPorIsbn(isbn);
        if (libro == null) {
            System.out.println("[Error] El libro con ISBN " + isbn + " no pertenece al catálogo.");
        } else {
            libro.devolver();
            System.out.println("[Log] Devolución procesada correctamente.");
        }
    }

    public void listarLibros() {
        System.out.println("\n--- Catálogo de la Biblioteca ---");
        if (contadorLibros == 0) {
            System.out.println("No hay libros registrados en el catálogo.");
            return;
        }
        for (int i = 0; i < contadorLibros; i++) {
            catalogo[i].mostrarInfo();
        }
    }

    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca(3);

        // Registro de libros
        biblio.registrarLibro("Cien Años de Soledad", "G. García Márquez", "978-1", 2);
        biblio.registrarLibro("Don Quijote", "Miguel de Cervantes", "978-2", 1);
        
        biblio.listarLibros();

        // Pruebas de préstamos y manejo de errores
        System.out.println("\n--- Prueba de Préstamos y Errores ---");
        biblio.prestarLibro("978-2"); // Exitoso (quedan 0)
        biblio.prestarLibro("978-2"); // Error: sin copias

        // Devolución
        biblio.devolverLibro("978-2"); // Exitoso (queda 1)
        
        biblio.listarLibros();
    }
}
