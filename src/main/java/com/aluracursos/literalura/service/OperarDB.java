package com.aluracursos.literalura.service;

import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OperarDB {

    @Autowired
    private LibroRepository repoLibro;
    @Autowired
    private AutorRepository repoAutor;

    public void registrarLibroDB(Libro libro) {
        Libro nuevoLibro;
        Libro libroDescubierto = repoLibro.buscarLibroPorIdGut(libro.getIdGut());
        //System.out.println("libroDescubierto: "+libroDescubierto);

        if (libroDescubierto == null){

            nuevoLibro = libro;
            System.out.println("nuevoLibro: "+nuevoLibro);

            repoLibro.save(nuevoLibro);

            System.out.println("-------------------- Libro --------------------<<");
            System.out.println("Titulo: " + nuevoLibro.getTitulo());
            System.out.println("Autor: " + nuevoLibro.getAutores().get(0).getNombre());
            System.out.println("                  "+nuevoLibro.getAutores().get(0).getanioNacimiento()+" - "+nuevoLibro.getAutores().get(0).getanioMuerte());
            System.out.println("-----------------------------------------------<<");
            System.out.println("               << Registrado <<");
            System.out.println("");
        } else {
            var msgNR = """
                    >>---------------------------------------------<<
                      >            No puede registrar            <
                      >       el mismo libro más de una vez      <
                    >>---------------------------------------------<<
                    """;
            System.out.println(msgNR);

        }
    }


    public void mostrarLibrosDB() {
        var libros = repoLibro.findAll();
        System.out.println();
        System.out.println("-----------  Libros Registrados "+libros.size()+" -------------<<");
        if (!libros.isEmpty()){
            libros.stream()
                    .sorted(Comparator.comparing(Libro::getTitulo))
                    .forEach(System.out::println);
        } else {
            System.out.println("       >  Aún no registró Libros  <");
        }
        System.out.println("-----------------------------------------------<<");
        System.out.println();
    }

    public void mostrarAutoresDB(){
        var autores = repoAutor.findAll();

        System.out.println();
        System.out.println("------------  Autores Registrados  ------------<<");
        if (!autores.isEmpty()){
        autores.stream()
                .sorted(Comparator.comparing(Autor::getNombre))
                .distinct()
                .forEach(System.out::println);
        }else {
            System.out.println("       >  Aún no registró Libros  <");
        }
        System.out.println("-----------------------------------------------<<");
        System.out.println();
    }

    public void mostrarAutoresVivosDB(int anio) {
        List<Autor> autores = repoAutor.encontrarAutoresVivos(anio);
        System.out.println();
        System.out.println("---------------  Autores Vivos  ---------------<<");
        System.out.println("                 - en "+anio+" -");
        if (!autores.isEmpty()){
            autores.forEach(System.out::println);
        } else {
            System.out.println("      >  No encontrados en el año "+ anio+"  <");
        }
        System.out.println("-----------------------------------------------<<");
        System.out.println();
    }

    public void mostrarLibrosPorIdioma(String idiomaBuscado) {
        var libros = repoLibro.findAllByIdiomasContaining(idiomaBuscado);
        //System.out.println("librosO: "+libros);
        System.out.println();
        System.out.println("-----------  Libros por Idioma "+idiomaBuscado+"  -----------<<");
        if (!libros.isEmpty()){
            libros.forEach(System.out::println);
        } else {
            System.out.println("        >  Libro no encontrado  <");
        }
        System.out.println("-----------------------------------------------<<");
        System.out.println();
    }

    public void mostrarTop10Libros(){
        var libros = repoLibro.buscarTop10Libros();
        //System.out.println("libros: "+libros);
        System.out.println();
        System.out.println("      >>  Top 10  <<");
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i+1)+"- "+libros.get(i).getCantidadBajadas()+" - "+libros.get(i).getTitulo());
        }
        //libros.forEach(System.out::println);
        System.out.println("-----------------------------------------------<<");
        System.out.println();
    }

    public void mostrarEstadisticas() {
        List<Libro> libro = repoLibro.findAll();

        ArrayList<Libro> libros2 = new ArrayList<Libro>(libro);

        DoubleSummaryStatistics datos = libros2.stream()
                .collect(Collectors.summarizingDouble(Libro::getCantidadBajadas));

        System.out.println("        >>  Descarga de Libros  <<" +
                        "\nMedia: " + String.format("%.2f", datos.getAverage()) +
                        "\nMayor: " + String.format("%.0f", datos.getMax()) +
                        "\nMenor: " + String.format("%.0f",datos.getMin()) +
                        "\nTotal: " + datos.getCount() + " libros registrados." +
                        "\n-----------------------------------------------<<");

//        //Using Collectors.summarizingInt()
//        IntSummaryStatistics intSummaryStatistics = employeeList
//                .stream()
//                .collect(Collectors.summarizingInt(Employee::getAge));
//        System.out.println("IntSummaryStatistics for age: " + intSummaryStatistics);
//
//        //Using Collectors.summarizingLong()
//        LongSummaryStatistics longSummaryStatistics = employeeList
//                .stream()
//                .collect(Collectors.summarizingLong(Employee::getLeaves));
//        System.out.println("LongSummaryStatistics for leaves: " + longSummaryStatistics);
//
//        //Using Collectors.summarizingDouble()
//        DoubleSummaryStatistics doubleSummaryStatistics = employeeList
//                .stream()
//                .collect(Collectors.summarizingDouble(Employee::getSalary));
//        System.out.println("DoubleSummaryStatistics for salary: " + doubleSummaryStatistics);

    }

}
