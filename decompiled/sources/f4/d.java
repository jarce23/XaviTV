package f4;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.CompoundButton;
import android.widget.TextView;
import m.q;
import o.f;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5017a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5018b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5019c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f5020d;

    /* renamed from: e, reason: collision with root package name */
    public Parcelable f5021e;

    /* renamed from: f, reason: collision with root package name */
    public Object f5022f;

    public /* synthetic */ d(TextView textView) {
        this.f5021e = null;
        this.f5022f = null;
        this.f5017a = false;
        this.f5018b = false;
        this.f5020d = textView;
    }

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f5020d;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.f5017a || this.f5018b) {
                Drawable mutate = buttonDrawable.mutate();
                if (this.f5017a) {
                    mutate.setTintList((ColorStateList) this.f5021e);
                }
                if (this.f5018b) {
                    mutate.setTintMode((PorterDuff.Mode) this.f5022f);
                }
                if (mutate.isStateful()) {
                    mutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(mutate);
            }
        }
    }

    public void b() {
        q qVar = (q) this.f5020d;
        Drawable checkMarkDrawable = qVar.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f5017a || this.f5018b) {
                Drawable mutate = checkMarkDrawable.mutate();
                if (this.f5017a) {
                    mutate.setTintList((ColorStateList) this.f5021e);
                }
                if (this.f5018b) {
                    mutate.setTintMode((PorterDuff.Mode) this.f5022f);
                }
                if (mutate.isStateful()) {
                    mutate.setState(qVar.getDrawableState());
                }
                qVar.setCheckMarkDrawable(mutate);
            }
        }
    }

    public Bundle c(String str) {
        if (!this.f5018b) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = (Bundle) this.f5021e;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = (Bundle) this.f5021e;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = (Bundle) this.f5021e;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f5021e = null;
        return bundle2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005c A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:3:0x0022, B:5:0x0029, B:8:0x002f, B:9:0x0055, B:11:0x005c, B:12:0x0063, B:14:0x006a, B:21:0x003e, B:23:0x0044, B:25:0x004a), top: B:2:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #1 {all -> 0x003b, blocks: (B:3:0x0022, B:5:0x0029, B:8:0x002f, B:9:0x0055, B:11:0x005c, B:12:0x0063, B:14:0x006a, B:21:0x003e, B:23:0x0044, B:25:0x004a), top: B:2:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f5020d
            r1 = r0
            android.widget.CompoundButton r1 = (android.widget.CompoundButton) r1
            android.content.Context r0 = r1.getContext()
            int[] r3 = e.a.f4369m
            android.support.v4.media.session.a0 r7 = android.support.v4.media.session.a0.T(r0, r9, r3, r10)
            java.lang.Object r0 = r7.f231q
            android.content.res.TypedArray r0 = (android.content.res.TypedArray) r0
            android.content.Context r2 = r1.getContext()
            java.lang.Object r4 = r7.f231q
            r5 = r4
            android.content.res.TypedArray r5 = (android.content.res.TypedArray) r5
            r4 = r9
            r6 = r10
            m0.k0.l(r1, r2, r3, r4, r5, r6)
            r9 = 1
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            r2 = 0
            if (r10 == 0) goto L3e
            int r9 = r0.getResourceId(r9, r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L3e
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            android.graphics.drawable.Drawable r9 = n4.a.o(r10, r9)     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L3b android.content.res.Resources.NotFoundException -> L3e
            goto L55
        L3b:
            r0 = move-exception
            r9 = r0
            goto L7b
        L3e:
            boolean r9 = r0.hasValue(r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L55
            int r9 = r0.getResourceId(r2, r2)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L55
            android.content.Context r10 = r1.getContext()     // Catch: java.lang.Throwable -> L3b
            android.graphics.drawable.Drawable r9 = n4.a.o(r10, r9)     // Catch: java.lang.Throwable -> L3b
            r1.setButtonDrawable(r9)     // Catch: java.lang.Throwable -> L3b
        L55:
            r9 = 2
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L63
            android.content.res.ColorStateList r9 = r7.J(r9)     // Catch: java.lang.Throwable -> L3b
            r1.setButtonTintList(r9)     // Catch: java.lang.Throwable -> L3b
        L63:
            r9 = 3
            boolean r10 = r0.hasValue(r9)     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L77
            r10 = -1
            int r9 = r0.getInt(r9, r10)     // Catch: java.lang.Throwable -> L3b
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = m.i1.c(r9, r10)     // Catch: java.lang.Throwable -> L3b
            r1.setButtonTintMode(r9)     // Catch: java.lang.Throwable -> L3b
        L77:
            r7.U()
            return
        L7b:
            r7.U()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: f4.d.d(android.util.AttributeSet, int):void");
    }

    public void e(String str, c cVar) {
        Object obj;
        f fVar = (f) this.f5020d;
        o.c f10 = fVar.f(str);
        if (f10 != null) {
            obj = f10.f9359p;
        } else {
            o.c cVar2 = new o.c(str, cVar);
            fVar.f9368r++;
            o.c cVar3 = fVar.f9366p;
            if (cVar3 == null) {
                fVar.f9365o = cVar2;
                fVar.f9366p = cVar2;
            } else {
                cVar3.f9360q = cVar2;
                cVar2.f9361r = cVar3;
                fVar.f9366p = cVar2;
            }
            obj = null;
        }
        if (((c) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public d() {
        this.f5020d = new f();
        this.f5019c = true;
    }
}
