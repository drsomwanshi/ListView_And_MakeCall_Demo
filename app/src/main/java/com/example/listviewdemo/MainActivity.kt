package com.example.listviewdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arr= arrayOf("Ram Gochade\n9846465454","Sanket Fere\n984765454","Rushikesh Gorte\n6576465454","Abhishek Mane\n9866675465","Ram Gochade\n9846465454","Sanket Fere\n984765454","Rushikesh Gorte\n6576465454","Abhishek Mane\n9866675465","Ram Gochade\n9846465454","Sanket Fere\n984765454","Rushikesh Gorte\n6576465454","Abhishek Mane\n9866675465","Ram Gochade\n9846465454","Sanket Fere\n984765454","Rushikesh Gorte\n6576465454","Abhishek Mane\n9866675465")
        var adapter=ArrayAdapter(this,
            android.R.layout.simple_list_item_1,arr);
        var lst1=findViewById(R.id.lst1) as ListView;
        lst1.adapter=adapter;
        lst1.onItemClickListener=object :OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                var n=lst1.getItemAtPosition(position).toString();
                Toast.makeText(applicationContext,"Selected=" + n ,
                    Toast.LENGTH_LONG).show();
                var n1=n.split("\n")
                var mob=n1[1];
                var i=Intent(Intent.ACTION_DIAL)
                i.setData(Uri.parse("tel:" + mob))
                startActivity(i)
            }
        }
    }
}