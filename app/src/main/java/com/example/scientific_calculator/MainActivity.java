package com.example.scientific_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display             = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false); // For not letting device keyboard popup

    }


       private void updateText(String strToAdd){
         //display.setText(strToAdd);

           String oldStr = display.getText().toString(); //getting the string & displaying it      -->1

           int cursorPos = display.getSelectionStart(); //getting the position of the cursor

           String leftStr = oldStr.substring(0,cursorPos); //eg 894|97 leftStr=894 & rightStr=97 cursorPos->3
           String rightStr = oldStr.substring(cursorPos); //if want to add 1 in cursor position add

           display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr)); //adding next digit to oldStr -->1
           display.setSelection(cursorPos + strToAdd.length());
       }

       public void zeroBtnPush(View view){

           updateText(getResources().getString(R.string.zeroText)); // updateText("0"); hardcoded
           // i.e we have already declared 0 in string resources therefore use from there only(to reduce delicacy)
       }

    public void oneBtnPush(View view){

        updateText(getResources().getString(R.string.oneText));
    }

    public void twoBtnPush(View view){

        updateText(getResources().getString(R.string.twoText));
    }

    public void threeBtnPush(View view){

        updateText(getResources().getString(R.string.threeText));
    }

    public void fourBtnPush(View view){

        updateText(getResources().getString(R.string.fourText));
    }

    public void fiveBtnPush(View view){

        updateText(getResources().getString(R.string.fiveText));
    }

    public void sixBtnPush(View view){

        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenBtnPush(View view){

        updateText(getResources().getString(R.string.sevenText));
    }

    public void eightBtnPush(View view){

        updateText(getResources().getString(R.string.eightText));
    }

    public void nineBtnPush(View view){

        updateText(getResources().getString(R.string.nineText));
    }

    public void addBtnPush(View view){

        updateText(getResources().getString(R.string.addText));
    }

    public void minusBtnPush(View view){

        updateText(getResources().getString(R.string.subtractText));
    }

    public void multiplyBtnPush(View view){

        updateText(getResources().getString(R.string.multiplyText));
    }

    public void divideBtnPush(View view){

        updateText(getResources().getString(R.string.divideText));
    }

    public void decimalBtnPush(View view){

        updateText(getResources().getString(R.string.decimalText));
    }

    public void open_BracketBtnPush(View view){

        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void close_bracketBtnPush(View view){

        updateText(getResources().getString(R.string.parenthesesCloseText));
    }


    public void equalBTNPush(View view){
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void backspaceBTNPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void clearBTNPush(View view){
        display.setText("");
        previousCalculation.setText("");
    }


    public void trigSinBTNPush(View view){
        updateText("sin(");
    }

    public void trigCosBTNPush(View view){
        updateText("cos(");
    }

    public void trigTanBTNPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){
        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){
        updateText("arccos(");
    }

    public void trigArcTanBTNPush(View view){
        updateText("arctan(");
    }

    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }

    public void logBTNPush(View view){
        updateText("log(");
    }

    public void sqrtBTNPush(View view){
        updateText("sqrt(");
    }

    public void absBTNPush(View view){
        updateText("abs(");
    }

    public void piBTNPush(View view){
        updateText("pi");
    }

    public void eBTNPush(View view){
        updateText("e");
    }

    public void xSquaredBTNPush(View view){
        updateText("^(2)");
    }

    public void xPowerYBTNPush(View view){
        updateText("^(");
    }

    public void primeBTNPush(View view){
        updateText("ispr(");
    }


}