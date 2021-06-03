import java.util.*;
public class HelloWorld{


    static class Node{
        int data;
        Node prev;
        Node next;

        static Node getNode(int data){
            Node node = new Node();
            node.data= data;
            node.prev=node.next= null;
            return node;

        }
    }

    static class deque{
        int size;
        Node front, rear;

        deque(){
            front=rear=null;
            int size;
        }

        boolean isEmpty(){
            return (front == null);
        }

        int size(){
            return size;
        }

        void insertFront (int data){
            Node newNode = Node.getNode(data);
            if(newNode == null) System.out.println("overflow");

            else{
                if(front == null)
                    rear = front = newNode;
                else{
                    newNode.next=front;
                    front.prev= newNode;
                    front= newNode;

                }

                size++;
            }
        }

        void insertRear(int data){
            Node newNode = Node.getNode(data);
            if(newNode == null) System.out.println("overflow");
            else{
                if(rear == null)
                    front = rear= newNode;
                else{
                    newNode.prev= rear;
                    rear.next= newNode;
                    rear=newNode;
                }
                size++;
            }
        }

        void deleteFront(){
            if(isEmpty())
                System.out.println("underflow");
            else{
                Node temp= front;
                front= front.next;
                if(front == null) rear = null;
                else{
                    front.prev= null;
                }
                size--;
            }
        }

        void deleteRear(){
            if(isEmpty())  System.out.println("underflow");

            else{
                Node temp= rear;
                rear= rear.prev;
                if(rear == null) front = null;
                else{
                    rear.next= null;
                }
                size--;
            }
        }

        void eraseAll(){
            rear = null;
            while(front!=null){
                Node temp = front;
                front = front.next;
            }
            size=0;
        }

        int getFront(){
            if(isEmpty()) return -1;
            return front.data;

        }

        int getRear(){
            if(isEmpty()) return -1;
            return rear.data;
        }
    }



    public static void main(String []args){

        deque dq = new deque();
        System.out.print(
            "Insert element '5' at rear end\n");
        dq.insertRear(5);

        System.out.print(
            "Insert element '10' at rear end\n");
        dq.insertRear(10);
        System.out.print("Rear end element: " + dq.getRear()
            + "\n");
        dq.deleteRear();
        System.out.print(
            "After deleting rear element new rear"
                + " is: " + dq.getRear() + "\n");
        System.out.print(
            "Inserting element '15' at front end \n");
        dq.insertFront(15);
        System.out.print(
            "Front end element: " + dq.getFront() + "\n");

        System.out.print("Number of elements in Deque: "
            + dq.size() + "\n");
        dq.deleteFront();
        System.out.print("After deleting front element new "
            + "front is: " + dq.getFront()
            + "\n");
    }






}