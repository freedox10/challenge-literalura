![Imagen de Encabezado](https://github.com/freedox10/challenge-literalura/blob/main/img/Alura%20-%20ONE%20JAVA%20SpringBoot-modified-modified.webp?raw=true)
# Challenge LITERALURA
## _ONE - Alura - AAF_
### Java - SpringBoot - BackEnd - G6

Aplicación de Consola para consulta y registro de Libros a partir de la API Web Gutendex.

>2024-05-16
>>_Iniciando creación de Literalura como desafío al trayecto de formación Backend de Oracle Next Education y Alura Cursos.
Analizo los requisititos del Challenge, busco las herramientas necesarias, comienzo las pruebas de la API propuesta, implemento primeros pasos de mi aplicación java con Spring Initializr._
>
>2024-05-17
>>_Prueba de estructura de resultados API, formato JSON,
>creando logica general y en particular paginado de busqueda multiple en API._
>
>2024-05-20
>>_Trabaja validaciones en datos de entrada y flexibilidad de uso de las distintas opciones propuestas,
>aplico compresión y conversión de resultados usando la dependencia Jackson (Json -> Objetos)_
>
>2024-05-22
>>_Vinculación a Base de Datos, opciones de uso de JPA_
>
>2024-05-24
>>_Trabaja opciones de manejo BD con HQL._
>
>2024-05-28
>>_Muchas mejoras en interface, funcionalidades, manejo de errores y optimización de código._
>
>2024-05-29
>>_Versión 1.0 Operativa de mi Literalura._

## Características:
- Consulta y registro (persistencia en BD) de Libros a la API web Gutendex.
- Manejo de datos en DB como listados, top 10, estadísticas.
![Imagen del menú de Códigos](https://github.com/freedox10/challenge-literalura/blob/main/img/0-Menu.webp?raw=true)
## Característica Adicional:
- Manejo de consultas extendidas ante resultados múltiples mayores a uno.
- Presentación de resultados en paginado cada 32 libros.
![Imagen del Menú Literalura](https://github.com/freedox10/challenge-literalura/blob/main/img/0-Menu.webp?raw=true)
- Un resultado
![Imagen del menú un Libro Encontrado](https://github.com/freedox10/challenge-literalura/blob/main/img/1-1-Libro.webp?raw=true)
- varios resultados
![Imagen del menú de Libros Encontrados](https://github.com/freedox10/challenge-literalura/blob/main/img/1-N-Libros.webp?raw=true)

## Modo de Uso:
### Seleccionar una opción del Menú
![Imagen del menú de Códigos](https://github.com/freedox10/challenge-literalura/blob/main/img/0-Menu.webp?raw=true)
#### 1 - ingresar titulo y/o autor por Libro:
         recibirá respuesta de la API, las cuales pueden ser:
              nula: Libro no encontrado
              única: un Libro encontrado,
                     lo puede registrar, mostrar de nuevo o
                     puede salir sin registrar.
              multiple: se listaran los 32 primeros Libros,
                        puede registrar el primer Libro, o registrar por IdGut,
                        puede listar de nuevo estos 32 libros o,
                        puede pasar a la pagina siguiente, o
                        eventualemente a la anterior, o
                        puede salir sin registrar.
#### 2 - elija para listar Libros registrados:
    devuelve lista de Libros registrados en BD.
#### 3 - elija para listar Autores registrados:
    devuelve lista de Autores registrados en BD.
#### 4 - elija un año para listar Autores vivos en ese año:
    ingrese año a buscar:
           devuelve lista de Autores registrados en BD vivos en el año seleccionado.
#### 5 - elija para listar Libros por Idioma registrados :
    ingrese idioma de busqueda:
           devuelve lista de libros registrados en BD por idioma seleccionado.
#### 6 - elija para listar Top 10 Libros mas bajados:
    devuelve lista de Top 10 Libros mas bajados registrados en BD.
#### 7 - elija para mostrar estadísticas:
    devuelve datos estadísticos de Libros en BD.
#### 0 - elija para salir de aplicación:
    sale del menú y termina la aplicación.
![Imagen de mensaje de despedida](https://github.com/freedox10/challenge-literalura/blob/main/img/0-Salir.webp?raw=true)

## Otras Caracteristicas:

* Validación de datos ingresados por teclado
* Distintos mensajes para incorrectos en menú y submenús

## Tecnologías
#### Spring: JAVA 17 - Maven - SpringBoot 3.2.5 - Jar
#### IDE: IntelliJ 2024.1 CE
#### Servidor BD: PostGreSQL 4
| Dependencias |  |
|--|--|
| API Gutendex: | https://gutendex.com/ |
| Spring Data JPA: | https://start.spring.io/ |
| PostgreSQL Driver: | https://start.spring.io/ |
| Jackson Databind 2.16.0 | https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind |

# _by **AAF**_
