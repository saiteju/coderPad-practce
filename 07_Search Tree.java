import java.util.*;
public class HelloWorld{

    static class BST{
        private static class Node{
            Integer val;
            Node left;
            Node right;
        }
        private Node root;
        public BST(){
            this.root= new Node();
        }

        public void put(int value){
            putInValue(root, value);
        }

        private void putInValue(Node node, int value){

            if(node.val == null){
                node.val= value;
                return;
            }
            if(node.val < value){
                if(node.right == null){
                    Node p= new Node();
                    node.right= p;
                    p.val= value;
                    return;
                }
                else{
                    putInValue(node.right, value);
                }

            }
            else{
                if(node.left== null){
                    Node p= new Node();
                    node.left= p;
                    p.val= value;
                    return;
                }
                else{
                    putInValue(node.left, value);
                }
            }
        }

        public Boolean contains(int value){
            return findVal( root, value);
        }

        private Boolean findVal(Node node, int value){
            if(node == null)
                return false;
            if(node.val == value)
                return true;
            return (findVal(node.left, value)) ||   (findVal(node.right, value))  ;

        }

        public List<Integer> inverseOrder(){
            final List<Integer> array = new ArrayList<Integer>();
            InVerseOrderSort(root, array);
            return array;
        }

        private void InVerseOrderSort(Node node, List<Integer> array){
            if(node == null){
                return;
            }
            InVerseOrderSort(node.left, array);
            array.add(node.val);
            InVerseOrderSort(node.right , array);
        }



    }


    public static void main(String []args){

        BST searchTree = new BST();
        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(-1);
        searchTree.put(2);

        System.out.println(searchTree.contains(-1));

        System.out.println(searchTree.inverseOrder());



    }
}