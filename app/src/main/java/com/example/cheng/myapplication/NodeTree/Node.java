package com.example.cheng.myapplication.NodeTree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int id;
    // 根节点 pId 为 0
    private int pId = 0;
    private String name;
    // 当前的级别
    private int level;
    // 是否展开
    private boolean isExpand = false;
    private int icon;
    // 下一级的子 Node
    private List<Node> children = new ArrayList<>();
    // 父 Node
    private Node parent;

    public Node() {
    }

    public Node(int id,int pId,String name){
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    // 是否为根节点
    public boolean isRoot(){
        return parent == null;
    }

    // 判断父节点是否展开
    public boolean isParentExpand(){
        if (parent==null){
            return false;
        }
        return parent.isExpand();
    }

    // 是否是叶子节点
    public boolean isLeaf(){
        return children.size() == 0;
    }

    // 获取 level
    public int getLevel(){
        return parent == null?0:parent.getLevel()+1;
    }

    // 设置展开
    public void setExpand(boolean isExpand){
        this.isExpand = isExpand;
        if (!isExpand){
            for (Node node:children){
                node.setExpand(isExpand);
            }
        }
    }
}
