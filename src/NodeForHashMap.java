public class NodeForHashMap<T,K> {
    private T key;
    private K value;
    private NodeForHashMap next;

    public NodeForHashMap(T key, K value, NodeForHashMap next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }

    public NodeForHashMap getNext() {
        return next;
    }

    public void setNext(NodeForHashMap next) {
        this.next = next;
    }
}