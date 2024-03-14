package org.pebiblioteca

class RegistroPrestamos {
    val registroPrestamosActuales = mutableListOf<Libro>() //lista de libros NO disponibles los que se han prestado
    val historialPrestamos = mutableMapOf<String, MutableList<Libro>>() //Historial de los prestamos



    /**
     * Realizas un prestamo de un libro y cambias el estado de este
     * @param libro libro que se va a prestar
     */
    fun registrarPrestamo(libro: Libro, gestor:GestorBiblioteca){
        //Si el libro está en el catalogo se cambia el valor a no disponible
        if (gestor.consultarLibro(libro)){
            libro.mostrarEstado(libro) == "No Disponible"

            registroPrestamosActuales.add(libro)

        }else{
            GestionConsola.mostrarInfo("El libro no está disponible")
        }
    }


    /**
     * Devuelves un libro
     * @param libro Libro a devolver
     * @param gestor Gestor necesario para comprobar el libro
     */
    fun devolverLibro(libro: Libro,gestor: GestorBiblioteca){
        //si el libro NO esta en el catalogo lo devuelve y por tanto cambia el valor a disponible
        //Se borra de la lista de registros y se añade a la de catalogo de nuevo
        if (libro in registroPrestamosActuales){
            libro.estado= "Disponible"
            registroPrestamosActuales.remove(libro)
            GestionConsola.mostrarInfo("Libro Devuelto con éxito")
        }else{
            GestionConsola.mostrarInfo("El libro ya estaba disponible")
        }
    }

    /**
     * funcion que introduce datos dentro de la lista del historial
     * @param usuario usuario al que se le va a mirar el historial
     */
    fun historialUsuario(usuario: Usuario){
        historialPrestamos[usuario.id] = usuario.listaLibrosPrestados
    }
    /**
     * funcion que introduce datos dentro de la lista del historial
     * @param libro Libro al que se le va a mirar el historial
     * @param gestor Gestor necesario para mirar la lista de los libros
     */
    fun historialLibro(libro: Libro){
        historialPrestamos[libro.id] = registroPrestamosActuales
    }

}