package com.bumptech.glide.load.data;

import a6.e0;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements f {

    /* renamed from: q, reason: collision with root package name */
    public static final b6.a f3041q = new b6.a(1);

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3042o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f3043p;

    public g() {
        this.f3042o = 0;
        this.f3043p = new HashMap();
    }

    @Override // com.bumptech.glide.load.data.f
    public Object a() {
        switch (this.f3042o) {
            case 1:
                return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f3043p).rewind();
            case 2:
                return this.f3043p;
            default:
                e0 e0Var = (e0) this.f3043p;
                e0Var.reset();
                return e0Var;
        }
    }

    @Override // com.bumptech.glide.load.data.f
    public void b() {
        switch (this.f3042o) {
            case 1:
            case 2:
                break;
            default:
                ((e0) this.f3043p).c();
                break;
        }
    }

    public ParcelFileDescriptor e() {
        return ((ParcelFileDescriptorRewinder$InternalRewinder) this.f3043p).rewind();
    }

    public g(InputStream inputStream, u5.f fVar) {
        this.f3042o = 3;
        e0 e0Var = new e0(inputStream, fVar);
        this.f3043p = e0Var;
        e0Var.mark(5242880);
    }

    public g(ParcelFileDescriptor parcelFileDescriptor) {
        this.f3042o = 1;
        this.f3043p = new ParcelFileDescriptorRewinder$InternalRewinder(parcelFileDescriptor);
    }

    public g(Object obj) {
        this.f3042o = 2;
        this.f3043p = obj;
    }

    private final void c() {
    }

    private final void d() {
    }
}
