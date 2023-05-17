package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = this.head;
		while (!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T saida = null;
		SingleLinkedListNode<T> auxHead = this.head;
		while (!auxHead.isNIL()) {
			if (auxHead.getData().equals(element)) {
				saida = auxHead.getData();
			}
			auxHead = auxHead.getNext();
		}
		return saida;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.head.setData(element);
				this.head.setNext(new SingleLinkedListNode<>());
			} else {
				SingleLinkedListNode<T> auxHead = this.head;
				while (!auxHead.isNIL()) {
					auxHead = auxHead.getNext();
				}
				auxHead.setData(element);
				auxHead.next = new SingleLinkedListNode<>();
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (isEmpty()) {
				if (this.head.getData().equals(element)) {
					this.head = this.head.next;
				}
			} else {
				SingleLinkedListNode<T> auxHead = this.head;
				while (!auxHead.getNext().isNIL() && !auxHead.getData().equals(element)) {
					auxHead = auxHead.getNext();
				}
				if(!auxHead.isNIL()){
					auxHead.data = auxHead.getNext().getData();
					auxHead.setNext(auxHead.getNext().getNext());
				}
			}
		}
	}
	@Override
	public T[] toArray() {
		T[] saida = (T[]) new Object[size()];
		if(!isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			int i = 0;
			while(!aux.isNIL()) {
				saida[i] =  aux.getData();
				i++;
				aux = aux.getNext();
			}
		}
		return saida;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
