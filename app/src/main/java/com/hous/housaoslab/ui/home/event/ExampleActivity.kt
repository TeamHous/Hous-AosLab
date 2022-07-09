package com.hous.housaoslab.ui.home.event

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.hous.housaoslab.databinding.ActivityExampleBinding
import com.hous.housaoslab.util.showToast

class ExampleActivity : AppCompatActivity(), EventDialogFragment.MyCustomFragmentListener {

    private lateinit var binding: ActivityExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleBinding.inflate(layoutInflater)
        onClickDialogButton()
        setContentView(binding.root)
    }

    private fun onClickDialogButton() {
        binding.btnDialog.setOnClickListener {
            val dialog = EventDialogFragment()
            dialog.show(supportFragmentManager, EVENT_DIALOG_TAG)
        }
    }

    override fun onClickCloseIcon(dialog: DialogFragment) {
        dialog.dismiss()
    }

    override fun onClickSaveButton(dialog: DialogFragment) {
        showToast("저장버튼을 눌렀습니다.")
    }

    override fun onClickDeleteButton(dialog: DialogFragment) {
        showToast("삭제 버튼을 눌렀습니다.")
    }

    companion object {
        private const val TAG = "로그"
        private const val EVENT_DIALOG_TAG = "MyCustomFragment"
    }
}
