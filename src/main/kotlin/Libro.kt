package org.pebiblioteca

data class Libro(var id:String, private val autor:String, private val anioPublicacion:Int, private val tematica:String, var estado:String = "Disponible") {

    // Innit que comprueba que las entradas de la dataclass no sean ni nulas ni vacias
    init {
        require(autor.isNotBlank()){"El autor no puede ser nulo ni estar vacio"}//si es nulo o esta vacio, da error, lo mismo con las otras dos
        require(anioPublicacion>= 1){"El año de publicacion no puede ser menor que 1"}
        require(tematica.isNotBlank()){"La temática no puede ser nula ni estar vacia"}
        require(id.isNotBlank()){"El id no puede nulo ni ser vacio"}
    }
/**
 * Muestra el id del libro
 * @param libro Libro del que se muestra el id
 * */
    fun mostrarIdLibro(libro: Libro) = libro.id
    /**
     * Muestra el Autor del libro
     * @param libro Libro del que se muestra el autor
     * */
    fun mostrarAutorLibro(libro: Libro) = libro.autor
    /**
     * Muestra el año de publicacion del libro
     * @param libro Libro del que se muestra el año de publicacion
     * */
    fun mostrarAnioPublicacion(libro: Libro) = libro.anioPublicacion
    /**
     * Muestra la temática del libro
     * @param libro Libro del que se muestra la temática
     * */
    fun mostrarTematicaLibro(libro: Libro) = libro.tematica
    /**
     * Muestra el estado del libro
     * @param libro Libro del que se muestra el estado
     * */
    fun mostrarEstado(libro: Libro) = libro.estado



}