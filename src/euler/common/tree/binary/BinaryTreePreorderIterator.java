package euler.common.tree.binary;

/**
 * TreePreorderIterator
 * User: MOD
 * Date: Nov 29, 2008
 * Time: 12:51:03 PM
 */
public class BinaryTreePreorderIterator<T> extends AbstractBinaryTreeIterator<T> {
    public BinaryTreePreorderIterator(BinaryTree<T> root) {
        super(root);
    }

    public boolean hasNext() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public T next() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void remove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
