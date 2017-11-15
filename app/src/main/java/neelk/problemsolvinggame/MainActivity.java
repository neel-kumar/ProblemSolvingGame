package neelk.problemsolvinggame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static neelk.problemsolvinggame.R.id.home;
import static neelk.problemsolvinggame.R.id.level1;
import static neelk.problemsolvinggame.R.id.level2;
import static neelk.problemsolvinggame.R.id.level3;
import static neelk.problemsolvinggame.R.id.level4;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button l1, l2, l3, l4;

    private EditText Home;
    int score;
    public int readScore(){
        SharedPreferences sharedPref = getSharedPreferences("TOTAL_SCORE", Context.MODE_PRIVATE);
        int Score = sharedPref.getInt("score", 0);
        return Score;
    }
    public void saveScore(int score){
        SharedPreferences sharedPref = getSharedPreferences("TOTAL_SCORE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("score", score);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        score = readScore();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 = findViewById(level1);
        l2 = findViewById(level2);
        l3 = findViewById(level3);
        l4 = findViewById(level4);
        Home = findViewById(home);
        Home.setText("Home              *" + score);
    }

    public void onBackPressed() {
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure ? ")
                    .setCancelable(false)
                /*    .setNeutralButton("Yay dude", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                       }

                    })*/
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @Override
    public void onClick(View view) {
        if (view == l1) {
            Log.d(TAG, "Starting level1 activity");
            //the transition from MainActivity to Level1Activity
            startActivity(new Intent(MainActivity.this, Level1Activity.class));
        } else if (view == l2) {
            Log.d(TAG, "Starting level2 activity");
            //the transition from MainActivity to Level2Activity
              startActivity(new Intent(MainActivity.this, Level2Activity.class));
        } else if (view == l3) {
            Log.d(TAG, "Starting level3 activity");
            //the transition from MainActivity to Level3Activity
            startActivity(new Intent(MainActivity.this, Level3Activity.class));
        }  else if (view == l4) {
            Log.d(TAG, "Starting level4 activity");
            //the transition from MainActivity to Level4Activity
            startActivity(new Intent(MainActivity.this, Level4Activity.class));
        }
        // saveScore(score);
    }

    @Override
    public void onResume() {
        super.onResume();
        Home.setText("Home              *" + readScore());
    }
}
