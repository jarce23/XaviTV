package s2;

import o9.d0;
import o9.g0;
import o9.w0;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f11528a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f11529b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f11530c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
    
        if (r6 == (-1)) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b4.c a(java.lang.String r19) {
        /*
            org.xmlpull.v1.XmlPullParserFactory r0 = org.xmlpull.v1.XmlPullParserFactory.newInstance()
            org.xmlpull.v1.XmlPullParser r0 = r0.newPullParser()
            java.io.StringReader r1 = new java.io.StringReader
            r2 = r19
            r1.<init>(r2)
            r0.setInput(r1)
            r0.next()
            java.lang.String r1 = "x:xmpmeta"
            boolean r2 = l1.d.m(r0, r1)
            r3 = 0
            if (r2 == 0) goto Lcf
            o9.e0 r2 = o9.g0.f9617p
            o9.w0 r2 = o9.w0.f9686s
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r4
        L28:
            r0.next()
            java.lang.String r8 = "rdf:Description"
            boolean r8 = l1.d.m(r0, r8)
            r9 = 2
            if (r8 == 0) goto L9b
            r2 = 0
            r6 = r2
        L36:
            r7 = 4
            if (r6 >= r7) goto Lc8
            java.lang.String[] r8 = s2.d.f11528a
            r8 = r8[r6]
            java.lang.String r8 = l1.d.k(r0, r8)
            if (r8 == 0) goto L98
            int r6 = java.lang.Integer.parseInt(r8)
            r8 = 1
            if (r6 != r8) goto Lc8
            r6 = r2
        L4b:
            if (r6 >= r7) goto L61
            java.lang.String[] r8 = s2.d.f11529b
            r8 = r8[r6]
            java.lang.String r8 = l1.d.k(r0, r8)
            if (r8 == 0) goto L63
            long r6 = java.lang.Long.parseLong(r8)
            r10 = -1
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 != 0) goto L66
        L61:
            r6 = r4
            goto L66
        L63:
            int r6 = r6 + 1
            goto L4b
        L66:
            if (r2 >= r9) goto L93
            java.lang.String[] r8 = s2.d.f11530c
            r8 = r8[r2]
            java.lang.String r8 = l1.d.k(r0, r8)
            if (r8 == 0) goto L90
            long r11 = java.lang.Long.parseLong(r8)
            s2.b r13 = new s2.b
            r14 = 0
            r16 = 0
            java.lang.String r18 = "image/jpeg"
            r13.<init>(r14, r16, r18)
            r2 = r13
            s2.b r10 = new s2.b
            java.lang.String r15 = "video/mp4"
            r13 = 0
            r10.<init>(r11, r13, r15)
            o9.w0 r2 = o9.g0.s(r2, r10)
            goto Lbc
        L90:
            int r2 = r2 + 1
            goto L66
        L93:
            o9.e0 r2 = o9.g0.f9617p
            o9.w0 r2 = o9.w0.f9686s
            goto Lbc
        L98:
            int r6 = r6 + 1
            goto L36
        L9b:
            java.lang.String r8 = "Container:Directory"
            boolean r8 = l1.d.m(r0, r8)
            if (r8 == 0) goto Lac
            java.lang.String r2 = "Container"
            java.lang.String r8 = "Item"
            o9.w0 r2 = b(r0, r2, r8)
            goto Lbc
        Lac:
            java.lang.String r8 = "GContainer:Directory"
            boolean r8 = l1.d.m(r0, r8)
            if (r8 == 0) goto Lbc
            java.lang.String r2 = "GContainer"
            java.lang.String r8 = "GContainerItem"
            o9.w0 r2 = b(r0, r2, r8)
        Lbc:
            boolean r8 = l1.d.l(r0, r1)
            if (r8 == 0) goto L28
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto Lc9
        Lc8:
            return r3
        Lc9:
            b4.c r0 = new b4.c
            r0.<init>(r9, r6, r2)
            return r0
        Lcf:
            java.lang.String r0 = "Couldn't find xmp metadata"
            i1.h0 r0 = i1.h0.a(r3, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.d.a(java.lang.String):b4.c");
    }

    public static w0 b(XmlPullParser xmlPullParser, String str, String str2) {
        d0 m10 = g0.m();
        String concat = str.concat(":Item");
        String concat2 = str.concat(":Directory");
        do {
            xmlPullParser.next();
            if (l1.d.m(xmlPullParser, concat)) {
                String concat3 = str2.concat(":Mime");
                String concat4 = str2.concat(":Semantic");
                String concat5 = str2.concat(":Length");
                String concat6 = str2.concat(":Padding");
                String k10 = l1.d.k(xmlPullParser, concat3);
                String k11 = l1.d.k(xmlPullParser, concat4);
                String k12 = l1.d.k(xmlPullParser, concat5);
                String k13 = l1.d.k(xmlPullParser, concat6);
                if (k10 == null || k11 == null) {
                    return w0.f9686s;
                }
                m10.a(new b(k12 != null ? Long.parseLong(k12) : 0L, k13 != null ? Long.parseLong(k13) : 0L, k10));
            }
        } while (!l1.d.l(xmlPullParser, concat2));
        return m10.f();
    }
}
