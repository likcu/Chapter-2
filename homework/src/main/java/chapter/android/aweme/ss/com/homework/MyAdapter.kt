package chapter.android.aweme.ss.com.homework

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chapter.android.aweme.ss.com.homework.model.Message
import chapter.android.aweme.ss.com.homework.model.InfoBarItem
import kotlinx.android.synthetic.main.im_list_item.view.*

class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var list: List<Message> = ArrayList()
    private var infoBarList: List<InfoBarItem> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        if(infoBarList.isEmpty()) return 0
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1){
            return MessageViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.im_list_item,parent,false)
            )
        }
        return InfoBarViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.info_bar_list,parent,false))
    }

    override fun getItemCount(): Int = list.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        //when having different kind of viewHolder
        when(holder){
            is MessageViewHolder -> {
                holder.bind(list.get(position-1))//cause infobarlist is in the front position
            }
            is InfoBarViewHolder -> {
                holder.bind(infoBarList)
            }
        }
    }

    fun submitMessageList(userList: List<Message>){
        list = userList
    }
    fun submitInfoBarList(infoList: List<InfoBarItem>){
        infoBarList = infoList
    }

    //MessageViewHolder for message list
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val userIcon = itemView.iv_avatar
        //val robot_notice = itemView.robot_notice
        val userTitle = itemView.tv_title
        val userDescrip = itemView.tv_description
        val usedTime = itemView.tv_time

        fun bind(message: Message) {
            userTitle.setText(message.title)
            userDescrip.setText(message.description)
            usedTime.setText(message.time)
            if(message.isOfficial){
                itemView.robot_notice.visibility = View.INVISIBLE
            }
            when(message.icon){
                "TYPE_ROBOT" -> userIcon.setImageResource(R.drawable.session_robot)
                "TYPE_GAME" -> userIcon.setImageResource(R.drawable.icon_micro_game_comment)
                "TYPE_SYSTEM" -> userIcon.setImageResource(R.drawable.session_system_notice)
                "TYPE_STRANGER" -> userIcon.setImageResource(R.drawable.session_stranger)
                "TYPE_USER" -> userIcon.setImageResource(R.drawable.icon_girl)
            }
        }
    }

    //info bar viewholder above the message list
    class InfoBarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(infoItemList: List<InfoBarItem>){

        }
    }


}

