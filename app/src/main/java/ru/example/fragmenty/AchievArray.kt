package ru.example.fragmenty

class AchievArray {
    val AchArray = arrayListOf<Achievments>(
        Achievments("Стал самым молодым в истории обладателем титула «Мистер Вселенная»", "1967г."),
        Achievments("Стал самым молодым в истории обладателем титула «Мистер Олимпия»", "1970г."),
        Achievments("Стал первым, кому удалось вернуть титул «Мистер Олимпия»", "1980г."),
        Achievments("Стал самым финансово успешным культуристом в истории", "2020г.")
    )
    fun gelList():ArrayList<Achievments>{
        return AchArray
    }
}