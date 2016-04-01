package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import org.mockito.Mock;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gemma S. Lara Savill on 01/04/2016.
 */
public class GetJokeAsyncTaskTest extends AndroidTestCase {

    GetJokeAsyncTask getJokeAsyncTaskTask;
    String aJoke;
    @Mock Context mockContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        aJoke = null;
        getJokeAsyncTaskTask = new GetJokeAsyncTask(){
            @Override
            protected void onPostExecute(String joke){
                //No need to launch intent, so override this method
            }
        };
    }

    /**
     * Test that checks that the joke the AsyncTask returns is not null
     */
    public void testGetJokeNotNull() {

        try{
            getJokeAsyncTaskTask.execute(mockContext);
            aJoke = getJokeAsyncTaskTask.get(10, TimeUnit.SECONDS);
            assertNotNull(aJoke);
        }catch (Exception e){
            // Default timeout for the GCM server is 20 seconds
            // here it is given 10 seconds
            // Make sure it is testing on an emulator or the device has access to the GCM IP
            fail("Timed out");
        }
    }
}