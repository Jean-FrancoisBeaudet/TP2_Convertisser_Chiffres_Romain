package ca.csf.pobj.tp2.RomanNumberConverter;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ca.csf.pobj.tp2.R;
import ca.csf.pobj.tp2.Util.NumberUtils;
import ca.csf.pobj.tp2.Util.StringUtils;

public class RomanNumberConverterActivity extends AppCompatActivity {

    private View rootView;
    private EditText inputEditText;
    private TextView convertedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.rootView);
        inputEditText = findViewById(R.id.inputEditText);
        convertedNumber = findViewById(R.id.convertedNumber);
    }

    public void onToRomanNumberClick(View view){
        if(this.isValidInput()) {
            String input = this.inputEditText.getText().toString();
            int number = NumberUtils.toInt(input);
            convertedNumber.setText(RomanNumberConverter.convert(number));
        }
    }

    private boolean isValidInput(){
        if(this.isInputBlank()){
            Snackbar errorMessage = Snackbar.make(findViewById(R.id.rootView), R.string.blankStringError, Snackbar.LENGTH_LONG);
            return false;
        }
        if(this.isInputInt()){
            Snackbar errorMessage = Snackbar.make(findViewById(R.id.rootView), R.string.blankStringError, Snackbar.LENGTH_LONG);
            return false;
        }
        if(this.isInputRangeValid()){
            Snackbar errorMessage = Snackbar.make(findViewById(R.id.rootView), R.string.blankStringError, Snackbar.LENGTH_LONG);
            return false;
        }
        return true;
    }

    private boolean isInputBlank(){
        return StringUtils.isBlank(this.inputEditText.getText().toString());
    }

    private boolean isInputInt(){
        return NumberUtils.toInt(this.inputEditText.getText().toString());
    }

    private boolean isInputRangeValid(int inputAsInt){
        return inputAsInt > 0 && inputAsInt < 5000;
    }
}
