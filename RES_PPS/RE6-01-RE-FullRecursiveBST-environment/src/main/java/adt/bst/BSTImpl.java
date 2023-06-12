package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}

	private int height(BSTNode<T> node) {
		int result = -1;

		if (!node.isEmpty()) {

			BSTNode<T> leftNode = (BSTNode<T>) node.getLeft();
			BSTNode<T> rightNode = (BSTNode<T>) node.getRight();

			result = 1 + Math.max(height(leftNode), height(rightNode));
		}

		return result;
	}

	@Override
	public BSTNode<T> search(T element) {
		return searchRec(this.root, element);
	}

	private BSTNode<T> searchRec(BSTNode<T> node, T element) {
		BSTNode<T> result;
		if(node.isEmpty() || node.getData().equals(element)) result = node;
		else{
			if(element.compareTo(node.getData()) > 0) result = searchRec((BSTNode<T>) node.getRight(), element);
			else result = searchRec((BSTNode<T>) node.getLeft(), element);
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.root = (BSTNode<T>) new BSTNode.Builder<T>()
					.data(element)
					.left(new BSTNode<T>())
					.right(new BSTNode<T>())
					.build();

			this.root.getLeft().setParent(root);
			this.root.getRight().setParent(root);
		} else {
			this.insert(root, element);
		}

	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		} else if (element.compareTo(node.getData()) < 0) {
			this.insert((BSTNode<T>) node.getLeft(), element);
		} else {
			this.insert((BSTNode<T>) node.getRight(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
