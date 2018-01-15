package chapter3;


import java.util.Arrays;

/**
 * Created by xinchang on 2018/1/11.
 */
public class MyArrayList<AnyType> {

    private int defaultCapacity = 10;

    private int theSize;

    private AnyType[] theItems;

    private int assignSize;

    public MyArrayList() {
        theItems = (AnyType[]) new Object[defaultCapacity];
    }

    public MyArrayList(int assignSize) {
        this.assignSize = assignSize;
        theItems = (AnyType[]) new Object[assignSize];
    }

    public int size() {
        return theSize;
    }

    public boolean add(AnyType newParams) {
        add(size(), newParams);
        return true;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        theItems = (AnyType[]) new Object[defaultCapacity];
        theSize = 0;
    }

    public void add(int idx, AnyType newParams) {
        if (idx < 0 || idx > size()) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }

        if (theItems.length == size()) {
            ensureCapacity(theItems.length);
        }

        if (idx == size()) {
            theItems[idx] = newParams;
        } else {
            for (int i = size() - 1; i >= idx; i--) {
                theItems[i + 1] = theItems[i];
            }
            theItems[idx] = newParams;
        }
        theSize++;
    }

    public AnyType set(int idx, AnyType newParams) {
        if (idx < 0 || idx > size()) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        AnyType old = theItems[idx];
        theItems[idx] = newParams;
        return old;
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx > size()) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        return theItems[idx];
    }

    public AnyType remove(int idx) {
        if (idx < 0 || idx > size()) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        AnyType old = null;
        old = theItems[idx];
        if (idx == size() - 1) {
            theItems[idx] = null;
        } else {
            for (int i = idx; i < size(); i++) {
                theItems[i] = theItems[i + 1];
            }
        }
        theSize--;
        return old;
    }

    public void ensureCapacity(int capacitySize) {
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[capacitySize * 2 + 1];
        for (int i = 0; i < old.length; i++) {
            theItems[i] = old[i];
        }
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        for (int i = 0; i < size(); i++) {
            buffer.append(theItems[i]);
            if (i != size() - 1) {
                buffer.append(" , ");
            }
        }
        buffer.append("}");
        return buffer.toString();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(20);
        System.out.println(myArrayList.isEmpty());
        //增
        for (int i = 0; i < 12; i++) {
            myArrayList.add(i);
        }
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.toString());

        myArrayList.add(2, 20);
        System.out.println(myArrayList.toString());

//        //删
        myArrayList.remove(2);
        System.out.println(myArrayList.toString());
        System.out.println(myArrayList.size());

        //清空
        myArrayList.clear();
        System.out.println(myArrayList.toString());
        for(int i = 0 ; i < 12 ; i++) {
            myArrayList.add(i);
        }
        System.out.println(myArrayList.toString());
        //get
        System.out.println(myArrayList.get(2));
        //set
        myArrayList.set(2, 10);
        System.out.println(myArrayList.toString());
    }

}
