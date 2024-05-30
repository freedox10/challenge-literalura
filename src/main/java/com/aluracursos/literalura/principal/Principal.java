package com.aluracursos.literalura.principal;


import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.service.OperarDB;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    // Instanciar un objeto Scanner
    private final Scanner teclado = new Scanner(System.in);
    @Autowired
    private final BuscarResultadosAPI buscarResultadosAPI = new BuscarResultadosAPI();
    @Autowired
    private OperarDB serviciosDB;
    @Autowired
    private LibroRepository repoLibro;
    @Autowired
    private AutorRepository repoAutor;
    private List<Libro> libros;

    public Principal() {
    }

    public Principal(OperarDB serviciosDB) {
        this.serviciosDB = serviciosDB;
    }

    //    public Principal(LibroRepository repoLibro) {
//        this.repoLibro = repoLibro;
//    }

    public void muestraElMenu() {
        Libro libroEncontrado;
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

                        break;
                    case 1:
                        buscarLibro();
                        msg = "> Ingrese una opción <";
                        break;
                    case 2:
                        serviciosDB.mostrarLibrosDB();
                        msg = "> Ingrese una opción <";
                        break;
                    case 3:
                        serviciosDB.mostrarAutoresDB();
                        break;
                    case 4:
                        listarAutoresVivos();
                        break;
                    case 5:
                        listarLibroPorIdioma();
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

    private void buscarLibro(){
        var libroEncontrado = buscarResultadosAPI.buscarResultados();
        if (libroEncontrado != null){
            serviciosDB.registrarLibroDB(libroEncontrado);
        }

    }

    private void listarAutoresVivos() {
        System.out.println("Ingresa año desde el que deseas encontrar autores vivos");
        int anio = Integer.parseInt(teclado.nextLine());
        System.out.println("----------------------------------------------->>");
        serviciosDB.mostrarAutoresVivosDB(anio);
    }

    private void listarLibroPorIdioma() {
        System.out.println("Ingresa el idioma de los libros que desea listar");
        System.out.println("es - Español     en - Inglés\nfr - Francés     pt - Portugués\nde - Alemán     fi - Finlandes");
        var loop = "";
        while(loop!="salir"){
            String lenguaje = teclado.nextLine().toLowerCase();
            if (lenguaje.equals("es") | lenguaje.equals("en") | lenguaje.equals("fr")
                    | lenguaje.equals("pt") | lenguaje.equals("de") | lenguaje.equals("fi")){
                System.out.println("----------------------------------------------->>");
                serviciosDB.mostrarLibrosPorIdioma(lenguaje);

                loop = "salir";
            } else {
                System.out.println("> Opción inválida, prueve de nuevo <");

            }

        }

    }

}

