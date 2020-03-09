package miq0717.trendinggit.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import miq0717.trendinggit.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(
            this,
            findNavController(R.id.main_nav_fragment)
        )
    }

    override fun onSupportNavigateUp() = findNavController(R.id.main_nav_fragment).navigateUp()


}
