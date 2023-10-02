package vn.edu.usth.ldchess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LessonAdapter extends  RecyclerView.Adapter<LessonAdapter.LessonViewHolder>{
    private Context mContext;
    private List<Lesson> mListLesson;

    public LessonAdapter(Context mContext) {
        this.mContext = mContext;

    }
    public void  setData(List<Lesson> list) {
        this.mListLesson = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lessons,parent,false);

        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        Lesson lesson = mListLesson.get(position);
        if(lesson == null){
            return;
        }
        holder.imageLesson.setImageResource(lesson.getResourceId());
        holder.tvLesson.setText(lesson.getName());
    }

    @Override
    public int getItemCount() {
        if(mListLesson != null){
            return  mListLesson.size();

        }
        return 0;
    }

    public class LessonViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageLesson;
        private TextView tvLesson;
        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            imageLesson = itemView.findViewById(R.id.item_bg);
            tvLesson = itemView.findViewById(R.id.item_namelesson);
        }
    }
}
