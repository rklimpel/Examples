package de.tklimpel.fragmentsharedelementtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.TransitionInflater
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    lateinit var fragmentA : FragmentA
    lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentA = FragmentA()
        fragmentA.sharedElementReturnTransition = TransitionInflater.from(this).inflateTransition(android.R.transition.move)

        frameLayout = findViewById(R.id.frame_layout)

        supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(frameLayout.id,fragmentA)
                .commit()
    }
}