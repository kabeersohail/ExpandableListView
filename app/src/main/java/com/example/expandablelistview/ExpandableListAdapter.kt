package com.example.expandablelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast

class ExpandableListAdapter(
    private val context: Context,
    private val header: List<String>,
    private val body: List<List<String>>,
) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return header.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return body[groupPosition].size
    }

    override fun getGroup(groupPosition: Int): String {
        return header[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return body[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var cV = convertView
        if (cV == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            cV = inflater.inflate(R.layout.layout_group, cV)
        }
        val title: TextView? = cV?.findViewById(R.id.title)
        title?.text = getGroup(groupPosition)
        return cV
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var cV = convertView
        if (cV == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            cV = inflater.inflate(R.layout.layout_child, cV)
        }
        val title: TextView? = cV?.findViewById(R.id.child)
        title?.text = getChild(groupPosition, childPosition)
        title?.setOnClickListener {
            Toast.makeText(context, getChild(groupPosition, childPosition), Toast.LENGTH_SHORT)
                .show()
        }
        return cV
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}