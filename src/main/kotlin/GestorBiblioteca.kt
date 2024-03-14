package org.pebiblioteca

class GestorBiblioteca(listaLibro:List<Libro>) {
    val listaTodos = mutableListOf<Libro>() //lista de todos los libros
    val catalogoLibros = mutableListOf<Libro>() //lista de libros disponibles
    val registroPrestamos = mutableListOf<Libro>() //lista de libros NO disponibles


    fun agregarLibro(libro: Libro, utilidad: UtilidadesBiblioteca){
        utilidad.modificarIdLibro(libro)
        catalogoLibros.add(libro)
        listaTodos.add(libro)
        GestionConsola.mostrarInfo("Libro añadido correctamente")
    }


    fun eliminarLibro(libro: Libro){
        catalogoLibros.remove(libro)
        GestionConsola.mostrarInfo("Libro eliminiado correctamente")
    }

    fun consultarLibro(libro: Libro):Boolean = libro in catalogoLibros //Si el libro está en el catalogo da true si no esta, false

    fun registrarPrestamo(libro: Libro){
        //Si el libro está en el catalogo se cambia el valor a no disponible
        //Se borra de la lista de catalogos y se mete en la lista de registros todavia no
        if (consultarLibro(libro)){
            libro.estado = EstadoLibro.NO_DISPONIBLE

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
            libro.estado = EstadoLibro.DISPONIBLE
            registroPrestamos.remove(libro)
            catalogoLibros.add(libro)
        }else{
            GestionConsola.mostrarInfo("El libro ya estaba disponible")
        }
    }

    //Retornar los libros en función de su estado (todos, disponibles y prestados).
    fun librosDisponibles(){
        if (catalogoLibros.size == 0){
            GestionConsola.mostrarInfo("No hay libros disponibles")
        }else{
        GestionConsola.mostrarInfo("Mostrando libros Disponibles...")
        GestionConsola.mostrarInfo("${catalogoLibros}")
        }
    }
    fun librosNoDisponibles(){
        if (registroPrestamos.size == 0){
            GestionConsola.mostrarInfo("No hay libros No disponibles")
        }else{
        GestionConsola.mostrarInfo("Mostrando libros NO Disponibles...")
        GestionConsola.mostrarInfo("${registroPrestamos}")
        }
    }
    fun mostrarTodos(){

        GestionConsola.mostrarInfo("Mostrando todos los libros...")
        GestionConsola.mostrarInfo("${listaTodos}")
    }



}