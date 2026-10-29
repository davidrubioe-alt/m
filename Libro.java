public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private int copiasDisponibles;

    public Libro(String titulo, String autor, String isbn, int copiasDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.copiasDisponibles = copiasDisponibles;
    }

    public String getTitulo() { 
        return titulo; 
    }
    
    public String getAutor() { 
        return autor; 
    }
    
    public String getIsbn() { 
        return isbn; 
    }
    
    public int getCopiasDisponibles() { 
        return copiasDisponibles; 
    }

    public boolean prestar() {
        if (copiasDisponibles > 0) {
            copiasDisponibles--;
            return true;
        }
        return false;
    }

    public void devolver() {
        copiasDisponibles++;
    }

    public void mostrarInfo() {
        System.out.println("ISBN: " + isbn + " | Título: " + titulo + " | Autor: " + autor + " | Disponibles: " + copiasDisponibles);
    }
}