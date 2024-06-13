// creating the binarytree


import java.util.*;
public class BuildingTree{
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    static class BuildTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;

        }

        // creating preorder ---0(n);
        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }


        // creating inorder ---0(n);
        public static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }


        // creating postorder  ---0(n);
        public static void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }


        // level order Traversal -- using BFS ---0(n);

        public static void printLevelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }


        // ---------counting the number of nodes---O(n) Because each node should be recursively touced only one time-------
        public static int CountNode(Node root){
            if(root==null){
                return 0;
            }
            int leftCount = CountNode(root.left);
            int rightCount = CountNode(root.right);
            int count = leftCount+rightCount+1;
            return count;
        }


        // ---------counting the number of nodes----O(n)------
        public static int SumNode(Node root){
            if(root==null){
                return 0;
            }
            int leftdata = SumNode(root.left);
            int rightdata = SumNode(root.right);
            int NodeSum = leftdata+rightdata+root.data;
            return NodeSum;
        }


        // ---------height the Tree----O(n)------
        public static int TreeHeight(Node root){
            if(root==null){
                return 0;
            }
            int leftdata = TreeHeight(root.left);
            int rightdata = TreeHeight(root.right);
            int height = Math.max(leftdata,rightdata)+1;
            return height;
        }


        // ------------Diameter of the tree------O(N^2)--

        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int diam1 = diameter(root.left);
            int diam2 = diameter(root.right);
            int diam3 = TreeHeight(root.left)+TreeHeight(root.right)+1;
            
            return Math.max(diam3, Math.max(diam1, diam2));
        }


        // --------Approach 2 : for finding the diameter of the tree------O(N)-----

        static class TreeInfo{
            int ht;
            int diam;
            public TreeInfo(int ht, int diam){
                this.ht = ht;
                this.diam= diam;
            }
        }


        public static TreeInfo Diameter2(Node root){
            if(root==null){
                return new TreeInfo(0,0);
            }

            TreeInfo left = Diameter2(root.left);
            TreeInfo right = Diameter2(root.right);
            int myheight = Math.max(left.ht, right.ht)+1;

            int diam1 = left.diam;
            int diam2 = right.diam;
            int diam3 = left.ht+right.ht+1;
            int mydiam = Math.max(Math.max(diam1, diam2),diam3);

            TreeInfo myinfo = new TreeInfo(myheight, mydiam);
            return myinfo;
        }


    }
    public static void main(String[]args){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BuildTree tree = new BuildTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preorder(root);
        // System.out.println();
        // tree.inorder(root);
        // System.out.println();
        // tree.postorder(root);
        // System.out.println();
        // tree.printLevelOrder(root);
        // System.out.println(tree.CountNode(root));
        // System.out.println(tree.SumNode(root));
        // System.out.println(tree.TreeHeight(root));
        // System.out.println(tree.diameter(root));
        System.out.println(tree.Diameter2(root).diam);
}
}