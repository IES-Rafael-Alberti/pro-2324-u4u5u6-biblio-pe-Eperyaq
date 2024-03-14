package org.pebiblioteca
/*
* Prestable (Interface): Definir una interfaz Prestable que especifique los métodos prestar() y devolver().
* Asegurar que la clase Libro implemente esta interfaz, lo que garantiza que todos los tipos de elementos que puedan ser prestados cumplan con estos métodos.*/
interface Prestable {
    /**
     * Pides prestado el objeto que tengas
     */
    fun prestar()

    /**
     * Devuelves el objeto que tengas libro, cd etc
     */
    fun devolver()

}