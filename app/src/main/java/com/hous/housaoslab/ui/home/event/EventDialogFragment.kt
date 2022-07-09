package com.hous.housaoslab.ui.home.event

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.hous.housaoslab.R
import com.hous.housaoslab.databinding.FragmentDialogEventBinding

class EventDialogFragment : DialogFragment() {
    private var _binding: FragmentDialogEventBinding? = null
    private val binding get() = _binding ?: error("null값 들어감")
    private lateinit var customFragmentListener: MyCustomFragmentListener
    private val eventViewModel: EventViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dialog_event, container, false)
        binding.viewmodel = eventViewModel
        binding.lifecycleOwner = this@EventDialogFragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDialog()
        close()
        delete()
        save()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            customFragmentListener = context as MyCustomFragmentListener
        } catch (e: ClassCastException) {
            Log.e("error", "onAttach: $context must implement MyCustomFragmentListener")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initDialog() {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isCancelable = false
    }

    private fun close() {
        binding.ivClose.setOnClickListener {
            customFragmentListener.onClickCloseIcon(this)
        }
    }

    private fun delete() {
        binding.btnDelete.setOnClickListener {
            customFragmentListener.onClickDeleteButton(this)
        }
    }

    private fun save() {
        binding.btnSave.setOnClickListener {
            customFragmentListener.onClickSaveButton(this)
        }
    }

    interface MyCustomFragmentListener {
        fun onClickCloseIcon(dialog: DialogFragment)
        fun onClickSaveButton(dialog: DialogFragment)
        fun onClickDeleteButton(dialog: DialogFragment)
    }
}
