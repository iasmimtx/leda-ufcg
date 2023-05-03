package adt.stack;

public class StackImpl<T> implements Stack<T> {

    private T[] array;
    private int top;

    @SuppressWarnings("unchecked")
    public StackImpl(int size) {
        array = (T[]) new Object[size];
        top = -1;
    }

    @Override
    public T top() {
        T saida = null;
        if (!this.isEmpty()) {
            saida = this.array[this.top];
        }
        return saida;
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public boolean isFull() {
        return this.top == array.length - 1;
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if (isFull()) throw new StackOverflowException();
        if (element != null) this.array[++this.top] = element;
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (isEmpty()) throw new StackUnderflowException();
        T result = this.array[this.top];
        this.top--;
        return result;
    }

}
