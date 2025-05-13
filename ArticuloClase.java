
// Clase base Articulo con encapsulamiento
public class ArticuloClase {
    // Atributos privados para aplicar el principio de encapsulamiento
    private int id;
    private String nombre;
    private double precio;
    private String descripcion;

    // Constructor para inicializar el objeto Articulo
    public ArticuloClase(int idParametro, String nombreParametro, double precioParametro, String descripcionParametro) {
        this.id = idParametro;               // 'this' refiere al atributo del objeto
        this.nombre = nombreParametro;
        this.precio = precioParametro;
        this.descripcion = descripcionParametro;
    }

    // Getter para el atributo id (solo lectura)
    public int getId() {
        return id;
    }
    // no tengo un setter para el id, 

    // Getter para el atributo nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para modificar el nombre
    public void setNombre(String nombreParametro) {
        this.nombre = nombreParametro;
    }

    // Getter para el atributo precio
    public double getPrecio() {
        return precio;
    }

    // Setter para modificar el precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcionParametro) {
        this.descripcion = descripcionParametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Método para mostrar la información del artículo
    public void mostrar() {
        // Este método puede ser sobrescrito por subclases (polimorfismo)
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio);
        System.out.println("Descripcion: " + descripcion);
    }
}
