package w9;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements t9.e {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f13151f = Charset.forName("UTF-8");
    public static final t9.c g;

    /* renamed from: h, reason: collision with root package name */
    public static final t9.c f13152h;

    /* renamed from: i, reason: collision with root package name */
    public static final v9.a f13153i;

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f13154a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13155b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f13156c;

    /* renamed from: d, reason: collision with root package name */
    public final t9.d f13157d;

    /* renamed from: e, reason: collision with root package name */
    public final g f13158e = new g(this);

    static {
        a aVar = new a(1);
        HashMap hashMap = new HashMap();
        hashMap.put(d.class, aVar);
        g = new t9.c("key", Collections.unmodifiableMap(new HashMap(hashMap)));
        a aVar2 = new a(2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(d.class, aVar2);
        f13152h = new t9.c("value", Collections.unmodifiableMap(new HashMap(hashMap2)));
        f13153i = new v9.a(1);
    }

    public e(ByteArrayOutputStream byteArrayOutputStream, HashMap hashMap, HashMap hashMap2, t9.d dVar) {
        this.f13154a = byteArrayOutputStream;
        this.f13155b = hashMap;
        this.f13156c = hashMap2;
        this.f13157d = dVar;
    }

    public static int f(t9.c cVar) {
        d dVar = (d) ((Annotation) cVar.f12030b.get(d.class));
        if (dVar != null) {
            return ((a) dVar).f13147a;
        }
        throw new t9.b("Field has no @Protobuf config");
    }

    @Override // t9.e
    public final t9.e a(t9.c cVar, Object obj) {
        c(cVar, obj, true);
        return this;
    }

    public final void b(t9.c cVar, int i10, boolean z10) {
        if (z10 && i10 == 0) {
            return;
        }
        d dVar = (d) ((Annotation) cVar.f12030b.get(d.class));
        if (dVar == null) {
            throw new t9.b("Field has no @Protobuf config");
        }
        g(((a) dVar).f13147a << 3);
        g(i10);
    }

    public final void c(t9.c cVar, Object obj, boolean z10) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z10 && charSequence.length() == 0) {
                return;
            }
            g((f(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f13151f);
            g(bytes.length);
            this.f13154a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                c(cVar, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                e(f13153i, cVar, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (z10 && doubleValue == 0.0d) {
                return;
            }
            g((f(cVar) << 3) | 1);
            this.f13154a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(doubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (z10 && floatValue == 0.0f) {
                return;
            }
            g((f(cVar) << 3) | 5);
            this.f13154a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(floatValue).array());
            return;
        }
        if (obj instanceof Number) {
            long longValue = ((Number) obj).longValue();
            if (z10 && longValue == 0) {
                return;
            }
            d dVar = (d) ((Annotation) cVar.f12030b.get(d.class));
            if (dVar == null) {
                throw new t9.b("Field has no @Protobuf config");
            }
            g(((a) dVar).f13147a << 3);
            h(longValue);
            return;
        }
        if (obj instanceof Boolean) {
            b(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z10);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z10 && bArr.length == 0) {
                return;
            }
            g((f(cVar) << 3) | 2);
            g(bArr.length);
            this.f13154a.write(bArr);
            return;
        }
        t9.d dVar2 = (t9.d) this.f13155b.get(obj.getClass());
        if (dVar2 != null) {
            e(dVar2, cVar, obj, z10);
            return;
        }
        t9.f fVar = (t9.f) this.f13156c.get(obj.getClass());
        if (fVar != null) {
            g gVar = this.f13158e;
            gVar.f13160a = false;
            gVar.f13162c = cVar;
            gVar.f13161b = z10;
            fVar.a(obj, gVar);
            return;
        }
        if (obj instanceof w6.c) {
            b(cVar, ((w6.c) obj).f13127o, true);
        } else if (obj instanceof Enum) {
            b(cVar, ((Enum) obj).ordinal(), true);
        } else {
            e(this.f13157d, cVar, obj, z10);
        }
    }

    @Override // t9.e
    public final t9.e d(t9.c cVar, long j10) {
        if (j10 == 0) {
            return this;
        }
        d dVar = (d) ((Annotation) cVar.f12030b.get(d.class));
        if (dVar == null) {
            throw new t9.b("Field has no @Protobuf config");
        }
        g(((a) dVar).f13147a << 3);
        h(j10);
        return this;
    }

    public final void e(t9.d dVar, t9.c cVar, Object obj, boolean z10) {
        b bVar = new b();
        bVar.f13148o = 0L;
        try {
            OutputStream outputStream = this.f13154a;
            this.f13154a = bVar;
            try {
                dVar.a(obj, this);
                this.f13154a = outputStream;
                long j10 = bVar.f13148o;
                bVar.close();
                if (z10 && j10 == 0) {
                    return;
                }
                g((f(cVar) << 3) | 2);
                h(j10);
                dVar.a(obj, this);
            } catch (Throwable th) {
                this.f13154a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void g(int i10) {
        while ((i10 & (-128)) != 0) {
            this.f13154a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f13154a.write(i10 & 127);
    }

    public final void h(long j10) {
        while (((-128) & j10) != 0) {
            this.f13154a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f13154a.write(((int) j10) & 127);
    }
}
