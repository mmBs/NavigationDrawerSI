package mmbialas.pl.navigationdrawersi.data.model;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class NavigationDrawerItem {

  private String itemName;

  private int itemIcon;

  private boolean mainItem;

  private boolean selected;

  public NavigationDrawerItem(String itemName, int itemIcon, boolean mainItem) {
    this.itemName = itemName;
    this.itemIcon = itemIcon;
    this.mainItem = mainItem;
  }

  public NavigationDrawerItem(String itemName, boolean mainItem) {
    this(itemName, 0, mainItem);
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public int getItemIcon() {
    return itemIcon;
  }

  public void setItemIcon(int itemIcon) {
    this.itemIcon = itemIcon;
  }

  public boolean isMainItem() {
    return mainItem;
  }

  public void setMainItem(boolean mainItem) {
    this.mainItem = mainItem;
  }

  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }
}
