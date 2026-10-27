package o0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements g {

    /* renamed from: o, reason: collision with root package name */
    public final InputContentInfo f9372o;

    public f(Object obj) {
        this.f9372o = (InputContentInfo) obj;
    }

    @Override // o0.g
    public final ClipDescription a() {
        return this.f9372o.getDescription();
    }

    @Override // o0.g
    public final Object b() {
        return this.f9372o;
    }

    @Override // o0.g
    public final Uri d() {
        return this.f9372o.getContentUri();
    }

    @Override // o0.g
    public final void l() {
        this.f9372o.requestPermission();
    }

    @Override // o0.g
    public final Uri m() {
        return this.f9372o.getLinkUri();
    }

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f9372o = new InputContentInfo(uri, clipDescription, uri2);
    }
}
