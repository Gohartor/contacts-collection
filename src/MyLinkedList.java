import java.util.*;



    /*
    • isEmpty
    • add(element)
    • add(index, element)
    • remove(element)
    • remove(index)
    • indexOf(element)
    */



public class MyLinkedList<T> implements List<T> {
    Node<T> head;
    int size;



    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }



    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }





    @Override
    public void add(int index, T element) {
        if (index > size) {
            System.out.println("this index ' " + index + " ' more than this Size ' " + size + " '");
        }

        Node<T> newNode = new Node<>(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }







    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(o)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(o)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        return false;
    }






    @Override
    public T remove(int index) {
        if (index >= size) {
            return null;
        }

        Node<T> removedNode;

        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = current.next.next;
        }
        size--;
        return removedNode.data;
    }




    @Override
    public int indexOf(Object o) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }






    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }



    class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

    }



    public class LinkedListIterator implements Iterator<T> {

        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                System.out.println("no element");
                return null;
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

















        @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }


    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<>();
        boolean added = list.add("car");
        System.out.println("added element? " + added);

        list.add("animal");
        list.add(0, "first");
        System.out.println("is empty? " + list.isEmpty());
        System.out.println("list: ");
        for (String s : list) {
            System.out.print(s);
            System.out.print( "  ");
        }

        System.out.println("\n--------------------------");
        System.out.println("index of animal: " + list.indexOf("animal"));
        boolean removed = list.remove("animal");
        System.out.println("anima removed? " + removed);
        System.out.println("list after removing: ");
        for (String s : list) {
            System.out.print(s);
            System.out.print( "  ");
        }


        System.out.println("\n--------------------------");
        String removedElement = list.remove(0);
        System.out.println("removed element '0': " + removedElement);
        System.out.println("list after removing: ");
        for (String s : list) {
            System.out.print(s);
            System.out.print( "  ");
        }
    }
}