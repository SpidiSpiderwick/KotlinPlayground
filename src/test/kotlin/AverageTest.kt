import org.junit.Test

class AverageTest{

    @Test
    fun testAverageSumWithThreads(){
        val array = LongArray(100){i -> i.toLong()+1}
        var average = Average(array,4)
        assert(average.getAverage().toInt() == 50)
    }
}