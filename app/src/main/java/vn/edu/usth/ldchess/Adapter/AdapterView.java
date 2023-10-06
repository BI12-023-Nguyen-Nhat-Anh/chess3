package vn.edu.usth.ldchess.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.ldchess.HeaderProfileFragment;
import vn.edu.usth.ldchess.Home_Explore_Content;
import vn.edu.usth.ldchess.List_Chess;
import vn.edu.usth.ldchess.List_Lesson;
import vn.edu.usth.ldchess.PlayChess;
import vn.edu.usth.ldchess.PlayChessFragment;

public class AdapterView extends FragmentStateAdapter {
    public AdapterView(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Home_Explore_Content();
            case 1:
                return new List_Chess();
            case 2:
                return new List_Lesson();
            case 3:
                return new HeaderProfileFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {

        return 4;
    }
}