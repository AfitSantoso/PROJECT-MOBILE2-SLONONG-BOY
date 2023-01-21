package com.example.tokosembako.ui.theme.shared

import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CrebitsDatePicker(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    val date = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDate.now()
    } else {
        return
    }

    val year = date.year
    val monthValue = date.monthValue
    val dayOfMonth = date.dayOfMonth


    val datePickerDialog = remember {
        DatePickerDialog(
            context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                onValueChange(LocalDate.of(year, month, dayOfMonth).format(formatter))
                focusManager.clearFocus()
            }, year, monthValue, dayOfMonth
        ).apply {
            setOnDismissListener {
                focusManager.clearFocus()
            }
        }
    }


    OutlinedTextField(
        value = value.format(formatter),
        onValueChange = {
            onValueChange(LocalDate.of(year, monthValue, dayOfMonth).format(formatter))
        },
        label = { Text(text = "Date") },
        modifier = modifier.onFocusChanged {
            if (it.isFocused)
                datePickerDialog.show()
            else
                datePickerDialog.dismiss()
        },
        readOnly = true,
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = "Select a date",
                modifier = Modifier.clickable {
                    datePickerDialog.show()
                }
            )
        }
    )


}