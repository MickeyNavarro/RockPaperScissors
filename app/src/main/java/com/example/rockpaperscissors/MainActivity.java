package com.example.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock, b_scissors, b_paper;
    TextView tv_score;
    ImageView iv_compChoice, iv_yourChoice;

    int HumanScore, CompScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_paper = (Button) findViewById(R.id.b_paper);
        b_rock = (Button) findViewById(R.id.b_rock);
        b_scissors = (Button) findViewById(R.id.b_scissors);

        iv_compChoice = (ImageView) findViewById(R.id.iv_compChoice);
        iv_yourChoice = (ImageView) findViewById(R.id.iv_yourChoice);

        tv_score = (TextView) findViewById(R.id.tv_score);

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_yourChoice.setImageResource(R.drawable.paper);
                String message  = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("SCORE: Human " + Integer.toString(HumanScore)  + " Computer " + Integer.toString(CompScore));
            }
        });

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_yourChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("SCORE: Human " + Integer.toString(HumanScore)  + " Computer " + Integer.toString(CompScore));

            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_yourChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("SCORE: Human " + Integer.toString(HumanScore)  + " Computer " + Integer.toString(CompScore));


            }
        });
    }

    public String play_turn(String player_choice) {
        String computer_choice = "";
        Random r = new Random();

        //choose 1 2 or 3
        int comp_choice_numb = r.nextInt(3) + 1;

        if (comp_choice_numb == 1) {
            computer_choice = "rock";
        } else if (comp_choice_numb == 2) {
            computer_choice = "scissors";
        } else if (comp_choice_numb == 3) {
            computer_choice = "paper";
        }

        //set the computer image based on its choice
        if (computer_choice == "rock") {
            iv_compChoice.setImageResource(R.drawable.rock);
        } else if (computer_choice == "scissors") {
            iv_compChoice.setImageResource(R.drawable.scissors);
        } else if (computer_choice == "paper") {
            iv_compChoice.setImageResource(R.drawable.paper);
        }

        //compare the human and comp choices to determine who won
        if (computer_choice == player_choice) {
            return "Draw!";
        } else if (player_choice == "rock" && computer_choice == "scissors") {
            HumanScore++;
            return "Rock crushes scissors. You win!";
        } else if (computer_choice == "rock" && player_choice == "scissors") {
            CompScore++;
            return "Rock crushes scissors. Computer wins!";
        } else if (player_choice == "paper" && computer_choice == "rock") {
            HumanScore++;
            return "Paper covers rock. You win!";
        } else if (computer_choice == "paper" && player_choice == "rock") {
            CompScore++;
            return "Paper covers rock. Computer wins!";
        } else if (player_choice == "scissors" && computer_choice == "paper") {
            HumanScore++;
            return "Scissors cuts paper. You win!";
        } else if (computer_choice == "scissors" && player_choice == "paper") {
            CompScore++;
            return "Scissors cuts paper. Computer wins!";
        }
        else return "Error";


    }
}
