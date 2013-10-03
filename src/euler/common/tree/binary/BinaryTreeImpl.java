package euler.common.tree.binary;

/**
 * TreeImpl
 * User: MOD
 * Date: Nov 29, 2008
 * Time: 12:43:34 PM
 */
public class BinaryTreeImpl<T> implements BinaryTree<T> {
    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTreeImpl(T value) {
        this(value, null, null);
    }

    public BinaryTreeImpl(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return ((this.left == null) && (this.right == null));
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTree<T> getLeft() {
        return this.left;
    }

    public void addLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public void removeLeft() {
        this.left = null;
    }

    public BinaryTree<T> getRight() {
        return this.right;
    }

    public void addRight(BinaryTree<T> right) {
        this.right = right;
    }

    public void removeRight() {
        this.right = null;
    }
}
