package example.android.issuxark11.hci_lsl_player;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView Title_LC;
    private Button StopBtn_LC;
    private Button PlayBtn_LC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        actionBar.hide();

        Title_LC = (TextView) findViewById(R.id.Title_LC);
        Title_LC.setText("Title");

    }

    public void SelectFragment(View view) {
        Fragment fr;

        if (view == findViewById(R.id.SpBtn)) {
            fr = new FragmentSP();
        } else {
            fr = new FragmentLC();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_main, fr);
        fragmentTransaction.commit();
    }
}