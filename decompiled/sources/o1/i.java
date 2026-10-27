package o1;

import java.io.IOException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class i extends IOException {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f9413p = 0;

    /* renamed from: o, reason: collision with root package name */
    public final int f9414o;

    public i(int i10) {
        this.f9414o = i10;
    }

    public i(int i10, Exception exc) {
        super(exc);
        this.f9414o = i10;
    }

    public i(String str, int i10) {
        super(str);
        this.f9414o = i10;
    }

    public i(String str, Exception exc, int i10) {
        super(str, exc);
        this.f9414o = i10;
    }
}
