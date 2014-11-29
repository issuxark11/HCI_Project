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
    ImageButton Controlbtn_SPR; // Play/Pause
    ImageButton Timer_SP;

    TextView Title_SP;
    TextView PlayTime;
    ImageButton Controlbtn_SPP;
    int ControlFlag_SPP=0;
    ImageButton Folderbtn_SP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_sp,container,false);

        RecordTime = (TextView) view.findViewById(R.id.recordtime);
        RecordTime.setText("00:00");

        // Controlybtn 처리 부분
        Controlbtn_SPP = (ImageButton) view.findViewById(R.id.ControlBtnSPP);
        Controlbtn_SPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ControlFlag_SPP == 0) {
                    Controlbtn_SPP.setSelected(true);
                    ControlFlag_SPP = 1;
                    Controlbtn_SPP.setBackgroundResource(R.drawable.pause);
                }
                else
                {
                    Controlbtn_SPP.setSelected(false);
                    ControlFlag_SPP = 0;
                    Controlbtn_SPP.setBackgroundResource(R.drawable.play);
                }
            }
        });

        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
    }
}