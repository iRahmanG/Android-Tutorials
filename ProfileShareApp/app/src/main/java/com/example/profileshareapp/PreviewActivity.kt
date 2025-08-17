package com.example.profileshareapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreviewActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        // getting data from intent
        val imagePreview: ImageView = findViewById(R.id.imgPreview)
        val tvName: TextView = findViewById(R.id.tvName)
        val tvEmail: TextView = findViewById(R.id.tvEmail)
        val tvMobile: TextView = findViewById(R.id.tvMobile)
        val tvWebsite: TextView = findViewById(R.id.tvWebsite)
        val btnOpenWebsite: Button = findViewById(R.id.btnOpenWebsite)
        val btnShareProfile: Button = findViewById(R.id.btnShareProfile)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val mobile = intent.getStringExtra("mobile")
        val website = intent.getStringExtra("website")
        val imageUriString = intent.getStringExtra("imageUri")
        val imageUri = Uri.parse(imageUriString)

        val btnCall : Button = findViewById(R.id.btnCall)
        val btnSendSMS : Button = findViewById(R.id.btnSendSMS)

        // setting data to views
        imagePreview.setImageURI(imageUri)
        tvName.text = name
        tvEmail.text = email
        tvMobile.text = mobile
        tvWebsite.text = website


        // Share Profile button click listener -> Implicit Intent
        btnShareProfile.setOnClickListener {
            val shareText = "Name: $name\nEmail: $email\nWebsite: $website"
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

        // Call button click listener -> Implicit Intent
        btnCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:$mobile") // Set the phone number
            startActivity(callIntent)
        }

        // Send SMS button click listener -> Implicit Intent
        btnSendSMS.setOnClickListener {
            val smsIntent = Intent(Intent.ACTION_SENDTO)
            smsIntent.data = Uri.parse("smsto:$mobile") // Set the phone number
            smsIntent.putExtra("sms_body", "Hello, I am $name") // Set the message
            startActivity(smsIntent)
        }

        // Open Website button click listener -> Implicit Intent
        btnOpenWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(website))
            startActivity(intent)
        }
    }

}