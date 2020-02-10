package com.rekkursion.dialogfloatingactionbutton

import android.app.Dialog
import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DialogFloatingActionButton(context: Context, attrs: AttributeSet?): FloatingActionButton(context, attrs), View.OnClickListener {
    // the dialog which will be prompted up when the user clicks the floating-action-button
    protected var mDialog: Dialog? = null

    /* ============================================================ */

    // primary constructor
    init {
        // set the default on-click-listener to prompt up the dialog which has been set by the user
        super.setOnClickListener(this)
    }

    // secondary constructor
    constructor(context: Context): this(context, null)

    /* ============================================================ */

    // set the to-be-prompt-up dialog
    fun setDialog(dialog: Dialog) {
        mDialog = dialog
    }

    /* ============================================================ */

    // override the set-on-click-listener method and let it do nothing
    override fun setOnClickListener(l: OnClickListener?) {}

    // set the on-click method of the on-click-listener to prompt up the dialog
    override fun onClick(view: View?) {
        mDialog?.show()
    }
}