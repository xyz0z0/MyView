package com.example.cheng.myapplication.NodeTree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

public class TreeListViewAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<Node> mNodes;
    protected LayoutInflater mInflater;
    protected List<Node> mAllNodes;

    // 点击的回调接口
    private OnTreeNodeClickListener onTreeNodeClickListener;

    public interface OnTreeNodeClickListener{
        void onClick(Node node,int position);
    }

    public void setOnTreeNodeClickListener(OnTreeNodeClickListener onTreeNodeClickListener){
        this.onTreeNodeClickListener = onTreeNodeClickListener;
    }

    // 默认展开几级树


    public TreeListViewAdapter(ListView mTree,Context context,List<T> datas,int defaultExpandLevel) {

        mContext = mContext;
        // 对所有的 Node 进行排序
        mAllNodes = TreeHelper
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
