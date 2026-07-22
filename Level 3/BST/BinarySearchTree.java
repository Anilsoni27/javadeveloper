import java.util.Scanner;

public class BinarySearchTree {

    private TreeNode root;

    // Insert Node
    public TreeNode insert(TreeNode root, int data) {

        if (root == null) {
            System.out.println(data + " inserted successfully.");
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            System.out.println("Duplicate values are not allowed!");
        }

        return root;
    }

    // Search Node
    public boolean search(TreeNode root, int key) {

        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);

        return search(root.right, key);
    }

    // Delete Node
    public TreeNode delete(TreeNode root, int key) {

        if (root == null)
            return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {

            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            TreeNode successor = minValue(root.right);

            root.data = successor.data;

            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    // Minimum Value Node
    public TreeNode minValue(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Inorder Traversal
    public void inorder(TreeNode root) {

        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder Traversal
    public void preorder(TreeNode root) {

        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder Traversal
    public void postorder(TreeNode root) {

        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Count Nodes
    public int countNodes(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Height of Tree
    public int height(TreeNode root) {

        if (root == null)
            return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("      BINARY SEARCH TREE");
            System.out.println("=================================");
            System.out.println("1. Insert Node");
            System.out.println("2. Search Node");
            System.out.println("3. Delete Node");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Display All Traversals");
            System.out.println("8. Tree Statistics");
            System.out.println("9. Exit");
            System.out.println("=================================");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Value: ");
                    int value = sc.nextInt();
                    bst.root = bst.insert(bst.root, value);
                    break;

                case 2:
                    System.out.print("Enter Value to Search: ");
                    int key = sc.nextInt();

                    if (bst.search(bst.root, key))
                        System.out.println("Node Found!");
                    else
                        System.out.println("Node Not Found!");
                    break;

                case 3:
                    System.out.print("Enter Value to Delete: ");
                    int deleteValue = sc.nextInt();

                    if (bst.search(bst.root, deleteValue)) {
                        bst.root = bst.delete(bst.root, deleteValue);
                        System.out.println("Node Deleted Successfully!");
                    } else {
                        System.out.println("Node Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Inorder Traversal: ");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Preorder Traversal: ");
                    bst.preorder(bst.root);
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Postorder Traversal: ");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;

                case 7:
                    if (bst.root == null) {
                        System.out.println("Tree is Empty!");
                        break;
                    }

                    System.out.println("\n===== BST Traversals =====");

                    System.out.print("Inorder   : ");
                    bst.inorder(bst.root);
                    System.out.println();

                    System.out.print("Preorder  : ");
                    bst.preorder(bst.root);
                    System.out.println();

                    System.out.print("Postorder : ");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;

                case 8:
                    System.out.println("\n===== Tree Statistics =====");
                    System.out.println("Total Nodes : " + bst.countNodes(bst.root));
                    System.out.println("Tree Height : " + bst.height(bst.root));
                    break;

                case 9:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice! Please Try Again.");
            }
        }
    }
}