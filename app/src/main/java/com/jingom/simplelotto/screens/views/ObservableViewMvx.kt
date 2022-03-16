package com.jingom.simplelotto.screens.views

interface ObservableViewMvx<ListenerType>: ViewMvx {
	fun registerListener(listener: ListenerType)
	fun unregisterListener(listener: ListenerType)
}