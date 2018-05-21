package com.example.cheng.myapplication.multilevel_tree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cheng.myapplication.R;
import com.example.cheng.myapplication.multilevel_tree.base.Node;
import com.example.cheng.myapplication.multilevel_tree.base.TreeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MultilevelActivity extends AppCompatActivity {

    private TreeRecyclerAdapter mAdapter;
    int num = 0;
    private List<Node> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multilevel);
        initDatas();
        RecyclerView mTree = findViewById(R.id.recyclerview);
        mTree.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SimpleTreeRecyclerAdapter(mTree,
                this,mDatas,1,R.drawable.drop_2,R.drawable.drop_1);
        mTree.setAdapter(mAdapter);
    }

    private void initDatas()
    {
        // id , pid , label , 其他属性
        mDatas.add(new Node("1", "-1", "文件管理系统"));

        mDatas.add(new Node(2+"", 1+"", "一级机构"));
        mDatas.add(new Node(3+"", 1+"", "一级机构"));
        mDatas.add(new Node(4+"", 1+"", "一级机构"));

        mDatas.add(new Node(5+"", 3+"", "二级机构"));
        mDatas.add(new Node(6+"", 3+"", "二级机构"));

        mDatas.add(new Node(7+"", 6+"", "三级机构"));
        mDatas.add(new Node(8+"", 6+"", "三级机构"));

        mDatas.add(new Node(9+"", 8+"", "四级机构"));


    }
}
