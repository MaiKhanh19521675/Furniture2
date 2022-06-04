package com.example.furniture2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_model.view.*

const val SELECTED_MODEL_COLOR = Color.YELLOW
const val UNSELECTED_MODEL_COLOR = Color.LTGRAY

class ModelAdapter(
    private val models: List<Model>,
    private val itemClick: (Model) -> Unit

) : RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {

    var selectedModel = MutableLiveData<Model>()
    private var selectedModelIndex = 0

    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_model, parent, false)

        return ModelViewHolder(view)
    }

    override fun getItemCount() = models.size


    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {

        if (selectedModelIndex == holder.layoutPosition) {
            holder.itemView.setBackgroundColor(SELECTED_MODEL_COLOR)
            selectedModel.value = models[holder.layoutPosition]
        } else {
            holder.itemView.setBackgroundColor(UNSELECTED_MODEL_COLOR)
        }
//        holder.bindView(models[position],listener).apply {
//
//        }
        holder.itemView.apply {
            ivThumbnail.setImageResource(models[position].imageResource)
            tvTitle.text = models[position].title

            setOnClickListener {
                selectModel(holder)


            }
        }
        holder.itemView.setOnClickListener {
            itemClick(models[position])
        }
    }

    private fun selectModel(holder: ModelViewHolder) {
        if (selectedModelIndex != holder.layoutPosition) {
            holder.itemView.setBackgroundColor(SELECTED_MODEL_COLOR)
            notifyItemChanged(selectedModelIndex)
            selectedModelIndex = holder.layoutPosition
            selectedModel.value = models[holder.layoutPosition]
        }
    }

}