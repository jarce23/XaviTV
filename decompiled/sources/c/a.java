package c;

import androidx.emoji2.text.o;
import com.google.android.gms.internal.cast.a0;
import com.google.android.gms.internal.cast.z;
import j9.v1;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;
import m6.f;
import m6.g;
import p4.p;
import q4.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements z, g {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2491o;

    /* renamed from: p, reason: collision with root package name */
    public volatile Object f2492p;

    /* renamed from: q, reason: collision with root package name */
    public Object f2493q;

    public /* synthetic */ a(int i10, Object obj) {
        this.f2491o = i10;
        this.f2493q = obj;
    }

    @Override // com.google.android.gms.internal.cast.z
    public Object a() {
        z zVar = (z) this.f2492p;
        a0 a0Var = a0.f3238o;
        if (zVar != a0Var) {
            synchronized (this) {
                try {
                    if (((z) this.f2492p) != a0Var) {
                        Object a10 = ((z) this.f2492p).a();
                        this.f2493q = a10;
                        this.f2492p = a0Var;
                        return a10;
                    }
                } finally {
                }
            }
        }
        return this.f2493q;
    }

    public v5.a b() {
        if (((v5.a) this.f2492p) == null) {
            synchronized (this) {
                try {
                    if (((v5.a) this.f2492p) == null) {
                        File cacheDir = ((o) ((p) this.f2493q).f9953p).f591o.getCacheDir();
                        d dVar = null;
                        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
                        if (file != null && (file.isDirectory() || file.mkdirs())) {
                            dVar = new d(file);
                        }
                        this.f2492p = dVar;
                    }
                    if (((v5.a) this.f2492p) == null) {
                        this.f2492p = new v1(23);
                    }
                } finally {
                }
            }
        }
        return (v5.a) this.f2492p;
    }

    @Override // m6.g
    public Object get() {
        if (this.f2492p == null) {
            synchronized (this) {
                try {
                    if (this.f2492p == null) {
                        Object obj = ((g) this.f2493q).get();
                        f.c("Argument must not be null", obj);
                        this.f2492p = obj;
                    }
                } finally {
                }
            }
        }
        return this.f2492p;
    }

    public String toString() {
        switch (this.f2491o) {
            case 1:
                Object obj = (z) this.f2492p;
                if (obj == a0.f3238o) {
                    obj = android.support.v4.media.d.q("<supplier that returned ", String.valueOf(this.f2493q), ">");
                }
                return android.support.v4.media.d.q("Suppliers.memoize(", String.valueOf(obj), ")");
            default:
                return super.toString();
        }
    }

    public a(int i10) {
        this.f2491o = i10;
        switch (i10) {
            case 1:
                break;
            default:
                this.f2493q = new CopyOnWriteArraySet();
                break;
        }
    }
}
