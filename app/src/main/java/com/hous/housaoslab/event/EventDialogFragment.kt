package com.hous.housaoslab.event

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.hous.housaoslab.databinding.FragmentDialogEventBinding

class EventDialogFragment : DialogFragment() {
    private var _binding: FragmentDialogEventBinding? = null
    private val binding get() = _binding ?: error("null값 들어감")
    internal lateinit var customFragmentListener: MyCustomFragmentListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "MyCustomFragment - onCreateView() called")
        _binding = FragmentDialogEventBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "MyCustomFragment - onViewCreated() called")
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
            Log.e(TAG, "onAttach: $context must implement MyCustomFragmentListener")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initDialog() {
        Log.d(TAG, "MyCustomFragment - initDialog() called")
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

    companion object {
        private const val TAG = "로그"
    }

    interface MyCustomFragmentListener {
        fun onClickCloseIcon(dialog: DialogFragment)
        fun onClickSaveButton(dialog: DialogFragment)
        fun onClickDeleteButton(dialog: DialogFragment)
    }
}
