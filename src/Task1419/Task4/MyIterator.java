package Task1419.Task4;

public class MyIterator implements MyIter {
    Integer[] a;
    Integer next;
    Integer prev;
    Integer size;

    public MyIterator(){

    }
    public MyIterator(Integer[] source){
        this.a = source;
        this.next = 0;
        this.prev = 0;
        this.size = source.length;
    }

    @Override
    public boolean hasNext() {
        if (this.next < this.size){
            return true;
        } else return false;
    }

    @Override
    public Integer next() {
        if (this.hasNext()){
            Integer count = this.next;
            this.prev=this.next;
            this.next+=1;
            return this.a[count];
        } else return null;
    }

    @Override
    public Integer prev() {
        if (this.next == 0){
            return 0;
        } else {
            Integer count = this.prev-1;
            this.next = this.prev;
            this.prev-=1;
            return this.a[count];
        }
    }
}
