package com.example.recycleview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.EquipmentItemBinding


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.EquipmentHolder>() {
    val equipmentList = ArrayList<Equipment>()
    class EquipmentHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = EquipmentItemBinding.bind(item)
        fun bind(equipment: Equipment) = with(binding){
            image.setImageResource(equipment.imageId)
            title.text = equipment.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipmentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.equipment_item, parent, false)
        return EquipmentHolder(view)
    }

    override fun onBindViewHolder(holder: EquipmentHolder, position: Int) {
        holder.bind(equipmentList[position])
    }

    override fun getItemCount(): Int {
        return equipmentList.size
    }
    fun addEquipment(equipment: Equipment){
        equipmentList.add(equipment)
        notifyDataSetChanged()

    }
}
