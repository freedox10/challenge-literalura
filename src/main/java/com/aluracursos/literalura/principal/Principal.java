package com.aluracursos.literalura.principal;


import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    // Instanciar un objeto Scanner
    private final Scanner teclado = new Scanner(System.in);
    // Instanciar un objeto ContenedorResultados
    @Autowired
    private final BuscarResultadosAPI buscarResultadosAPI = new BuscarResultadosAPI();
    @Autowired
    private LibroRepository repoLibro;
    private List<Libro> libros;
    //private Libro libro;

//    public Principal() {
//    }

    public Principal(LibroRepository repoLibro) {
        this.repoLibro = repoLibro;
    }

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
                        libroEncontrado = buscarResultadosAPI.buscarResultados();
                        if (libroEncontrado != null){
                            registrarLibroDB(libroEncontrado);
                            System.out.println("-------------------- Libro --------------------<<");
                            System.out.println("Titulo: " + libroEncontrado.getTitulo());
                            System.out.println("Autor: " + libroEncontrado.getAutores().get(0).getNombre());
                            System.out.println("                  "+libroEncontrado.getAutores().get(0).getanioNacimiento()+" - "+libroEncontrado.getAutores().get(0).getanioMuerte());
                            System.out.println("-----------------------------------------------<<");
                            System.out.println("               << Registrado <<");
                            System.out.println("");
                        }
                        msg = "> Ingrese una opción <";
                        break;
                    case 2:
                        mostrarLibrosDB();
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

    private void mostrarLibrosDB() {
        libros = repoLibro.findAll();
        libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .forEach(System.out::println);
    }

    private void registrarLibroDB(Libro libro) {
        System.out.println("registrarLibroDB"+libro);
        repoLibro.save(libro);

    }

    private  void mostrarAutoresDB(){

    }

}

