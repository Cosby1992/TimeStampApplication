package dk.cosby.timestampapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.Database;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button btnBigBlueButton;

    private TextView tvPunchedInTime;
    private TextView tvPunchedOutTime;

    private TextView tvPunchedInText;
    private TextView tvPunchedOutText;
    private TextView tvTimeWorkedText;
    private TextView tvTimeWorkedResult;

    private TextClock tcTextClockMain;

    private boolean workInProgress = false;

    private TimeUtilities timeUtil;
    private Shift shift;

    private long timeStart;
    private long timeEnd;


    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        btnBigBlueButton = (Button) findViewById(R.id.btn_big_blue_button);

        tcTextClockMain = (TextClock) findViewById(R.id.tc_textclock_1);

        tvPunchedInTime = (TextView) findViewById(R.id.tv_punched_in_time);
        tvPunchedOutTime = (TextView) findViewById(R.id.tv_punched_out_time);

        tvPunchedInText = (TextView) findViewById(R.id.tv_punched_in_text);
        tvPunchedOutText = (TextView) findViewById(R.id.tv_punched_out_text);

        tvTimeWorkedText = (TextView) findViewById(R.id.tv_time_worked_text);
        tvTimeWorkedResult = (TextView) findViewById(R.id.tv_time_worked_result);

        timeUtil = new TimeUtilities();

        tcTextClockMain.setFormat12Hour("HH:mm:ss");

        db = Room.inMemoryDatabaseBuilder(getApplicationContext(), AppDatabase.class).build();
    }

    public void onBigBlueButtonClick(View view) {

        if (!workInProgress) {
            shift = new Shift();

            tvPunchedInTime.setText("");
            tvPunchedOutTime.setText("");
            tvTimeWorkedResult.setText("");

            timeStart = System.currentTimeMillis();
            shift.setTimeStartShift(timeUtil.getTimeFromMillis(timeStart));
            shift.setDateStartShift(timeUtil.getDateFromMillis(timeStart));

            String textOut = shift.getTimeStartShift();

            workInProgress = true;

            tvPunchedInTime.setText(textOut);


        } else {

            timeEnd = System.currentTimeMillis();
            shift.setTimeEndShift(timeUtil.getTimeFromMillis(timeEnd));
            shift.setDateEndShift(timeUtil.getDateFromMillis(timeEnd));
            shift.setShiftLength(timeUtil.timeBetweenMillis(timeStart, timeEnd));

            String textOut = shift.getTimeEndShift();

            tvPunchedOutTime.setText(textOut);
            tvTimeWorkedResult.setText(shift.getShiftLength());

            workInProgress = false;


        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_time_settings) {

            //Starting the TimeSetting Activity
            Intent timeSettingActivityIntend = new Intent(getApplicationContext(), TimeSettingsActivity.class);
            startActivity(timeSettingActivityIntend);

        } else if (id == R.id.nav_share) {

            Toast.makeText(getApplicationContext(), "This menu item has not been developed", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {

            Toast.makeText(getApplicationContext(), "This menu item has not been developed", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
