package com.example.android.roomcontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomcontacts.adapter.Contact
import com.example.android.roomcontacts.adapter.ContactAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class FamilyActivity : AppCompatActivity() {

    private lateinit var familyAdapter: ContactAdapter
    private lateinit var familyRecyclerView: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var builder: AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog
    private lateinit var name: TextInputEditText
    private lateinit var phoneNo: TextInputEditText
    private lateinit var saveBtn: MaterialButton
    private lateinit var addBtn: FloatingActionButton
    private lateinit var dialogueView: View
    private lateinit var contact: Contact


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contacts)

        init()

        createAlertDialogue()

        setUpContact()
    }

    private fun init() {

        familyAdapter = ContactAdapter()
        familyRecyclerView = findViewById(R.id.contacts_rv)
        gridLayoutManager = GridLayoutManager(this, 2)

        familyRecyclerView.layoutManager = gridLayoutManager

        familyRecyclerView.adapter = familyAdapter


    }

    private fun createAlertDialogue() {
        builder = AlertDialog.Builder(this)

        dialogueView =
            LayoutInflater.from(this).inflate(R.layout.add_contact_dialogue, null)

        builder.setView(dialogueView)

        alertDialog = builder.create()
    }

    private fun setUpContact() {

        name = dialogueView.findViewById(R.id.name_et)
        phoneNo = dialogueView.findViewById(R.id.phone_no_et)
        saveBtn = dialogueView.findViewById(R.id.save_btn)
        addBtn = findViewById(R.id.add_fab)

        addBtn.setOnClickListener {
            alertDialog.show()
        }

        phoneNo.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveBtn.isEnabled = s?.length == 11
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        saveBtn.setOnClickListener {
            contact = Contact(name.text.toString(), phoneNo.text.toString())
            val contacts = mutableListOf(contact)
            familyAdapter.setUpData(contacts)
            alertDialog.dismiss()
        }
    }

}