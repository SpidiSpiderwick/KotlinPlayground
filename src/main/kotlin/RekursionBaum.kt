interface Operator {
    fun verarbeiteWert(wert: Double)
    fun getBezeichnung() : String
    fun liefereErgebnis() : Double
}

class Summe : Operator{
    var summe : Double = 0.0
    override fun verarbeiteWert(wert: Double) {
        summe += wert
    }
    override fun getBezeichnung(): String {
        return "Summe"
    }
    override fun liefereErgebnis(): Double {
        return summe
    }

}

class Durchschnitt : Operator{
    var anzahlSummanden : Int = 0
    var summe : Double = 0.0
    override fun verarbeiteWert(wert: Double) {
        anzahlSummanden += 1
        summe += wert
    }
    override fun getBezeichnung(): String {
        return "Durchschnitt"
    }
    override fun liefereErgebnis(): Double {
        return summe/anzahlSummanden
    }
}

data class Knoten (val wert: Double, val kinder: List<Knoten>?= null)

class BaumProzessor(val wurzelDesBaumes: Knoten, val operator: Operator){
    fun berechneErgebnis(): Double{
        println("Operation: ${operator.getBezeichnung()}")
        verarbeiteKnoten(wurzelDesBaumes)
        println("Ergebnis: ${operator.liefereErgebnis()}")
        return operator.liefereErgebnis()
    }
    fun verarbeiteKnoten(knoten: Knoten){
        operator.verarbeiteWert(knoten.wert)
        knoten.kinder?.forEach{kind:Knoten -> verarbeiteKnoten(kind)}
    }
}
