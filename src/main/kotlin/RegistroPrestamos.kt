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

    /**
     * Compruebas si un libro está en el catalogo
     * @param libro libro que se está consultando si esta
     */
    fun consultarLibro(libro: Libro):Boolean = libro in catalogoLibros //Si el libro está en el catalogo da true si no esta, false

    /**
     * Realizas un prestamo de un libro y cambias el estado de este
     * @param libro libro que se va a prestar
     */
    fun registrarPrestamo(libro: Libro){
        //Si el libro está en el catalogo se cambia el valor a no disponible
        //Se borra de la lista de catalogos y se mete en la lista de registros todavia no
        if (consultarLibro(libro)){
            libro.mostrarEstado(libro) == "No Disponible"

            catalogoLibros.remove(libro)
            registroPrestamos.add(libro)

        }else{
            GestionConsola.mostrarInfo("El libro no está disponible")
        }
    }



    fun devolverLibro(libro: Libro){
        //si el libro NO esta en el catalogo lo devuelve y por tanto cambia el valor a disponible
        //Se borra de la lista de registros y se añade a la de catalogo de nuevo
        if (!consultarLibro(libro)){
            libro.mostrarEstado(libro) == "Disponible"
            registroPrestamos.remove(libro)
            catalogoLibros.add(libro)
        }else{
            GestionConsola.mostrarInfo("El libro ya estaba disponible")
        }
    }

}