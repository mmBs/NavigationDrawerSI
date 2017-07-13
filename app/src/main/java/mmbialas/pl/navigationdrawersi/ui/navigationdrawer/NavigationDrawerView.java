package mmbialas.pl.navigationdrawersi.ui.navigationdrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import mmbialas.pl.navigationdrawersi.R;
import mmbialas.pl.navigationdrawersi.data.model.NavigationDrawerItem;
import mmbialas.pl.navigationdrawersi.ui.misc.BetterViewAnimator;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class NavigationDrawerView extends BetterViewAnimator {

  @BindView(R.id.leftDrawerListView) ListView leftDrawerListView;

  private final NavigationDrawerAdapter adapter;

  public NavigationDrawerView(Context context, AttributeSet attrs) {
    super(context, attrs);
    adapter = new NavigationDrawerAdapter(context);
  }

  public void replaceWith(List<NavigationDrawerItem> items) {
    adapter.replaceWith(items);
    setDisplayedChildId(R.id.leftDrawerListView);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);
    leftDrawerListView.setAdapter(adapter);
  }

  public NavigationDrawerAdapter getAdapter() {
    return adapter;
  }
}
