package hs.khosbayar.droidjetpack.second


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import hs.khosbayar.droidjetpack.data.LuckyNumber
import hs.khosbayar.droidjetpack.second.SecondFragmentArgs
import hs.khosbayar.droidjetpack.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSecondBinding.inflate(inflater)
        val application = requireNotNull(this.activity).application

        binding.lifecycleOwner = this

        val arguments = SecondFragmentArgs.fromBundle(arguments!!)

        val chosenNum = arguments.chosenNumber

        Toast.makeText(context, "Added : ${chosenNum}", Toast.LENGTH_SHORT).show()


        val factory = SecondViewModelProviderFactory(application, chosenNum)

        val viewModel = ViewModelProviders.of(this, factory).get(SecondViewModel::class.java)

        val luckyNumber = LuckyNumber()
        luckyNumber.number = chosenNum
        viewModel.insert(luckyNumber)
        binding.viewModel = viewModel

        val manager = LinearLayoutManager(activity)
        val adapter = LuckyNumbersAdapter(NumberClickListener {
            number ->
                viewModel.incrementNumber(number)
        })
        binding.rvNumbers.layoutManager = manager
        binding.rvNumbers.adapter = adapter

        viewModel.allNumbers.observe(this, Observer {
            numbers ->
                numbers?.let{
                    adapter.submitList(it)
                }
        })



        return binding.root
    }


}
