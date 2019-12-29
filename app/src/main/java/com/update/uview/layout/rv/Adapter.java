package com.update.uview.layout.rv;

import android.view.View;
import android.view.ViewGroup;

public interface Adapter {
    View onCreateViewHolder(int position, View convertView, ViewGroup parent);

    View onBindViewHolder(int position, View convertView, ViewGroup parent);

    /**
     * 获取 Item的类型
     */
    int getItemViewType(int row);

    /**
     * 获取 Item 类型的数量
     */
    int getViewTypeCount();

    int getCount();

    int getHeight(int index);

}