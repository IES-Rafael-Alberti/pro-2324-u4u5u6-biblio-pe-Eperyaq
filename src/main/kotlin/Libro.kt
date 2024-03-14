package org.pebiblioteca

data class Libro(var id:String?, val autor:String?, val anioPublicacion:Int, val tematica:String?, var estado:EstadoLibro = EstadoLibro.DISPONIBLE) {

    // Innit que comprueba que las entradas de la dataclass no sean ni nulas ni vacias
    init {
        require(!autor.isNullOrBlank()){"El autor no puede ser nulo ni estar vacio"}//si es nulo o esta vacio, da error, lo mismo con las otras dos
        require(anioPublicacion>= 1){"El año de publicacion no puede ser menor que 1"}
        require(!tematica.isNullOrBlank()){"La temática no puede ser nula ni estar vacia"}
        require(!id.isNullOrBlank()){"El id no puede nulo ni ser vacio"}
    }

}