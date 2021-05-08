import java.util.Scanner;


public class GenericTree {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        TreeNode root = createNode();
        printTree(root);

    }

        static TreeNode createNode(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter No. of Children: ");
            // "n" is the no. of children the new node will have
            int n = sc.nextInt();
            // "data" of the new node to be created
            System.out.println("Enter Data: ");
            int data = sc.nextInt();
            TreeNode node = new TreeNode(data, n);//The recursive call
            return node;
        }

        static void printTree(TreeNode node){
            System.out.println("Current Node is: "+ node.data);
            //array to store references of children of the node
            TreeNode[] alpha = node.listChildren;
            //print the children of the node
            System.out.println("No. of Children of "+ node.data+" are: "+node.noOfChildren);
            System.out.println("The Children are: \n");
            for(TreeNode eachChild : alpha){
                System.out.print(eachChild.data+"-");
            }
            System.out.println(" ");
            for(TreeNode eachChild : alpha){
                printTree(eachChild);//The recursive call
            }

        }

//class to instantiate nodes of a tree
    static public class TreeNode{
//class has data of node and number of child nodes it has
        private int data;
        private int noOfChildren;
        //an array of nodes to store references of child nodes of the root node in context.
        private TreeNode[] listChildren;
        //constructor to initialize object(the node) with data and its child nodes
        TreeNode(int d, int n){
            this.data = d;
            this.noOfChildren = n;
            this.listChildren = new TreeNode[n];
            this.addChildren();
        }
        //method to add children of a node
        private void addChildren(){
            for(int i=0; i<this.noOfChildren; i++)
                this.listChildren[i] =  createNode();
        }


    }
}
