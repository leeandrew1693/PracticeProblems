package datastructures.tree.practice;

import datastructures.tree.common.BinaryTree;
import datastructures.tree.common.BinaryTreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by andrew on 3/11/17.
 */
public class PathsWithSum {
    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(0);
        binaryTreeNode.setLeftChild(binaryTreeNode1);
        binaryTreeNode.setRightChild(binaryTreeNode2);
        binaryTreeNode1.setLeftChild(binaryTreeNode3);
        binaryTreeNode1.setRightChild(binaryTreeNode4);
        binaryTreeNode2.setLeftChild(binaryTreeNode5);
        binaryTreeNode2.setRightChild(binaryTreeNode6);

        Map<Integer, Integer> temp = new HashMap<>();
        Map<Integer, Integer> map = getSumsFromNode(binaryTreeNode, temp);
        System.out.println(numPathsWithSum(binaryTreeNode, 14));
    }

    public static int numPathsWithSum(BinaryTreeNode binaryTreeNode, int sum) {
        Map<Integer, Integer> total = new HashMap<>();
        getSumsFromNode(binaryTreeNode, total);
        if(total.containsKey(sum)){
            return total.get(sum);
        } else {
            return 0;
        }
    }

    private static Map<Integer, Integer> getSumsFromNode(BinaryTreeNode binaryTreeNode, Map<Integer, Integer> totalMap) {
        if(binaryTreeNode == null) {
            return new HashMap<>();
        }

        BinaryTreeNode leftNode = binaryTreeNode.getLeftChild();
        BinaryTreeNode rightNode = binaryTreeNode.getRightChild();

        Map<Integer, Integer> leftMap = getSumsFromNode(leftNode, totalMap);
        Map<Integer, Integer> rightMap = getSumsFromNode(rightNode, totalMap);

        Map<Integer,Integer> output = new HashMap();
        incrementMap(output, binaryTreeNode.getValue());
        incrementMap(totalMap, binaryTreeNode.getValue());
        leftMap.forEach((key, value) -> {
            incrementMap(output, binaryTreeNode.getValue() + key);
            incrementMap(totalMap, binaryTreeNode.getValue() + key);
        });
        rightMap.forEach((key, value) -> {
            incrementMap(output, binaryTreeNode.getValue() + key);
            incrementMap(totalMap, binaryTreeNode.getValue() + key);
        });

        return output;
    }

    private static void incrementMap(Map<Integer, Integer> map, int val) {
        if(map.containsKey(val)) {
            map.put(val, map.get(val) + 1);
        } else {
            map.put(val, 1);
        }
    }
}
