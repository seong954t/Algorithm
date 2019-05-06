import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer;

        int T, V, E, node1, node2, parent, child;
        Node nodes[], parentNode;
        T = Integer.parseInt(bufferedReader.readLine());
        for (int testcase = 1; testcase <= T; testcase++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            V = Integer.parseInt(stringTokenizer.nextToken());
            E = Integer.parseInt(stringTokenizer.nextToken());
            node1 = Integer.parseInt(stringTokenizer.nextToken());
            node2 = Integer.parseInt(stringTokenizer.nextToken());

            nodes = new Node[V+1];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i = 0; i<E; i++){
                parent = Integer.parseInt(stringTokenizer.nextToken());
                child = Integer.parseInt(stringTokenizer.nextToken());
                appendNode(parent, child, nodes);
            }
            parentNode = getEqualParent(nodes[node1], nodes[node2]);
            bufferedWriter.append("#"+testcase+" "+parentNode.value+" "+(parentNode.getSubNodeCount()+1)+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static Node getEqualParent(Node node1, Node node2){
        int node1Depth = node1.getDepth();
        int node2Depth = node2.getDepth();
        if(node1Depth < node2Depth){
            node2 = getParentNodeFromDistance(node2Depth - node1Depth, node2);
        } else{
            node1 = getParentNodeFromDistance(node1Depth - node2Depth, node1);
        }

        while(node1.value != node2.value){
            node1 = node1.getParent();
            node2 = node2.getParent();
        }

        return node1;
    }

    private static Node getParentNodeFromDistance(int distance, Node node){
        for(int i = 0; i<distance; i++){
            node = node.getParent();
        }
        return node;
    }

    private static void appendNode(int parent, int child, Node[] nodes) {
        if(Objects.isNull(nodes[parent])){
            nodes[parent] = new Node(parent);
        }
        if(Objects.isNull(nodes[child])){
            nodes[child] = new Node(child);
        }
        nodes[parent].appendChild(nodes[child]);
        nodes[child].setParent(nodes[parent]);
    }

    static class Node{
        private final int value;
        private Node right, left, parent;

        Node(int value){
            this.value = value;
        }

        void appendChild(Node node){
            if(Objects.isNull(this.right)){
                this.right = node;
            } else if(Objects.isNull(this.left)){
                this.left = node;
            }
        }

        void setParent(Node node){
            this.parent = node;
        }

        Node getParent(){
            return this.parent;
        }

        int getSubNodeCount(){
            int rightSubNodeCount, leftSubNodeCount;
            if(Objects.isNull(this.right)){
                rightSubNodeCount = 0;
            } else{
                rightSubNodeCount = this.right.getSubNodeCount() + 1;
            }
            if(Objects.isNull(this.left)){
                leftSubNodeCount = 0;
            } else{
                leftSubNodeCount = this.left.getSubNodeCount() + 1;
            }
            return rightSubNodeCount + leftSubNodeCount;
        }

        int getDepth(){
            int depth = 1;
            Node parent = this.getParent();
            while(!Objects.isNull(parent)){
                parent = parent.getParent();
                depth++;
            }
            return depth;
        }
    }
}
