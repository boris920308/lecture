package com.hoon.booksearch.ui.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hoon.booksearch.R
import com.hoon.booksearch.data.db.BookSearchDatabase
import com.hoon.booksearch.data.repository.BookSearchRepositoryImpl
import com.hoon.booksearch.databinding.ActivityMainBinding
import com.hoon.booksearch.ui.viewmodel.BookSearchViewModel
import com.hoon.booksearch.ui.viewmodel.BookSearchViewModelProviderFactory
import com.hoon.booksearch.util.Constants.DATASTORE_NAME

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var bookSearchViewModel: BookSearchViewModel
    private lateinit var navController: NavController
    // AppBar fragment 이름 표시로 변경
    private lateinit var appBarConfiguration: AppBarConfiguration

    // data store singleton 객체 생성
    private val Context.dataStore by preferencesDataStore(DATASTORE_NAME)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupJetpackNavigation()

        val database = BookSearchDatabase.getInstance(this)
        val bookSearchRepository = BookSearchRepositoryImpl(database, dataStore)
        val factory = BookSearchViewModelProviderFactory(bookSearchRepository, this)
        bookSearchViewModel = ViewModelProvider(this, factory)[BookSearchViewModel::class.java]

    }

    private fun setupJetpackNavigation() {
        val host = supportFragmentManager
            .findFragmentById(R.id.booksearch_nav_host_fragment) as NavHostFragment? ?: return
        navController = host.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        // AppBar fragment 이름 표시로 변경
        appBarConfiguration = AppBarConfiguration(
            // 모든 fragment 를 top level destination 로 지정
            setOf(
                R.id.fragment_search, R.id.fragment_favorite, R.id.fragment_setting
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        // AppBar fragment 이름 표시로 변경
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}