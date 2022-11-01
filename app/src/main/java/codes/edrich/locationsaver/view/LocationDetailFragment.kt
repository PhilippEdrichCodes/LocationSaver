package codes.edrich.locationsaver.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import codes.edrich.locationsaver.databinding.FragmentLocationDetailBinding
import codes.edrich.locationsaver.viewmodel.MainViewModel

class LocationDetailFragment: Fragment() {
    private lateinit var locationDetailBinding: FragmentLocationDetailBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        locationDetailBinding = FragmentLocationDetailBinding.inflate(inflater)
        return locationDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}