package com.jingom.simplelotto.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.jingom.simplelotto.R
import kotlin.math.min

private const val DEFAULT_LOTTO_NUMBER = 1

class LottoBall @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

	var lottoNumber: Int = DEFAULT_LOTTO_NUMBER
		set(value) {
			field = value

			setLottoBallColor()
			invalidate()
		}

	var isBonus: Boolean = false
		set(value) {
			field = value
			invalidate()
		}

	private var radius: Float = 0f

	private val lottoBallColorIndex: Int
		get() = (lottoNumber - 1) / 10

	private val centerX: Float get() = width.toFloat() / 2
	private val centerY: Float get() = height.toFloat() / 2

	private val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
		style = Paint.Style.FILL
		textAlign = Paint.Align.CENTER
	}

	private val lottoNumberTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
		style = Paint.Style.FILL
		color = resources.getColor(R.color.simple_lotto_white, null)
		textAlign = Paint.Align.CENTER
		textSize = 55.0f
	}

	private val bonusTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
		style = Paint.Style.FILL
		color = resources.getColor(R.color.simple_lotto_gray_500, null)
		textAlign = Paint.Align.CENTER
		textSize = 35f
	}

	private val bonusText = resources.getString(R.string.bonus)

	private fun setLottoBallColor() {
		val colorArray = resources.getIntArray(R.array.lotto_ball_color_array)
		if (0 <= lottoBallColorIndex && lottoBallColorIndex < colorArray.size) {
			backgroundPaint.color = colorArray[lottoBallColorIndex]
		}
	}

	override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
		radius = (min(w, h) / 2).toFloat()
	}

	override fun onDraw(canvas: Canvas) = with(canvas) {
		drawLottoBallBackground()
		drawLottoNumber()
		if (isBonus) {
			drawBonusText()
		}
	}

	private fun Canvas.drawLottoBallBackground() {
		drawCircle(centerX, centerY, radius, backgroundPaint)
	}

	private fun Canvas.drawLottoNumber() {
		val textHeight = lottoNumberTextPaint.descent() - lottoNumberTextPaint.ascent()
		val textOffset = (textHeight / 2) - lottoNumberTextPaint.descent()

		drawText(lottoNumber.toString(), centerX, centerY + textOffset, lottoNumberTextPaint)
	}

	private fun Canvas.drawBonusText() {
		val bonusTextY = height.toFloat() / 2 - radius

		drawText(bonusText, centerX, bonusTextY, bonusTextPaint)
	}

}