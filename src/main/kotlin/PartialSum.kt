import kotlin.math.ceil

class PartialSum(var nums: List<Long>) : Thread(){
    var sum : Long = 0
    var anz : Int = 0
    override fun run(){
        anz = nums.size
        sum = nums.sum()
    }
}

class Average (val nums: LongArray, val anzThreads: Int){
    var sum : Long = 0
    fun getAverage(): Long{
        val chunckSize : Int =  ceil((nums.size / anzThreads.toDouble())).toInt()
        val threadList = mutableListOf<PartialSum>()
        for (i in 0..<anzThreads){
            if (i<anzThreads-1) threadList.add(PartialSum(nums.slice((i*chunckSize..<(i+1)*chunckSize))))
            else threadList.add(PartialSum(nums.slice((i*chunckSize..<nums.size))))
        }
        for (thread in threadList){
            thread.run()
            sum += thread.sum
        }
        return sum / nums.size
    }
}
