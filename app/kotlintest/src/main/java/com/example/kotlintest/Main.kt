package com.example.kotlintest

import com.example.kotlintest.model.Student
import kotlin.random.Random

fun main(){
    println("Hola")
    var saludo="Hola buen día"
    saludo="Hola buenas tardes"

    //manejar valores nulos
    val e:Int? = null

    val student1 = Student(1, "Alison", "Becerra")
    println("El estudiante es ${student1.name} ${student1.lastname}") //El estudiante es Alison Becerra

    student1. name="Lisset"

    var array1 = arrayOf(1,2,3,4,5) //Así no se podrían agregar elementos directamente al final.
    // Se tendrían que dar todos los valores nuevamente.
    //no se tiene el metodo add
    println(array1) //Muestra la dirección de memoria del arreglo en lugar de sus elementos

    //funcion que se pasa como parámetro a otra
    val milambda1={z:Int -> println(z+2)}
    array1.forEach(milambda1)    //3,4,5,6,7

    val milambda2:(Int)->Unit={
        val z= it+2
        println(z)
    }
    array1.forEach(milambda2)   //3,4,5,6,7

    print("\n")
    println(array1[2]) //empieza con el índice cero //3
    println(array1.size) //cantidad de elementos. En Swift se usa count   //5


    var lista1 = mutableListOf(35,36,5,2)  //Especificando el tipo (opcional)
    lista1.add(6) //agregamos un elemento al final
    lista1.add(2, 80) //se agrega al índice 2 el valor de 80
    println(lista1)    //35,36,80,5,2,6

    //Con ArrayLists
    var array2 = ArrayList<String>()
    array2.add("texto1")
    array2.add("texto2")
    array2.add("texto3")

    println(array2) //texto1, texto2, texto3

    var miMapa = mapOf("llave1" to  "valor1", "llave2" to "valor2")
    println(miMapa["llave1"])      //valor 1

    //miMapa["llave3"] = "valor3" //marca error porque no es mutable

    var miMapa2 = mutableMapOf("llave1" to  "valor1", "llave2" to "valor2")
    miMapa2["llave3"] = "valor3"  //imprime los 3 llave y valor
    println(miMapa2)

    val miMapa3 = mapOf("llave1" to 1, "llave2" to 2)
    println(miMapa3)

    val edad = Random.nextInt(1,100)

    if (edad >= 18) {
        println("Tienes $edad, por lo que eres mayor de edad")
    } else {
        println("Tienes $edad, por lo que eres menor de edad")
    }

    /*print("Ingresa tu edad: ")
    val edad2 = readLine()    //asi se lee valor de terminal

    if (!edad2.isNullOrEmpty() && edad2.toIntOrNull() != null) {
        if (edad2.toInt() >= 18) {
            println("Eres mayor de edad")
        } else {
            println("Eres menor de edad")
        }
    }else{
        println("Ingresa una edad válida")
    }*/

    var tipoSaludo = Random.nextInt(1,4)

    when(tipoSaludo){
        1 -> {
            println("Hola Amaury")
        }
        2 -> {
            println("¿Qué onda Amaury?")
        }
        else -> {    //Como el default
            println("¿Cómo estás Amaury?")
        }
    }

    var num = 1

    while (num<=10){
        println(num)
        num++
    }

    println("------------------------")

    var num2 = 1

    do {
        println(num2)
        num2 += 1
    } while (num2<=10)

    for (x in 1..5){
        println(x)
    }

    for (x in 1..9 step 2){
        println(x)
    }

    for (x in 5 downTo 1){
        println(x)
    }

    for (x in 1.rangeTo(15)) {
        println(x)
    }

    var dulcesFavoritos = listOf("Dulce1", "Dulce2", "Dulce3")

    for (dulce in dulcesFavoritos){
        println(dulce)
    } //dulce 1, 2, 3

    dulcesFavoritos.forEach{ println(it) } //dulce 1,2,3

    /*for (num in 1..200){
        if(num % 2 != 0) println(num)   //Números impares
    }*/   //Imprime del 1 al 199 solo impares


    fun hola(){println("Hola mundo")}
    hola()

    /*fun hola2():String{return "Hola"}
    fun hola2():String="Hola"
    Puede transformarse a: */
    fun hola2()="Hola"
    println(hola2())

    /*fun hola3(nombre:String):String{
        return "Hola $nombre"
    }
    println(hola3("Alison"))*/

    fun hola3(nombre:String)="Hola $nombre"
    println(hola3("Alison"))


    /*fun hola4(nombre: String = "Alison"): String {
        return "Hola $nombre"
    }
    println(hola4()) //pondría "Hola Alison" (no recibió parámetros)*/

    fun hola4(nombre:String="Alison")="Hola $nombre"
    hola4() //Hola Alison

    fun hola5(nombre: String = "Alison", apellidos: String = "Becerra")= "Hola $nombre $apellidos"
    println(hola5(apellidos = "Lara")) //Alison Lara
    println(hola5()) //Alison Becerra

    fun sumaNumeros(num1: Int, num2: Int) = num1 + num2
    println("La suma de 5 + 8 es: ${sumaNumeros(5,8)}")

    //funciones de alcance y extensión
    //esta es una scope function de apply, ya no es necesario poner student.name="", student1.lastname"" etc
    student1.apply{
        name="Alison"
        lastname="Becerra"
    }

    /*Hay 5 funciones de alcance en Kotlin
    * Apply y Also devuelven el mismo objeto
    * Let, run, with devuelven resultado del bloque
    * */

    println(student1.getFullName())
    println(student1.getFullNameUppercase()) //extendiendo una clase que no nos pertenecía
    //Hay funciones de extension muy útiles como para ver la version de android, para los mensajes Toast






















}

