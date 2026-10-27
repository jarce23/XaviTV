package okhttp3.internal;

import com.bumptech.glide.c;
import com.bumptech.glide.f;
import gb.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import la.d;
import ma.p;
import okhttp3.Headers;
import okhttp3.internal.url._UrlKt;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class _HeadersCommonKt {
    private static final String charCode(char c10) {
        c.h(16);
        String num = Integer.toString(c10, 16);
        h.d("toString(...)", num);
        return num.length() < 2 ? "0".concat(num) : num;
    }

    public static final Headers.Builder commonAdd(Headers.Builder builder, String str, String str2) {
        h.e("<this>", builder);
        h.e("name", str);
        h.e("value", str2);
        headersCheckName(str);
        headersCheckValue(str2, str);
        commonAddLenient(builder, str, str2);
        return builder;
    }

    public static final Headers.Builder commonAddAll(Headers.Builder builder, Headers headers) {
        h.e("<this>", builder);
        h.e("headers", headers);
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            commonAddLenient(builder, headers.name(i10), headers.value(i10));
        }
        return builder;
    }

    public static final Headers.Builder commonAddLenient(Headers.Builder builder, String str, String str2) {
        h.e("<this>", builder);
        h.e("name", str);
        h.e("value", str2);
        builder.getNamesAndValues$okhttp().add(str);
        builder.getNamesAndValues$okhttp().add(i.o0(str2).toString());
        return builder;
    }

    public static final Headers commonBuild(Headers.Builder builder) {
        h.e("<this>", builder);
        return new Headers((String[]) builder.getNamesAndValues$okhttp().toArray(new String[0]));
    }

    public static final boolean commonEquals(Headers headers, Object obj) {
        h.e("<this>", headers);
        return (obj instanceof Headers) && Arrays.equals(headers.getNamesAndValues$okhttp(), ((Headers) obj).getNamesAndValues$okhttp());
    }

    public static final String commonGet(Headers.Builder builder, String str) {
        h.e("<this>", builder);
        h.e("name", str);
        int size = builder.getNamesAndValues$okhttp().size() - 2;
        int j10 = f.j(size, 0, -2);
        if (j10 > size) {
            return null;
        }
        while (!str.equalsIgnoreCase(builder.getNamesAndValues$okhttp().get(size))) {
            if (size == j10) {
                return null;
            }
            size -= 2;
        }
        return builder.getNamesAndValues$okhttp().get(size + 1);
    }

    public static final int commonHashCode(Headers headers) {
        h.e("<this>", headers);
        return Arrays.hashCode(headers.getNamesAndValues$okhttp());
    }

    public static final String commonHeadersGet(String[] strArr, String str) {
        h.e("namesAndValues", strArr);
        h.e("name", str);
        int length = strArr.length - 2;
        int j10 = f.j(length, 0, -2);
        if (j10 > length) {
            return null;
        }
        while (!str.equalsIgnoreCase(strArr[length])) {
            if (length == j10) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public static final Headers commonHeadersOf(String... strArr) {
        h.e("inputNamesAndValues", strArr);
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        int length = strArr2.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (strArr2[i11] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i11] = i.o0(strArr[i11]).toString();
        }
        int j10 = f.j(0, strArr2.length - 1, 2);
        if (j10 >= 0) {
            while (true) {
                String str = strArr2[i10];
                String str2 = strArr2[i10 + 1];
                headersCheckName(str);
                headersCheckValue(str2, str);
                if (i10 == j10) {
                    break;
                }
                i10 += 2;
            }
        }
        return new Headers(strArr2);
    }

    public static final Iterator<d> commonIterator(Headers headers) {
        h.e("<this>", headers);
        int size = headers.size();
        d[] dVarArr = new d[size];
        for (int i10 = 0; i10 < size; i10++) {
            dVarArr[i10] = new d(headers.name(i10), headers.value(i10));
        }
        return new fb.b(dVarArr);
    }

    public static final String commonName(Headers headers, int i10) {
        h.e("<this>", headers);
        String str = (String) ma.i.L(i10 * 2, headers.getNamesAndValues$okhttp());
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i10 + ']');
    }

    public static final Headers.Builder commonNewBuilder(Headers headers) {
        h.e("<this>", headers);
        Headers.Builder builder = new Headers.Builder();
        List<String> namesAndValues$okhttp = builder.getNamesAndValues$okhttp();
        String[] namesAndValues$okhttp2 = headers.getNamesAndValues$okhttp();
        h.e("<this>", namesAndValues$okhttp);
        h.e("elements", namesAndValues$okhttp2);
        namesAndValues$okhttp.addAll(ma.i.B(namesAndValues$okhttp2));
        return builder;
    }

    public static final Headers.Builder commonRemoveAll(Headers.Builder builder, String str) {
        h.e("<this>", builder);
        h.e("name", str);
        int i10 = 0;
        while (i10 < builder.getNamesAndValues$okhttp().size()) {
            if (str.equalsIgnoreCase(builder.getNamesAndValues$okhttp().get(i10))) {
                builder.getNamesAndValues$okhttp().remove(i10);
                builder.getNamesAndValues$okhttp().remove(i10);
                i10 -= 2;
            }
            i10 += 2;
        }
        return builder;
    }

    public static final Headers.Builder commonSet(Headers.Builder builder, String str, String str2) {
        h.e("<this>", builder);
        h.e("name", str);
        h.e("value", str2);
        headersCheckName(str);
        headersCheckValue(str2, str);
        builder.removeAll(str);
        commonAddLenient(builder, str, str2);
        return builder;
    }

    public static final Headers commonToHeaders(Map<String, String> map) {
        h.e("<this>", map);
        String[] strArr = new String[map.size() * 2];
        int i10 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String obj = i.o0(key).toString();
            String obj2 = i.o0(value).toString();
            headersCheckName(obj);
            headersCheckValue(obj2, obj);
            strArr[i10] = obj;
            strArr[i10 + 1] = obj2;
            i10 += 2;
        }
        return new Headers(strArr);
    }

    public static final String commonToString(Headers headers) {
        h.e("<this>", headers);
        StringBuilder sb2 = new StringBuilder();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = headers.name(i10);
            String value = headers.value(i10);
            sb2.append(name);
            sb2.append(": ");
            if (_UtilCommonKt.isSensitiveHeader(name)) {
                value = "██";
            }
            sb2.append(value);
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public static final String commonValue(Headers headers, int i10) {
        h.e("<this>", headers);
        String str = (String) ma.i.L((i10 * 2) + 1, headers.getNamesAndValues$okhttp());
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i10 + ']');
    }

    public static final List<String> commonValues(Headers headers, String str) {
        h.e("<this>", headers);
        h.e("name", str);
        int size = headers.size();
        List<String> list = null;
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(headers.name(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.value(i10));
            }
        }
        if (arrayList != null) {
            list = Collections.unmodifiableList(arrayList);
            h.d("unmodifiableList(...)", list);
        }
        return list == null ? p.f9051o : list;
    }

    public static final void headersCheckName(String str) {
        h.e("name", str);
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if ('!' > charAt || charAt >= 127) {
                throw new IllegalArgumentException(("Unexpected char 0x" + charCode(charAt) + " at " + i10 + " in header name: " + str).toString());
            }
        }
    }

    public static final void headersCheckValue(String str, String str2) {
        h.e("value", str);
        h.e("name", str2);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '\t' && (' ' > charAt || charAt >= 127)) {
                StringBuilder sb2 = new StringBuilder("Unexpected char 0x");
                sb2.append(charCode(charAt));
                sb2.append(" at ");
                sb2.append(i10);
                sb2.append(" in ");
                sb2.append(str2);
                sb2.append(" value");
                sb2.append(_UtilCommonKt.isSensitiveHeader(str2) ? _UrlKt.FRAGMENT_ENCODE_SET : ": ".concat(str));
                throw new IllegalArgumentException(sb2.toString().toString());
            }
        }
    }
}
