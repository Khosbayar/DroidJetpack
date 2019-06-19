package hs.khosbayar.droidjetpack.details


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hs.khosbayar.droidjetpack.databinding.FragmentEmployeeDetailsBinding


/**
 * A simple [Fragment] subclass.
 *
 */
class EmployeeDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding  = FragmentEmployeeDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val args = EmployeeDetailsFragmentArgs.fromBundle(arguments!!)


        binding.employee = args.employee
        binding.executePendingBindings()

        return binding.root
    }


}
