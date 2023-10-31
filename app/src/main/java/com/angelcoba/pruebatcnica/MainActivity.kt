package com.angelcoba.pruebatcnica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.angelcoba.pruebatcnica.Adapters.ViewAdapter
import com.angelcoba.pruebatcnica.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: ViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun initFragmentTabs(){
        var tabLayoutTalleres: TabLayoutMediator
        adapter = ViewAdapter(this,2)
        binding.containerMain.adapter = adapter
        tabLayoutTalleres = TabLayoutMediator(
            binding.tabLayoutMain,
            binding.containerMain,
                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                    when (position) {
                        0 -> {
                            tab.text = "Entradas"
                            tab.icon = getDrawable(R.drawable.newstabicon)
                            binding.containerMain.isNestedScrollingEnabled = true
                        }
                        1 -> {
                            tab.text = "Alta de entradas"
                            tab.icon = getDrawable(R.drawable.newentryicon)
                        }
                    }
                })
        tabLayoutTalleres.attach()
        binding.containerMain.setUserInputEnabled(false);
    }
}