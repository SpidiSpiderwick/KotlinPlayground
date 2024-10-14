import org.junit.Test

class BinarySearchTreeKtTest{

    @Test
    fun testBinaryTreeDepth(){
        val tree = BinarySearchTree()
        assert(tree.getDepth() == 0)
        tree.add(5.0)
        assert(tree.getDepth() == 1)
        tree.add(3.0)
        assert(tree.getDepth() == 2)
        tree.add(1.0)
        assert(tree.getDepth() == 3)
        tree.add(4.0)
        assert(tree.getDepth() == 3)
    }
}