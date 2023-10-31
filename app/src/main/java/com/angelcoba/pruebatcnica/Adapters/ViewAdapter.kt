package com.angelcoba.pruebatcnica.Adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.angelcoba.pruebatcnica.Views.Fragments.CreateEntryFragment
import com.angelcoba.pruebatcnica.Views.Fragments.EntrysFragment

class ViewAdapter (fragment: FragmentActivity, val size: Int) : FragmentStateAdapter(fragment) {
    companion object {
        private const val ARG_OBJ = "objeto"
    }

    override fun getItemCount(): Int{
        return size
    }

    override fun createFragment(position: Int): Fragment {
        val entradas = EntrysFragment()
        entradas.arguments = Bundle().apply {
            putInt(ARG_OBJ, position +1)
        }
        val crearEntrada = CreateEntryFragment()
        crearEntrada.arguments = Bundle().apply {
            putInt(ARG_OBJ, position +1)
        }
        return when (position) {
            0 -> {
                return entradas
            }
            else -> {
                return crearEntrada
            }
        }
    }
}