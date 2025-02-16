package com.saika.composelearning.view

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.saika.composelearning.ui.theme.Black
import com.saika.composelearning.ui.theme.focussedTextFieldText
import com.saika.composelearning.ui.theme.textFieldContainer
import com.saika.composelearning.ui.theme.unFocussedTextFieldText

@Composable
fun CustomLoginTextField(
    modifier: Modifier,
    label: String,
    trailing: String
) {

    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    TextField(
        modifier = modifier,
        value = "",
        onValueChange = {},
        label = {
            Text(text = label, style = MaterialTheme.typography.labelMedium, color = uiColor)
        },
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unFocussedTextFieldText,
            focusedPlaceholderColor = MaterialTheme.colorScheme.focussedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
        ),
        trailingIcon = {
            TextButton(onClick = { /*TODO*/ }) {
                
                Text(
                    text = trailing,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uiColor
                    )
                
            }
        }
    )

}