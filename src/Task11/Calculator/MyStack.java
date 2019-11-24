package Task11.Calculator;

public class MyStack implements MyStackMethods{
    // Структура данных стек работает по принципу LIFO (Последний вошел - первый вышел)
    String[] stack;

    public MyStack(){
    }
    public MyStack(String[] b){
        this.stack = b.clone();
    }

    @Override
    public void push(String value) {
        if (this.stack == null){
            this.stack = new String[1];
            this.stack[0] = value;
        } else {
            String[] newStack = new String[this.stack.length+1];
            for (int i = 0; i <this.stack.length ; i++) {
                newStack[i] = this.stack[i];
            }
            newStack[newStack.length-1] = value;
            this.stack=newStack.clone();
        }
    }

    @Override
    public String pop() {
        if (this.stack.length>0){
            String result;
            result = this.stack[this.stack.length-1];
            String[] newStack = new String[this.stack.length-1];
            for (int i = 0; i < newStack.length; i++) {
                newStack[i] = this.stack[i];
            }
            this.stack = newStack.clone();
            return result;
        }
        else return null;

    }

    public void show(){
        for (int i = 0; i < this.stack.length; i++) {
            System.out.println(this.stack[i]);
        }
    }
    public boolean isNull(){
        if (this.stack == null){
            return true;
        } else if (this.stack.length == 0) {
            return true;
        } else return false;
    }

    public String printPop() {
        if (this.stack.length>0){
            String result;
            result = this.stack[this.stack.length-1];
            return result;
        }
        else return null;

    }

}
