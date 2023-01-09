package codes.edrich.locationsaver.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import codes.edrich.locationsaver.databinding.ItemLocationBinding
import codes.edrich.locationsaver.model.Location

class LocationAdapter(val locations: List<Location>) :
    RecyclerView.Adapter<LocationAdapter.ItemViewHolder>() {

    class ItemViewHolder(val itemBinding: ItemLocationBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemLocationBinding =
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemLocationBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = locations[position]

        holder.itemBinding.locationItemNameText.text = item.name
        holder.itemBinding.locationItemWordsText.text = item.w3w

    }

    override fun getItemCount(): Int {
        return locations.size
    }
}