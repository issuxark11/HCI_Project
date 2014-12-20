package example.android.issuxark11.hci_lsl_player;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by 영진 on 2014-12-01.
 */
public class FileManage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_manage);

        ListView LV = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter;
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        //adapter = new CustomAdapter();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        LV.setAdapter(adapter);

        adapter.add("LC 1-1.mp3");
        adapter.add("LC 1-2.mp3");
        adapter.add("LC 1-3.mp3");
        adapter.add("LC 2-1.mp3");
        adapter.add("LC 2-2.mp3");
        adapter.add("LC 2-3.mp3");
        adapter.add("LC 2-4.mp3");
    }
}