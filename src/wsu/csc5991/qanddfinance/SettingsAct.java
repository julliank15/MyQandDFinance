//==============================================================
//
//  Class: Option 1
//  Description:
//  	This class represents a screen activity.
//
//==============================================================
package wsu.csc5991.qanddfinance;

//Import Android packages
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//Import Java packages
import java.text.DecimalFormat;
import java.util.Calendar;

//--------------------------------------------------------------
//class ActOption1
//--------------------------------------------------------------
public class SettingsAct extends Activity 
{

    //----------------------------------------------------------------
    // Constants
    //----------------------------------------------------------------

	// Declare application constants
	private static final String APP_NAME = "Menu";
	private static final String APP_VERSION = "1.0";

    // Declare format constants
    private static final DecimalFormat FORMAT_TIME_SEGMENT =
    		new DecimalFormat("00");
    private static final DecimalFormat FORMAT_YEAR_SEGMENT = 
    		new DecimalFormat("0000");

    //----------------------------------------------------------------
    // Activity overrides
    //----------------------------------------------------------------

    //----------------------------------------------------------------
    // onCreate
    //----------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.laysettings);
		
		//Update Variables
		transferToMain();
	}
	
	private void transferToMain() {
		Button btn = (Button) findViewById(R.id.btnMain);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Get the information from the EditTexts
				EditText federalTextEntry = (EditText) findViewById(R.id.etFederal1);
				String federalUserData = federalTextEntry.getText().toString();
				Shared.Data.federalTax = Double.parseDouble(federalUserData);
				EditText stateTaxTextEntry = (EditText) findViewById(R.id.ettax1);
				String stateTaxUserData = stateTaxTextEntry.getText().toString();
				Shared.Data.stateTax = Double.parseDouble(stateTaxUserData);
				EditText retireAgeTextEntry = (EditText) findViewById(R.id.etretireAge1);
				String retireAgeUserData = retireAgeTextEntry.getText().toString();
				Shared.Data.retireAge = Integer.parseInt(retireAgeUserData);
				
				// Transfer Data to next activity
				Intent intent = new Intent(getApplicationContext(), MainAct.class);
				intent.putExtra("Federal Tax", Shared.Data.federalTax);
				intent.putExtra("State Tax", Shared.Data.stateTax);
				intent.putExtra("Retirement Age", Shared.Data.retireAge);
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
    	System.out.println("### DEBUG ### Option1-onStart started at " +
    			currentTime() + ".");
		super.onStart();
	}

    //----------------------------------------------------------------
    // onResume
    //----------------------------------------------------------------
	@Override
	protected void onResume()
	{
    	System.out.println("### DEBUG ### Option1-onResume started at " +
    			currentTime() + ".");
		super.onResume();
	}

    //----------------------------------------------------------------
    // onPause
    //----------------------------------------------------------------
	@Override
	protected void onPause()
	{
    	System.out.println("### DEBUG ### Option1-onPause started at " +
    			currentTime() + ".");
		super.onPause();
	}

    //----------------------------------------------------------------
    // onStop
    //----------------------------------------------------------------
	@Override
	protected void onStop()
	{
    	System.out.println("### DEBUG ### Option1-onStop started at " +
    			currentTime() + ".");
		super.onStop();
	}

	//----------------------------------------------------------------
    // onRestart
    //----------------------------------------------------------------
	@Override
	protected void onRestart()
	{
    	System.out.println("### DEBUG ### Option1-onRestart started at " +
    			currentTime() + ".");
		super.onRestart();
	}

    //----------------------------------------------------------------
    // onDestroy
    //----------------------------------------------------------------
	@Override
	protected void onDestroy() 
	{
    	System.out.println("### DEBUG ### Option1-onDestroy started at " +
    			currentTime() + ".");
		super.onDestroy();
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