package com.surivalcoding.composerecipeapp.presentation.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.MediumButton
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            model = R.drawable.splash_screen,
            contentDescription = "splash screen image",
            placeholder = painterResource(R.drawable.splash_screen)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(start = 50.dp, end = 50.dp, top = 104.dp, bottom = 95.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.recipe_app_logo),
                    contentDescription = "recipe app logo",
                )
                Text(
                    modifier = Modifier,
                    text = "100K+ Premium Recipe",
                    style = AppTextStyles.mediumTextBold.copy(
                        color = AppColors.white
                    )
                )
            }

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier,
                    text = "Get Cooking",
                    style = AppTextStyles.titleTextBold.copy(
                        color = AppColors.white
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.padding(top = 20.dp, bottom = 64.dp),
                    text = "Simple way to find Tasty Recipe",
                    style = AppTextStyles.normalTextRegular.copy(
                        color = AppColors.white
                    )
                )
                MediumButton(
                    modifier = Modifier,
                    text = "Start Cooking",
                    onClick = onClick
                )
            }
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}