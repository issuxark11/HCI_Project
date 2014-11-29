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
import android.widget.Spinner;

/**
 * Created by 영진 on 2014-11-29.
 */
public class FragmentLC extends Fragment{
    private static String ScriptURL = "http://lslscript.pe.hu/script.html";
    WebView webview;   // script 창을 불러온다.
    Button stopbtn;
    Button playbtn;
    Button pausebtn;
    Button folderbtn;
    Spinner spinner;   // 배속 선택
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_lc,container,false);

        webview = (WebView) view.findViewById(R.id.ScriptView);
        webview.post(new Runnable() {
            @Override
            public void run() {
                webview.setHorizontalScrollBarEnabled(false); // 세로 scroll 제거
                webview.setVerticalScrollBarEnabled(false);   // 가로 scroll 제거
                webview.getSettings().setUseWideViewPort(true);
                webview.setInitialScale(1);
                webview.loadUrl(ScriptURL);
            }
        });

        spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.speed_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        return view;
    }
}
