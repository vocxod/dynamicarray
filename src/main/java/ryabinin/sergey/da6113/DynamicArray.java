/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ryabinin.sergey.da6113;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author vragos
 */
public class DynamicArray<T> implements Serializable {
    private int length = 1024;
    private final int DELTA = 512;
    private int currIndex;
    private Object[] myArray;

    public DynamicArray() {
        myArray = new Object[this.length];
        currIndex = -1;
    }

    public void add(T el) {
        if (currIndex == length - 1) {
            // if last - need enhancing array.
            length += length + DELTA;
            Object[] newArray = new Object[length];
            for (int i = 0; i < myArray.length ; i++) {
                newArray[i] = myArray[i];
            }
            currIndex++;
            newArray[currIndex] = el;
            myArray = newArray;
        } else {
            currIndex++;
            myArray[currIndex] = el;
        }
    }

    public T get(int index) {
        if (index < 0 || index > currIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T)myArray[index];
    }
    public void remove(int index) {
        if (index < 0 || index > currIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object[] destination = new Object[length];
        int j = 0;
        for ( int i = 0; i < length; i++) {
            if (i == index) {
                // to skip remove index
                continue;
            }
            destination[j] = myArray[i];
            j++;
        }
        currIndex--;
        myArray = destination;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= currIndex; i++){
            if (myArray[i] != null) {
                sb.append(myArray[i]).append(':');
            }
        }
        return "DynamicArray: "+ " Len:" + length 
                + " CurrentIndex:" + currIndex
                + " [" + sb.toString() + "]";
    }
     
    public static void main(String[] args) {
        DynamicArray ad = new DynamicArray<Integer>();
        System.out.println("Empty class: " + ad);
        ad.add(100);
        System.out.println("After add: " + ad);
        ad.remove(0);
        System.out.println("After remove: " + ad);
        ad.add(100);
        ad.add(200);
        ad.add(300);
        ad.add(400);
        System.out.println("After add: " + ad);
        ad.remove(3);
        ad.remove(2);
        ad.remove(1);
        ad.remove(0);
        System.out.println("After remove: " + ad);
        ad.add(100);
        ad.add(200);
        ad.add(300);
        ad.add(400);
        System.out.println("After add: " + ad);
        ad.remove(ad.currIndex);
        ad.remove(ad.currIndex);
        ad.remove(ad.currIndex);
        ad.remove(ad.currIndex);
        System.out.println("After remove: " + ad);
    }
}
