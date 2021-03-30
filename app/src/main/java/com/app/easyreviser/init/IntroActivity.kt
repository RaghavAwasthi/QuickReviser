package com.app.easyreviser.init

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.app.easyreviser.repository.AppPreference
import com.app.easyreviser.repository.Constants
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType

class IntroActivity : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addSlide(
            AppIntroFragment.newInstance(
                title = "Welcome to Easy Revisor", titleColor = Color.WHITE,
                description = "App Let's you revise stuff periodically",
                backgroundColor = Color.argb(8, 240, 220, 220),
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                title = "Create Flash Cards",
                titleColor = Color.BLACK,
                descriptionColor = Color.BLACK,
                description = "Helps in Quick Revision",
                backgroundColor = Color.WHITE,
            )
        )

        addSlide(
            AppIntroFragment.newInstance(
                title = "Wooaah hoo!!",
                titleColor = Color.WHITE,
                descriptionColor = Color.WHITE,
                description = "Let those cards remind periodically",
                backgroundColor = Color.YELLOW,
            )
        )

        setProgressIndicator()
        isVibrate = true
        vibrateDuration = 50L
        isWizardMode = true
        isColorTransitionsEnabled = true
        setTransformer(
            AppIntroPageTransformerType.Parallax(
                titleParallaxFactor = 1.0,
                imageParallaxFactor = -1.0,
                descriptionParallaxFactor = 2.0
            )
        )
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