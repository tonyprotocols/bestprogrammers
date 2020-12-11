package karimovic.toni.lv5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnInspiration;
    Button btnDescription;
    EditText etDescription;
    TextView tvFirstPerson;
    TextView tvSecondPerson;
    TextView tvThirdPerson;
    RadioGroup rgRadioGroup;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
    }

    public void initializeUI (){
        this.btnInspiration = (Button) findViewById(R.id.btnInspiration);
        this.btnDescription = (Button) findViewById(R.id.btnNewDescription);
        this.etDescription = (EditText) findViewById(R.id.etNewDescription);
        this.tvFirstPerson = (TextView) findViewById(R.id.tvFirstPersonAbout);
        this.tvSecondPerson = (TextView) findViewById(R.id.tvSecondPersonAbout);
        this.tvThirdPerson = (TextView) findViewById(R.id.tvThirdPersonAbout);
        this.rgRadioGroup = (RadioGroup) findViewById(R.id.rgRadioGroup);
        ((RadioButton)rgRadioGroup.getChildAt(0)).setChecked(true);

        this.btnInspiration.setOnClickListener(this);
        this.btnDescription.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btnInspiration:
                final int random = new Random().nextInt(2) + 1;
                Log.d("Random", "Random num is " + random);
                switch (random) {
                    case 1:
                        Toast.makeText(this, R.string.inspirationFirstPerson, Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(this, R.string.inspirationSecondPerson, Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(this, R.string.inspirationThirdPerson, Toast.LENGTH_LONG).show();
                        break;
                    default:
                        Toast.makeText(this, "Bad random num!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnNewDescription:
                Log.d("Desc:", "Desc is clicked!");
                String text = etDescription.getText().toString();

                int selectedId = rgRadioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                Log.d("RadioButton", radioButton.getText().toString());

                switch (radioButton.getId()){
                    case R.id.rbFirstPerson:
                        this.tvFirstPerson.setText(text);
                        break;
                    case R.id.rbSecondPerson:
                        this.tvSecondPerson.setText(text);
                        break;
                    case R.id.rbThirdPerson:
                        this.tvThirdPerson.setText(text);
                        break;
                    default:
                        Log.wtf("WTF", "We don't have this RB");
                }

                break;
            default:
                Log.wtf("WTF", "I dont have that button!");
        }
    }
}
