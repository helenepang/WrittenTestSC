package com.example.writtentestsc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

/**
 * Created by xiaomin10 on 2023/4/28.
 */
class SecondFragment: Fragment(){

    val viewModel: NumberViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ResultPageView()
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun ResultPageView(modifier: Modifier = Modifier) {
        Column(modifier = modifier.padding(16.dp)) {
            Text(text = "Result List", textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth())
            ResultDataList(listData = viewModel.getValue())
        }
    }


    @Composable
    fun ResultDataList(listData: MutableList<Double>?) {
        LazyColumn {
            listData?.let {
                items(listData) { item ->
                    ItemView(item)
                }
            }
        }
    }

    @Composable
    fun ItemView(item: Double) {
        Text(text = String.format("%.2f", item),textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp)).padding(8.dp))
    }


}