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
    val registro = RegistroPrestamos()
    val usuario = Usuario("123A","Ernesto")
    val usuario2 = Usuario("1234A","Lolo")
    val usuario3 = Usuario("12345A","Fran")

    //añadimos los 6 libros
    gestor.agregarLibro(libro1,idUnico)
    gestor.agregarLibro(libro2,idUnico)
    gestor.agregarLibro(libro3,idUnico)
    gestor.agregarLibro(libro4,idUnico)
    gestor.agregarLibro(libro5,idUnico)
    gestor.agregarLibro(libro6,idUnico)

    GestionConsola.mostrarInfo("\n")


    //MENU--> GestionConsola.mostrarLibros(gestor)
    //prestamos los 3 libros para probar el historial de una persona
    usuario.agregarLibroPrestado(libro1)
    usuario.agregarLibroPrestado(libro2)
    usuario.agregarLibroPrestado(libro3)


    //prestamos 3 libros dentro de la clase registro
    // para probar el historial del libro y las devoluciones
    registro.registrarPrestamo(libro4,gestor)
    registro.registrarPrestamo(libro5,gestor)
    registro.registrarPrestamo(libro6,gestor)

    //Devolucion
    registro.devolverLibro(libro4,gestor)
    registro.devolverLibro(libro5, gestor)

    //Historiales
    //hay que llamar a registro para que este meta los datos en la lista
    registro.historialUsuario(usuario)
    registro.historialLibro(libro4)
    GestionConsola.mostrarInfo("${registro.historialPrestamos}")


/*
* Crear instancias de varios usuarios y realizar operaciones de préstamo y devolución utilizando el sistema modificado.
Utilizar la clase GestorBiblioteca, que hará uso de RegistroPrestamos, para realizar las operaciones de prestamos y devolución y mostrar el historial de préstamos y devoluciones.
Demostrar cómo se puede acceder a la información de los libros y usuarios de manera controlada a través de los métodos públicos sin exponer directamente las propiedades internas.*/



}

