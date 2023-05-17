package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(element != null) {
			if(isFull()) {
				throw new StackOverflowException();
			}
			top.insert(element);
			size++;
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()){
			throw new StackUnderflowException();
		}
		T valor = this.top();
		this.top.removeLast();
		size--;
		return valor;
	}

	@Override
	public T top() {
		T value;
		if (this.isEmpty())
			value = null;
		else {
			value = top.toArray()[top.size() - 1];
		}
		return value;
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size == top.size();
	}

}
