package com.example.cheng.myapplication.multilevel_tree;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cheng.myapplication.R;
import com.example.cheng.myapplication.multilevel_tree.base.Node;
import com.example.cheng.myapplication.multilevel_tree.base.TreeRecyclerAdapter;

import java.util.List;

public class SimpleTreeRecyclerAdapter extends TreeRecyclerAdapter {

    public SimpleTreeRecyclerAdapter(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel, int iconExpand, int iconNoExpand) {
        super(mTree, context, datas, defaultExpandLevel, iconExpand, iconNoExpand);
    }

    public SimpleTreeRecyclerAdapter(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel) {
        super(mTree, context, datas, defaultExpandLevel);
    }

    @Override
    public void onBindViewHolder(final Node node, RecyclerView.ViewHolder holder, int position) {
        final TreeHolder viewHolder = (TreeHolder) holder;
        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChecked(node,viewHolder.cb.isChecked());
            }
        });

        if (node.isChecked()){
            viewHolder.cb.setChecked(true);
        }else {
            viewHolder.cb.setChecked(false);
        }
        if (node.getIcon()==-1){
            viewHolder.icon.setVisibility(View.INVISIBLE);
        }else {
            viewHolder.icon.setVisibility(View.VISIBLE);
            viewHolder.icon.setImageResource(node.getIcon());
        }
        viewHolder.label.setText(node.getName());
        if (node.isExpand()){
            ((TreeHolder) holder).label.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        }else {
            ((TreeHolder) holder).label.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TreeHolder(View.inflate(mContext,R.layout.item_rv_multilevel,null));
    }

    class TreeHolder extends RecyclerView.ViewHolder{
        public TextView label;
        public ImageView icon;
        public CheckBox cb;

        public TreeHolder(View itemView ) {
            super(itemView);
            this.label = itemView.findViewById(R.id.id_treenode_label);
            this.icon = itemView.findViewById(R.id.icon);
            this.cb = itemView.findViewById(R.id.cb_select_tree);
        }
    }
}
