package cn.colintree.aix.SwipeRefresh;

import android.content.res.Resources;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.ListView;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;
import com.google.appinventor.components.runtime.util.YailList;

@SimpleObject(external = true)
@DesignerComponent(category = ComponentCategory.EXTENSION, description = "by ColinTree at http://aix.colintree.cn", iconName = "aiwebres/icon.png", nonVisible = true, version = 2)
@UsesLibraries(libraries = "support-v4.aar")
public class SwipeRefresh extends AndroidNonvisibleComponent implements Component {
    private static final String LOG_TAG = "SwipeRefresh";
    public static final int VERSION = 2;
    private int backgroundColor = -328966;
    private YailList colorList;
    private ComponentContainer container;
    private int dragEnd = 150;
    private int dragStart = 0;
    private boolean enabled = true;
    private boolean large = false;
    private boolean nestedScrollingEnabled = true;
    private Resources res;
    private boolean scale = true;
    private SwipeRefreshLayout srl;

    public SwipeRefresh(ComponentContainer container2) {
        super(container2.$form());
        Log.d(LOG_TAG, "SwipeRefresh Created");
        this.container = container2;
        this.res = container2.$context().getResources();
        ColorList(YailList.makeList(new Object[]{Integer.valueOf(_Color_holo_blue_bright()), Integer.valueOf(_Color_holo_green_light()), Integer.valueOf(_Color_holo_orange_light()), Integer.valueOf(_Color_holo_red_light())}));
    }

    @SimpleEvent
    public void Refresh() {
        EventDispatcher.dispatchEvent(this, "Refresh", new Object[0]);
    }

    @SimpleFunction
    public void CancelRefreshing() {
        if (this.srl != null) {
            Refreshing(false);
        }
    }

    @SimpleProperty
    public void Refreshing(boolean refreshing) {
        if (this.srl != null) {
            this.srl.setRefreshing(refreshing);
        }
    }

    @SimpleProperty
    public boolean Refreshing() {
        if (this.srl != null) {
            return this.srl.isRefreshing();
        }
        return false;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty
    public void Enabled(boolean enabled2) {
        this.enabled = enabled2;
        if (this.srl != null) {
            this.srl.setEnabled(enabled2);
        }
    }

    @SimpleProperty
    public boolean Enabled() {
        return this.enabled;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty
    public void NestedScrollingEnabled(boolean enabled2) {
        this.nestedScrollingEnabled = enabled2;
        if (this.srl != null) {
            this.srl.setNestedScrollingEnabled(enabled2);
        }
    }

    @SimpleProperty
    public boolean NestedScrollingEnabled() {
        if (this.srl != null) {
            return this.srl.isNestedScrollingEnabled();
        }
        return this.nestedScrollingEnabled;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void SizeLarge(boolean large2) {
        this.large = large2;
        if (this.srl != null) {
            this.srl.setSize(large2 ? 0 : 1);
        }
    }

    @SimpleProperty
    public boolean SizeLarge() {
        return this.large;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty
    public void DragScale(boolean scale2) {
        this.scale = scale2;
        if (this.srl != null) {
            this.srl.setProgressViewOffset(DragScale(), DragStart(), DragStart());
        }
    }

    @SimpleProperty
    public boolean DragScale() {
        return this.scale;
    }

    @DesignerProperty(defaultValue = "0", editorType = "non_negative_integer")
    @SimpleProperty
    public void DragStart(int dragStart2) {
        this.dragStart = dragStart2;
        if (this.srl != null) {
            this.srl.setProgressViewOffset(DragScale(), DragStart(), DragStart());
        }
    }

    @SimpleProperty
    public int DragStart() {
        return this.dragStart;
    }

    @DesignerProperty(defaultValue = "150", editorType = "non_negative_integer")
    @SimpleProperty
    public void DragEnd(int dragEnd2) {
        this.dragEnd = dragEnd2;
        if (this.srl != null) {
            this.srl.setProgressViewOffset(DragScale(), DragStart(), DragEnd());
        }
    }

    @SimpleProperty
    public int DragEnd() {
        return this.dragEnd;
    }

    @DesignerProperty(defaultValue = "&H00000000", editorType = "color")
    @SimpleProperty(description = "have to use the color that provided here")
    public void BackgroundColor(int color) {
        if (color == 0) {
            color = -328966;
        }
        this.backgroundColor = color;
        if (this.srl != null) {
            this.srl.setProgressBackgroundColorSchemeColor(color);
        }
    }

    @SimpleProperty
    public int BackgroundColor() {
        return this.backgroundColor;
    }

    @SimpleProperty
    public void ColorList(YailList list) {
        if (list != null && this.srl != null) {
            this.colorList = list;
            int[] color = new int[list.size()];
            for (int i = list.size() - 1; i >= 0; i--) {
                color[i] = Integer.parseInt(list.getString(i));
            }
            this.srl.setColorSchemeColors(color);
        }
    }

    @SimpleProperty
    public YailList ColorList() {
        return this.colorList;
    }

    @SimpleFunction(description = "Vertical Scroll Arrangement allowed only")
    public void RegisterArrangement(VerticalScrollArrangement arrangement) {
        register(arrangement);
    }

    @SimpleFunction(description = "Vertical Scroll Arrangement allowed only")
    public void RegisterListView(ListView listView) {
        register(listView);
    }

    private void register(AndroidViewComponent component) {
        if (this.srl == null) {
            this.srl = new SwipeRefreshLayout(this.container.$context());
            Enabled(Enabled());
            NestedScrollingEnabled(NestedScrollingEnabled());
            DragScale(DragScale());
            DragStart(DragStart());
            DragEnd(DragEnd());
            SizeLarge(SizeLarge());
            BackgroundColor(BackgroundColor());
            ColorList(ColorList());
            this.srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                public void onRefresh() {
                    SwipeRefresh.this.Refresh();
                }
            });
            View child = component.getView();
            ViewGroup vg = (ViewGroup) child.getParent();
            if (vg.getChildCount() > 0) {
                vg.addView(this.srl, vg.indexOfChild(child));
                vg.removeView(child);
                this.srl.addView(child);
            }
        }
    }

    @SimpleFunction
    public int _Color_holo_blue_bright() {
        return this.res.getColor(17170459);
    }

    @SimpleFunction
    public int _Color_holo_blue_dark() {
        return this.res.getColor(17170451);
    }

    @SimpleFunction
    public int _Color_holo_blue_light() {
        return this.res.getColor(17170450);
    }

    @SimpleFunction
    public int _Color_holo_green_dark() {
        return this.res.getColor(17170453);
    }

    @SimpleFunction
    public int _Color_holo_green_light() {
        return this.res.getColor(17170452);
    }

    @SimpleFunction
    public int _Color_holo_orange_dark() {
        return this.res.getColor(17170457);
    }

    @SimpleFunction
    public int _Color_holo_orange_light() {
        return this.res.getColor(17170456);
    }

    @SimpleFunction
    public int _Color_holo_purple() {
        return this.res.getColor(17170458);
    }

    @SimpleFunction
    public int _Color_holo_red_dark() {
        return this.res.getColor(17170455);
    }

    @SimpleFunction
    public int _Color_holo_red_light() {
        return this.res.getColor(17170454);
    }
}
