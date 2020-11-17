package datastructures.touro.edu;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @org.junit.jupiter.api.Test
    void size() {
        MyArrayList mal = new MyArrayList();
        for(int i = 0; i < 15; i++)
            mal.add("A");
        assertEquals(15, mal.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertTrue(!mal.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertTrue(mal.contains("A"));
    }

    @org.junit.jupiter.api.Test
    void iteratorHasNext() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        mal.add("B");
        Iterator<String> mali = mal.iterator();
        assertTrue(mali.hasNext());
    }

    @org.junit.jupiter.api.Test
    void iteratorNext() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        mal.add("B");
        Iterator<String> mali = mal.iterator();
        assertEquals("A", mali.next());
    }

    @org.junit.jupiter.api.Test
    void toArray() {
    }

    @org.junit.jupiter.api.Test
    void testToArray() {
    }

    @org.junit.jupiter.api.Test
    void add() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertEquals("A", mal.get(0));
    }

    @org.junit.jupiter.api.Test
    void addIndex() {
        MyArrayList mal = new MyArrayList();
        mal.add("B");
        mal.add(0, "A");
        assertEquals("A", mal.get(0));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        MyArrayList mal = new MyArrayList();
        ArrayList<String> al = new ArrayList<String>();
        mal.add("B");
        for(int i = 0; i < 15; i++)
            al.add("A");
        mal.addAll(0, al);
        mal.remove("A");
        assertEquals(null, mal.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeIndex() {
        MyArrayList mal = new MyArrayList();
        ArrayList<String> al = new ArrayList<String>();
        mal.add("B");
        for(int i = 0; i < 15; i++)
            al.add("A");
        mal.addAll(al);
        mal.remove(0);
        assertEquals("A", mal.get(0));
    }

    @org.junit.jupiter.api.Test
    void containsAll() {
    }

    @org.junit.jupiter.api.Test
    void addAll() {
        MyArrayList mal = new MyArrayList();
        ArrayList<String> al = new ArrayList<String>();
        for(int i = 0; i < 15; i++)
            al.add("A");
        mal.addAll(al);
        assertEquals("A", mal.get(14));
    }

    @org.junit.jupiter.api.Test
    void addAllConstructor() {
        ArrayList<String> al = new ArrayList<String>();
        for(int i = 0; i < 15; i++)
            al.add("A");
        MyArrayList mal = new MyArrayList(al);
        assertEquals("A", mal.get(14));
    }

    @org.junit.jupiter.api.Test
    void addAllIndex() {
        MyArrayList mal = new MyArrayList();
        ArrayList<String> al = new ArrayList<String>();
        mal.add("B");
        for(int i = 0; i < 15; i++)
            al.add("A");
        mal.addAll(0, al);
        assertEquals("B", mal.get(15));
    }

    @org.junit.jupiter.api.Test
    void testAddAll() {
    }

    @org.junit.jupiter.api.Test
    void removeAll() {
        MyArrayList mal = new MyArrayList();
        ArrayList<String> al = new ArrayList<String>();

        al.add("A");
        al.add("B");

        mal.addAll(al);

        mal.removeAll(al);
        assertEquals(null, mal.get(0));
    }

    @org.junit.jupiter.api.Test
    void retainAll() {
        MyArrayList mal = new MyArrayList();
        ArrayList<String> al = new ArrayList<String>();
        mal.add("A");
        mal.add("B");

        al.add("A");

        mal.retainAll(al);
        assertEquals("A", mal.get(0));
        assertNull(mal.get(1));
    }

    @org.junit.jupiter.api.Test
    void clear() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        mal.clear();
        assertTrue(mal.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void set() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertEquals("A", mal.set(0, "B"));
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertEquals(0, mal.indexOf("A"));
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertEquals(0, mal.lastIndexOf("A"));
    }

    @org.junit.jupiter.api.Test
    void listIterator() {
    }

    @org.junit.jupiter.api.Test
    void testListIterator() {
    }

    @org.junit.jupiter.api.Test
    void subList() {
    }
}