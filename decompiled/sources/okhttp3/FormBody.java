package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.url._UrlKt;
import rb.l;
import rb.m;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class FormBody extends RequestBody {
    private final List<String> encodedNames;
    private final List<String> encodedValues;
    public static final Companion Companion = new Companion(null);
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder add(String str, String str2) {
            h.e("name", str);
            h.e("value", str2);
            this.names.add(_UrlKt.canonicalizeWithCharset$default(str, 0, 0, _UrlKt.FORM_ENCODE_SET, false, false, false, false, this.charset, 91, null));
            this.values.add(_UrlKt.canonicalizeWithCharset$default(str2, 0, 0, _UrlKt.FORM_ENCODE_SET, false, false, false, false, this.charset, 91, null));
            return this;
        }

        public final Builder addEncoded(String str, String str2) {
            h.e("name", str);
            h.e("value", str2);
            this.names.add(_UrlKt.canonicalizeWithCharset$default(str, 0, 0, _UrlKt.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            this.values.add(_UrlKt.canonicalizeWithCharset$default(str2, 0, 0, _UrlKt.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            return this;
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public /* synthetic */ Builder(Charset charset, int i10, e eVar) {
            this((i10 & 1) != 0 ? null : charset);
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public FormBody(List<String> list, List<String> list2) {
        h.e("encodedNames", list);
        h.e("encodedValues", list2);
        this.encodedNames = _UtilJvmKt.toImmutableList(list);
        this.encodedValues = _UtilJvmKt.toImmutableList(list2);
    }

    private final long writeOrCountBytes(m mVar, boolean z10) {
        l b2;
        if (z10) {
            b2 = new l();
        } else {
            h.b(mVar);
            b2 = mVar.b();
        }
        int size = this.encodedNames.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                b2.X(38);
            }
            b2.e0(this.encodedNames.get(i10));
            b2.X(61);
            b2.e0(this.encodedValues.get(i10));
        }
        if (!z10) {
            return 0L;
        }
        long j10 = b2.f11035p;
        b2.a();
        return j10;
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m44deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final String encodedName(int i10) {
        return this.encodedNames.get(i10);
    }

    public final String encodedValue(int i10) {
        return this.encodedValues.get(i10);
    }

    public final String name(int i10) {
        return _UrlKt.percentDecode$default(encodedName(i10), 0, 0, true, 3, null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String value(int i10) {
        return _UrlKt.percentDecode$default(encodedValue(i10), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(m mVar) {
        h.e("sink", mVar);
        writeOrCountBytes(mVar, false);
    }
}
