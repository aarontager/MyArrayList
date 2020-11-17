package datastructures.touro.edu;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList implements List<String> {

    private String[] backingStore = new String[10];
    private int insertionPoint = 0;

    public MyArrayList() {

    }

    public MyArrayList(Collection<?extends String> c) {
        if(c == null)
            throw new NullPointerException();

        addAll(c);
    }

    public MyArrayList(int initialCapacity) {
        if(initialCapacity < 0)
            throw new IllegalArgumentException();

        backingStore = new String[initialCapacity];
    }

    @Override
    public int size() {
        return insertionPoint;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size(); i++) {
            if(backingStore[i].equals(o))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < insertionPoint;
        }

        @Override
        public String next() {
            return backingStore[index++];
        }
    }

    @Override
    public Object[] toArray() {
        String[] array = new String[size()];
        System.arraycopy(backingStore, 0, array, 0, size());
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        if(insertionPoint == backingStore.length) {
            expandArray();
        }
        backingStore[insertionPoint++] = s;
        return true;
    }

    private void expandArray() {
        int currentSize = backingStore.length;
        String[] temp = new String[currentSize * 2 + 1];
        System.arraycopy(backingStore, 0, temp, 0, backingStore.length);
        backingStore = temp;
    }

    @Override
    public boolean remove(Object o) {
        int idx = indexOf(o);
        if(idx == -1)
            return false;

        backingStore[idx] = null;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        if(c == null)
            throw new NullPointerException();

        ensureCapacity(insertionPoint + c.size());

        for(String s : c) {
            backingStore[insertionPoint++] = s;
        }
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if(insertionPoint + minCapacity >= backingStore.length) {
            int currentSize = backingStore.length;
            String[] temp = new String[currentSize + minCapacity];
            System.arraycopy(backingStore, 0, temp, 0, backingStore.length);
            backingStore = temp;
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        if(c == null)
            throw new NullPointerException();
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        ensureCapacity(insertionPoint + c.size());

        System.arraycopy(backingStore, index, backingStore, index + c.size(), backingStore.length - (c.size() + 1));
        for(String s : c) {
            backingStore[index++] = s;
        }
        insertionPoint += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if(c == null)
            throw new NullPointerException();

        boolean changed = false;

        for (int i = 0; i < backingStore.length; i++) {
            if(c.contains(backingStore[i])) {
                backingStore[i] = null;
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if(c == null)
            throw new NullPointerException();

        boolean changed = false;

        for (int i = 0; i < backingStore.length; i++) {
            if(!c.contains(backingStore[i])) {
                backingStore[i] = null;
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public void clear() {
        backingStore = new String[10];
        insertionPoint = 0;
    }

    @Override
    public String get(int index) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        return backingStore[index];
    }

    @Override
    public String set(int index, String element) {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        String old = get(index);
        backingStore[index] = element;
        return old;
    }

    @Override
    public void add(int index, String element) {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        if(insertionPoint >= backingStore.length - 1)
            expandArray();

        System.arraycopy(backingStore, index, backingStore, index + 1, backingStore.length - (index + 1));
        backingStore[index] = element;
        insertionPoint++;
    }

    @Override
    public String remove(int index) {
        String element = backingStore[index];
        System.arraycopy(backingStore, index + 1, backingStore, index, backingStore.length - (index + 1));
        insertionPoint--;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size(); i++) {
            if(backingStore[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size(); i > 0; i--) {
            if(backingStore[i - 1].equals(o))
                return i - 1;
        }
        return -1;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    public void trimToSize() {
        String[] temp = new String[size()];
        System.arraycopy(backingStore, 0, temp, 0, size());
        backingStore = temp;
    }
}
