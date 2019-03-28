package com.example.kkboxdemo.model

/**
 * Client Credentials Flow
 */
data class TokenResponse(
    val access_token: String,
    val expires_in: Int,
    val token_type: String,
    val error: String


)

/**
 * Search, api response
 */
data class SearchResponse(
    val artists: Artists,
    val paging: Paging,
    val summary: Summary,
    val tracks: Tracks
)

data class Artists(
    val `data`: List<Data>,
    val paging: Paging,
    val summary: Summary
)

data class Data(
    val id: String,
    val images: List<Image>,
    val name: String,
    val url: String
)

data class Image(
    val height: Int,
    val url: String,
    val width: Int
)

data class Summary(
    val total: Int
)

data class Paging(
    val limit: Int,
    val next: Any,
    val offset: Int,
    val previous: Any
)

data class Tracks(
    val `data`: List<DataX>,
    val paging: Paging,
    val summary: Summary
)

data class DataX(
    val album: Album,
    val available_territories: List<String>,
    val duration: Int,
    val explicitness: Boolean,
    val id: String,
    val name: String,
    val track_number: Int,
    val url: String
)

data class Album(
    val artist: Artist,
    val available_territories: List<String>,
    val explicitness: Boolean,
    val id: String,
    val images: List<Image>,
    val name: String,
    val release_date: String,
    val url: String
)

data class Artist(
    val id: String,
    val images: List<Image>,
    val name: String,
    val url: String
)

/**
 * Charts
 */

data class ChartResponse(
    val `data`: List<ChartData>,
    val paging: ChartPaging,
    val summary: ChartSummary
)

data class ChartData(
    val description: String,
    val id: String,
    val images: List<ChartImage>,
    val owner: Owner,
    val title: String,
    val updated_at: String,
    val url: String
)

data class ChartImage(
    val height: Int,
    val url: String,
    val width: Int
)

data class Owner(
    val description: String,
    val id: String,
    val images: List<ChartImage>,
    val name: String,
    val url: String
)

data class ChartSummary(
    val total: Int
)

data class ChartPaging(
    val limit: Int,
    val next: Any,
    val offset: Int,
    val previous: Any
)


/**
 * Error
 */

data class ApiErrorModel(var status: Int, var message: String)


data class ErrorCode(
    val error: Error
)

data class Error(
    val code: Int,
    val message: String
)

