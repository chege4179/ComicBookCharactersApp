package com.peterchege.dccomicsapp.models

data class Biography(
    val aliases: List<String>,
    val alignment: String,
    val alterEgos: String,
    val firstAppearance: String,
    val fullName: String,
    val placeOfBirth: String,
    val publisher: String
)