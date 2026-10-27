package h3;

import a6.a0;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import l1.t;
import o9.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements l1.h, l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5538o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ long f5539p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f5540q;

    public /* synthetic */ l(m mVar, long j10, int i10) {
        this.f5540q = mVar;
        this.f5539p = j10;
        this.f5538o = i10;
    }

    @Override // l1.h
    public void accept(Object obj) {
        m mVar = (m) this.f5540q;
        a aVar = (a) obj;
        l1.d.h(mVar.f5547h);
        g0 g0Var = aVar.f5521a;
        long j10 = aVar.f5523c;
        a0 a0Var = new a0(29);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(g0Var.size());
        int size = g0Var.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = g0Var.get(i10);
            i10++;
            arrayList.add((Bundle) a0Var.apply(obj2));
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j10);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        t tVar = mVar.f5543c;
        tVar.getClass();
        tVar.G(marshall.length, marshall);
        mVar.f5541a.c(marshall.length, tVar);
        long j11 = aVar.f5522b;
        long j12 = this.f5539p;
        if (j11 == -9223372036854775807L) {
            l1.d.g(mVar.f5547h.f5996s == Long.MAX_VALUE);
        } else {
            long j13 = mVar.f5547h.f5996s;
            j12 = j13 == Long.MAX_VALUE ? j12 + j11 : j11 + j13;
        }
        mVar.f5541a.e(j12, this.f5538o | 1, marshall.length, 0, null);
    }

    @Override // l1.m
    public void invoke(Object obj) {
        t1.a aVar = (t1.a) this.f5540q;
        ((t1.b) obj).v(this.f5538o, this.f5539p, aVar);
    }

    public /* synthetic */ l(t1.a aVar, int i10, long j10, long j11) {
        this.f5540q = aVar;
        this.f5538o = i10;
        this.f5539p = j10;
    }
}
