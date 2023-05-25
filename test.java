import java.util.*;
import java.util.regex.*;

public class TreeTestQ {
    public static void main(String... args) {

        // Tree first = new Tree("1(2,4, 6) 2(3, 9) 4(5,7)  6(11,12 ) 5(13,16)   12(14, 23, 17) 16( 24,32 )");
        // assertTrue(first.getLevelOfNodeWithId(1) == 5);
        // assertTrue(first.getLevelOfNodeWithId(4) == 4);
        // assertTrue(first.getLevelOfNodeWithId(5) == 3);
        // assertTrue(first.getLevelOfNodeWithId(12) == 3);
        // assertTrue(first.getLevelOfNodeWithId(16) == 2);
        // assertTrue(first.getLevelOfNodeWithId(23) == 2);
        // assertTrue(first.getLevelOfNodeWithId(32) == 1);

        Tree second = new Tree(" 2(5, 4, 3,1)  5(7)   3(9) 7(12, 10)   9(11, 14)  10(13) 13(16,8,15)");
        // assertTrue(second.getLevelOfNodeWithId(2) == 6);
        // assertTrue(second.getLevelOfNodeWithId(5) == 5);
        // assertTrue(second.getLevelOfNodeWithId(3) == 5);
        // assertTrue(second.getLevelOfNodeWithId(12) == 3);
        // assertTrue(second.getLevelOfNodeWithId(11) == 3);
        // assertTrue(second.getLevelOfNodeWithId(13) == 2);
        // assertTrue(second.getLevelOfNodeWithId(8) == 1);

        System.out.println(second.getLevelOfNodeWithId(2));
        System.out.println(second.getLevelOfNodeWithId(5));
        System.out.println(second.getLevelOfNodeWithId(3));
        System.out.println(second.getLevelOfNodeWithId(12));
        System.out.println(second.getLevelOfNodeWithId(11));
        System.out.println(second.getLevelOfNodeWithId(13));
        System.out.println(second.getLevelOfNodeWithId(8));
        System.out.println(second.getLevelOfNodeWithId(100));
    }

    private static void assertTrue(boolean v) {
        if(!v) {
            Thread.dumpStack();
            System.exit(0);
        }
    }
}

class Tree {
    private Node root;

    public Tree(String treeData) {
        root = constructTree(treeData);
    }

    private Node constructTree(String treeData){
        Node root = null;
        // Merapikan semua spasi yang ada di dalam kurung.
        String output = treeData.replaceAll("\\s+(?=[^()]*\\))", "");

        // split string nya menjadi array based on one or more space
        String[] nodes = output.split("\\s+");

        for (String node : nodes) {
            // split lagi string nya berdasarkan tanda kurung
            String[] parts = node.split("[()]");
            
            // convert string ke integer
            if(parts[0].equals("")){
                continue;
            }

            int nodeId = Integer.parseInt(parts[0]);


            // check apakah ini node pertama yang ingin dimasukkan
            if (root == null) {
                root = new Node(nodeId);
            }

            //cari parent dari node nya
            Node parentNode = findNode(root, nodeId);
            if (parentNode != null) {

                // pisahkan lagi menjadi berdasarkan koma
                String[] childIds = parts[1].split(",");
                for (String childId : childIds) {
                    //appent child berdasarkan parentnya
                    parentNode.appendChild(new Node(Integer.parseInt(childId), parentNode));
                }
            }
        }
        return root;
    }

    private Node findNode(Node node, int nodeId) {
        // rekursif mode untuk mencari node

        //Base case nya
        if (node == null || node.getId() == nodeId) {
            return node;
        }

        for (Node child : node.getChildren()) {
            Node foundNode = findNode(child, nodeId);
            if (foundNode != null) {
                return foundNode;
            }
        }

        return null;
    }

    public int getLevelOfNodeWithId(int id) {
        int level = getLevel(root, id, 0);
        if(level == -1){
            return level;
        }
        return calculateHeight(root) - level;
    }

    private int getLevel(Node node, int id, int level) {
            if (node == null) {
                return -1;
            }

            if (node.getId() == id) {
                return level;
            }

            for (Node child : node.getChildren()) {
                int childLevel = getLevel(child, id, level + 1);
                if (childLevel != -1) {
                    return childLevel;
                }
            }

            return -1;
        }

    private int calculateHeight(Node node) {
        if (node == null) {
            return -1; // Height of a null node is -1
        }

        int maxHeight = 0;
        for (Node child : node.getChildren()) {
            int childHeight = calculateHeight(child);
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }

        return maxHeight + 1;
    }
}

class Node {
    private Node parent;
    private List<Node> children;
    private int id;

    public Node(int id) {
        this.id = id;
        this.children = new ArrayList<Node>();
    }

    public Node(int id, Node parent) {
        this(id);
        this.parent = parent;
    }

    public void appendChild(Node child) {
        children.add(child);
    }

    public int getId() {
        return id;
    }

    public List<Node> getChildren() {
        return Collections.unmodifiableList(children);
    }
}
