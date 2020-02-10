package com.rekkursion.dialogfloatingactionbutton.utils

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.bottomsheet.BottomSheetDialog

internal class ListBottomSheetDialog(context: Context): BottomSheetDialog(context) {
    // the list of items
    private val mItemList = ArrayList<String>()

    // the list of items' listeners
    private val mOnClickListenerList = ArrayList<Pair<View.OnClickListener, Boolean>?>()

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
    fun add(itemName: String,
            onClickListener: View.OnClickListener? = null,
            dismissAfterClicking: Boolean = true,
            index: Int = mItemList.size) {
        // add the new item into the item list
        mAdapter.insert(itemName, index)

        // add the designated on-click-listener to the list if has one
        if (onClickListener == null)
            mOnClickListenerList.add(index, null)
        else {
            mOnClickListenerList.add(index, Pair(onClickListener, dismissAfterClicking))
            setOnItemClickListener(null, null)
        }

        // set the content view
        if (mItemListView.parent == null)
            setContentView(mItemListView)
    }

    /* ============================================================ */

    // set the on-item-click-listener
    internal fun setOnItemClickListener(onItemClickListener: AdapterView.OnItemClickListener?, dismissAfterClicking: Boolean?) {
        val listener = AdapterView.OnItemClickListener { adapterView, view, index, id ->
            if (mOnClickListenerList[index] != null) {
                mOnClickListenerList[index]?.first?.onClick(view)
                if (mOnClickListenerList[index]!!.second) this.dismiss()
            }
            else if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, index, id)
                if (dismissAfterClicking == true) this.dismiss()
            }
        }
        mItemListView.onItemClickListener = listener
    }
}