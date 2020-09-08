package chapter.android.aweme.ss.com.homework

import android.graphics.LinearGradient
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import chapter.android.aweme.ss.com.homework.model.PullParser
import kotlinx.android.synthetic.main.activity_tips.*
import java.sql.DriverManager.println

class Exercise3 : AppCompatActivity() {

    //private var assetInput = assets.open("data.xml")
    //private var messages = PullParser.pull2xml(assetInput)

    private lateinit var userAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tips)

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        var assetInput = assets.open("data.xml")
        var messages = PullParser.pull2xml(assetInput)
        userAdapter.submitList(messages)
    }


    private fun initRecyclerView() {

        rv_list.apply {
            layoutManager = LinearLayoutManager(this@Exercise3)
            userAdapter = MyAdapter()
            adapter = userAdapter
        }
    }

}