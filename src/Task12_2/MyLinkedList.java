package Task12_2;

public class MyLinkedList implements MyList {
    private Element firstElement;
    private Element lastElement;
    private int size = 0;

    // При создании экземпляра класса MyLinkedList, создаются два экземпляра класса Element:
    // 1. последний элемент - у которого значение null, ссылка на предыдущий элемент равен первый элемент, ссылка на следующий элемент null
    // 2. первый элемент - у которого значение null, ссылка на предыдущий элемент равен null, ссылка на следующий элемент последний элемент
    public MyLinkedList() {
        this.lastElement = new Element(null, this.firstElement, null);
        this.firstElement = new Element(null, null, this.lastElement);
        ;
    }


    @Override
    public void appendLast(Integer value) {
        // Создаем новую ссылку на последний элемент и записываем на нее значение
        Element prev = this.lastElement;
        prev.setValue(value);
// Создаем новый последний элемент, где предыдущий элемент равен prev
        this.lastElement = new Element(null, prev, null);
// у нового элемента обновляем ссылку на следующий элемент - последний элемент
        prev.setNext(this.lastElement);
        size++;
    }

    @Override
    public void appendPosition(Integer value, Integer position) {
        Element temp = firstElement.getNext();
        int i = 1;
        while (temp.getValue() != null) {
            if (i == position) {
                Element pred = temp;
                Element a = new Element(value, temp.getPrev(), temp);
                if (!(temp.getPrev() == null)) {
                    temp.getPrev().setNext(a);
                    temp.setPrev(a);
                } else this.firstElement.setNext(a);
            }
            temp = temp.getNext();
            i++;
        }
    }

    @Override
    public void appendFirst(Integer value) {
        Element prev = this.firstElement;
        prev.setValue(value);
        this.firstElement = new Element(null, null, prev);
        prev.setPrev(this.firstElement);
        prev.getNext().setPrev(prev);
        size++;
    }

    //Вывести элементы списка
    public void show() {
        Element temp = firstElement.getNext();
        while (temp.getValue() != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    @Override
    public void size() {
        System.out.println(String.format("Размер списка %d ", this.getSize()));
    }

    @Override
    public void replace(Integer value, Integer index) {
        if (index > this.getSize() || index < 0) {
            System.out.println("Вы вышли за пределы индекса");
        } else {
            Element temp = firstElement.getNext();
            int i = 0;
            while (i <= index) {
                if (i == index) {
                    temp.setValue(value);
                }
                temp = temp.getNext();
                i++;
            }
        }

    }

    @Override
    public void remove(Integer index) {
        Element temp = firstElement.getNext();
        int i = 0;
        while (temp.getValue() != null) {
            if (i == index) {
                System.out.println(temp.getValue());
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
//                temp.setPrev(null);
//                temp.setNext(null);
                break;
            }
            temp = temp.getNext();
            i++;
        }
    }

    @Override
    public void max() {
        Element temp = firstElement.getNext();
        int oporElem = Integer.MIN_VALUE;
        while (temp.getValue() != null) {
            if (temp.getValue() > oporElem) {
                oporElem = temp.getValue();
            }
            temp = temp.getNext();
        }
        System.out.println(oporElem);
    }

    @Override
    public void min() {
        Element temp = firstElement.getNext();
        int oporElem = Integer.MAX_VALUE;
        while (temp.getValue() != null) {
            if (temp.getValue() < oporElem) {
                oporElem = temp.getValue();
            }
            temp = temp.getNext();
        }
        System.out.println(oporElem);
    }


    public Integer getSize() {
        return this.size;
    }

    //Создаем элемент у которого есть ссылка след. элемент и предыдущий элемент
    private class Element {
        private Integer value;
        private Element next;
        private Element prev;


        private Element(Integer value, Element prev, Element next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        // Гетеры и сетеры для приватных свойств


        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
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