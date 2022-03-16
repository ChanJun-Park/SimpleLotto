package com.jingom.simplelotto.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jingom.simplelotto.screens.views.ViewMvxFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

	private val viewModel: HomeFragmentViewModel by viewModels()

	@Inject lateinit var viewMvxFactory: ViewMvxFactory
	private lateinit var homeViewMvx: HomeViewMvx

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		homeViewMvx = viewMvxFactory.getHomeViewMvx(viewLifecycleOwner, container)
		return homeViewMvx.rootView
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		observeEvents()
	}

	private fun observeEvents() {
		viewModel.latestLottoResult.observe(viewLifecycleOwner) { lottoResult ->
			homeViewMvx.bindLottoResult(lottoResult)
		}
	}
}