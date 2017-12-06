public class MyArrayList<T> {

    private static final int INIT_SIZE = 16;
    private static final int INC_RATE = 2;
    private static final int CUT_RATE = 4;

    private Object[] array;

    private int init =0;

    public MyArrayList() {
        this.array = new Object[INIT_SIZE];
    }

    public void add(T value){

        if (init==array.length -1)
            resize(array.length * INC_RATE);

        array[init++] = value;

    }

    public boolean remove(int index){
        if (index>=0 && index < init){
            System.arraycopy(array,index+1,array,index,init-index);
            array[--init]=null;

            if (array.length>INIT_SIZE && init<array.length/CUT_RATE)
                resize(array.length/INC_RATE);

            return true;
        }

        return false;
    }

    public void clear(){

        if (init>0){
            for (int i =0; i<init; i++)
                array[i]=null;
            array = new Object[INIT_SIZE];
            init=0;
        }
    }

    public T get(int index) {
        if (index >= 0 && index < init) return (T) array[index];
        return null;
    }

    public void resize(int length){

        Object[] newArray = new Object[length];
        //System.arraycopy(array,0,newArray,0,start);
        for (int i =0; i<array.length; i++){
            newArray[i]=array[i];
            array=newArray;
        }
    }

    public int size() {
        return init;
    }
}
