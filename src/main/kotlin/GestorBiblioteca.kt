package org.pebiblioteca

class GestorBiblioteca(listaLibro:List<Libro>) {
    val listaTodos = mutableListOf<Libro>() //lista de todos los libros
    val catalogoLibros = mutableListOf<Libro>() //lista de libros disponibles
    val registroPrestamos = mutableListOf<Libro>() //lista de libros NO disponibles

    /**
     * Agregas un libro a la biblioteca
     * @param libro libro agregado
     * @param utilidad llamada a otra clase para generar el Id unico
     */
    fun agregarLibro(libro: Libro, utilidad: UtilidadesBiblioteca){
        utilidad.modificarIdLibro(libro)
        catalogoLibros.add(libro)
        listaTodos.add(libro)
        GestionConsola.mostrarInfo("Libro añadido correctamente")
    }

    /**
     * Eliminas un libro de la biblioteca
     */
    fun eliminarLibro(libro: Libro){
        catalogoLibros.remove(libro)
        GestionConsola.mostrarInfo("Libro eliminiado correctamente")
    }

    /**
     * Compruebas si un libro está en el catalogo
     * @param libro libro que se está consultando si esta
     */
    fun consultarLibro(libro: Libro):Boolean = libro in catalogoLibros //Si el libro está en el catalogo da true si no esta, false

    /**
     * Comprueba los libros disponibles, si hay te los muestra, si no, te muestra un mensaje de que no hay libros
     */
    fun librosDisponibles(){
        if (catalogoLibros.size == 0){
            GestionConsola.mostrarInfo("No hay libros disponibles")
        }else{
        GestionConsola.mostrarInfo("Mostrando libros Disponibles...")
        GestionConsola.mostrarInfo("${catalogoLibros}")
        }
    }

    /**
     * Comprueba los libros NO disponibles y si hay, los muestra, si no, te muestra un mensaje diciendo que no hay libros
     */
    fun librosNoDisponibles(){
        if (registroPrestamos.size == 0){
            GestionConsola.mostrarInfo("No hay libros No disponibles")
        }else{
        GestionConsola.mostrarInfo("Mostrando libros NO Disponibles...")
        GestionConsola.mostrarInfo("${registroPrestamos}")
        }
    }

    /**
     * Muestra todos los libros que hay en la biblioteca
     */
    fun mostrarTodos(){

        GestionConsola.mostrarInfo("Mostrando todos los libros...")
        GestionConsola.mostrarInfo("${listaTodos}")
    }



}