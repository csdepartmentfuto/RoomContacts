package com.example.android.roomcontacts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomcontacts.R

class ContactAdapter(): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val contacts = mutableListOf<Contact>()

    fun setUpData(contacts: List<Contact>) {
        this.contacts.addAll(contacts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.contact_list_item, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ContactViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(contact: Contact) {
            val name = itemView.findViewById<TextView>(R.id.name_tv)
            val phoneNo = itemView.findViewById<TextView>(R.id.phone_no_tv)

            name.text = contact.name
            phoneNo.text = contact.phoneNo
        }
    }
}