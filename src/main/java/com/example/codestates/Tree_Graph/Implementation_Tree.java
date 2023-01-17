package com.example.codestates.Tree_Graph;

import java.util.ArrayList;

public class Implementation_Tree {
    public static void main(String[] args) {
        Solution rootNode = new Solution("0");

        for(int i = 1; i <= 5; i++) {
            rootNode.addChildNode(new Solution(Integer.toString(i)));
        }
        System.out.println("rootNode = " + rootNode);
        System.out.println("rootNode.contains(\"6\") = " + rootNode.contains("6"));
        System.out.println("rootNode.contains(\"1\") = " + rootNode.contains("1"));
    }
    static public class Solution {
        private String value;
        private ArrayList<Solution> children;

        public Solution() {	//전달인자가 없을 경우의 생성자
            this.value = null;
            this.children = null;
        }
        public Solution(String data) {	//전달인자가 존재할 경우의 생성자
            this.value = data;
            this.children = null;
        }

        public void setValue(String data) {
            this.value = data;
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }
        public void addChildNode(Solution node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
        }
        public void removeChildNode(Solution node) {
            String data = node.getValue();

            if(children != null) {
                for(int i = 0; i < children.size(); i++) {
                    if(children.get(i).getValue().equals(data)) {
                        children.remove(i);
                        return;
                    }
                    if(children.get(i).children != null) children.get(i).removeChildNode(node);
                }
            }
        }

        public ArrayList<Solution> getChildrenNode() {
            return children;
        }

        public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
            if(value.equals(data)) return true;

            boolean check;

            if(children != null) {
                for(int i = 0; i < children.size(); i++) {
                    check = children.get(i).contains(data, false);
                    if(check) return true;
                }
            }
            return false;
        }

        public boolean contains(String data, boolean check) {      //재귀를 사용하여 값을 검색합니다.
            if(value.equals(data)) return true;

            if(children != null) {
                for(int i = 0; i < children.size(); i++) {
                    check = children.get(i).contains(data, check);
                }
            }
            return check;
        }

        @Override
        public String toString() {
            return "Solution{" +
                    "value='" + value + '\'' +
                    ", children=" + children +
                    '}';
        }
    }

}
