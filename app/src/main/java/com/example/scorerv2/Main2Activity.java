package com.example.scorerv2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    //intent
    String danielPointsIntent;
    String danielReboundsIntent;
    String danielBlocksIntent;
    String raphPointsIntent;
    String raphReboundsIntent;
    String raphBlocksIntent;
    String joshPointsIntent;
    String joshReboundsIntent;
    String joshBlocksIntent;
    String dadsPointsIntent;
    String dadsReboundsIntent;
    String dadsBlocksIntent;
    //winlose
    String danielWinsIntent;
    String raphWinsIntent;
    String joshWinsIntent;
    String dadsWinsIntent;
    String danielLoseIntent;
    String raphLoseIntent;
    String joshLoseIntent;
    String dadsLoseIntent;

    TextView DanielCareerPointsView;
    TextView DanielCareerReboundsView;
    TextView DanielCareerBlocksView;
    TextView RaphCareerPointsView;
    TextView RaphCareerReboundsView;
    TextView RaphCareerBlocksView;
    TextView JoshCareerPointsView;
    TextView JoshCareerReboundsView;
    TextView JoshCareerBlocksView;
    TextView DadsCareerPointsView;
    TextView DadsCareerReboundsView;
    TextView DadsCareerBlocksView;
    //winlose
    TextView DanielWinsView;
    TextView RaphWinsView;
    TextView JoshWinsView;
    TextView DadsWinsView;
    TextView DanielLoseView;
    TextView RaphLoseView;
    TextView JoshLoseView;
    TextView DadsLoseView;
    // advanced
    TextView DanielAdvView1;
    TextView DanielAdvView2;
    TextView DanielAdvView3;
    TextView DanielAdvView4;
    TextView RaphAdvView1;
    TextView RaphAdvView2;
    TextView RaphAdvView3;
    TextView RaphAdvView4;
    TextView JoshAdvView1;
    TextView JoshAdvView2;
    TextView JoshAdvView3;
    TextView JoshAdvView4;
    TextView DadsAdvView1;
    TextView DadsAdvView2;
    TextView DadsAdvView3;
    TextView DadsAdvView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //intent receive values
        Intent intent = getIntent();
        danielPointsIntent = intent.getStringExtra("daniel_PointsIntent");
        danielReboundsIntent = intent.getStringExtra("daniel_ReboundsIntent");
        danielBlocksIntent = intent.getStringExtra("daniel_BlocksIntent");
        raphPointsIntent = intent.getStringExtra("raph_PointsIntent");
        raphReboundsIntent = intent.getStringExtra("raph_ReboundsIntent");
        raphBlocksIntent = intent.getStringExtra("raph_BlocksIntent");
        joshPointsIntent = intent.getStringExtra("josh_PointsIntent");
        joshReboundsIntent = intent.getStringExtra("josh_ReboundsIntent");
        joshBlocksIntent = intent.getStringExtra("josh_BlocksIntent");
        dadsPointsIntent = intent.getStringExtra("dads_PointsIntent");
        dadsReboundsIntent = intent.getStringExtra("dads_ReboundsIntent");
        dadsBlocksIntent = intent.getStringExtra("dads_BlocksIntent");
        danielWinsIntent = intent.getStringExtra("daniel_WinsIntent");
        raphWinsIntent = intent.getStringExtra("raph_WinsIntent");
        joshWinsIntent = intent.getStringExtra("josh_WinsIntent");
        dadsWinsIntent = intent.getStringExtra("dads_WinsIntent");
        danielLoseIntent = intent.getStringExtra("daniel_LoseIntent");
        raphLoseIntent = intent.getStringExtra("raph_LoseIntent");
        joshLoseIntent = intent.getStringExtra("josh_LoseIntent");
        dadsLoseIntent = intent.getStringExtra("dads_LoseIntent");

        // update display
        DanielCareerPointsView = (TextView) findViewById(R.id.daniel_stats_pts);
        DanielCareerPointsView.setText(String.valueOf(danielPointsIntent));
        DanielCareerReboundsView = (TextView) findViewById(R.id.daniel_stats_rebs);
        DanielCareerReboundsView.setText(String.valueOf(danielReboundsIntent));
        DanielCareerBlocksView = (TextView) findViewById(R.id.daniel_stats_blks);
        DanielCareerBlocksView.setText(String.valueOf(danielBlocksIntent));
        DanielWinsView = (TextView) findViewById(R.id.daniel_stats_wins);
        DanielWinsView.setText(String.valueOf(danielWinsIntent));
        DanielLoseView = (TextView) findViewById(R.id.daniel_stats_lose);
        DanielLoseView.setText(String.valueOf(danielLoseIntent));
        // advanced
        DanielAdvView1 = (TextView) findViewById(R.id.daniel_stats_ppg);
        double danielpts = Integer.parseInt(danielPointsIntent);
        double danielwins = Integer.parseInt(danielWinsIntent);
        double daniellosses = Integer.parseInt(danielLoseIntent);
        double danielgamesplayed = (danielwins+daniellosses);
        double danielppg = (danielpts/danielgamesplayed);
        double danielppgroundoff = Math.round(danielppg * 100.0) / 100.0;
        if (danielppg == 0) {
            DanielAdvView1.setText("0");
        } else if (danielppg > 0) {
            DanielAdvView1.setText(String.valueOf(danielppgroundoff));
        }
        DanielAdvView2 = (TextView) findViewById(R.id.daniel_stats_rpg);
        double danielrebs = Integer.parseInt(danielReboundsIntent);
        double danielrpg = (danielrebs/danielgamesplayed);
        double danielrpgroundoff = Math.round(danielrpg * 100.0) / 100.0;
        if (danielrebs == 0) {
            DanielAdvView2.setText("0");
        } else if (danielrebs > 0) {
            DanielAdvView2.setText(String.valueOf(danielrpgroundoff));
        }
        DanielAdvView3 = (TextView) findViewById(R.id.daniel_stats_bpg);
        double danielblks = Integer.parseInt(danielBlocksIntent);
        double danielbpg = (danielblks/danielgamesplayed);
        double danielbpgroundoff = Math.round(danielbpg * 100.0) / 100.0;
        if (danielblks == 0) {
            DanielAdvView3.setText("0");
        } else if (danielblks > 0) {
            DanielAdvView3.setText(String.valueOf(danielbpgroundoff));
        }
        DanielAdvView4 = (TextView) findViewById(R.id.daniel_stats_wrate);
        int danielwrate = (int) ((danielwins/danielgamesplayed)*100);
        DanielAdvView4.setText(danielwrate +"%");


        RaphCareerPointsView = (TextView) findViewById(R.id.raph_stats_pts);
        RaphCareerPointsView.setText(String.valueOf(raphPointsIntent));
        RaphCareerReboundsView = (TextView) findViewById(R.id.raph_stats_rebs);
        RaphCareerReboundsView.setText(String.valueOf(raphReboundsIntent));
        RaphCareerBlocksView = (TextView) findViewById(R.id.raph_stats_blks);
        RaphCareerBlocksView.setText(String.valueOf(raphBlocksIntent));
        RaphWinsView = (TextView) findViewById(R.id.raph_stats_wins);
        RaphWinsView.setText(String.valueOf(raphWinsIntent));
        RaphLoseView = (TextView) findViewById(R.id.raph_stats_lose);
        RaphLoseView.setText(String.valueOf(raphLoseIntent));
        // advanced
        RaphAdvView1 = (TextView) findViewById(R.id.raph_stats_ppg);
        double raphpts = Integer.parseInt(raphPointsIntent);
        double raphwins = Integer.parseInt(raphWinsIntent);
        double raphlosses = Integer.parseInt(raphLoseIntent);
        double raphgamesplayed = (raphwins+raphlosses);
        double raphppg = (raphpts/raphgamesplayed);
        double raphppgroundoff = Math.round(raphppg * 100.0) / 100.0;
        if (raphppg == 0) {
            RaphAdvView1.setText("0");
        } else if (raphppg > 0) {
            RaphAdvView1.setText(String.valueOf(raphppgroundoff));
        }
        RaphAdvView2 = (TextView) findViewById(R.id.raph_stats_rpg);
        double raphrebs = Integer.parseInt(raphReboundsIntent);
        double raphrpg = (raphrebs/raphgamesplayed);
        double raphrpgroundoff = Math.round(raphrpg * 100.0) / 100.0;
        if (raphrebs == 0) {
            RaphAdvView2.setText("0");
        } else if (raphrebs > 0) {
            RaphAdvView2.setText(String.valueOf(raphrpgroundoff));
        }
        RaphAdvView3 = (TextView) findViewById(R.id.raph_stats_bpg);
        double raphblks = Integer.parseInt(raphBlocksIntent);
        double raphbpg = (raphblks/raphgamesplayed);
        double raphbpgroundoff = Math.round(raphbpg * 100.0) / 100.0;
        if (raphblks == 0) {
            RaphAdvView3.setText("0");
        } else if (raphblks > 0) {
            RaphAdvView3.setText(String.valueOf(raphbpgroundoff));
        }
        RaphAdvView4 = (TextView) findViewById(R.id.raph_stats_wrate);
        int raphwrate = (int) ((raphwins/raphgamesplayed)*100);
        RaphAdvView4.setText(raphwrate +"%");



        JoshCareerPointsView = (TextView) findViewById(R.id.josh_stats_pts);
        JoshCareerPointsView.setText(String.valueOf(joshPointsIntent));
        JoshCareerReboundsView = (TextView) findViewById(R.id.josh_stats_rebs);
        JoshCareerReboundsView.setText(String.valueOf(joshReboundsIntent));
        JoshCareerBlocksView = (TextView) findViewById(R.id.josh_stats_blks);
        JoshCareerBlocksView.setText(String.valueOf(joshBlocksIntent));
        JoshWinsView = (TextView) findViewById(R.id.josh_stats_wins);
        JoshWinsView.setText(String.valueOf(joshWinsIntent));
        JoshLoseView = (TextView) findViewById(R.id.josh_stats_lose);
        JoshLoseView.setText(String.valueOf(joshLoseIntent));
        // advanced
        JoshAdvView1 = (TextView) findViewById(R.id.josh_stats_ppg);
        double joshpts = Integer.parseInt(joshPointsIntent);
        double joshwins = Integer.parseInt(joshWinsIntent);
        double joshlosses = Integer.parseInt(joshLoseIntent);
        double joshgamesplayed = (joshwins+joshlosses);
        double joshppg = (joshpts/joshgamesplayed);
        double joshppgroundoff = Math.round(joshppg * 100.0) / 100.0;
        if (joshppg == 0) {
            JoshAdvView1.setText("0");
        } else if (joshppg > 0) {
            JoshAdvView1.setText(String.valueOf(joshppgroundoff));
        }
        JoshAdvView2 = (TextView) findViewById(R.id.josh_stats_rpg);
        double joshrebs = Integer.parseInt(joshReboundsIntent);
        double joshrpg = (joshrebs/joshgamesplayed);
        double joshrpgroundoff = Math.round(joshrpg * 100.0) / 100.0;
        if (joshrebs == 0) {
            JoshAdvView2.setText("0");
        } else if (joshrebs > 0) {
            JoshAdvView2.setText(String.valueOf(joshrpgroundoff));
        }
        JoshAdvView3 = (TextView) findViewById(R.id.josh_stats_bpg);
        double joshblks = Integer.parseInt(joshBlocksIntent);
        double joshbpg = (joshblks/joshgamesplayed);
        double joshbpgroundoff = Math.round(joshbpg * 100.0) / 100.0;
        if (joshblks == 0) {
            JoshAdvView3.setText("0");
        } else if (joshblks > 0) {
            JoshAdvView3.setText(String.valueOf(joshbpgroundoff));
        }
        JoshAdvView4 = (TextView) findViewById(R.id.josh_stats_wrate);
        int joshwrate = (int) ((joshwins/joshgamesplayed)*100);
        JoshAdvView4.setText(joshwrate +"%");


        DadsCareerPointsView = (TextView) findViewById(R.id.dads_stats_pts);
        DadsCareerPointsView.setText(String.valueOf(dadsPointsIntent));
        DadsCareerReboundsView = (TextView) findViewById(R.id.dads_stats_rebs);
        DadsCareerReboundsView.setText(String.valueOf(dadsReboundsIntent));
        DadsCareerBlocksView = (TextView) findViewById(R.id.dads_stats_blks);
        DadsCareerBlocksView.setText(String.valueOf(dadsBlocksIntent));
        DadsWinsView = (TextView) findViewById(R.id.dads_stats_wins);
        DadsWinsView.setText(String.valueOf(dadsWinsIntent));
        DadsLoseView = (TextView) findViewById(R.id.dads_stats_lose);
        DadsLoseView.setText(String.valueOf(dadsLoseIntent));
        // advanced
        DadsAdvView1 = (TextView) findViewById(R.id.dads_stats_ppg);
        double dadspts = Integer.parseInt(dadsPointsIntent);
        double dadswins = Integer.parseInt(dadsWinsIntent);
        double dadslosses = Integer.parseInt(dadsLoseIntent);
        double dadsgamesplayed = (dadswins+dadslosses);
        double dadsppg = (dadspts/dadsgamesplayed);
        double dadsppgroundoff = Math.round(dadsppg * 100.0) / 100.0;
        if (dadsppg == 0) {
            DadsAdvView1.setText("0");
        } else if (dadsppg > 0) {
            DadsAdvView1.setText(String.valueOf(dadsppgroundoff));
        }
        DadsAdvView2 = (TextView) findViewById(R.id.dads_stats_rpg);
        double dadsrebs = Integer.parseInt(dadsReboundsIntent);
        double dadsrpg = (dadsrebs/dadsgamesplayed);
        double dadsrpgroundoff = Math.round(dadsrpg * 100.0) / 100.0;
        if (dadsrebs == 0) {
            DadsAdvView2.setText("0");
        } else if (dadsrebs > 0) {
            DadsAdvView2.setText(String.valueOf(dadsrpgroundoff));
        }
        DadsAdvView3 = (TextView) findViewById(R.id.dads_stats_bpg);
        double dadsblks = Integer.parseInt(dadsBlocksIntent);
        double dadsbpg = (dadsblks/dadsgamesplayed);
        double dadsbpgroundoff = Math.round(dadsbpg * 100.0) / 100.0;
        if (dadsblks == 0) {
            DadsAdvView3.setText("0");
        } else if (dadsblks > 0) {
            DadsAdvView3.setText(String.valueOf(dadsbpgroundoff));
        }
        DadsAdvView4 = (TextView) findViewById(R.id.dads_stats_wrate);
        int dadswrate = (int) ((dadswins/dadsgamesplayed)*100);
        DadsAdvView4.setText(dadswrate +"%");

    }
}
