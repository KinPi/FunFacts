package com.treehouse.funfacts;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {
    private static final String TAG = FunFactsActivity.class.getSimpleName();
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    private ConstraintLayout mConstraintLayout;
    private TextView mFactTextView;
    private Button mShowFactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        mConstraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mShowFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = mColorWheel.getColor();

                mFactTextView.setText(mFactBook.getFact());
                mConstraintLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
            }
        });

        Log.d(TAG, "Logging from onCreate() method.");
    }
}
