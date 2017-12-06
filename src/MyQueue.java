public class MyQueue<T> {
    private MyNode<T> head;
    private int size;

    public void add(T value) {
        if (head == null)
            head = new MyNode<>(null, value, null);
        else {
            MyNode<T> tempNode = head;

            while (tempNode.getNext() != null)
                tempNode = tempNode.getNext();

            tempNode.setNext(new MyNode<>(null, value, null));
        }

        size++;
    }

    public boolean remove(int index) {
        if (index == 0 && index < size) {
            poll();

            return true;
        }

        if (index > 0 && index < size) {
            MyNode<T> prevNode = recursiveGet(head, 0, index - 1);
            MyNode<T> nodeForRemove = prevNode.getNext();
            MyNode<T> nextNode = nodeForRemove.getNext();

            prevNode.setNext(nextNode);
            nodeForRemove.setNext(null);

            nodeForRemove.setItem(null);
            size--;

            return true;
        }

        return false;
    }

    public void clear() {
        for (MyNode<T> tempNode = head; tempNode != null; ) {
            MyNode<T> nextNode = tempNode.getNext();
            tempNode.setItem(null);
            tempNode.setNext(null);
            tempNode = nextNode;
        }
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (head != null)
            return head.getItem();

        return null;
    }

    public T poll() {
        T result = null;

        if (head != null) {
            result = head.getItem();

            if (head.getNext() == null) {
                head.setItem(null);
                head = null;
            } else {
                MyNode<T> tempNode = head;
                head = head.getNext();
                tempNode.setItem(null);
                tempNode.setNext(null);
            }

            size--;
        }

        return result;
    }

    private MyNode<T> recursiveGet(MyNode<T> node, int point, int index) {
        if (point != index)
            return recursiveGet(node.getNext(), point + 1, index);
        else return node;
    }

    public T get(int index) {
        if (index >= 0 && index < size)
            return recursiveGet(head, 0, index).getItem();

        return null;
    }
}