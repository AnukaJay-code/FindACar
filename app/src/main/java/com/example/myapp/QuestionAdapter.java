package com.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionAdapter extends ListAdapter<questions, QuestionAdapter.QuestionHolder >{

    // private List<questions> q = new ArrayList<>();
    private OnItemClickListener listener;

    public QuestionAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<questions> DIFF_CALLBACK = new DiffUtil.ItemCallback<questions>() {
        @Override
        public boolean areItemsTheSame(@NonNull questions oldItem, @NonNull questions newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull questions oldItem, @NonNull questions newItem) {
            return oldItem.getQuestions().equals(newItem.getQuestions()) &&
                    oldItem.getDescription().equals(newItem.getDescription());
        }
    };

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.questions_item, parent, false);
        return new QuestionHolder(itemView);
    }

    //getting the data from java to the views
    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {

        questions currentQ = getItem(position);
        holder.textViewQuestion.setText(currentQ.getQuestions());
        holder.textViewDescription.setText(currentQ.getDescription());
    }


    public questions getQestionsAt(int position) {
        return getItem(position);
    }

    class QuestionHolder extends RecyclerView.ViewHolder {
        private TextView textViewQuestion;
        private TextView textViewDescription;


        public QuestionHolder(@NonNull View itemView) {
            super(itemView);

            textViewQuestion = itemView.findViewById(R.id.text_view_question);
            textViewDescription = itemView.findViewById(R.id.text_view_description);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int possition = getAdapterPosition();
                    if (listener != null && possition != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(possition));
                    }
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(questions questions);
    }

    public void setOnItemClickListner(OnItemClickListener listner) {
        this.listener = listner;
    }
}
