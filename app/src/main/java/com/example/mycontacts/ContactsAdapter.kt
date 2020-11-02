package com.example.mycontacts

import android.provider.ContactsContract
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*
import java.nio.file.Files.size

class ContactsAdapter(contacts: ArrayList<Contacts>?) {

    class ViewHolder(View:View):RecyclerView.ViewHolder(View){
        val name:TextView=View.findViewById(R.id.tvName)
        val email:TextView=View.findViewById(R.id.tvEmail)
        val phoneNumber:TextView=View.findViewById(R.id.tvPhoneNumber)


    }

    override fun onCreateViewHolder(p0:ViewGroup,p1:String):ViewHolder{
        return ViewHolder((LayoutInflater.from(p0.context).inflate(R.layout.row,p0,false)))
    }

    override fun onBindViewHolder(p0:ViewHolder,p1:Int){
        val itm=contactList[p1]

        p0.name.text=itm.Name
        p0.email.text=itm.Email
        p0.phoneNumber.text=itm.phoneNumber
    }
   override fun getItemCount():Int{
        return contactsList.size
    }

    fun clear(){
        val size:Int=Contacts.size()
        Contacts.clear()
        notifyItemRangeRemoved(0,size)
    }

}