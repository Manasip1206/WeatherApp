package com.example.session18weatherapp
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.session18weatherapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Step 1 -> Generate Api Key From this Site -> https://openweathermap.org/
 * Step 2-> Add Retrofit Dependency
 * Step 3 -> Add internet permission
 * Step 4 -> Make Retrofit Builder Class- ApiBuilder class
 * Step 5 -> Make Data Class for storing response of api
 * Step 6 -> Make XML
 *
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // CLICK ON SEARCH BUTTON :
        binding.search.setOnClickListener {
            val city = binding.YourCity.text.toString()
            getWeatherData(city)
        }
    }

    private fun getWeatherData(city: String) {
        val call = ApiBuilder.retrofitBuilder.getCurrentWeather(city, Constants.API_KEY)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    setViews(response.body())
                } else {
                    Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }

    private fun setViews(response: WeatherResponse?) {
        binding.city.text = response?.name
        binding.country.text = response?.sys?.country
        binding.sunrises.text = response?.sys?.sunrise.toString()
        binding.sunsets.text = response?.sys?.sunset.toString()
        binding.maxTemp.text = response?.main?.temp_max.toString()
        binding.minTemp.text = response?.main?.temp_min.toString()
        binding.humidity.text = response?.main?.humidity.toString()
    }
}



