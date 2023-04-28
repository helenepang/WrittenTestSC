package com.example.writtentestsc

/**
 * Created by xiaomin10 on 2023/4/28.
 */

class NumberTools {

    companion object {
        fun formatNumberToAmount(number: String?): String {
            if (number.isNullOrBlank()) {
                return ""
            }
            return String.format("%.2f", number.toDouble());
        }

        fun formatSecondToTime(time: String?): String {
            if (time.isNullOrBlank()) {
                return ""
            }
            var seconds = time.toInt()
            val hours = seconds / 3600
            val minutes = (seconds % 3600) / 60
            val remainingSeconds = seconds % 60

            val output = StringBuilder()

            if (hours > 0) {
                output.append(hours).append("h")
            }

            if (minutes > 0 || hours > 0) {
                output.append(minutes).append("m")
            }

            if (remainingSeconds > 0 || (hours == 0 && minutes == 0)) {
                output.append(remainingSeconds).append("s")
            }

            return output.toString()
        }
    }

}

