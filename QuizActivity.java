package com.aiyu.ceoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFlaseButton;
    private TextView mQuestionTestView;
    private Button mNextButtion;


    private Question[] mQuestionBand = new Question[] {
        new Question(R.string.question_anstralia,true),
        new Question(R.string.question_mideast,false),
        new Question(R.string.question_americas,true),
        new Question(R.string.question_asia,true),
    };

    private int mCurrentIndex = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTestView = (TextView) findViewById(R.id.question_text_view);

        mTrueButton = (Button) findViewById(R.id.true_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast toast = Toast.makeText(QuizActivity.this, R.string.conrrent_toast, Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.TOP, 0, 0);
//                toast.show();
                checkAnswer(true);

            }
        });

        mFlaseButton = (Button) findViewById(R.id.false_button);

        mFlaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast toast = Toast.makeText(QuizActivity.this, R.string.inconrrect_toast, Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.TOP, 0, 0);
//                toast.show();
                  checkAnswer(false);
            }
        });

        mNextButtion = (Button) findViewById(R.id.next_button);
        mNextButtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBand.length;
                updateQuestion();
            }

        });

        updateQuestion();
    }

    private void updateQuestion() {
        int question = mQuestionBand[mCurrentIndex].getTextResid();
        mQuestionTestView.setText(question);

    }

    private void checkAnswer(boolean userPressceTrue) {
        boolean answerIsTrue = mQuestionBand[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;

        if (userPressceTrue == answerIsTrue) {
            messageResId = R.string.conrrent_toast;

        } else {
            messageResId = R.string.inconrrect_toast;

        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

    }

}
