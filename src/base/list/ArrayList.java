package base.list;

class ArrayList {
    int MAXSIZE;
    int length;
    int[] data;

    ArrayList() {
        this.length = 0;
        this.MAXSIZE = 100;
        this.data = new int[100];
    }

    public int size() {
        return length;
    }

    public boolean insert(int index, int e) {
        if (length == MAXSIZE || index < 0 || index > MAXSIZE - 1) return false;
        for (int i = length - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        length++;
        return true;
    }

    public int delete(int index) {
        if (index < 0 || index > length - 1) throw new RuntimeException();
        int temp = data[index];
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        length--;
        return temp;
    }

    public int get(int index) {
        if (index < 0 || index > length - 1) throw new RuntimeException();
        return data[index];
    }

    public int getIndex(int e){
        for (int i = 0; i < length; i++) {
            if(e==data[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            arrayList.insert(i,i+1);
        }
        arrayList.insert(4,999);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println();
        arrayList.delete(2);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println();
        System.out.println(arrayList.getIndex(999));
    }


}
