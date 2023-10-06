package vn.edu.usth.ldchess.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.ldchess.AnalyticsFragment;
import vn.edu.usth.ldchess.CoursesFragment;
import vn.edu.usth.ldchess.SaveFragment;

public class AdapterProfile extends FragmentStateAdapter {
    public AdapterProfile(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new AnalyticsFragment();
            case 1:
                return new SaveFragment();

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
