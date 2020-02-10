package com.rekkursion.dialogfloatingactionbutton

import android.app.Dialog
import android.content.Context
import android.util.AttributeSet
import android.widget.AdapterView
import com.rekkursion.dialogfloatingactionbutton.utils.ListBottomSheetDialog

class ListBottomSheetDialogFloatingActionButton(context: Context, attrs: AttributeSet?):
    DialogFloatingActionButton(context, attrs) {

    // primary constructor
    init {
        // the bottom-sheet-dialog for listing the items
        mDialog = ListBottomSheetDialog(context)
    }

    /* ============================================================ */

    // add a new item by a string
    fun addItem(itemName: String,
                onClickListener: OnClickListener? = null,
                dismissAfterClicking: Boolean = true,
                index: Int = (mDialog as ListBottomSheetDialog).size) {
        (mDialog as ListBottomSheetDialog).add(itemName, onClickListener, dismissAfterClicking, index)
    }

    // set the listener for clicking a certain item
    fun setOnItemClickListener(onItemClickListener: AdapterView.OnItemClickListener, dismissAfterClicking: Boolean) {
        (mDialog as ListBottomSheetDialog).setOnItemClickListener(onItemClickListener, dismissAfterClicking)
    }

    /* ============================================================ */

    // override the set-dialog method and let it do nothing
    override fun setDialog(dialog: Dialog) {}
}