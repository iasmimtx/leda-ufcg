package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
			if (isEmpty()) {
				head = newNode;
			} else {
				newNode.previous = last;
				last.next = newNode;
			}
			last = newNode;
		}
	}

	@Override
	public void insertFirst(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
			newHead.next = head;
			newHead.previous = new DoubleLinkedListNode<>();
			head = newHead;
			if (head.isNIL()) {
				this.last = newHead;
			}
			head = newHead;
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()){
			this.head = this.head.getNext();

			if (this.head.isNIL())
				this.last = ((DoubleLinkedListNode<T>) this.head);
			else {
				DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<>();

				((DoubleLinkedListNode<T>) this.head).setPrevious(nil);
				nil.setNext(this.head);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!last.isNIL()) {
			last = last.getPrevious();
		}
		if (last.isNIL()) {
			head = last;
		}
		last.setNext(new DoubleLinkedListNode<>());
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}