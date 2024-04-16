package com.example.firstlanaapplication.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstlanaapplication.R
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    val scope = rememberCoroutineScope()
    val tabs = listOf(TabItem.Registration, TabItem.Login)
    val pagerState = rememberPagerState(pageCount = { tabs.size })

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Icon(
            painter = painterResource(id = R.drawable.borow_launcher_foreground),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        TabRow (
            containerColor = Color.Transparent,
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, tab ->
                val isSelected = pagerState.currentPage == index
                Tab(selected = isSelected,
                    text = {
                           Text(text = tab.title, fontSize = 24.sp)
                    },
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(tab.ordinal)
                        }
                    },
                )
            }
        }
        HorizontalPager(state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.Bottom
        ) {
            page ->
            Box(
                modifier = Modifier.fillMaxSize().padding(20.dp),
                contentAlignment = Alignment.Center,
            ) {
                tabs[page].content.invoke()
            }
        }
    }
}

enum class TabItem(var title: String, var content: @Composable () -> Unit) {
    @ExperimentalMaterial3Api
    Registration("Sign Up", { SignUpScreen() } ),
    @ExperimentalMaterial3Api
    Login("Sign In", { SignInScreen() } )
}