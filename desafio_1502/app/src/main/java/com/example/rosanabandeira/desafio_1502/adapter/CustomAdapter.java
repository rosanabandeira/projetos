package com.example.rosanabandeira.desafio_1502.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.rosanabandeira.desafio_1502.R;
import com.example.rosanabandeira.desafio_1502.databinding.CustomerBinding;
import com.example.rosanabandeira.desafio_1502.viewmodel.CustomerViewModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomView> {

    private ArrayList<CustomerViewModel> arrayList;

    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, ArrayList<CustomerViewModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater == null) {

            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        CustomerBinding customerBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_recycler, parent, false);

        return new CustomView(customerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView customView, int position) {

        CustomerViewModel customerViewModel = arrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        private CustomerBinding customerBinding;


        public CustomView(CustomerBinding customerBinding) {

            super(customerBinding.getRoot());

            this.customerBinding = customerBinding;
        }

        public void bind(CustomerViewModel customerViewModel) {
            this.customerBinding.setCustomerModel(customerViewModel);
            customerBinding.executePendingBingings();

        }

        public CustomerBinding getCustomerBinding() {
            return customerBinding;
        }
    }

}
