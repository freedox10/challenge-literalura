package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.List;
import java.util.Scanner;

public class BuscarResultadosAPI {
    private final Scanner teclado = new Scanner(System.in);
    // Instanciar un objeto ConsumoAPI
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    // Instanciar un objeto ConvierteDatos
    private final ConvierteDatos conversor = new ConvierteDatos();

    public void buscarResultados() {
        System.out.println("> Escribe el Título y/o el Autor del Libro <");
        var busqueda = teclado.nextLine();
        //System.out.println(busqueda);
        String url = "https://gutendex.com/books/?search=" + busqueda.replace(" ", "%20");

        var resultado = getResultados(url).getInicial();
        var libros = getResultados(url).getPaginado();
        //System.out.println("var libros"+libros);

        imprimeLibros(libros);

        String msg = "> Ingrese una opción <";
        var palabra2 = "";
        var palabra3 ="";
        var opcion3 = -1;

            int pagina = 1;
            int nroLibros = resultado.getCantidad();
            int librosPorPagina = libros.size();

            var msg2 = "  > " + nroLibros + " Libros encontrados < " + librosPorPagina + " mostrados > página " + pagina + " <";

            switch (nroLibros) {
                case 0:
                    var menu_1_0 = """
                        ----------------------------------------------->>
                                    -  Libro no encontrado  -
                        ----------------------------------------------->>""";
                    System.out.println(menu_1_0);
                    break;

                case 1:

                    var opcion2 = -1;
                    while (opcion2 != 0){

                        var menu_1_1 = """                            
                                        < 1 Libro encontrado >
                             1 - Registrar este Libro
                             2 - Mostrar de nuevo libro encontrado
                             0 - Menu principal
                            ----------------------------------------------->>""";
                        System.out.println(menu_1_1);
                        System.out.println(msg);

                        try {
                            palabra2 = teclado.nextLine();
                            opcion2 = Integer.parseInt(palabra2);

                            switch (opcion2) {
                                case 1:
                                    System.out.println("Aca va el metodo add libro");
                                    break;
                                case 2:
                                    imprimeLibros(libros);
                                    msg = "> Ingrese una opción <";
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("> Opción inválida <");
                                    msg = "> Opción inválida, prueve de nuevo <";
                            }

                        }catch (NumberFormatException e) {
                            //System.out.println("lanzó el NumberFormatException");
                            //e.printStackTrace();
                            msg = "> Ingrese números <";
                        }

                    }
                    break;

                default:
                    while (opcion3 != 0){

                        System.out.println(msg2);
                        System.out.println();

                        if (resultado.getAnterior() != null) {
                            System.out.println(" 1 - Ver 32 libros menos");
                        }
                        if (resultado.getProximo() != null) {
                            System.out.println(" 2 - Ver 32 libros mas");
                        }
                        System.out.println(" 3 - Listar de nuevo estos " + librosPorPagina + " libros");
                        System.out.println(" 4 - Registrar PRIMER LIBRO de la lista, ó -->");
                        System.out.println(" --> Escribe el >IdGut: del libro a registrar");
                        System.out.println(" 0 - Volver al menu principal");
                        System.out.println("----------------------------------------------->>");
                        System.out.println(msg);

                        try {
                            palabra3 = teclado.nextLine();
                            opcion3 = Integer.parseInt(palabra3);

                            switch (opcion3) {
                                case -2:
                                    System.out.println("* metodo para escribir id y registrar libro");
                                    break;
                                case 1:
                                    if (resultado.getAnterior() != null){
                                        System.out.println("_= listando 32 libros menos =_");
                                        //System.out.println("urlAnt case 3: " + resultado.getAnterior());
                                        String urlAnt = resultado.getAnterior();

                                        resultado = getResultados(urlAnt).getInicial();
                                        libros = getResultados(urlAnt).getPaginado();

                                        imprimeLibros(libros);
                                        pagina--;
                                        msg2 = "  > " + nroLibros + " Libros encontrados < " + librosPorPagina + " mostrados > página " + pagina + " <";
                                    } else {
                                        msg2 = "  > " + nroLibros + " Libros encontrados < ";
                                    }
                                    break;
                                case 2:
                                    if (resultado.getProximo() != null){
                                        System.out.println("_= listando 32 libros mas =_");
                                        //System.out.println("urlProx case 3: " + resultado.getProximo());
                                        String urlProx = resultado.getProximo();

                                        resultado = getResultados(urlProx).getInicial();
                                        libros = getResultados(urlProx).getPaginado();

                                        imprimeLibros(libros);
                                        pagina++;
                                        msg2 = "  > " + nroLibros + " Libros encontrados < " + librosPorPagina + " mostrados > página " + pagina + " <";
                                    } else {
                                        msg2 = "  > " + nroLibros + " Libros encontrados < ";
                                    }
                                    break;
                                case 3:
                                    imprimeLibros(libros);
                                    msg = "> Ingrese una opción <";
                                    msg2 = "  > " + nroLibros + " Libros encontrados < " + librosPorPagina + " mostrados > página " + pagina + " <";
                                    break;
                                case 4:
                                    System.out.println("* metodo para registrar libro *");
                                    break;
                                case 0:

                                    break;
                                default:

                                    msg = "> Opción inválida, prueve de nuevo <";
                                    msg2 = "  > " + nroLibros + " Libros encontrados < ";

                            }

                        } catch (NumberFormatException | NullPointerException e) {
                            //System.out.println("lanzó el NumberFormatException");
                            //e.printStackTrace();
                            msg = "> Ingrese números <";
                        }
                    }


            }

    }

    private ContenedorResultados getResultados(String url){
        //System.out.println("url: " + url);
        var json = consumoApi.obtenerDatosAPI(url);
        //System.out.println("json: " + json);

        DatosResultados datos = conversor.obtenerDatos(json, DatosResultados.class);
        //System.out.println("datos completos: " + datos);

        Resultados resultado = new Resultados(datos);
        System.out.println("resultado raíz Resultados: " + resultado);

        List<Libro> libros = resultado.getResultados().stream()
                .map(l->new Libro(l.idGut(), l.titulo(), l.autores(), l.idiomas(), l.cantidadBajadas()))
                .toList();
        System.out.println("ListaPrueba List<Libro>: " + libros);

        return new ContenedorResultados(resultado, libros);

    }

    private void imprimeLibros(List<Libro> librosPasados){

        librosPasados.forEach(System.out::println);

        //for (int i = 0; i < librosPasados.size(); i++) {
        //    System.out.println(librosPasados.get(i));
        //}
        //for (Libro librosPasados : librosPasados) {
        //    System.out.println(librosPasados);
        //}

    }

    private void registrarLibro(){

    }

}
