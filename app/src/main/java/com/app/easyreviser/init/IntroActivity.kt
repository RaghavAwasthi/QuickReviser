package com.app.easyreviser.init

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.app.easyreviser.R
import com.app.easyreviser.repository.AppPreference
import com.app.easyreviser.repository.Constants
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment

class IntroActivity : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isVibrate = true
        vibrateDuration = 50L
        isWizardMode = true
        isColorTransitionsEnabled = true
        addSlide(
                AppIntroFragment.newInstance(
                        title = "Welcome to Easy Revisor", titleColor = Color.WHITE,
                        description = "App Let's you revise stuff periodically",
                        backgroundColor = Color.parseColor("#2196f3"),
                        imageDrawable = R.drawable.intro_1
                )
        )
        addSlide(
                AppIntroFragment.newInstance(
                        title = "Create Flash Cards",
                        titleColor = Color.WHITE,
                        descriptionColor = Color.WHITE,
                        description = "Helps in Quick Revision",
                        backgroundColor = Color.parseColor("#009688"),
                        imageDrawable = R.drawable.ic_intro_2

                )
        )

        addSlide(
                AppIntroFragment.newInstance(
                        title = "Wooaah hoo!!",
                        titleColor = Color.WHITE,
                        descriptionColor = Color.WHITE,
                        description = "Let those cards remind periodically",
                        backgroundColor = Color.parseColor("#43a047"),
                        imageDrawable = R.drawable.intro_3
                )
        )

        setProgressIndicator()


    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        AppPreference.getInstance(applicationContext).putBoolean(Constants.FIRSTLAUNCH, false)
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        AppPreference.getInstance(applicationContext).putBoolean(Constants.FIRSTLAUNCH, false)

        finish()
    }
}