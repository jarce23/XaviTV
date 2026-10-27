package u3;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends View implements e0 {

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f12344o;

    /* renamed from: p, reason: collision with root package name */
    public List f12345p;

    /* renamed from: q, reason: collision with root package name */
    public int f12346q;

    /* renamed from: r, reason: collision with root package name */
    public float f12347r;

    /* renamed from: s, reason: collision with root package name */
    public c f12348s;

    /* renamed from: t, reason: collision with root package name */
    public float f12349t;

    public b(Context context, int i10) {
        super(context, null);
        this.f12344o = new ArrayList();
        this.f12345p = Collections.EMPTY_LIST;
        this.f12346q = 0;
        this.f12347r = 0.0533f;
        this.f12348s = c.g;
        this.f12349t = 0.08f;
    }

    @Override // u3.e0
    public final void a(List list, c cVar, float f10, int i10, float f11) {
        this.f12345p = list;
        this.f12348s = cVar;
        this.f12347r = f10;
        this.f12346q = i10;
        this.f12349t = f11;
        while (true) {
            ArrayList arrayList = this.f12344o;
            if (arrayList.size() >= list.size()) {
                invalidate();
                return;
            }
            arrayList.add(new d0(getContext()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0468  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchDraw(android.graphics.Canvas r37) {
        /*
            Method dump skipped, instructions count: 1174
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.b.dispatchDraw(android.graphics.Canvas):void");
    }
}
