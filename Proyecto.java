public class Proyecto {
 private String nombre;
    private String descripcion;
    private TareaProyecto[] tareas;
    private int contadorTareas;

    public Proyecto(String nombre, String descripcion, int maxTareas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tareas = new TareaProyecto[maxTareas];
        this.contadorTareas = 0;
    }

    public void agregarTarea(String descripcionTarea) {
        if (contadorTareas < tareas.length) {
            tareas[contadorTareas] = new TareaProyecto(descripcionTarea);
            contadorTareas++;
            System.out.println("Tarea agregada con éxito.");
        } else {
            System.out.println("No se pueden agregar más tareas a este proyecto.");
        }
    }

    public void mostrarProyecto() {
        System.out.println("Proyecto: " + nombre + " (" + descripcion + ")");
        System.out.println("Lista de Tareas:");
        for (int i = 0; i < contadorTareas; i++) {
            System.out.println(tareas[i]);
        }
    }
}

