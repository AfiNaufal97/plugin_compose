package com.plugin.movie_app.model

data class MovieObject(
	val original_language: String,
	val imdb_id: String,
	val video: Boolean,
	val title: String,
	val backdrop_path: String,
	val revenue: Int,
	val genres: List<GenresItem?>,
	val popularity: Double,
	val production_countries: List<ProductionCountriesItem?>,
	val id: Int,
	val voteCount: Int,
	val budget: Int,
	val overview: String,
	val original_title: String,
	val runtime: Int,
	val poster_path: String,
	val spoken_languages: List<SpokenLanguagesItem?>,
	val production_companies: List<ProductionCompaniesItem?>,
	val releaseDate: String,
	val voteAverage: Double,
	val belongs_to_collection: Any,
	val tagline: String,
	val adult: Boolean,
	val homepage: String,
	val status: String
)
