package vn.edu.usth.ldchess.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.ldchess.Intro;
import vn.edu.usth.ldchess.List_Lesson;
import vn.edu.usth.ldchess.home_Fragment;

public class AdapterView extends FragmentStateAdapter {
    public AdapterView(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new home_Fragment();
            case 1:
                return new Intro();
            case 2:
                return new List_Lesson();
        }
    }

    @Override
    public int getItemCount() {

        return 3;
    }
}
