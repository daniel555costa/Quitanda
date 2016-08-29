package com.st.ggviario.client.view.adapters.vholders;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.st.dbutil.android.adapter.BaseReclyclerAdapter;
import com.st.dbutil.android.adapter.SupportRecyclerAdapter;
import com.st.ggviario.client.R;
import com.st.ggviario.client.view.activitys.PaymentMode;
import com.st.ggviario.client.view.adapters.ListItemView;

/**
 * Created by Daniel Costa at 8/26/16.
 * Using user computer xdata
 */
public class ModePayment extends BaseReclyclerAdapter.ItemViewHolder implements SupportRecyclerAdapter.OnCreateViewHolder, View.OnClickListener {

    private final RecyclerView recyclerView;
    private final Button btChagePayMode;
    private SupportRecyclerAdapter supportAdapterPayInfo;

    public ModePayment(View itemView)
    {
        super(itemView);
        this.recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_pay_info);
        this.btChagePayMode = (Button) this.itemView.findViewById(R.id.bt_pay_mode_change);
        this.btChagePayMode.setOnClickListener(this);
    }


    @Override
    public BaseReclyclerAdapter.ItemViewHolder onCreateViewHolder(View view, int viewType, int onRecyclerViewId) {
        switch (viewType)
        {
            case R.layout.item_detais:
                ListItemView.ItemViewHolder listItemViewHolder = new ListItemView.ItemViewHolder(view, R.id.item_title);
                listItemViewHolder.setTextSecond1dId(R.id.item_value);
                return listItemViewHolder;
        }
        return null;
    }

    @Override
    public boolean bind(BaseReclyclerAdapter.ItemDataSet itemDataSet, int position)
    {
        super.bind(itemDataSet, position);
        if(supportAdapterPayInfo == null)
        {
            this.supportAdapterPayInfo = new SupportRecyclerAdapter(super.getContext());
            this.supportAdapterPayInfo.setOnCreateViewHolder(this);
            this.supportAdapterPayInfo.useTypeViewAsReferenceLayout(true);


            // O valor não devera ser colocado nessa area (sera colocado apenas para o teste) O ideal e colocar o valor no momento de OnBind

            ListItemView.TextTowLineDataSet dataSet;
            supportAdapterPayInfo.addItemDataSet(dataSet = new ListItemView.TextTowLineDataSet(R.layout.item_detais));
            dataSet.setTextPrimary("Cliente");
            dataSet.setTextSecond1("Anonimo");

            supportAdapterPayInfo.addItemDataSet(dataSet = new ListItemView.TextTowLineDataSet(R.layout.item_detais));
            dataSet.setTextPrimary("Pagamento");
            dataSet.setTextSecond1("Credito");

            supportAdapterPayInfo.addItemDataSet(dataSet = new ListItemView.TextTowLineDataSet(R.layout.item_detais));
            dataSet.setTextPrimary("Data entrega");

            supportAdapterPayInfo.addItemDataSet(dataSet = new ListItemView.TextTowLineDataSet(R.layout.item_detais));
            dataSet.setTextPrimary("Data pagamento");
            dataSet.setTextSecond1("30/10/2016");


            RecyclerView.LayoutManager lm = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            this.recyclerView.setLayoutManager(lm);
            this.recyclerView.setAdapter(this.supportAdapterPayInfo);
        }
        return true;
    }

    @Override
    public void onClick(View view)
    {
        if(view == btChagePayMode)
        {
            Intent intent = new Intent(getContext(), PaymentMode.class);
            getContext().startActivity(intent);
        }
    }
}
