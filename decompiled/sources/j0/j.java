package j0;

import android.net.Uri;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f6930a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6931b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6932c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6933d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6934e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6935f;

    public j(Uri uri, int i10, int i11, boolean z10, int i12) {
        uri.getClass();
        this.f6930a = uri;
        this.f6931b = i10;
        this.f6932c = i11;
        this.f6933d = z10;
        this.f6934e = null;
        this.f6935f = i12;
    }

    public j(String str, String str2) {
        this.f6930a = new Uri.Builder().scheme("systemfont").authority(str).build();
        this.f6931b = 0;
        this.f6932c = 400;
        this.f6933d = false;
        this.f6934e = str2;
        this.f6935f = 0;
    }
}
