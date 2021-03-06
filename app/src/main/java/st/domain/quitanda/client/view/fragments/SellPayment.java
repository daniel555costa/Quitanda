package st.domain.quitanda.client.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import st.domain.support.android.model.ImageTextResource;
import st.domain.quitanda.client.R;
import st.domain.quitanda.client.model.visitor.SellCollectorVisitor;
import st.domain.quitanda.client.view.adapters.vholders.SupportSellPayment;
import st.domain.quitanda.client.model.visitor.Collectable;

public class SellPayment extends AbstractStep implements Collectable
{
	private View rootView;
	private SupportSellPayment support;
	private RecyclerView recyclerView;
	private Context context;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}

	@Override
	public void onCreate(@Nullable Bundle restore)
	{
		super.onCreate(restore);
		this.context = this.getActivity();
		this.support = new SupportSellPayment(this.context);
	}

	@Override
	public String name() {
		return new ImageTextResource("Cocluir", R.drawable.img_money_subs).toString();
	}

	@Override
	public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle restore)
	{
		this.rootView = inflater.inflate(R.layout.layout_sell, container, false);
		this.recyclerView = (RecyclerView) this.rootView.findViewById(R.id.recycler_view);
		LinearLayoutManager llm = new LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false);
		this.recyclerView.setLayoutManager(llm);
		this.recyclerView.setAdapter(this.support.getSupportRecyclerAdapter());
		return rootView;
	}

	@Override
	public void accept(SellCollectorVisitor collectorVisitor) {
		collectorVisitor.collectPaymentMode();
	}
}
