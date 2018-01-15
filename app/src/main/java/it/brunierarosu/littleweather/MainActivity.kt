package it.brunierarosu.littleweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import it.brunierarosu.littleweather.task.GETTask
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object{
        private val TAG=MainActivity::class.java.name
        private val secs:Long=15
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

    }

    fun login(view: View){
        /*Log.i("bottone",view.toString())
        Log.i(txtusr.text.toString(),txtpass.text.toString())*/
       /* val int=Intent(this,SearchActivity::class.java)
        int.putExtra("Sancio",getString(R.string.user))
        int.putExtra("Panza",getString(R.string.password))

        startActivity(int)*/

        val get= GETTask()

        get.execute("&q=${txtusr.text}")

        Log.i("RESULT",get.get(secs, TimeUnit.SECONDS))

    }
}
