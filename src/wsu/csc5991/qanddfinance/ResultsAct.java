package wsu.csc5991.qanddfinance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;

public class ResultsAct extends Activity {
	// ----------------------------------------------------------------
	// Constants
	// ----------------------------------------------------------------

	// Declare application constants
	private static final String APP_NAME = "TemplateMain";
	private static final String APP_VERSION = "1.0";

	// Declare format constants
	private static final DecimalFormat FORMAT_TIME_SEGMENT = new DecimalFormat(
			"00");
	private static final DecimalFormat FORMAT_YEAR_SEGMENT = new DecimalFormat(
			"0000");

	// Declare SMS constants
	private static final int MAX_MESSAGE_LENGTH = 140;

	// Global Variables
	private double inflation;
	private int myAge;
	private double inflationValue = 0;

	// Declare control variables
	private EditText etSendMessage;
	private EditText etPhoneNumber;
	private Button btnSendMessage;

	// Declare SMS variables
	private SmsManager smsManager;

	// ----------------------------------------------------------------
	// method to format decimals to two significant figures
	// ----------------------------------------------------------------

	private static DecimalFormatSymbols DFS;
	private static DecimalFormat myFormatter;

	public static String DoubleToFormatedString(double value) {
		DFS = new DecimalFormatSymbols();
		DFS.setDecimalSeparator('.');
		myFormatter = new DecimalFormat("#.00");
		myFormatter.setDecimalFormatSymbols(DFS);
		return myFormatter.format(value);
	}

	// ----------------------------------------------------------------
	// onCreate
	// ----------------------------------------------------------------

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layresults);

		// ----------------------------------------------------------------
		// Define send message controls
		// ----------------------------------------------------------------
		etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);

		// Get the intent from previous pages

		Intent intent = getIntent();
		inflation = intent.getIntExtra("Inflation", 0);
		Intent intent6 = getIntent();
		myAge = intent6.getIntExtra("My Age", 0);

		// Compute Savings
		double retirementSavings = Shared.Data.MonthlyRetire * 12;
		for (int i = 0; i < (Shared.Data.retireAge - Shared.Data.UserAge); i++) {
			inflationValue = (retirementSavings + inflationValue);
			inflationValue = inflationValue
					- (inflationValue * (Shared.Data.inflation / 100));
			// retirementSavings = retirementSavings -
			// (retirementSavings*0.0322);

		}

		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// Display the values
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		TextView displayMonthlyRetirement = (TextView) findViewById(R.id.tvMonthlyRetire1);
		displayMonthlyRetirement.setText("" + DoubleToFormatedString (inflationValue));

		// s~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// send message with results
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		Button btnSendMessage = (Button) findViewById(R.id.btnSmsMessage);
		btnSendMessage.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				sendMessageInfo();
			}
		});
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// start MessageAct activity
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private void sendMessageInfo() {
		// Get send message and phone number
		Log.i("Send SMS", "");
		String msg = "Salary After Tax: $"
				+ DoubleToFormatedString(Shared.Data.mySalaryAfterTax) + "\n"
				+ "Savings: " + Shared.Data.savings + "\n" + "Flex Spending: "
				+ Shared.Data.flexSpending + "\n" + "Fixed Cost"
				+ Shared.Data.fixedCost + "\n";
		String num = etPhoneNumber.getText().toString();

		try {
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(num, null, msg, null, null);
			Toast.makeText(getApplicationContext(), "Message Sent",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					"SMS faild, please try again.", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// ----------------------------------------------------------------
	// onStart
	// ----------------------------------------------------------------
	@Override
	protected void onStart() {
		System.out.println("### DEBUG ### onStart started at " + currentTime()
				+ ".");
		super.onStart();
	}

	// ----------------------------------------------------------------
	// onResume
	// ----------------------------------------------------------------
	@Override
	protected void onResume() {
		System.out.println("### DEBUG ### onResume started at " + currentTime()
				+ ".");
		super.onResume();
	}

	// ----------------------------------------------------------------
	// onPause
	// ----------------------------------------------------------------
	@Override
	protected void onPause() {
		System.out.println("### DEBUG ### onPause started at " + currentTime()
				+ ".");
		super.onPause();
	}

	// ----------------------------------------------------------------
	// onStop
	// ----------------------------------------------------------------
	@Override
	protected void onStop() {
		System.out.println("### DEBUG ### onStop started at " + currentTime()
				+ ".");
		super.onStop();
	}

	// ----------------------------------------------------------------
	// onRestart
	// ----------------------------------------------------------------
	@Override
	protected void onRestart() {
		System.out.println("### DEBUG ### onRestart started at "
				+ currentTime() + ".");
		super.onRestart();
	}

	// ----------------------------------------------------------------
	// onDestroy
	// ----------------------------------------------------------------
	@Override
	protected void onDestroy() {
		System.out.println("### DEBUG ### onDestroy started at "
				+ currentTime() + ".");
		super.onDestroy();
	}

	// ----------------------------------------------------------------
	// onBackPressed
	// The default behavior of the Android Back button is to destroy
	// the current activity but leave the application in the menu
	// list. We override it here so that the button does nothing.
	// ----------------------------------------------------------------
	@Override
	public void onBackPressed() {
		System.out.println("### DEBUG ### Back button pressed at "
				+ currentTime() + ".");
		super.onBackPressed();
	}

	// ----------------------------------------------------------------
	// currentTime
	// ----------------------------------------------------------------
	private String currentTime() {

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
		return (yStr + "-" + mnStr + dStr + ", " + hStr + ":" + miStr + ":" + sStr);
	}
}
