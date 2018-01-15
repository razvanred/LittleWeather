package it.brunierarosu.littleweather.task

import android.os.AsyncTask
import android.util.Log
import it.brunierarosu.littleweather.BuildConfig
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*


/**
 * Created by razva on 14/01/2018.
 */
class GETTask : AsyncTask<String, Void, String>() {

    companion object {
        private val TAG = GETTask::class.java.name
        private val URL_MAIN = "http://api.openweathermap.org/data/2.5/weather?units=metric&lang=it&appid=${BuildConfig.OpenWeatherMapAPI}&mode=xml"
    }

    override fun doInBackground(vararg p0: String?): String? {

        val build = StringBuilder()
        build.append(URL_MAIN)
        build.append(p0[0])

        try {
            val url = URL(build.toString().trim { it <= ' ' }.replace(" +".toRegex(), " ").replace(" ".toRegex(), "%20"))

            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connect()

            if (connection.responseCode != 200)
            //città non trovata
                throw IOException()
            val s=StringBuilder()
            val scanner = Scanner(connection.inputStream)
            while (scanner.hasNext()) {
                s.append(scanner.nextLine()+"\n")
            }

            connection.inputStream.close()
            scanner.close()

            return s.toString()
        } catch (urlExc: MalformedURLException) {
            Log.e(TAG, "Malformed URL")
            return null
        } catch (ioExc: IOException) {
            Log.e(TAG, "IO not valid")
            return null
        }
    }


}