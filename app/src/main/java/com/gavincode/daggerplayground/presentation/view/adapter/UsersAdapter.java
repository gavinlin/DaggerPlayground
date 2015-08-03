package com.gavincode.daggerplayground.presentation.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gavincode.daggerplayground.R;
import com.gavincode.daggerplayground.presentation.model.User;
import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gavinlin on 31/07/15.
 */
public class UsersAdapter extends  RecyclerView.Adapter<UsersAdapter.UserViewHolder>{

    public interface OnItemClickListener {
        void onUserItemClicked(User user);
    }

    private List<User> usersCollection;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    public UsersAdapter(@NonNull Context context,@NonNull Collection<User> users) {
        this.layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.usersCollection = (List<User>) users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = this.layoutInflater.inflate(R.layout.user_list_item, viewGroup, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder userViewHolder, int i) {
        final User user = usersCollection.get(i);
        userViewHolder.textViewTitle.setText(user.getLogin());
        //TODO set avatar
        Picasso.with(layoutInflater.getContext()).load(user.getAvatar_url())
                .into(userViewHolder.imageViewAvatar);

        userViewHolder.itemView.setOnClickListener(
                view -> {
                    if (UsersAdapter.this.onItemClickListener != null) {
                        UsersAdapter.this.onItemClickListener.onUserItemClicked(user);
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return (usersCollection != null) ? usersCollection.size() : 0;
    }

    public void setUsersCollection(@NonNull Collection<User> usersCollection) {
        this.usersCollection = (List<User>) usersCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    static class UserViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title)
        TextView textViewTitle;

        @Bind(R.id.avatar)
        ImageView imageViewAvatar;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
