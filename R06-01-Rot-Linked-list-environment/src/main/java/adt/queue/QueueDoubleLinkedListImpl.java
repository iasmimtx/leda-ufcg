package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element != null && !this.isFull()) {
			this.list.insert(element);
		} else {
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!this.isEmpty()) {
			T element = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
			this.list.removeFirst();
			return element;
		} else {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		T element = null;
		if (!this.isEmpty()) {
			element = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return (this.list.size() <= 0);
	}

	@Override
	public boolean isFull() {
		return (this.size == this.list.size());
	}
}
