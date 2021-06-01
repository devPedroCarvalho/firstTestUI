package app.devpedrocarvalho.firsttestui

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun whenOpenMainActivity_shouldDisplayInitialInfo(){
        onView(withId(R.id.addNameButton)).check(matches(isDisplayed()))
        onView(withId(R.id.clearButton)).check(matches(isDisplayed()))
        onView(withId(R.id.nameTextView)).check(matches(withText("Nome:")))
        onView(withId(R.id.writeYourNameEditText)).check(matches(withHint("Digite seu nome")))
        onView(withId(R.id.resultTextView)).check(matches(withText("")))
    }


    @Test
    fun whenClickOnButtonAdd_shouldDisplayErrorTextView(){
        //when
        onView(withId(R.id.addNameButton)).perform(click())

       //then
        onView(withId(R.id.errorNameTextView)).check(matches(isDisplayed()))
    }

    @Test
    fun whenWriteNameAndClickOnButtonAdd_shouldDisplayResultOnTextView(){
        //when
        onView(withId(R.id.writeYourNameEditText)).perform(typeText("Pedro"))
        onView(withId(R.id.addNameButton)).perform(click())

        //then
        onView(withId(R.id.resultTextView)).check(matches(withText("Pedro")))
    }


    @Test
    fun givenNameWasWriteAndButtonAddWasClick_whenClickOnButtonClear_shouldClearTexts(){
        //given
        onView(withId(R.id.writeYourNameEditText)).perform(typeText("Pedro"))
        onView(withId(R.id.addNameButton)).perform(click())

        closeSoftKeyboard()
        Thread.sleep(1500)

        //when
        onView(withId(R.id.clearButton)).perform(click())

        //then
        onView(withId(R.id.resultTextView)).check(matches(withText("")))
        onView(withId(R.id.writeYourNameEditText)).check(matches(withText("")))
    }

}