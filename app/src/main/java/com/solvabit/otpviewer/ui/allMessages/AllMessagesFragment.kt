package com.solvabit.otpviewer.ui.allMessages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.solvabit.otpviewer.R
import com.solvabit.otpviewer.databinding.FragmentAllMessagesBinding

class AllMessagesFragment : Fragment() {

    private lateinit var binding: FragmentAllMessagesBinding
    private lateinit var viewModel: AllMessagesViewModel
    private val args: AllMessagesFragmentArgs by navArgs()

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = args.messages[0].address
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllMessagesBinding.inflate(inflater)

        val messagesViewModelFactory = AllMessagesViewModelFactory(args.messages.toList(), requireContext())
        viewModel = ViewModelProvider(this, messagesViewModelFactory)[AllMessagesViewModel::class.java]
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.allMessagesRecyclerView.adapter = AllMessagesAdapter(MessagesListener {
//            this.findNavController().navigate(
////                AllMessa.actionMessagesFragmentToMessageDetailsFragment(it)
//            )
            Toast.makeText(context, "clicked on - ${it.address}", Toast.LENGTH_SHORT).show()
        })

        binding.allMessagesBackButton.setOnClickListener {
            this.findNavController().popBackStack()
        }

        return binding.root
    }

}