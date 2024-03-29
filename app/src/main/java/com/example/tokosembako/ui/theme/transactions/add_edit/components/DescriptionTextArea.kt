package com.example.tokosembako.ui.theme.transactions.add_edit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tokosembako.ui.theme.transactions.add_edit.AddEditTransactionViewModel
import com.example.tokosembako.ui.theme.transactions.add_edit.state.AddEditTransactionEvent
import com.example.tokosembako.ui.theme.transactions.add_edit.state.TextFieldState

@Composable
fun DescriptionTextArea(
    descState: TextFieldState,
    viewModel: AddEditTransactionViewModel,
) {
    val descTextModifier = Modifier
        .fillMaxWidth()
        .height(120.dp)

    OutlinedTextField(
        value = descState.text,
        onValueChange = {
            viewModel.onEvent(AddEditTransactionEvent.EnteredDescription(it))
        },
        label = { Text(text = "Deskripsi Transaksi") },
        modifier = descTextModifier,
        maxLines = 5,
    )
}