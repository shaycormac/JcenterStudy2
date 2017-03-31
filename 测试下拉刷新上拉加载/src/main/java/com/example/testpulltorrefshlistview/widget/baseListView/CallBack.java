package com.example.testpulltorrefshlistview.widget.baseListView;

import android.support.annotation.NonNull;

/**
 * @author 作者：Shay-Patrick-Cormac
 * @datetime 创建时间：2017-03-31 15:12 GMT+8
 * @email 邮箱： 574583006@qq.com
 * @content 说明：创建这个类的目的，意义。
 */
public  class CallBack
{

    /**
     *  先从网络获取数据，如果失败再从本地数据库获取
     * @param response 返回数据
     * @param isCache 数据是否从本地数据库获取
     * @param failureMessage 失败信息
     */
    public  void onResponse(@NonNull String response, @NonNull boolean isCache, String failureMessage ) {};
}
