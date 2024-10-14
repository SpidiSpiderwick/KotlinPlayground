import org.junit.Test

class BaumProzessorTest{

    @Test
    fun testTreeProcessSumAndAvg() {
        val baum = Knoten(7.0, listOf(Knoten(4.4, listOf(Knoten(1.0),Knoten(5.3))),Knoten(3.1, listOf(Knoten(9.2)))))
        val prozessor_sum = BaumProzessor(baum,Summe())
        val prozessor_dur = BaumProzessor(baum,Durchschnitt())
        assert(prozessor_sum.berechneErgebnis() == 30.0)
        assert(prozessor_dur.berechneErgebnis() == 5.0)

    }
}