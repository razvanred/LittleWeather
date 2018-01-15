package it.brunierarosu.littleweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import it.brunierarosu.littleweather.task.GETTask
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

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
        try {
            Log.i("RESULT", get.get(secs, TimeUnit.SECONDS))
        } catch (exc: InterruptedException) {
            //Contattare lo sviluppatore se l'errore persiste
            Log.i("RESULT","interrupted")
        } catch (exc: ExecutionException) {
            Log.i("RESULT","execution")
            Log.i("RESULT",exc.cause.toString())
        } catch (exc: TimeoutException) {
            Log.i("RESULT","timeout")
        } catch (exc: NullPointerException) {
            Log.i("RESULT","offline")
        } catch (exc: Exception){
            Log.i("RESULT","other")
        }

    }
}
