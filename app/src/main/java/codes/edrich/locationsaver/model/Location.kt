package codes.edrich.locationsaver.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Location(

    @PrimaryKey
    val id: Long,

    @Json(name = "identifier")
    var name: String,

    var description: String,

    @Json(name = "w3w")
    var w3w: String,
    var longitude: Double,
    var latitude: Double
)