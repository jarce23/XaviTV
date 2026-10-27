package l3;

import h3.e;
import h3.k;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l1.a0;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements k {

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f8162u = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: o, reason: collision with root package name */
    public final boolean f8163o;

    /* renamed from: p, reason: collision with root package name */
    public final j3.b f8164p;

    /* renamed from: r, reason: collision with root package name */
    public LinkedHashMap f8166r;

    /* renamed from: s, reason: collision with root package name */
    public float f8167s = -3.4028235E38f;

    /* renamed from: t, reason: collision with root package name */
    public float f8168t = -3.4028235E38f;

    /* renamed from: q, reason: collision with root package name */
    public final t f8165q = new t();

    public a(List list) {
        if (list == null || list.isEmpty()) {
            this.f8163o = false;
            this.f8164p = null;
            return;
        }
        this.f8163o = true;
        String o2 = a0.o((byte[]) list.get(0));
        l1.d.b(o2.startsWith("Format:"));
        j3.b a10 = j3.b.a(o2);
        a10.getClass();
        this.f8164p = a10;
        c(new t((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }

    public static int a(long j10, ArrayList arrayList, ArrayList arrayList2) {
        int i10;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i10 = 0;
                break;
            }
            if (((Long) arrayList.get(size)).longValue() == j10) {
                return size;
            }
            if (((Long) arrayList.get(size)).longValue() < j10) {
                i10 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i10, Long.valueOf(j10));
        arrayList2.add(i10, i10 == 0 ? new ArrayList() : new ArrayList((Collection) arrayList2.get(i10 - 1)));
        return i10;
    }

    public static long e(String str) {
        Matcher matcher = f8162u.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String group = matcher.group(1);
        int i10 = a0.f8067a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(group) * 3600000000L);
    }

    @Override // h3.k
    public final /* synthetic */ e b(byte[] bArr, int i10, int i11) {
        return android.support.v4.media.d.a(this, bArr, i11);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(l1.t r39, java.nio.charset.Charset r40) {
        /*
            Method dump skipped, instructions count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.a.c(l1.t, java.nio.charset.Charset):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cc  */
    @Override // h3.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(byte[] r44, int r45, int r46, h3.j r47, l1.h r48) {
        /*
            Method dump skipped, instructions count: 998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.a.d(byte[], int, int, h3.j, l1.h):void");
    }

    @Override // h3.k
    public final /* synthetic */ void reset() {
    }
}
