package de.tklimpel.fragmentsharedelementtest

import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listitem.view.*

class ListAdapter(private val activity: MainActivity) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    class MyViewHolder(val layout : RelativeLayout) : RecyclerView.ViewHolder(layout) {
        val tv = itemView.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.MyViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem, parent, false) as RelativeLayout
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv.setText("Text " + position.toString())
        holder.tv.transitionName = holder.tv.text.toString()
        holder.tv.setOnClickListener {
            openEditActivity(holder.tv)
        }
    }

    override fun getItemCount() = 62

    fun openEditActivity(tv : TextView){
        val fragmentB = FragmentB(tv.text.toString())
        fragmentB.sharedElementEnterTransition = TransitionInflater.from(activity).inflateTransition(android.R.transition.move)
        activity.supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .addSharedElement(tv,tv.transitionName)
            .replace(activity.frameLayout.id,fragmentB)
            .commit()
    }
}

