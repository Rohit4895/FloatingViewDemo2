package com.example.floatingviewdemo2.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floatingviewdemo2.R;
import com.example.floatingviewdemo2.utils.CallBackOnClick;
import com.example.floatingviewdemo2.utils.Users;

import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.UserViewHolder> implements View.OnClickListener {

    private Context context;
    private List<Users> list;
    private CallBackOnClick callBackOnClick;

    UserInfoAdapter(Context context, List<Users> list, CallBackOnClick callBackOnClick){
        this.context = context;
        this.list = list;
        this.callBackOnClick = callBackOnClick;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_of_users, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Users users = list.get(position);

        holder.textView.setText(users.getUsername());
        holder.textView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.userCredentials:
                callBackOnClick.getUsereDetails();
                break;
            default:
                break;
        }
    }

    public  class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.userCredentials);
        }
    }
}
