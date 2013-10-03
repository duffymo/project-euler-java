package euler.common.tree.binary;

/**
 * Tree
 * User: MOD
 * Date: Nov 29, 2008
 * Time: 12:39:07 PM
 */
public interface BinaryTree<T> {
    T getValue();

    void setValue(T value);

    BinaryTree<T> getLeft();

    void addLeft(BinaryTree<T> left);

    void removeLeft();

    BinaryTree<T> getRight();

    void addRight(BinaryTree<T> right);

    void removeRight();

    boolean isLeaf();
}
