package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import android.text.format.DateUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b4.o0;
import b4.r0;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f3756a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f3757b;

    public k(l lVar, t tVar) {
        this.f3757b = lVar;
        this.f3756a = tVar;
    }

    @Override // b4.r0
    public final void b(RecyclerView recyclerView, int i10, int i11) {
        int c12;
        String formatDateTime;
        DateFormat instanceForSkeleton;
        TimeZone timeZone;
        DisplayContext unused;
        b bVar = this.f3756a.f3797d;
        l lVar = this.f3757b;
        if (i10 < 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) lVar.f3764o0.getLayoutManager();
            View e12 = linearLayoutManager.e1(0, linearLayoutManager.x(), false);
            c12 = e12 == null ? -1 : o0.N(e12);
        } else {
            c12 = ((LinearLayoutManager) lVar.f3764o0.getLayoutManager()).c1();
        }
        Calendar a10 = x.a(bVar.f3736o.f3781o);
        a10.add(2, c12);
        p pVar = new p(a10);
        lVar.f3760k0 = pVar;
        MaterialButton materialButton = lVar.f3769t0;
        Calendar a11 = x.a(bVar.f3736o.f3781o);
        a11.add(2, c12);
        a11.set(5, 1);
        Calendar a12 = x.a(a11);
        a12.get(2);
        a12.get(1);
        a12.getMaximum(7);
        a12.getActualMaximum(5);
        a12.getTimeInMillis();
        long timeInMillis = a12.getTimeInMillis();
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = Locale.getDefault();
            AtomicReference atomicReference = x.f3800a;
            instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
            timeZone = TimeZone.getTimeZone("UTC");
            instanceForSkeleton.setTimeZone(timeZone);
            unused = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
            instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
            formatDateTime = instanceForSkeleton.format(new Date(timeInMillis));
        } else {
            formatDateTime = DateUtils.formatDateTime(null, timeInMillis, 8228);
        }
        materialButton.setText(formatDateTime);
        lVar.L(bVar.f3736o.d(pVar));
    }
}
