class BinarySearchTree {

    private class BinaryNode {
        private int element;
        private BinaryNode left;
        private BinaryNode right;

        private BinaryNode(int element) {
            this.element = element;
        }
    }

    private BinaryNode root;

    void insert(int newNumber) {
        if (root == null) {
            root = new BinaryNode(newNumber);
            return;
        }

        BinaryNode parent = null;
        BinaryNode child = root;
        while (child != null) {
            parent = child;
            if (newNumber == child.element) {
                return;
            } else if (newNumber < child.element) {
                child = child.left;
            } else {
                child = child.right;
            }
        }

        if (newNumber < parent.element) {
            parent.left = new BinaryNode(newNumber);
        } else {
            parent.right = new BinaryNode(newNumber);
        }
    }

    int maximumRecursive() {
        if (root == null) {
            throw new java.util.NoSuchElementException();
        }
        return maximumRecursive(root);
    }

    private int maximumRecursive(BinaryNode current) {
        if (current.right == null) {
            return current.element;
        }
        return maximumRecursive(current.right);
    }

    int maximumIterative() {
        if (root == null) {
            throw new java.util.NoSuchElementException();
        }

        BinaryNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.element;
    }

    int height() {
        return height(root);
    }

    private int height(BinaryNode current) {
        if (current == null) {
            return 0;
        }

        int leftHeight = height(current.left);
        int rightHeight = height(current.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    int sum() {
        return sum(root);
    }

    private int sum(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        return root.element + sum(root.left) + sum(root.right);
    }

    String reverseOrder() {
        return reverseOrder(root);
    }

    private String reverseOrder(BinaryNode current) {
        if (current == null) {
            return "";
        }
        return reverseOrder(current.right) + current.element + ", " + reverseOrder(current.left);
    }
}
