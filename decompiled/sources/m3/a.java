package m3;

import android.support.v4.media.d;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import h3.e;
import h3.j;
import h3.k;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l1.b;
import l1.h;
import l1.t;
import o9.g0;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements k {

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f8862r = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f8863s = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: o, reason: collision with root package name */
    public final StringBuilder f8864o = new StringBuilder();

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f8865p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public final t f8866q = new t();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0070, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008c, code lost:
    
        if (r22.equals("{\\an9}") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x009c, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0093, code lost:
    
        if (r22.equals("{\\an8}") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
    
        if (r22.equals("{\\an7}") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
    
        if (r22.equals("{\\an3}") != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c1, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b8, code lost:
    
        if (r22.equals("{\\an2}") != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bf, code lost:
    
        if (r22.equals("{\\an1}") != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0054, code lost:
    
        if (r22.equals("{\\an7}") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x007d, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x005b, code lost:
    
        if (r22.equals("{\\an6}") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0067, code lost:
    
        if (r22.equals("{\\an4}") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x006e, code lost:
    
        if (r22.equals("{\\an3}") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x007b, code lost:
    
        if (r22.equals("{\\an1}") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0048, code lost:
    
        if (r22.equals("{\\an9}") != false) goto L25;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k1.b a(android.text.Spanned r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.a.a(android.text.Spanned, java.lang.String):k1.b");
    }

    public static long c(Matcher matcher, int i10) {
        String group = matcher.group(i10 + 1);
        long parseLong = group != null ? Long.parseLong(group) * 3600000 : 0L;
        String group2 = matcher.group(i10 + 2);
        group2.getClass();
        long parseLong2 = (Long.parseLong(group2) * RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) + parseLong;
        String group3 = matcher.group(i10 + 3);
        group3.getClass();
        long parseLong3 = (Long.parseLong(group3) * 1000) + parseLong2;
        String group4 = matcher.group(i10 + 4);
        if (group4 != null) {
            parseLong3 += Long.parseLong(group4);
        }
        return parseLong3 * 1000;
    }

    @Override // h3.k
    public final /* synthetic */ e b(byte[] bArr, int i10, int i11) {
        return d.a(this, bArr, i11);
    }

    @Override // h3.k
    public final void d(byte[] bArr, int i10, int i11, j jVar, h hVar) {
        String k10;
        String str;
        a aVar = this;
        long j10 = jVar.f5536a;
        t tVar = aVar.f8866q;
        tVar.G(i10 + i11, bArr);
        tVar.I(i10);
        Charset E = tVar.E();
        if (E == null) {
            E = StandardCharsets.UTF_8;
        }
        long j11 = -9223372036854775807L;
        ArrayList arrayList = (j10 == -9223372036854775807L || !jVar.f5537b) ? null : new ArrayList();
        while (true) {
            String k11 = tVar.k(E);
            if (k11 == null) {
                break;
            }
            if (!k11.isEmpty()) {
                try {
                    Integer.parseInt(k11);
                    k10 = tVar.k(E);
                } catch (NumberFormatException unused) {
                    b.q("SubripParser", "Skipping invalid index: ".concat(k11));
                }
                if (k10 == null) {
                    b.q("SubripParser", "Unexpected end");
                    break;
                }
                Matcher matcher = f8862r.matcher(k10);
                if (matcher.matches()) {
                    long c10 = c(matcher, 1);
                    long c11 = c(matcher, 6);
                    StringBuilder sb2 = aVar.f8864o;
                    sb2.setLength(0);
                    long j12 = j11;
                    ArrayList arrayList2 = aVar.f8865p;
                    arrayList2.clear();
                    for (String k12 = tVar.k(E); !TextUtils.isEmpty(k12); k12 = tVar.k(E)) {
                        if (sb2.length() > 0) {
                            sb2.append("<br>");
                        }
                        String trim = k12.trim();
                        StringBuilder sb3 = new StringBuilder(trim);
                        Matcher matcher2 = f8863s.matcher(trim);
                        int i12 = 0;
                        while (matcher2.find()) {
                            String group = matcher2.group();
                            arrayList2.add(group);
                            int start = matcher2.start() - i12;
                            int length = group.length();
                            sb3.replace(start, start + length, _UrlKt.FRAGMENT_ENCODE_SET);
                            i12 += length;
                            j10 = j10;
                        }
                        sb2.append(sb3.toString());
                    }
                    long j13 = j10;
                    Spanned fromHtml = Html.fromHtml(sb2.toString());
                    int i13 = 0;
                    while (true) {
                        if (i13 >= arrayList2.size()) {
                            str = null;
                            break;
                        }
                        str = (String) arrayList2.get(i13);
                        if (str.matches("\\{\\\\an[1-9]\\}")) {
                            break;
                        } else {
                            i13++;
                        }
                    }
                    if (j13 == j12 || c11 >= j13) {
                        hVar.accept(new h3.a(c10, c11 - c10, g0.r(a(fromHtml, str))));
                    } else if (arrayList != null) {
                        arrayList.add(new h3.a(c10, c11 - c10, g0.r(a(fromHtml, str))));
                    }
                    aVar = this;
                    j11 = j12;
                    j10 = j13;
                } else {
                    b.q("SubripParser", "Skipping invalid timing: ".concat(k10));
                    aVar = this;
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i14 = 0;
            while (i14 < size) {
                Object obj = arrayList.get(i14);
                i14++;
                hVar.accept((h3.a) obj);
            }
        }
    }

    @Override // h3.k
    public final /* synthetic */ void reset() {
    }
}
