package i3;

import androidx.fragment.app.v0;
import java.util.ArrayDeque;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i implements h3.f {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f6390a = new ArrayDeque();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f6391b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f6392c;

    /* renamed from: d, reason: collision with root package name */
    public h f6393d;

    /* renamed from: e, reason: collision with root package name */
    public long f6394e;

    /* renamed from: f, reason: collision with root package name */
    public long f6395f;
    public long g;

    public i() {
        for (int i10 = 0; i10 < 10; i10++) {
            this.f6390a.add(new h(1));
        }
        this.f6391b = new ArrayDeque();
        for (int i11 = 0; i11 < 2; i11++) {
            ArrayDeque arrayDeque = this.f6391b;
            v0 v0Var = new v0(10, this);
            h3.d dVar = new h3.d();
            dVar.f5532v = v0Var;
            arrayDeque.add(dVar);
        }
        this.f6392c = new ArrayDeque();
        this.g = -9223372036854775807L;
    }

    @Override // r1.b
    public final void b(h3.h hVar) {
        l1.d.b(hVar == this.f6393d);
        h hVar2 = (h) hVar;
        if (!hVar2.d(4)) {
            long j10 = hVar2.f10412u;
            if (j10 != Long.MIN_VALUE) {
                long j11 = this.g;
                if (j11 != -9223372036854775807L && j10 < j11) {
                    hVar2.j();
                    this.f6390a.add(hVar2);
                    this.f6393d = null;
                }
            }
        }
        long j12 = this.f6395f;
        this.f6395f = 1 + j12;
        hVar2.f6389y = j12;
        this.f6392c.add(hVar2);
        this.f6393d = null;
    }

    @Override // r1.b
    public final void c(long j10) {
        this.g = j10;
    }

    @Override // h3.f
    public final void d(long j10) {
        this.f6394e = j10;
    }

    @Override // r1.b
    public final Object f() {
        l1.d.g(this.f6393d == null);
        ArrayDeque arrayDeque = this.f6390a;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        h hVar = (h) arrayDeque.pollFirst();
        this.f6393d = hVar;
        return hVar;
    }

    @Override // r1.b
    public void flush() {
        ArrayDeque arrayDeque;
        this.f6395f = 0L;
        this.f6394e = 0L;
        while (true) {
            ArrayDeque arrayDeque2 = this.f6392c;
            boolean isEmpty = arrayDeque2.isEmpty();
            arrayDeque = this.f6390a;
            if (isEmpty) {
                break;
            }
            h hVar = (h) arrayDeque2.poll();
            int i10 = a0.f8067a;
            hVar.j();
            arrayDeque.add(hVar);
        }
        h hVar2 = this.f6393d;
        if (hVar2 != null) {
            hVar2.j();
            arrayDeque.add(hVar2);
            this.f6393d = null;
        }
    }

    public abstract a3.f g();

    public abstract void h(h hVar);

    @Override // r1.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public h3.d e() {
        ArrayDeque arrayDeque = this.f6391b;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        while (true) {
            ArrayDeque arrayDeque2 = this.f6392c;
            if (arrayDeque2.isEmpty()) {
                return null;
            }
            h hVar = (h) arrayDeque2.peek();
            int i10 = a0.f8067a;
            if (hVar.f10412u > this.f6394e) {
                return null;
            }
            h hVar2 = (h) arrayDeque2.poll();
            boolean d6 = hVar2.d(4);
            ArrayDeque arrayDeque3 = this.f6390a;
            if (d6) {
                h3.d dVar = (h3.d) arrayDeque.pollFirst();
                dVar.b(4);
                hVar2.j();
                arrayDeque3.add(hVar2);
                return dVar;
            }
            h(hVar2);
            if (j()) {
                a3.f g = g();
                h3.d dVar2 = (h3.d) arrayDeque.pollFirst();
                long j10 = hVar2.f10412u;
                dVar2.f10415q = j10;
                dVar2.f5529s = g;
                dVar2.f5530t = j10;
                hVar2.j();
                arrayDeque3.add(hVar2);
                return dVar2;
            }
            hVar2.j();
            arrayDeque3.add(hVar2);
        }
    }

    public abstract boolean j();

    @Override // r1.b
    public void a() {
    }
}
