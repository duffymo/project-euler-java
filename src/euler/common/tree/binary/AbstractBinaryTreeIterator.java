package euler.common.tree.binary;

import java.util.Iterator;

/**
 * AbstractTreeIterator
 * User: MOD
 * Date: Nov 29, 2008
 * Time: 12:52:40 PM
 */
public abstract class AbstractBinaryTreeIterator<T> implements Iterator<T> {
    private BinaryTree<T> root;

    protected AbstractBinaryTreeIterator(BinaryTree<T> root) {
        this.root = root;
    }

    public BinaryTree<T> getRoot() {
        return this.root;
    }
}
