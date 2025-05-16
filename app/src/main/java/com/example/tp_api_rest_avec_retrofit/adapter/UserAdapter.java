package com.example.tp_api_rest_avec_retrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tp_api_rest_avec_retrofit.R;
import com.example.tp_api_rest_avec_retrofit.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;
    private List<User> filteredList;


    // Ajout d'un constructeur
    public UserAdapter() {
        this.userList = new ArrayList<>();
        this.filteredList = new ArrayList<>();
    }

    public void setUserList(List<User> users) {
        this.userList = users;
        this.filteredList = new ArrayList<>(userList);
        notifyDataSetChanged();
    }

    public void filter(String query) {
        if (query.isEmpty()) {
            filteredList = new ArrayList<>(userList);
        } else {
            List<User> filtered = new ArrayList<>();
            for (User user : userList) {
                if (user.getName().toLowerCase().contains(query.toLowerCase())) {
                    filtered.add(user);
                }
            }
            filteredList = filtered;
        }
        notifyDataSetChanged();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, phone, address;

        public UserViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            email = itemView.findViewById(R.id.userEmail);
            phone = itemView.findViewById(R.id.userPhone);
            address = itemView.findViewById(R.id.userAddress);
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = filteredList.get(position);
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        holder.phone.setText(user.getPhone());
        holder.address.setText(user.getAddress().getCity());
    }

    @Override
    public int getItemCount() {
        return (filteredList != null) ? filteredList.size() : 0;
    }
}