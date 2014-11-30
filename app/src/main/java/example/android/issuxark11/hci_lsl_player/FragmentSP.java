package example.android.issuxark11.hci_lsl_player;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by 영진 on 2014-11-29.
 */
public class FragmentSP extends Fragment {

    TextView RecordTime;
    ImageButton Stopbtn_SP1;
    ImageButton Recordbtn_SPR; // Record/Pause
    int ControlFlag_SPR=0;
    ImageButton Timer_SP;

    TextView Title_SP;
    TextView PlayTime;
    ImageButton Controlbtn_SPP;  // Play/Pause
    int ControlFlag_SPP=0;
    ImageButton Folderbtn_SP;

    RecordTimeCounterTask RecordTask = null;
    TimeCounter timecounter = null;
    PlayTimeCounterTask PlayTask = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_sp,container,false);

        RecordTime = (TextView) view.findViewById(R.id.recordtime);
        //RecordTime.setText("00:00");

        // Controlbtn1(Record/pause) 처리 부분
        Recordbtn_SPR = (ImageButton) view.findViewById(R.id.RecordBtnSPR);
        Recordbtn_SPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ControlFlag_SPR == 0) {
                    Recordbtn_SPR.setSelected(true);
                    ControlFlag_SPR = 1;
                    Recordbtn_SPR.setBackgroundResource(R.drawable.pause_r);
                    RecordTask = new RecordTimeCounterTask();
                    timecounter = new TimeCounter();
                    RecordTask.execute(timecounter);
                }
                else
                {
                    Recordbtn_SPR.setSelected(false);
                    ControlFlag_SPR = 0;
                    Recordbtn_SPR.setBackgroundResource(R.drawable.record);
                    RecordTask.cancel(true);
                }
            }
        });

        PlayTime = (TextView) view.findViewById(R.id.PlayTimeSPP);
        // Controlbtn2(Play/Pause) 처리 부분
        Controlbtn_SPP = (ImageButton) view.findViewById(R.id.ControlBtnSPP);
        Controlbtn_SPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ControlFlag_SPP == 0) {
                    Controlbtn_SPP.setSelected(true);
                    ControlFlag_SPP = 1;
                    Controlbtn_SPP.setBackgroundResource(R.drawable.pause);

                    PlayTask = new PlayTimeCounterTask();
                    timecounter = new TimeCounter();
                    PlayTask.execute(timecounter);
                }
                else
                {
                    Controlbtn_SPP.setSelected(false);
                    ControlFlag_SPP = 0;
                    Controlbtn_SPP.setBackgroundResource(R.drawable.play);

                    PlayTask.cancel(true);
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

    public static class TimeCounter{
        private long startTime;
        public TimeCounter(){
            startTime = new Date().getTime();
        }
        public long countTime(){
            return new Date().getTime() - startTime;
        }
    }

    public class RecordTimeCounterTask extends AsyncTask<TimeCounter, Long, Void> {
        @Override
        protected Void doInBackground(TimeCounter... params) {
            TimeCounter tc = params[0];
            while(true){
                publishProgress(new Long(tc.countTime()));
                try{
                    Thread.sleep(500);
                } catch(InterruptedException e){
                    break;
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            long millis = values[0].longValue();
            int minutes = (int) ((millis / 1000) / 60);
            int seconds = (int) ((millis / 1000) % 60);
            String s = String.format("%02d : %02d", minutes, seconds);
            RecordTime.setText(s);
        }
    }

    public class PlayTimeCounterTask extends AsyncTask<TimeCounter, Long, Void> {
        @Override
        protected Void doInBackground(TimeCounter... params) {
            TimeCounter tc = params[0];
            while(true){
                publishProgress(new Long(tc.countTime()));
                try{
                    Thread.sleep(500);
                } catch(InterruptedException e){
                    break;
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            long millis = values[0].longValue();
            int minutes = (int) ((millis / 1000) / 60);
            int seconds = (int) ((millis / 1000) % 60);
            String s = String.format("%02d : %02d", minutes, seconds);
            PlayTime.setText(s);
        }
    }
}