package com.example.cheng.myapplication.multilevel_tree.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class TreeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected Context mContext;

    // 存储所有可见的 Node
    protected List<Node> mNodes = new ArrayList<>();
    protected LayoutInflater mInflater;

    // 存储所有可见的 Node
    protected List<Node> mAllNodes = new ArrayList<>();

    // 点击的回调接口
    private OnTreeNodeClickListener onTreeNodeClickListener;

    // 默认不展开
    private int defaultExpandLevel = 0;

    // 展开与关闭的图片
    private int iconExpand = -1, iconNoExpand = -1;

    public TreeRecyclerAdapter(RecyclerView mTree, Context context, List<Node> datas,
                               int defaultExpandLevel, int iconExpand, int iconNoExpand) {
        this.iconExpand = iconExpand;
        this.iconNoExpand = iconNoExpand;

        for (Node node : datas) {
            node.getChildren().clear();
            node.iconExpand = iconExpand;
            node.iconNoExpand = iconNoExpand;
        }
        this.defaultExpandLevel = defaultExpandLevel;
        mContext = context;
        // 对所有的 Node 进行排序
        mAllNodes = TreeHelper.getSortedNodes(datas, defaultExpandLevel);
        // 过滤出可见的 Node
        mNodes = TreeHelper.filterVisibleNode(mAllNodes);
        mInflater = LayoutInflater.from(context);
    }

    // 默认展开几级树
    public TreeRecyclerAdapter(RecyclerView mTree, Context context, List<Node> datas,
                               int defaultExpandLevel) {
        this(mTree, context, datas, defaultExpandLevel, -1, -1);
    }

    public void setOnTreeNodeClickListener(OnTreeNodeClickListener onTreeNodeClickListener) {
        this.onTreeNodeClickListener = onTreeNodeClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Node node = mNodes.get(position);
//        holder.itemView.
        // 设置内边距
        holder.itemView.setPadding(node.getLevel() * 180, 3, 3, 3);
        // 设置节点点击时，可以展开以及关闭，将事件继续往外公布
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandOrCollapse(position);
                if (onTreeNodeClickListener != null) {
                    onTreeNodeClickListener.onClick(mNodes.get(position), position);
                }
            }
        });
        onBindViewHolder(node, holder, position);
    }

    // 相应 list 的点击事件，展开或关闭某节点
    public void expandOrCollapse(int position) {
        Node n = mNodes.get(position);
        if (n != null) { // 排除传入参数错误异常
            if (!n.isLeaf()) {
                n.setExpand(!n.isExpand());
                mNodes = TreeHelper.filterVisibleNode(mAllNodes);
                notifyDataSetChanged();
            }
        }
    }

    @Override
    public int getItemCount() {
        return mNodes.size();
    }

    // 清除掉之前数据并刷新，重新添加
    public void addDataAll(List<Node> mLists, int defaultExpandLevel) {
        mAllNodes.clear();
    }

    // 在指定位置添加数据并刷新，可指定刷新后显示层级
    public void addData(int index, List<Node> mLists, int defaultExpandLevel) {
        this.defaultExpandLevel = defaultExpandLevel;
        notifyData(index, mLists);
    }

    // 在指定位置添加数据并刷新
    public void addData(int index, List<Node> mLists) {
        notifyData(index, mLists);
    }

    // 添加数据并刷新
    public void addData(List<Node> mLists) {
        addData(mLists, defaultExpandLevel);
    }

    // 添加数据并刷新
    public void addData(Node node) {
        addData(node, defaultExpandLevel);
    }

    // 添加数据并刷新，可以指定刷新后显示层级
    public void addData(Node node, int defaultExpandLevel) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        this.defaultExpandLevel = defaultExpandLevel;
        notifyData(-1, nodes);
    }

    // 添加数据并刷新，可指定刷新后显示层级
    public void addData(List<Node> mLists, int defaultExpandLevel) {
        this.defaultExpandLevel = defaultExpandLevel;
        notifyData(-1, mLists);
    }

    // 刷新数据
    protected void notifyData(int index, List<Node> mListNodes) {
        for (int i = 0; i < mListNodes.size(); i++) {
            Node node = mListNodes.get(i);
            node.getChildren().clear();
            node.iconExpand = iconExpand;
            node.iconNoExpand = iconNoExpand;
        }
        for (int i = 0; i < mAllNodes.size(); i++) {
            Node node = mAllNodes.get(i);
            node.getChildren().clear();
            node.isNewAdd = false;
        }
        if (index != -1) {
            mAllNodes.addAll(index, mListNodes);
        } else {
            mAllNodes.addAll(mListNodes);
        }
        // 对所有的 Node 进行排序
        mAllNodes = TreeHelper.getSortedNodes(mAllNodes, defaultExpandLevel);
        // 过滤出可见的 Node
        mNodes = TreeHelper.filterVisibleNode(mAllNodes);
        // 刷新数据
        notifyDataSetChanged();
    }

    // 获取排序后所有节点
    public List<Node> getAllNodes() {
        if (mAllNodes == null) {
            mAllNodes = new ArrayList<>();
        }
        return mAllNodes;
    }

    // 设置多选
    protected void setChecked(final Node node, boolean checked) {
        node.setChecked(checked);
        setChildChecked(node, checked);
        if (node.getParent() != null) {
//            setNodeParentChecked(node.getParent(), checked);
        }
        notifyDataSetChanged();
    }

    // 设置是否选中
    public <T, B> void setChildChecked(Node<T, B> node, boolean checked) {
        if (!node.isLeaf()) {
            node.setChecked(checked);
            for (Node childrenNode : node.getChildren()) {
                setChildChecked(childrenNode, checked);
            }
        } else {
            node.setChecked(checked);
        }
    }

    private void setNodeParentChecked(Node node, boolean checked) {
        if (checked) {
            node.setChecked(checked);
            if (node.getParent() != null) {
                setNodeParentChecked(node.getParent(), checked);
            }
        } else {
            List<Node> childrens = node.getChildren();
            boolean isChecked = false;
            for (Node children : childrens) {
                if (children.isChecked()) {
                    isChecked = true;
                }
            }
            // 如果所有子节点都没有被选中，父节点也不选中
            if (!isChecked) {
                node.setChecked(checked);
            }
            if (node.getParent() != null) {
                setNodeParentChecked(node.getParent(), checked);
            }
        }
    }


    public abstract void onBindViewHolder(Node node, RecyclerView.ViewHolder holder, final int position);
}
