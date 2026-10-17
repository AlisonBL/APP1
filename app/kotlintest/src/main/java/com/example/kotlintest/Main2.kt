package com.example.kotlintest

import kotlin.random.Random

fun main(){
    class Perro {
        var nombre = ""   //Agregando las propiedades
        var edad = 0
    }

    var miPerro = Perro() //Instanciando un objeto

    miPerro.nombre = "Rocky"   //ya tiene en automático los getters y setters
    miPerro.edad = 7

    //otra forma con llaves
    data class Perro2(var nombre: String, var edad: Int)
    var miPerro2 = Perro2("Rocky", 5)

//con inicializador
    class Perro3 {
        var name: String
        var age: Int
        init {          //Inicializador
            name = ""
            age = 0
        }
    }
    var miPerro3 = Perro3()
    class Perro4 {
        var nombre_p: String
        var edad_p: Int
        constructor(nombre: String, edad: Int){
            this.nombre_p = nombre   //como en Java
            this.edad_p = edad
        }
        constructor() {
            nombre_p = "Sin nombre"
            edad_p = 0
        }

        fun infoPerro() {                              //funciones en una clase (o métodos)
            println("$nombre_p tiene $edad_p años")
        }
    }
    val miPerro4 = Perro4("Fido", 8)   //cada uno usa un constructor diferente
    val miPerro5 = Perro4()
    miPerro4.infoPerro()
    miPerro5.infoPerro()

    //nullables
    var edadPersona: Int? = Random.nextInt(0,3) //aleatorios del 0 al 2

    edadPersona = when(edadPersona){
        0 -> null //Permite el valor null. Marcaría error si no se hubiera declarado nullable
        1 -> 10
        else -> 20
    }

    if(edadPersona != null){
        println("Tu edad en 5 años será de ${edadPersona + 5} años")
    }

    //val y = edadPersona.toDouble()  //Marca error al compilar porque no estamos revisando primeramente si no es nulo
    //Entonces poner:
    if(edadPersona != null){
        val y = edadPersona.toDouble()
        println(y)
    }
    //con safe access
    println(edadPersona?.toDouble())

    //not null assertion
    //println(edadPersona!!.toDouble())

//usando la interfaz
    fun operaNumeros(a:Int, b:Int, operacion:Operaciones){
        operacion.suma(2,3)
        operacion.resta(3,2)
    }
    //usando lambda
    fun operaNumeros(a:Int, b:Int, operacion:(Int,Int)->Unit){
        operacion(a,b)
    }

    val milambda: (Int,Int)->Unit = {
        num1, num2 -> println("LA suma de $num1 + $num2 es ${num1+num2}")
    } //Cuando solo hay 1 parámetro se usa it

//PUEDO TENER Diferentes Implementaciones
    operaNumeros(36,23, object : Operaciones {
        override fun suma(a: Int, b: Int) {
           println("EL DOBLE DE La suma de los números $a + $b es: ${2*(a+b)}")
        }
        override fun resta(a: Int, b: Int) {
            println("EL DOBLE DE La resta de los números $a - $b es: ${2*(a-b)}")
        }
    })
    //ej OnSuccess y OnFail e implementarlas en nuestra app

    //Como lambda, más fácil y conciso
    //operaNumeros(3,4,milambda) usualmente no se usa una variable intermedia para la lambda
    operaNumeros(3,4) { num1, num2 ->
        println("La suma de $num1 + $num2 es ${num1 + num2}")
    }
//cierra los que no son lambdas en ()
    operaNumeros(3,4) { num1, num2 ->
        println("La resta de $num1 - $num2 es ${num1 - num2}")
    }

}