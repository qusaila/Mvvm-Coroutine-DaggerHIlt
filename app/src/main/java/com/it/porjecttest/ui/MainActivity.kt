package com.it.porjecttest.ui

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.it.porjecttest.R
import com.it.porjecttest.base.BaseActivity
import com.it.porjecttest.databinding.ActivityMainBinding
import com.it.porjecttest.utils.ApiStatus
import com.it.porjecttest.viewmodels.LauchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    val model: LauchViewModel by viewModels()
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        getUserInfoApi()



    }

    fun getUserInfoApi() {


        model.getUser().observe(this, Observer {

            when (it.status) {

                ApiStatus.SUCCESS -> {
                    it?.let {
                        Toast.makeText(
                            this,
                            ApiStatus.SUCCESS.name + " " + it.data!!.student!!.firstName,
                            Toast.LENGTH_LONG
                        ).show()
                    }


                }
                ApiStatus.CONFLICT -> {
                    Toast.makeText(this, ApiStatus.CONFLICT.name, Toast.LENGTH_LONG).show()

                }
                ApiStatus.UNAUTHORIZED -> {
                    Toast.makeText(this, ApiStatus.UNAUTHORIZED.name, Toast.LENGTH_LONG).show()

                }

                ApiStatus.LOADING -> {
                    Toast.makeText(this, ApiStatus.LOADING.name, Toast.LENGTH_LONG).show()

                }
                ApiStatus.ERROR -> {
                    Toast.makeText(this, ApiStatus.ERROR.name, Toast.LENGTH_LONG).show()

                }
                ApiStatus.NOINTERNETCONNECTION -> {
                    Toast.makeText(this, ApiStatus.NOINTERNETCONNECTION.name, Toast.LENGTH_LONG)
                        .show()

                }
                else -> {
                    Toast.makeText(this, ApiStatus.ERROR.name, Toast.LENGTH_LONG)
                        .show()
                }
            }

        })

    }
}