package chapter.android.aweme.ss.com.homework

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import chapter.android.aweme.ss.com.homework.model.PullParser
import chapter.android.aweme.ss.com.homework.model.InfoBarItem
import kotlinx.android.synthetic.main.activity_tips.*

class Exercise3 : AppCompatActivity() {

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
        userAdapter.submitMessageList(messages)
        var infoBarList = listOf<InfoBarItem>(InfoBarItem("粉丝", "FANS"), InfoBarItem("赞","LIKE"), InfoBarItem("@我的","PEOPLE"), InfoBarItem("评论","COMMENT"))
        userAdapter.submitInfoBarList(infoBarList)

    }


    private fun initRecyclerView() {

        rv_list.apply {
            layoutManager = LinearLayoutManager(this@Exercise3)
            userAdapter = MyAdapter()
            adapter = userAdapter
        }
    }

}