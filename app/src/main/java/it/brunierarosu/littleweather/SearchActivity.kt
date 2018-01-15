package it.brunierarosu.littleweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setSupportActionBar(toolbar)

        tv1.text = intent.getStringExtra("Sancio")
        tv2.text = intent.getStringExtra("Panza")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            android.R.id.home-> run {
                onBackPressed()
                Log.i("Gatto", "ceppo")
            }
            else-> Log.i("Uncontrolled button","yes")
        }

        return super.onOptionsItemSelected(item)
    }


}
