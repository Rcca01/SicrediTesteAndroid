package com.example.sicrediandroidtest

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.sicrediandroidtest.model.Event
import com.example.sicrediandroidtest.utils.Utils
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso

class BottomDialogDetailsEvent(
    detailsEvent: Event,
    private val onSignUpEvent: (idEvent: String, refButtonSignUp: Button) -> Unit
): BottomSheetDialogFragment() {

    private lateinit var ivImageDetailsEvent: ImageView
    private lateinit var tvTitleDetailsEvent: TextView
    private lateinit var tvDescriptionDetailsEvent: TextView
    private lateinit var btnDetailsEventClose: ImageButton
    private lateinit var tvPriceDetailsEvent: TextView
    private lateinit var btnSharedEvent: Button
    private lateinit var btnSingUp: Button
    private lateinit var tvDateDetailsEvent: TextView
    private val details = detailsEvent

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val view = LayoutInflater.from(requireContext())
            .inflate(R.layout.layout_dialog, null)

        ivImageDetailsEvent = view.findViewById(R.id.ivImageDetailsEvent)
        tvTitleDetailsEvent = view.findViewById(R.id.tvTitleDetailsEvent)
        tvDescriptionDetailsEvent = view.findViewById(R.id.tvDescriptionDetailsEvent)
        btnDetailsEventClose = view.findViewById(R.id.btnDetailsEventClose)
        tvPriceDetailsEvent = view.findViewById(R.id.tvPriceDetailsEvent)
        btnSharedEvent = view.findViewById(R.id.btnSharedEvent)
        btnSingUp = view.findViewById(R.id.btnSingUp)
        tvDateDetailsEvent = view.findViewById(R.id.tvDateDetailsEvent)

        Picasso.with(context)
            .load(details.image.replace("http://", "https://"))
            .fit()
            .centerCrop()
            .into(ivImageDetailsEvent)
        tvTitleDetailsEvent.text = details.title
        tvDescriptionDetailsEvent.text = details.description
        tvPriceDetailsEvent.text = Utils().toMoneyPtBr(details.price)
        tvDateDetailsEvent.text = Utils().formatDate(details.date)


        dialog.setCanceledOnTouchOutside(false)

        btnDetailsEventClose.setOnClickListener {
            dismiss()
        }

        btnSharedEvent.setOnClickListener {
            shareLinkEvent(details.title)
        }

        btnSingUp.setOnClickListener {
            onSignUpEvent(details.id, btnSingUp)
        }

        dialog.setContentView(view)
    }


    private fun shareLinkEvent(titleEvent: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, titleEvent)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}