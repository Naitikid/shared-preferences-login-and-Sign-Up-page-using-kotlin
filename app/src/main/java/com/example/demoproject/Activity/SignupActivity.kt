package com.example.demoproject.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.demoproject.Activity.file.utils.dialogmain
import com.example.demoproject.Activity.file.utils.sharePrefff
import com.example.demoproject.Activity.file.utils.emailPattern
import com.example.demoproject.R
import com.example.demoproject.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var sharedpre: sharePrefff
    private lateinit var dialog: dialogmain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedpre = sharePrefff(this)
        dialog = dialogmain(this)
        initView()
    }

    private fun initView() {
        binding.apply {
            signSignAcivityBtn.setOnClickListener {
                val enterusername = enterUsernameSign.editText?.text?.toString()
                val enteremailadress = enterEmailSign.editText?.text?.toString()
                val enterpassword = enterPasswordSign.editText?.text?.toString()
                val enterpasswordconfrom = passwordConfirmsign.editText?.text?.toString()

                enterUsernameSign.error = null
                enterEmailSign.error = null
                passwordConfirmsign.error = null
                enterPasswordSign.error = null

                if (enterusername!!.isEmpty()) {
                    enterUsernameSign.error = getString(R.string.error_user_name)
                } else if (enteremailadress!!.isEmpty()) {
                    enterEmailSign.error = getString(R.string.error_email)
                } else if (!enteremailadress!!.matches(emailPattern.toRegex())) {
                    enterEmailSign.error = getString(R.string.correct_email)
                } else if (enterpassword!!.isEmpty()) {
                    enterPasswordSign.error = getString(R.string.erro_enter_password)
                } else if (enterpasswordconfrom!!.isEmpty()) {
                    passwordConfirmsign.error = getString(R.string.erro_enter_password)
                } else if (enterpassword != enterpasswordconfrom) {
                    passwordConfirmsign.error = getString(R.string.erro_enter_password)
                } else {
                    dialog.dialog(R.string.sucessfull_SignUp,R.string.sucessfull_SignUp)
                    sharedpre.setPrefString("username", enterusername)
                    sharedpre.setPrefString("enteremail", enteremailadress)
                    sharedpre.setPrefString("enterpassword", enterpassword)
                    sharedpre.setPrefString("enter_confrom_password", enterpasswordconfrom)

                    binding.apply {
                        signSignAcivityBtn.setOnClickListener {
                            startActivity(Intent(this@SignupActivity, SignupActivity::class.java))
                            finishAffinity()
                        }
                    }

                }
            }
        }
    }
}