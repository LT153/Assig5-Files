/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTreePackage;

/**
 *
 * @author LT153_000
 */
public class ComparableBinaryTree<T extends Comparable<? super T>> extends BinaryTree<T> implements ComparableTreeInterface<T> {

    public ComparableBinaryTree() {
        super();
    } // end default constructor

    public ComparableBinaryTree(T rootData) {
        super();
        setRootNode(new BinaryNode<>(rootData));
    } // end constructor

    @Override
    public T getMax() {
        return getMax(getRootNode());
    }

    private T getMax(BinaryNode<T> node) {
        T max = node.getData();
        if (node.getLeftChild() != null) {
            T maxLeft = getMax(node.getLeftChild());
            if (maxLeft.compareTo(max) > 0) {
                max = maxLeft;
            } 
        }
        if(node.getRightChild() != null) {
            T maxRight = getMax(node.getRightChild());
            if(maxRight.compareTo(max) > 0) {
                max = maxRight;
            }
        }
        return max;

        /*T max = null;
         if (node != null) {
         T maxLeft = getMax(node.getLeftChild());
         T maxRight = getMax(node.getRightChild());
         if (node.getLeftChild() == null && node.getRightChild() == null) {
         max = node.getData();
         } else if (node.getLeftChild() == null) {
         max = maxRight;
         } else if (node.getRightChild() == null) {
         max = maxLeft;
         } else {
         if (maxLeft.compareTo(maxRight) > 0) {
         max = maxLeft;
         } else {
         max = maxRight;
         }
         }
         }
         return max;*/
    }

    @Override
    public T getMin() {
        return getMin(getRootNode());
    }

    private T getMin(BinaryNode<T> node) {
        T min = node.getData();
        if (node.getLeftChild() != null) {
            T minLeft = getMin(node.getLeftChild());
            if (minLeft.compareTo(min) < 0) {
                min = minLeft;
            } 
        }
        if(node.getRightChild() != null) {
            T minRight = getMin(node.getRightChild());
            if(minRight.compareTo(min) < 0) {
                min = minRight;
            }
        }
        return min;
        
        /*T min = null;
        if (node != null) {
            T minLeft = getMax(node.getLeftChild());
            T minRight = getMax(node.getRightChild());
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                min = node.getData();
            } else if (node.getLeftChild() == null) {
                min = minRight;
            } else if (node.getRightChild() == null) {
                min = minLeft;
            } else {
                if (minLeft.compareTo(minRight) < 0) {
                    min = minLeft;
                } else {
                    min = minRight;
                }
            }
        }
        return min;*/
    }

    @Override
    public boolean isBST() {
        BinaryNode<T> root = getRootNode();
        return isBST(root);
    }

    private boolean isBST(BinaryNode<T> node) {
        if (node != null && node.getLeftChild() != null && node.getRightChild() != null) {
            T maxLeft = getMax(node.getLeftChild());
            T minRight = getMin(node.getRightChild());
            T nodeData = node.getData();
            if (nodeData.compareTo(maxLeft) > 0 && nodeData.compareTo(minRight) < 0) {
                return isBST(node.getLeftChild()) && isBST(node.getRightChild());
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

}
