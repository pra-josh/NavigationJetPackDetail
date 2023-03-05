package com.pra.navigation

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.pra.navigation.databinding.ActivityConditionalBinding

class ConditionalActivity : AppCompatActivity() {


    private var mBinding: ActivityConditionalBinding? = null

    public var sharePreference: SharePreference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityConditionalBinding.inflate(layoutInflater)
        setContentView(mBinding?.root)

        sharePreference = SharePreference(applicationContext)



    }


}