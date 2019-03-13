package com.leonkianoapps.leonk.litchmandemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_events.*

class EventsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)


        //ToolBar
        setSupportActionBar(events_toolBar)
        supportActionBar!!.title = "Events"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_search_white_24dp)





        //Recycler View

        val linearLayoutManger = LinearLayoutManager(this)
        events_recyclerView.layoutManager = linearLayoutManger

        val adapter = RecyclerViewCustomAdapter(initializeEventData(),applicationContext,main_event_layout)

        events_recyclerView.adapter = adapter






    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId){

            android.R.id.home -> {

                showSnack("Searching...")

            }


        }


        return super.onOptionsItemSelected(item)
    }


    private fun showSnack(message: String) {

        val snackBar: Snackbar = Snackbar.make(main_event_layout,message, Snackbar.LENGTH_LONG)
            .setAction("Okay", View.OnClickListener {  })

        snackBar.show()
    }

    private fun initializeEventData(): ArrayList<Events> {

         val eventsNames =
            arrayOf("Event1", "Event2", "Event3", "Event4", "Event5", "Event6", "Event7", "Event8", "Event9", "Event10", "Event11")

         val descOfEvents = arrayOf(

            "Description1", "Description2", "Description3", "Description4", "Description5", "Description6", "Description7", "Description8",
            "Description9", "Description10", "Description11" )

        val eventImages = arrayOf(R.drawable.event8,R.drawable.event8,R.drawable.event8,R.drawable.event8,R.drawable.event8,
            R.drawable.event8,R.drawable.event8,R.drawable.event8,R.drawable.event8,R.drawable.event8 )

        val eventsArrayList= ArrayList<Events>()

        for (element in 0..9){

            val events  = Events(eventImages[element],eventsNames[element],descOfEvents[element])

            eventsArrayList.add(events)



        }

        return eventsArrayList
    }
}
