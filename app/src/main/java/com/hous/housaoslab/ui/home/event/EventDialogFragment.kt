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
import com.hous.housaoslab.R
import com.hous.housaoslab.databinding.FragmentDialogEventBinding

class EventDialogFragment : DialogFragment() {
    private var _binding: FragmentDialogEventBinding? = null
    private val binding get() = _binding ?: error("null값 들어감")
    private lateinit var customFragmentListener: MyCustomFragmentListener
    private lateinit var currentCheckedIcon: EventIcon

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dialog_event, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDialog()
        onClickEvents()
        close()
        delete()
        save()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            customFragmentListener = context as MyCustomFragmentListener
        } catch (e: ClassCastException) {
            Log.e(TAG, "onAttach: $context must implement MyCustomFragmentListener")
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

    private fun onClickEvents() {
        initSelectedImage()

        binding.ivEventOne.setOnClickListener {
            if (binding.ivEventOne.isSelected) return@setOnClickListener
            changeSelectedState()
            binding.ivEventOne.isSelected = true
            currentCheckedIcon = EventIcon.FIRST
            binding.ivTitle.setImageResource(currentCheckedIcon.drawableRes)
        }
        binding.ivEventTwo.setOnClickListener {
            if (binding.ivEventTwo.isSelected) return@setOnClickListener
            changeSelectedState()
            binding.ivEventTwo.isSelected = true
            currentCheckedIcon = EventIcon.SECOND
            binding.ivTitle.setImageResource(currentCheckedIcon.drawableRes)
        }

        binding.ivEventThree.setOnClickListener {
            if (binding.ivEventThree.isSelected) return@setOnClickListener
            changeSelectedState()
            binding.ivEventThree.isSelected = true
            currentCheckedIcon = EventIcon.THIRD
            binding.ivTitle.setImageResource(currentCheckedIcon.drawableRes)
        }

        binding.ivEventFour.setOnClickListener {
            if (binding.ivEventFour.isSelected) return@setOnClickListener
            changeSelectedState()
            binding.ivEventFour.isSelected = true
            currentCheckedIcon = EventIcon.FOURTH
            binding.ivTitle.setImageResource(currentCheckedIcon.drawableRes)
        }
    }

    private fun initSelectedImage() {
        currentCheckedIcon = EventIcon.FIRST
        binding.ivEventOne.isSelected = true
        binding.ivTitle.setImageResource(currentCheckedIcon.drawableRes)
    }

    private fun changeSelectedState() {
        when (currentCheckedIcon) {
            EventIcon.FIRST -> binding.ivEventOne.isSelected = false
            EventIcon.SECOND -> binding.ivEventTwo.isSelected = false
            EventIcon.THIRD -> binding.ivEventThree.isSelected = false
            EventIcon.FOURTH -> binding.ivEventFour.isSelected = false
        }
    }

    companion object {
        private const val TAG = "로그"
    }

    interface MyCustomFragmentListener {
        fun onClickCloseIcon(dialog: DialogFragment)
        fun onClickSaveButton(dialog: DialogFragment)
        fun onClickDeleteButton(dialog: DialogFragment)
    }
}
