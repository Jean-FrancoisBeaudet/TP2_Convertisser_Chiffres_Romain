package ca.csf.pobj.tp2.RomanNumberConverter;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import ca.csf.pobj.tp2.R;
import ca.csf.pobj.tp2.Util.NumberUtils;
import ca.csf.pobj.tp2.Util.StringUtils;

public class RomanNumberConverterActivity extends AppCompatActivity {

    private View rootView;
    private EditText inputEditText;
    private TextView outputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.rootView);
        inputEditText = findViewById(R.id.inputEditText);
        outputEditText = findViewById(R.id.convertedNumber);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("outputEditText", this.outputEditText.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.outputEditText.setText(savedInstanceState.getString("outputEditText"));
    }

    public void onToRomanNumberClick(View view){
        if(this.isValidInput()) {
            String input = this.inputEditText.getText().toString();
            int number = NumberUtils.toInt(input);
            outputEditText.setText(RomanNumberConverter.convert(number));
        }
        this.hideKeyboard();
    }

    private boolean isValidInput(){
        if(this.isInputBlank()){
            this.showErrorMessage(R.string.blankStringError);
            return false;
        }
        if(!this.isInputInt()){
            this.showErrorMessage(R.string.stringNotValid);
            return false;
        }
        int value = NumberUtils.toInt(this.inputEditText.getText().toString());
        if(!this.isInputRangeValid(value)){
            this.showErrorMessage(R.string.intOutOfRange);
            return false;
        }
        return true;
    }

    private boolean isInputBlank(){
        return StringUtils.isBlank(this.inputEditText.getText().toString());
    }

    private boolean isInputInt(){
        return NumberUtils.isInputInt(this.inputEditText.getText().toString());
    }

    private boolean isInputRangeValid(int inputAsInt) {
        return inputAsInt > 0 && inputAsInt < 5000;
    }

    private void showErrorMessage(int errorMessage) {
        Snackbar.make(findViewById(R.id.rootView), errorMessage, Snackbar.LENGTH_LONG).show();
        this.outputEditText.setText("");
    }

    public void hideKeyboard(){
        InputMethodManager manager = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);
        View view = this.getCurrentFocus();
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
