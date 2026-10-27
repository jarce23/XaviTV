package v;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends o {
    @Override // v.d
    public final void a(d dVar) {
        f fVar = this.f12628h;
        if (fVar.f12600c && !fVar.f12606j) {
            fVar.d((int) ((((f) fVar.f12608l.get(0)).g * ((u.h) this.f12623b).f12137p0) + 0.5f));
        }
    }

    @Override // v.o
    public final void d() {
        u.d dVar = this.f12623b;
        u.h hVar = (u.h) dVar;
        int i10 = hVar.f12138q0;
        int i11 = hVar.f12139r0;
        int i12 = hVar.f12141t0;
        f fVar = this.f12628h;
        if (i12 == 1) {
            if (i10 != -1) {
                fVar.f12608l.add(dVar.S.f12066d.f12628h);
                this.f12623b.S.f12066d.f12628h.f12607k.add(fVar);
                fVar.f12603f = i10;
            } else if (i11 != -1) {
                fVar.f12608l.add(dVar.S.f12066d.f12629i);
                this.f12623b.S.f12066d.f12629i.f12607k.add(fVar);
                fVar.f12603f = -i11;
            } else {
                fVar.f12599b = true;
                fVar.f12608l.add(dVar.S.f12066d.f12629i);
                this.f12623b.S.f12066d.f12629i.f12607k.add(fVar);
            }
            m(this.f12623b.f12066d.f12628h);
            m(this.f12623b.f12066d.f12629i);
            return;
        }
        if (i10 != -1) {
            fVar.f12608l.add(dVar.S.f12068e.f12628h);
            this.f12623b.S.f12068e.f12628h.f12607k.add(fVar);
            fVar.f12603f = i10;
        } else if (i11 != -1) {
            fVar.f12608l.add(dVar.S.f12068e.f12629i);
            this.f12623b.S.f12068e.f12629i.f12607k.add(fVar);
            fVar.f12603f = -i11;
        } else {
            fVar.f12599b = true;
            fVar.f12608l.add(dVar.S.f12068e.f12629i);
            this.f12623b.S.f12068e.f12629i.f12607k.add(fVar);
        }
        m(this.f12623b.f12068e.f12628h);
        m(this.f12623b.f12068e.f12629i);
    }

    @Override // v.o
    public final void e() {
        u.d dVar = this.f12623b;
        int i10 = ((u.h) dVar).f12141t0;
        f fVar = this.f12628h;
        if (i10 == 1) {
            dVar.X = fVar.g;
        } else {
            dVar.Y = fVar.g;
        }
    }

    @Override // v.o
    public final void f() {
        this.f12628h.c();
    }

    @Override // v.o
    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        f fVar2 = this.f12628h;
        fVar2.f12607k.add(fVar);
        fVar.f12608l.add(fVar2);
    }
}
