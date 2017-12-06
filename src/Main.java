
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int arraySize = 8;
        int minRnd = 10;
        int maxRnd = 100;
        int i;


        //MyArrayList
        System.out.println("MyArrayList");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(3);
        arrayList.add(20);
        arrayList.add(6);
        System.out.println("Добавили в лист " + arrayList.size() + " элемента.");
        System.out.println("Элемент под индексом 1 равняется " + arrayList.get(1));
        arrayList.remove(2);
        System.out.println("Удалили с индексом 0, теперь их количество - " + arrayList.size());
        arrayList.clear();
        System.out.println("Очистили лист, теперь количество элементов равняется - " + arrayList.size());

        //MyLinkedList
        System.out.println("MyLinkedList");
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Ferrari");
        linkedList.add("Audi");
        linkedList.add("Honda");
        System.out.println("Добавили в лист " + linkedList.size() + " элемента.");
        linkedList.remove(0);
        System.out.println("Удалили с индексом 0, теперь их количество - " + linkedList.size());
        System.out.println("Теперь элемент под индексом 1 - " + linkedList.get(1));
        linkedList.clear();
        System.out.println("Очистили лист, теперь количество элементов равняется - " + linkedList.size());

        //MyQueue
        System.out.println("MyQueue");
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(11);
        myQueue.add(22);
        myQueue.add(15);
        System.out.println("Добавили в очередь: " + myQueue.size());
        System.out.println("Первый элемент очереди: "+ myQueue.peek());
        System.out.println("Первый элемент очереди возвращаем и удаляем: " + myQueue.poll());
        System.out.println("Теперь количество элементов в очереди равняется: " + myQueue.size());
        myQueue.clear();
        System.out.println("Очистили все элементы и теперь их еоличество равняется: " + myQueue.size());

        //MyStack
        System.out.println("MyStack");
        MyStack<Integer> myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println("Добавили " + myStack.size() +" элемента в стэк.");
        myStack.remove(0);
        System.out.println("Удалили один элемент, теперь их - " + myStack.size());
        System.out.println("Сейчас значение первого элемента - " + myStack.peek());
        System.out.println("Возвратили 1-ый элемент " + myStack.pop() + " и удалили из коллекции." + " Сейчас значение первого элемента - " + myStack.peek());

        //MyHashMap
        System.out.println("MyHashMap");
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "Mars");
        myHashMap.put(2, "Sneakers");
        myHashMap.put(3, "Bounty");
        System.out.println("Добавили " + myHashMap.size() +" элемента в мапу.");
        myHashMap.remove(2);
        System.out.println("Удалили один элемент по ключу 3, теперь их - " + myHashMap.size());
        System.out.println("Возвращаем значение по ключу 1 - " + myHashMap.get(1));
        myHashMap.clear();
        System.out.println("Очистили мапу, теперь количество элементов равняется - " + myHashMap.size());
    }
}
