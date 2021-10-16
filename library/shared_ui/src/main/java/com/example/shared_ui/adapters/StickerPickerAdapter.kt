package com.example.shared_ui.adapters

import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shared_ui.databinding.RvItemStickerBinding

class StickerPickerAdapter(): RecyclerView.Adapter<StickerPickerAdapter.ViewHolder>() {
    lateinit var images:List<Int>

    inner class ViewHolder(val binding: RvItemStickerBinding)
        :RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StickerPickerAdapter.ViewHolder {

        val binding:RvItemStickerBinding =
            RvItemStickerBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    fun setData(image: List<Int>){
        Log.i("StickerPickerAdapter","${images.size} khar")
        this.images = image
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: StickerPickerAdapter.ViewHolder, position: Int)
    {
        val image  = this.images[position]

        Log.i("teeeest","teeeest")
      //  holder.binding.profileImage.setBackgroundResource(image)

    }
    override fun getItemCount(): Int {
        return if (images.isNotEmpty()) {
            images.size
        }else{
            0
        }
    }
}