package com.jingom.simplelotto.screens.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jingom.simplelotto.databinding.LatestLottoResultListItemBinding
import com.jingom.simplelotto.screens.model.LottoResult

class LatestLottoResultAdapter: RecyclerView.Adapter<LatestLottoResultAdapter.LatestLottoResultViewHolder>() {

	var lottoResult: LottoResult? = null
		set(value) {
			field = value
			notifyItemChanged(0)
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestLottoResultViewHolder {
		return LatestLottoResultViewHolder.from(parent)
	}

	override fun onBindViewHolder(holder: LatestLottoResultViewHolder, position: Int) {
		holder.bind(lottoResult)
	}

	override fun getItemCount() = 1

	class LatestLottoResultViewHolder(private val binding: LatestLottoResultListItemBinding): RecyclerView.ViewHolder(binding.root) {

		fun bind(latestLottoResult: LottoResult?) {

		}

		companion object {
			fun from(parent: ViewGroup): LatestLottoResultViewHolder {
				val layoutInflater = LayoutInflater.from(parent.context)
				val binding = LatestLottoResultListItemBinding.inflate(layoutInflater, parent, false)

				return LatestLottoResultViewHolder(binding)
			}
		}
	}
}