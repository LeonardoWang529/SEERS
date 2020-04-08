package com.example.seersandroid.ViewViewModel.CollegeLists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seersandroid.R;
import com.example.seersandroid.data.model.College;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

public class CollegeListAdapter extends RecyclerView.Adapter<CollegeListAdapter.CollegeHolder> {
    List<College> collegeList = new ArrayList<>();

    public void setCollegeList(List<College> collegeList) {
        this.collegeList = collegeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CollegeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collegelist,parent,false);
        return new CollegeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeHolder holder, int position) {
        holder.collegeState.setText(collegeList.get(position).getState());
        holder.collegeName.setText(collegeList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return collegeList.size();
    }

    class CollegeHolder extends RecyclerView.ViewHolder{
        TextView collegeName;
        TextView collegeState;

        public CollegeHolder(@NonNull View itemView) {
            super(itemView);
            collegeName = itemView.findViewById(R.id.collegeName);
            collegeState = itemView.findViewById(R.id.collegeState);
        }
    }
}
