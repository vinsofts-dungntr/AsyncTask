package hanoi.com.vinsofts.readjsonasynctask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hanoi.com.vinsofts.readjsonasynctask.model.Song;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder>{
    Context context;
    List<Song> mList;

    public SongAdapter(Context context, List<Song> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.layout_item_recyclerview,viewGroup,false);

        return new SongHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder songHolder, int i) {
        Song model=mList.get(i);
        songHolder.tvTitle.setText(model.getScore());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class SongHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        public SongHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvTitle);
        }
    }
}
