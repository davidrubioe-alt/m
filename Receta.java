 import java.util.List;

public class Receta {
    private String nombre;
    private List<Ingrediente> ingredientes;
    private String instrucciones;
    private int porciones;

    public Receta(String nombre, List<Ingrediente> ingredientes, String instrucciones, int porciones) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
        this.porciones = porciones;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    public void mostrarDetalles() {
        System.out.println("\n========================================");
        System.out.println("RECETA: " + nombre.toUpperCase());
        System.out.println("Porciones: " + porciones);
        System.out.println("Ingredientes:");
        for (Ingrediente ing : ingredientes) {
            System.out.println("  " + ing);
        }
        System.out.println("Instrucciones:\n  " + instrucciones);
        System.out.println("========================================\n");
    }
}

