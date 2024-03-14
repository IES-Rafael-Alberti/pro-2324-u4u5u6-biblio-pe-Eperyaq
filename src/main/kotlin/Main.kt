package org.pebiblioteca

import java.util.*


fun main() {




    val libro1 = Libro("123123A","Elia",2019,"Comedia")
    val libro2 = Libro("123456A","Manuel",2001,"Miedo")
    val libro3 = Libro("123456789A","Tomás",2024, "Ficcion")
    val libro4 = Libro("123A","Pablo",3,"Horror")
    val libro5 = Libro("123444A","Jose",23,"Horror")
    val libro6 = Libro("080219E","Lucia",2300,"Risa")

    val listalibro = mutableListOf<Libro>()// creamo la lista y añadimos los libros a la lista para pasarsela al gestor
    listalibro.add(libro1)
    listalibro.add(libro2)
    listalibro.add(libro3)
    listalibro.add(libro4)
    listalibro.add(libro5)
    listalibro.add(libro6)

//Realizar al menos dos préstamo y dos devoluciones. Tanto un préstamo, como una devolución tiene que ser errónea, debido al estado del libro.
//Mostrar el estado actual de los libros.
    val idUnico = UtilidadesBiblioteca()
    val gestor = GestorBiblioteca(listalibro)
    //añadimos los 6 libros
    gestor.agregarLibro(libro1,idUnico)
    gestor.agregarLibro(libro2,idUnico)
    gestor.agregarLibro(libro3,idUnico)
    gestor.agregarLibro(libro4,idUnico)
    gestor.agregarLibro(libro5,idUnico)
    gestor.agregarLibro(libro6,idUnico)

    GestionConsola.mostrarInfo("\n")
    //Hacemos los prestamos con el ultimo prestamo erroneo
    gestor.registrarPrestamo(libro1)
    gestor.registrarPrestamo(libro2)
    gestor.registrarPrestamo(libro3)
    gestor.registrarPrestamo(libro4)
    gestor.registrarPrestamo(libro1)
    GestionConsola.mostrarInfo("\n")

    //hacemos las devoluciones con la ultima devolucion erroneae
    gestor.devolverLibro(libro1)
    gestor.devolverLibro(libro2)
    gestor.devolverLibro(libro1)

    GestionConsola.mostrarLibros(gestor)





}

