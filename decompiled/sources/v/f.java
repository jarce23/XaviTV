package v;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d, reason: collision with root package name */
    public final o f12601d;

    /* renamed from: f, reason: collision with root package name */
    public int f12603f;
    public int g;

    /* renamed from: a, reason: collision with root package name */
    public o f12598a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12599b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12600c = false;

    /* renamed from: e, reason: collision with root package name */
    public int f12602e = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f12604h = 1;

    /* renamed from: i, reason: collision with root package name */
    public g f12605i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12606j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f12607k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f12608l = new ArrayList();

    public f(o oVar) {
        this.f12601d = oVar;
    }

    @Override // v.d
    public final void a(d dVar) {
        ArrayList arrayList = this.f12608l;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            if (!((f) obj).f12606j) {
                return;
            }
        }
        this.f12600c = true;
        o oVar = this.f12598a;
        if (oVar != null) {
            oVar.a(this);
        }
        if (this.f12599b) {
            this.f12601d.a(this);
            return;
        }
        int size2 = arrayList.size();
        f fVar = null;
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList.get(i12);
            i12++;
            f fVar2 = (f) obj2;
            if (!(fVar2 instanceof g)) {
                i10++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i10 == 1 && fVar.f12606j) {
            g gVar = this.f12605i;
            if (gVar != null) {
                if (!gVar.f12606j) {
                    return;
                } else {
                    this.f12603f = this.f12604h * gVar.g;
                }
            }
            d(fVar.g + this.f12603f);
        }
        o oVar2 = this.f12598a;
        if (oVar2 != null) {
            oVar2.a(this);
        }
    }

    public final void b(o oVar) {
        this.f12607k.add(oVar);
        if (this.f12606j) {
            oVar.a(oVar);
        }
    }

    public final void c() {
        this.f12608l.clear();
        this.f12607k.clear();
        this.f12606j = false;
        this.g = 0;
        this.f12600c = false;
        this.f12599b = false;
    }

    public void d(int i10) {
        if (this.f12606j) {
            return;
        }
        this.f12606j = true;
        this.g = i10;
        ArrayList arrayList = this.f12607k;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            d dVar = (d) obj;
            dVar.a(dVar);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f12601d.f12623b.f12072g0);
        sb2.append(":");
        switch (this.f12602e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb2.append(str);
        sb2.append("(");
        sb2.append(this.f12606j ? Integer.valueOf(this.g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f12608l.size());
        sb2.append(":d=");
        sb2.append(this.f12607k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
