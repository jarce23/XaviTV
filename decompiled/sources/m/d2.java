package m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d2 extends o1 {
    public final int A;
    public final int B;
    public a2 C;
    public l.n D;

    public d2(Context context, boolean z10) {
        super(context, z10);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.A = 21;
            this.B = 22;
        } else {
            this.A = 22;
            this.B = 21;
        }
    }

    @Override // m.o1, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        l.i iVar;
        int i10;
        int pointToPosition;
        int i11;
        if (this.C != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i10 = headerViewListAdapter.getHeadersCount();
                iVar = (l.i) headerViewListAdapter.getWrappedAdapter();
            } else {
                iVar = (l.i) adapter;
                i10 = 0;
            }
            l.n item = (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i11 = pointToPosition - i10) < 0 || i11 >= iVar.getCount()) ? null : iVar.getItem(i11);
            l.n nVar = this.D;
            if (nVar != item) {
                l.l lVar = iVar.f7981o;
                if (nVar != null) {
                    this.C.q(lVar, nVar);
                }
                this.D = item;
                if (item != null) {
                    this.C.m(lVar, item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i10 == this.A) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i10 != this.B) {
            return super.onKeyDown(i10, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (l.i) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (l.i) adapter).f7981o.c(false);
        return true;
    }

    public void setHoverListener(a2 a2Var) {
        this.C = a2Var;
    }

    @Override // m.o1, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
