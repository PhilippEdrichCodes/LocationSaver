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
import codes.edrich.locationsaver.databinding.FragmentLoginBinding
import codes.edrich.locationsaver.viewmodel.MainViewModel

class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginBinding = FragmentLoginBinding.inflate(inflater)

        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBinding.loginLoginButton.setOnClickListener {
            val email = loginBinding.loginEmailInput.text.toString()
            val pass = loginBinding.loginPasswordInput.text.toString()

            if (!email.isNullOrEmpty() && !pass.isNullOrEmpty()) {
                viewModel.login(email, pass)
            }
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
}