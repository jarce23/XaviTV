package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f1319o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ s f1320p;

    public j(s sVar, boolean z10) {
        this.f1320p = sVar;
        this.f1319o = z10;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int i10;
        HashMap hashMap;
        HashMap hashMap2;
        Bitmap bitmap;
        s sVar = this.f1320p;
        sVar.H.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (sVar.f1403t0) {
            sVar.f1405u0 = true;
            return;
        }
        w3.z zVar = sVar.f1408w;
        int i11 = sVar.O.getLayoutParams().height;
        s.o(sVar.O, -1);
        sVar.u(sVar.i());
        View decorView = sVar.getWindow().getDecorView();
        decorView.measure(View.MeasureSpec.makeMeasureSpec(sVar.getWindow().getAttributes().width, 1073741824), 0);
        s.o(sVar.O, i11);
        if (!(sVar.I.getDrawable() instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) sVar.I.getDrawable()).getBitmap()) == null) {
            i10 = 0;
        } else {
            i10 = sVar.l(bitmap.getWidth(), bitmap.getHeight());
            sVar.I.setScaleType(bitmap.getWidth() >= bitmap.getHeight() ? ImageView.ScaleType.FIT_XY : ImageView.ScaleType.FIT_CENTER);
        }
        int m10 = sVar.m(sVar.i());
        int size = sVar.U.size();
        int size2 = sVar.n() ? Collections.unmodifiableList(zVar.f13088u).size() * sVar.f1387c0 : 0;
        if (size > 0) {
            size2 += sVar.f1389e0;
        }
        int min = Math.min(size2, sVar.f1388d0);
        if (!sVar.f1402s0) {
            min = 0;
        }
        int max = Math.max(i10, min) + m10;
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int height = rect.height() - (sVar.G.getMeasuredHeight() - sVar.H.getMeasuredHeight());
        if (i10 <= 0 || max > height) {
            if (sVar.O.getMeasuredHeight() + sVar.S.getLayoutParams().height >= sVar.H.getMeasuredHeight()) {
                sVar.I.setVisibility(8);
            }
            max = min + m10;
            i10 = 0;
        } else {
            sVar.I.setVisibility(0);
            s.o(sVar.I, i10);
        }
        if (!sVar.i() || max > height) {
            sVar.P.setVisibility(8);
        } else {
            sVar.P.setVisibility(0);
        }
        sVar.u(sVar.P.getVisibility() == 0);
        int m11 = sVar.m(sVar.P.getVisibility() == 0);
        int max2 = Math.max(i10, min) + m11;
        if (max2 > height) {
            min -= max2 - height;
        } else {
            height = max2;
        }
        sVar.O.clearAnimation();
        sVar.S.clearAnimation();
        sVar.H.clearAnimation();
        boolean z10 = this.f1319o;
        if (z10) {
            sVar.h(sVar.O, m11);
            sVar.h(sVar.S, min);
            sVar.h(sVar.H, height);
        } else {
            s.o(sVar.O, m11);
            s.o(sVar.S, min);
            s.o(sVar.H, height);
        }
        s.o(sVar.F, rect.height());
        List unmodifiableList = Collections.unmodifiableList(zVar.f13088u);
        if (unmodifiableList.isEmpty()) {
            sVar.U.clear();
            sVar.T.notifyDataSetChanged();
            return;
        }
        if (new HashSet(sVar.U).equals(new HashSet(unmodifiableList))) {
            sVar.T.notifyDataSetChanged();
            return;
        }
        if (z10) {
            OverlayListView overlayListView = sVar.S;
            r rVar = sVar.T;
            hashMap = new HashMap();
            int firstVisiblePosition = overlayListView.getFirstVisiblePosition();
            for (int i12 = 0; i12 < overlayListView.getChildCount(); i12++) {
                Object item = rVar.getItem(firstVisiblePosition + i12);
                View childAt = overlayListView.getChildAt(i12);
                hashMap.put(item, new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()));
            }
        } else {
            hashMap = null;
        }
        if (z10) {
            Context context = sVar.f1410x;
            OverlayListView overlayListView2 = sVar.S;
            r rVar2 = sVar.T;
            hashMap2 = new HashMap();
            int firstVisiblePosition2 = overlayListView2.getFirstVisiblePosition();
            for (int i13 = 0; i13 < overlayListView2.getChildCount(); i13++) {
                Object item2 = rVar2.getItem(firstVisiblePosition2 + i13);
                View childAt2 = overlayListView2.getChildAt(i13);
                Bitmap createBitmap = Bitmap.createBitmap(childAt2.getWidth(), childAt2.getHeight(), Bitmap.Config.ARGB_8888);
                childAt2.draw(new Canvas(createBitmap));
                hashMap2.put(item2, new BitmapDrawable(context.getResources(), createBitmap));
            }
        } else {
            hashMap2 = null;
        }
        ArrayList arrayList = sVar.U;
        HashSet hashSet = new HashSet(unmodifiableList);
        hashSet.removeAll(arrayList);
        sVar.V = hashSet;
        HashSet hashSet2 = new HashSet(sVar.U);
        hashSet2.removeAll(unmodifiableList);
        sVar.W = hashSet2;
        sVar.U.addAll(0, sVar.V);
        sVar.U.removeAll(sVar.W);
        sVar.T.notifyDataSetChanged();
        if (z10 && sVar.f1402s0) {
            if (sVar.W.size() + sVar.V.size() > 0) {
                sVar.S.setEnabled(false);
                sVar.S.requestLayout();
                sVar.f1403t0 = true;
                sVar.S.getViewTreeObserver().addOnGlobalLayoutListener(new l(sVar, hashMap, hashMap2));
                return;
            }
        }
        sVar.V = null;
        sVar.W = null;
    }
}
