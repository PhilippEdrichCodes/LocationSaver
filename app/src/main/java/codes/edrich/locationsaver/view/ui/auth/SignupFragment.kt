package codes.edrich.locationsaver.view.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import codes.edrich.locationsaver.R
import codes.edrich.locationsaver.databinding.FragmentSignupBinding
import codes.edrich.locationsaver.viewmodel.MainViewModel

class SignupFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var signupBinding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        signupBinding = FragmentSignupBinding.inflate(inflater)
        return signupBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signupBinding.signupCreateButton.setOnClickListener {
            this.signUp()
        }

        signupBinding.signupCancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    findNavController().navigate(R.id.mainFragment)
                }
            }
        )
    }

    private fun signUp() {
        val email = signupBinding.signupEmailInput.text.toString()
        val pass = signupBinding.signupPasswordInput.text.toString()
        val repeat = signupBinding.signupPassrepeatInput.text.toString()

        if (!email.isNullOrEmpty() && !pass.isNullOrEmpty() && pass == repeat) {
            viewModel.signUp(email, pass)
        }
    }
}