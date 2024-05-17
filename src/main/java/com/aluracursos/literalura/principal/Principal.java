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
    //private ConvierteDatos conversor = new ConvierteDatos();



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
        System.out.println(busqueda);
        var json = consumoApi.obtenerDatos(URL_BASE + "/?search=" +
                busqueda.replace(" ","%20"));
        System.out.println("RESULTADO: " + json);
        ConvierteDatos conversor = new ConvierteDatos();
        DatosResultados datos = conversor.obtenerDatos(json, DatosResultados.class);
        System.out.println(datos);
        return datos;
    }

    private Resultados get32ResultadosMas(String urlProx){
        System.out.println("urlProx en 32Mas: " + urlProx);
        var jsonProx = consumoApi.obtenerDatos(urlProx);
        System.out.println("jsonProx en 32Mas: " + jsonProx);
        ConvierteDatos conversor = new ConvierteDatos();
        DatosResultados datosProx = conversor.obtenerDatos(jsonProx, DatosResultados.class);
        System.out.println("datosProx en 32Mas: " + datosProx);
        Resultados resultadoProx = new Resultados(datosProx);
        System.out.println("resultadoProx en 32Mas: " + resultadoProx);
        return resultadoProx;
    }

    private Resultados get32ResultadosMenos(String urlAnt){
        System.out.println("urlAnt en 32Mas: " + urlAnt);
        var jsonAnt = consumoApi.obtenerDatos(urlAnt);
        System.out.println("jsonAnt en 32Mas: " + jsonAnt);
        ConvierteDatos conversor = new ConvierteDatos();
        DatosResultados datosAnt = conversor.obtenerDatos(jsonAnt, DatosResultados.class);
        System.out.println("datosAnt en 32Mas: " + datosAnt);
        Resultados resultadoAnt = new Resultados(datosAnt);
        System.out.println("resultadoAnt en 32Mas: " + resultadoAnt);
        return resultadoAnt;
    }

    private void registrarLibro(Resultados resultado){
        var opcion3 = -1;
        while (opcion3 != 0) {
            Integer nroLibros = resultado.getCantidad();
            if (nroLibros != 0) {
                if (nroLibros == 1) {
                    var opcion2 = -1;
                    opcion2 = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("1 - Registrar Libro");
                    System.out.println("0 - Menu principal");
                    switch (opcion2) {
                        case 1:
                            System.out.println("Aca va el metodo add libro");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                } else {
                    //var opcion3 = -1;
                    //while (opcion3 != 0) {
                    System.out.println("En Paginado: " + resultado);
                    System.out.println(resultado.getCantidad() + " Libros encontrados");
                    System.out.println("* Aca debería listar los libros y sus Ids *");
                    System.out.println("1 - Seleccionar por Id y registrar Libro");
                    if (resultado.getAnterior() != null) {
                        System.out.println("2 - Ver 32 libros menos");
                    }
                    if (resultado.getProximo() != null) {
                        System.out.println("3 - Ver 32 libros mas");
                    }
                    System.out.println(" ");
                    System.out.println("0 - volver menu principal");

                    opcion3 = teclado.nextInt();
                    teclado.nextLine();

                    switch (opcion3) {
                        case 1:
                            System.out.println("* metodo para seleccionar y registrar libro por id");
                            break;
                        case 2:
                            System.out.println("* devería listar 32 libros menos *");
                            System.out.println("urlAnt case 3: " + resultado.getAnterior());
                            String urlAnt = resultado.getAnterior();
                            resultado = get32ResultadosMenos(urlAnt);
                            System.out.println("salida case 3: " + resultado);
                            break;
                        case 3:
                            System.out.println("* intentando listar 32 libros mas *");
                            System.out.println("urlProx case 3: " + resultado.getProximo());
                            String urlProx = resultado.getProximo();
                            resultado = get32ResultadosMas(urlProx);
                            System.out.println("salida case 3: " + resultado);
                            break;
                        case 0:

                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                    //}
                }
            } else {
                System.out.println("Libro no encontrado");
            }
        }
    }

    private void buscarLibroPorTituloAutor(){
        DatosResultados datos = getDatosResultados();
        Resultados resultado = new Resultados(datos);
        System.out.println("CONVERTIDO: " + resultado);

        registrarLibro(resultado);

//        if (nroLibros != 0){
//            if (nroLibros == 1){
//                var opcion2 = -1;
//                opcion2 = teclado.nextInt();
//                teclado.nextLine();
//                System.out.println("1 - Registrar Libro");
//                System.out.println("0 - Menu principal");
//                switch (opcion2){
//                    case 1:
//                        System.out.println("Aca va el metodo add libro");
//                        break;
//                    case 0:
//                        break;
//                    default:
//                        System.out.println("Opción inválida");
//                }
//            } else {
//                var opcion3 = -1;
//                while (opcion3 != 0) {
//                    System.out.println(resultado.getCantidad() + " Libros encontrados");
//                    System.out.println("* Aca debería listar los libros y sus Ids *");
//                    System.out.println("1 - Seleccionar por Id y registrar Libro");
//                    if (resultado.getAnterior() != null){
//                        System.out.println("2 - Ver 32 libros menos" );
//                    }
//                    if (resultado.getProximo() != null){
//                        System.out.println("3 - Ver 32 libros mas" );
//                    }
//                    System.out.println(" ");
//                    System.out.println("0 - volver menu principal");
//
//                    opcion3 = teclado.nextInt();
//                    teclado.nextLine();
//
//                    switch (opcion3) {
//                        case 1:
//                            System.out.println("* metodo para seleccionar y registrar libro por id");
//                            break;
//                        case 2:
//                            System.out.println("* devería listar 32 libros menos *");
//                            break;
//                        case 3:
//                            System.out.println("* devería listar 32 libros mas *");
//                            get32ResultadosMas(resultado.getProximo());
//                            break;
//                        case 0:
//
//                            break;
//                        default:
//                            System.out.println("Opción inválida");
//                    }
//                }
//            }
//        }else {
//            System.out.println("Libro no encontrado");
//        }

        System.out.println("Fin método buscar por titulo y/o autor");

    }


}
