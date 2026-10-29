public class TareaProyecto {
    private String descripcion;
    private String estado; // "Pendiente" o "Completa"

    public TareaProyecto(String descripcion) {
        this.descripcion = descripcion;
        this.estado = "Pendiente";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void completar() {
        this.estado = "Completa";
    }

    @Override
    public String toString() {
        return " - Tarea: " + descripcion + " | Estado: " + estado;
    }
}