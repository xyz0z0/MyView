package com.example.cheng.myapplication.multilevel_tree.base;

import java.util.ArrayList;
import java.util.List;

public class TreeHelper {

    // 传入 Node 返回排序后的 Node
    public static List<Node> getSortedNodes(List<Node> datas, int defaultExpandLevel) {
        List<Node> result = new ArrayList<>();
        // 设置 Node 间父子关系
        List<Node> nodes = convertDataToNode(datas);
        // 拿到根节点
        List<Node> rootNodes = getRootNodes(nodes);
        // 排序以及设置 Node 间的关系
        for (Node node : rootNodes) {
            addNode(result, node, defaultExpandLevel, 1);
        }
        return result;
    }


    // 设置 Node 间父子关系，让每两个节点都比较一次，即可设置其中的关系
    private static List<Node> convertDataToNode(List<Node> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                Node m = nodes.get(j);
                if (m.getId() instanceof String) {
                    if (m.getpId().equals(n.getId())) {
                        n.getChildren().add(m);
                        m.setParent(n);
                    } else if (m.getId().equals(n.getpId())) {
                        m.getChildren().add(n);
                        n.setParent(m);
                    }
                } else {
                    if (m.getpId() == n.getId()) {
                        n.getChildren().add(m);
                        m.setParent(n);
                    } else if (m.getId() == n.getpId()) {
                        m.getChildren().add(n);
                        n.setParent(m);
                    }
                }
            }
        }
        return nodes;
    }

    // 获取根节点
    private static List<Node> getRootNodes(List<Node> nodes) {
        List<Node> root = new ArrayList<>();
        for (Node node : nodes) {
            if (node.isRoot()) {
                root.add(node);
            }
        }
        return root;
    }

    // 把一个节点上的所有内容都放在 nodes 节点上
    private static <T, B> void addNode(List<Node> nodes, Node<T, B> node,
                                       int defaultExpandLevel, int currentLevel) {
        nodes.add(node);
        if (node.isNewAdd && defaultExpandLevel >= currentLevel) {
            node.setExpand(true);
        }
        if (node.isLeaf()) {
            return;
        }
        for (int i = 0; i < node.getChildren().size(); i++) {
            addNode(nodes, node.getChildren().get(i), defaultExpandLevel,
                    currentLevel + 1);
        }
    }

    // 设置节点的图标
    private static void setNodeIcon(Node node) {
        if (node.getChildren().size() > 0 && node.isExpand()) {
            node.setIcon(node.iconExpand);
        } else if (node.getChildren().size() > 0 && !node.isExpand()) {
            node.setIcon(node.iconNoExpand);
        } else {
            node.setIcon(node.iconNoExpand);
        }
    }

    // 过滤出所有可见的 Node
    public static List<Node> filterVisibleNode(List<Node> nodes) {
        List<Node> result = new ArrayList<>();
        for (Node node : nodes) {
            // 如果是根节点，或者上层目录为展开状态
//            if (node.isRoot() || node.isParentExpand()) {
            if (node.isParentExpand()) {
                setNodeIcon(node);
                result.add(node);
            }
        }
        return result;
    }
}
