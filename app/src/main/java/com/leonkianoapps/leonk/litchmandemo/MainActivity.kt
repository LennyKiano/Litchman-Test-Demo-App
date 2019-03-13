package com.leonkianoapps.leonk.litchmandemo

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.SwitchCompat
import android.view.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_ui.*
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setting up tool bar
        setSupportActionBar(app_toolBar)

        //adding navigation item listener to navigation view and Bottom Navigation View
        main_nav_view.setNavigationItemSelectedListener(this)
        bottom_nav.setOnNavigationItemSelectedListener(this)

        //setting on click listeners for the text view and card view

        events_textView.setOnClickListener { it -> openEventsActivity() }

        event_cardView.setOnClickListener { it -> openEventsActivity() }


        val currentTime: String = Calendar.getInstance().time.toString()

        currentTimeTextView2.text = currentTime



        app_toolBar.setNavigationOnClickListener {
            View.OnClickListener {

                if(drawer_layout.isDrawerOpen(Gravity.END)){
                    drawer_layout.closeDrawer(Gravity.END)
                }else{

                    drawer_layout.openDrawer(Gravity.END)
                }

            }
        }//end of setNav listener







    }

    private fun openEventsActivity() {

        val intent = Intent(this,EventsActivity::class.java)
        startActivity(intent)


    }






    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

//        menuItem.isCheckable = false

        val itemSelected = menuItem.itemId

        navigate(itemSelected)

        return true


    }

    private fun navigate(itemSelected: Int) {

        var intent: Intent? = null



        when (itemSelected){

            //navigation view items

            R.id.home_item_menu ->  { showSnack("Home was Tapped")
                drawer_layout.closeDrawer(Gravity.END)}

            R.id.inbox_item_menu -> { showSnack("Inbox was Tapped")
                drawer_layout.closeDrawer(Gravity.END) }

            R.id.payments_item_menu -> { showSnack("Payments was Tapped")
                drawer_layout.closeDrawer(Gravity.END) }

            R.id.dashboard_item_menu -> { showSnack("DashBoard  was Tapped")
                drawer_layout.closeDrawer(Gravity.END)}

            R.id.company_profile_item_menu -> { showSnack("Company Profile was Tapped")
                drawer_layout.closeDrawer(Gravity.END) }

            R.id.user_profile_item_menu -> { showSnack("User Profile Profile was Tapped")
                drawer_layout.closeDrawer(Gravity.END)}

            R.id.contact_us_item_menu -> { showSnack("Contact Us  was Tapped")
                drawer_layout.closeDrawer(Gravity.END)}

            R.id.about_chamber_item_menu -> { showSnack("About Chamber was Tapped")
                drawer_layout.closeDrawer(Gravity.END)}

            R.id.login_item_menu -> { showSnack("Login was Tapped")
                drawer_layout.closeDrawer(Gravity.END)}


            //Bottom Navigation Items

            R.id.home_bottom_nav_item -> { showSnack("Home Bottom Nav was Tapped")
                drawer_layout.closeDrawer(Gravity.END)}

            R.id.happiness_bottom_nav_item -> { showSnack("Happiness Bottom Nav was Tapped")
                drawer_layout.closeDrawer(Gravity.END)}

            R.id.inbox_bottom_nav_item -> { showSnack("Inbox Bottom Nav was Tapped")
                drawer_layout.closeDrawer(Gravity.END)}

            R.id.switch_item_menu -> {



            }



        }





    }


    private fun showSnack(message: String) {


        val snackBar : Snackbar = Snackbar.make(const_layout,message,Snackbar.LENGTH_LONG)
            .setAction(R.string.okay, View.OnClickListener {  })

        snackBar.show()




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_activity_main,menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId){

            R.id.ham_icon -> {

                if(drawer_layout.isDrawerOpen(Gravity.END)){

                    drawer_layout.closeDrawer(Gravity.END)} else { drawer_layout.openDrawer(Gravity.END)}
            }


            }



        return super.onOptionsItemSelected(item)
    }


}
