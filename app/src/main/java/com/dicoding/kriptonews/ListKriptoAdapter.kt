package com.dicoding.kriptonews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListKriptoAdapter(private val listKripto: ArrayList<KriptoNews>) : RecyclerView.Adapter<ListKriptoAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFlashDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_kripto, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val kripto = listKripto[position]
        Glide.with(holder.itemView.context)
            .load(kripto.images)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvTitle.text = kripto.title
        holder.tvFlashDetail.text = kripto.title

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(holder.adapterPosition) }
    }

    override fun getItemCount(): Int {
        return listKripto.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(index: Int)
    }

}