//==============================================================
//
//  Title:       <QandD Finance>
//  Course:      CSC 5991 – Mobile Application Development
//  Application: <number>
//  Author:      <author>
//  Date:        <date>
//  Description:
//  	<brief description of application including its inputs,
//  processing, and outputs>
//
//==============================================================
package wsu.csc5991.qanddfinance;

import wsu.csc5991.qanddfinance.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



import android.view.View;
import android.widget.Button;






import android.widget.TextView;

//Import Java packages
import java.text.DecimalFormat;
import java.util.Calendar;

//--------------------------------------------------------------
//class ActMain
//--------------------------------------------------------------
public class MainAct extends Activity {

	//----------------------------------------------------------------
    // Constants
    //----------------------------------------------------------------

	// Declare application constants
	private static final String APP_NAME = "QandD Finance";
	private static final String APP_VERSION = "1.0";

    // Declare format constants
    private static final DecimalFormat FORMAT_TIME_SEGMENT =
    		new DecimalFormat("00");
    private static final DecimalFormat FORMAT_YEAR_SEGMENT = 
    		new DecimalFormat("0000");

    //----------------------------------------------------------------
    // Variables
    //----------------------------------------------------------------

    // Declare variables
    private Button btnNext;

    //----------------------------------------------------------------
    // Activity overrides
    //----------------------------------------------------------------
    
    //----------------------------------------------------------------
    // onCreateOptionsMenu
    //----------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
    	System.out.println("### DEBUG ### Main-onCreateOptionsMenu " +
    			"started at " + currentTime() + ".");
        getMenuInflater().inflate(R.menu.laymenu, menu);
        return true;
    }

    //----------------------------------------------------------------
    // onOptionsItemSelected
    // Menu hierarchy
    //   Option 1
    //   Option 2
    //   Option 3
    //     Option 3a
    //     Option 3b
    //       Option 3b1
    //       Option 3b2
    //       Option 3b3
    //       Option 3b4
    //----------------------------------------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	System.out.println("### DEBUG ### Main-onOptionsItemSelected " +
    			"started at " + currentTime() + ".");

    	// Handle menu option click
	    switch (item.getItemId())
	    {
	    	
	    	case R.id.itmHelp:
	    		Intent intOption1 = new Intent(this, HelpAct.class);
	    		startActivity(intOption1);
	    		return true;
		    	
	    	case R.id.itmSettings:
	    		Intent intOption2 = new Intent(this, SettingsAct.class);
	    		startActivity(intOption2);
	    		return true;
	    	
	    	case R.id.itmAbout:
	    		Intent intOption3 = new Intent(this, AboutAct.class);
	    		startActivity(intOption3);
	    		return true;
		    	
	    	default:
	    		return super.onOptionsItemSelected(item);

	    }

    }

    //----------------------------------------------------------------
    // onCreate
    //----------------------------------------------------------------
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("### DEBUG ### onCreate started at " +
    			currentTime() + ".");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.laymain);
		
		//Define Button Control
		btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent (getApplicationContext(), InfoAct.class);			
				startActivity(intent);
			}
			
		});
	}
	
	//----------------------------------------------------------------
    // onStart
    //----------------------------------------------------------------
	@Override
	protected void onStart()
	{
    	System.out.println("### DEBUG ### onStart started at " +
    			currentTime() + ".");
		super.onStart();
	}

    //----------------------------------------------------------------
    // onResume
    //----------------------------------------------------------------
	@Override
	protected void onResume()
	{
    	System.out.println("### DEBUG ### onResume started at " +
    			currentTime() + ".");
		super.onResume();
	}

    //----------------------------------------------------------------
    // onPause
    //----------------------------------------------------------------
	@Override
	protected void onPause()
	{
    	System.out.println("### DEBUG ### onPause started at " +
    			currentTime() + ".");
		super.onPause();
	}

    //----------------------------------------------------------------
    // onStop
    //----------------------------------------------------------------
	@Override
	protected void onStop()
	{
    	System.out.println("### DEBUG ### onStop started at " +
    			currentTime() + ".");
		super.onStop();
	}

	//----------------------------------------------------------------
    // onRestart
    //----------------------------------------------------------------
	@Override
	protected void onRestart()
	{
    	System.out.println("### DEBUG ### onRestart started at " +
    			currentTime() + ".");
		super.onRestart();
	}

    //----------------------------------------------------------------
    // onDestroy
    //----------------------------------------------------------------
	@Override
	protected void onDestroy() 
	{
    	System.out.println("### DEBUG ### onDestroy started at " +
    			currentTime() + ".");
		super.onDestroy();
	}

    //----------------------------------------------------------------
    // onBackPressed
	//   The default behavior of the Android Back button is to destroy
	// the current activity but leave the application in the menu
	// list.  We override it here so that the button does nothing.
    //----------------------------------------------------------------
    @Override
	public void onBackPressed()
    {
    	System.out.println("### DEBUG ### Back button pressed at " +
    			currentTime() + ".");
//		super.onBackPressed();
	}
    
    //----------------------------------------------------------------
    // General utilities
    //----------------------------------------------------------------

    //----------------------------------------------------------------
    // currentTime
    //----------------------------------------------------------------
    private String currentTime()
    {

        // Declare variables
        int y;
        String yStr;
        int mn;
        String mnStr;
        int d;
        String dStr;
        int h;
        String hStr;
        int mi;
        String miStr;
        int s;
        String sStr;
        Calendar timeNow;

        // Get current time
        timeNow = Calendar.getInstance();
        y = timeNow.get(Calendar.YEAR);
        mn = timeNow.get(Calendar.MONTH) + 1;
        d = timeNow.get(Calendar.DAY_OF_MONTH);
        h = timeNow.get(Calendar.HOUR_OF_DAY);
        mi = timeNow.get(Calendar.MINUTE);
        s = timeNow.get(Calendar.SECOND);

        // Format current time as string
        yStr = FORMAT_YEAR_SEGMENT.format(y);
        mnStr = FORMAT_TIME_SEGMENT.format(mn);
        dStr = FORMAT_TIME_SEGMENT.format(d);
        hStr = FORMAT_TIME_SEGMENT.format(h);
        miStr = FORMAT_TIME_SEGMENT.format(mi);
        sStr = FORMAT_TIME_SEGMENT.format(s);
        return (yStr + "-" + mnStr + dStr + ", " + 
        		hStr + ":" + miStr + ":" + sStr);

    }
}