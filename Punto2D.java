public class Punto2D {
    // Atributos privados
    private double x;
    private double y;

    // Constructor por defecto (origen 0,0)
    public Punto2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Constructor con parámetros
    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters y Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Desplaza el punto en los ejes X e Y
    public void mover(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    // Calcula la distancia desde (0,0)
    public double calcularDistanciaDesdeOrigen() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    // Representación en texto del punto
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}