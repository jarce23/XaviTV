package mb;

import androidx.lifecycle.h0;
import ib.s;
import kb.i;
import ya.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends ra.h implements p {

    /* renamed from: p, reason: collision with root package name */
    public i f9075p;

    /* renamed from: q, reason: collision with root package name */
    public byte[] f9076q;

    /* renamed from: r, reason: collision with root package name */
    public int f9077r;

    /* renamed from: s, reason: collision with root package name */
    public int f9078s;

    /* renamed from: t, reason: collision with root package name */
    public int f9079t;

    /* renamed from: u, reason: collision with root package name */
    public /* synthetic */ Object f9080u;

    /* renamed from: v, reason: collision with root package name */
    public final /* synthetic */ lb.f[] f9081v;

    /* renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h0 f9082w;

    /* renamed from: x, reason: collision with root package name */
    public final /* synthetic */ t4.g f9083x;

    /* renamed from: y, reason: collision with root package name */
    public final /* synthetic */ lb.g f9084y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(lb.f[] fVarArr, h0 h0Var, t4.g gVar, lb.g gVar2, pa.d dVar) {
        super(2, dVar);
        this.f9081v = fVarArr;
        this.f9082w = h0Var;
        this.f9083x = gVar;
        this.f9084y = gVar2;
    }

    @Override // ya.p
    public final Object b(Object obj, Object obj2) {
        return ((f) create((s) obj, (pa.d) obj2)).invokeSuspend(la.i.f8335a);
    }

    @Override // ra.a
    public final pa.d create(Object obj, pa.d dVar) {
        f fVar = new f(this.f9081v, this.f9082w, this.f9083x, this.f9084y, dVar);
        fVar.f9080u = obj;
        return fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0089, code lost:
    
        if (r12 == r1) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00de, code lost:
    
        if (r18.f9083x.c(r18.f9084y, r12, r18) == r1) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
    
        if (r8 != 0) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.io.Serializable, java.lang.Object[], t4.c[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00de -> B:11:0x0077). Please report as a decompilation issue!!! */
    @Override // ra.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mb.f.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
