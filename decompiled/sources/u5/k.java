package u5;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import m6.n;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f12553d;

    /* renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f12554e;

    /* renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f12555f;
    public static final Bitmap.Config[] g;

    /* renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f12556h;

    /* renamed from: a, reason: collision with root package name */
    public final e f12557a = new e(1);

    /* renamed from: b, reason: collision with root package name */
    public final x4.c f12558b = new x4.c(18);

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f12559c = new HashMap();

    static {
        Bitmap.Config config;
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            int length = configArr.length - 1;
            config = Bitmap.Config.RGBA_F16;
            configArr[length] = config;
        }
        f12553d = configArr;
        f12554e = configArr;
        f12555f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f12556h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String c(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap d6 = d(bitmap.getConfig());
        Integer num2 = (Integer) d6.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                d6.remove(num);
                return;
            } else {
                d6.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(n.c(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6 A[EDGE_INSN: B:34:0x00a6->B:20:0x00a6 BREAK  A[LOOP:0: B:10:0x0058->B:32:0x00a3], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap b(int r11, int r12, android.graphics.Bitmap.Config r13) {
        /*
            r10 = this;
            int r0 = r11 * r12
            int r1 = m6.n.d(r13)
            int r1 = r1 * r0
            u5.e r0 = r10.f12557a
            java.lang.Object r2 = r0.f2162a
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2
            java.lang.Object r2 = r2.poll()
            u5.h r2 = (u5.h) r2
            if (r2 != 0) goto L19
            u5.h r2 = r0.q()
        L19:
            u5.j r2 = (u5.j) r2
            r2.f12551b = r1
            r2.f12552c = r13
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 26
            r5 = 0
            if (r3 < r4) goto L33
            android.graphics.Bitmap$Config r3 = n0.b.C()
            boolean r3 = r3.equals(r13)
            if (r3 == 0) goto L33
            android.graphics.Bitmap$Config[] r3 = u5.k.f12554e
            goto L57
        L33:
            int[] r3 = u5.i.f12549a
            int r4 = r13.ordinal()
            r3 = r3[r4]
            r4 = 1
            if (r3 == r4) goto L55
            r6 = 2
            if (r3 == r6) goto L52
            r6 = 3
            if (r3 == r6) goto L4f
            r6 = 4
            if (r3 == r6) goto L4c
            android.graphics.Bitmap$Config[] r3 = new android.graphics.Bitmap.Config[r4]
            r3[r5] = r13
            goto L57
        L4c:
            android.graphics.Bitmap$Config[] r3 = u5.k.f12556h
            goto L57
        L4f:
            android.graphics.Bitmap$Config[] r3 = u5.k.g
            goto L57
        L52:
            android.graphics.Bitmap$Config[] r3 = u5.k.f12555f
            goto L57
        L55:
            android.graphics.Bitmap$Config[] r3 = u5.k.f12553d
        L57:
            int r4 = r3.length
        L58:
            if (r5 >= r4) goto La6
            r6 = r3[r5]
            java.util.NavigableMap r7 = r10.d(r6)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            java.lang.Object r7 = r7.ceilingKey(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto La3
            int r8 = r7.intValue()
            int r9 = r1 * 8
            if (r8 > r9) goto La3
            int r3 = r7.intValue()
            if (r3 != r1) goto L85
            if (r6 != 0) goto L7f
            if (r13 == 0) goto La6
            goto L85
        L7f:
            boolean r1 = r6.equals(r13)
            if (r1 != 0) goto La6
        L85:
            r0.i(r2)
            int r1 = r7.intValue()
            java.lang.Object r2 = r0.f2162a
            java.util.ArrayDeque r2 = (java.util.ArrayDeque) r2
            java.lang.Object r2 = r2.poll()
            u5.h r2 = (u5.h) r2
            if (r2 != 0) goto L9c
            u5.h r2 = r0.q()
        L9c:
            u5.j r2 = (u5.j) r2
            r2.f12551b = r1
            r2.f12552c = r6
            goto La6
        La3:
            int r5 = r5 + 1
            goto L58
        La6:
            x4.c r0 = r10.f12558b
            java.lang.Object r0 = r0.R(r2)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 == 0) goto Lbc
            int r1 = r2.f12551b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.a(r1, r0)
            r0.reconfigure(r11, r12, r13)
        Lbc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u5.k.b(int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }

    public final NavigableMap d(Bitmap.Config config) {
        HashMap hashMap = this.f12559c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        hashMap.put(config, treeMap);
        return treeMap;
    }

    public final void e(Bitmap bitmap) {
        int c10 = n.c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        e eVar = this.f12557a;
        h hVar = (h) ((ArrayDeque) eVar.f2162a).poll();
        if (hVar == null) {
            hVar = eVar.q();
        }
        j jVar = (j) hVar;
        jVar.f12551b = c10;
        jVar.f12552c = config;
        this.f12558b.a0(jVar, bitmap);
        NavigableMap d6 = d(bitmap.getConfig());
        Integer num = (Integer) d6.get(Integer.valueOf(jVar.f12551b));
        d6.put(Integer.valueOf(jVar.f12551b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SizeConfigStrategy{groupedMap=");
        sb2.append(this.f12558b);
        sb2.append(", sortedSizes=(");
        HashMap hashMap = this.f12559c;
        for (Map.Entry entry : hashMap.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append('[');
            sb2.append(entry.getValue());
            sb2.append("], ");
        }
        if (!hashMap.isEmpty()) {
            sb2.replace(sb2.length() - 2, sb2.length(), _UrlKt.FRAGMENT_ENCODE_SET);
        }
        sb2.append(")}");
        return sb2.toString();
    }
}
