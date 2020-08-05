package com.example.simplesoup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplesoup.data.Order
import kotlinx.android.synthetic.main.list_item.view.*


class MainsAdapter(viewModel: MainsViewModel):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var orders: List<Order> = ArrayList()
    private val viewmodel:MainsViewModel=viewModel




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return orders.size
    }


    fun submitList(ordersList:ArrayList<Order>) {
        orders = ordersList
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            //       is HomeViewHolder -> holder.bind(viewmodel,people.get(position))
            is HomeViewHolder -> holder.bind(viewmodel,position)
        }
    }
}


class HomeViewHolder constructor(
    itemView: View):RecyclerView.ViewHolder(itemView){

    val myName=itemView.order_name


    fun bind(viewModel: MainsViewModel,position: Int){


        myName.text=viewModel.orders.value?.get(position)?.orderName
        }
        //myPhoto.setImageResource(person.myphoto)
    }