
import java.util.ArrayList;
import java.util.Scanner;

// Clase principal del programa
public class Main {
    // Lista que almacena objetos de tipo Articulo
    static ArrayList<ArticuloClase> lista = new ArrayList<>();
    // Scanner para entrada de datos por consola
    static Scanner sc = new Scanner(System.in);

    // Método principal
    public static void main(String[] args) {
        int opcion;
        // Bucle principal del programa con menú interactivo
        do {
            System.out.println("\n--- Menú de Artículos ---");
            cantArticulos();
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();         // Leer opción del usuario
            sc.nextLine();                 // Limpiar buffer del scanner

            // Estructura switch para manejar las opciones
            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> listarArticulos();
                case 3 -> modificarArticulo();
                case 4 -> eliminarArticulo();
                case 5 -> {
                    System.out.println("Saliendo...");
                    System.out.println("Gracias por usar el programa! - Javier Monzon");
                }
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5); // Repetir hasta que el usuario elija salir
    }

    // Método para crear un nuevo artículo
    public static void crearArticulo() {
        boolean idVal1=false;
        boolean idVal2=false;
        boolean precioVal=false;
        double precio=0;
        int id = 0;
        
        //Ingreso de ID

        System.out.println("\n--- Ingreso de Articulo ---");
        while (idVal1==false || idVal2==false){
            System.out.print("ID: ");
            id = sc.nextInt(); sc.nextLine();     // Leer ID

            if ( id < 100000 || id > 999999 ) {
                //Si el ID no tiene 6 digitos se vuelve a pedir
                System.out.println("Error! ID debe tener 6 digitos! Intente nuevamente");
                idVal1 = false;
            } else {
                idVal1 = true;
            }

            if (lista.isEmpty()) {
                idVal2 = true;
            }else{
                //Mientras que el ID sea igual a alguno ya existente, va a seguir pidiendo uno
                for (ArticuloClase a : lista) {
                    if (a.getId() == id) {
                        System.out.println("Error! ID ya esta en uso! Intente nuevamente");
                        idVal2 = false;
                    } else {
                        idVal2 = true;
                    }            
                }
            }
            
        }
        
       //Ingreso de nombre del producto

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();            // Leer nombre
        //Convertimos todo en minuscula y solo la primer letra en mayuscula
        nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
        
        //Ingreso del precio

        while (precioVal==false){
            System.out.print("Precio: $"); //Leer precio
            precio = sc.nextDouble(); sc.nextLine();
            if ( precio < 0 ) {
                //Si el precio es negativo se vuelve a pedir
                System.out.println("Error! Precio no puede ser negativo! Intente nuevamente");
                precioVal = false;
            } else {
                precioVal = true;
            }
        }

        //Ingreso de la descripcion

        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();       // Leer descripcion

        // Crear un nuevo objeto Articulo y agregarlo a la lista
        ArticuloClase nuevo = new ArticuloClase(id, nombre, precio, descripcion);
        lista.add(nuevo);
        System.out.println("Artículo agregado.");
    }

    // Método para mostrar todos los artículos de la lista
    public static void listarArticulos() {
        System.out.println("\n--- Lista de Articulos ---");
        if (lista.isEmpty()) {
            System.out.println("No hay artículos cargados.");
        } else {
            for (ArticuloClase a : lista) {
                /*a.mostrar(); */
                System.out.println(a.toString());   // Llamada polimórfica al método mostrar()
            }
        }
    }

    // Método para modificar un artículo existente
    public static void modificarArticulo() {
        int opcion;
        System.out.println("\n--- Modificar Artículo ---");
        System.out.print("ID del artículo a modificar: ");
        int id = sc.nextInt();
        for (ArticuloClase articulo : lista) {
            if (articulo.getId() == id) {
                sc.nextLine();
                System.out.println("--- Que desea modificar? ---");
                System.out.println("1. Nombre");
                System.out.println("2. Precio");
                System.out.println("3. Descripcion");
                System.out.println("4. Todos");
                System.out.print("Opcion: ");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Nuevo nombre: ");
                        articulo.setNombre(sc.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Nuevo precio: $");
                        articulo.setPrecio(sc.nextDouble());
                    }
                    case 3 -> {
                        System.out.print("Nueva descripcion: ");
                        articulo.setDescripcion(sc.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Nuevo nombre: ");
                        articulo.setNombre(sc.nextLine());
                        System.out.print("Nuevo precio: $");
                        articulo.setPrecio(sc.nextDouble());
                        System.out.print("Nueva descripcion: ");
                        articulo.setDescripcion(sc.nextLine());
                    }
                    default -> System.out.println("Opción inválida");
                }
                System.out.println("Artículo actualizado con exito!.");
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }

    // Método para eliminar un artículo por ID
    public static void eliminarArticulo() {
        System.out.println("\n--- Eliminar Artículo ---");
        System.out.print("ID del artículo a eliminar: ");
        int id = sc.nextInt();
        // Usamos removeIf con expresión lambda para eliminar por ID
        lista.removeIf(a -> a.getId() == id);
        for ( ArticuloClase producto : lista ) {
            if (producto.getId()==id){
                System.out.println("Error! Articulo no eliminado!");
                return;
            } else {
                System.out.println("Articulo eliminado con exito!");
                return;
            }
        }
    }

    // Método para mostrar la cantidad de artículos cargados
    public static void cantArticulos() {
        System.out.println();
        System.out.println("Cantidad de articulos cargados: " + lista.size());
        System.out.println();
    }
}
