package o4;

import android.media.MediaCodec;
import android.os.Build;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f9473a;

    /* renamed from: b, reason: collision with root package name */
    public int f9474b;

    /* renamed from: c, reason: collision with root package name */
    public int f9475c;

    /* renamed from: d, reason: collision with root package name */
    public int f9476d;

    /* renamed from: e, reason: collision with root package name */
    public Object f9477e;

    /* renamed from: f, reason: collision with root package name */
    public Object f9478f;
    public Object g;

    /* renamed from: h, reason: collision with root package name */
    public Object f9479h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f9480i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f9481j;

    public a(q qVar) {
        this.f9477e = k5.a.b(false);
        this.f9478f = k5.a.b(true);
        this.g = new q();
        this.f9479h = new x();
        this.f9480i = q.f9513a;
        this.f9481j = new h5.i(29);
        this.f9473a = 4;
        this.f9474b = Integer.MAX_VALUE;
        this.f9476d = Build.VERSION.SDK_INT == 23 ? 10 : 20;
        this.f9475c = 8;
    }

    public a() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f9480i = cryptoInfo;
        this.f9481j = Build.VERSION.SDK_INT >= 24 ? new x4.c(cryptoInfo) : null;
    }
}
