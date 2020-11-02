package com.example.mycontacts

import android.content.Intent
import android.graphics.ColorSpace
import android.graphics.ColorSpace.Model
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.*
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   var contactList:ArrayList<Contacts>?= arrayListOf()
        val mRecyclerView:RecyclerView=findViewById(R.id.recyclerview)
        val button:FloatingActionButton = findViewById(R.id.add)
        val mDatabaseReference:DatabaseReference=FirebaseDatabase.getInstance().getReference("Contacts")
        mDatabaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(p0:DataSnapshot){
                for (i in p0.children){
                    val item=i.getValue(Contacts::class.java)
                    contactList!!.add(item!!)
                }


                
                val adapter=ContactsAdapter(contactList!!)
                mRecyclerView.adapter= adapter

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        toAddContact.setOnClickListener(){
            startActivity(Intent(this,AddContactActivity::class.java))
        }


    }


}