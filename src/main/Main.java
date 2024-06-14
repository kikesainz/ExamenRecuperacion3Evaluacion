package main;
import dto.AlumnoDTO;
import model.AlumnosModelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static AlumnosModelo alumnosModelo = new AlumnosModelo();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear alumno");
            System.out.println("2. Leer alumno");
            System.out.println("3. Actualizar alumno");
            System.out.println("4. Eliminar alumno");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  

            try {
                switch (opcion) {
                    case 1:
                        crearAlumno(scanner);
                        break;
                    case 2:
                        leerAlumno(scanner);
                        break;

                    case 3:
                        actualizarAlumno(scanner);
                        break;
                    case 4:
                        eliminarAlumno(scanner);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void crearAlumno(Scanner scanner) throws SQLException {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("ID Municipio: ");
        int idMunicipio = scanner.nextInt();
        System.out.print("Familia Numerosa (0/1): ");
        int familiaNumerosa = scanner.nextInt();
        scanner.nextLine();  


        AlumnoDTO alumno = new AlumnoDTO(nombre, idMunicipio, familiaNumerosa);
        alumnosModelo.createAlumno(alumno);
    }

    private static void leerAlumno(Scanner scanner) throws SQLException {
        System.out.print("ID del alumno: ");
        String id = scanner.nextLine();
        List<AlumnoDTO> listaAlumnos = new ArrayList<>();

          
            listaAlumnos = alumnosModelo.readAlumno(id);
            
            for (AlumnoDTO a: listaAlumnos) {
            	System.out.println(a.toString());
            }
            
            
    
        
    }

    private static void actualizarAlumno(Scanner scanner) throws SQLException {
        System.out.print("ID del alumno: ");
        String id = scanner.nextLine(); 
        System.out.print("Nombre (deja en blanco para no actualizar): ");
        String nombre = scanner.nextLine();
        System.out.print("ID Municipio (deja en blanco para no actualizar): ");
        String idMunicipio = scanner.nextLine();
        System.out.print("Familia Numerosa (0/1, deja en blanco para no actualizar): ");
        String familiaNumerosa = scanner.nextLine();



            
            alumnosModelo.updateAlumno(id, nombre, idMunicipio, familiaNumerosa) ;
        
    }

    private static void eliminarAlumno(Scanner scanner) throws SQLException {
        System.out.print("ID del alumno: ");
        int id = scanner.nextInt();
        alumnosModelo.deleteAlumno(id);
    }
}
