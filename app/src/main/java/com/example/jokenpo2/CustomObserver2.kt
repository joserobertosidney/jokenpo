package com.example.jokenpo2

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import java.security.acl.Owner
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer


class CustomObserver2 : DefaultLifecycleObserver {

        override fun onResume(owner: LifecycleOwner) {
            super.onResume(owner)
            Log.d("LifeCycle", "Observer ${owner.toString()} - onResume")
        }

        fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event){
            Log.d("LifeCycle","Observer ${source.toString()} event: ${event.toString()}")

        }
}