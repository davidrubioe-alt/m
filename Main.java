public class Main {
    public static void main(String[] args) {
        Proyecto p = new Proyecto("Sistema Web", "Desarrollo de plataforma e-commerce", 5);
        
        p.agregarTarea("Diseñar Base de Datos");
        p.agregarTarea("Crear Backend");

        System.out.println();
        p.mostrarProyecto();
    }
}
