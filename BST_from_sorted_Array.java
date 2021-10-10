public class BST_from_sorted_Array {

    class Node {
        int val;
        Node left, right;

        Node(int d) {
            this.val = d;
            left = right = null;
        }
    }

    public Node binSearchTree(int[] arr, int start, int end) {

        if (start > end)
            return null;

        int middle = start + (end - start) / 2;
        Node head = new Node(arr[middle]);

        head.left = binSearchTree(arr, start, middle - 1);
        head.right = binSearchTree(arr, middle + 1, end);
        return head;
    }

}
