import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class GeometricObjectsMainKtTest{

    val outContent = ByteArrayOutputStream()
    var originalOut : PrintStream = System.out

    @Before
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }

    @Test
    fun testObjects(){
        val list = mutableListOf<GeometricObject>()
        list.add(Kugel(3.14))
        list.add(Wuerfel(3.14))
        GeometrischeObjekte(list).ausgeben()
        assertEquals("Kugel mit r = 3.14, Volumen = 97.26101935182854 und Oberfläche = 123.89938770933571\n" +
                "Würfel mit a = 3.14, Raumdiagonale = 5.438639535766274, Volumen = 30.959144000000002 und Oberfläche = 59.1576", outContent.toString().trim())
    }

    @Test
    fun testGeometricObjectException(){
        assertThrows(GeometricObjectException::class.java) {
            val badObject = Kugel(-1.0)
        }
    }

    @After
    fun restoreStreams() {
        System.setOut(originalOut)
    }
}