package com.example.groceriescsc301;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/* Test created in reference to https://www.youtube.com/watch?v=_TR6QcRozAg&ab_channel=LearnShareAnythingAnyone*/

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mainActivity = null;

    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view = mainActivity.findViewById(R.id.companyName);
        assertNotNull(view);
    }
    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}