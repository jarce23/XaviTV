package v9;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import t9.f;
import t9.g;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements t9.e, g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12700a = true;

    /* renamed from: b, reason: collision with root package name */
    public final JsonWriter f12701b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f12702c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f12703d;

    /* renamed from: e, reason: collision with root package name */
    public final t9.d f12704e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f12705f;

    public e(BufferedWriter bufferedWriter, HashMap hashMap, HashMap hashMap2, a aVar, boolean z10) {
        this.f12701b = new JsonWriter(bufferedWriter);
        this.f12702c = hashMap;
        this.f12703d = hashMap2;
        this.f12704e = aVar;
        this.f12705f = z10;
    }

    @Override // t9.e
    public final t9.e a(t9.c cVar, Object obj) {
        f(cVar.f12029a, obj);
        return this;
    }

    @Override // t9.g
    public final g b(String str) {
        g();
        this.f12701b.value(str);
        return this;
    }

    @Override // t9.g
    public final g c(boolean z10) {
        g();
        this.f12701b.value(z10);
        return this;
    }

    @Override // t9.e
    public final t9.e d(t9.c cVar, long j10) {
        String str = cVar.f12029a;
        g();
        JsonWriter jsonWriter = this.f12701b;
        jsonWriter.name(str);
        g();
        jsonWriter.value(j10);
        return this;
    }

    public final e e(Object obj) {
        JsonWriter jsonWriter = this.f12701b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        int i10 = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    e(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        f((String) key, entry.getValue());
                    } catch (ClassCastException e7) {
                        throw new t9.b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e7);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            t9.d dVar = (t9.d) this.f12702c.get(obj.getClass());
            if (dVar != null) {
                jsonWriter.beginObject();
                dVar.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            f fVar = (f) this.f12703d.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (obj instanceof Enum) {
                String name = ((Enum) obj).name();
                g();
                jsonWriter.value(name);
                return this;
            }
            jsonWriter.beginObject();
            this.f12704e.a(obj, this);
            jsonWriter.endObject();
            return this;
        }
        if (obj instanceof byte[]) {
            g();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i10 < length) {
                jsonWriter.value(r7[i10]);
                i10++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i10 < length2) {
                long j10 = jArr[i10];
                g();
                jsonWriter.value(j10);
                i10++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i10 < length3) {
                jsonWriter.value(dArr[i10]);
                i10++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i10 < length4) {
                jsonWriter.value(zArr[i10]);
                i10++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i10 < length5) {
                e(numberArr[i10]);
                i10++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i10 < length6) {
                e(objArr[i10]);
                i10++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final e f(String str, Object obj) {
        boolean z10 = this.f12705f;
        JsonWriter jsonWriter = this.f12701b;
        if (z10) {
            if (obj == null) {
                return this;
            }
            g();
            jsonWriter.name(str);
            e(obj);
            return this;
        }
        g();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        e(obj);
        return this;
    }

    public final void g() {
        if (!this.f12700a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
