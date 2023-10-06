package vn.edu.usth.ldchess;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnalyticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnalyticsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnalyticsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnalyticsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnalyticsFragment newInstance(String param1, String param2) {
        AnalyticsFragment fragment = new AnalyticsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_analytics, container, false);
        ShareData shareData = ShareData.getInstance();
        String sharedString = shareData.getSharedString();
        TextView text = view.findViewById(R.id.tt);

        text.setMovementMethod(LinkMovementMethod.getInstance());
        String url = "https://api.chess.com/pub/player/"+sharedString+"/stats";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject chessRapidObject = response.getJSONObject("chess_rapid");
                    JSONObject lastObject = chessRapidObject.getJSONObject("last");
//                    JSONObject bestObject = chessRapidObject.getJSONObject("best");
                    JSONObject recordObject = chessRapidObject.getJSONObject("record");
                    long lastdate = lastObject.getLong("date");
//                    int rating = bestObject.getInt("rating");
//                    long date = bestObject.getLong("date");
//                    String game = bestObject.getString("game");
                    int win = recordObject.getInt("win");
                    int loss = recordObject.getInt("loss");
                    int draw = recordObject.getInt("draw");



                    String lastDate = "<span style=' padding: 5px;'><font color='#FF9999'>Date:</font> " + formatDate(lastdate) + "</span>";
//                    String lastRatingText = "<span style='padding: 5px;'><font color='#00FF00'>Rating:</font> " + rating + "</span>";
//                    String lastDateText = "<span style='padding: 5px;'><font color='#FF9999'>Date:</font> " + formatDate(date) + "</span>";
//                    String bestGame = "<a href='" + game + "'>Live game here</a>";
                    String recordWin = "<span style='padding: 5px;'><font color='#00FF00'>Win:</font> " + win + "</span>";
                    String recordLoss = "<span style='padding: 5px;'><font color='#FF9999'>Loss:</font> " + loss + "</span>";
                    String recordDraw = "<span style='padding: 5px;'>Draw: " + draw + "</span>";


                    // Set the text for the TextView with HTML content
                    String htmlContent = "The last time you were online: <br>" + lastDate + "<br><br>" +
                          "Total: "+"<br>" + recordWin +"<br>"+recordDraw+"<br>"+ recordLoss;

                    text.setText(Html.fromHtml(htmlContent, Html.FROM_HTML_MODE_COMPACT));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                text.setText("error");
            }

        });


        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonObjectRequest);

        return view;
    }
    private String formatDate(long timestamp) {
        Date date = new Date(timestamp * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}