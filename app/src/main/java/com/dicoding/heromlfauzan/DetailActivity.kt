package com.dicoding.heromlfauzan

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Images.Media.insertImage
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail Hero ML"
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#33cae8")))



        val button :Button = findViewById(R.id.action_share)
        val tvDetailName : TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription : TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto : ImageView = findViewById(R.id.iv_detail_photo)
        val tvDetailalias : TextView = findViewById(R.id.tv_detail_alias)
        val tvDetailgender : TextView = findViewById(R.id.tv_detail_gender)
        val tvDetailspecies : TextView = findViewById(R.id.tv_detail_species)
        val tvDetaildamagetype :TextView = findViewById(R.id.tv_detail_damagetype)


        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>("key_hero", Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>("key_hero")
        }
        button.setOnClickListener{
            val wl = BitmapFactory.decodeResource(resources, dataHero!!.photo)
            val intent = Intent()
            intent.action= Intent.ACTION_SEND

            val path= insertImage(contentResolver,wl,"title",null)

            val uri= Uri.parse(path)

            intent.putExtra(Intent.EXTRA_STREAM, uri)
            intent.putExtra(Intent.EXTRA_TEXT, dataHero.description)
            intent.putExtra(Intent.EXTRA_TITLE, dataHero.name)
            intent.type = "image/*"
            intent.type = "text/*"
            startActivity(Intent.createChooser(intent,"Share to :"))


        }
        tvDetailName.text = dataHero!!.name
        tvDetailDescription.text = dataHero.description
        ivDetailPhoto.setImageResource(dataHero.photo)
        tvDetailalias.text = dataHero.alias
        tvDetailgender.text = dataHero.gender
        tvDetailspecies.text = dataHero.species
        tvDetaildamagetype.text = dataHero.damagetype
    }
}