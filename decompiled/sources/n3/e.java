package n3;

import b4.j0;
import com.google.android.gms.internal.cast.n;
import com.google.android.gms.internal.cast.u5;
import h3.j;
import h3.k;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l1.a0;
import l1.h;
import okhttp3.internal.url._UrlKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements k {

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f9140p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f9141q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f9142r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f9143s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f9144t = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f9145u = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");

    /* renamed from: v, reason: collision with root package name */
    public static final Pattern f9146v = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: w, reason: collision with root package name */
    public static final d f9147w = new d(30.0f, 1, 1);

    /* renamed from: o, reason: collision with root package name */
    public final XmlPullParserFactory f9148o;

    public e() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f9148o = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e7) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e7);
        }
    }

    public static g a(g gVar) {
        return gVar == null ? new g() : gVar;
    }

    public static boolean c(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    public static int e(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return 15;
        }
        Matcher matcher = f9146v.matcher(attributeValue);
        if (!matcher.matches()) {
            l1.b.q("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return 15;
        }
        boolean z10 = true;
        try {
            String group = matcher.group(1);
            group.getClass();
            int parseInt = Integer.parseInt(group);
            String group2 = matcher.group(2);
            group2.getClass();
            int parseInt2 = Integer.parseInt(group2);
            if (parseInt == 0 || parseInt2 == 0) {
                z10 = false;
            }
            l1.d.a("Invalid cell resolution " + parseInt + " " + parseInt2, z10);
            return parseInt2;
        } catch (NumberFormatException unused) {
            l1.b.q("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return 15;
        }
    }

    public static void f(String str, g gVar) {
        Matcher matcher;
        String group;
        int i10 = a0.f8067a;
        String[] split = str.split("\\s+", -1);
        int length = split.length;
        Pattern pattern = f9142r;
        if (length == 1) {
            matcher = pattern.matcher(str);
        } else {
            if (split.length != 2) {
                throw new h3.g(r.a.d(new StringBuilder("Invalid number of entries for fontSize: "), split.length, "."));
            }
            matcher = pattern.matcher(split[1]);
            l1.b.q("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new h3.g(android.support.v4.media.d.q("Invalid expression for fontSize: '", str, "'."));
        }
        group = matcher.group(3);
        group.getClass();
        switch (group) {
            case "%":
                gVar.f9166j = 3;
                break;
            case "em":
                gVar.f9166j = 2;
                break;
            case "px":
                gVar.f9166j = 1;
                break;
            default:
                throw new h3.g(android.support.v4.media.d.q("Invalid unit for fontSize: '", group, "'."));
        }
        String group2 = matcher.group(1);
        group2.getClass();
        gVar.f9167k = Float.parseFloat(group2);
    }

    public static d g(XmlPullParser xmlPullParser) {
        float f10;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            int i10 = a0.f8067a;
            l1.d.a("frameRateMultiplier doesn't have 2 parts", attributeValue2.split(" ", -1).length == 2);
            f10 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f10 = 1.0f;
        }
        d dVar = f9147w;
        int i11 = dVar.f9138b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i11 = Integer.parseInt(attributeValue3);
        }
        int i12 = dVar.f9139c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i12 = Integer.parseInt(attributeValue4);
        }
        return new d(parseInt * f10, i11, i12);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h(org.xmlpull.v1.XmlPullParser r20, java.util.HashMap r21, int r22, b4.j0 r23, java.util.HashMap r24, java.util.HashMap r25) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.e.h(org.xmlpull.v1.XmlPullParser, java.util.HashMap, int, b4.j0, java.util.HashMap, java.util.HashMap):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static c i(XmlPullParser xmlPullParser, c cVar, HashMap hashMap, d dVar) {
        long j10;
        char c10;
        String[] split;
        int attributeCount = xmlPullParser.getAttributeCount();
        String[] strArr = null;
        g j11 = j(xmlPullParser, null);
        String str = null;
        String str2 = _UrlKt.FRAGMENT_ENCODE_SET;
        long j12 = -9223372036854775807L;
        long j13 = -9223372036854775807L;
        long j14 = -9223372036854775807L;
        for (int i10 = 0; i10 < attributeCount; i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            String attributeValue = xmlPullParser.getAttributeValue(i10);
            attributeName.getClass();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    if (!hashMap.containsKey(attributeValue)) {
                        break;
                    } else {
                        str2 = attributeValue;
                        continue;
                    }
                case 1:
                    j14 = k(attributeValue, dVar);
                    break;
                case 2:
                    j13 = k(attributeValue, dVar);
                    break;
                case 3:
                    j12 = k(attributeValue, dVar);
                    break;
                case 4:
                    String trim = attributeValue.trim();
                    if (trim.isEmpty()) {
                        split = new String[0];
                    } else {
                        int i11 = a0.f8067a;
                        split = trim.split("\\s+", -1);
                    }
                    if (split.length > 0) {
                        strArr = split;
                        break;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith("#")) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (cVar != null) {
            long j15 = cVar.f9128d;
            if (j15 != -9223372036854775807L) {
                if (j12 != -9223372036854775807L) {
                    j12 += j15;
                }
                if (j13 != -9223372036854775807L) {
                    j13 += j15;
                }
            }
        }
        if (j13 == -9223372036854775807L) {
            if (j14 != -9223372036854775807L) {
                j13 = j12 + j14;
            } else if (cVar != null) {
                long j16 = cVar.f9129e;
                if (j16 != -9223372036854775807L) {
                    j10 = j16;
                    return new c(xmlPullParser.getName(), null, j12, j10, j11, strArr, str2, str, cVar);
                }
            }
        }
        j10 = j13;
        return new c(xmlPullParser.getName(), null, j12, j10, j11, strArr, str2, str, cVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x025c  */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static n3.g j(org.xmlpull.v1.XmlPullParser r18, n3.g r19) {
        /*
            Method dump skipped, instructions count: 1550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.e.j(org.xmlpull.v1.XmlPullParser, n3.g):n3.g");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long k(java.lang.String r13, n3.d r14) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.e.k(java.lang.String, n3.d):long");
    }

    public static j0 l(XmlPullParser xmlPullParser) {
        String k10 = l1.d.k(xmlPullParser, "extent");
        if (k10 == null) {
            return null;
        }
        Matcher matcher = f9145u.matcher(k10);
        if (!matcher.matches()) {
            l1.b.q("TtmlParser", "Ignoring non-pixel tts extent: ".concat(k10));
            return null;
        }
        try {
            String group = matcher.group(1);
            group.getClass();
            int parseInt = Integer.parseInt(group);
            String group2 = matcher.group(2);
            group2.getClass();
            return new j0(parseInt, Integer.parseInt(group2), 6);
        } catch (NumberFormatException unused) {
            l1.b.q("TtmlParser", "Ignoring malformed tts extent: ".concat(k10));
            return null;
        }
    }

    @Override // h3.k
    public final h3.e b(byte[] bArr, int i10, int i11) {
        try {
            XmlPullParser newPullParser = this.f9148o.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put(_UrlKt.FRAGMENT_ENCODE_SET, new f(_UrlKt.FRAGMENT_ENCODE_SET, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            j0 j0Var = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, i10, i11), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            d dVar = f9147w;
            int i12 = 0;
            int i13 = 15;
            u5 u5Var = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                c cVar = (c) arrayDeque.peek();
                if (i12 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            dVar = g(newPullParser);
                            i13 = e(newPullParser);
                            j0Var = l(newPullParser);
                        }
                        d dVar2 = dVar;
                        j0 j0Var2 = j0Var;
                        int i14 = i13;
                        if (c(name)) {
                            if ("head".equals(name)) {
                                h(newPullParser, hashMap, i14, j0Var2, hashMap2, hashMap3);
                            } else {
                                try {
                                    c i15 = i(newPullParser, cVar, hashMap2, dVar2);
                                    arrayDeque.push(i15);
                                    if (cVar != null) {
                                        if (cVar.f9136m == null) {
                                            cVar.f9136m = new ArrayList();
                                        }
                                        cVar.f9136m.add(i15);
                                    }
                                } catch (h3.g e7) {
                                    l1.b.r("TtmlParser", "Suppressing parser error", e7);
                                }
                            }
                            i13 = i14;
                            j0Var = j0Var2;
                            dVar = dVar2;
                        } else {
                            l1.b.l("TtmlParser", "Ignoring unsupported tag: " + newPullParser.getName());
                        }
                        i12++;
                        i13 = i14;
                        j0Var = j0Var2;
                        dVar = dVar2;
                    } else if (eventType == 4) {
                        cVar.getClass();
                        c a10 = c.a(newPullParser.getText());
                        if (cVar.f9136m == null) {
                            cVar.f9136m = new ArrayList();
                        }
                        cVar.f9136m.add(a10);
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            c cVar2 = (c) arrayDeque.peek();
                            cVar2.getClass();
                            u5Var = new u5(cVar2, hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i12++;
                } else if (eventType == 3) {
                    i12--;
                }
                newPullParser.next();
            }
            u5Var.getClass();
            return u5Var;
        } catch (IOException e8) {
            throw new IllegalStateException("Unexpected error when reading input.", e8);
        } catch (XmlPullParserException e10) {
            throw new IllegalStateException("Unable to decode source", e10);
        }
    }

    @Override // h3.k
    public final void d(byte[] bArr, int i10, int i11, j jVar, h hVar) {
        n.v(b(bArr, i10, i11), jVar, hVar);
    }

    @Override // h3.k
    public final /* synthetic */ void reset() {
    }
}
