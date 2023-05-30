package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull()) {
			throw new HashtableOverflowException();
		}
		if (element != null) {
			int probe = 0;
			int hash;
			while (probe < capacity()) {
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe++);
				if (table[hash] == null || table[hash].equals(new DELETED())) {
					table[hash] = element;
					elements++;
					break;
				}
				COLLISIONS++;
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int probe = 0;
			int hash;
			while (probe < capacity()) {
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe++);
				if (table[hash] != null && table[hash].equals(element)) {
					this.table[hash] = new DELETED();
					elements--;
				}
				COLLISIONS++;
			}
		}
	}

	@Override
	public T search(T element) {
		int cont = 0;
		int hash;
		T result = null;
		while (cont < capacity()) {
			hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, cont++);
			if (this.table[hash] != null && this.table[hash].equals(element)) {
				result = (T) table[hash];
			}
		}
		return result;
	}

	@Override
	public int indexOf(T element) {
		int probe = 0;
		int hash;
		int result = -1;
		while (probe < capacity()) {
			hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probe++);
			if (this.table[hash] != null && this.table[hash].equals(element)) {
				result = hash;
			}
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}
}
