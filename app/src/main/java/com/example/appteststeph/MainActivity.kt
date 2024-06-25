package com.example.appteststeph

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.edgarchavezdev.CodeChallengeAndroidEKT.home.module.fragment.home.adapter.ProductsAdapter
import com.example.appteststeph.databinding.ActivityMainBinding
import com.example.appteststeph.home.framework.presentation.screen.state.HomeUiState
import com.example.appteststeph.home.framework.presentation.view_model.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val viewModel : HomeViewModel by lazy {
        getViewModel ()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        viewModel.state.observe(this, resultData())


    }

    private fun resultData(): (HomeUiState) -> Unit = { state ->
        val data = state as HomeUiState.Data
        val adapterData =  ProductsAdapter(data.brands)
        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            adapter = adapterData
        }

    }
}