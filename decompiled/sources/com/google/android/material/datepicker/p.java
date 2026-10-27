package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements Comparable, Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new android.support.v4.media.a(18);

    /* renamed from: o, reason: collision with root package name */
    public final Calendar f3781o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3782p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3783q;

    /* renamed from: r, reason: collision with root package name */
    public final int f3784r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3785s;

    /* renamed from: t, reason: collision with root package name */
    public final long f3786t;

    /* renamed from: u, reason: collision with root package name */
    public String f3787u;

    public p(Calendar calendar) {
        calendar.set(5, 1);
        Calendar a10 = x.a(calendar);
        this.f3781o = a10;
        this.f3782p = a10.get(2);
        this.f3783q = a10.get(1);
        this.f3784r = a10.getMaximum(7);
        this.f3785s = a10.getActualMaximum(5);
        this.f3786t = a10.getTimeInMillis();
    }

    public static p a(int i10, int i11) {
        Calendar c10 = x.c(null);
        c10.set(1, i10);
        c10.set(2, i11);
        return new p(c10);
    }

    public static p b(long j10) {
        Calendar c10 = x.c(null);
        c10.setTimeInMillis(j10);
        return new p(c10);
    }

    public final String c() {
        String formatDateTime;
        DateFormat instanceForSkeleton;
        TimeZone timeZone;
        DisplayContext unused;
        if (this.f3787u == null) {
            long timeInMillis = this.f3781o.getTimeInMillis();
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
            this.f3787u = formatDateTime;
        }
        return this.f3787u;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f3781o.compareTo(((p) obj).f3781o);
    }

    public final int d(p pVar) {
        if (!(this.f3781o instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (pVar.f3782p - this.f3782p) + ((pVar.f3783q - this.f3783q) * 12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f3782p == pVar.f3782p && this.f3783q == pVar.f3783q;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3782p), Integer.valueOf(this.f3783q)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f3783q);
        parcel.writeInt(this.f3782p);
    }
}
