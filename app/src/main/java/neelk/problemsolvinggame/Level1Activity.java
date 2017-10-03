package neelk.problemsolvinggame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Level1Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = Level1Activity.class.getSimpleName();

    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ok, delete;
    private TextView p1, p2, p3, p4;
    private Problem pb1, pb2, pb3, pb4;
    int p;
    long v1, v2, v3, v4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        b0 = (Button) findViewById(R.id.id0);
        b1 = (Button) findViewById(R.id.id1);
        b2 = (Button) findViewById(R.id.id2);
        b3 = (Button) findViewById(R.id.id3);
        b4 = (Button) findViewById(R.id.id4);
        b5 = (Button) findViewById(R.id.id5);
        b6 = (Button) findViewById(R.id.id6);
        b7 = (Button) findViewById(R.id.id7);
        b8 = (Button) findViewById(R.id.id8);
        b9 = (Button) findViewById(R.id.id9);
        delete = (Button) findViewById(R.id.delete);
        ok = (Button) findViewById(R.id.ok);

        p1 = (TextView) findViewById(R.id.p1);
        p2 = (TextView) findViewById(R.id.p2);
        p3 = (TextView) findViewById(R.id.p3);
        p4 = (TextView) findViewById(R.id.p4);

        pb1 = new Problem(10);
        pb2 = new Problem(10);
        pb3 = new Problem(10);
        pb4 = new Problem(10);

        pb1.create();
        pb2.create();
        pb3.create();
        pb4.create();

        p1.setText(pb1.getString(-1));
        p2.setText(pb2.getString(-1));
        p3.setText(pb3.getString(-1));
        p4.setText(pb4.getString(-1));

        v1 = -1;
        v2 = -1;
        v3 = -1;
        v4 = -1;

    }

    public void onClick(View view) {
        // Log.d(TAG, "NEEL: onClick");
        // int p = 0;
        if (view == p1) {
            p1.setTextAppearance(this, R.style.SelectedProblemStyle);
            p2.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p3.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p4.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p = 1;
        } else if (view == p2) {
            p2.setTextAppearance(this, R.style.SelectedProblemStyle);
            p1.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p3.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p4.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p = 2;
        } else if (view == p3) {
            p3.setTextAppearance(this, R.style.SelectedProblemStyle);
            p1.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p2.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p4.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p = 3;
        } else if (view == p4) {
            p4.setTextAppearance(this, R.style.SelectedProblemStyle);
            p1.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p2.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p3.setTextAppearance(this, R.style.UnSelectedProblemStyle);
            p = 4;
        } else if (view == delete) {
            if (p == 1) {
                v1 = -1;
                p1.setText(pb1.getString(-1));
            } else if (p == 2) {
                v2 = -1;
                p2.setText(pb2.getString(-1));
            } else if (p == 3) {
                v3 = -1;
                p3.setText(pb3.getString(-1));
            } else if (p == 4) {
                v4 = -1;
                p4.setText(pb4.getString(-1));
            }
        }

        else if (view == b0) {
            P(0);
        } else if (view == b1) {
            P(1);
        }else if (view == b2) {
            P(2);
        } else if (view == b3) {
            P(3);
        }else if (view == b4) {
            P(4);
        } else if (view == b5) {
            P(5);
        }else if (view == b6) {
            P(6);
        } else if (view == b7) {
            P(7);
        }else if (view == b8) {
            P(8);
        } else if (view == b9) {
            P(9);
        }
        else if(view == ok){
            OK();
        }
    }

    private void OK() {
       if (v1 == -1 || v2 == -1 || v3 == -1 || v4 == -1) {
        if (v1 == -1) {
            p1.setTextColor(Color.parseColor("#00EA00"));
        } else {
            pb1.checkSolution(v1);
        }

        if (v2 == -1) {
            p2.setTextColor(Color.parseColor("#00EA00"));
        } else {
            pb2.checkSolution(v2);
        }

        if (v3 == -1) {
            p3.setTextColor(Color.parseColor("#00EA00"));
        } else {
            pb3.checkSolution(v3);
        }

        if (v4 == -1) {
            p4.setTextColor(Color.parseColor("#00EA00"));
        } else {
            pb4.checkSolution(v4);
        }
    } else{
            if((pb1.checkSolution(v1) && pb2.checkSolution(v2) &&
                    pb3.checkSolution(v3) && pb4.checkSolution(v4)) == false){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("WRONG TRY AGAIN")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            } else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Well Done!")
                        .setCancelable(false)
                        .setPositiveButton("Home", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
    }

    public long Button(int i) {
        switch (p) {
            case 1:
                if (v1 == -1) {
                    v1 = i;
                } else {
                    v1 = (v1 * 10) + i;
                }
                return v1;

            case 2:
                if (v2 == -1) {
                    v2 = i;
                } else {
                    v2 = (v2 * 10) + i;
                }
                return v2;

            case 3:
                if (v3 == -1) {
                    v3 = i;
                } else {
                    v3 = (v3 * 10) + i;
                }
                return v3;

            default:
                if (v4 == -1) {
                    v4 = i;
                } else {
                    v4 = (v4 * 10) + i;
                }
                return v4;
        }
    }

    public void P (int i){
        if (p == 1) {
            p1.setText(pb1.getString(Button(i)));
            // p1.setText(valueString(i));
        } else if (p == 2) {
            p2.setText (pb2.getString(Button(i)));
        } else if (p == 3) {
            p3.setText(pb3.getString(Button(i)));
        } else if (p == 4) {
            p4.setText(pb4.getString(Button(i)));
        }
    }
}