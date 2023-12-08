/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

import java.util.Scanner;

/**
 *
 * @author Syed Dell
 */
public class LinkedList {

    private ListNode items; // First node in the linked list. Can find all the others
    // from this node
    private ListNode current; // the currently selected node in the list (set to last for now)

    /**
     * sets current to the first item in the linked list
     * <p>
     * New paragraph </p>
     */
    public void start() {
        current = items;

    }

    //if we are able to  move current forward
    public boolean advance() {
        //if current is last item in the lsit
        if (current.next == null) {
            return false;
        } else {
            //move current to the next item in the list
            current = current.next;
            return false;
        }

    }

    /**
     * Returns the data of the current node
     *
     * @return the data of the current node in Object format
     */
    //returns the current item
    public Object getCurrent() {
        return current.getData();
    }

    public void printCurrent() {
        System.out.println("The value of current is: " + current.getData().toString());
    }

    /**
     * Allows user to add a new list node at the end of the list
     *
     * @param inItem
     */
    //Allow the user to Add
    public void add(ListNode inItem) {
        //either the list in empty
        if (items == null) {
            //set the first item in list
            items = inItem;
            current = items;
        } //or its not
        else {
            ListNode temp = items;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = inItem;
            current = temp.next;
        }
    }

    public void print() {
        //if the lsit is empty
        if (items == null) {
            System.out.println("The list is empty");
        } else //if the lsit has data
        {
            ListNode temp2 = items;
            while (temp2 != null) {
                System.out.println(temp2.getData().toString());
                temp2 = temp2.next;
            }
        }
    }

    /**
     * Delete the current node from the linked list and makes the next node
     * current
     */
    public void deleteCurrent() {
    // If the list is empty, exit function
    if (items == null) {
        return;
    }

    // If the current node is the first node
    if (current == items) {
        items = items.next;
        current = items; // Update current to the new first node
    } else {
        // Make a pointer
        ListNode temp = items;

        // Navigate the list until the pointer is the item before current
        while (temp.next != null && temp.next != current) {
            temp = temp.next;
        }

        if (temp.next != null) {
            // Update the pointer to skip over the current node
            temp.next = current.next;

            // Move current to the next node (or null if it was the last node)
            current = current.next;
        }
    }
}


    /**
     * Add item before the current . If there is no list it makes the first
     * ListNode in the list
     *
     * @param items The new node be added
     */
    public void addBefore(ListNode inItem) {
        //if Empty
        if (items == null) {
            items = inItem;
        } // if current is first item
        else if (current == items) {
            inItem.next = current;
            items = inItem;
        } // if its last
        else {
            // make a pointer
            ListNode temp = items;

            //navigate the list until pinter is the item before current
            while (temp.next != current) {
                temp = temp.next;
            }
            // set the item before current to point to our new item
            temp.next = inItem;
        }
    }

    /**
     * This will add items after the node
     *
     * @param inItem
     */
    public void addAfter(ListNode inItem) {
        //if the list is empty
        if (items == null) {
            items = inItem;
            current = items;
        } else // make the new item the first item in the list
        {
            //if the list has data
            //set new items next to be currents old next o=if it has one
            inItem.next = current.next;
            current.next = inItem;
        }

        //if the list has data
        //set it to be the node after current
        // set new items next to be current old next
    }

    public static void main(String[] args) {
        // TODO code application logic here

        ListNode node1 = new ListNode("Node1 data");
        ListNode node2 = new ListNode("Node2 data");
        ListNode node3 = new ListNode("Node3 data");
        ListNode node4 = new ListNode("Node4 data");

        ListNode newNode = new ListNode("New node data");
        LinkedList ll = new LinkedList();

        System.out.println("===========================================");
        ll.add(node1);
        ll.add(node2);
        ll.add(node3);
        ll.add(node4);

        ll.print();
        ll.printCurrent();

        System.out.println("===========================================");
        ll.start();
        ll.advance();
        ll.advance();
        ll.printCurrent();
        ll.addBefore(newNode);
        ll.print();

        //set current to the start of the lsit
        do {
            //print out current item
            System.out.println(ll.getCurrent());
            //move item to the next item in the list
            ll.advance();

        } while (ll.advance());

        int menuOption = 0;
        while (menuOption != 8) {

            System.out.println("1. Add Before");
            System.out.println("2. Add After");
            System.out.println("3. Print");
            System.out.println("4. Get Current");
            System.out.println("5. Delete Current ");
            System.out.println("6. Advance ");
            System.out.println("7. Start ");
            System.out.println("8. Exit ");
            System.out.print("Select Option: ");
            Scanner userInput = new Scanner(System.in);
            menuOption = userInput.nextInt();

            switch (menuOption) {
                case 1 -> {
                    ll.addBefore(newNode);
                    System.out.println("The data of add before is " + ll.getCurrent().toString());
                }
                case 2 -> {
                    ll.addAfter(node1);
                    System.out.println("The data of add after is " + ll.getCurrent().toString());
                }
                case 3 -> ll.print();
                case 4 -> // current
                    System.out.println("The data of current is " + ll.getCurrent().toString());
                case 5 -> {
                    ll.deleteCurrent();
                    System.out.println("The data after delete current is " + ll.getCurrent().toString());
                }
                case 6 -> {
                    ll.advance();
                    System.out.println("The data of advance is " + ll.getCurrent().toString());
                }
                case 7 -> {
                    ll.start();
                    System.out.println("The data of start is " + ll.getCurrent().toString());
                }

            }
            //set current to start
                    }
        
    }
}
        //stop when current is at the end

//        
//        System.out.println("Node 1's Data");
//        String printout = (String)node1.data;
//        System.out.println(printout);
//        
//                
//        System.out.println("Node 2's Data");
//        System.out.println(node2.data.toString());
//        
//                System.out.println("Node 3's Data");
//        System.out.println(node3.data.toString());
//        
//        System.out.println("===========================================");
//        
//        node1.next = node2;
//        node2.next = node3;
//        System.out.println("Node 1.next Data");
//        System.out.println(node1.next.data.toString());
//        
//        System.out.println("Node 2.next Data");
//        System.out.println(node2.next.data.toString());
//        
//        
//        System.out.println("Node1's next.next   data");
//        System.out.println(node1.next.next.data.toString());
//        
