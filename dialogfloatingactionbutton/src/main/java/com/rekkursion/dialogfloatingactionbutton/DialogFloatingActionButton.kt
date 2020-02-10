package com.rekkursion.dialogfloatingactionbutton

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DialogFloatingActionButton(context: Context, attrs: AttributeSet?): FloatingActionButton(context, attrs), View.OnClickListener {
    // the bottom-sheet-dialog which will be prompted up when the user clicks the floating-action-button
    protected var mBottomSheetDialog: BottomSheetDialog? = null

    /* ============================================================ */

    // primary constructor
    init {
        super.setOnClickListener(this)
    }

    // secondary constructor
    constructor(context: Context): this(context, null)

    /* ============================================================ */

    // set the to-be-prompt-up bottom-sheet-dialog
    fun setBottomSheetDialog(bottomSheetDialog: BottomSheetDialog) {
        mBottomSheetDialog = bottomSheetDialog
    }

    /* ============================================================ */

    // override the set-on-click-listener method and let it do nothing
    override fun setOnClickListener(l: OnClickListener?) {}

    // set the on-click method of the on-click-listener to prompt up the dialog
    override fun onClick(view: View?) {
        mBottomSheetDialog?.show()
    }
}