package androidx.emoji2.text;

import android.os.Build;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends j1.c {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f565b;

    public e(f fVar) {
        this.f565b = fVar;
    }

    @Override // j1.c
    public final void m(Throwable th) {
        this.f565b.f566a.d(th);
    }

    @Override // j1.c
    public final void n(x4.i iVar) {
        f fVar = this.f565b;
        fVar.f568c = iVar;
        x4.i iVar2 = fVar.f568c;
        l lVar = fVar.f566a;
        fVar.f567b = new x4.m(iVar2, lVar.g, lVar.f584i, Build.VERSION.SDK_INT >= 34 ? q.a() : k5.a.m());
        l lVar2 = fVar.f566a;
        lVar2.getClass();
        ArrayList arrayList = new ArrayList();
        lVar2.f577a.writeLock().lock();
        try {
            lVar2.f579c = 1;
            arrayList.addAll(lVar2.f578b);
            lVar2.f578b.clear();
            lVar2.f577a.writeLock().unlock();
            lVar2.f580d.post(new j(arrayList, lVar2.f579c, (Throwable) null));
        } catch (Throwable th) {
            lVar2.f577a.writeLock().unlock();
            throw th;
        }
    }
}
