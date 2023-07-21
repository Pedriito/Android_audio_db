package com.pedriito.audiodb.ui.home
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pedriito.audiodb.api_connect.apiInterface
import com.pedriito.audiodb.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerViewAlbums: RecyclerView
    private lateinit var recyclerViewTitres: RecyclerView

    private val albumAdapter = AlbumAdapter(ArrayList())
    private val titreAdapter = TitreAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        recyclerViewAlbums = binding.recyclerViewAlbums
        recyclerViewTitres = binding.recyclerViewTitres

        recyclerViewAlbums.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewTitres.layoutManager = LinearLayoutManager(requireContext())

        recyclerViewAlbums.adapter = albumAdapter
        recyclerViewTitres.adapter = titreAdapter

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (it.position) {
                        0 -> {
                            recyclerViewAlbums.visibility = View.VISIBLE
                            recyclerViewTitres.visibility = View.GONE
                        }
                        1 -> {
                            recyclerViewAlbums.visibility = View.GONE
                            recyclerViewTitres.visibility = View.VISIBLE
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        fetchTrendingData()

        return root
    }

    private fun fetchTrendingData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(
                CoroutineCallAdapterFactory()
            )
            .build()

        val apiInterface = retrofit.create(apiInterface::class.java)

        GlobalScope.launch(Dispatchers.Main) {

            try {
                val trendingResponse = apiInterface.getTendingSigles().await()
                val trendingSingles = trendingResponse[1]

                Log.d("API", "Trending singles response: $trendingSingles")

                albumAdapter.updateData(trendingSingles)
            } catch (e: Exception) {
                Log.e("API", "Error fetching data: ${e.message}")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}