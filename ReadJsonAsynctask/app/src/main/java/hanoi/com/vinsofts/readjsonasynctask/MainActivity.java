package hanoi.com.vinsofts.readjsonasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import hanoi.com.vinsofts.readjsonasynctask.model.Song;

public class MainActivity extends AppCompatActivity {

    SongAdapter adapter;
    RecyclerView recyclerView;
    List<Song> mList = new ArrayList<>();
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    RecyclerView recyclerView4;
    RecyclerView recyclerView5;
    RecyclerView recyclerView6;
    RecyclerView recyclerView7;
    MyAsyncTask asyncTask1;
    MyAsyncTask asyncTask2;
    MyAsyncTask asyncTask3;
    MyAsyncTask asyncTask4;
    MyAsyncTask asyncTask5;
    MyAsyncTask asyncTask6;
    MyAsyncTask asyncTask7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview1);
        recyclerView2 = findViewById(R.id.recyclerview2);
        recyclerView3 = findViewById(R.id.recyclerview3);
        recyclerView4 = findViewById(R.id.recyclerview4);
        recyclerView5 = findViewById(R.id.recyclerview5);
        recyclerView6 = findViewById(R.id.recyclerview6);
        recyclerView7 = findViewById(R.id.recyclerview7);

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager manager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager manager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager manager3 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager manager4 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager manager5 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager manager6 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        
        recyclerView.setLayoutManager(manager);
        recyclerView2.setLayoutManager(manager1);
        recyclerView3.setLayoutManager(manager2);
        recyclerView4.setLayoutManager(manager3);
        recyclerView5.setLayoutManager(manager4);
        recyclerView6.setLayoutManager(manager5);
        recyclerView7.setLayoutManager(manager6);

        asyncTask1 = (MyAsyncTask) new MyAsyncTask().execute("https://api-v2.soundcloud.com/charts?kind=top&genre=soundcloud%3Agenres%3Aall-music&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=20&offset=20");
        asyncTask2= (MyAsyncTask) new MyAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                "https://api-v2.soundcloud.com/charts?kind=top&genre=soundcloud%3Agenres%3Aall-music&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=20&offset=20");
        asyncTask3= (MyAsyncTask) new MyAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                "https://api-v2.soundcloud.com/charts?kind=top&genre=soundcloud%3Agenres%3Aall-music&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=20&offset=20");
        asyncTask4= (MyAsyncTask) new MyAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                "https://api-v2.soundcloud.com/charts?kind=top&genre=soundcloud%3Agenres%3Aall-music&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=20&offset=20");
        asyncTask5= (MyAsyncTask) new MyAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                "https://api-v2.soundcloud.com/charts?kind=top&genre=soundcloud%3Agenres%3Aall-music&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=20&offset=20");
        asyncTask6= (MyAsyncTask) new MyAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                "https://api-v2.soundcloud.com/charts?kind=top&genre=soundcloud%3Agenres%3Aall-music&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=20&offset=20");
        asyncTask7= (MyAsyncTask) new MyAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                "https://api-v2.soundcloud.com/charts?kind=top&genre=soundcloud%3Agenres%3Aall-music&client_id=a7Ucuq0KY8Ksn8WzBG6wj4x6pcId6BpU&limit=20&offset=20");

        adapter = new SongAdapter(MainActivity.this, mList);
        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapter);
        recyclerView3.setAdapter(adapter);
        recyclerView4.setAdapter(adapter);
        recyclerView5.setAdapter(adapter);
        recyclerView6.setAdapter(adapter);
        recyclerView7.setAdapter(adapter);
    }

    public class MyAsyncTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject root = new JSONObject(s);
                JSONArray array = root.getJSONArray("collection");
                for (int i = 0; i <= array.length(); i++) {
                    JSONObject score = array.getJSONObject(i);
                    String s1 = score.getString("score");
                    mList.add(new Song(s1));
                    adapter.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private String docNoiDung_Tu_URL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();


            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
