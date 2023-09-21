package vn.edu.usth.ldchess;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Adapter4 extends FragmentStateAdapter {

    public Adapter4(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Content4();
            case 1:
                return new Disscustionn();
        }
        return null;

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}