package Task12_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Список:");
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.appendFirst(10); // 10
        myArrayList.appendFirst(20); // 20 10
        myArrayList.appendFirst(30); // 30 20 10
        myArrayList.appendLast(40);     // 30 10 20 40
        myArrayList.show();
        myArrayList.appendPosition(50, 2); // 30 50 20 10 40
        myArrayList.show();
        myArrayList.min(); // 10
        myArrayList.max(); // 50
        myArrayList.remove(0); // 50 20 10 40
        myArrayList.show();
        myArrayList.sortAsc(); // 10 20 40 50
        myArrayList.show();
        myArrayList.sortDesc(); // 50 40 20 10
        myArrayList.show();

        System.out.println("\nСвязанный список:");
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.appendFirst(10); // 10
        myLinkedList.appendFirst(20); // 20 10
        myLinkedList.appendFirst(30); // 30 20 10
        myLinkedList.appendLast(40); // 30 10 20 40
        myLinkedList.show();
        myLinkedList.appendPosition(50,2); // 30 50 20 10 40
        myLinkedList.show();
        myLinkedList.min(); // 10
        myLinkedList.max(); // 50
        myLinkedList.remove(0); // 50 20 10 40
        myLinkedList.show();
        myLinkedList.replace(10,0);
        myLinkedList.show();





    }
}
