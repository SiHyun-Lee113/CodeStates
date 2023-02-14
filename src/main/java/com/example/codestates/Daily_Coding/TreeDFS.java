package com.example.codestates.Daily_Coding;

import java.util.ArrayList;

public class TreeDFS {
    public static void main(String[] args) {
        Solution.tree root = new Solution.tree("1");
        Solution.tree rootChild1 = root.addChildNode(new Solution.tree("2"));
        Solution.tree rootChild2 = root.addChildNode(new Solution.tree("3"));
        Solution.tree leaf1 = rootChild1.addChildNode(new Solution.tree("4"));
        Solution.tree leaf2 = rootChild1.addChildNode(new Solution.tree("5"));
        ArrayList<String> output = Solution.dfs(root);
        System.out.println(output); // --> ["1", "2", "4", "5", "3"]

        leaf1.addChildNode(new Solution.tree("6"));
        rootChild2.addChildNode(new Solution.tree("7"));
        output = Solution.dfs(root);
        System.out.println(output); // --> ["1", "2", "4", "6", "5", "3", "7"]
    }


    public static class Solution {

        public static ArrayList<String> dfs(tree node) {
            // TODO:
            ArrayList<String> result = new ArrayList<>();

            searchTree(result, node);

            return result;
        }

        public static void searchTree(ArrayList<String> result, tree node) {
            if (node.children == null) {
                result.add(node.getValue());
                return;
            }

            result.add(node.getValue());
            for (tree t : node.children) {
                searchTree(result, t);
            }
        }

        //아래 클래스의 내용은 수정하지 말아야 합니다.
        public static class tree {
            private String value;
            private ArrayList<tree> children;

            public tree(String data) {
                this.value = data;
                this.children = null;
            }

            public tree addChildNode(tree node) {
                if(children == null) children = new ArrayList<>();
                children.add(node);
                return children.get(children.size() - 1);
            }

            public String getValue() {      //현재 노드의 데이터를 반환
                return value;
            }

            public ArrayList<tree> getChildrenNode() {
                return children;
            }
        }
    }

}
