package com.example.recyclewviewllamar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorUsuario  extends RecyclerView.Adapter<AdaptadorUsuario.MyViewHolder>{

    List<Usuario> usersList;

    private ItemClickListener mitemListener;
    public AdaptadorUsuario(List<Usuario> userList , ItemClickListener itemClickListener)
    {
        this.usersList = userList;
        this.mitemListener = itemClickListener;

    }

    public AdaptadorUsuario(ArrayList<Usuario> usersList)
    {
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView nameTxt;
        private TextView phoneTxt;

        public MyViewHolder(final View view)
        {
            super(view);
            nameTxt = view.findViewById(R.id.txt1);
            phoneTxt = view.findViewById(R.id.txt2);
        }

    }

    @NonNull
    @Override
    public AdaptadorUsuario.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_users,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorUsuario.MyViewHolder holder, int position) {
        String name = usersList.get(position).getUsername();
        holder.nameTxt.setText(name);
        String phone = usersList.get(position).getPhone();
        holder.phoneTxt.setText(phone);

        holder.itemView.setOnClickListener(view -> {
            mitemListener.onItemClick(usersList.get(position));//esto da la posicion de nuestros items en el recycleview..
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }


    public interface ItemClickListener
    {
        void onItemClick(Usuario item);
    }

}
