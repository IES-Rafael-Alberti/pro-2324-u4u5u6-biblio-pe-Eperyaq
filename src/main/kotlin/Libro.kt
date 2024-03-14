package org.pebiblioteca


/*

Clase Libro: solo contendrá datos, sin ninguna lógica asociada.
Algunos de los datos que contendrá: Id, título, autor, año de publicación, temática, y estado (disponible o prestado).
Se debe poder inicializar las propiedades del libro, y no pueden ser vacías. El estado inicial de cualquier libro al incorporarse a la biblioteca es **disponible**.
*/
data class Libro(val id:String?, val autor:String?, val anioPublicacion:Int, val tematica:String?, var estado:EstadoLibro = EstadoLibro.DISPONIBLE) {

    // Innit que comprueba que las entradas de la dataclass no sean ni nulas ni vacias
    init {
        require(!autor.isNullOrBlank()){"El autor no puede ser nulo ni estar vacio"}//si es nulo o esta vacio, da error, lo mismo con las otras dos
        require(anioPublicacion>= 1){"El año de publicacion no puede ser menor que 1"}
        require(!tematica.isNullOrBlank()){"La temática no puede ser nula ni estar vacia"}
        require(!id.isNullOrBlank()){"El id no puede nulo ni ser vacio"}
    }

}