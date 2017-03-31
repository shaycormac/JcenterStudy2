package com.example.testpulltorrefshlistview;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import com.example.testpulltorrefshlistview.widget.library.PullToRefreshBase;
import com.example.testpulltorrefshlistview.widget.library.PullToRefreshListView;

import java.util.LinkedList;

/**
 * @author 作者：Shay-Patrick-Cormac
 * @datetime 创建时间：2017-03-31 10:24 GMT+8
 * @email 邮箱： 574583006@qq.com
 * @content 说明：创建这个类的目的，意义。
 */
public class GetDataTask extends AsyncTask<Void,Void,Void> 
{
    private PullToRefreshListView mPullRefreshListView;
    private ArrayAdapter<String> mAdapter;
    private LinkedList<String> mListItems;

    public GetDataTask(PullToRefreshListView listView,
                       ArrayAdapter<String> adapter,LinkedList<String> listItems) {
        // TODO 自动生成的构造函数存根
        mPullRefreshListView = listView;
        mAdapter = adapter;
        mListItems = listItems;
    }

    @Override
    protected Void doInBackground(Void... params) {
        //模拟请求
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // TODO 自动生成的方法存根
        super.onPostExecute(result);
        //得到当前的模式
        PullToRefreshBase.Mode mode = mPullRefreshListView.getCurrentMode();
        if(mode == PullToRefreshBase.Mode.PULL_FROM_START) {
            mListItems.addFirst("这是刷新出来的数据");
        }
        else {
            mListItems.addLast("这是刷新出来的数据");
        }
        // 通知数据改变了
        mAdapter.notifyDataSetChanged();
        // 加载完成后停止刷新
        mPullRefreshListView.onRefreshComplete();

    }

}
