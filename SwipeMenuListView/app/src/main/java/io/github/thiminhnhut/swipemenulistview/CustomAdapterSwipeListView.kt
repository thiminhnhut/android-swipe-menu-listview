package io.github.thiminhnhut.swipemenulistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapterSwipeListView(private var context: Context, private var layout: Int, private var array: ArrayList<String>?) : BaseAdapter() {

    class ViewHolder (row: View) {
        var txtView = row.findViewById<TextView>(R.id.txtView)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(layout, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        viewHolder.txtView.text = array!![position]

        return view as View
    }

    override fun getItem(position: Int): Any {
        return array!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return array!!.size
    }

}