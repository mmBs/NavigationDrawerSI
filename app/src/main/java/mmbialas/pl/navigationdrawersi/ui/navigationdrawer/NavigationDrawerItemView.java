package mmbialas.pl.navigationdrawersi.ui.navigationdrawer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import mmbialas.pl.navigationdrawersi.R;
import mmbialas.pl.navigationdrawersi.data.model.NavigationDrawerItem;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class NavigationDrawerItemView extends RelativeLayout {

  @BindView(R.id.itemRR) RelativeLayout rr;

  @BindView(R.id.navigationDrawerItemTitleTV) TextView itemTitleTV;

  @BindView(R.id.navigationDrawerItemIconIV) ImageView itemIconIV;

  final Resources res;

  public NavigationDrawerItemView(Context context) {
    super(context);
    res = context.getResources();
  }

  public NavigationDrawerItemView(Context context, AttributeSet attrs) {
    super(context, attrs);
    res = context.getResources();
  }

  public NavigationDrawerItemView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    res = context.getResources();
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }

  public void bindTo(NavigationDrawerItem item) {
    requestLayout();
    if (item.isMainItem()) {
      itemTitleTV.setText(item.getItemName());
      itemTitleTV.setTextSize(22);
      itemIconIV.setVisibility(View.GONE);
    } else {
      itemTitleTV.setText(item.getItemName());
      itemTitleTV.setTextSize(14);
      itemIconIV.setImageDrawable(getIcon(item.getItemIcon()));
      itemIconIV.setVisibility(View.VISIBLE);
      rr.setBackgroundColor(res.getColor(R.color.grey_background));
    }

    if (item.isSelected()) {
      itemTitleTV.setTypeface(null, Typeface.BOLD);
    } else {
      itemTitleTV.setTypeface(null, Typeface.NORMAL);
    }
  }

  private Drawable getIcon(int res) {
    return getContext().getResources().getDrawable(res);
  }
}
