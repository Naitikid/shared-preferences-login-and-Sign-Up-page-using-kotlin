package com.example.demoproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.demoproject.Activity.file.utils.dialogmain
import com.example.demoproject.Activity.file.utils.sharePrefff
import com.example.demoproject.Activity.file.utils.emailPattern
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedpre: sharePrefff
    private lateinit var dialog:dialogmain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedpre = sharePrefff(this)
        dialog = dialogmain(this)
        initView()
    }
    private fun initView() {
        binding.apply {
            loginActivityBtn.setOnClickListener {
                val email = enterEmail.editText?.text?.toString()
                val password = enterPassword.editText?.text?.toString()
                val gettextmail = sharedpre.getPrefString("enteremail", "")
                val getpassword = sharedpre.getPrefString("enterpassword", "")

                enterEmail.error = null
                enterPassword.error = null

                if (email!!.isEmpty()) {
                    enterEmail.error = getString(R.string.error_email)
                } else if (!email.matches(emailPattern.toRegex())) {
                    enterEmail.error = getString(R.string.correct_email)
                } else if (password!!.isEmpty()) {
                    enterPassword.error = getString(R.string.error_pass)
                } else if (email != gettextmail || password != getpassword) {
                    Toast.makeText(
                        this@LoginActivity, R.string.email_is_not_match, Toast.LENGTH_SHORT
                    ).show()
                } else {
                   /* Toast.makeText(
                        this@LoginActivity, R.string.sucessfull_Login, Toast.LENGTH_SHORT
                    ).show()*/
                    sharedpre.setPrefBoolean("userlogin", true)
                    dialog.dialog(R.string.areyousurelogin,  R.string.sucessfull_Login)
                   /* startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                    finishAffinity()*/
                }

            }
        }
        binding.apply {
            btnSignUp.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
                finishAffinity()
            }
        }
    }
}

