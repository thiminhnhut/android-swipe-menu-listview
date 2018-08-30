package io.github.thiminhnhut.swipemenulistview

import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.baoyz.swipemenulistview.SwipeMenuCreator
import com.baoyz.swipemenulistview.SwipeMenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSwipeListView()

        val data = arrayListOf("C++", "Python", "Java", "Rust", "Bash")
        val adapterSwipeListView = CustomAdapterSwipeListView(this, R.layout.item_swipe_listview, data)
        swipeListView.adapter = adapterSwipeListView
    }

    private fun setSwipeListView() {
        val creator = SwipeMenuCreator { menu ->
            // create "delete" item
            val deleteItem = SwipeMenuItem(this@MainActivity)
            // set item background
            deleteItem.background = ColorDrawable(resources.getColor(R.color.red))
            // set item width
            deleteItem.width = 170
            // set a icon
            deleteItem.setIcon(R.drawable.ic_bin)
            // set item title
            deleteItem.title = "Delete"
            // set item title fontsize
            deleteItem.titleSize = 14
            // set item title font color
            deleteItem.titleColor = resources.getColor(R.color.gray)
            // add to menu
            menu.addMenuItem(deleteItem)
        }
        swipeListView.setMenuCreator(creator)

        swipeListView.setOnMenuItemClickListener { position, menu, index ->
            println("INDEX = $index")
            false
        }

    }
}
