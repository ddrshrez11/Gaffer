package com.dell.firestore;

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

    public class Assignment_Adapter extends RecyclerView.Adapter<Assignment_Adapter.ViewHolder>{
        private List<Assignment_list> assignment_lists;
        private Context context;
        static String assignment_id;

        public Assignment_Adapter(List<Assignment_list> assignment_lists, Context context) {
            this.assignment_lists = assignment_lists;
            this.context = context;
        }



        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_layout_assignment,parent,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Assignment_list assignment_list=assignment_lists.get(position);

            holder.Asgn_Title.setText(assignment_list.getTitle());
            holder.Asgn_Deadline.setText(assignment_list.getDeadline());
            holder.Asgn_Subject.setText(assignment_list.getSubject());
            holder.Asgn_Desc.setText(assignment_list.getDesc());

            holder.linearlayoutAssignment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent b = new Intent(context,AssignmentDisp.class);
                    assignment_id = assignment_list.getAssignment_id();
                    context.startActivity(b);
                }
            });
        }

        @Override
        public int getItemCount() {
            return assignment_lists.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            public TextView Asgn_Title, Asgn_Subject,Asgn_Deadline,Asgn_Desc;
            public CardView linearlayoutAssignment;

            public ViewHolder(View itemView) {
                super(itemView);
                Asgn_Title= itemView.findViewById(R.id.Asgn_Title);
                Asgn_Subject= itemView.findViewById(R.id.Asgn_Subject);
                Asgn_Deadline= itemView.findViewById(R.id.Asgn_Deadline);
                Asgn_Desc= itemView.findViewById(R.id.Asgn_Desc);
                linearlayoutAssignment= itemView.findViewById(R.id.linearlayoutAssignment);
            }
        }
    }


