package com.example.oneabes

class DataSource {
    fun loadLectures(): List<DailyLecture> {
        return listOf<DailyLecture>(
            DailyLecture(R.string.Lecture1),
            DailyLecture(R.string.Lecture2),
            DailyLecture(R.string.Lecture3),
            DailyLecture(R.string.Lecture4),
            DailyLecture(R.string.Lecture5),
            DailyLecture(R.string.Lecture6),
            DailyLecture(R.string.Lecture7),
            DailyLecture(R.string.Lecture8)
        )
    }
}