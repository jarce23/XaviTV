package okhttp3;

import gb.i;
import gb.p;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import la.d;
import okhttp3.internal._HeadersCommonKt;
import okhttp3.internal.http.DateFormattingKt;
import okhttp3.internal.url._UrlKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import za.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Headers implements Iterable<d>, ab.a {
    public static final Companion Companion = new Companion(null);
    public static final Headers EMPTY = new Headers(new String[0]);
    private final String[] namesAndValues;

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String str) {
            h.e("line", str);
            int e02 = i.e0(str, ':', 0, 6);
            if (e02 == -1) {
                throw new IllegalArgumentException("Unexpected header: ".concat(str).toString());
            }
            String substring = str.substring(0, e02);
            h.d("substring(...)", substring);
            String obj = i.o0(substring).toString();
            String substring2 = str.substring(e02 + 1);
            h.d("substring(...)", substring2);
            add(obj, substring2);
            return this;
        }

        public final Builder addAll(Headers headers) {
            h.e("headers", headers);
            return _HeadersCommonKt.commonAddAll(this, headers);
        }

        public final Builder addLenient$okhttp(String str) {
            h.e("line", str);
            int e02 = i.e0(str, ':', 1, 4);
            if (e02 != -1) {
                String substring = str.substring(0, e02);
                h.d("substring(...)", substring);
                String substring2 = str.substring(e02 + 1);
                h.d("substring(...)", substring2);
                addLenient$okhttp(substring, substring2);
                return this;
            }
            if (str.charAt(0) != ':') {
                addLenient$okhttp(_UrlKt.FRAGMENT_ENCODE_SET, str);
                return this;
            }
            String substring3 = str.substring(1);
            h.d("substring(...)", substring3);
            addLenient$okhttp(_UrlKt.FRAGMENT_ENCODE_SET, substring3);
            return this;
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            h.e("name", str);
            h.e("value", str2);
            _HeadersCommonKt.headersCheckName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Headers build() {
            return _HeadersCommonKt.commonBuild(this);
        }

        public final String get(String str) {
            h.e("name", str);
            return _HeadersCommonKt.commonGet(this, str);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String str) {
            h.e("name", str);
            return _HeadersCommonKt.commonRemoveAll(this, str);
        }

        public final Builder set(String str, Date date) {
            h.e("name", str);
            h.e("value", date);
            return set(str, DateFormattingKt.toHttpDateString(date));
        }

        @IgnoreJRERequirement
        public final Builder set(String str, Instant instant) {
            Date from;
            h.e("name", str);
            h.e("value", instant);
            from = Date.from(instant);
            h.d("from(...)", from);
            return set(str, from);
        }

        public final Builder set(String str, String str2) {
            h.e("name", str);
            h.e("value", str2);
            return _HeadersCommonKt.commonSet(this, str, str2);
        }

        public final Builder add(String str, String str2) {
            h.e("name", str);
            h.e("value", str2);
            return _HeadersCommonKt.commonAdd(this, str, str2);
        }

        public final Builder add(String str, Date date) {
            h.e("name", str);
            h.e("value", date);
            return add(str, DateFormattingKt.toHttpDateString(date));
        }

        @IgnoreJRERequirement
        public final Builder add(String str, Instant instant) {
            Date from;
            h.e("name", str);
            h.e("value", instant);
            from = Date.from(instant);
            h.d("from(...)", from);
            return add(str, from);
        }

        public final Builder addLenient$okhttp(String str, String str2) {
            h.e("name", str);
            h.e("value", str2);
            return _HeadersCommonKt.commonAddLenient(this, str, str2);
        }
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m54deprecated_of(String... strArr) {
            h.e("namesAndValues", strArr);
            return of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final Headers of(String... strArr) {
            h.e("namesAndValues", strArr);
            return _HeadersCommonKt.commonHeadersOf((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        private Companion() {
        }

        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m53deprecated_of(Map<String, String> map) {
            h.e("headers", map);
            return of(map);
        }

        public final Headers of(Map<String, String> map) {
            h.e("<this>", map);
            return _HeadersCommonKt.commonToHeaders(map);
        }
    }

    public Headers(String[] strArr) {
        h.e("namesAndValues", strArr);
        this.namesAndValues = strArr;
    }

    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m52deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            length += this.namesAndValues[i10].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return _HeadersCommonKt.commonEquals(this, obj);
    }

    public final String get(String str) {
        h.e("name", str);
        return _HeadersCommonKt.commonHeadersGet(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        h.e("name", str);
        String str2 = get(str);
        if (str2 != null) {
            return DateFormattingKt.toHttpDateOrNull(str2);
        }
        return null;
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String str) {
        Instant instant;
        h.e("name", str);
        Date date = getDate(str);
        if (date == null) {
            return null;
        }
        instant = date.toInstant();
        return instant;
    }

    public final String[] getNamesAndValues$okhttp() {
        return this.namesAndValues;
    }

    public int hashCode() {
        return _HeadersCommonKt.commonHashCode(this);
    }

    @Override // java.lang.Iterable
    public Iterator<d> iterator() {
        return _HeadersCommonKt.commonIterator(this);
    }

    public final String name(int i10) {
        return _HeadersCommonKt.commonName(this, i10);
    }

    public final Set<String> names() {
        p.T();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(name(i10));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        h.d("unmodifiableSet(...)", unmodifiableSet);
        return unmodifiableSet;
    }

    public final Builder newBuilder() {
        return _HeadersCommonKt.commonNewBuilder(this);
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        p.T();
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = name(i10);
            Locale locale = Locale.US;
            h.d("US", locale);
            String lowerCase = name.toLowerCase(locale);
            h.d("toLowerCase(...)", lowerCase);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i10));
        }
        return treeMap;
    }

    public String toString() {
        return _HeadersCommonKt.commonToString(this);
    }

    public final String value(int i10) {
        return _HeadersCommonKt.commonValue(this, i10);
    }

    public final List<String> values(String str) {
        h.e("name", str);
        return _HeadersCommonKt.commonValues(this, str);
    }

    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }
}
