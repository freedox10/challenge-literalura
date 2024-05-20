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
    private BuscarResultadosAPI buscarResultadosAPI = new BuscarResultadosAPI();


    public void muestraElMenu() {
        String msg = "Ingrese una opción";
        var palabra = "";
        var opcion = -1;
        while (opcion !=0){
            var menu = """
                    1 - Buscar Libro por Título y/o Autor
                    2 - Listar Libros Registrados
                    3 - Listar Autores Registrados
                    4 - Listar Autores Vivos en un determinado Año
                    5 - Listar Libros por Idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            System.out.println(msg);
            try {
                palabra = teclado.nextLine();
                opcion = Integer.parseInt(palabra);

                switch (opcion) {
                    case 1:
                        buscarResultadosAPI.buscarResultados();
                        //buscarResultados();
                        msg = "Ingrese una opción";
                        break;
                    case 0:
                        var salida = """
                                   Gracias por utilizar nuestra
                                           LITERALURA ;)
                            _by_----- Aplicación Finalizada -----_AAF_
                            """;
                        System.out.println(salida);
                        break;
                    default:
                        msg = "Opción inválida, prueve de nuevo";
                }

            } catch (NumberFormatException e) {
                //System.out.println("lanzó el InputMismatchException");
                msg = "Ingrese números";
            }
        }
    }

    // Crear método registrarLibro

}
