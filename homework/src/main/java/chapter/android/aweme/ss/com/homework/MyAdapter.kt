package chapter.android.aweme.ss.com.homework

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import chapter.android.aweme.ss.com.homework.model.Message
import chapter.android.aweme.ss.com.homework.widget.CircleImageView
import kotlinx.android.synthetic.main.im_list_item.view.*
import java.util.zip.Inflater

class MyAdapter : RecyclerView.Adapter<MyAdapter.MessageViewHolder>() {
    private var list: List<Message> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.im_list_item,parent,false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        //when having different kind of viewHolder
        when(holder){
            is MessageViewHolder -> {
                holder.bind(list.get(position))
            }
        }
    }

    fun submitList(userList: List<Message>){
        list = userList
    }

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

}

