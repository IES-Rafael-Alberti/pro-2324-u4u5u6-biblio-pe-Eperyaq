package org.pebiblioteca
abstract class ElementoBilbioteca(val titulo:String, val id:String, val estado:String ) {
    /**
     * Pides prestado un libro/cd lo que sea
     */
    abstract fun prestar()

    /**
     * Devuelves el libro/cd lo que tengas
     */
    abstract fun devolver()

    /**
     * Comprueba si esta en la biblioteca
     */
    abstract fun comprobar()

}