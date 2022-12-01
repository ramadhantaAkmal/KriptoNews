package com.dicoding.kriptonews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailPage: AppCompatActivity() {

    private lateinit var imageDataReceived: ImageView
    private lateinit var titleDataReceived: TextView
    private lateinit var authorDataReceived: TextView
    private lateinit var dateDataReceived: TextView
    private lateinit var newsDataReceived: TextView

    companion object{
        const val EXTRA_INDEX = "extra_index"
    }

    private var list: ArrayList<KriptoNews> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val index = intent.getIntExtra(EXTRA_INDEX, 0)

        list.addAll(KriptoNewsData.listData)
        val newsChoosed = list[index]

        imageDataReceived= findViewById(R.id.kripto_image)
        titleDataReceived= findViewById(R.id.title_detail)
        authorDataReceived = findViewById(R.id.kripto_author)
        dateDataReceived = findViewById(R.id.date_released)
        newsDataReceived = findViewById(R.id.text_news)

        imageDataReceived.setImageResource(newsChoosed.images)
        titleDataReceived.text = newsChoosed.title
        authorDataReceived.text = newsChoosed.author
        dateDataReceived.text = newsChoosed.dateReleased
        newsDataReceived.text = newsChoosed.news
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}