package generic.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleUniqueList<T> implements ListContainer<T>{

    private T[] array;

    private int size;

    private int modCount;

    public SimpleUniqueList(int initialCapacity) {
        this.array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T value) {
        if (size == array.length) {
            resize(size * 2);
        }
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (value == array[i]) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            array[size++] = value;
        }

    }

    @Override
    public T set(int index, T newValue) {
        array[index] = newValue;
        return newValue;
    }

    @Override
    public T remove(int index) {
        T result = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;

        return result;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0 , newArray, 0, size);
        array = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && array[currentIndex] != null;
            }

            @Override
            public T next() {
                if (currentIndex >= size) {
                    throw new ConcurrentModificationException();
                }
                return array[currentIndex++];
            }
        };
    }
}