package u3;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 extends FrameLayout implements e0 {

    /* renamed from: o, reason: collision with root package name */
    public final b f12422o;

    /* renamed from: p, reason: collision with root package name */
    public final j0 f12423p;

    /* renamed from: q, reason: collision with root package name */
    public List f12424q;

    /* renamed from: r, reason: collision with root package name */
    public c f12425r;

    /* renamed from: s, reason: collision with root package name */
    public float f12426s;

    /* renamed from: t, reason: collision with root package name */
    public int f12427t;

    /* renamed from: u, reason: collision with root package name */
    public float f12428u;

    public l0(Context context) {
        super(context, null);
        this.f12424q = Collections.EMPTY_LIST;
        this.f12425r = c.g;
        this.f12426s = 0.0533f;
        this.f12427t = 0;
        this.f12428u = 0.08f;
        b bVar = new b(context, 0);
        this.f12422o = bVar;
        j0 j0Var = new j0(context, null);
        this.f12423p = j0Var;
        j0Var.setBackgroundColor(0);
        addView(bVar);
        addView(j0Var);
    }

    @Override // u3.e0
    public final void a(List list, c cVar, float f10, int i10, float f11) {
        this.f12425r = cVar;
        this.f12426s = f10;
        this.f12427t = i10;
        this.f12428u = f11;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            k1.b bVar = (k1.b) list.get(i11);
            if (bVar.f7626d != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.f12424q.isEmpty() || !arrayList2.isEmpty()) {
            this.f12424q = arrayList2;
            c();
        }
        this.f12422o.a(arrayList, cVar, f10, i10, f11);
        invalidate();
    }

    public final String b(int i10, float f10) {
        float p10 = j1.c.p(i10, f10, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (p10 == -3.4028235E38f) {
            return "unset";
        }
        Object[] objArr = {Float.valueOf(p10 / getContext().getResources().getDisplayMetrics().density)};
        int i11 = l1.a0.f8067a;
        return String.format(Locale.US, "%.2fpx", objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x04c1, code lost:
    
        if (((android.text.style.TypefaceSpan) r3).getFamily() != null) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x01ff, code lost:
    
        if (r12 != 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0202, code lost:
    
        r30 = "left";
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0205, code lost:
    
        if (r12 != 0) goto L85;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x054a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x06a3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0253  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 1867
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.l0.c():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!z10 || this.f12424q.isEmpty()) {
            return;
        }
        c();
    }
}
