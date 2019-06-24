package hs.khosbayar.droidjetpack.employee


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import hs.khosbayar.droidjetpack.R
import hs.khosbayar.droidjetpack.data.DroidRoomDatabase
import hs.khosbayar.droidjetpack.data.EmployeeLocalCache
import hs.khosbayar.droidjetpack.data.EmployeeRepository
import hs.khosbayar.droidjetpack.databinding.FragmentEmployeeBinding
import hs.khosbayar.droidjetpack.details.EmployeeDetailsFragmentArgs
import hs.khosbayar.droidjetpack.network.EmployeeApi
import hs.khosbayar.droidjetpack.network.EmployeeApiService

/**
 * A simple [Fragment] subclass.
 *
 */
class EmployeeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEmployeeBinding.inflate(inflater)
        val application = requireNotNull(this.activity).application
        val factory = EmployeeViewModelProviderFactory(EmployeeRepository(EmployeeApi.retrofitService,
            EmployeeLocalCache(DroidRoomDatabase.getDatabase(application).employeeDao())
        ))
        val viewModel = ViewModelProviders.of(this, factory).get(EmployeeViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        val manager = LinearLayoutManager(context)
        val adapter = EmployeeAdapter(EmployeeOnClickListener {
            Navigation.findNavController(view!!).navigate(EmployeeFragmentDirections.actionEmployeeFragmentToEmployeeDetailsFragment(it))
        })
        binding.rvEmployee.layoutManager = manager
        binding.rvEmployee.adapter = adapter

        viewModel.employees.observe(this, Observer {
            list ->
            list?.let {
                adapter.submitList(list)
            }
        })

        viewModel.networkError.observe(this, Observer {
            error ->
            error.let {
                if(error!="")
                    Toast.makeText(context, "Oops: $error", Toast.LENGTH_LONG).show()
            }
        })

        return binding.root
    }


}
