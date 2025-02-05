package tech.kicky.hms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import tech.kicky.hms.helper.TextAdapter
import tech.kicky.hms.scan.databinding.FragmentHomeBinding

/**
 * Home Fragment
 * author: yidong
 * 2021-07-10
 */
class HomeFragment : Fragment() {

    private val mBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val menu = arrayOf(
        "ScanKit" to HomeFragmentDirections.actionHomeFragmentToScanKitFragment(),
        "CameraKit" to HomeFragmentDirections.actionHomeFragmentToCameraKitFragment(),
        "Color Filter" to HomeFragmentDirections.actionHomeFragmentToColorFilterFragment()
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TextAdapter {
            doRouter(menu[it].second)
        }
        adapter.setData(menu.map {
            it.first
        })
        mBinding.menu.apply {
            setAdapter(adapter)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun doRouter(second: NavDirections) {
        findNavController().navigate(second)
    }

}