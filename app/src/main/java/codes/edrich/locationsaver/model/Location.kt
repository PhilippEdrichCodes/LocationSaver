package codes.edrich.locationsaver.model

data class Location(
    val id: Long,
    var identifier: String,
    var description: String,
    var w3w: String,
    var lng: Double,
    var lat: Double
)