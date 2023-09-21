package vn.edu.usth.ldchess.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.ldchess.HeaderProfileFragment;
import vn.edu.usth.ldchess.Lesson_0;
import vn.edu.usth.ldchess.exploreFragment;
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
                return new exploreFragment();
            case 2:
                return new Lesson_0();
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
