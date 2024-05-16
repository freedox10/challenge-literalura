package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.DatosResultados;
import com.aluracursos.literalura.model.Resultados;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    // Instanciar un objeto ConsumoAPI
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books";
    // Instanciar un objeto ConvierteDatos
    private ConvierteDatos conversor = new ConvierteDatos();


//    public void muestraResultadoBusqueda(){
//        System.out.println("Escribe el título y/o autor del libro: ");
//        var busqueda = teclado.nextLine();
//        System.out.println(busqueda);
//        var json = consumoApi.obtenerDatos(URL_BASE + "/?search=" +
//                busqueda.replace(" ","%20"));
//        System.out.println("RESULTADO: " + json);
//    }


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar Libro por Título y/o Autor
                    2 - Listar Libros Registrados
                    3 - Listar Autores Registrados
                    4 - Listar Autores Vivos en un determinado Año
                    5 - Listar Libros por Idioma

                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTituloAutor();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private DatosResultados getDatosResultados(){
        System.out.println("Escribe el título y/o autor del libro: ");
        var busqueda = teclado.nextLine();
        //System.out.println(busqueda);
        var json = consumoApi.obtenerDatos(URL_BASE + "/?search=" +
                busqueda.replace(" ","%20"));
        System.out.println("RESULTADO: " + json);
        DatosResultados datos = conversor.obtenerDatos(json, DatosResultados.class);
        System.out.println(datos);
        return datos;
    }

    private void buscarLibroPorTituloAutor(){
        DatosResultados datos = getDatosResultados();
        Resultados resultado = new Resultados(datos);
        System.out.println("RESULTADO: " + resultado);

    }


}
