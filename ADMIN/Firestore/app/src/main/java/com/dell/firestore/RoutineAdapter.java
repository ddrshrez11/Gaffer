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
import android.widget.Toast;

import java.util.List;

public class RoutineAdapter extends  RecyclerView.Adapter<RoutineAdapter.RoutineViewHolder>{

    private List<Routine_list> routine_lists;
    public Context context;
    static int routine_id;

    public RoutineAdapter(List<Routine_list> routine_lists, Context context) {
        this.routine_lists = routine_lists;
        this.context = context;
    }

    @NonNull
    @Override
    public RoutineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_layout_routine,parent,false);
        return new RoutineViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RoutineViewHolder holder, int position) {

        final Routine_list routine_list = routine_lists.get(position);

        holder.textDay.setText(routine_list.getDay());
        holder.textSubject1.setText(routine_list.getSubject1());
        holder.textSubject2.setText(routine_list.getSubject2());
        holder.textSubject3.setText(routine_list.getSubject3());
        holder.textSubject4.setText(routine_list.getSubject4());
        holder.textSubject5.setText(routine_list.getSubject5());
//        final String time1=(routine_list.getTime1());
//        final String time2=(routine_list.getTime2());
//        final String time3=(routine_list.getTime3());
//        final String time4=(routine_list.getTime4());
//        final String time5=(routine_list.getTime5());

        holder.linearlayoutday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent a= new Intent(context,RoutineDisp.class);
                routine_id = routine_list.getSN();
                context.startActivity(a);

//                Toast.makeText(context, "You Clicked "+routine_list.getDay(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return routine_lists.size();
    }



    class RoutineViewHolder extends RecyclerView.ViewHolder{

        public TextView textDay;
        public TextView textSubject1;
        public TextView textSubject2;
        public TextView textSubject3;
        public TextView textSubject4;
        public TextView textSubject5;
        //public TextView time1,time2,time3,time4,time5;
        public CardView linearlayoutday;


        public RoutineViewHolder(View itemView) {
            super(itemView);

            textDay= itemView.findViewById(R.id.textDay);
            textSubject1= itemView.findViewById(R.id.textSubject1);
            textSubject2= itemView.findViewById(R.id.textSubject2);
            textSubject3= itemView.findViewById(R.id.textSubject3);
            textSubject4= itemView.findViewById(R.id.textSubject4);
            textSubject5= itemView.findViewById(R.id.textSubject5);
            linearlayoutday= itemView.findViewById(R.id.linearlayoutDay);

        }
    }

}
