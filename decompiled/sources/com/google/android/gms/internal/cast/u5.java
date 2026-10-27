package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u5 implements k9.f, h3.e, v6.b {

    /* renamed from: o, reason: collision with root package name */
    public final Object f3494o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f3495p;

    /* renamed from: q, reason: collision with root package name */
    public Object f3496q;

    /* renamed from: r, reason: collision with root package name */
    public Object f3497r;

    /* renamed from: s, reason: collision with root package name */
    public Object f3498s;

    public u5(l0 l0Var, c cVar, String str) {
        this.f3494o = l0Var;
        this.f3495p = cVar;
        this.f3496q = str;
        this.f3498s = new j4(this);
    }

    public static void e(u5 u5Var, t6 t6Var) {
        int i10 = t6Var.f3484e;
        if (i10 == 2 && ((s6) u5Var.f3497r) != null) {
            u5Var.g();
        }
        if (i10 == 2) {
            u5Var.f3497r = new s6((l0) u5Var.f3494o, (String) u5Var.f3496q);
        } else {
            u5Var.f3497r = u5Var.f();
        }
        s6 s6Var = (s6) u5Var.f3497r;
        r7.r.e(s6Var);
        t6Var.f3483d = s6Var.f3461h;
        s6Var.f3456b.add(t6Var);
    }

    @Override // h3.e
    public int a(long j10) {
        long[] jArr = (long[]) this.f3495p;
        int a10 = l1.a0.a(jArr, j10, false);
        if (a10 < jArr.length) {
            return a10;
        }
        return -1;
    }

    public void b(Uri uri) {
        int i10;
        Context context = (Context) this.f3494o;
        if (uri == null) {
            d();
            return;
        }
        if (uri.equals((Uri) this.f3496q)) {
            return;
        }
        d();
        this.f3496q = uri;
        i7.b bVar = (i7.b) this.f3495p;
        int i11 = bVar.f6467p;
        if (i11 == 0 || (i10 = bVar.f6468q) == 0) {
            this.f3497r = new j7.b(context, 0, 0, this);
        } else {
            this.f3497r = new j7.b(context, i11, i10, this);
        }
        j7.b bVar2 = (j7.b) this.f3497r;
        r7.r.e(bVar2);
        Uri uri2 = (Uri) this.f3496q;
        r7.r.e(uri2);
        bVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, uri2);
    }

    @Override // k9.f
    public Object c() {
        return new j9.l(((androidx.emoji2.text.o) ((h5.i) this.f3494o).f5610p).f591o, (j9.p) ((k9.e) this.f3495p).c(), (j9.t1) ((k9.e) this.f3496q).c(), (j9.d0) ((k9.e) this.f3497r).c(), (j9.h1) ((k9.e) this.f3498s).c());
    }

    public void d() {
        j7.b bVar = (j7.b) this.f3497r;
        if (bVar != null) {
            bVar.cancel(true);
            this.f3497r = null;
        }
        this.f3496q = null;
    }

    public s6 f() {
        if (((s6) this.f3497r) == null) {
            s6 s6Var = new s6((l0) this.f3494o, (String) this.f3496q);
            this.f3497r = s6Var;
            s6Var.b(1);
        }
        return (s6) this.f3497r;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void g() {
        int i10;
        m1 m1Var;
        int i11;
        long j10;
        s6 s6Var = (s6) this.f3497r;
        if (s6Var != null) {
            Map map = s6Var.f3459e;
            List<c3> list = s6Var.f3458d;
            List<a> list2 = s6Var.f3457c;
            List<t6> list3 = s6Var.f3456b;
            h7.d dVar = s6Var.f3463j;
            if (dVar != null) {
                dVar.f5735l = null;
                s6Var.f3463j = null;
            }
            long j11 = s6Var.f3462i;
            m1 m10 = n1.m();
            m10.c();
            n1.t((n1) m10.f3641p, j11);
            String str = s6Var.f3465l;
            if (str != null) {
                m10.c();
                n1.y((n1) m10.f3641p, str);
            }
            String str2 = s6Var.f3466m;
            if (str2 != null) {
                m10.c();
                n1.u((n1) m10.f3641p, str2);
            }
            f1 l10 = g1.l();
            String str3 = s6.f3453o;
            l10.c();
            g1.n((g1) l10.f3641p, str3);
            String str4 = s6Var.g;
            l10.c();
            g1.m((g1) l10.f3641p, str4);
            g1 g1Var = (g1) l10.a();
            m10.c();
            n1.r((n1) m10.f3641p, g1Var);
            c.a aVar = s6Var.f3455a;
            s1 l11 = t1.l();
            Object a10 = aVar.a();
            if (a10 != null) {
                e2 l12 = f2.l();
                l12.c();
                f2.m((f2) l12.f3641p, (String) a10);
                f2 f2Var = (f2) l12.a();
                l11.c();
                t1.m((t1) l11.f3641p, f2Var);
            }
            String str5 = s6Var.f3464k;
            if (str5 != null) {
                try {
                    String replace = str5.replace("-", _UrlKt.FRAGMENT_ENCODE_SET);
                    j10 = new BigInteger(replace.substring(0, Math.min(16, replace.length())), 16).longValue();
                } catch (NumberFormatException e7) {
                    l7.b bVar = s6.f3452n;
                    Log.w(bVar.f8271a, bVar.d("receiverSessionId %s is not valid for hash", str5), e7);
                    j10 = 0;
                }
                l11.c();
                t1.n((t1) l11.f3641p, j10);
            }
            if (!list3.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (t6 t6Var : list3) {
                    t6Var.getClass();
                    q1 l13 = r1.l();
                    int i12 = t6Var.f3484e;
                    l13.c();
                    r1.p((r1) l13.f3641p, i12);
                    int i13 = (int) (t6Var.f3481b - t6Var.f3483d);
                    l13.c();
                    r1.m((r1) l13.f3641p, i13);
                    Integer num = t6Var.f3480a;
                    if (num != null) {
                        int intValue = num.intValue();
                        l13.c();
                        r1.n((r1) l13.f3641p, intValue);
                    }
                    Boolean bool = t6Var.f3482c;
                    if (bool != null) {
                        boolean booleanValue = bool.booleanValue();
                        l13.c();
                        r1.o((r1) l13.f3641p, booleanValue);
                    }
                    arrayList.add((r1) l13.a());
                }
                l11.c();
                t1.o((t1) l11.f3641p, arrayList);
            }
            int i14 = 2;
            if (list2.isEmpty()) {
                i10 = 1;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (a aVar2 : list2) {
                    aVar2.getClass();
                    w1 l14 = x1.l();
                    int i15 = (int) (aVar2.f3236b - aVar2.f3237c);
                    l14.c();
                    x1.m((x1) l14.f3641p, i15);
                    int i16 = aVar2.f3235a;
                    int i17 = i16 != 1 ? i16 != 2 ? i16 != 3 ? 1 : 4 : 3 : 2;
                    l14.c();
                    x1.n((x1) l14.f3641p, i17);
                    arrayList2.add((x1) l14.a());
                }
                i10 = 1;
                l11.c();
                t1.q((t1) l11.f3641p, arrayList2);
            }
            if (list.isEmpty()) {
                m1Var = m10;
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (c3 c3Var : list) {
                    String str6 = c3Var.f3281a;
                    o1 l15 = p1.l();
                    switch (str6.hashCode()) {
                        case -1189611734:
                            if (str6.equals("queueInsert")) {
                                i11 = 13;
                                break;
                            }
                            i11 = i10;
                            break;
                        case -1109843021:
                            if (str6.equals("launch")) {
                                i11 = 22;
                                break;
                            }
                            i11 = i10;
                            break;
                        case -940430091:
                            if (str6.equals("queueRemove")) {
                                i11 = 15;
                                break;
                            }
                            i11 = i10;
                            break;
                        case -936597225:
                            if (str6.equals("queueFetchItems")) {
                                i11 = 19;
                                break;
                            }
                            i11 = i10;
                            break;
                        case -930425472:
                            if (str6.equals("setPlaybackDevices")) {
                                i11 = 23;
                                break;
                            }
                            i11 = i10;
                            break;
                        case -921113364:
                            if (str6.equals("volume-mute")) {
                                i11 = 9;
                                break;
                            }
                            i11 = i10;
                            break;
                        case -900560382:
                            if (str6.equals("skipAd")) {
                                i11 = 21;
                                break;
                            }
                            i11 = i10;
                            break;
                        case -892481550:
                            if (str6.equals("status")) {
                                i11 = 10;
                                break;
                            }
                            i11 = i10;
                            break;
                        case -844665542:
                            if (str6.equals("queueUpdate")) {
                                i11 = 14;
                                break;
                            }
                            i11 = i10;
                            break;
                        case -810883302:
                            if (str6.equals("volume")) {
                                i11 = 7;
                                break;
                            }
                            i11 = i10;
                            break;
                        case -402284771:
                            if (str6.equals("setPlaybackRate")) {
                                i11 = 20;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 3327206:
                            if (str6.equals("load")) {
                                i11 = i14;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 3363353:
                            if (str6.equals("mute")) {
                                i11 = 8;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 3443508:
                            if (str6.equals("play")) {
                                i11 = 3;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 3526264:
                            if (str6.equals("seek")) {
                                i11 = 6;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 3540994:
                            if (str6.equals("stop")) {
                                i11 = 5;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 106440182:
                            if (str6.equals("pause")) {
                                i11 = 4;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 525402049:
                            if (str6.equals("queueFetchItemRange")) {
                                i11 = 18;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 913357482:
                            if (str6.equals("queueReorder")) {
                                i11 = 16;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 1148867366:
                            if (str6.equals("trackStyle")) {
                                i11 = 12;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 1451542318:
                            if (str6.equals("activeTracks")) {
                                i11 = 11;
                                break;
                            }
                            i11 = i10;
                            break;
                        case 1873161788:
                            if (str6.equals("queueFetchItemIds")) {
                                i11 = 17;
                                break;
                            }
                            i11 = i10;
                            break;
                        default:
                            i11 = i10;
                            break;
                    }
                    l15.c();
                    p1.q((p1) l15.f3641p, i11);
                    int i18 = (int) c3Var.f3282b;
                    l15.c();
                    p1.m((p1) l15.f3641p, i18);
                    int i19 = c3Var.f3283c;
                    l15.c();
                    p1.n((p1) l15.f3641p, i19);
                    int i20 = (int) (c3Var.f3284d - c3Var.f3286f);
                    l15.c();
                    p1.o((p1) l15.f3641p, i20);
                    int i21 = (int) (c3Var.f3285e - c3Var.f3286f);
                    l15.c();
                    p1.p((p1) l15.f3641p, i21);
                    arrayList3.add((p1) l15.a());
                    m10 = m10;
                    i14 = 2;
                }
                m1Var = m10;
                l11.c();
                t1.p((t1) l11.f3641p, arrayList3);
            }
            if (!map.isEmpty()) {
                ArrayList arrayList4 = new ArrayList();
                for (b bVar2 : map.values()) {
                    bVar2.getClass();
                    u1 l16 = v1.l();
                    int i22 = bVar2.f3260e;
                    l16.c();
                    v1.p((v1) l16.f3641p, i22);
                    int i23 = bVar2.f3259d.get();
                    l16.c();
                    v1.m((v1) l16.f3641p, i23);
                    int i24 = (int) (bVar2.f3256a - bVar2.f3258c);
                    l16.c();
                    v1.n((v1) l16.f3641p, i24);
                    int i25 = (int) (bVar2.f3257b - bVar2.f3258c);
                    l16.c();
                    v1.o((v1) l16.f3641p, i25);
                    arrayList4.add((v1) l16.a());
                }
                l11.c();
                t1.r((t1) l11.f3641p, arrayList4);
            }
            t1 t1Var = (t1) l11.a();
            m1Var.c();
            n1.q((n1) m1Var.f3641p, t1Var);
            s6Var.f3460f.a((n1) m1Var.a(), 233);
            this.f3497r = null;
        }
    }

    @Override // ka.a
    public Object get() {
        return new y6.a((Executor) ((ka.a) this.f3494o).get(), (t6.d) ((ka.a) this.f3495p).get(), (android.support.v4.media.session.a0) ((android.support.v4.media.session.a0) this.f3496q).get(), (a7.d) ((ka.a) this.f3497r).get(), (b7.c) ((ka.a) this.f3498s).get());
    }

    @Override // h3.e
    public long l(int i10) {
        return ((long[]) this.f3495p)[i10];
    }

    @Override // h3.e
    public List r(long j10) {
        n3.c cVar = (n3.c) this.f3494o;
        Map map = (Map) this.f3496q;
        HashMap hashMap = (HashMap) this.f3497r;
        HashMap hashMap2 = (HashMap) this.f3498s;
        ArrayList arrayList = new ArrayList();
        cVar.g(j10, cVar.f9131h, arrayList);
        TreeMap treeMap = new TreeMap();
        cVar.i(j10, false, cVar.f9131h, treeMap);
        cVar.h(j10, map, hashMap, cVar.f9131h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            Pair pair = (Pair) obj;
            String str = (String) hashMap2.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                n3.f fVar = (n3.f) hashMap.get(pair.first);
                fVar.getClass();
                arrayList2.add(new k1.b(null, null, null, decodeByteArray, fVar.f9151c, 0, fVar.f9153e, fVar.f9150b, 0, Integer.MIN_VALUE, -3.4028235E38f, fVar.f9154f, fVar.g, false, -16777216, fVar.f9157j, 0.0f, 0));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            n3.f fVar2 = (n3.f) hashMap.get(entry.getKey());
            fVar2.getClass();
            k1.a aVar = (k1.a) entry.getValue();
            CharSequence charSequence = aVar.f7598a;
            charSequence.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (n3.a aVar2 : (n3.a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), n3.a.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar2), spannableStringBuilder.getSpanEnd(aVar2), (CharSequence) _UrlKt.FRAGMENT_ENCODE_SET);
            }
            for (int i11 = 0; i11 < spannableStringBuilder.length(); i11++) {
                if (spannableStringBuilder.charAt(i11) == ' ') {
                    int i12 = i11 + 1;
                    int i13 = i12;
                    while (i13 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i13) == ' ') {
                        i13++;
                    }
                    int i14 = i13 - i12;
                    if (i14 > 0) {
                        spannableStringBuilder.delete(i11, i14 + i11);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i15 = 0; i15 < spannableStringBuilder.length() - 1; i15++) {
                if (spannableStringBuilder.charAt(i15) == '\n') {
                    int i16 = i15 + 1;
                    if (spannableStringBuilder.charAt(i16) == ' ') {
                        spannableStringBuilder.delete(i16, i15 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i17 = 0; i17 < spannableStringBuilder.length() - 1; i17++) {
                if (spannableStringBuilder.charAt(i17) == ' ') {
                    int i18 = i17 + 1;
                    if (spannableStringBuilder.charAt(i18) == '\n') {
                        spannableStringBuilder.delete(i17, i18);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            float f10 = fVar2.f9151c;
            int i19 = fVar2.f9152d;
            aVar.f7602e = f10;
            aVar.f7603f = i19;
            aVar.g = fVar2.f9153e;
            aVar.f7604h = fVar2.f9150b;
            aVar.f7608l = fVar2.f9154f;
            float f11 = fVar2.f9156i;
            int i20 = fVar2.f9155h;
            aVar.f7607k = f11;
            aVar.f7606j = i20;
            aVar.f7612p = fVar2.f9157j;
            arrayList2.add(aVar.a());
        }
        return arrayList2;
    }

    @Override // h3.e
    public int w() {
        return ((long[]) this.f3495p).length;
    }

    public /* synthetic */ u5(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.f3494o = obj;
        this.f3495p = obj2;
        this.f3496q = obj3;
        this.f3497r = obj4;
        this.f3498s = obj5;
    }

    public u5(Context context) {
        this(context, new i7.b(-1, 0, 0));
    }

    public u5(Context context, i7.b bVar) {
        this.f3494o = context;
        this.f3495p = bVar;
        d();
    }

    public u5(n3.c cVar, HashMap hashMap, HashMap hashMap2, HashMap hashMap3) {
        this.f3494o = cVar;
        this.f3497r = hashMap2;
        this.f3498s = hashMap3;
        this.f3496q = Collections.unmodifiableMap(hashMap);
        TreeSet treeSet = new TreeSet();
        int i10 = 0;
        cVar.d(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i10] = ((Long) it.next()).longValue();
            i10++;
        }
        this.f3495p = jArr;
    }
}
