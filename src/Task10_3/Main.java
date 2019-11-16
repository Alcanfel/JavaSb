package Task10_3;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.appendLast("I");
        myLinkedList.appendLast("Love");
        myLinkedList.appendLast("Java");
        myLinkedList.appendLast("and");
        myLinkedList.appendLast("Python");
        myLinkedList.appendFirst("A");
        myLinkedList.appendFirst("B");
        myLinkedList.appendFirst("C");
        myLinkedList.show();
    }
}
