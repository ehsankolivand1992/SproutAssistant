package com.ehsankolivand.listtodo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.ehsankolivand.listtodo.R
import com.ehsankolivand.listtodo.databinding.SlideImagesDetailProductBinding
import java.util.zip.Inflater

class DetailAdapter constructor(context:Context,
                                 inflater:LayoutInflater,
                                imagesList:List<Int>) : PagerAdapter() {

     var context: Context = context
     private  var imagesList: List<Int> =imagesList
     private lateinit var ivDetailImagesProduct: ImageView


    override fun getCount(): Int {
        return imagesList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val binding = SlideImagesDetailProductBinding.inflate(LayoutInflater.from(context),container,false)
        val view = binding.root
        ivDetailImagesProduct =binding.ivImagesDetailProduct
        initViews(position)
        container.addView(view)
        return view
    }

    private fun initViews(position: Int) {
        val images = imagesList[position]

    }



    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }

}