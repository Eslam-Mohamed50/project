package com.example.projecct;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public  class UserViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public UserViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }
    public void setDetails(String user_Name, String user_Spc, String user_Loc, String user_Phone1, String user_Phone2, String user_name_t, String user_spe_t) {

        TextView name_id=mView.findViewById(R.id.name_id);
        TextView spe_id = mView.findViewById(R.id.spe_id);
        TextView loc_id= mView.findViewById(R.id.loc_id);
        TextView phone1_id =mView.findViewById(R.id.phone1_id);
        TextView phone2_id= mView.findViewById(R.id.phone2_id);
        TextView name_t = mView.findViewById(R.id.name_t);
        TextView spe_t = mView.findViewById(R.id.sep_t);
        name_id.setText(user_Name);
        spe_id.setText(user_Spc);
        loc_id.setText(user_Loc);
        phone1_id.setText(user_Phone1);
        phone2_id.setText(user_Phone2);
        name_t.setText(user_name_t);
        spe_t.setText(user_spe_t);
        }
}
