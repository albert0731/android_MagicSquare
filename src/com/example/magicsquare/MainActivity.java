package com.example.magicsquare;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	/** CamyLayouted when the activity is first created. */
	//Creat a N by N array
	int NByN = 4, StartNumber;
	//Magic Square Numbers
	int[][] NumberArray = {{16, 2, 3, 13}, {5, 11, 10, 8}, {9, 7, 6, 12}, {4, 14, 15, 1}};
	Button[][] ButtonNumberFiled = new Button[NByN][NByN];
	String[] SetNumberArray = new String [NByN*NByN+5];
	TextView DebugPrintOut;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		CreateDynamicLayouts();
	}

	private void CreateDynamicLayouts(){

		LinearLayout MainLayout = new LinearLayout(this);
		MainLayout.setOrientation(LinearLayout.VERTICAL);

		DebugPrintOut = new TextView(this);
		DebugPrintOut.setText("Dynamic layouts ftw!");
		MainLayout.addView(DebugPrintOut);

		//Get Width Pixels of Cell Phone
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		//Build Table of N by N array
		LinearLayout[] RowLayout = new LinearLayout[NByN];

		StartNumber = 1;

		for(int i = 0; i < NByN; i++) {
			//Build N Rows
			RowLayout[i] = new LinearLayout(this);
			RowLayout[i].setOrientation(LinearLayout.HORIZONTAL);	

			for(int j = 0; j < NByN; j++) {
				//Build N Columns
				ButtonNumberFiled[i][j] = new Button(this);
				ButtonNumberFiled[i][j].setText(String.valueOf(StartNumber));
				ButtonNumberFiled[i][j].setTag(StartNumber);
				ButtonNumberFiled[i][j].setOnClickListener(mySelectNumbers);
				RowLayout[i].addView(ButtonNumberFiled[i][j]);
				SetNumberArray[StartNumber] = String.valueOf(StartNumber);
				StartNumber++;
			}			
			MainLayout.addView(RowLayout[i]);			
		}
		SetNumberArray[StartNumber+1] = "0";
		//Build Set Default Number Button
		Button ButtonReset = new Button(this);
		ButtonReset.setText("Load Test Numbers");
		ButtonReset.setOnClickListener(myLoadTestNumbers);
		MainLayout.addView(ButtonReset);

		this.setContentView(MainLayout);

	}//end of CreateDynamicLayouts

	Button.OnClickListener myLoadTestNumbers = new Button.OnClickListener(){		
		public void onClick(View arg0){
			ButtonNumberReadWrite( false );//Write date to Buttons
		}//end of onClick(View arg0)

	};//end of OnClickListener mySelectNumbers

	//a POP Menu to Select Numbers 
	Button.OnClickListener mySelectNumbers = new Button.OnClickListener(){
		//POP a Menu
		public void onClick(View ButtonTag){
			Button TempButton;
			DebugPrintOut.setText("ButtonTag.getTag()="+ButtonTag.getTag());
			TempButton = (Button) ButtonTag.findViewWithTag(ButtonTag.getTag());
			TempButton.setText("XXXX");
//			new AlertDialog.Builder(MainActivity.this)
//			.setTitle("Please Select Numbers")
//			.setItems(SetNumberArray, new DialogInterface.OnClickListener() {
//
//				//When click on a option
//				public void onClick(DialogInterface dialog, int whichNumber) {
//					//ButtonNumberFiled..setText(String.valueOf(SetNumberArray[whichNumber]));
//					ButtonTag.findViewWithTag(i);
//					//DebugPrintOut.setText(String.valueOf(SetNumberArray[whichNumber]));
//				}
//			})
//			.show();//DialogInterface.OnClickListener
		}
	};//end of OnClick  Listener mySelectNumbers

	//Load or Save Buttons   RW=1 Read   ; RW=0 Write
	void ButtonNumberReadWrite(boolean RW){
		if(RW){//Read date to Buttons
//			for(int i = 0; i < NByN; i++)			
//				for(int j = 0; j < NByN; j++)
//					NumberArray[i][j] = String.valueOf(ButtonNumberFiled[i][j]).getText());
		}else{//Write date to Buttons
			for(int i = 0; i < NByN; i++)			
				for(int j = 0; j < NByN; j++)
					ButtonNumberFiled[i][j].setText(String.valueOf(NumberArray[i][j]));
		}
		
	}//end of ButtonNumberReadWrite





}//end of MainActivity

