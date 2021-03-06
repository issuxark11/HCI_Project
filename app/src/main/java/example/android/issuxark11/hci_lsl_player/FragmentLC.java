package example.android.issuxark11.hci_lsl_player;

import android.app.Fragment;
import android.content.Intent;
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
    ImageButton Stopbtn_LC;
    ImageButton Controlbtn_LC; // Play/Pause
    int ControlFlag_LC=0;
    ImageButton Folderbtn_LC;
    Spinner Spinner;   // 배속 선택
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_lc,container,false);

        // Set Default Title
        Title_LC = (TextView) view.findViewById(R.id.Title_LC);
        Title_LC.setText("Test03.mp3");

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

        // Stopbtn 처리 부분

        // Controlbtn 처리 부분
        Controlbtn_LC = (ImageButton) view.findViewById(R.id.ControlBtnLC);
        Controlbtn_LC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ControlFlag_LC == 0) {
                    Controlbtn_LC.setSelected(true);
                    ControlFlag_LC = 1;
                    Controlbtn_LC.setBackgroundResource(R.drawable.pause);
                }
                else
                {
                    Controlbtn_LC.setSelected(false);
                    ControlFlag_LC = 0;
                    Controlbtn_LC.setBackgroundResource(R.drawable.play);
                }
            }
            });

        // Folderbtn 처리 부분
        Folderbtn_LC = (ImageButton) view.findViewById(R.id.FolderBtnLC);
        Folderbtn_LC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FileManage.class);
                startActivity(intent);
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