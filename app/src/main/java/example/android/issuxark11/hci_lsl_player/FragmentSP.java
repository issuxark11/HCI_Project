package example.android.issuxark11.hci_lsl_player;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by 영진 on 2014-11-29.
 */
public class FragmentSP extends Fragment {

    TextView RecordTime;
    ImageButton Stopbtn_SP1;
    ImageButton Controlbtn_SP2; // Play/Pause
    ImageButton Timer_SP;

    TextView Title_SP;
    TextView PlayTime;
    int ControlFlag_SP=0;
    ImageButton Folderbtn_SP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_sp,container,false);

        RecordTime = (TextView) view.findViewById(R.id.recordtime);
        RecordTime.setText("00:00");

        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
    }
}
