package com.san22.retrofitsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class rvadapter:RecyclerView.Adapter<rvadapter.myviewholder>()
{
    var data:List<User> =ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvadapter.myviewholder {
       return myviewholder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: rvadapter.myviewholder, position: Int) {
          holder.bind(data[position])
    }

    override fun getItemCount(): Int=data.size


    class myviewholder(itemview:View):RecyclerView.ViewHolder(itemview)
    {
        fun bind(user: User)
        {
           with(itemView)
           {
              tvlogin.text=user.login
               tvid.text=user.id.toString()
               Picasso.get().load(user.avatarUrl).into(imageView)
           }
        }

    }
    fun sendtoadapter(list: List<User>)
    {
        this.data=list
        notifyDataSetChanged()
    }
}