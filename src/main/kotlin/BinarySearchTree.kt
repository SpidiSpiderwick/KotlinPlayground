import kotlin.math.max

class BinarySearchTreeNode(var wert: Double, var left: BinarySearchTreeNode?=null, var right: BinarySearchTreeNode?=null){
    fun add(neuerWert: Double){
        when{
            neuerWert == wert -> println("Wert bereits im Baum.")
            (neuerWert < wert && this.left == null) -> this.left = BinarySearchTreeNode(neuerWert)
            (neuerWert < wert && this.left != null) -> this.left!!.add(neuerWert)
            (neuerWert > wert && this.right == null) -> this.right = BinarySearchTreeNode(neuerWert)
            (neuerWert > wert && this.right != null) -> this.right!!.add(neuerWert)
            else -> println("I think there is a problem here.")
        }
    }
    fun getDepth(): Int {
        return when{
            left == null && right == null -> 1
            left != null && right == null -> left!!.getDepth()+1
            left == null && right != null -> right!!.getDepth()+1
            else -> max(left!!.getDepth(), right!!.getDepth())+1
        }
    }
}

class BinarySearchTree(var wurzel: BinarySearchTreeNode?=null){
    fun add(wert: Double){
        if (wurzel == null) wurzel = BinarySearchTreeNode(wert)
        else wurzel!!.add(wert)
    }
    fun getDepth(): Int {
        return if (wurzel == null) 0
        else wurzel!!.getDepth()
    }
}