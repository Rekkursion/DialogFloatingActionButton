package com.rekkursion.dialogfloatingactionbuttonsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add the first item and its own on-click-listener
        dialogBtn.addItem("first", View.OnClickListener {
            Toast.makeText(this, "This has higher priority to be invoked", Toast.LENGTH_SHORT).show()
        }, false)

        // add the second & third items without listeners
        dialogBtn.addItem("second")
        dialogBtn.addItem("third")

        /**
         * when clicks the second or third item, this listener will be invoked
         * because they don't have their corresponding listeners
         **/
        dialogBtn.setOnItemClickListener(AdapterView.OnItemClickListener { _, _, index, _ ->
            Toast.makeText(this, "#${index + 1} has been invoked", Toast.LENGTH_SHORT).show()
        }, false)
    }
}
