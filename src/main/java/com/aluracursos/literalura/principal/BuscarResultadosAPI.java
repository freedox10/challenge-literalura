package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;
import com.aluracursos.literalura.service.ConvierteDatosSelectivo;
import com.aluracursos.literalura.service.ConvierteDatosSelectivoPuro;

import java.util.List;
import java.util.Scanner;

public class BuscarResultadosAPI {
    private final Scanner teclado = new Scanner(System.in);
    // Instanciar un objeto ConsumoAPI
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    // Instanciar un objeto ConvierteDatos
    private final ConvierteDatos conversor = new ConvierteDatos();
    // Instanciar un objeto ConvierteDatosSelectivo
    //private final ConvierteDatosSelectivo conversorSelectivo = new ConvierteDatosSelectivo();
    private final ConvierteDatosSelectivoPuro convierteDatosSelectivoPuro = new ConvierteDatosSelectivoPuro();
    // Instanciar un objeto ContenedorResultados
    private final ContenedorResultados contenedor = new ContenedorResultados();

    public void buscarResultados() {
        System.out.println("Escribe el título y/o autor del libro: ");
        var busqueda = teclado.nextLine();
        //System.out.println(busqueda);
        String url = "https://gutendex.com/books/?search=" + busqueda.replace(" ", "%20");

        var resultado = getResultados(url).getInicial();
        var libros = getResultados(url).getPaginado();
        //System.out.println("var libros"+libros);

        imprimeLibros(libros);

        //for (int i = 0; i < libros.size(); i++) {
        //    System.out.println(libros.get(i));
        //}
        //for (Libro libro : libros) {
        //    System.out.println(libro);
        //}
        //System.out.println(libro.toString());

        String msg = "Ingrese una opción";
        var palabra = "";
        var palabra2 ="";
        var opcion3 = -1;
        while (opcion3 != 0) {

            int mostrados;
            int nroLibros = resultado.getCantidad();
            if (nroLibros<32){
                mostrados = nroLibros;
            }else {
                mostrados = 32;
            }
            var msg2 = "  > " + nroLibros + " Libros encontrados < " + mostrados + " mostrados >";
            var msg3 = "--> Escribe el IdGut del libro a registrar";

            switch (nroLibros) {
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
                    System.out.println(msg2);
                    System.out.println();

                    if (resultado.getAnterior() != null) {
                        System.out.println("1 - Ver 32 libros menos");
                    }
                    if (resultado.getProximo() != null) {
                        System.out.println("2 - Ver 32 libros mas");
                    }
                    System.out.println("3 - Listar de nuevo estos 32 libros");
                    System.out.println("0 - volver menu principal");

                    System.out.println(msg3);
                    System.out.println(msg);

                    try {
                        palabra = teclado.nextLine();
                        opcion3 = Integer.parseInt(palabra);

                        switch (opcion3) {
                            case -2:
                                System.out.println("* metodo para escribir id y registrar libro");
                                break;
                            case 1:
                                System.out.println("_= listando 32 libros menos =_");
                                //System.out.println("urlAnt case 3: " + resultado.getAnterior());
                                String urlAnt = resultado.getAnterior();

                                resultado = getResultados(urlAnt).getInicial();
                                libros = getResultados(urlAnt).getPaginado();
                                //for (Libro libro : libros) {
                                //    System.out.println(libro);
                                //}
                                for (int i = 0; i < libros.size(); i++) {
                                    System.out.println(libros.get(i));
                                }

                                //System.out.println("salida case 3: " + resultado);
                                break;
                            case 2:
                                System.out.println("_= listando 32 libros mas =_");
                                //System.out.println("urlProx case 3: " + resultado.getProximo());
                                String urlProx = resultado.getProximo();

                                resultado = getResultados(urlProx).getInicial();
                                libros = getResultados(urlProx).getPaginado();
                                //for (Libro libro : libros) {
                                //    System.out.println(libro);
                                //}
                                for (int i = 0; i < libros.size(); i++) {
                                    System.out.println(libros.get(i));
                                }

                                //System.out.println("salida case 3: " + resultado);
                                break;
                            case 3:
                                for (int i = 0; i < libros.size(); i++) {
                                    System.out.println(libros.get(i));
                                }
                                msg2 = "  > " + nroLibros + " Libros encontrados < 32 mostrados >";
                                msg3 = "--> Escribe el IdGut del libro a registrar";
                            case 0:

                                break;
                            default:
//                                for (int i = 0; i < contenedor.getPaginado().size(); i++) {
//
//                                }
                                // Metodo para seleccionar y registrar por IdGut

                                msg = "Opción inválida, prueve de nuevo";
                                msg2 = "";
                                msg3 = "--> Escribe el IdGut del libro a registrar";

                        }

                    } catch (NumberFormatException e) {
                        //System.out.println("lanzó el NumberFormatException");
                        //e.printStackTrace();
                        msg = "Ingrese números";
                    }


            }

        }
    }

    private ContenedorResultados getResultados(String url){
        //System.out.println("url: " + url);
        var json = consumoApi.obtenerDatosAPI(url);
        //System.out.println("json: " + json);

        DatosResultados datos = conversor.obtenerDatos(json, DatosResultados.class);
        //System.out.println("datos pagina: " + datos);
        Resultados resultado = new Resultados(datos);
        //System.out.println("resultado pagina: " + resultado);

        List<DatosLibro> listaDatosLibros = convierteDatosSelectivoPuro.obtenerDatosSelectivoPuro(json);
        //System.out.println("List<DatosLibro> listaDatosLibros" + listaDatosLibros);

        List<Libro> listaLibros = convierteDatosSelectivoPuro.convierteListaDLaListaL(listaDatosLibros);
        //System.out.println("List<Libro> listaLibros" + listaLibros);

        contenedor.setInicial(resultado);
        contenedor.setPaginado(listaLibros);

        return contenedor;

    }

    private void imprimeLibros(List<Libro> librospasados){

        for (int i = 0; i < librospasados.size(); i++) {
            System.out.println(librospasados.get(i));
        }
        //for (Libro librospasados : librospasados) {
        //    System.out.println(librospasados);
        //}
        //System.out.println(librospasados.toString());

    }

}
