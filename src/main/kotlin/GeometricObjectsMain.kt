import java.security.InvalidParameterException
import kotlin.math.sqrt

class GeometricObjectException(message: String? = null) :
    InvalidParameterException("Geometric Object ERROR: $message")

sealed class GeometricObject

data class Kugel(var r: Double) : GeometricObject() {
    init {
        if (r < 0) throw GeometricObjectException("Kugel: Parameter r <0; Wert: $r")
    }

    var volume = 4 / 3 * Math.PI * r * r * r
    var oberflaeche = 4 * Math.PI * r * r
}

data class Wuerfel(var a: Double) : GeometricObject() {
    init {
        if (a < 0) throw GeometricObjectException("Wuerfel: Parameter a <0; Wert: $a")
    }

    var raumdiagonale = sqrt(3.0) * a
    var volume = a * a * a
    var oberflaeche = 6 * a * a
}

class GeometrischeObjekte(val objekte: MutableList<GeometricObject>) {
    fun add(objekt: GeometricObject) {
        objekte.add(objekt)
    }

    fun getAnzahl(): Int {
        return objekte.size
    }

    fun ausgeben() {
        for (objekt in objekte) {
            when (objekt) {
                is Kugel -> print("Kugel mit r = ${objekt.r}, Volumen = ${objekt.volume} und Oberfläche = ${objekt.oberflaeche}\n")
                is Wuerfel -> print("Würfel mit a = ${objekt.a}, Raumdiagonale = ${objekt.raumdiagonale}, Volumen = ${objekt.volume} und Oberfläche = ${objekt.oberflaeche}\n")
            }
        }
    }
}



