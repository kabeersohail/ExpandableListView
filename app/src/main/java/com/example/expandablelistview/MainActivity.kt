package com.example.expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView

class MainActivity : AppCompatActivity() {

    private val header: List<String> = ArrayList(listOf("SOHAIL", "SALMAN", "NIRGIN"))
    private val body: List<List<String>> = ArrayList(
        listOf(listOf("GOOD","BAD","UGLY"),listOf("SAMOSA","PURI","VADA"),listOf("IDLT","DOSA"))
    )
    lateinit var expandablelistview: ExpandableListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expandablelistview = findViewById(R.id.expandable_list_view)
        expandablelistview.setAdapter(ExpandableListAdapter(this, header, body))


    }
}