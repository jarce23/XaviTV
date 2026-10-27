package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b4.n1;
import j9.w1;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w0 implements e3.c {

    /* renamed from: o, reason: collision with root package name */
    public int f1087o;

    /* renamed from: p, reason: collision with root package name */
    public int f1088p;

    /* renamed from: q, reason: collision with root package name */
    public Object f1089q = new ArrayList();

    public w0(Context context, XmlResourceParser xmlResourceParser) {
        this.f1088p = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), x.p.f13323h);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == 0) {
                this.f1087o = obtainStyledAttributes.getResourceId(index, this.f1087o);
            } else if (index == 1) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f1088p);
                this.f1088p = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new x.m().c((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Override // e3.c
    public int a() {
        return this.f1087o;
    }

    @Override // e3.c
    public int b() {
        return this.f1088p;
    }

    @Override // e3.c
    public int c() {
        int i10 = this.f1087o;
        return i10 == -1 ? ((l1.t) this.f1089q).A() : i10;
    }

    public void d() {
        int i10;
        int i11 = this.f1087o;
        if (i11 != 2) {
            if (i11 != 3 && i11 != 1) {
                this.f1089q = null;
                return;
            }
            n1 n1Var = (n1) this.f1089q;
            if (n1Var == null || n1Var.j() != Integer.MAX_VALUE) {
                this.f1089q = new n1(Integer.MAX_VALUE);
                return;
            }
            return;
        }
        if (this.f1088p <= 0) {
            throw new IllegalArgumentException();
        }
        n1 n1Var2 = (n1) this.f1089q;
        if (n1Var2 != null) {
            synchronized (((w1) n1Var2.g)) {
                i10 = n1Var2.f2351b;
            }
            if (i10 == this.f1088p) {
                return;
            }
        }
        this.f1089q = new n1(this.f1088p);
    }
}
