package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.DatosLibro;
import com.aluracursos.literalura.model.DatosResultados;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.model.Resultados;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;
import com.aluracursos.literalura.service.ConvierteDatosSelectivo;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    // Instanciar un objeto ConsumoAPI
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books";
    // Instanciar un objeto ConvierteDatos
    private ConvierteDatos conversor = new ConvierteDatos();
    private ConvierteDatosSelectivo conversorSelectivo = new ConvierteDatosSelectivo();


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
//                    System.out.println("Escribe el título y/o autor del libro: ");
//                    var busqueda = teclado.nextLine();
//                    //System.out.println(busqueda);
//                    String url1 = URL_BASE + "/?search=" + busqueda.replace(" ","%20");
                    buscarResultados();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private String getDatosJson(String url){
        //System.out.println("Escribe el título y/o autor del libro: ");
        //var busqueda = teclado.nextLine();
        //System.out.println(busqueda);
        var json = consumoApi.obtenerDatosAPI(url);
        //System.out.println("Salida getDatosJson: " + json);
        return json;
    }

    private Resultados getConvertirResultados(String json){
        DatosResultados datos = conversor.obtenerDatos(json, DatosResultados.class);
        //System.out.println(datos);
        Resultados resultado = new Resultados(datos);
        //System.out.println("CONVERTIDO: " + resultado);
        return resultado;
    }

    private List<DatosLibro> getConvertirSelectivo(String json){
        List<DatosLibro> datosLibros = conversorSelectivo.obtenerDatosLibros(json);
        return datosLibros;
    }

    private Resultados get32ResultadosMenos(String urlAnt){
        //System.out.println("urlAnt en 32Mas: " + urlAnt);
        var jsonAnt = consumoApi.obtenerDatosAPI(urlAnt);
        //System.out.println("jsonAnt en 32Mas: " + jsonAnt);

        //ConvierteDatos conversor = new ConvierteDatos();
        DatosResultados datosAnt = conversor.obtenerDatos(jsonAnt, DatosResultados.class);
        //System.out.println("datosAnt en 32Mas: " + datosAnt);

        Resultados resultadoAnt = new Resultados(datosAnt);
        //System.out.println("resultadoAnt en 32Mas: " + resultadoAnt);

        List<DatosLibro> datosLibros = conversorSelectivo.obtenerDatosLibros(jsonAnt);
        for(int i = 0; i < datosLibros.size(); i++) {
            System.out.println(datosLibros.get(i));
        }

        return resultadoAnt;
    }

    private Resultados get32ResultadosMas(String urlProx){
        //System.out.println("urlProx en 32Mas: " + urlProx);
        var jsonProx = consumoApi.obtenerDatosAPI(urlProx);
        //System.out.println("jsonProx en 32Mas: " + jsonProx);

        //ConvierteDatos conversor = new ConvierteDatos();
        DatosResultados datosProx = conversor.obtenerDatos(jsonProx, DatosResultados.class);
        //System.out.println("datosProx en 32Mas: " + datosProx);

        Resultados resultadoProx = new Resultados(datosProx);
        //System.out.println("resultadoProx en 32Mas: " + resultadoProx);

        List<DatosLibro> datosLibros = conversorSelectivo.obtenerDatosLibros(jsonProx);
        for(int i = 0; i < datosLibros.size(); i++) {
            System.out.println(datosLibros.get(i));
        }

        return resultadoProx;
    }


    private void buscarResultados(){
        System.out.println("Escribe el título y/o autor del libro: ");
        var busqueda = teclado.nextLine();
        //System.out.println(busqueda);
        String url = URL_BASE + "/?search=" + busqueda.replace(" ","%20");

        String json = getDatosJson(url);

        Resultados resultado = getConvertirResultados(json);

        List<DatosLibro> datosLibros = getConvertirSelectivo(json);

        for(int i = 0; i < datosLibros.size(); i++) {
            System.out.println(datosLibros.get(i));
        }
        //System.out.println(datosLibros.toString());


        var opcion3 = -1;
        while (opcion3 != 0) {
            Integer nroLibros = resultado.getCantidad();
            switch (nroLibros){
                case 0:
                    System.out.println("Libro no encontrado");
                    System.out.println(" ");
                    opcion3 = 0;
                    break;

                case 1:
                    System.out.println("    1 Libro encontrado");
                    System.out.println("1 - Registrar este Libro");
                    System.out.println("0 - Menu principal");
                    var opcion2 = -1;
                    opcion2 = teclado.nextInt();
                    teclado.nextLine();
                    switch (opcion2) {
                        case 1:
                            System.out.println("Aca va el metodo add libro");
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                    opcion3 = 0;
                    break;

                default:
                    System.out.println(resultado.getCantidad()
                            + " Libros encontrados, 32 mostrados");
                    System.out.println("");
                    System.out.println("--> Escribe el IdGut del libro a registrar");

                    if (resultado.getAnterior() != null) {
                        System.out.println("2 - Ver 32 libros menos");
                    }
                    if (resultado.getProximo() != null) {
                        System.out.println("3 - Ver 32 libros mas");
                    }
                    System.out.println("0 - volver menu principal");

                    opcion3 = teclado.nextInt();
                    teclado.nextLine();

                    switch (opcion3) {
                        case 1:
                            System.out.println("* metodo para escribir id y registrar libro");
                            break;
                        case 2:
                            System.out.println("_= listando 32 libros menos =_");
                            //System.out.println("urlAnt case 3: " + resultado.getAnterior());
                            String urlAnt = resultado.getAnterior();
                            resultado = get32ResultadosMenos(urlAnt);
                            //System.out.println("salida case 3: " + resultado);
                            break;
                        case 3:
                            System.out.println("_= listando 32 libros mas =_");
                            //System.out.println("urlProx case 3: " + resultado.getProximo());
                            String urlProx = resultado.getProximo();
                            resultado = get32ResultadosMas(urlProx);
                            //System.out.println("salida case 3: " + resultado);
                            break;
                        case 0:

                            break;
                        default:
                            System.out.println("Opción inválida");
                    }

            }

        }

        System.out.println("Fin método Buscar Libro");
        System.out.println(" ");

    }





    // Crear método registrarLibro

    //Crear método listar los libros y sus Ids

}
