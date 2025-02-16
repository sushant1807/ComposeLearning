package com.saika.composelearning.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saika.composelearning.ui.theme.dimens

@Composable
fun CustomSocialMediaSection(
    modifier: Modifier,
    @DrawableRes icon: Int,
    text: String,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .border(
                border = ButtonDefaults.outlinedButtonBorder,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(4.dp))
            .clickable { onClick }
            .height(MaterialTheme.dimens.buttonHeight),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon), contentDescription = null,
            modifier = Modifier.size(16.dp)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF94A3B8))
        )
    }
}