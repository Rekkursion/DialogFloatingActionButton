package com.rekkursion.dialogfloatingactionbutton

import android.app.Dialog
import android.content.Context
import android.util.AttributeSet

class ListBottomSheetDialogFloatingActionButton(context: Context, attrs: AttributeSet?):
    DialogFloatingActionButton(context, attrs) {

    // primary constructor
    init {
        // the bottom-sheet-dialog for listing the items
        mDialog = ListBottomSheetDialog(context)
    }

    /* ============================================================ */

    // add a new item by a string
    fun addItem(itemName: String, index: Int = (mDialog as ListBottomSheetDialog).size) {
        (mDialog as ListBottomSheetDialog).add(itemName, index)
    }

    /* ============================================================ */

    // override the set-dialog method and let it do nothing
    override fun setDialog(dialog: Dialog) {}
}