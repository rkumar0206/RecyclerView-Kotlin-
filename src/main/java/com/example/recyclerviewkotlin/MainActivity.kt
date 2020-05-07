package com.example.recyclerviewkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var list:ArrayList<Custom_ListHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         list = ArrayList()

        list.add(Custom_ListHolder(R.drawable.ic_android_black_24dp, "Android"))
        list.add(Custom_ListHolder(R.drawable.ic_announcement_black_24dp, "Announcement"))
        list.add(Custom_ListHolder(R.drawable.ic_archive_black_24dp, "Archive"))
        list.add(Custom_ListHolder(R.drawable.ic_beach_access_black_24dp, "Umbrella"))
        list.add(Custom_ListHolder(R.drawable.ic_brightness_2_black_24dp, "Brightness"))
        list.add(Custom_ListHolder(R.drawable.ic_call_end_black_24dp, "Call end"))
        list.add(Custom_ListHolder(R.drawable.ic_camera_black_24dp, "Camera"))
        list.add(Custom_ListHolder(R.drawable.ic_fingerprint_black_24dp, "FingerPrint"))

        list.add(Custom_ListHolder(R.drawable.ic_android_black_24dp, "Android"))
        list.add(Custom_ListHolder(R.drawable.ic_announcement_black_24dp, "Announcement"))
        list.add(Custom_ListHolder(R.drawable.ic_archive_black_24dp, "Archive"))
        list.add(Custom_ListHolder(R.drawable.ic_beach_access_black_24dp, "Umbrella"))
        list.add(Custom_ListHolder(R.drawable.ic_brightness_2_black_24dp, "Brightness"))
        list.add(Custom_ListHolder(R.drawable.ic_call_end_black_24dp, "Call end"))
        list.add(Custom_ListHolder(R.drawable.ic_camera_black_24dp, "Camera"))
        list.add(Custom_ListHolder(R.drawable.ic_fingerprint_black_24dp, "FingerPrint"))

        val adapter = CustomAdapter(list,this)
        //recyclerView.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        //recyclerView.layoutManager=GridLayoutManager(this,2)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter



       ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {

                    val frompos=viewHolder.adapterPosition
                    val topos=target.adapterPosition

                    adapter.notifyItemMoved(frompos,topos)
                   return true
                }


                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                    val pos:Int=viewHolder.adapterPosition
                    list.removeAt(pos)
                    adapter.notifyItemRemoved(pos)
                }
            }).attachToRecyclerView(recyclerView)


        adapter.setOnItemClickListener(object : CustomAdapter.OnItemClickListener{

            override fun OnItemClick(pos: Int) {

                Toast.makeText(this@MainActivity,""+pos,Toast.LENGTH_LONG).show()

            }
        })

    }
}
