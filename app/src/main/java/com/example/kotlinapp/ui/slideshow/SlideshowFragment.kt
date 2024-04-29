package com.example.kotlinapp.ui.slideshow

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinapp.databinding.FragmentSlideshowBinding
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.kotlinapp.R

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var videoView: VideoView? = null
    var mediaController: MediaController? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pagekotlinViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        pagekotlinViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it

            videoView = root.findViewById<View>(R.id.videoView) as VideoView?

            if (mediaController == null){
                mediaController = MediaController(requireContext())
                mediaController!!.setAnchorView(this.videoView)
            }

            videoView!!.setMediaController(mediaController)

            videoView!!.setVideoURI(Uri.parse("android.resource://"+requireActivity().packageName+"/"+R.raw.videov))

            videoView!!.requestFocus()
            videoView!!.resume()
            videoView!!.start()

            videoView!!.setOnCompletionListener {
                Toast.makeText(requireActivity().applicationContext, "Video End", Toast.LENGTH_LONG).show()
            }

            videoView!!.setOnErrorListener { mediaPlayer, i, i2 ->
                Toast.makeText(requireActivity().applicationContext, "Error Occured", Toast.LENGTH_LONG).show()
                false
            }

        }
        return root
    }

       override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}