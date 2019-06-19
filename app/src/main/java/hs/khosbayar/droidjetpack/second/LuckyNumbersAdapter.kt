package hs.khosbayar.droidjetpack.second


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hs.khosbayar.droidjetpack.data.LuckyNumber
import hs.khosbayar.droidjetpack.databinding.ListItemLuckyNumberBinding

class LuckyNumbersAdapter(val numberClickListener: NumberClickListener): ListAdapter<LuckyNumber, LuckyNumbersAdapter.ViewHolder>(LuckyNumberDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val number = getItem(position)
        holder.bind(numberClickListener, number)
    }

    class ViewHolder(val binding: ListItemLuckyNumberBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: NumberClickListener, number: LuckyNumber){
            binding.clickListener = clickListener
            binding.luckyNumber = number
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemLuckyNumberBinding.inflate(layoutInflater)
                return ViewHolder(binding)
            }
        }
    }
}

class LuckyNumberDiffCallback : DiffUtil.ItemCallback<LuckyNumber>(){
    override fun areItemsTheSame(oldItem: LuckyNumber, newItem: LuckyNumber): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LuckyNumber, newItem: LuckyNumber): Boolean {
        return oldItem == newItem
    }
}

class NumberClickListener(val clickListener: (number: LuckyNumber) -> Unit){
    fun onClick(number: LuckyNumber) = clickListener(number)
}