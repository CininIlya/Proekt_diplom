package com.example.avtoapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avtoapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class AdapterContact  extends RecyclerView.Adapter<AdapterContact.ContactViewHolder>{

    private Context context;
    private ArrayList<ModelContact> contactsList;

    public AdapterContact(Context context, ArrayList<ModelContact> contactsList) {
        this.context = context;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_contact_item,parent,false);  // добавление нового элемента на страницу
        ContactViewHolder vh = new ContactViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        ModelContact modelContact = contactsList.get(position);

        String id = modelContact.getId();
        String  image = modelContact.getImage();
        String  name = modelContact.getName();


        holder.contactName.setText(name); // установка в поле name вводимый текст
        if(image.equals("null")){// проверка изображение на заначение null
            holder.contactImage.setImageResource(R.drawable.baseline_person_24);

        } else{
            holder.contactImage.setImageURI(Uri.parse(image)); // прописание пути к изображению
            holder.contactImage.setClipToOutline(true); // закругление углов
        }
        holder.contactDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
 // переход по нажатия по созданному контакту
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContactDetail.class);
                intent.putExtra("contactId",id);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return contactsList.size();
    }

    class  ContactViewHolder extends RecyclerView.ViewHolder{

        ImageView contactImage,contactDial;

        TextView contactName;


        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            contactImage = itemView.findViewById(R.id.contact_image);
            contactDial = itemView.findViewById(R.id.contact_number_dial);
            contactName = itemView.findViewById(R.id.contact_name);


        }
    }

}
