package com.dell.routine;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {
    private List<Notice_list> notice_lists;
    private Context context;
     static String notice_id;

    public NoticeAdapter(List<Notice_list> notice_lists, Context context) {
        this.notice_lists = notice_lists;
        this.context = context;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_layout_notice,parent,false);
        return new NoticeViewHolder(v);

    }



    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, int position) {
        final Notice_list notice_list=notice_lists.get(position);

        holder.textTitle.setText(notice_list.getTitle());
        holder.textDesc.setText(notice_list.getDesc());
//        notice_id = notice_list.getNotice_id();
        holder.linearlayoutNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(context,NoticeDisp.class);
                context.startActivity(b);
                notice_id = notice_list.getNotice_id();
            }
        });

    }

    @Override
    public int getItemCount() {
        return notice_lists.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {//implements View.OnClickListener{

        View mView;
        public TextView textTitle, textDesc;
        public CardView linearlayoutNotice;

        public NoticeViewHolder(View itemView) {
            super(itemView);
            mView= itemView;
            textTitle=mView.findViewById(R.id.textTitle);
            textDesc=mView.findViewById(R.id.textDesc);
            linearlayoutNotice= mView.findViewById(R.id.linearlayoutNotice);
//            mView.setOnClickListener(this);
        }
    }

}
