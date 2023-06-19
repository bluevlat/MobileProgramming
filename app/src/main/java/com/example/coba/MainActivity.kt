package com.example.coba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    // member variable to save the score
    private var mScore1: Int = 0
    private var mScore2: Int = 0
    private var mScore3: Int = 0
    private var mScore4: Int = 0

    // member variable for 2 element TextView score
    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2: TextView
    private lateinit var mScoreText3: TextView
    private lateinit var mScoreText4: TextView

    // Tag that we use for the key in OnSavedInstanceState
    companion object {
        const val STATE_SCORE_1 = "Score Tim 1"
        const val STATE_SCORE_2 = "Score Tim 2"
        const val STATE_SCORE_3 = "Score Tim 3"
        const val STATE_SCORE_4 = "Score Tim 4"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find the TextViews based on ID
        mScoreText1 = findViewById(R.id.score_1)
        mScoreText2 = findViewById(R.id.score_2)
        mScoreText3 = findViewById(R.id.score_3)
        mScoreText4 = findViewById(R.id.score_4)

        // give back the score if there is savedInstanceState.
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1)
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2)
            mScore3 = savedInstanceState.getInt(STATE_SCORE_3)
            mScore4 = savedInstanceState.getInt(STATE_SCORE_4)

            // set the TextView score
            mScoreText1.text = mScore1.toString()
            mScoreText2.text = mScore2.toString()
            mScoreText3.text = mScore3.toString()
            mScoreText4.text = mScore4.toString()
        }
    }

    fun decreaseScore(view: View) {
        // get the IDs button.
        val viewID = view.id
        when (viewID) {
            // Team1:
            R.id.decreaseTeam1 -> {
                mScore1--
                mScoreText1.text = mScore1.toString()
            }
            // Team2:
            R.id.decreaseTeam2 -> {
                mScore2--
                mScoreText2.text = mScore2.toString()
            }
            // Team3:
            R.id.decreaseTeam3 -> {
                mScore3--
                mScoreText3.text = mScore3.toString()
            }
            // Team4:
            R.id.decreaseTeam4 -> {
                mScore4--
                mScoreText4.text = mScore4.toString()
            }
        }
    }

    fun increaseScore(view: View) {
        // Dapatkan ID tombol yang diklik.
        val viewID = view.id
        when (viewID) {
            // Team1:
            R.id.increaseTeam1 -> {
                mScore1++
                mScoreText1.text = mScore1.toString()
            }
            // Team2:
            R.id.increaseTeam2 -> {
                mScore2++
                mScoreText2.text = mScore2.toString()
            }
            // Team3:
            R.id.increaseTeam3 -> {
                mScore3++
                mScoreText3.text = mScore3.toString()
            }
            // Team4:
            R.id.increaseTeam4 -> {
                mScore4++
                mScoreText4.text = mScore4.toString()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        // change the menu's label based on the app's status.
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode)
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // check is the click's item right.
        if (item.itemId == R.id.night_mode) {
            val nightMode = AppCompatDelegate.getDefaultNightMode()
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // save score.
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        outState.putInt(STATE_SCORE_3, mScore3)
        outState.putInt(STATE_SCORE_4, mScore4)
        super.onSaveInstanceState(outState)
    }
}