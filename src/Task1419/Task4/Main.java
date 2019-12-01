package Task1419.Task4;

import Task12_2.MyList;

public class Main {
    public static void main(String[] args) {
        Integer[] source = {0,1,2,3,4};
        MyIterator myList = new MyIterator(source);
//        while (myList.hasNext()){
//            System.out.println(myList.next());
//        }

        System.out.println(myList.next()); // 0
        System.out.println(myList.next()); // 1
        System.out.println(myList.next()); // 2
        System.out.println(myList.prev()); // 1
        System.out.println(myList.prev()); // 0
        System.out.println(myList.next()); // 1
        System.out.println(myList.next()); // 2
        System.out.println(myList.next()); // 3
        System.out.println(myList.next()); // 4
        System.out.println(myList.next()); // null
        System.out.println(myList.prev()); // 3
        System.out.println(myList.prev()); // 2
        System.out.println(myList.next()); // 3

        System.out.println(myList.hasNext()); // false



    }
}
