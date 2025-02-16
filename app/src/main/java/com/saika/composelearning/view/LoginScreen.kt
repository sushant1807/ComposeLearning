package com.saika.composelearning.view

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.saika.composelearning.R
import com.saika.composelearning.ui.theme.Black
import com.saika.composelearning.ui.theme.BlueGray
import com.saika.composelearning.ui.theme.Roboto
import com.saika.composelearning.ui.theme.ScreenOrientation
import com.saika.composelearning.ui.theme.dimens

@Composable
fun LoginScreenView() {
    Surface {

//        Column(modifier = Modifier.fillMaxSize()) {
//            TopSection()
//
//            Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium2))
//
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(horizontal = 30.dp)
//            ) {
//                LoginSection()
//
//                Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))
//
//                SocialMediaSection()
//
//                BottomSection()
//            }
//        }

        if (ScreenOrientation == Configuration.ORIENTATION_PORTRAIT){
            PortraitLoginScreen()
        }else{
            PortraitLoginScreen()
        }
    }
}

@Composable
private fun PortraitLoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        TopSection()
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium2))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MaterialTheme.dimens.medium1)
        ) {
            LoginSection()
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))
            SocialMediaSection()
        }
        Spacer(modifier = Modifier.weight(0.8f))
        BottomSection()
        Spacer(modifier = Modifier.weight(0.3f))
    }
}

@Composable
private fun BottomSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    Box(
        modifier = Modifier
            .fillMaxHeight(fraction = 0.8f)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter

    ) {

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF94A3B8),
                        fontSize = MaterialTheme.typography.labelMedium.fontSize,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append("Don't have account?")
                }
                withStyle(
                    style = SpanStyle(
                        color = uiColor,
                        fontSize = MaterialTheme.typography.labelMedium.fontSize,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(" ")
                    append("Create now")
                }
            }
        )
    }
}

@Composable
private fun SocialMediaSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF94A3B8))
        )
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))
        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            CustomSocialMediaSection(
                modifier = Modifier.weight(1f),
                icon = R.drawable.google,
                text = "Google"
            ) {

            }
            Spacer(modifier = Modifier.width(20.dp))
            CustomSocialMediaSection(
                modifier = Modifier.weight(1f),
                icon = R.drawable.facebook,
                text = "Facebook"
            ) {

            }
        }
    }
}

@Composable
private fun LoginSection() {
    CustomLoginTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(R.string.lbl_email),
        trailing = ""
    )
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small2))
    CustomLoginTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(R.string.lbl_password),
        trailing = stringResource(R.string.lbl_forgot)
    )
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp)
    ) {

        Text(
            text = stringResource(id = R.string.lbl_login),
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    Box(contentAlignment = Alignment.TopStart) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.5f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.dimens.large),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(MaterialTheme.dimens.logoSize),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(R.string.lbl_app_logo),
                tint = uiColor
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )
                Text(
                    text = stringResource(id = R.string.lbl_by_android),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor,
                    //textAlign = Alignment.BottomEnd
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter),
            text = stringResource(id = R.string.lbl_login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )

    }
}