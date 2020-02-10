package com.rekkursion.dialogfloatingactionbuttonsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lbsdfab.addItem("first", View.OnClickListener {
            Toast.makeText(this, "YES! YES! YES!", Toast.LENGTH_SHORT).show()
        }, true)

        lbsdfab.addItem("second")
        lbsdfab.addItem("third")

        lbsdfab.setOnItemClickListener(AdapterView.OnItemClickListener { _, _, index, _ ->
            AlertDialog.Builder(this).setMessage(index.toString()).show()
        }, false)
    }
}
