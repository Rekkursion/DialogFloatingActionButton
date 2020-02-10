package com.rekkursion.dialogfloatingactionbutton

import android.app.Dialog
import android.content.Context
import android.util.AttributeSet
import com.google.android.material.floatingactionbutton.FloatingActionButton

open class DialogFloatingActionButton(context: Context, attrs: AttributeSet?): FloatingActionButton(context, attrs) {
    // the dialog which will be prompted up when the user clicks the floating-action-button
    protected var mDialog: Dialog? = null

    // the default on-click-listener of the floating-action-button
    private val mDefaultFloatingActionButtonOnClickListener = OnClickListener {
        mDialog?.show()
    }

    /* ============================================================ */

    // primary constructor
    init {
        // set the default on-click-listener to prompt up the dialog which has been set by the user
        super.setOnClickListener(mDefaultFloatingActionButtonOnClickListener)
    }

    // secondary constructor
    constructor(context: Context): this(context, null)

    /* ============================================================ */

    // set the to-be-prompt-up dialog
    open fun setDialog(dialog: Dialog) {
        mDialog = dialog
    }

    /* ============================================================ */

    // override the set-on-click-listener method and let it do nothing
    override fun setOnClickListener(l: OnClickListener?) {}
}