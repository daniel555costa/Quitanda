package st.domain.quitanda.client.view.activitys;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.idescout.sql.SqlScoutServer;
import st.domain.support.android.beans.CallbackControler;
import st.domain.support.android.fragment.GeralActivityPager;
import st.domain.support.android.model.CallbackClient;
import st.domain.support.android.model.Divice;
import st.domain.support.android.socket.ClientSocketListener;
import st.domain.support.android.socket.NetIntent;
import st.domain.support.android.sqlite.AssetsDataBase;
import st.domain.support.android.text.XTextName;
import st.domain.support.android.view.SlidingTabLayout;
import st.domain.quitanda.client.R;
import st.domain.quitanda.client.references.RData;
import st.domain.quitanda.client.references.RMap;
import st.domain.quitanda.client.view.fragments.BlanckFragment;
import st.domain.quitanda.client.view.fragments.MainHome;

public class Quitanda extends GeralActivityPager implements ClientSocketListener.OnTreatNetIntent, CallbackClient{
    public static final String SOCKET_SERVICE = "SOCKET_SERVICE";

    private ClientSocketListener service;
    private ViewPager pager;
    private SlidingTabLayout slidingLayout;
    private Toolbar tollbar;
    private String host;
    private Divice divice;

    public Quitanda() {
        XTextName.apllyText(RData.class, XTextName.ApplyMode.ORIGINAL, XTextName.ApplyRange.CLASS_ONLY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqlScoutServer.create(this, getPackageName());

        this.pager = (ViewPager) this.findViewById(R.id.pagerInit);
        this.slidingLayout = (SlidingTabLayout) this.findViewById(R.id.tabs_init);
        this.tollbar = (Toolbar) this.findViewById(R.id.toolbar_top);



        this.tollbar.setTitle(R.string.app_name);
        this.setSupportActionBar(this.tollbar);
        tollbar.setTitleTextColor(getResources().getColor(R.color.white));

        MainHome home = new MainHome();
        BlanckFragment blank1 = new BlanckFragment();
        BlanckFragment blank2 = new BlanckFragment();

        this.divice = new Divice("Daniel");
        this.host = "192.168.43.28";
        this.service = new ClientSocketListener(this.host, RMap.SOCKET_PORT, this.divice.getMac(), this, this);

        this.slidingLayout.useColorizerOnTextColor(true);



        super.addFragment(home);
        super.addFragment(blank1);
        super.setViewPager(this.pager);
        super.setTabLayout(this.slidingLayout);
        super.setDistributeEvenly(false);
        super.setSelectedIndicatorColor(getResources().getColor(R.color.white));
        super.setUp();
        CallbackControler.inOutingNet(this);

        AssetsDataBase data = new AssetsDataBase(this, RData.DATABASE_NAME, RData.DATABASE_VERSION);
//        data.restory();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_toolbar_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean canTreat(NetIntent intent)
    {
        return false;
    }

    @Override
    public NetIntent treat(NetIntent intent)
    {
        return null;
    }

    @Override
    public void onConnectionResult(NetIntent.ConnectionStatus status)
    {
        Log.i("DBA:APP.TEST", getClass().getSimpleName()+"-> Result connection "+status);
    }

    /**
     *
     * @param sendType o tipo de envio para todos ao apenas para a activite
     * Recoperar o valor enviado de um outro fragmento
     * @param origem O fragmento que enviou o valor
     * @param summary O codigo do valor
     * @param values O valor enviado
     */
    @Override
    public void onReceive(SendType sendType, CallbackClient origem, String summary, Object[] values)
    {
        if(summary.equals(RMap.SUMMARY_REGISTER_TREATER_LISTNER)) registerTreat(origem);
    }

    public void registerTreat(CallbackClient origem)
    {
        if(origem instanceof ClientSocketListener.OnTreatNetIntent)
            this.service.addTreater((ClientSocketListener.OnTreatNetIntent) origem);
        else Log.e("DBA:APP.TEST", "Can not registerTreat terater "+origem.getProtocolKey()+" this not support "+ClientSocketListener.OnTreatNetIntent.class.getName());
    }

    @Override
    public Bundle query(CallbackClient clientOrigen, String queryQuention, Object... inParams) {
        Bundle bundle = new Bundle();
        if(queryQuention.equals(RMap.QUERY_GET_SOCKET_SERVICE))
            bundle.putSerializable(Quitanda.SOCKET_SERVICE, this.service);
        return bundle;
    }

    @Override
    public CharSequence getProtocolKey() {
        return RMap.IDENTIFIER_QUITANDA;
    }
}
