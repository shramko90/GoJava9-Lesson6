public class MyLinkedList<T> {
    private MyNode<T> first;
    private MyNode<T> last;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    public void add(T value) {
        MyNode<T> lastNode = last;
        MyNode<T> tempNode = new MyNode<>(last, value, null);
        last = tempNode;

        if (lastNode == null)
            first = tempNode;
        else
            lastNode.setNext(tempNode);

        size++;
    }

    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            MyNode<T> nodeForRemove = recursiveGet(first, 0, index);
            MyNode<T> prevNode = nodeForRemove.getPrev();
            MyNode<T> nextNode = nodeForRemove.getNext();

            if (prevNode == null) {
                first = nextNode;
            } else {
                prevNode.setNext(nextNode);
                nodeForRemove.setPrev(null);
            }

            if (nextNode == null) {
                last = prevNode;
            } else {
                nextNode.setPrev(prevNode);
                nodeForRemove.setNext(null);
            }

            nodeForRemove.setItem(null);
            size--;

            return true;
        }
        return false;
    }

    public void clear() {
        for (MyNode<T> tempNode = first; tempNode != null; ) {
            MyNode<T> nextNode = tempNode.getNext();
            tempNode.setItem(null);
            tempNode.setNext(null);
            tempNode.setPrev(null);
            tempNode = nextNode;
        }
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= 0 && index < size)
            return recursiveGet(first, 0, index).getItem();

        return null;
    }

    private MyNode<T> recursiveGet(MyNode<T> node, int point, int index) {
        if (point != index)
            return recursiveGet(node.getNext(), point + 1, index);
        else return node;
    }
}