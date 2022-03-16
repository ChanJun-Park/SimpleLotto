package com.jingom.simplelotto.screens.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

abstract class BaseViewMvx(
	layoutInflater: LayoutInflater,
	parent: ViewGroup?,
	@LayoutRes layoutResId: Int
): ViewMvx {

	override val rootView: View = layoutInflater.inflate(layoutResId, parent, false)

	protected val context: Context
		get() = rootView.context

	protected fun <T : View?> findViewById(@IdRes id: Int): T {
		return rootView.findViewById<T>(id)
	}
}