package org.pebiblioteca
/*
Programa Principal:

Instanciar una GestorBiblioteca:
Agregar al menos tres libros al catálogo.

Recomendación implementar un menú de usuario. Este menú incorporará todas las acciones posibles que se vayan incorporando al sistema, permitiendo al usuario interactuar de manera clara y eficaz y facilitar las pruebas.*/
fun main() {
    val libro1 = Libro("123123A","Elia",2019,"Comedia")
    val libro2 = Libro("123456A","Manuel",2001,"Miedo")
    val libro3 = Libro("123456789A","Tomás",2024, "Ficcion")
    val libro4 = Libro("123A","Pablo",3,"Horror")
    val libro5 = Libro("123444A","Jose",23,"Horror")
    val libro6 = Libro("080219","Lucia",2300,"Risa")

    val listalibro = mutableListOf<Libro>()// creamo la lista y añadimos los libros a la lista para pasarsela al gestor
    listalibro.add(libro1)
    listalibro.add(libro2)
    listalibro.add(libro3)
    listalibro.add(libro4)
    listalibro.add(libro5)
    listalibro.add(libro6)

//Realizar al menos dos préstamo y dos devoluciones. Tanto un préstamo, como una devolución tiene que ser errónea, debido al estado del libro.
//Mostrar el estado actual de los libros.

    val gestor = GestorBiblioteca(listalibro)
    //añadimos los 6 libros
    gestor.agregarLibro(libro1)
    gestor.agregarLibro(libro2)
    gestor.agregarLibro(libro3)
    gestor.agregarLibro(libro4)
    gestor.agregarLibro(libro5)
    gestor.agregarLibro(libro6)

    GestionConsola.mostrarInfo("\n")
    //Hacemos los prestamos con el ultimo prestamo erroneo
    gestor.registrarPrestamo(libro1)
    gestor.registrarPrestamo(libro2)
    gestor.registrarPrestamo(libro3)
    gestor.registrarPrestamo(libro4)
    gestor.registrarPrestamo(libro1)
    GestionConsola.mostrarInfo("\n")

    //hacemos las devoluciones con la ultima devolucion erronea
    gestor.devolverLibro(libro1)
    gestor.devolverLibro(libro2)
    gestor.devolverLibro(libro1)


    GestionConsola.mostrarLibros(gestor)


}

