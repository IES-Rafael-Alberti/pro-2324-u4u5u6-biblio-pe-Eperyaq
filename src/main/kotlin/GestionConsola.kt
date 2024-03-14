package org.pebiblioteca

object GestionConsola {

    /**
     * Se muestra un mensaje
     * @param text El mensaje a mostrar
     */
    fun mostrarInfo(text:String){
        println(text)
    }

    /**
     * Solicita al usuario introducir un numero a traves de la consola
     *
     * Hasta que no introduce un numero correcto no va a parar de preguntar por ese numero
     *
     * @return El numero introducido por el usuario
     */
    fun preguntarnum():Int{
        var penguin = true
        var numero= 0

        while (penguin){
            try {
                numero = readln().toInt()
                penguin = false
            }catch (e: NumberFormatException){
                println("Inserte un numero válido")
            }
        }
        return numero
    }

    /**
     * Solicita al usuario introducir una opcion entre un rango especifico
     *
     * @param maxop Numero maximo de opciones que va a tener disponibles
     * @throws IllegalArgumentException Si el numero introducido por consola es mayor que [maxop] o igual que 0
     * @return opcion La opcion escogida
     */
    fun opciones(maxop:Int):Int{
        mostrarInfo("Escoge tu opcion: ")
        var opcion = preguntarnum()
        var pinguinito = true

        while (pinguinito) {
            try {

                if (opcion > maxop || opcion ==0) {
                    throw IllegalArgumentException("Escoge un valor correcto") // si indican un numero mayor al pasado por parametros da error
                } else {
                    pinguinito = false
                }
            } catch (e: IllegalArgumentException) {
                mostrarInfo("ERROR, escoge un valor correcto")
                opcion = preguntarnum()
            }
        }
        return opcion
    }

    fun mostrarLibros(gestorBiblioteca: GestorBiblioteca){
        mostrarInfo("Que libros quieres mostrar? \n 1. Todos los libros que hay. \n 2.Los libros disponibles. \n 3.Los libros no disponibles")
        val opcion = opciones(3)

        when(opcion){
            1-> gestorBiblioteca.mostrarTodos()
            2-> gestorBiblioteca.librosDisponibles()
            3-> gestorBiblioteca.librosNoDisponibles()
        }
    }
}

