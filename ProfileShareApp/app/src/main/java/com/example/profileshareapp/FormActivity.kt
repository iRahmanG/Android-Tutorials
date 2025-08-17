package com.example.profileshareapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    private lateinit var profileImage: ImageView
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etWebsite: EditText
    private var selectedImageUri: Uri? = null

    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                selectedImageUri = it
                profileImage.setImageURI(it)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        // finding views
        profileImage = findViewById(R.id.imgProfile)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etWebsite = findViewById(R.id.etWebsite)

        val btnSelectImage: Button = findViewById(R.id.btnSelectImage)
        val btnPreviewProfile: Button = findViewById(R.id.btnPreviewProfile)

        // setting click listeners
        btnSelectImage.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        btnPreviewProfile.setOnClickListener {
            val intent = Intent(this, PreviewActivity::class.java)
            intent.putExtra("name", etName.text.toString())
            intent.putExtra("email", etEmail.text.toString())
            intent.putExtra("website", etWebsite.text.toString())
            intent.putExtra("imageUri", selectedImageUri.toString())
            startActivity(intent)
        }
    }
}