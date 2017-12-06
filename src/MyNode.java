public class MyNode<T> {
    private T item;
    private MyNode<T> next;
    private MyNode<T> prev;

    public MyNode(MyNode<T> prev, T element, MyNode<T> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }

    public MyNode<T> getPrev() {
        return prev;
    }

    public void setPrev(MyNode<T> prev) {
        this.prev = prev;
    }
}