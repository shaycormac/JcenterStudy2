package com.example.testpulltorrefshlistview.widget.testlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.testpulltorrefshlistview.R;
import com.example.testpulltorrefshlistview.widget.library.PullToRefreshListView;

public class RankListActivity extends AppCompatActivity {

    PullToRefreshListView ptrListView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_list);
        ptrListView = (PullToRefreshListView) findViewById(R.id.ptrListView);
        new RankList(ptrListView, this);
    }
}
