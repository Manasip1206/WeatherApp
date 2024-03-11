package com.example.session18weatherapp
class WeatherResponse (
    var main       : Main?              = Main(),
    var sys        : Sys?               = Sys(),
     var name       : String?            = null,
)
data class Main (
   var temp      : Double? = null,
    var feels_like : Double? = null,
    var temp_min   : Double? = null,
    var temp_max   : Double? = null,
    var pressure  : Int?    = null,
    var humidity  : Int?    = null
)
data class Sys (
    var type    : Int?    = null,
    var id      : Int?    = null,
    var country : String? = null,
    var sunrise : Int?    = null,
    var sunset  : Int?    = null
)
