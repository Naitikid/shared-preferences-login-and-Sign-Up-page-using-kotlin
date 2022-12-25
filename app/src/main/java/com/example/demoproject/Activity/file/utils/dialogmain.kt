package com.example.demoproject.Activity.file.utils

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import com.example.demoproject.Activity.HomeActivity
import com.example.demoproject.Activity.LoginActivity
import com.example.demoproject.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class dialogmain(val activity:Activity) {


    fun dialog(title: Int, isValue: Int) {
        val materialAlertDialog = MaterialAlertDialogBuilder(activity)
        materialAlertDialog.setTitle(title)
        materialAlertDialog.setIcon(R.drawable.logo)
        materialAlertDialog.setMessage(title)
        materialAlertDialog.setPositiveButton(
            R.string.ok,
            DialogInterface.OnClickListener { abc, bca ->

                when (isValue) {
                    R.string.sucessfull_SignUp -> {
                        activity.startActivity(Intent(activity, LoginActivity::class.java))
                        activity.finishAffinity()
                    }
                    R.string.sucessfull_Login -> {
                        activity.startActivity(Intent(activity, HomeActivity::class.java))
                        activity.finishAffinity()

                    }
                }

                materialAlertDialog.setCancelable(false)

            })
        materialAlertDialog.show()
    }
}

