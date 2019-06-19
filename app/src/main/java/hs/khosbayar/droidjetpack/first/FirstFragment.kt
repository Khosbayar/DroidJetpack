package hs.khosbayar.droidjetpack.first


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import hs.khosbayar.droidjetpack.R
import hs.khosbayar.droidjetpack.data.LuckyNumber
import hs.khosbayar.droidjetpack.first.FirstFragmentDirections
import hs.khosbayar.droidjetpack.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentFirstBinding.inflate(inflater)

        val factory = FirstViewModelProviderFactory("Fragment 1 + binding working")

        val viewModel = ViewModelProviders.of(this, factory).get(FirstViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.navigateToSecond.observe(this, Observer {
            navigate ->
            if(navigate == true && viewModel.text.value != null){
                val number = Integer.valueOf(viewModel.text.value!!) ?: 0
                Navigation.findNavController(view!!).navigate(
                    FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                        number
                    )
                )
                viewModel.doneNavigatingToSecond()
            }

        })

        viewModel.navigateToEmployees.observe(this, Observer {
            navigate ->
            if(navigate == true){
                Navigation.findNavController(view!!).navigate(R.id.action_firstFragment_to_employeeFragment)
                viewModel.doneNavigatingToEmployees()
            }
        })


        return binding.root
    }


}
