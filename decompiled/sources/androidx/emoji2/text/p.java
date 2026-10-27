package androidx.emoji2.text;

import android.os.Trace;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements Runnable {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ p f592p = new p(1);

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f593o;

    public /* synthetic */ p(int i10) {
        this.f593o = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f593o) {
            case 0:
                try {
                    int i10 = i0.j.f5790a;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (l.f576k != null) {
                        l.a().c();
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th) {
                    int i11 = i0.j.f5790a;
                    Trace.endSection();
                    throw th;
                }
            default:
                return;
        }
    }

    private final /* synthetic */ void a() {
    }
}
