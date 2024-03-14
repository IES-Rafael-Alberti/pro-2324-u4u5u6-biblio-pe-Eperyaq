package org.pebiblioteca

import java.util.UUID;
class UtilidadesBiblioteca {


    // Random UUID generada
    companion object{
        fun generarIdRandom():String{
            val myUuid = UUID.randomUUID()//Genera un Id random
            val myUuidString = myUuid.toString()//Lo pasa a String

            return myUuidString
        }

    }

    /**
     * Reasignamos el valor del Id al Id unico proporcionado por la funcion del companion object
     */
    fun modificarIdLibro(libro: Libro){
        libro.id = generarIdRandom()
    }



}