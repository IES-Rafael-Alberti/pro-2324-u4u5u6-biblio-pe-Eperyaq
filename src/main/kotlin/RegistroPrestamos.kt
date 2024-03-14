package org.pebiblioteca
/*
Clase RegistroPrestamos: Ten en cuenta que tienes que refactorizar, porque posiblemente ya tengas algo para registrar los prestamos.
Propiedades:
Mantendrá los registros de los prestamos actuales.
Además, mantendra un historial de todos los préstamos realizados.
Métodos:
Registrar un préstamo.
Devolver un libro.
Consultar el historial de préstamos de un libro específico.
Consultar el historial de préstamos de un usuario específico.
*/
class RegistroPrestamos {
    val registroPrestamosActuales = mutableListOf<Libro>() //lista de libros NO disponibles
    val historialPrestamos = mutableListOf<Libro>() //Historial de los prestamos



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



    fun devolverLibro(libro: Libro){
        //si el libro NO esta en el catalogo lo devuelve y por tanto cambia el valor a disponible
        //Se borra de la lista de registros y se añade a la de catalogo de nuevo
        if (!consultarLibro(libro)){
            libro.mostrarEstado(libro) == "Disponible"
            registroPrestamosActuales.remove(libro)
        }else{
            GestionConsola.mostrarInfo("El libro ya estaba disponible")
        }
    }

}