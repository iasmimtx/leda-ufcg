package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (element != null) {

			if (!this.isEmpty()) {
				this.getNext().insert(element);
			} else {
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<T>());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
				if (this.getPrevious() == null) {
					this.setPrevious(new RecursiveDoubleLinkedListImpl<T>());
				}
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {

			if (this.isEmpty()) {
				this.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> recusiveDouble = new RecursiveDoubleLinkedListImpl<T>();
				recusiveDouble.setData(this.getData());
				recusiveDouble.setNext(this.getNext());
				this.setData(element);
				this.setNext(recusiveDouble);

				recusiveDouble.setPrevious(this);
				((RecursiveDoubleLinkedListImpl<T>) recusiveDouble.getNext())
						.setPrevious(recusiveDouble);
			}

		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.getNext().isEmpty()) {
				this.setData(null);
				this.setNext(new RecursiveDoubleLinkedListImpl<T>());
			} else {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}

		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.getNext().isEmpty()) {
				this.setData(null);
				this.setNext(new RecursiveDoubleLinkedListImpl<T>());
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
			}

		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
}