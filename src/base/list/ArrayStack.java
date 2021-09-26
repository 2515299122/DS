package base.list;

class ArrayStack {
    private final static int MAXSIZE = 100;
    int[] data;
    int top;

    ArrayStack() {
        this.data = new int[MAXSIZE];
        this.top = -1;
    }

    public boolean isEmpty(){
        return this.top==-1;
    }
    public boolean push(int e){
        if(top+1==MAXSIZE) return false;
        data[++top]=e;
        return true;
    }
    public Integer pop(){
        if(top<0) return null;
        return data[top--];
    }
    public Integer top(){
        if(top<0) return null;
        return data[top];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i+1);
        }
        arrayStack.pop();
        arrayStack.push(999);
        while (!arrayStack.isEmpty()){
            System.out.print(arrayStack.pop()+" ");
        }
    }
}
