package hs.khosbayar.droidjetpack.employee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hs.khosbayar.droidjetpack.databinding.ListItemEmployeeBinding
import hs.khosbayar.droidjetpack.data.Employee

class EmployeeAdapter(val clickListener: EmployeeOnClickListener) : ListAdapter<Employee, EmployeeAdapter.EmployeeViewHolder>(EmployeeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder{
        return EmployeeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(clickListener, getItem(position))
    }

    class EmployeeViewHolder(val binding: ListItemEmployeeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: EmployeeOnClickListener, employee: Employee){
            binding.employee = employee
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent:ViewGroup) : EmployeeViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemEmployeeBinding.inflate(inflater)
                return EmployeeViewHolder(binding)
            }
        }
    }
}

class EmployeeDiffCallback : DiffUtil.ItemCallback<Employee>() {
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem == newItem
    }
}

class EmployeeOnClickListener(val clickListener: (employee: Employee) -> Unit){
    fun onClick(employee: Employee){ clickListener(employee) }
}
