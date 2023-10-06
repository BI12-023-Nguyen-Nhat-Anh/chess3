package vn.edu.usth.ldchess;

import static android.content.ContentValues.TAG;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import vn.edu.usth.ldchess.Adapter.AdapterProfile;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeaderProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeaderProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HeaderProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HeaderProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeaderProfileFragment newInstance(String param1, String param2) {
        HeaderProfileFragment fragment = new HeaderProfileFragment();
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
        View view =  inflater.inflate(R.layout.fragment_header_profile, container, false);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewpager);
        ImageView navbar=view.findViewById(R.id.navbar);


        tabLayout.addTab(tabLayout.newTab().setText("Analytic"));
        tabLayout.addTab(tabLayout.newTab().setText("Save"));
        tabLayout.addTab(tabLayout.newTab().setText("Courses"));

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        AdapterProfile adapterProfile = new AdapterProfile(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapterProfile);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        ShareData shareData = ShareData.getInstance();
        String sharedString = shareData.getSharedString();
        TextView text = view.findViewById(R.id.name_profile);
        ImageView imageView = view.findViewById(R.id.img);        TextView follow = view.findViewById(R.id.followers);


        String url = "https://api.chess.com/pub/player/"+sharedString;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    String name = response.getString("name");
//                    String username = response.getString("username");
//                    int follower = response.getInt("followers");
                    String avatar = response.getString("avatar");

                    Picasso.get().load(avatar).into(imageView);

                    text.setText(name);
//                    follow.setText(follower);


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

        navbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonObjectRequest);

        return view;
    }

    public void popup(){
        Dialog popup=new Dialog(requireContext());
        popup.setContentView(R.layout.logout);

        Window window=popup.getWindow();
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

        popup.show();

        Button yes=popup.findViewById(R.id.btn_accept);
        Button no=popup.findViewById(R.id.btn_decline);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closePopup(popup);
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Homepage.class));
            }
        });
    }

    public void closePopup(Dialog popup){
        popup.dismiss();
    }

    public void onBackPressed() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }
}