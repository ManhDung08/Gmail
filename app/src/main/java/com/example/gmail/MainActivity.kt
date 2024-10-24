package com.example.gmail

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emails = listOf(
            Email("Edurila.com", "$19 Only (First 10 spots) - Bestselling Courses", "Are you looking to Learn Web Desining..."),
            Email("Chris Abad", "Help make Campaign Monitor better", "Let us know your thought!..."),
            Email("Tuto.com", "8h de formation gratuite", "Photoshop, SEO, Blender, Css, WordPress,..."),
            Email("Support", "Société Ovh : suivi de vos services", "SAS OVH - http://www.ovh.com 2 rue K..."),
            Email("Matt from Ionic", "The New Ionic Creator Is Here!", "Announcing the all-new Creator, build Ionic apps visually..."),
            Email("Jane Doe", "New Feature: Dark Mode in App", "We're excited to announce the new dark mode feature! Try it today..."),
            Email("John Smith", "Invitation to Tech Conference 2024", "Join us at the biggest tech conference of the year. Early bird tickets available...")
        )

        val emailAdapter = EmailAdapter(this, emails)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = emailAdapter
    }

    class EmailAdapter(private val context: Context, private val emails: List<Email>) : BaseAdapter() {

        override fun getCount(): Int {
            return emails.size
        }

        override fun getItem(position: Int): Any {
            return emails[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflater = LayoutInflater.from(context)
            val view = convertView ?: inflater.inflate(R.layout.list_item, parent, false)

            val avatar = view.findViewById<TextView>(R.id.avatar)
            val title = view.findViewById<TextView>(R.id.title)
            val description = view.findViewById<TextView>(R.id.description)
            val receiver = view.findViewById<TextView>(R.id.receiver)

            val email = emails[position]

            // Set data
            avatar.text = email.receiver[0].toString()
            receiver.text = email.receiver
            title.text = email.title
            description.text = email.description

            // Tạo màu ngẫu nhiên
            val random = Random()
            val color = Color.argb(
                255,
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
            )

            // Áp dụng màu ngẫu nhiên cho avatar
            val shape = GradientDrawable()
            shape.shape = GradientDrawable.OVAL
            shape.setColor(color)
            avatar.background = shape

            return view
        }
    }
}
