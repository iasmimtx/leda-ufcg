package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return (data == null);
	}

	@Override
	public int size() {
		if (this.getData() == null) {
			return 0;
		}
		int counter = 0;
		if (this.getNext() != null) {
			counter = 1 + this.getNext().size();
		}
		return counter;
	}

	@Override
	public T search(T element) {
		T elemento = null;
		if (!(this.isEmpty()) && !(element == null)) {
			if (element == this.getData()) {
				elemento = this.getData();
			} else {
				if (!(this.getNext() == null)) {
					elemento = this.getNext().search(element);
				}
			}
		}
		return elemento;
	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl<T>());
		} else {
			this.getNext().insert(element);
		}

	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty() && element != null) {

			if (this.getData().equals(element)) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			} else {
				this.getNext().remove(element);
			}
		}

	}

	@Override
	public T[] toArray() {
		int tamanho = this.size();
		T[] array = (T[]) new Object[tamanho];
		if (!this.isEmpty()) {
			int index = 1;
			array[0] = this.getData();
			RecursiveSingleLinkedListImpl<T> proximo = this.getNext();
			while (!proximo.isEmpty()) {
				array[index++] = proximo.getData();
				proximo = proximo.getNext();
			}
		}
		return array;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
}