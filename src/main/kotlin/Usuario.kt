package org.pebiblioteca
class Usuario(val id:String, val nombre:String, val listaLibrosPrestados:MutableList<Libro>) {

    constructor(id: String, nombre: String): this(id,nombre, listaLibrosPrestados = mutableListOf<Libro>())

    /**
     * Se agrega un libro a la lista de libros Prestados
     * @param libro Libro a añadir a la lista
     */
    fun agregarLibroPrestado(libro: Libro){
        GestionConsola.mostrarInfo("Agregando libro...")
        listaLibrosPrestados.add(libro)
    }
    /**
     * Se quita un libro de la lista de libros Prestados
     * @param libro Libro a quitar a la lista
     */
    fun quitarLibroPrestado(libro: Libro){
        GestionConsola.mostrarInfo("Quitando libro...")
        listaLibrosPrestados.remove(libro)
    }

    /**
     * Muestra los libros que se le han prestado al usuario
     */
    fun mostrarLibrosPrestados(){
        GestionConsola.mostrarInfo("$listaLibrosPrestados")
    }
}