 import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestorRecetas {
    private final int capacidadMaxima;
    private List<Receta> recetario;
    private List<String> registroEventos;

    public GestorRecetas(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.recetario = new ArrayList<>();
        this.registroEventos = new ArrayList<>();
        registrarEvento("INICIO", "Sistema de Gestión de Recetas iniciado.");
    }

    public boolean agregarReceta(Receta receta) {
        if (recetario.size() >= capacidadMaxima) {
            System.out.println("Error: Capacidad máxima del sistema alcanzada (" + capacidadMaxima + " recetas).");
            registrarEvento("FALLO", "Intento de registro superando la capacidad máxima (" + capacidadMaxima + ").");
            return false;
        }

        if (buscarPorNombre(receta.getNombre()) != null) {
            System.out.println("Error: Ya existe una receta registrada con ese nombre.");
            registrarEvento("FALLO", "Intento de registro de receta duplicada: " + receta.getNombre());
            return false;
        }

        recetario.add(receta);
        registrarEvento("REGISTRO", "Receta creada exitosamente: " + receta.getNombre());
        return true;
    }

    public Receta buscarPorNombre(String nombre) {
        for (Receta r : recetario) {
            if (r.getNombre().equalsIgnoreCase(nombre)) {
                return r;
            }
        }
        return null;
    }

    public List<Receta> getRecetario() {
        return recetario;
    }

    public List<String> getRegistroEventos() {
        return registroEventos;
    }

    public void registrarEvento(String tipo, String descripcion) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String log = "[" + timestamp + "] [" + tipo + "] " + descripcion;
        registroEventos.add(log);
    }
}

