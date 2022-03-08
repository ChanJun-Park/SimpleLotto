package com.jingom.simplelotto.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.jingom.simplelotto.R
import com.jingom.simplelotto.databinding.HomeFragmentBinding
import com.jingom.simplelotto.screens.dataBindings
import com.jingom.simplelotto.screens.home.adapter.LatestLottoResultAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {

	private val binding: HomeFragmentBinding by dataBindings(HomeFragmentBinding::bind)
	private val viewModel: HomeFragmentViewModel by viewModels()

	private lateinit var adapter: LatestLottoResultAdapter

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.lifecycleOwner = viewLifecycleOwner

		binding.homeUiList.adapter = LatestLottoResultAdapter().also {
			adapter = it
		}

		observeEvents()
	}

	private fun observeEvents() {
		viewModel.latestLottoResult.observe(viewLifecycleOwner) { lottoResult ->
			adapter.lottoResult = lottoResult
		}
	}
}