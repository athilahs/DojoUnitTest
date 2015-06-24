package com.digitalday.dojounittest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.digitalday.dojounittest.validator.IntegerValidator;
import com.digitalday.dojounittest.validator.Validator;

public class MainActivity extends Activity {

    private Calculator calculator;

    private EditText sumOp1;
    private EditText sumOp2;
    private Button sumButton;
    private TextView sumTotal;

    private EditText subtractOp1;
    private EditText subtractOp2;
    private Button subtractButton;
    private TextView subtractTotal;

    private EditText multiplyOp1;
    private EditText multiplyOp2;
    private Button multiplyButton;
    private TextView multiplyTotal;

    private EditText divisionOp1;
    private EditText divisionOp2;
    private Button divisionButton;
    private TextView divisionTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();

        loadViews();
        setListeners();
    }

    private void loadViews() {
        sumOp1 = (EditText) findViewById(R.id.sumOp1);
        sumOp2 = (EditText) findViewById(R.id.sumOp2);
        sumButton = (Button) findViewById(R.id.buttonSum);
        sumTotal = (TextView) findViewById(R.id.sumTotal);

        subtractOp1 = (EditText) findViewById(R.id.subtractOp1);
        subtractOp2 = (EditText) findViewById(R.id.subtractOp2);
        subtractButton = (Button) findViewById(R.id.buttonSubtract);
        subtractTotal = (TextView) findViewById(R.id.subtractTotal);

        multiplyOp1 = (EditText) findViewById(R.id.multiplyOp1);
        multiplyOp2 = (EditText) findViewById(R.id.multiplyOp2);
        multiplyButton = (Button) findViewById(R.id.buttonMultiply);
        multiplyTotal = (TextView) findViewById(R.id.multiplyTotal);

        divisionOp1 = (EditText) findViewById(R.id.divisionOp1);
        divisionOp2 = (EditText) findViewById(R.id.divisionOp2);
        divisionButton = (Button) findViewById(R.id.buttonDivision);
        divisionTotal = (TextView) findViewById(R.id.divisionTotal);
    }

    private void setListeners() {
        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validator validator = new IntegerValidator();
                String op1 = sumOp1.getText().toString();
                String op2 = sumOp2.getText().toString();

                if (validator.validate(op1) && validator.validate(op2)) {
                    sumTotal.setText(Double.toString(calculator.sum(Integer.parseInt(op1), Integer.parseInt(op2))));
                }
            }
        });
    }
}
