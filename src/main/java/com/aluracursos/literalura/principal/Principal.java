package com.aluracursos.literalura.principal;


import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.service.OperarEnDB;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    // Instanciar un objeto Scanner
    private final Scanner teclado = new Scanner(System.in);
    // Instanciar un objeto ContenedorResultados
    private final BuscarResultadosAPI buscarResultadosAPI = new BuscarResultadosAPI();
    private OperarEnDB operarEnDB = new OperarEnDB();
    @Autowired
    private LibroRepository repoLibro;
    private List<Libro> libros;


    public void muestraElMenu() {
        String msg = "> Ingrese una opción <";
        var palabra = "";
        var opcion = -1;
        while (opcion !=0){
            var menu = """
                                 _=' LITERALURA '=_
                    ===============================================>>
                     1 - Buscar Libro por Título y/o Autor
                     2 - Listar Libros Registrados
                     3 - Listar Autores Registrados
                     4 - Listar Autores Vivos en un determinado Año
                     5 - Listar Libros por Idioma
                     0 - Salir                        AAF+ONE+Alura
                    ===============================================>>""";
            System.out.println(menu);
            System.out.println(msg);
            try {
                palabra = teclado.nextLine();
                opcion = Integer.parseInt(palabra);

                switch (opcion) {
                    case -2:
                        libros = repoLibro.findAll();
                        libros.stream()
                                .sorted(Comparator.comparing(Libro::getIdGut))
                                .forEach(System.out::println);

                        //List<Libro> librosEnDB = repoLibro.findAll();
                        //System.out.println("librosEnDB: "+librosEnDB);
                    case 1:
                        buscarResultadosAPI.buscarResultados();
                        msg = "> Ingrese una opción <";
                        break;
                    case 0:
                        var salida = """
                            >>=============================================<<
                                       Gracias por utilizar nuestra
                                              LITERALURA ;)
                            _by_-----     Aplicación Finalizada    -----_AAF_
                            >>=============================================<<
                            """;
                        System.out.println(salida);
                        break;
                    default:
                        msg = "> Opción inválida, prueve de nuevo <";
                }

            } catch (NumberFormatException e) {
                //System.out.println("lanzó el NumberFormatException");
                //e.printStackTrace();
                msg = "> Ingrese números <";
            }

        }

    }

}

