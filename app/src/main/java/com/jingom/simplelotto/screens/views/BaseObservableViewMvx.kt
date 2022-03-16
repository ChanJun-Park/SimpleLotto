package com.jingom.simplelotto.screens.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes

abstract class BaseObservableViewMvx<ListenerType>(
	layoutInflater: LayoutInflater,
	parent: ViewGroup?,
	@LayoutRes layoutResId: Int
): BaseViewMvx(layoutInflater, parent, layoutResId), ObservableViewMvx<ListenerType> {

	private val listeners = HashSet<ListenerType>()

	override fun registerListener(listener: ListenerType) {
		listeners.add(listener)
	}

	override fun unregisterListener(listener: ListenerType) {
		listeners.remove(listener)
	}
}