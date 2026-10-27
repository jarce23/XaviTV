package e3;

import android.util.Pair;
import c2.y0;
import i1.f0;
import i1.g0;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f4428a;

    static {
        int i10 = a0.f8067a;
        f4428a = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static void a(l1.t tVar) {
        int i10 = tVar.f8130b;
        tVar.J(4);
        if (tVar.j() != 1751411826) {
            i10 += 4;
        }
        tVar.I(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:319:0x05a0, code lost:
    
        if (r14 == 2) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:553:0x018f, code lost:
    
        if (r11 == (-1)) goto L95;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0834 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0794  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x09e4 A[LOOP:18: B:459:0x09e4->B:469:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0a21  */
    /* JADX WARN: Removed duplicated region for block: B:471:? A[LOOP:17: B:454:0x09cd->B:471:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:472:? A[LOOP:16: B:451:0x09c5->B:472:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:473:? A[LOOP:15: B:447:0x09ab->B:473:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(l1.t r50, int r51, int r52, int r53, int r54, java.lang.String r55, boolean r56, i1.l r57, app.shamel.tv.activities.v r58, int r59) {
        /*
            Method dump skipped, instructions count: 3252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.e.b(l1.t, int, int, int, int, java.lang.String, boolean, i1.l, app.shamel.tv.activities.v, int):void");
    }

    public static y0 c(int i10, l1.t tVar) {
        tVar.I(i10 + 12);
        tVar.J(1);
        d(tVar);
        tVar.J(2);
        int w10 = tVar.w();
        if ((w10 & 128) != 0) {
            tVar.J(2);
        }
        if ((w10 & 64) != 0) {
            tVar.J(tVar.w());
        }
        if ((w10 & 32) != 0) {
            tVar.J(2);
        }
        tVar.J(1);
        d(tVar);
        String e7 = g0.e(tVar.w());
        if ("audio/mpeg".equals(e7) || "audio/vnd.dts".equals(e7) || "audio/vnd.dts.hd".equals(e7)) {
            return new y0(e7, null, -1L, -1L);
        }
        tVar.J(4);
        long y8 = tVar.y();
        long y10 = tVar.y();
        tVar.J(1);
        int d6 = d(tVar);
        long j10 = y10;
        byte[] bArr = new byte[d6];
        tVar.h(bArr, 0, d6);
        if (j10 <= 0) {
            j10 = -1;
        }
        return new y0(e7, bArr, j10, y8 > 0 ? y8 : -1L);
    }

    public static int d(l1.t tVar) {
        int w10 = tVar.w();
        int i10 = w10 & 127;
        while ((w10 & 128) == 128) {
            w10 = tVar.w();
            i10 = (i10 << 7) | (w10 & 127);
        }
        return i10;
    }

    public static int e(int i10) {
        return (i10 >> 24) & 255;
    }

    public static f0 f(m1.c cVar) {
        m1.a aVar;
        m1.d k10 = cVar.k(1751411826);
        m1.d k11 = cVar.k(1801812339);
        m1.d k12 = cVar.k(1768715124);
        if (k10 != null && k11 != null && k12 != null) {
            l1.t tVar = k10.f8757q;
            tVar.I(16);
            if (tVar.j() == 1835299937) {
                l1.t tVar2 = k11.f8757q;
                tVar2.I(12);
                int j10 = tVar2.j();
                String[] strArr = new String[j10];
                for (int i10 = 0; i10 < j10; i10++) {
                    int j11 = tVar2.j();
                    tVar2.J(4);
                    strArr[i10] = tVar2.u(j11 - 8, StandardCharsets.UTF_8);
                }
                l1.t tVar3 = k12.f8757q;
                tVar3.I(8);
                ArrayList arrayList = new ArrayList();
                while (tVar3.a() > 8) {
                    int i11 = tVar3.f8130b;
                    int j12 = tVar3.j();
                    int j13 = tVar3.j() - 1;
                    if (j13 < 0 || j13 >= j10) {
                        android.support.v4.media.d.x("Skipped metadata with unknown key index: ", j13, "BoxParsers");
                    } else {
                        String str = strArr[j13];
                        int i12 = i11 + j12;
                        while (true) {
                            int i13 = tVar3.f8130b;
                            if (i13 >= i12) {
                                aVar = null;
                                break;
                            }
                            int j14 = tVar3.j();
                            if (tVar3.j() == 1684108385) {
                                int j15 = tVar3.j();
                                int j16 = tVar3.j();
                                int i14 = j14 - 16;
                                byte[] bArr = new byte[i14];
                                tVar3.h(bArr, 0, i14);
                                aVar = new m1.a(str, bArr, j16, j15);
                                break;
                            }
                            tVar3.I(i13 + j14);
                        }
                        if (aVar != null) {
                            arrayList.add(aVar);
                        }
                    }
                    tVar3.I(i11 + j12);
                }
                if (!arrayList.isEmpty()) {
                    return new f0(arrayList);
                }
            }
        }
        return null;
    }

    public static m1.g g(l1.t tVar) {
        long q10;
        long q11;
        tVar.I(8);
        if (e(tVar.j()) == 0) {
            q10 = tVar.y();
            q11 = tVar.y();
        } else {
            q10 = tVar.q();
            q11 = tVar.q();
        }
        return new m1.g(q10, q11, tVar.y());
    }

    public static Pair h(l1.t tVar, int i10, int i11) {
        Integer num;
        r rVar;
        Pair create;
        int i12;
        int i13;
        Integer num2;
        boolean z10;
        int i14 = tVar.f8130b;
        while (i14 - i10 < i11) {
            tVar.I(i14);
            int j10 = tVar.j();
            k2.b.c("childAtomSize must be positive", j10 > 0);
            if (tVar.j() == 1936289382) {
                int i15 = i14 + 8;
                int i16 = 0;
                int i17 = -1;
                Integer num3 = null;
                String str = null;
                while (i15 - i14 < j10) {
                    tVar.I(i15);
                    int j11 = tVar.j();
                    int j12 = tVar.j();
                    if (j12 == 1718775137) {
                        num3 = Integer.valueOf(tVar.j());
                    } else if (j12 == 1935894637) {
                        tVar.J(4);
                        str = tVar.u(4, StandardCharsets.UTF_8);
                    } else if (j12 == 1935894633) {
                        i17 = i15;
                        i16 = j11;
                    }
                    i15 += j11;
                }
                byte[] bArr = null;
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    k2.b.c("frma atom is mandatory", num3 != null);
                    k2.b.c("schi atom is mandatory", i17 != -1);
                    int i18 = i17 + 8;
                    while (true) {
                        if (i18 - i17 >= i16) {
                            num = num3;
                            rVar = null;
                            break;
                        }
                        tVar.I(i18);
                        int j13 = tVar.j();
                        if (tVar.j() == 1952804451) {
                            int e7 = e(tVar.j());
                            tVar.J(1);
                            if (e7 == 0) {
                                tVar.J(1);
                                i13 = 0;
                                i12 = 0;
                            } else {
                                int w10 = tVar.w();
                                i12 = w10 & 15;
                                i13 = (w10 & 240) >> 4;
                            }
                            if (tVar.w() == 1) {
                                num2 = num3;
                                z10 = true;
                            } else {
                                num2 = num3;
                                z10 = false;
                            }
                            int w11 = tVar.w();
                            byte[] bArr2 = new byte[16];
                            tVar.h(bArr2, 0, 16);
                            if (z10 && w11 == 0) {
                                int w12 = tVar.w();
                                byte[] bArr3 = new byte[w12];
                                tVar.h(bArr3, 0, w12);
                                bArr = bArr3;
                            }
                            num = num2;
                            rVar = new r(z10, str, w11, bArr2, i13, i12, bArr);
                        } else {
                            i18 += j13;
                        }
                    }
                    k2.b.c("tenc atom is mandatory", rVar != null);
                    int i19 = a0.f8067a;
                    create = Pair.create(num, rVar);
                } else {
                    create = null;
                }
                if (create != null) {
                    return create;
                }
            }
            i14 += j10;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0805  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0826  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0958  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x095b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static app.shamel.tv.activities.v i(l1.t r67, b4.o1 r68, java.lang.String r69, i1.l r70, boolean r71) {
        /*
            Method dump skipped, instructions count: 3463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.e.i(l1.t, b4.o1, java.lang.String, i1.l, boolean):app.shamel.tv.activities.v");
    }

    /* JADX WARN: Code restructure failed: missing block: B:322:0x00e3, code lost:
    
        if (r23 == 0) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0867  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x090c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0914  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x091a  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0928  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x09bb  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x09ce  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x092b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0924  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x091d  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0917  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x090e  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x084f  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x09f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:425:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList j(m1.c r54, k2.u r55, long r56, i1.l r58, boolean r59, boolean r60, n9.d r61) {
        /*
            Method dump skipped, instructions count: 2557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.e.j(m1.c, k2.u, long, i1.l, boolean, boolean, n9.d):java.util.ArrayList");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01bb, code lost:
    
        r1.I(r15);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01a4, code lost:
    
        r1.I(r9);
        r1.J(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01b7, code lost:
    
        r9 = new y2.l(r0, r8, r1.s(r10 - 16));
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01c0, code lost:
    
        r16 = r3 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x023e, code lost:
    
        l1.b.f("MetadataUtil", "Skipped unknown metadata entry: " + m1.e.c(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0251, code lost:
    
        r1.I(r15);
        r9 = null;
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0079, code lost:
    
        r0 = y2.k.a(e3.p.g(r1) - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0082, code lost:
    
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0084, code lost:
    
        r9 = new y2.o("TCON", r12, o9.g0.r(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x008e, code lost:
    
        l1.b.q("MetadataUtil", "Failed to parse standard genre code");
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0093, code lost:
    
        r9 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00a8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0272, code lost:
    
        r1.I(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0275, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x006f, code lost:
    
        r16 = r3 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01c5, code lost:
    
        r0 = 16777215 & r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01cc, code lost:
    
        if (r0 != 6516084) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01ce, code lost:
    
        r9 = e3.p.d(r13, r1);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01d6, code lost:
    
        if (r0 == 7233901) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01db, code lost:
    
        if (r0 != 7631467) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01e2, code lost:
    
        if (r0 == 6516589) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01e7, code lost:
    
        if (r0 != 7828084) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01ee, code lost:
    
        if (r0 != 6578553) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01f0, code lost:
    
        r9 = e3.p.i(r13, "TDRC", r1);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01fa, code lost:
    
        if (r0 != 4280916) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01fc, code lost:
    
        r9 = e3.p.i(r13, "TPE1", r1);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        r1.I(r7);
        r7 = r7 + r13;
        r1.J(r0);
        r6 = new java.util.ArrayList();
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0206, code lost:
    
        if (r0 != 7630703) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0208, code lost:
    
        r9 = e3.p.i(r13, "TSSE", r1);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0212, code lost:
    
        if (r0 != 6384738) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0214, code lost:
    
        r9 = e3.p.i(r13, "TALB", r1);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x021e, code lost:
    
        if (r0 != 7108978) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0220, code lost:
    
        r9 = e3.p.i(r13, "USLT", r1);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x022a, code lost:
    
        if (r0 != 6776174) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
    
        r13 = r1.f8130b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x022c, code lost:
    
        r9 = e3.p.i(r13, "TCON", r1);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0231, code lost:
    
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0234, code lost:
    
        if (r0 != 6779504) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0236, code lost:
    
        r9 = e3.p.i(r13, "TIT1", r1);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0256, code lost:
    
        r9 = e3.p.i(r13, "TCOM", r1);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x025e, code lost:
    
        r9 = e3.p.i(r13, "TIT2", r1);
        r16 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0276, code lost:
    
        r16 = r3 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x027c, code lost:
    
        if (r6.isEmpty() == false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
    
        if (r13 >= r7) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0280, code lost:
    
        r12 = new i1.f0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
    
        r15 = r1.j() + r13;
        r13 = r1.j();
        r0 = (r13 >> 24) & 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
    
        if (r0 == 169) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r0 != 253) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        if (r13 != 1735291493) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009f, code lost:
    
        if (r13 != 1684632427) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a1, code lost:
    
        r9 = e3.p.f(r13, "TPOS", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:
    
        r1.I(r15);
        r16 = r3 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0266, code lost:
    
        if (r9 == null) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0268, code lost:
    
        r6.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x026b, code lost:
    
        r3 = r16;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ae, code lost:
    
        if (r13 != 1953655662) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b0, code lost:
    
        r9 = e3.p.f(r13, "TRCK", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ba, code lost:
    
        if (r13 != 1953329263) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bc, code lost:
    
        r9 = e3.p.h(r13, "TBPM", r1, true, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c6, code lost:
    
        if (r13 != 1668311404) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c8, code lost:
    
        r9 = e3.p.h(r13, "TCMP", r1, true, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d2, code lost:
    
        if (r13 != 1668249202) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d4, code lost:
    
        r9 = e3.p.e(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dc, code lost:
    
        if (r13 != 1631670868) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00de, code lost:
    
        r9 = e3.p.i(r13, "TPE2", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e8, code lost:
    
        if (r13 != 1936682605) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ea, code lost:
    
        r9 = e3.p.i(r13, "TSOT", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f4, code lost:
    
        if (r13 != 1936679276) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f6, code lost:
    
        r9 = e3.p.i(r13, "TSOA", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0100, code lost:
    
        if (r13 != 1936679282) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0102, code lost:
    
        r9 = e3.p.i(r13, "TSOP", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010c, code lost:
    
        if (r13 != 1936679265) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010e, code lost:
    
        r9 = e3.p.i(r13, "TSO2", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0119, code lost:
    
        if (r13 != 1936679791) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011b, code lost:
    
        r9 = e3.p.i(r13, "TSOC", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0126, code lost:
    
        if (r13 != 1920233063) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0128, code lost:
    
        r9 = e3.p.h(r13, "ITUNESADVISORY", r1, r3, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0133, code lost:
    
        if (r13 != 1885823344) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0135, code lost:
    
        r9 = e3.p.h(r13, "ITUNESGAPLESS", r1, r3, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0140, code lost:
    
        if (r13 != 1936683886) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0142, code lost:
    
        r9 = e3.p.i(r13, "TVSHOWSORT", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x014d, code lost:
    
        if (r13 != 1953919848) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x014f, code lost:
    
        r9 = e3.p.i(r13, "TVSHOW", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x015a, code lost:
    
        if (r13 != 757935405) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x015c, code lost:
    
        r0 = r12;
        r8 = r0;
        r9 = -1;
        r10 = -1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0160, code lost:
    
        r13 = r1.f8130b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0162, code lost:
    
        if (r13 >= r15) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0164, code lost:
    
        r14 = r1.j();
        r12 = r1.j();
        r16 = r3;
        r1.J(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0175, code lost:
    
        if (r12 != 1835360622) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0177, code lost:
    
        r0 = r1.s(r14 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0196, code lost:
    
        r3 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0181, code lost:
    
        if (r12 != 1851878757) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0183, code lost:
    
        r8 = r1.s(r14 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x018d, code lost:
    
        if (r12 != 1684108385) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x018f, code lost:
    
        r9 = r13;
        r10 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0191, code lost:
    
        r1.J(r14 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x019a, code lost:
    
        r16 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x019c, code lost:
    
        if (r0 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x019e, code lost:
    
        if (r8 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01a1, code lost:
    
        if (r9 != (-1)) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ba, code lost:
    
        r9 = null;
        r16 = r16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0328  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i1.f0 k(m1.d r17) {
        /*
            Method dump skipped, instructions count: 942
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.e.k(m1.d):i1.f0");
    }
}
