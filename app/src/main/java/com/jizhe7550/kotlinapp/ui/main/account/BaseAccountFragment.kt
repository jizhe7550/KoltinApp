package com.jizhe7550.kotlinapp.ui.main.account

import android.content.Context
import android.util.Log
import com.jizhe7550.kotlinapp.ui.DataStateChangeListener
import dagger.android.support.DaggerFragment

abstract class BaseAccountFragment : DaggerFragment(){

    val TAG: String = "AppDebug"

    lateinit var stateChangeListener: DataStateChangeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            stateChangeListener = context as DataStateChangeListener
        }catch(e: ClassCastException){
            Log.e(TAG, "$context must implement DataStateChangeListener" )
        }
    }
}