package com.example.frolf2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MasterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //podlaczenie button navigation view
        bottomNavigationView.setupWithNavController(fragment.findNavController())

        //!!viewmodel tworzymy zawsze w aktywnosci!!!
        //nastepnie podpinamy nasz viewModel:
        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(MasterViewModel::class.java)
    }
}