package pith.itdev.pithtraffic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ExerciseActivity extends AppCompatActivity {

    //Explicit
    private TextView questionTextView;
    private ImageView questionImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton, choice3RadioButton,choice4RadioButton;
    private int radioAnInt,timesAnInt, scoreAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        bindWidget();

        radioControler();

    }   //Main Method

    //Method Checking Choice
    private void radioControler() {
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButton:
                        radioAnInt = 1;
                        break;
                    case R.id.radioButton2:
                        radioAnInt = 2;
                        break;
                    case R.id.radioButton3:
                        radioAnInt = 3;
                        break;
                    case R.id.radioButton4:
                        radioAnInt = 4;
                        break;
                    default:
                        radioAnInt = 0;
                        break;
                }   //Switch

            }   //Event
        });
    }

    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.txtQuestion);
        questionImageView = (ImageView) findViewById(R.id.imvQuestion);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.ragChoice);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);
    }

    public void clickAnswer(View view) {

        //Check Zero
        if (radioAnInt == 0) {
            //True, Don't Have Answer
            Toast.makeText(ExerciseActivity.this, "Please Check Choice", Toast.LENGTH_SHORT).show();
        } else {
            checkScore();

            //False, Have Answer
            if (timesAnInt == 4) { //Check Sum Question
                scoreDialog();
            } else {


                changeView();

                timesAnInt += 1;
            }   //If2

        }   //If1

    }   //Click Answer

    private void checkScore() {

        int[] intTrue = {1,2,3,4,1};
        if (radioAnInt == intTrue[timesAnInt]) {
            scoreAnInt += 1;
        }

    }

    private void changeView() {

        String[] strQuestion = new String[5];
        strQuestion[0] = "1. What is this ?";
        strQuestion[1] = "2. What is this ?";
        strQuestion[2] = "3. What is this ?";
        strQuestion[3] = "4. What is this ?";
        strQuestion[4] = "5. What is this ?";
        questionTextView.setText(strQuestion[timesAnInt + 1]);

        int[] intImage = new int[5];
        intImage[0] = R.drawable.traffic_01;
        intImage[1] = R.drawable.traffic_02;
        intImage[2] = R.drawable.traffic_03;
        intImage[3] = R.drawable.traffic_04;
        intImage[4] = R.drawable.traffic_05;
        questionImageView.setImageResource(intImage[timesAnInt+1]);

        int[] intChoice = new int[5];
        intChoice[0] = R.array.times1;
        intChoice[1] = R.array.times2;
        intChoice[2] = R.array.times3;
        intChoice[3] = R.array.times4;
        intChoice[4] = R.array.times5;
        String[] strChoice = getResources().getStringArray(intChoice[timesAnInt + 1]);
        choice1RadioButton.setText(strChoice[0]);
        choice2RadioButton.setText(strChoice[1]);
        choice3RadioButton.setText(strChoice[2]);
        choice4RadioButton.setText(strChoice[3]);

    }

    private void scoreDialog() {
        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        objBuilder.setIcon(R.drawable.icon_myaccount);
        objBuilder.setTitle("Score");
        objBuilder.setMessage("Score = " + Integer.toString(scoreAnInt));
        objBuilder.setCancelable(false);
        objBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(ExerciseActivity.this, MainActivity.class));
                dialog.dismiss();
            }
        });
        objBuilder.show();
    }
}   //Main Class
