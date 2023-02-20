package com.pra.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pra.navigation.databinding.FragmentHomeBinding
import com.pra.navigation.databinding.FragmentViewBalanceBinding

class HomeFragment : Fragment(R.layout.fragment_home) {


    private var mBinding: FragmentHomeBinding? = null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = FragmentHomeBinding.inflate(inflater, container, false);
        return mBinding?.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        mBinding?.btnViewBalance?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment()
            navController.navigate(action)
        }

        mBinding?.btnSendMoney?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
            navController.navigate(action)
        }

        mBinding?.btnTransactions?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionFragment()
            navController.navigate(action)
        }
    }


}