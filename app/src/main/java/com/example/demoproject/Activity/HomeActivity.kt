package com.example.demoproject.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demoproject.Activity.file.utils.sharePrefff
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedpre: sharePrefff

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedpre = sharePrefff(this)
        binding.homeTextOne.text = sharedpre.getPrefString("username", "")
        binding.homeTextTwo.text = sharedpre.getPrefString("enteremail", "")
        binding.homeTextThree.text = sharedpre.getPrefString("enterpassword", "")
        binding.homeTextFour.text = sharedpre.getPrefString("enter_confrom_password", "")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                Toast.makeText(this, getText(R.string.profile), Toast.LENGTH_SHORT).show()
            }
            R.id.Logout_menu -> {
                val editor = sharedpre.editor
                editor.clear()
                editor.apply()
                Toast.makeText(this, getText(R.string.logout), Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
        finish()
    }

}
