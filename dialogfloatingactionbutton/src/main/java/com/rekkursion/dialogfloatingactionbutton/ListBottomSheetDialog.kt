package com.rekkursion.dialogfloatingactionbutton

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.bottomsheet.BottomSheetDialog

internal class ListBottomSheetDialog(context: Context): BottomSheetDialog(context) {
    // the list of items
    private val mItemList = ArrayList<String>()

    // the list-view for showing items
    private val mItemListView = ListView(context)

    // the adapter of the list-view
    private val mAdapter = ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, mItemList)

    // public: the size of the item list
    val size get() = mItemList.size

    // primary constructor
    init {
        // set the adapter of the list-view
        mItemListView.adapter = mAdapter
    }

    /* ============================================================ */

    // add a new item by a string
    fun add(itemName: String, index: Int = mItemList.size) {
        // add the new item into the item list
        mAdapter.insert(itemName, index)

        // remove the previous list-view if has one
        if (mItemListView.parent != null)
            (mItemListView.parent as ViewGroup).removeView(mItemListView)
        // set the content view
        setContentView(mItemListView)
    }
}