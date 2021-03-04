package com.example.scorerv2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    //instantiate variables
    public static int player1CurrentPoints = 0;
    public static int player2CurrentPoints = 0;
    public static int player1CurrentRebounds = 0;
    public static int player2CurrentRebounds = 0;
    public static int player1CurrentBlocks = 0;
    public static int player2CurrentBlocks = 0;
    public static int DanielCareerPoints = 0;
    public static int RaphCareerPoints = 0;
    public static int JoshCareerPoints = 0;
    public static int DadsCareerPoints = 0;
    public static int DanielCareerRebounds = 0;
    public static int RaphCareerRebounds = 0;
    public static int JoshCareerRebounds = 0;
    public static int DadsCareerRebounds = 0;
    public static int DanielCareerBlocks = 0;
    public static int RaphCareerBlocks = 0;
    public static int JoshCareerBlocks = 0;
    public static int DadsCareerBlocks = 0;
    public static int DanielWins = 0;
    public static int RaphWins = 0;
    public static int JoshWins = 0;
    public static int DadsWins = 0;
    public static int DanielLose = 0;
    public static int RaphLose = 0;
    public static int JoshLose = 0;
    public static int DadsLose = 0;

    //shared preferences
    public static final String PREFS_NAME = "MyPrefsFile";
    //dropdown(spinner)
    Spinner sp1;
    Spinner sp2;
    String players1[] = {"Daniel","Raph","Josh","Dads"};
    String players2[] = {"Daniel","Raph","Josh","Dads"};
    ArrayAdapter <String> adapter;
    String selectedPlayer1 = "";
    String selectedPlayer2 = "";
    //intent
    TextView daniel_pts_view_career;
    TextView raph_pts_view_career;
    TextView josh_pts_view_career;
    TextView dads_pts_view_career;
    TextView daniel_rebs_view_career;
    TextView raph_rebs_view_career;
    TextView josh_rebs_view_career;
    TextView dads_rebs_view_career;
    TextView daniel_blks_view_career;
    TextView raph_blks_view_career;
    TextView josh_blks_view_career;
    TextView dads_blks_view_career;
    TextView daniel_wins_view_career;
    TextView raph_wins_view_career;
    TextView josh_wins_view_career;
    TextView dads_wins_view_career;
    TextView daniel_lose_view_career;
    TextView raph_lose_view_career;
    TextView josh_lose_view_career;
    TextView dads_lose_view_career;
    Button button_stats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //shared preferences//
        //daniel
        SharedPreferences settings1 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings2 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings3 = getSharedPreferences(PREFS_NAME,0);
        //raph
        SharedPreferences settings4 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings5 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings6 = getSharedPreferences(PREFS_NAME,0);
        //josh
        SharedPreferences settings7 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings8 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings9 = getSharedPreferences(PREFS_NAME,0);
        //dads
        SharedPreferences settings10 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings11 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings12 = getSharedPreferences(PREFS_NAME,0);
        //win-drjd-lose-drjd
        SharedPreferences settings13 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings14 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings15 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings16 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings17 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings18 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings19 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences settings20 = getSharedPreferences(PREFS_NAME,0);
        DanielCareerPoints=settings1.getInt("DanielCareerPoints",DanielCareerPoints);
        DanielCareerRebounds=settings2.getInt("DanielCareerRebounds",DanielCareerRebounds);
        DanielCareerBlocks=settings3.getInt("DanielCareerBlocks",DanielCareerBlocks);
        RaphCareerPoints=settings4.getInt("RaphCareerPoints",RaphCareerPoints);
        RaphCareerRebounds=settings5.getInt("RaphCareerRebounds",RaphCareerRebounds);
        RaphCareerBlocks=settings6.getInt("RaphCareerBlocks",RaphCareerBlocks);
        JoshCareerPoints=settings7.getInt("JoshCareerPoints",JoshCareerPoints);
        JoshCareerRebounds=settings8.getInt("JoshCareerRebounds",JoshCareerRebounds);
        JoshCareerBlocks=settings9.getInt("JoshCareerBlocks",JoshCareerBlocks);
        DadsCareerPoints=settings10.getInt("DadsCareerPoints",DadsCareerPoints);
        DadsCareerRebounds=settings11.getInt("DadsCareerRebounds",DadsCareerRebounds);
        DadsCareerBlocks=settings12.getInt("DadsCareerBlocks",DadsCareerBlocks);
        //winlose
        DanielWins=settings13.getInt("DanielWins",DanielWins);
        RaphWins=settings14.getInt("RaphWins",RaphWins);
        JoshWins=settings15.getInt("JoshWins",JoshWins);
        DadsWins=settings16.getInt("DadsWins",DadsWins);
        DanielLose=settings17.getInt("DanielLose",DanielLose);
        RaphLose=settings18.getInt("RaphLose",RaphLose);
        JoshLose=settings19.getInt("JoshLose",JoshLose);
        DadsLose=settings20.getInt("DadsLose",DadsLose);
        //update career point, reb, blk display
        TextView DanielCareerPointsView = (TextView) findViewById(R.id.daniel_pts_view_career);
        DanielCareerPointsView.setText(String.valueOf(DanielCareerPoints));
        TextView DanielCareerReboundsView = (TextView) findViewById(R.id.daniel_rebs_view_career);
        DanielCareerReboundsView.setText(String.valueOf(DanielCareerRebounds));
        TextView DanielCareerBlocksView = (TextView) findViewById(R.id.daniel_blks_view_career);
        DanielCareerBlocksView.setText(String.valueOf(DanielCareerBlocks));
        TextView RaphCareerPointsView = (TextView) findViewById(R.id.raph_pts_view_career);
        RaphCareerPointsView.setText(String.valueOf(RaphCareerPoints));
        TextView RaphCareerReboundsView = (TextView) findViewById(R.id.raph_rebs_view_career);
        RaphCareerReboundsView.setText(String.valueOf(RaphCareerRebounds));
        TextView RaphCareerBlocksView = (TextView) findViewById(R.id.raph_blks_view_career);
        RaphCareerBlocksView.setText(String.valueOf(RaphCareerBlocks));
        TextView JoshCareerPointsView = (TextView) findViewById(R.id.josh_pts_view_career);
        JoshCareerPointsView.setText(String.valueOf(JoshCareerPoints));
        TextView JoshCareerReboundsView = (TextView) findViewById(R.id.josh_rebs_view_career);
        JoshCareerReboundsView.setText(String.valueOf(JoshCareerRebounds));
        TextView JoshCareerBlocksView = (TextView) findViewById(R.id.josh_blks_view_career);
        JoshCareerBlocksView.setText(String.valueOf(JoshCareerBlocks));
        TextView DadsCareerPointsView = (TextView) findViewById(R.id.dads_pts_view_career);
        DadsCareerPointsView.setText(String.valueOf(DadsCareerPoints));
        TextView DadsCareerReboundsView = (TextView) findViewById(R.id.dads_rebs_view_career);
        DadsCareerReboundsView.setText(String.valueOf(DadsCareerRebounds));
        TextView DadsCareerBlocksView = (TextView) findViewById(R.id.dads_blks_view_career);
        DadsCareerBlocksView.setText(String.valueOf(DadsCareerBlocks));
        //winlose
        TextView DanielWinsView = (TextView) findViewById(R.id.daniel_wins_view_career);
        DanielWinsView.setText(String.valueOf(DanielWins));
        TextView RaphWinsView = (TextView) findViewById(R.id.raph_wins_view_career);
        RaphWinsView.setText(String.valueOf(RaphWins));
        TextView JoshWinsView = (TextView) findViewById(R.id.josh_wins_view_career);
        JoshWinsView.setText(String.valueOf(JoshWins));
        TextView DadsWinsView = (TextView) findViewById(R.id.dads_wins_view_career);
        DadsWinsView.setText(String.valueOf(DadsWins));
        TextView DanielLoseView = (TextView) findViewById(R.id.daniel_lose_view_career);
        DanielLoseView.setText(String.valueOf(DanielLose));
        TextView RaphLoseView = (TextView) findViewById(R.id.raph_lose_view_career);
        RaphLoseView.setText(String.valueOf(RaphLose));
        TextView JoshLoseView = (TextView) findViewById(R.id.josh_lose_view_career);
        JoshLoseView.setText(String.valueOf(JoshLose));
        TextView DadsLoseView = (TextView) findViewById(R.id.dads_lose_view_career);
        DadsLoseView.setText(String.valueOf(DadsLose));
        //spinner1
        Spinner sp1 = (Spinner) findViewById(R.id.player1_spinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,players1);
        sp1.setAdapter(adapter);
        //spinner method
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //use position value
                switch (position) {
                    case 0:
                        selectedPlayer1 = "Daniel";
                        break;
                    case 1:
                        selectedPlayer1 = "Raph";
                        break;
                    case 2:
                        selectedPlayer1 = "Josh";
                        break;
                    case 3:
                        selectedPlayer1 = "Dads";
                        break;
                }
                TextView player1View = (TextView) findViewById(R.id.player1_selected_view);
                player1View.setText(String.valueOf(selectedPlayer1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //spinner2
        Spinner sp2 = (Spinner) findViewById(R.id.player2_spinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,players2);
        sp2.setAdapter(adapter);
        //spinner2 method
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //use position value
                switch (position) {
                    case 0:
                        selectedPlayer2 = "Daniel";
                        break;
                    case 1:
                        selectedPlayer2 = "Raph";
                        break;
                    case 2:
                        selectedPlayer2 = "Josh";
                        break;
                    case 3:
                        selectedPlayer2 = "Dads";
                        break;
                }
                TextView player2View = (TextView) findViewById(R.id.player2_selected_view);
                player2View.setText(String.valueOf(selectedPlayer2));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //intent
        daniel_pts_view_career = (TextView) findViewById(R.id.daniel_pts_view_career);
        daniel_rebs_view_career = (TextView) findViewById(R.id.daniel_rebs_view_career);
        daniel_blks_view_career = (TextView) findViewById(R.id.daniel_blks_view_career);
        raph_pts_view_career = (TextView) findViewById(R.id.raph_pts_view_career);
        raph_rebs_view_career = (TextView) findViewById(R.id.raph_rebs_view_career);
        raph_blks_view_career = (TextView) findViewById(R.id.raph_blks_view_career);
        josh_pts_view_career = (TextView) findViewById(R.id.josh_pts_view_career);
        josh_rebs_view_career = (TextView) findViewById(R.id.josh_rebs_view_career);
        josh_blks_view_career = (TextView) findViewById(R.id.josh_blks_view_career);
        dads_pts_view_career = (TextView) findViewById(R.id.dads_pts_view_career);
        dads_rebs_view_career = (TextView) findViewById(R.id.dads_rebs_view_career);
        dads_blks_view_career = (TextView) findViewById(R.id.dads_blks_view_career);
        daniel_wins_view_career = (TextView) findViewById(R.id.daniel_wins_view_career);
        raph_wins_view_career = (TextView) findViewById(R.id.raph_wins_view_career);
        josh_wins_view_career = (TextView) findViewById(R.id.josh_wins_view_career);
        dads_wins_view_career = (TextView) findViewById(R.id.dads_wins_view_career);
        daniel_lose_view_career = (TextView) findViewById(R.id.daniel_lose_view_career);
        raph_lose_view_career = (TextView) findViewById(R.id.raph_lose_view_career);
        josh_lose_view_career = (TextView) findViewById(R.id.josh_lose_view_career);
        dads_lose_view_career = (TextView) findViewById(R.id.dads_lose_view_career);
        button_stats = (Button) findViewById(R.id.button_stats);
        button_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStats();
            }
        });
    }

    //player1 actions
    public void player1PlusPoint(View view) {
        player1CurrentPoints = player1CurrentPoints + 1;
        player1UpdatePoints(player1CurrentPoints);
    }
    private void player1UpdatePoints(int c_p1pts) {
        TextView player1CurrentPointsView = (TextView) findViewById(R.id.player1_pts_view_current);
        player1CurrentPointsView.setText(String.valueOf(c_p1pts));
    }
    public void player1PlusRebound(View view) {
        player1CurrentRebounds = player1CurrentRebounds + 1;
        player1UpdateRebounds(player1CurrentRebounds);
    }
    private void player1UpdateRebounds(int c_p1rebs) {
        TextView player1CurrentReboundsView = (TextView) findViewById(R.id.player1_rebs_view_current);
        player1CurrentReboundsView.setText(String.valueOf(c_p1rebs));
    }
    public void player1PlusBlock(View view) {
        player1CurrentBlocks = player1CurrentBlocks + 1;
        player1UpdateBlocks(player1CurrentBlocks);
    }
    private void player1UpdateBlocks(int c_p1blks) {
        TextView player1CurrentBlocksView = (TextView) findViewById(R.id.player1_blks_view_current);
        player1CurrentBlocksView.setText(String.valueOf(c_p1blks));
    }

    //player2 actions
    public void player2PlusPoint(View view) {
        player2CurrentPoints = player2CurrentPoints + 1;
        player2UpdatePoints(player2CurrentPoints);
    }
    private void player2UpdatePoints(int c_p2pts) {
        TextView player2CurrentPointsView = (TextView) findViewById(R.id.player2_pts_view_current);
        player2CurrentPointsView.setText(String.valueOf(c_p2pts));
    }
    public void player2PlusRebound(View view) {
        player2CurrentRebounds = player2CurrentRebounds + 1;
        player2UpdateRebounds(player2CurrentRebounds);
    }
    private void player2UpdateRebounds(int c_p2rebs) {
        TextView player2CurrentReboundsView = (TextView) findViewById(R.id.player2_rebs_view_current);
        player2CurrentReboundsView.setText(String.valueOf(c_p2rebs));
    }
    public void player2PlusBlock(View view) {
        player2CurrentBlocks = player2CurrentBlocks + 1;
        player2UpdateBlocks(player2CurrentBlocks);
    }
    private void player2UpdateBlocks(int c_p2blks) {
        TextView player2CurrentBlocksView = (TextView) findViewById(R.id.player2_blks_view_current);
        player2CurrentBlocksView.setText(String.valueOf(c_p2blks));
    }

    public void resetCurrent(View view) {
        //reset values of current//
        player1CurrentPoints = 0;
        player1UpdatePoints(0);
        player1CurrentRebounds = 0;
        player1UpdateRebounds(0);
        player1CurrentBlocks = 0;
        player1UpdateBlocks(0);
        player2CurrentPoints = 0;
        player2UpdatePoints(0);
        player2CurrentRebounds = 0;
        player2UpdateRebounds(0);
        player2CurrentBlocks = 0;
        player2UpdateBlocks(0);
    }

    public void save(View view) {
        Toast.makeText(this, "Stats Updated", Toast.LENGTH_LONG).show();
        if (selectedPlayer1 == "Daniel") {
            DanielCareerPoints = DanielCareerPoints + player1CurrentPoints;
            SharedPreferences settings1 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putInt("DanielCareerPoints", DanielCareerPoints);
            editor.commit();
            TextView DanielCareerPointsView = (TextView) findViewById(R.id.daniel_pts_view_career);
            DanielCareerPointsView.setText(String.valueOf(DanielCareerPoints));

            DanielCareerRebounds = DanielCareerRebounds + player1CurrentRebounds;
            SharedPreferences settings2 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor2 = settings2.edit();
            editor2.putInt("DanielCareerRebounds", DanielCareerRebounds);
            editor2.commit();
            TextView DanielCareerReboundsView = (TextView) findViewById(R.id.daniel_rebs_view_career);
            DanielCareerReboundsView.setText(String.valueOf(DanielCareerRebounds));
            player1CurrentRebounds = 0;
            player1UpdateRebounds(0);

            DanielCareerBlocks = DanielCareerBlocks + player1CurrentBlocks;
            SharedPreferences settings3 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor3 = settings3.edit();
            editor3.putInt("DanielCareerBlocks", DanielCareerBlocks);
            editor3.commit();
            TextView DanielCareerBlocksView = (TextView) findViewById(R.id.daniel_blks_view_career);
            DanielCareerBlocksView.setText(String.valueOf(DanielCareerBlocks));
            //reset current//
            player1CurrentBlocks = 0;
            player1UpdateBlocks(0);

            if (player1CurrentPoints > player2CurrentPoints) {
                DanielWins = DanielWins + 1;
                SharedPreferences settings13 = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor13 = settings13.edit();
                editor13.putInt("DanielWins", DanielWins);
                editor13.commit();
                TextView DanielWinsView = (TextView) findViewById(R.id.daniel_wins_view_career);
                DanielWinsView.setText(String.valueOf(DanielWins));
            } else if (player2CurrentPoints > player1CurrentPoints) {
                DanielLose = DanielLose + 1;
                SharedPreferences settings17 = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor17 = settings17.edit();
                editor17.putInt("DanielLose", DanielLose);
                editor17.commit();
                TextView DanielLoseView = (TextView) findViewById(R.id.daniel_lose_view_career);
                DanielLoseView.setText(String.valueOf(DanielLose));
            }
        } else if (selectedPlayer1 == "Raph") {
            RaphCareerPoints = RaphCareerPoints + player1CurrentPoints;
            SharedPreferences settings4 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor4 = settings4.edit();
            editor4.putInt("RaphCareerPoints", RaphCareerPoints);
            editor4.commit();
            TextView RaphCareerPointsView = (TextView) findViewById(R.id.raph_pts_view_career);
            RaphCareerPointsView.setText(String.valueOf(RaphCareerPoints));

            RaphCareerRebounds = RaphCareerRebounds + player1CurrentRebounds;
            SharedPreferences settings5 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor5 = settings5.edit();
            editor5.putInt("RaphCareerRebounds", RaphCareerRebounds);
            editor5.commit();
            TextView RaphCareerReboundsView = (TextView) findViewById(R.id.raph_rebs_view_career);
            RaphCareerReboundsView.setText(String.valueOf(RaphCareerRebounds));
            player1CurrentRebounds = 0;
            player1UpdateRebounds(0);

            RaphCareerBlocks = RaphCareerBlocks + player1CurrentBlocks;
            SharedPreferences settings6 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor6 = settings6.edit();
            editor6.putInt("RaphCareerBlocks", RaphCareerBlocks);
            editor6.commit();
            TextView RaphCareerBlocksView = (TextView) findViewById(R.id.raph_blks_view_career);
            RaphCareerBlocksView.setText(String.valueOf(RaphCareerBlocks));
            //reset current//
            player1CurrentBlocks = 0;
            player1UpdateBlocks(0);

            if (player1CurrentPoints > player2CurrentPoints) {
                RaphWins = RaphWins + 1;
                SharedPreferences settings14 = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor14 = settings14.edit();
                editor14.putInt("RaphWins", RaphWins);
                editor14.commit();
                TextView RaphWinsView = (TextView) findViewById(R.id.raph_wins_view_career);
                RaphWinsView.setText(String.valueOf(RaphWins));
            } else if (player2CurrentPoints > player1CurrentPoints) {
                RaphLose = RaphLose + 1;
                SharedPreferences settings18 = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor18 = settings18.edit();
                editor18.putInt("RaphLose", RaphLose);
                editor18.commit();
                TextView RaphLoseView = (TextView) findViewById(R.id.raph_lose_view_career);
                RaphLoseView.setText(String.valueOf(RaphLose));
            }
        } else if (selectedPlayer1 == "Josh") {
            JoshCareerPoints = JoshCareerPoints + player1CurrentPoints;
            SharedPreferences settings7 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor7 = settings7.edit();
            editor7.putInt("JoshCareerPoints", JoshCareerPoints);
            editor7.commit();
            TextView JoshCareerPointsView = (TextView) findViewById(R.id.josh_pts_view_career);
            JoshCareerPointsView.setText(String.valueOf(JoshCareerPoints));

            JoshCareerRebounds = JoshCareerRebounds + player1CurrentRebounds;
            SharedPreferences settings8 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor8 = settings8.edit();
            editor8.putInt("JoshCareerRebounds", JoshCareerRebounds);
            editor8.commit();
            TextView JoshCareerReboundsView = (TextView) findViewById(R.id.josh_rebs_view_career);
            JoshCareerReboundsView.setText(String.valueOf(JoshCareerRebounds));
            player1CurrentRebounds = 0;
            player1UpdateRebounds(0);

            JoshCareerBlocks = JoshCareerBlocks + player1CurrentBlocks;
            SharedPreferences settings9 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor9 = settings9.edit();
            editor9.putInt("JoshCareerBlocks", JoshCareerBlocks);
            editor9.commit();
            TextView JoshCareerBlocksView = (TextView) findViewById(R.id.josh_blks_view_career);
            JoshCareerBlocksView.setText(String.valueOf(JoshCareerBlocks));
            //reset current//
            player1CurrentBlocks = 0;
            player1UpdateBlocks(0);

            if (player1CurrentPoints > player2CurrentPoints) {
                JoshWins = JoshWins + 1;
                SharedPreferences settings15 = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor15 = settings15.edit();
                editor15.putInt("JoshWins", JoshWins);
                editor15.commit();
                TextView JoshWinsView = (TextView) findViewById(R.id.josh_wins_view_career);
                JoshWinsView.setText(String.valueOf(JoshWins));
            } else if (player2CurrentPoints > player1CurrentPoints) {
                JoshLose = JoshLose + 1;
                SharedPreferences settings19 = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor19 = settings19.edit();
                editor19.putInt("JoshLose", JoshLose);
                editor19.commit();
                TextView JoshLoseView = (TextView) findViewById(R.id.josh_lose_view_career);
                JoshLoseView.setText(String.valueOf(JoshLose));
            }
        } else if (selectedPlayer1 == "Dads") {
            DadsCareerPoints = DadsCareerPoints + player1CurrentPoints;
            SharedPreferences settings10 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor10 = settings10.edit();
            editor10.putInt("DadsCareerPoints", DadsCareerPoints);
            editor10.commit();
            TextView DadsCareerPointsView = (TextView) findViewById(R.id.dads_pts_view_career);
            DadsCareerPointsView.setText(String.valueOf(DadsCareerPoints));

            DadsCareerRebounds = DadsCareerRebounds + player1CurrentRebounds;
            SharedPreferences settings11 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor11 = settings11.edit();
            editor11.putInt("DadsCareerRebounds", DadsCareerRebounds);
            editor11.commit();
            TextView DadsCareerReboundsView = (TextView) findViewById(R.id.dads_rebs_view_career);
            DadsCareerReboundsView.setText(String.valueOf(DadsCareerRebounds));
            player1CurrentRebounds = 0;
            player1UpdateRebounds(0);

            DadsCareerBlocks = DadsCareerBlocks + player1CurrentBlocks;
            SharedPreferences settings12 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor12 = settings12.edit();
            editor12.putInt("DadsCareerBlocks", DadsCareerBlocks);
            editor12.commit();
            TextView DadsCareerBlocksView = (TextView) findViewById(R.id.dads_blks_view_career);
            DadsCareerBlocksView.setText(String.valueOf(DadsCareerBlocks));
            //reset current//
            player1CurrentBlocks = 0;
            player1UpdateBlocks(0);

            if (player1CurrentPoints > player2CurrentPoints) {
                DadsWins = DadsWins + 1;
                SharedPreferences settings16 = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor16 = settings16.edit();
                editor16.putInt("DadsWins", DadsWins);
                editor16.commit();
                TextView DadsWinsView = (TextView) findViewById(R.id.dads_wins_view_career);
                DadsWinsView.setText(String.valueOf(DadsWins));
            } else if (player2CurrentPoints > player1CurrentPoints) {
                DadsLose = DadsLose + 1;
                SharedPreferences settings20 = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor20 = settings20.edit();
                editor20.putInt("DadsLose", DadsLose);
                editor20.commit();
                TextView DadsLoseView = (TextView) findViewById(R.id.dads_lose_view_career);
                DadsLoseView.setText(String.valueOf(DadsLose));
            }
        }

        if (selectedPlayer2 == "Daniel") {
            DanielCareerPoints = DanielCareerPoints + player2CurrentPoints;
            SharedPreferences settings1 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putInt("DanielCareerPoints", DanielCareerPoints);
            editor.commit();
            TextView DanielCareerPointsView = (TextView) findViewById(R.id.daniel_pts_view_career);
            DanielCareerPointsView.setText(String.valueOf(DanielCareerPoints));

            DanielCareerRebounds = DanielCareerRebounds + player2CurrentRebounds;
            SharedPreferences settings2 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor2 = settings2.edit();
            editor2.putInt("DanielCareerRebounds", DanielCareerRebounds);
            editor2.commit();
            TextView DanielCareerReboundsView = (TextView) findViewById(R.id.daniel_rebs_view_career);
            DanielCareerReboundsView.setText(String.valueOf(DanielCareerRebounds));
            player2CurrentRebounds = 0;
            player2UpdateRebounds(0);

            DanielCareerBlocks = DanielCareerBlocks + player2CurrentBlocks;
            SharedPreferences settings3 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor3 = settings3.edit();
            editor3.putInt("DanielCareerBlocks", DanielCareerBlocks);
            editor3.commit();
            TextView DanielCareerBlocksView = (TextView) findViewById(R.id.daniel_blks_view_career);
            DanielCareerBlocksView.setText(String.valueOf(DanielCareerBlocks));
            player2CurrentBlocks = 0;
            player2UpdateBlocks(0);

            if (player2CurrentPoints > player1CurrentPoints) {
                DanielWins = DanielWins + 1;
                SharedPreferences settings13 = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor13 = settings13.edit();
                editor13.putInt("DanielWins", DanielWins);
                editor13.commit();
                TextView DanielWinsView = (TextView) findViewById(R.id.daniel_wins_view_career);
                DanielWinsView.setText(String.valueOf(DanielWins));
            } else if (player1CurrentPoints > player2CurrentPoints) {
                DanielLose = DanielLose + 1;
                SharedPreferences settings17 = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor17 = settings17.edit();
                editor17.putInt("DanielLose", DanielLose);
                editor17.commit();
                TextView DanielLoseView = (TextView) findViewById(R.id.daniel_lose_view_career);
                DanielLoseView.setText(String.valueOf(DanielLose));
            }

        } else if (selectedPlayer2 == "Raph") {
            RaphCareerPoints = RaphCareerPoints + player2CurrentPoints;
            SharedPreferences settings4 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor4 = settings4.edit();
            editor4.putInt("RaphCareerPoints", RaphCareerPoints);
            editor4.commit();
            TextView RaphCareerPointsView = (TextView) findViewById(R.id.raph_pts_view_career);
            RaphCareerPointsView.setText(String.valueOf(RaphCareerPoints));

            RaphCareerRebounds = RaphCareerRebounds + player2CurrentRebounds;
            SharedPreferences settings5 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor5 = settings5.edit();
            editor5.putInt("RaphCareerRebounds", RaphCareerRebounds);
            editor5.commit();
            TextView RaphCareerReboundsView = (TextView) findViewById(R.id.raph_rebs_view_career);
            RaphCareerReboundsView.setText(String.valueOf(RaphCareerRebounds));
            player2CurrentRebounds = 0;
            player2UpdateRebounds(0);

            RaphCareerBlocks = RaphCareerBlocks + player2CurrentBlocks;
            SharedPreferences settings6 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor6 = settings6.edit();
            editor6.putInt("RaphCareerBlocks", RaphCareerBlocks);
            editor6.commit();
            TextView RaphCareerBlocksView = (TextView) findViewById(R.id.raph_blks_view_career);
            RaphCareerBlocksView.setText(String.valueOf(RaphCareerBlocks));
            //reset current//
            player2CurrentBlocks = 0;
            player2UpdateBlocks(0);

            if (player2CurrentPoints > player1CurrentPoints) {
                RaphWins = RaphWins + 1;
                SharedPreferences settings14 = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor14 = settings14.edit();
                editor14.putInt("RaphWins", RaphWins);
                editor14.commit();
                TextView RaphWinsView = (TextView) findViewById(R.id.raph_wins_view_career);
                RaphWinsView.setText(String.valueOf(RaphWins));
            } else if (player1CurrentPoints > player2CurrentPoints) {
                RaphLose = RaphLose + 1;
                SharedPreferences settings18 = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor18 = settings18.edit();
                editor18.putInt("RaphLose", RaphLose);
                editor18.commit();
                TextView RaphLoseView = (TextView) findViewById(R.id.raph_lose_view_career);
                RaphLoseView.setText(String.valueOf(RaphLose));
            }

        } else if (selectedPlayer2 == "Josh") {
            JoshCareerPoints = JoshCareerPoints + player2CurrentPoints;
            SharedPreferences settings7 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor7 = settings7.edit();
            editor7.putInt("JoshCareerPoints", JoshCareerPoints);
            editor7.commit();
            TextView JoshCareerPointsView = (TextView) findViewById(R.id.josh_pts_view_career);
            JoshCareerPointsView.setText(String.valueOf(JoshCareerPoints));

            JoshCareerRebounds = JoshCareerRebounds + player2CurrentRebounds;
            SharedPreferences settings8 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor8 = settings8.edit();
            editor8.putInt("JoshCareerRebounds", JoshCareerRebounds);
            editor8.commit();
            TextView JoshCareerReboundsView = (TextView) findViewById(R.id.josh_rebs_view_career);
            JoshCareerReboundsView.setText(String.valueOf(JoshCareerRebounds));
            player2CurrentRebounds = 0;
            player2UpdateRebounds(0);

            JoshCareerBlocks = JoshCareerBlocks + player2CurrentBlocks;
            SharedPreferences settings9 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor9 = settings9.edit();
            editor9.putInt("JoshCareerBlocks", JoshCareerBlocks);
            editor9.commit();
            TextView JoshCareerBlocksView = (TextView) findViewById(R.id.josh_blks_view_career);
            JoshCareerBlocksView.setText(String.valueOf(JoshCareerBlocks));
            player2CurrentBlocks = 0;
            player2UpdateBlocks(0);

            if (player2CurrentPoints > player1CurrentPoints) {
                JoshWins = JoshWins + 1;
                SharedPreferences settings15 = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor15 = settings15.edit();
                editor15.putInt("JoshWins", JoshWins);
                editor15.commit();
                TextView JoshWinsView = (TextView) findViewById(R.id.josh_wins_view_career);
                JoshWinsView.setText(String.valueOf(JoshWins));
            } else if (player1CurrentPoints > player2CurrentPoints) {
                JoshLose = JoshLose + 1;
                SharedPreferences settings19 = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor19 = settings19.edit();
                editor19.putInt("JoshLose", JoshLose);
                editor19.commit();
                TextView JoshLoseView = (TextView) findViewById(R.id.josh_lose_view_career);
                JoshLoseView.setText(String.valueOf(JoshLose));
            }

        } else if (selectedPlayer2 == "Dads") {
            DadsCareerPoints = DadsCareerPoints + player2CurrentPoints;
            SharedPreferences settings10 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor10 = settings10.edit();
            editor10.putInt("DadsCareerPoints", DadsCareerPoints);
            editor10.commit();
            TextView DadsCareerPointsView = (TextView) findViewById(R.id.dads_pts_view_career);
            DadsCareerPointsView.setText(String.valueOf(DadsCareerPoints));

            DadsCareerRebounds = DadsCareerRebounds + player2CurrentRebounds;
            SharedPreferences settings11 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor11 = settings11.edit();
            editor11.putInt("DadsCareerRebounds", DadsCareerRebounds);
            editor11.commit();
            TextView DadsCareerReboundsView = (TextView) findViewById(R.id.dads_rebs_view_career);
            DadsCareerReboundsView.setText(String.valueOf(DadsCareerRebounds));
            player2CurrentRebounds = 0;
            player2UpdateRebounds(0);

            DadsCareerBlocks = DadsCareerBlocks + player2CurrentBlocks;
            SharedPreferences settings12 = getSharedPreferences(PREFS_NAME,0);
            SharedPreferences.Editor editor12 = settings12.edit();
            editor12.putInt("DadsCareerBlocks", DadsCareerBlocks);
            editor12.commit();
            TextView DadsCareerBlocksView = (TextView) findViewById(R.id.dads_blks_view_career);
            DadsCareerBlocksView.setText(String.valueOf(DadsCareerBlocks));
            //reset current//
            player2CurrentBlocks = 0;
            player2UpdateBlocks(0);

            if (player2CurrentPoints > player1CurrentPoints) {
                DadsWins = DadsWins + 1;
                SharedPreferences settings16 = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor16 = settings16.edit();
                editor16.putInt("DadsWins", DadsWins);
                editor16.commit();
                TextView DadsWinsView = (TextView) findViewById(R.id.dads_wins_view_career);
                DadsWinsView.setText(String.valueOf(DadsWins));
            } else if (player1CurrentPoints > player2CurrentPoints) {
                DadsLose = DadsLose + 1;
                SharedPreferences settings20 = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor20 = settings20.edit();
                editor20.putInt("DadsLose", DadsLose);
                editor20.commit();
                TextView DadsLoseView = (TextView) findViewById(R.id.dads_lose_view_career);
                DadsLoseView.setText(String.valueOf(DadsLose));
            }
        }
        player1CurrentPoints = 0;
        player1UpdatePoints(0);
        player2CurrentPoints = 0;
        player2UpdatePoints(0);
    }

    public void openStats() {
        // open page
        Intent intent = new Intent(this, Main2Activity.class);
        // create and pass stats
        String danielPointsIntent = daniel_pts_view_career.getText().toString();
        intent.putExtra("daniel_PointsIntent", danielPointsIntent);
        String danielReboundsIntent = daniel_rebs_view_career.getText().toString();
        intent.putExtra("daniel_ReboundsIntent", danielReboundsIntent);
        String danielBlocksIntent = daniel_blks_view_career.getText().toString();
        intent.putExtra("daniel_BlocksIntent", danielBlocksIntent);
        String raphPointsIntent = raph_pts_view_career.getText().toString();
        intent.putExtra("raph_PointsIntent", raphPointsIntent);
        String raphReboundsIntent = raph_rebs_view_career.getText().toString();
        intent.putExtra("raph_ReboundsIntent", raphReboundsIntent);
        String raphBlocksIntent = raph_blks_view_career.getText().toString();
        intent.putExtra("raph_BlocksIntent", raphBlocksIntent);
        String joshPointsIntent = josh_pts_view_career.getText().toString();
        intent.putExtra("josh_PointsIntent", joshPointsIntent);
        String joshReboundsIntent = josh_rebs_view_career.getText().toString();
        intent.putExtra("josh_ReboundsIntent", joshReboundsIntent);
        String joshBlocksIntent = josh_blks_view_career.getText().toString();
        intent.putExtra("josh_BlocksIntent", joshBlocksIntent);
        String dadsPointsIntent = dads_pts_view_career.getText().toString();
        intent.putExtra("dads_PointsIntent", dadsPointsIntent);
        String dadsReboundsIntent = dads_rebs_view_career.getText().toString();
        intent.putExtra("dads_ReboundsIntent", dadsReboundsIntent);
        String dadsBlocksIntent = dads_blks_view_career.getText().toString();
        intent.putExtra("dads_BlocksIntent", dadsBlocksIntent);
        //winlose
        String danielWinsIntent = daniel_wins_view_career.getText().toString();
        intent.putExtra("daniel_WinsIntent", danielWinsIntent);
        String raphWinsIntent = raph_wins_view_career.getText().toString();
        intent.putExtra("raph_WinsIntent", raphWinsIntent);
        String joshWinsIntent = josh_wins_view_career.getText().toString();
        intent.putExtra("josh_WinsIntent", joshWinsIntent);
        String dadsWinsIntent = dads_wins_view_career.getText().toString();
        intent.putExtra("dads_WinsIntent", dadsWinsIntent);
        String danielLoseIntent = daniel_lose_view_career.getText().toString();
        intent.putExtra("daniel_LoseIntent", danielLoseIntent);
        String raphLoseIntent = raph_lose_view_career.getText().toString();
        intent.putExtra("raph_LoseIntent", raphLoseIntent);
        String joshLoseIntent = josh_lose_view_career.getText().toString();
        intent.putExtra("josh_LoseIntent", joshLoseIntent);
        String dadsLoseIntent = dads_lose_view_career.getText().toString();
        intent.putExtra("dads_LoseIntent", dadsLoseIntent);

        //execute
        startActivity(intent);
    }

    public void hardReset(View view) {
        //reset values of current//
        player1CurrentPoints = 0;
        player1UpdatePoints(0);
        player1CurrentRebounds = 0;
        player1UpdateRebounds(0);
        player1CurrentBlocks = 0;
        player1UpdateBlocks(0);
        player2CurrentPoints = 0;
        player2UpdatePoints(0);
        player2CurrentRebounds = 0;
        player2UpdateRebounds(0);
        player2CurrentBlocks = 0;
        player2UpdateBlocks(0);
        //shared preferences//
        DanielCareerPoints = 0;
        SharedPreferences settings1 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = settings1.edit();
        editor.putInt("DanielCareerPoints", DanielCareerPoints);
        editor.commit();
        TextView DanielCareerPointsView = (TextView) findViewById(R.id.daniel_pts_view_career);
        DanielCareerPointsView.setText(String.valueOf(DanielCareerPoints));
        DanielCareerRebounds = 0;
        SharedPreferences settings2 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor2 = settings2.edit();
        editor2.putInt("DanielCareerRebounds", DanielCareerRebounds);
        editor2.commit();
        TextView DanielCareerReboundsView = (TextView) findViewById(R.id.daniel_rebs_view_career);
        DanielCareerReboundsView.setText(String.valueOf(DanielCareerRebounds));
        DanielCareerBlocks = 0;
        SharedPreferences settings3 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor3 = settings3.edit();
        editor3.putInt("DanielCareerBlocks", DanielCareerBlocks);
        editor3.commit();
        TextView DanielCareerBlocksView = (TextView) findViewById(R.id.daniel_blks_view_career);
        DanielCareerBlocksView.setText(String.valueOf(DanielCareerBlocks));
        DanielWins = 0;
        SharedPreferences settings13 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor13 = settings13.edit();
        editor13.putInt("DanielWins", DanielWins);
        editor13.commit();
        TextView DanielWinsView = (TextView) findViewById(R.id.daniel_wins_view_career);
        DanielWinsView.setText(String.valueOf(DanielWins));
        DanielLose = 0;
        SharedPreferences settings17 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor17 = settings17.edit();
        editor17.putInt("DanielLose", DanielLose);
        editor17.commit();
        TextView DanielLoseView = (TextView) findViewById(R.id.daniel_lose_view_career);
        DanielLoseView.setText(String.valueOf(DanielLose));


        RaphCareerPoints = 0;
        SharedPreferences settings4 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor4 = settings4.edit();
        editor4.putInt("RaphCareerPoints", RaphCareerPoints);
        editor4.commit();
        TextView RaphCareerPointsView = (TextView) findViewById(R.id.raph_pts_view_career);
        RaphCareerPointsView.setText(String.valueOf(RaphCareerPoints));
        RaphCareerRebounds = 0;
        SharedPreferences settings5 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor5 = settings5.edit();
        editor5.putInt("RaphCareerRebounds", RaphCareerRebounds);
        editor5.commit();
        TextView RaphCareerReboundsView = (TextView) findViewById(R.id.raph_rebs_view_career);
        RaphCareerReboundsView.setText(String.valueOf(RaphCareerRebounds));
        RaphCareerBlocks = 0;
        SharedPreferences settings6 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor6 = settings6.edit();
        editor6.putInt("RaphCareerBlocks", RaphCareerBlocks);
        editor6.commit();
        TextView RaphCareerBlocksView = (TextView) findViewById(R.id.raph_blks_view_career);
        RaphCareerBlocksView.setText(String.valueOf(RaphCareerBlocks));
        RaphWins = 0;
        SharedPreferences settings14 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor14 = settings14.edit();
        editor14.putInt("RaphWins", RaphWins);
        editor14.commit();
        TextView RaphWinsView = (TextView) findViewById(R.id.raph_wins_view_career);
        RaphWinsView.setText(String.valueOf(RaphWins));
        RaphLose = 0;
        SharedPreferences settings18 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor18 = settings18.edit();
        editor18.putInt("RaphLose", RaphLose);
        editor18.commit();
        TextView RaphLoseView = (TextView) findViewById(R.id.raph_lose_view_career);
        RaphLoseView.setText(String.valueOf(RaphLose));

        JoshCareerPoints = 0;
        SharedPreferences settings7 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor7 = settings7.edit();
        editor7.putInt("JoshCareerPoints", JoshCareerPoints);
        editor7.commit();
        TextView JoshCareerPointsView = (TextView) findViewById(R.id.josh_pts_view_career);
        JoshCareerPointsView.setText(String.valueOf(JoshCareerPoints));
        JoshCareerRebounds = 0;
        SharedPreferences settings8 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor8 = settings8.edit();
        editor8.putInt("JoshCareerRebounds", JoshCareerRebounds);
        editor8.commit();
        TextView JoshCareerReboundsView = (TextView) findViewById(R.id.josh_rebs_view_career);
        JoshCareerReboundsView.setText(String.valueOf(JoshCareerRebounds));
        JoshCareerBlocks = 0;
        SharedPreferences settings9 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor9 = settings9.edit();
        editor9.putInt("JoshCareerBlocks", JoshCareerBlocks);
        editor9.commit();
        TextView JoshCareerBlocksView = (TextView) findViewById(R.id.josh_blks_view_career);
        JoshCareerBlocksView.setText(String.valueOf(JoshCareerBlocks));
        JoshWins = 0;
        SharedPreferences settings15 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor15 = settings15.edit();
        editor15.putInt("JoshWins", JoshWins);
        editor15.commit();
        TextView JoshWinsView = (TextView) findViewById(R.id.josh_wins_view_career);
        JoshWinsView.setText(String.valueOf(JoshWins));
        JoshLose = 0;
        SharedPreferences settings19 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor19 = settings19.edit();
        editor19.putInt("JoshLose", JoshLose);
        editor19.commit();
        TextView JoshLoseView = (TextView) findViewById(R.id.josh_lose_view_career);
        JoshLoseView.setText(String.valueOf(JoshLose));

        DadsCareerPoints = 0;
        SharedPreferences settings10 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor10 = settings10.edit();
        editor10.putInt("DadsCareerPoints", DadsCareerPoints);
        editor10.commit();
        TextView DadsCareerPointsView = (TextView) findViewById(R.id.dads_pts_view_career);
        DadsCareerPointsView.setText(String.valueOf(DadsCareerPoints));
        DadsCareerRebounds = 0;
        SharedPreferences settings11 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor11 = settings11.edit();
        editor11.putInt("DadsCareerRebounds", DadsCareerRebounds);
        editor11.commit();
        TextView DadsCareerReboundsView = (TextView) findViewById(R.id.dads_rebs_view_career);
        DadsCareerReboundsView.setText(String.valueOf(DadsCareerRebounds));
        DadsCareerBlocks = 0;
        SharedPreferences settings12 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor12 = settings12.edit();
        editor12.putInt("DadsCareerBlocks", DadsCareerBlocks);
        editor12.commit();
        TextView DadsCareerBlocksView = (TextView) findViewById(R.id.dads_blks_view_career);
        DadsCareerBlocksView.setText(String.valueOf(DadsCareerBlocks));
        DadsWins = 0;
        SharedPreferences settings16 = getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor16 = settings16.edit();
        editor16.putInt("DadsWins", DadsWins);
        editor16.commit();
        TextView DadsWinsView = (TextView) findViewById(R.id.dads_wins_view_career);
        DadsWinsView.setText(String.valueOf(DadsWins));
        DadsLose = 0;
        SharedPreferences settings20 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor20 = settings20.edit();
        editor20.putInt("DadsLose", DadsLose);
        editor20.commit();
        TextView DadsLoseView = (TextView) findViewById(R.id.dads_lose_view_career);
        DadsLoseView.setText(String.valueOf(DadsLose));
    }
}
