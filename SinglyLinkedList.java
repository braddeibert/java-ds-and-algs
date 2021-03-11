import nodes.ListNode;
import java.util.Random;

public class SinglyLinkedList {
  private ListNode root;
  private ListNode head;
  private int size;
  
  public SinglyLinkedList(ListNode node) {
    root = node;
    head = node;
    size = 1;
  }

  public int size() {
    return size;
  }

  public void append(ListNode node) {
    if (root == head) {
      root.next = node;
    }

    head.next = node;
    head = node;
    size++;
  }
  
  public void prepend(ListNode node) {
    node.next = root;
    root = node;
    size++;
  }

  public void insertNode(ListNode node, int pos) {
    int i = 0;
    ListNode current = root;
    ListNode prev = null;

    if (pos == 0) { 
      prepend(node); 
      return; 
    }
    if (pos == size - 1) { 
      append(node); 
      return; 
    }

    while (true) {
      if (i == pos) {
        prev.next = node;
        node.next = current;
        size++;
        return;
      }
      if (i + 1 == pos) {
        prev = current;
      }

      current = current.next;
      i++;
    }
  }

  public void removeNode(int val) {
    ListNode toRemove = getNode(val);

    if (toRemove == null) { 
      System.out.println("Node not found in list.");
      return;
    }

    ListNode current = root;

    while (true) {
      if (current.next == toRemove) {
        current.next = toRemove.next;
        size--;
        break;
      }

      current = current.next;
    }

    return;
  }

  public void removeIndex(int pos) {
    int i = 0;
    ListNode current = root;
    ListNode prev = null;

    if (pos >= size || pos < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (pos == 0) {
      root = root.next;
      size--;
      return;
    }
    if (pos == size - 1) {
      head = getIndex(pos-1);
      head.next = null;
      size--;
      return;
    }

    while (true) {
      if (i == pos) {
        prev.next = current.next;
        size--;
        return;
      }
      if (i + 1 == pos) {
        prev = current;
      }
      
      current = current.next;
      i++;
    }
  }

  public ListNode getIndex(int pos) {
    int i = 0;
    ListNode current = root;

    while (current != null) {
      if (i == pos) {
        return current;
      }
      
      current = current.next;
      i++;
    }

    return null;
  }

  public ListNode getNode(int val) {
    ListNode current = root;

    while (current != null) {
      if (current.value == val) {
        return current;
      }

      current = current.next;
    }

    return null;
  }

  public ListNode getHead() {
    return head;
  }

  public ListNode getRoot() {
    return root;
  }

  public void printReverse(ListNode node) {
    if (node == null) return;
    printReverse(node.next);
    System.out.println(node.value);
  }

  public void printList() {
    ListNode current = root;

    while (current != null) {
      System.out.println(current.value);
      current = current.next;
    }
  }

  public static void main(String args[]) {
    ListNode test = new ListNode(50);
    SinglyLinkedList list = new SinglyLinkedList(test);
    Random r = new Random();

    // append/prepend 4 random nodes
    for (int i = 0; i < 4; i++) {
      int randomInt = r.nextInt(100);
      System.out.println("Random num " + i + " " + randomInt);
      ListNode testing = new ListNode(randomInt);
        
      if (i % 2 == 0) list.append(testing);
      else list.prepend(testing);
    }
    System.out.println("Randomly generated list:");
    list.printList();

    // insert '24' at position 3
    System.out.println("Insert 24 at position 3 in list:");
    ListNode testing = new ListNode(24);
    list.insertNode(testing, 3);
    list.printList();

    // print in reverse
    System.out.println("Print list in reverse");
    list.printReverse(list.getRoot());

    // remove 3rd item in list
    System.out.println("Remove 3rd item in list:");
    list.removeIndex(3);
    list.printList();

    // remove first and last items
    System.out.println("Remove first and last items:");
    list.removeIndex(0);
    list.removeIndex(list.size()-1);
    list.printList();

    // get '50' from list
    System.out.println("Remove 50 from list");
    list.removeNode(50);
    list.printList();

    System.out.println("The list's final root: " + list.getRoot().value);
    System.out.println("The list's final head: " + list.getHead().value);
    System.out.println("The list's final size is: " + list.size());
  }
}
