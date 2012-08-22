package com.example.magicsquare;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.Gravity;  
import android.view.View;  
import android.view.ViewGroup;  
import android.view.Window;  
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends Activity {
	/** CamyLayouted when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CreateDynamicLayouts();
	}

	void CreateDynamicLayouts(){

		LinearLayout myLayout = new LinearLayout(this);
		myLayout.setOrientation(LinearLayout.VERTICAL);

		TextView tv = new TextView(this);
		tv.setText("Dynamic layouts ftw!");
		myLayout.addView(tv);
		
		//Creat a N by N array
		int NByN = 4;
		//Magic Square Numbers
		int[][] NumberArray = {{16, 2, 3, 13}, {5, 11, 10, 8}, {9, 7, 6, 12}, {4, 14, 15, 1}};
		
		//Get Width Pixels of Cell Phone
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		
		Button[][] TextFiled = new Button[NByN][NByN];
		TableRow[] myTableRow = new TableRow[NByN];

		for(int i = 0; i < NByN; i++) {
			myTableRow[i] = new TableRow(this);
			myTableRow[i].setLayoutParams(new TableRow.LayoutParams(MATCH_PARENT, WRAP_CONTENT)); 
			
			for(int j = 0; j < NByN; j++) {
				TextFiled[i][j] = new Button(this);
//				TextFiled[i][j].setWidth(50);
//				TextFiled[i][j].setSingleLine();
				TextFiled[i][j].setText(String.valueOf(NumberArray[i][j]));

				myTableRow[i].addView(TextFiled[i][j]);
				//myLayout.addView(TextFiled[i][j]);
				//myTableRow[i].addView(TextFiled[i][j], new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
				//myLayout.addView(TextFiled[i][j], new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
			}			
			myLayout.addView(myTableRow[i]);
			
		}
		
		Button b = new Button(this);
		b.setText("dm.widthPixels = "+String.valueOf(dm.widthPixels)+"     dm.heightPixels = "+String.valueOf(dm.heightPixels));
		myLayout.addView(b);
		
		this.setContentView(myLayout);

	}//end of CreateDynamicLayouts

}//end of MainActivity

