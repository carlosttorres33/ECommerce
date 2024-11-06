package com.carlostorres.ecommerce.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.carlostorres.ecommerce.ui.navigation.graph.RootNavGraph
import com.carlostorres.ecommerce.ui.theme.ECommerceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECommerceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RootNavGraph()
                }
            }
        }
    }
}