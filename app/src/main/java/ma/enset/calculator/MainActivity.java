package ma.enset.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private EditText inputTxt;
    private EditText outputTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTxt = findViewById(R.id.inputTxt);
        outputTxt = findViewById(R.id.outputTxt);

        outputTxt.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToDisplay){
        String str = outputTxt.getText().toString();
        int cursorPos = outputTxt.getSelectionStart();
        String leftStr = str.substring(0,cursorPos);
        String rightStr = str.substring(cursorPos);
        outputTxt.setText(String.format("%s%s%s",leftStr,strToDisplay,rightStr));
        outputTxt.setSelection(cursorPos+strToDisplay.length());
    }

    public void zeroBtn(View view){
        updateText((String) getResources().getText(R.string.zeroText));
    }
    public void oneBtn(View view){
        updateText((String) getResources().getText(R.string.oneText));
    }
    public void twoBtn(View view){
        updateText((String) getResources().getText(R.string.twoText));
    }
    public void threeBtn(View view){
        updateText((String) getResources().getText(R.string.threeText));
    }
    public void fourBtn(View view){
        updateText((String) getResources().getText(R.string.fourText));
    }
    public void fiveBtn(View view){
        updateText((String) getResources().getText(R.string.fiveText));
    }public void sixBtn(View view){
        updateText((String) getResources().getText(R.string.sixText));
    }
    public void sevenBtn(View view){
        updateText((String) getResources().getText(R.string.sevenText));
    }
    public void eightBtn(View view){
        updateText((String) getResources().getText(R.string.eightText));
    }
    public void nineBtn(View view){
        updateText((String) getResources().getText(R.string.nineText));
    }public void decimalBtn(View view){
        updateText((String) getResources().getText(R.string.decimalText));
    }
    public void addBtn(View view){
        updateText((String) getResources().getText(R.string.addText));
    }
    public void substractBtn(View view){
        updateText((String) getResources().getText(R.string.subtractText));
    }
    public void multiplayBtn(View view){
        updateText((String) getResources().getText(R.string.multiplyText));
    }
    public void divideBtn(View view){
        updateText((String) getResources().getText(R.string.divideText));
    }
    public void clearBtn(View view){
        inputTxt.setText("");
        outputTxt.setText("");
    }
    public void parenthesesOpenBtn(View view){
        updateText((String) getResources().getText(R.string.parenthesesOpenText));
    }
    public void parenthesesCloseBtn(View view){
        updateText((String) getResources().getText(R.string.parenthesesCloseText));
    }


    public void backspaceBtn(View view){
        int cursorPos = outputTxt.getSelectionStart();
        int textLen = outputTxt.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) outputTxt.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            outputTxt.setText(selection);
            outputTxt.setSelection(cursorPos-1);
        }
    }

    public void equalBtn(View view){
        String userInput = outputTxt.getText().toString();
        userInput = userInput.replaceAll(String.valueOf(getResources().getText(R.string.divideText)),"/");
        userInput = userInput.replaceAll(String.valueOf(getResources().getText(R.string.multiplyText)),"*");
        Expression exp = new Expression(userInput);
        String result = String.valueOf(exp.calculate());
        inputTxt.setText(result);
        //outputTxt.setSelection(result.length());
    }

}