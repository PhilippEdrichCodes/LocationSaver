package codes.edrich.locationsaver.model

data class Location(
    val id: Long,
    val name: String,
    val w3w: String,
    val coords: Coordinates
)