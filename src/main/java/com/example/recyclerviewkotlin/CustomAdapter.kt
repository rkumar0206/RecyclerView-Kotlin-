package com.example.recyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_recycler_view.view.*

class CustomAdapter(private val list: ArrayList<Custom_ListHolder>,private val context:Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

private  var mListener:OnItemClickListener?=null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.custom_recycler_view, parent, false)
        return ViewHolder(view)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setData(list[position], position)


    }

    override fun getItemCount(): Int = list.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var pos:Int=0

        init {

            itemView.setOnClickListener(this)

        }


        fun setData(item: Custom_ListHolder, position: Int) {

            itemView.custom_list_textView.text = item.text
            itemView.custom_list_imageview.setImageResource(item.image)

            pos=position
        }

        override fun onClick(v: View?) {

            if(mListener!=null){

                val postion:Int?= adapterPosition

                if(postion!=RecyclerView.NO_POSITION){

                    mListener?.OnItemClick(postion!!)
                }
            }
        }

    }

     interface OnItemClickListener{

        fun OnItemClick(pos:Int)
    }

     fun setOnItemClickListener(listener:OnItemClickListener){

        mListener=listener
    }
}