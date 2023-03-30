package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentCabinetBinding
import com.example.myapplication.databinding.FragmentProfileBinding

// TODO: Rename parameter arguments, choose names that match
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class CabinetFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentCabinetBinding.inflate(inflater, container, false)

        val names = binding.name.text
        val password = binding.password.text
        val t = parentFragmentManager.beginTransaction()

        binding.enter.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.profile_main, MyOrderFragment.newInstance(names.toString(), password.toString()))
                .commit()
        }

        return binding.root
    }

    companion object {

        @JvmStatic fun newInstance(param1: String, param2: String) =
                CabinetFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}