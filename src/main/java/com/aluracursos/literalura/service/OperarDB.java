package com.aluracursos.literalura.service;

import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    public List<Autor> verificarAutores(List<Autor> autores){
        List<Autor> autoresVerificados = new ArrayList<>();
        for (Autor autorX : autores){
            Autor autor = repoAutor.buscarAutor(autorX.getNombre(), autorX.getanioNacimiento(), autorX.getanioMuerte());
            if (autor == null){
                autoresVerificados.add(new Autor(autorX.getNombre(), autorX.getanioNacimiento(), autorX.getanioMuerte()));
            } else {
                autoresVerificados.add(autor);
            }
        }
        return autoresVerificados;
    }

    public void mostrarLibrosDB() {
        var libros = repoLibro.findAll();
        libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .forEach(System.out::println);
    }

    public void mostrarAutoresDB(){
        var autores = repoAutor.findAll();
        System.out.println();
        autores.forEach(System.out::println);
        System.out.println("<<---------------------------------------------<<");
        System.out.println();
    }

    public void mostrarAutoresVivosDB(int anio) {
        List<Autor> autores = repoAutor.encontrarAutoresVivos(anio);
        System.out.println();
        autores.forEach(System.out::println);
        System.out.println("<<---------------------------------------------<<");
        System.out.println();
    }

    public void mostrarLibrosPorIdioma(String idiomaBuscado) {
        var libros = repoLibro.findAllByIdiomasContaining(idiomaBuscado);
        //System.out.println("librosO: "+libros);
        if (!libros.isEmpty()){
            System.out.println();
            libros.forEach(System.out::println);
            System.out.println("<<---------------------------------------------<<");
            System.out.println();
        } else {
            var msgIdioma = """
                              >  Libro por Idioma, no encontrado  <
                        >>---------------------------------------------<<""";
            System.out.println(msgIdioma);
        }
    }

}
