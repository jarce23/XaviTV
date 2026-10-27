package n3;

import android.text.SpannableStringBuilder;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f9125a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9126b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9127c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9128d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9129e;

    /* renamed from: f, reason: collision with root package name */
    public final g f9130f;
    public final String[] g;

    /* renamed from: h, reason: collision with root package name */
    public final String f9131h;

    /* renamed from: i, reason: collision with root package name */
    public final String f9132i;

    /* renamed from: j, reason: collision with root package name */
    public final c f9133j;

    /* renamed from: k, reason: collision with root package name */
    public final HashMap f9134k;

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f9135l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f9136m;

    public c(String str, String str2, long j10, long j11, g gVar, String[] strArr, String str3, String str4, c cVar) {
        this.f9125a = str;
        this.f9126b = str2;
        this.f9132i = str4;
        this.f9130f = gVar;
        this.g = strArr;
        this.f9127c = str2 != null;
        this.f9128d = j10;
        this.f9129e = j11;
        str3.getClass();
        this.f9131h = str3;
        this.f9133j = cVar;
        this.f9134k = new HashMap();
        this.f9135l = new HashMap();
    }

    public static c a(String str) {
        return new c(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, _UrlKt.FRAGMENT_ENCODE_SET, null, null);
    }

    public static SpannableStringBuilder e(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            k1.a aVar = new k1.a();
            aVar.f7598a = new SpannableStringBuilder();
            aVar.f7599b = null;
            treeMap.put(str, aVar);
        }
        CharSequence charSequence = ((k1.a) treeMap.get(str)).f7598a;
        charSequence.getClass();
        return (SpannableStringBuilder) charSequence;
    }

    public final c b(int i10) {
        ArrayList arrayList = this.f9136m;
        if (arrayList != null) {
            return (c) arrayList.get(i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int c() {
        ArrayList arrayList = this.f9136m;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void d(TreeSet treeSet, boolean z10) {
        String str = this.f9125a;
        boolean equals = "p".equals(str);
        boolean equals2 = "div".equals(str);
        if (z10 || equals || (equals2 && this.f9132i != null)) {
            long j10 = this.f9128d;
            if (j10 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j10));
            }
            long j11 = this.f9129e;
            if (j11 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j11));
            }
        }
        if (this.f9136m == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f9136m.size(); i10++) {
            ((c) this.f9136m.get(i10)).d(treeSet, z10 || equals);
        }
    }

    public final boolean f(long j10) {
        long j11 = this.f9128d;
        long j12 = this.f9129e;
        if (j11 == -9223372036854775807L && j12 == -9223372036854775807L) {
            return true;
        }
        if (j11 <= j10 && j12 == -9223372036854775807L) {
            return true;
        }
        if (j11 != -9223372036854775807L || j10 >= j12) {
            return j11 <= j10 && j10 < j12;
        }
        return true;
    }

    public final void g(long j10, String str, ArrayList arrayList) {
        String str2;
        String str3 = this.f9131h;
        if (!_UrlKt.FRAGMENT_ENCODE_SET.equals(str3)) {
            str = str3;
        }
        if (f(j10) && "div".equals(this.f9125a) && (str2 = this.f9132i) != null) {
            arrayList.add(new Pair(str, str2));
            return;
        }
        for (int i10 = 0; i10 < c(); i10++) {
            b(i10).g(j10, str, arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(long r21, java.util.Map r23, java.util.HashMap r24, java.lang.String r25, java.util.TreeMap r26) {
        /*
            Method dump skipped, instructions count: 753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.c.h(long, java.util.Map, java.util.HashMap, java.lang.String, java.util.TreeMap):void");
    }

    public final void i(long j10, boolean z10, String str, TreeMap treeMap) {
        boolean z11;
        TreeMap treeMap2;
        long j11;
        HashMap hashMap = this.f9134k;
        hashMap.clear();
        HashMap hashMap2 = this.f9135l;
        hashMap2.clear();
        String str2 = this.f9125a;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.f9131h;
        String str4 = _UrlKt.FRAGMENT_ENCODE_SET.equals(str3) ? str : str3;
        if (this.f9127c && z10) {
            SpannableStringBuilder e7 = e(str4, treeMap);
            String str5 = this.f9126b;
            str5.getClass();
            e7.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z10) {
            e(str4, treeMap).append('\n');
            return;
        }
        if (f(j10)) {
            for (Map.Entry entry : treeMap.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequence = ((k1.a) entry.getValue()).f7598a;
                charSequence.getClass();
                hashMap.put(str6, Integer.valueOf(charSequence.length()));
            }
            boolean equals = "p".equals(str2);
            for (int i10 = 0; i10 < c(); i10++) {
                c b2 = b(i10);
                if (z10 || equals) {
                    z11 = true;
                    treeMap2 = treeMap;
                    j11 = j10;
                } else {
                    z11 = false;
                    j11 = j10;
                    treeMap2 = treeMap;
                }
                b2.i(j11, z11, str4, treeMap2);
            }
            if (equals) {
                SpannableStringBuilder e8 = e(str4, treeMap);
                int length = e8.length() - 1;
                while (length >= 0 && e8.charAt(length) == ' ') {
                    length--;
                }
                if (length >= 0 && e8.charAt(length) != '\n') {
                    e8.append('\n');
                }
            }
            for (Map.Entry entry2 : treeMap.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence charSequence2 = ((k1.a) entry2.getValue()).f7598a;
                charSequence2.getClass();
                hashMap2.put(str7, Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
