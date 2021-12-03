import kotlin.math.pow
import kotlin.math.sqrt

class Punto(val id: String) {
    var x = 0
    var y = 0

    constructor(identificador: String, x: Int, y: Int) : this(identificador) {
        this.x = x
        this.y = y

    }

    companion object {

        //Devuelve un punto en el cual el id es el conjunto del punto A y punto B introducidos, la x es el resultado de restarle a la x del punto B la del A, y la y igual con sus y respectivas.
        fun componenteDeVector(pa: Punto, pb: Punto): Punto = Punto((pa.id + pb.id), (pb.x - pa.x), (pb.y - pa.y))

        //Calculo RaízCuadrada[(pb.x - pa.x)^2 + (pb.y - pa-y)^2]
        fun distancia(pa: Punto, pb: Punto): Double =
            sqrt(x = ((pb.x - pa.x).toDouble().pow(2) + (pb.y - pa.y).toDouble().pow(2)))

        //Agrupo los puntos en la lista que corresponde a la clave: String ("Norte") o a la clave "Sur" según la y sea mayor a 0 o no.
        fun localizacionGeograficaNS(puntos: Array<Punto>): Map<String, List<Punto>> =
            puntos.groupBy { if (it.y >= 0) "Norte" else "Sur" }
    }

    fun obtenerCoordenadas(): Pair<Int, Int> = Pair(x, y)

    override fun toString(): String {
        return "punto $id -> [$x,$y]"
    }
}

fun main() {
    val pA = Punto("pA", 3, 2)
    val pB = Punto("pB", 1, 3)

    val punto1 = Punto("p1", -1, 0)
    val punto2 = Punto("p2", 3, -1)
    val punto3 = Punto("p3", -4, 4)
    val punto4 = Punto("p4", -3, 2)
    val punto5 = Punto("p5", 6, -4)
    val punto6 = Punto("p6", -5, 6)
    val punto7 = Punto("p7", 10, -8)
    val punto8 = Punto("p8", 1, 5)
    val punto9 = Punto("p9", 6, -7)

    val arrayPuntos = arrayOf(punto1, punto2, punto3, punto4, punto5, punto6, punto7, punto8, punto9)

    println(pA)
    println(pB)

    println("Coordenadas de pA: " + pA.obtenerCoordenadas())
    println("Coordenadas de pB: " + pB.obtenerCoordenadas())

    println("Distancia entre los puntos pA y pB: " + Punto.distancia(pA,pB))

    println("Componente AB: " + Punto.componenteDeVector(pA, pB))
    
    println("Lista de puntos: " + arrayPuntos.contentToString())
    println("Localización Geográfica NS: " + Punto.localizacionGeograficaNS(arrayPuntos))
}