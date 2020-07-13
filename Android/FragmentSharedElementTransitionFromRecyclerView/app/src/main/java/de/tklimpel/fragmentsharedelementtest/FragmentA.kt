package de.tklimpel.fragmentsharedelementtest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class FragmentA : Fragment() {

    lateinit var a : ViewTreeObserver.OnPreDrawListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_a, container, false)
        val recyclerview : RecyclerView = v.findViewById(R.id.recyclerview)
        val listAdapter = ListAdapter(activity!! as MainActivity)
        recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = listAdapter
            postponeEnterTransition()

            viewTreeObserver
                .addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
        }
        return v
    }

}