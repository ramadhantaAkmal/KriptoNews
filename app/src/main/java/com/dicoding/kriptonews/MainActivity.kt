package com.dicoding.kriptonews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKripto: RecyclerView
    private var list: ArrayList<KriptoNews> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "KriptoNews"

        rvKripto = findViewById(R.id.rv_kripto)
        rvKripto.setHasFixedSize(true)

        list.addAll(KriptoNewsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvKripto.layoutManager = LinearLayoutManager(this)
        val listKriptoAdapter = ListKriptoAdapter(list)
        rvKripto.adapter = listKriptoAdapter

        listKriptoAdapter.setOnItemClickCallback(object : ListKriptoAdapter.OnItemClickCallback {
            override fun onItemClicked(index: Int) {
                showSelectedKripto(index)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.btn_about_page) {
            val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
            startActivity(moveIntent)
        }
        return true
    }

    private fun showSelectedKripto(index: Int) {
        val moveIntent = Intent(this@MainActivity, DetailPage::class.java)
        moveIntent.putExtra(DetailPage.EXTRA_INDEX, index)
        startActivity(moveIntent)
    }

}