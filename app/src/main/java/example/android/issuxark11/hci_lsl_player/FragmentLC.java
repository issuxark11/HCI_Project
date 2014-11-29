package example.android.issuxark11.hci_lsl_player;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ResourceBundle;

/**
 * Created by 영진 on 2014-11-29.
 */
public class FragmentLC extends Fragment{
    private static String ScriptURL = "http://lslscript.pe.hu/script.html";

    TextView Title_LC;
    WebView Webview;   // script 창을 불러온다.
    ImageButton Stopebtn;
    ImageButton Controlbtn; // Play/Pause
    int ControlFlag=0;
    ImageButton Folderbtn;
    Spinner Spinner;   // 배속 선택
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_lc,container,false);

        // Set Default Title
        Title_LC = (TextView) view.findViewById(R.id.Title_LC);
        Title_LC.setText("Title");

        // Script 처리 부분
        Webview = (WebView) view.findViewById(R.id.ScriptView);
        Webview.post(new Runnable() {
            @Override
            public void run() {
                Webview.setHorizontalScrollBarEnabled(false); // 세로 scroll 제거
                Webview.setVerticalScrollBarEnabled(false);   // 가로 scroll 제거
                Webview.getSettings().setUseWideViewPort(true);
                Webview.setInitialScale(1);
                Webview.loadUrl(ScriptURL);
            }
        });

        // Spinner 처리 부분
        Spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.speed_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner.setAdapter(adapter);
        Spinner.setSelection(1);
        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        // Stopebtn 처리 부분

        // Controlybtn 처리 부분
        Controlbtn = (ImageButton) view.findViewById(R.id.ControlBtnLC);
        Controlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ControlFlag == 0) {
                    Controlbtn.setSelected(true);
                    ControlFlag = 1;
                    Controlbtn.setBackgroundResource(R.drawable.pause);
                }
                else
                {
                    Controlbtn.setSelected(false);
                    ControlFlag = 0;
                    Controlbtn.setBackgroundResource(R.drawable.play);
                }
            }
            });

        // Folderbtn 처리 부분

        return view;
    }
}