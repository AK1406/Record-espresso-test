package com.anju.kumari.gfg


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val imageView = onView(
            allOf(
                withId(R.id.imageView),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withId(R.id.name), withText("GeeksForGeeks"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("GeeksForGeeks")))

        val textView2 = onView(
            allOf(
                withText("Billions of Users, Millions of Articles Published, Thousands Got Hired by Top Companies and the numbers are still growing."),
                withContentDescription("About Achievement"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Billions of Users, Millions of Articles Published, Thousands Got Hired by Top Companies and the numbers are still growing.")))
    }
}
