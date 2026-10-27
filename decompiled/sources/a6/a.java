package a6;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.InputStream;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements r5.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f32a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f33b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f34c;

    public /* synthetic */ a(Object obj, int i10, Object obj2) {
        this.f32a = i10;
        this.f33b = obj;
        this.f34c = obj2;
    }

    @Override // r5.j
    public final boolean a(Object obj, r5.h hVar) {
        switch (this.f32a) {
            case 0:
                return ((r5.j) this.f33b).a(obj, hVar);
            case 1:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                ((s) this.f33b).getClass();
                return true;
        }
    }

    @Override // r5.j
    public final t5.y b(Object obj, int i10, int i11, r5.h hVar) {
        boolean z10;
        e0 e0Var;
        m6.e eVar;
        switch (this.f32a) {
            case 0:
                t5.y b2 = ((r5.j) this.f33b).b(obj, i10, i11, hVar);
                Resources resources = (Resources) this.f34c;
                if (b2 == null) {
                    return null;
                }
                return new e(resources, b2);
            case 1:
                t5.y c10 = ((c6.c) this.f33b).c((Uri) obj, hVar);
                if (c10 == null) {
                    return null;
                }
                return u.b((u5.a) this.f34c, (Drawable) ((c6.b) c10).get(), i10, i11);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof e0) {
                    e0Var = (e0) inputStream;
                    z10 = false;
                } else {
                    z10 = true;
                    e0Var = new e0(inputStream, (u5.f) this.f34c);
                }
                ArrayDeque arrayDeque = m6.e.f9010q;
                synchronized (arrayDeque) {
                    eVar = (m6.e) arrayDeque.poll();
                }
                if (eVar == null) {
                    eVar = new m6.e();
                }
                m6.e eVar2 = eVar;
                eVar2.f9011o = e0Var;
                m6.k kVar = new m6.k(eVar2);
                x4.c cVar = new x4.c(e0Var, 1, eVar2);
                try {
                    s sVar = (s) this.f33b;
                    e a10 = sVar.a(new x4.m(kVar, sVar.f100d, sVar.f99c), i10, i11, hVar, cVar);
                    eVar2.a();
                    if (z10) {
                        e0Var.c();
                    }
                    return a10;
                } finally {
                }
        }
    }

    public a(Resources resources, r5.j jVar) {
        this.f32a = 0;
        this.f34c = resources;
        this.f33b = jVar;
    }
}
