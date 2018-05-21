package com.example.cheng.myapplication.multilevel_tree.base;

import java.util.ArrayList;
import java.util.List;

public class Node<T, B> {

    // 传入的实体对象
    public B bean;

    // 设置开启 关闭的图片
    public int iconExpand = -1, iconNoExpand = -1;
    // 是否为新添加的
    public boolean isNewAdd = true;
    private T id;
    // 根节点 pId 为 0
    private T pId;
    private String name;
    // 当前的级别
    private int level;
    // 是否展开
    private boolean isExpand = false;
    private int icon = -1;
    // 下一级的子 Node
    private List<Node> children = new ArrayList<>();
    // 父 Node
    private Node parent;
    // 是否被 checked 选中
    private boolean isChecked;

    public Node() {
    }

    public Node(T id, T pId, String name) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    public Node(T id, T pId, String name, B bean) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.bean = bean;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public T getpId() {
        return pId;
    }

    public void setpId(T pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExpand() {
        return isExpand;
    }

    // 设置展开
    public void setExpand(boolean isExpand) {
        this.isExpand = isExpand;
        if (!isExpand) {
            for (Node node : children) {
                node.setExpand(isExpand);
            }
        }
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

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    // 获取 level
    public int getLevel() {
        return parent == null ? 0 : parent.getLevel() + 1;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // 是否为根节点
    public boolean isRoot() {
        return parent == null;
    }

    // 判断父节点是否展开
    public boolean isParentExpand() {
        if (parent == null) {
            return false;
        }
        return parent.isExpand();
    }

    // 是否是叶子节点
    public boolean isLeaf() {
        return children.size() == 0;
    }

}
