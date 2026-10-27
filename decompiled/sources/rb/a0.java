package rb;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 implements s0 {

    /* renamed from: o, reason: collision with root package name */
    public byte f10990o;

    /* renamed from: p, reason: collision with root package name */
    public final m0 f10991p;

    /* renamed from: q, reason: collision with root package name */
    public final Inflater f10992q;

    /* renamed from: r, reason: collision with root package name */
    public final c0 f10993r;

    /* renamed from: s, reason: collision with root package name */
    public final CRC32 f10994s;

    public a0(n nVar) {
        za.h.e("source", nVar);
        m0 m0Var = new m0(nVar);
        this.f10991p = m0Var;
        Inflater inflater = new Inflater(true);
        this.f10992q = inflater;
        this.f10993r = new c0(m0Var, inflater);
        this.f10994s = new CRC32();
    }

    public static void a(String str, int i10, int i11) {
        if (i11 == i10) {
            return;
        }
        StringBuilder a10 = s.e.a(str, ": actual 0x");
        a10.append(gb.i.j0(b.j(i11)));
        a10.append(" != expected 0x");
        a10.append(gb.i.j0(b.j(i10)));
        throw new IOException(a10.toString());
    }

    public final void c(long j10, l lVar, long j11) {
        n0 n0Var = lVar.f11034o;
        za.h.b(n0Var);
        while (true) {
            int i10 = n0Var.f11044c;
            int i11 = n0Var.f11043b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
        }
        while (j11 > 0) {
            int min = (int) Math.min(n0Var.f11044c - r5, j11);
            this.f10994s.update(n0Var.f11042a, (int) (n0Var.f11043b + j10), min);
            j11 -= min;
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
            j10 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f10993r.close();
    }

    @Override // rb.s0
    public final long read(l lVar, long j10) {
        a0 a0Var = this;
        za.h.e("sink", lVar);
        if (j10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.n(j10, "byteCount < 0: ").toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        byte b2 = a0Var.f10990o;
        CRC32 crc32 = a0Var.f10994s;
        m0 m0Var = a0Var.f10991p;
        if (b2 == 0) {
            m0Var.D(10L);
            l lVar2 = m0Var.f11040p;
            byte x6 = lVar2.x(3L);
            boolean z10 = ((x6 >> 1) & 1) == 1;
            if (z10) {
                a0Var.c(0L, lVar2, 10L);
            }
            a("ID1ID2", 8075, m0Var.readShort());
            m0Var.skip(8L);
            if (((x6 >> 2) & 1) == 1) {
                m0Var.D(2L);
                if (z10) {
                    c(0L, lVar2, 2L);
                }
                long Q = lVar2.Q() & 65535;
                m0Var.D(Q);
                if (z10) {
                    c(0L, lVar2, Q);
                }
                m0Var.skip(Q);
            }
            if (((x6 >> 3) & 1) == 1) {
                long a10 = m0Var.a((byte) 0, 0L, Long.MAX_VALUE);
                if (a10 == -1) {
                    throw new EOFException();
                }
                if (z10) {
                    c(0L, lVar2, a10 + 1);
                }
                m0Var.skip(a10 + 1);
            }
            if (((x6 >> 4) & 1) == 1) {
                long a11 = m0Var.a((byte) 0, 0L, Long.MAX_VALUE);
                if (a11 == -1) {
                    throw new EOFException();
                }
                if (z10) {
                    a0Var = this;
                    a0Var.c(0L, lVar2, a11 + 1);
                } else {
                    a0Var = this;
                }
                m0Var.skip(a11 + 1);
            } else {
                a0Var = this;
            }
            if (z10) {
                a("FHCRC", m0Var.s(), (short) crc32.getValue());
                crc32.reset();
            }
            a0Var.f10990o = (byte) 1;
        }
        if (a0Var.f10990o == 1) {
            long j11 = lVar.f11035p;
            long read = a0Var.f10993r.read(lVar, j10);
            if (read != -1) {
                a0Var.c(j11, lVar, read);
                return read;
            }
            a0Var.f10990o = (byte) 2;
        }
        if (a0Var.f10990o == 2) {
            a("CRC", m0Var.c(), (int) crc32.getValue());
            a("ISIZE", m0Var.c(), (int) a0Var.f10992q.getBytesWritten());
            a0Var.f10990o = (byte) 3;
            if (!m0Var.t()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // rb.s0
    public final v0 timeout() {
        return this.f10991p.f11039o.timeout();
    }
}
