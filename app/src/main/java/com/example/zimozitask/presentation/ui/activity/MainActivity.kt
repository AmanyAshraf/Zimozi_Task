package com.example.zimozitask.presentation.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.zimozitask.data.model.Data
import com.example.zimozitask.databinding.ActivityMainBinding
import com.example.zimozitask.presentation.viewmodel.MainViewModel
import com.example.zimozitask.dependency.PreferenceManager
import com.example.zimozitask.presentation.ui.adapter.RvAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: RvAdapter
    val items = mutableListOf<Data>()

    @Inject
    lateinit var preferencesManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RvAdapter(items.toList())
        binding.rv.setHasFixedSize(true)
        binding.rv.adapter=adapter

        var sharedPreferences = getSharedPreferences(PreferenceManager.KEY, Context.MODE_PRIVATE)
        viewModel.response.observe(this) {
            preferencesManager.saveData("data",it.data)
            adapter.data=it.data
            adapter.notifyDataSetChanged()

        }
        if (sharedPreferences.getString("data","")!!.isNotEmpty() ){
          //  Toast.makeText(this, "data", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch {
                preferencesManager.getData("data").collect {
                    items.add(it)
                }
            }
            adapter.data=items
            adapter.notifyDataSetChanged()
        }

    }
}