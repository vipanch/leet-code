//package ads.tree;
//
//import org.junit.Test;
//
//public class Tree {
//    Node root;
//
//    @Test
//    public void test(){
//        Tree tree = new Tree();
//        tree.add(7);
//        tree.add(2);
//        tree.add(5);
//        tree.add(12);
//
//        Node n1 = tree.search(5);
//        Node n2 = tree.search(13);
//        Node n3 = tree.search(12);
//        System.out.print("done");
//
//        Node n = tree.nearestNode(17);
//        n = tree.nearestNode(1);
//        n = tree.nearestNode(3);
//        n = tree.nearestNode(6);
//        System.out.print("done");
//    }
//
//    private Node search(int data){
//        if(this.root==null) return null;
//        if(this.root.data==data) return root;
//        return search(this.root, data);
//    }
//
//    private Node search(Node node, int data){
//        if(node==null) return null;
//        if(node.data==data) return node;
//        if(node.data>data) return search(node.leftChild, data);
//        return search(node.rightChild, data);
//    }
//
//    public void add(int data){
//        if(this.root==null){
//            Node root = new Node();
//            root.data=data;
//            this.root = root;
//        }
//        else{
//            insert(root, data);
//        }
//    }
//
//    private void insert(Node root, int data){
//        if(root.data>=data){
//            if(root.leftChild==null){
//                Node nx = new Node();
//                nx.data=data;
//                root.leftChild=nx;
//            }else{
//                insert(root.leftChild, data);
//            }
//        }else{
//            if(root.rightChild==null){
//                Node nx = new Node();
//                nx.data=data;
//                root.rightChild=nx;
//            }else{
//                insert(root.rightChild, data);
//            }
//        }
//    }
//    public Node nearestNode(int data){
//        return nearestNode(this.root, data);
//    }
//
//    private Node nearestNode(Node node, int data){
//        if(node==null) return null;
//        if(node.data==data) return node;
//        if(node.data>data){
//            Node nearestOnLeft = nearestNode(node.leftChild, data);
//            if(nearestOnLeft==null) return  node;
//            if(Math.abs(nearestOnLeft.data-data)<Math.abs(node.data-data)) return nearestOnLeft;
//            return node;
//        }
//        Node nearestOnRight = nearestNode(node.rightChild, data);
//        if(nearestOnRight==null) return node;
//        if(Math.abs(nearestOnRight.data-data)<Math.abs(node.data-data)) return nearestOnRight;
//        return node;
//    }
//
//    public List<Integer> treeToList(){}
//}
