package Task10_3;

public class MyLinkedList {

    private Element firstElement;
    private Element lastElement;
    public int size = 0;

    // При создании экземпляра класса MyLinkedList, создаются два экземпляра класса Element:
    // 1. последний элемент - у которого значение null, ссылка на предыдущий элемент равен первый элемент, ссылка на следующий элемент null
    // 2. первый элемент - у которого значение null, ссылка на предыдущий элемент равен null, ссылка на следующий элемент последний элемент
    public MyLinkedList(){
        this.lastElement = new Element(null,this.firstElement,null);
        this.firstElement = new Element(null,null,this.lastElement);;
    }

    // Добавления списка в конец
    public void appendLast(String value){
        // Создаем новую ссылку на последний элемент и записываем на нее значение
        Element prev = this.lastElement;
        prev.setValue(value);
        // Создаем новый последний элемент, где предыдущий элемент равен prev
        this.lastElement = new Element(null, prev, null );
        // у нового элемента обновляем ссылку на следующий элемент - последний элемент
        prev.setNext(this.lastElement);
        size++;
    }
    public void appendFirst(String value){
        Element prev = this.firstElement;
        Element next = this.lastElement;
        prev.setValue(value);
        this.firstElement = new Element(null, null, prev );
        prev.setPrev(this.firstElement);
        size++;
    }

    //Вывести элементы списка
    public void show(){
        Element temp = firstElement.getNext();
        while (temp.getValue()!=null){
            System.out.print(temp.getValue()+" ");
            temp = temp.getNext();
        }
    }

    //Создаем элемент у которого есть ссылка след. элемент и предыдущий элемент
    private class Element{
        private String value;
        private Element next;
        private Element prev;



        private Element(String value, Element prev, Element next)
        {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        // Гетеры и сетеры для приватных свойств
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }
    }
}

