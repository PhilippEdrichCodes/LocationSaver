package codes.edrich.locationsaver.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import codes.edrich.locationsaver.R
import codes.edrich.locationsaver.databinding.FragmentMainBinding
import codes.edrich.locationsaver.model.Location
import codes.edrich.locationsaver.view.adapter.LocationAdapter
import codes.edrich.locationsaver.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private lateinit var mainFragmentBinding: FragmentMainBinding

    private val viewModel: MainViewModel by activityViewModels()

    // private lateinit var userMail: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentBinding = FragmentMainBinding.inflate(inflater)
        return mainFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = mainFragmentBinding.mainLocationRecycler
        recycler.adapter = LocationAdapter(listOf<Location>())//viewModel.locations)

        recycler.setHasFixedSize(true)

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it == null) {
                    findNavController().navigate(R.id.loginFragment)
                }
            }
        )

        mainFragmentBinding.mainLogoutFab.setOnClickListener {
            viewModel.logout()
        }
    }

}