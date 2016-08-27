package json.serenity.rs.jsonparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView tvJson;
    private String JSON, dataToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvJson = (TextView) findViewById(R.id.tvJson);

        // url: https://jsonplaceholder.typicode.com/posts

        JSON = "" +
                "{" +
                "\"Student\" :[" +
                "{" +
                "\"indeks\":\"1635\"," +
                "\"ime\":\"Nikola Kumric\"," +
                "\"bodovi\":\"44\"" +
                "}," +
                "{" +
                "\"indeks\":\"1550\"," +
                "\"ime\":\"Milan Hakaj\"," +
                "\"bodovi\":\"36\"" +
                "}," +
                "{" +
                "\"indeks\":\"1660\"," +
                "\"ime\":\"Filip Stojkovic\"," +
                "\"bodovi\":\"48\"" +
                "}" +
                "]" +
                "}";

        try {
            JSONObject  jsonRootObject = new JSONObject(JSON);
            JSONArray jsonArray = jsonRootObject.optJSONArray("Student");

            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id       = Integer.parseInt(jsonObject.optString("indeks").toString());
                String name  = jsonObject.optString("ime").toString();
                float salary = Float.parseFloat(jsonObject.optString("bodovi").toString());

                dataToDisplay += "Student"+(i+1)+" : \n indeks= "+ id +" \n Ime= "+ name +" \n Bodovi= "+ salary +" \n\n ";
            }
            tvJson.setText(dataToDisplay);

        } catch (JSONException e) {e.printStackTrace();}
    }

}










