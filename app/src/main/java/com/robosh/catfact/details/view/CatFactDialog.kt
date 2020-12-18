package com.robosh.catfact.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import com.bumptech.glide.Glide
import com.robosh.catfact.R
import com.robosh.catfact.model.CatFact

class CatFactDialog : AppCompatDialogFragment() {

    companion object {
        const val TAG_DIALOG = "SimpleDialog"

        private const val KEY_CAT_FACT = "KEY_CAT_FACT"

        fun newInstance(catFact: CatFact): CatFactDialog {
            val args = Bundle()
            args.putParcelable(KEY_CAT_FACT, catFact)
            val fragment = CatFactDialog()
            fragment.arguments = args
            return fragment
        }
    }

    private var catFact: CatFact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        catFact = arguments?.getParcelable(KEY_CAT_FACT)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_detailed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }

    private fun setupView(view: View) {
        val textView = view.findViewById<TextView>(R.id.dialogFactDescriptionTextView)
        val imageView = view.findViewById<ImageView>(R.id.dialogFactImageView)
        if (catFact?.imageUrl.isNullOrEmpty().not()) {
            Glide.with(view).load(catFact?.imageUrl).into(imageView)
        }
        textView.text = catFact?.description
    }
}