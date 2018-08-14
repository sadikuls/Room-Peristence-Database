package com.sadikul.stepstoroom.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sadikul.stepstoroom.R;
import com.sadikul.stepstoroom.User;
import com.sadikul.stepstoroom.ViewModel.UserViewModel;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        private UserViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.name);
        }
    }

    private final LayoutInflater mInflater;
    private List<User> mUsers; // Cached copy of words

    public UserAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_recyclerview, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        if (mUsers != null) {
            User current = mUsers.get(position);
            holder.tvName.setText(current.getUserName());
        } else {
            // Covers the case of data not being ready yet.
            holder.tvName.setText("No user");
        }
    }



    void setWords(List<User> users){
        mUsers = users;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mUsers != null)
            return mUsers.size();
        else return 0;
    }
}
