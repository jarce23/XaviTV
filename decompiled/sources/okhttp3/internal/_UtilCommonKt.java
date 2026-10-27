package okhttp3.internal;

import com.bumptech.glide.f;
import gb.i;
import j9.w1;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import ma.p;
import na.c;
import rb.h0;
import rb.i0;
import rb.m;
import rb.n;
import rb.o;
import rb.u;
import ya.l;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class _UtilCommonKt {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final h0 UNICODE_BOMS;
    public static final String USER_AGENT = "okhttp/5.3.0";

    static {
        o oVar = o.f11048r;
        UNICODE_BOMS = rb.b.f(w1.E("efbbbf"), w1.E("feff"), w1.E("fffe0000"), w1.E("fffe"), w1.E("0000feff"));
    }

    public static final <E> void addIfAbsent(List<E> list, E e7) {
        h.e("<this>", list);
        if (list.contains(e7)) {
            return;
        }
        list.add(e7);
    }

    public static final int and(byte b2, int i10) {
        return b2 & i10;
    }

    public static final void checkOffsetAndCount(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("length=" + j10 + ", offset=" + j11 + ", count=" + j11);
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        h.e("<this>", closeable);
        try {
            closeable.close();
        } catch (RuntimeException e7) {
            throw e7;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String str) {
        h.e("<this>", strArr);
        h.e("value", str);
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        h.d("copyOf(...)", copyOf);
        String[] strArr2 = (String[]) copyOf;
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static final void deleteContents(u uVar, i0 i0Var) {
        h.e("<this>", uVar);
        h.e("directory", i0Var);
        try {
            IOException iOException = null;
            for (i0 i0Var2 : uVar.list(i0Var)) {
                try {
                    if (uVar.metadata(i0Var2).f11067b) {
                        deleteContents(uVar, i0Var2);
                    }
                    uVar.delete(i0Var2);
                } catch (IOException e7) {
                    if (iOException == null) {
                        iOException = e7;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static final void deleteIfExists(u uVar, i0 i0Var) {
        h.e("<this>", uVar);
        h.e("path", i0Var);
        try {
            uVar.delete(i0Var);
        } catch (FileNotFoundException unused) {
        }
    }

    public static final int delimiterOffset(String str, String str2, int i10, int i11) {
        h.e("<this>", str);
        h.e("delimiters", str2);
        while (i10 < i11) {
            if (i.a0(str2, str.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return delimiterOffset(str, str2, i10, i11);
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, l lVar) {
        h.e("<this>", iterable);
        h.e("predicate", lVar);
        ArrayList arrayList = p.f9051o;
        for (T t3 : iterable) {
            if (((Boolean) lVar.invoke(t3)).booleanValue()) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                za.p.a(arrayList).add(t3);
            }
        }
        return arrayList;
    }

    public static final h0 getUNICODE_BOMS() {
        return UNICODE_BOMS;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        h.e("<this>", strArr);
        h.e("comparator", comparator);
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final void ignoreIoExceptions(ya.a aVar) {
        h.e("block", aVar);
        try {
            aVar.invoke();
        } catch (IOException unused) {
        }
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        h.e("<this>", strArr);
        h.e("value", str);
        h.e("comparator", comparator);
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], str) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        h.e("<this>", str);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (h.f(charAt, 31) <= 0 || h.f(charAt, 127) >= 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i10, int i11) {
        h.e("<this>", str);
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i10, i11);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i10, int i11) {
        h.e("<this>", str);
        int i12 = i11 - 1;
        if (i10 <= i12) {
            while (true) {
                char charAt = str.charAt(i12);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i12 + 1;
                }
                if (i12 == i10) {
                    break;
                }
                i12--;
            }
        }
        return i10;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i10, i11);
    }

    public static final int indexOfNonWhitespace(String str, int i10) {
        h.e("<this>", str);
        int length = str.length();
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt != ' ' && charAt != '\t') {
                return i10;
            }
            i10++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return indexOfNonWhitespace(str, i10);
    }

    public static final <T> List<T> interleave(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        h.e("a", iterable);
        h.e("b", iterable2);
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends T> it2 = iterable2.iterator();
        c g = f.g();
        while (true) {
            if (!it.hasNext() && !it2.hasNext()) {
                return f.b(g);
            }
            if (it.hasNext()) {
                g.add(it.next());
            }
            if (it2.hasNext()) {
                g.add(it2.next());
            }
        }
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        h.e("<this>", strArr);
        h.e("other", strArr2);
        h.e("comparator", comparator);
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i10]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i10++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean isCivilized(rb.u r2, rb.i0 r3) {
        /*
            java.lang.String r0 = "<this>"
            za.h.e(r0, r2)
            java.lang.String r0 = "file"
            za.h.e(r0, r3)
            rb.q0 r0 = r2.sink(r3)
            r2.delete(r3)     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L24
            r2 = 1
            if (r0 == 0) goto L17
            r0.close()     // Catch: java.lang.Throwable -> L17
        L17:
            return r2
        L18:
            r1 = move-exception
            if (r0 == 0) goto L2f
            r0.close()     // Catch: java.lang.Throwable -> L1f
            goto L2f
        L1f:
            r0 = move-exception
            com.bumptech.glide.f.a(r1, r0)
            goto L2f
        L24:
            if (r0 == 0) goto L2d
            r0.close()     // Catch: java.lang.Throwable -> L2a
            goto L2d
        L2a:
            r0 = move-exception
        L2b:
            r1 = r0
            goto L2f
        L2d:
            r0 = 0
            goto L2b
        L2f:
            if (r1 != 0) goto L36
            r2.delete(r3)
            r2 = 0
            return r2
        L36:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._UtilCommonKt.isCivilized(rb.u, rb.i0):boolean");
    }

    public static final boolean isSensitiveHeader(String str) {
        h.e("name", str);
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    public static final int parseHexDigit(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        if ('a' <= c10 && c10 < 'g') {
            return c10 - 'W';
        }
        if ('A' > c10 || c10 >= 'G') {
            return -1;
        }
        return c10 - '7';
    }

    public static final int readMedium(n nVar) {
        h.e("<this>", nVar);
        return and(nVar.readByte(), 255) | (and(nVar.readByte(), 255) << 16) | (and(nVar.readByte(), 255) << 8);
    }

    public static final int skipAll(rb.l lVar, byte b2) {
        h.e("<this>", lVar);
        int i10 = 0;
        while (!lVar.t() && lVar.x(0L) == b2) {
            i10++;
            lVar.readByte();
        }
        return i10;
    }

    public static final long toLongOrDefault(String str, long j10) {
        h.e("<this>", str);
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static final int toNonNegativeInt(String str, int i10) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i10;
    }

    public static final String trimSubstring(String str, int i10, int i11) {
        h.e("<this>", str);
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i10, i11);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i11));
        h.d("substring(...)", substring);
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return trimSubstring(str, i10, i11);
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> list) {
        h.e("<this>", exc);
        h.e("suppressed", list);
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            f.a(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(m mVar, int i10) {
        h.e("<this>", mVar);
        mVar.writeByte((i10 >>> 16) & 255);
        mVar.writeByte((i10 >>> 8) & 255);
        mVar.writeByte(i10 & 255);
    }

    public static final int and(short s10, int i10) {
        return s10 & i10;
    }

    public static final int delimiterOffset(String str, char c10, int i10, int i11) {
        h.e("<this>", str);
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static final long and(int i10, long j10) {
        return j10 & i10;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return delimiterOffset(str, c10, i10, i11);
    }
}
