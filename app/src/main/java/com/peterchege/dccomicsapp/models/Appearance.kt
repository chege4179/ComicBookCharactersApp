package com.peterchege.dccomicsapp.models

data class Appearance(
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: List<String>,
    val race: String,
    val weight: List<String>
)