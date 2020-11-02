
package com.example.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_contact.*
import java.util.jar.Attributes

class AddContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        val name =findViewById<TextView>(R.id.tvName)
        val email=findViewById<TextView>(R.id.tvEmail)
        val phoneNumber=findViewById<TextView>(R.id.tvPhoneNumber)
        val add=findViewById<Button>(R.id.button)

        var contactList:ArrayList<Contacts>?= arrayListOf()
        val mDatabaseReference:DatabaseReference=FirebaseDatabase.getInstance().getReference("Contacts")
        add.setOnClickListener{
            val name=name.text.toString()
            val email=email.text.toString()
            val phoneNumber=tvPhoneNumber.toString()
            val contacts=Contacts(name,email,phoneNumber)
            mDatabaseReference.push().setValue(contacts)
            val adapter=ContactsAdapter(contactList!!)
            adapter.clear()
            finish()

        }

    }
}