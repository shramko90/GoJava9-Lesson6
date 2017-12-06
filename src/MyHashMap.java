public class MyHashMap<T, K> {
    private int size;
    private NodeForHashMap<T, K> start;

    public boolean put(T key, K value) {
        if (!isExist(key)) {
            if (start == null)
                start = new NodeForHashMap<>(key, value, null);
            else {
                NodeForHashMap<T, K> tempNode = start;

                while (tempNode.getNext() != null)
                    tempNode = tempNode.getNext();

                tempNode.setNext(new NodeForHashMap(key, value, null));
            }

            size++;
            return true;
        }

        return false;
    }

    public boolean remove(T key) {
        if (isExist(key)) {
            NodeForHashMap<T, K> prevNode = null;
            NodeForHashMap<T, K> nodeForRemove = start;

            while (nodeForRemove.getNext() != null) {
                if (nodeForRemove.getKey() == key)
                    break;

                prevNode = nodeForRemove;
                nodeForRemove = nodeForRemove.getNext();
            }

            if (prevNode == null)
                start = nodeForRemove.getNext();
            else
                prevNode.setNext(nodeForRemove.getNext());

            nodeForRemove.setNext(null);
            nodeForRemove.setKey(null);
            nodeForRemove.setValue(null);

            size--;
            return true;
        }

        return false;
    }

    public void clear() {
        for (NodeForHashMap<T, K> tempNode = start; tempNode != null; ) {
            NodeForHashMap<T, K> nextNode = tempNode.getNext();
            tempNode.setNext(null);
            tempNode.setKey(null);
            tempNode.setValue(null);
            tempNode = nextNode;
        }
        start = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public K get(T key) {
        if (start != null) {
            return getNode(key).getValue();
        }

        return null;
    }

    public boolean isExist(T key) {
        if (getNode(key) != null)
            return true;

        return false;
    }

    public NodeForHashMap<T, K> getNode(T key) {
        if (start != null) {
            NodeForHashMap<T, K> tempNode = start;

            while (tempNode != null) {
                if (tempNode.getKey() == key)
                    return tempNode;

                tempNode = tempNode.getNext();
            }
        }

        return null;
    }

    public NodeForHashMap<T, K> getNode(int index) {
        if (index >= 0 && index < size) {
            return recursiveGet(start, 0, index);
        }

        return null;
    }

    private NodeForHashMap<T, K> recursiveGet(NodeForHashMap<T, K> node, int point, int index) {
        if (point != index)
            return recursiveGet(node.getNext(), point + 1, index);
        else return node;
    }
}