package com.rekkursion.dialogfloatingactionbuttonsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val t = TextView(this)
        t.text = "Good"
        val d = BottomSheetDialog(this)
        d.setContentView(t)

        val d2 = AlertDialog.Builder(this).setMessage("Accelerator").create()

        lbsdfab.addItem("first")
        lbsdfab.addItem("second")
        lbsdfab.addItem("third")
        lbsdfab.addItem("true third", 2)
    }
}
