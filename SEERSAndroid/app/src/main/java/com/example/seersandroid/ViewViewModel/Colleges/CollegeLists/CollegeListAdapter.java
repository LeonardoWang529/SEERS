package com.example.seersandroid.ViewViewModel.Colleges.CollegeLists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.seersandroid.Classes.OnItemClick;
import com.example.seersandroid.Classes.OnItemClickListener;
import com.example.seersandroid.R;
import com.example.seersandroid.ViewViewModel.Colleges.CollegeItemFragment;
import com.example.seersandroid.data.model.College;
import com.google.android.gms.dynamic.SupportFragmentWrapper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class CollegeListAdapter extends
        RecyclerView.Adapter<CollegeListAdapter.CollegeHolder> implements OnItemClick {

    List<College> collegeList = new ArrayList<>();
    OnItemClickListener itemClickListener;

    public void setCollegeList(List<College> collegeList) {
        this.collegeList = collegeList;
        notifyDataSetChanged();
    }

    @Override
    public void setListerner(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CollegeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collegelist,parent,false);
        return new CollegeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CollegeHolder holder, final int position) {
        holder.collegeState.setText(collegeList.get(position).getState());
        holder.collegeName.setText(collegeList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                itemClickListener.onClick(collegeList.get(position));

            }
        });
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
