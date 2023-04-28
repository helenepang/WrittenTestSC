package com.example.writtentestsc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

/**
 * Created by xiaomin10 on 2023/4/28.
 */
class FirstFragment : Fragment() {

    private val viewModel: NumberViewModel by activityViewModels()
    private var amount: String = ""
    private var time: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                InputPageView()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun InputPageView(modifier: Modifier = Modifier) {
        Column(modifier = modifier.padding(16.dp)) {

            AmountEditText()

            TimeEditText()

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Button(onClick = {
                    viewModel.setValue(amount, time)
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                }, modifier = Modifier
                        .padding(16.dp)) {
                    Text("submit")
                }
            }
        }

    }

    @Composable
    fun AmountEditText() {
        var textState by remember { mutableStateOf(TextFieldValue()) }
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Amount: " + NumberTools.formatNumberToAmount(textState.text), modifier = Modifier.padding(all = 8.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textState,
                onValueChange = { newValue ->
                    //check the number
                    val text = newValue.text
                    if (text.matches(Regex("[0-9]*\\.?[0-9]*"))) {
                        textState = newValue
                        amount = textState.text
                    }
                },
                label = { Text("Please input amount") }
            )
        }
    }

    @Composable
    fun TimeEditText() {
        var textState by remember { mutableStateOf(TextFieldValue()) }
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Time: " +  NumberTools.formatSecondToTime(textState.text), modifier = Modifier.padding(all = 8.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textState,
                onValueChange = { newValue ->
                    val text = newValue.text
                    if (text.matches(Regex("[0-9]*?[0-9]*"))) {
                        textState = newValue
                        time = textState.text
                    }
                },
                label = { Text("Please input time") }
            )
        }
    }

}