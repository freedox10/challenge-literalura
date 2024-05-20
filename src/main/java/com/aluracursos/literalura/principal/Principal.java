package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;
import com.aluracursos.literalura.service.ConvierteDatosSelectivo;
import com.aluracursos.literalura.service.ConvierteDatosSelectivo2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private final Scanner teclado = new Scanner(System.in);
    // Instanciar un objeto ConsumoAPI
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    //private final String URL_BASE = "https://gutendex.com/books";
    // Instanciar un objeto ConvierteDatos
    private final ConvierteDatos conversor = new ConvierteDatos();
    //private ConvierteDatosSelectivo conversorSelectivo = new ConvierteDatosSelectivo();
    private final ConvierteDatosSelectivo2 conversorSelectivo2 = new ConvierteDatosSelectivo2();
    private final ContenedorResultados contenedor = new ContenedorResultados();


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
                        buscarResultados();
                        break;
                    case 0:
                        var salida = """
                                   Gracias por utilizar nuestro
                                           LITERALURA ;)
                            _by_----- Aplicación Finalizada -----_AAF_
                            """;
                        System.out.println(salida);
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            }

//            try{
//            (InputMismatchException e );
//            }catch (NumberFormatException e){
//                System.out.println("_-= No ingresó un monto numérico válido =-_");
//                //System.out.println(e.getMessage());
//            }catch (ConnectException |InputMismatchException e){
//                System.out.println("_-= Error de conexion =-_");
//            }

//            /* Validar Integer en entrada de teclado */
//            /*--------------------------------------------------------*/
//            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
//
//            Integer x = -1;/*instancia de Integer a la que asignamos
//                     el valor 0 para inicializarla.*/
//            do{
//                try {
//                    x = Integer.valueOf(teclado.readLine());
//                /*si consigue asignar a x el valor leido por
//                  teclado entonces con break paramos el
//                  do-while y devolvemos x, sino
//                  continuamos al catch.*/
//
//                    break;
//
//                }catch (NumberFormatException | IOException e) {
//                /*sino lo consigue entra aqui y mostramos el
//                  mensaje.*/
//                    System.out.println("debes introducir un
//                            numero entero");
//                }
//            /*como x desde el principio vale 0 es por tanto una
//              instancia de Integer, entonces repetimos el bucle,
//              así, hasta que Integer.valueOf() consiga asignar
//              un valor nuevo a x diferente al inicial que era 0,
//              entonces con break se saldra del bucle*/
//
//            }while(x instanceof Integer);
//            --------------------------------------------------------


    }

    private ContenedorResultados getResultados(String url){
        //System.out.println("url: " + url);
        var json = consumoApi.obtenerDatosAPI(url);
        //System.out.println("json: " + json);

        //ConvierteDatos conversor = new ConvierteDatos();
        DatosResultados datos = conversor.obtenerDatos(json, DatosResultados.class);
        //System.out.println("datos pagina: " + datos);
        Resultados resultado = new Resultados(datos);
        //System.out.println("resultado pagina: " + resultado);

        List<Libro> libros = conversorSelectivo2.obtenerDatosSelectivo2(json);

        contenedor.setInicial(resultado);
        contenedor.setPaginado(libros);

        return contenedor;

    }

    private void buscarResultados(){
        System.out.println("Escribe el título y/o autor del libro: ");
        var busqueda = teclado.nextLine();
        //System.out.println(busqueda);
        String url = "https://gutendex.com/books/?search=" + busqueda.replace(" ","%20");

        var resultado = getResultados(url).getInicial();
        var libros = getResultados(url).getPaginado();

        //System.out.println("libros: "+libros);
//        for (Libro libro : libros) {
//            System.out.println(libro);
//        }
        for(int i = 0; i < libros.size(); i++) {
            System.out.println(libros.get(i));
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
                    System.out.println();
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

                            resultado = getResultados(urlAnt).getInicial();
                            libros = getResultados(urlAnt).getPaginado();
//                            for (Libro libro : libros) {
//                                System.out.println(libro);
//                            }
                            for(int i = 0; i < libros.size(); i++) {
                                System.out.println(libros.get(i));
                            }

                            //resultado = get32ResultadosMenos(urlAnt);
                            //System.out.println("salida case 3: " + resultado);
                            break;
                        case 3:
                            System.out.println("_= listando 32 libros mas =_");
                            //System.out.println("urlProx case 3: " + resultado.getProximo());
                            String urlProx = resultado.getProximo();

                            resultado = getResultados(urlProx).getInicial();
                            libros = getResultados(urlProx).getPaginado();
//                            for (Libro libro : libros) {
//                                System.out.println(libro);
//                            }
                            for(int i = 0; i < libros.size(); i++) {
                                System.out.println(libros.get(i));
                            }

                            //resultado = get32ResultadosMas(urlProx);
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

}
