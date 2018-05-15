package com.example.cheng.myapplication.NodeTree;

import java.util.ArrayList;
import java.util.List;

public class TreeHelper {

    // 传入我们的普通 bean 转换为我们排序后的 Node
    public static <T> List<Node> getSortedNodes(
            List<T> datas,
            int defaultExpandLevel){
        List<Node> result = new ArrayList<>();
        // 将用户数据转化为 List<Node> 以及设置 Node 间关系
        List<Node> nodes =
    }
}
