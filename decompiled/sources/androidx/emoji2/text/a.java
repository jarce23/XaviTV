package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f554a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f555b;

    public /* synthetic */ a(String str, int i10) {
        this.f554a = i10;
        this.f555b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f554a) {
            case 0:
                Thread thread = new Thread(runnable, this.f555b);
                thread.setPriority(10);
                return thread;
            default:
                return new Thread(runnable, this.f555b);
        }
    }
}
