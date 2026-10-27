package l4;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.HashMap;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends m {
    public static final String[] P = {"android:visibility:visibility", "android:visibility:parent"};
    public final int O;

    public g(int i10) {
        this();
        this.O = i10;
    }

    public static void H(u uVar) {
        View view = uVar.f8258b;
        int visibility = view.getVisibility();
        HashMap hashMap = uVar.f8257a;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    public static float J(u uVar, float f10) {
        Float f11;
        return (uVar == null || (f11 = (Float) uVar.f8257a.get("android:fade:transitionAlpha")) == null) ? f10 : f11.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static l4.f0 K(l4.u r8, l4.u r9) {
        /*
            l4.f0 r0 = new l4.f0
            r0.<init>()
            r1 = 0
            r0.f8218c = r1
            r0.f8219d = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f8257a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f8216a = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f8220e = r6
            goto L33
        L2f:
            r0.f8216a = r3
            r0.f8220e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f8257a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f8217b = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f8221f = r2
            goto L56
        L52:
            r0.f8217b = r3
            r0.f8221f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L92
            if (r9 == 0) goto L92
            int r8 = r0.f8216a
            int r9 = r0.f8217b
            if (r8 != r9) goto L6c
            java.lang.Object r3 = r0.f8220e
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            java.lang.Object r4 = r0.f8221f
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            if (r3 != r4) goto L6c
            goto La7
        L6c:
            if (r8 == r9) goto L7c
            if (r8 != 0) goto L75
            r0.f8219d = r1
            r0.f8218c = r2
            return r0
        L75:
            if (r9 != 0) goto La7
            r0.f8219d = r2
            r0.f8218c = r2
            return r0
        L7c:
            java.lang.Object r8 = r0.f8221f
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            if (r8 != 0) goto L87
            r0.f8219d = r1
            r0.f8218c = r2
            return r0
        L87:
            java.lang.Object r8 = r0.f8220e
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            if (r8 != 0) goto La7
            r0.f8219d = r2
            r0.f8218c = r2
            return r0
        L92:
            if (r8 != 0) goto L9d
            int r8 = r0.f8217b
            if (r8 != 0) goto L9d
            r0.f8219d = r2
            r0.f8218c = r2
            return r0
        L9d:
            if (r9 != 0) goto La7
            int r8 = r0.f8216a
            if (r8 != 0) goto La7
            r0.f8219d = r1
            r0.f8218c = r2
        La7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.g.K(l4.u, l4.u):l4.f0");
    }

    public final ObjectAnimator I(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        w.f8260a.F(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, w.f8261b, f11);
        f fVar = new f(view);
        ofFloat.addListener(fVar);
        n().a(fVar);
        return ofFloat;
    }

    @Override // l4.m
    public final void c(u uVar) {
        H(uVar);
    }

    @Override // l4.m
    public final void f(u uVar) {
        H(uVar);
        View view = uVar.f8258b;
        Float f10 = (Float) view.getTag(R.id.transition_pause_alpha);
        if (f10 == null) {
            f10 = view.getVisibility() == 0 ? Float.valueOf(w.f8260a.w(view)) : Float.valueOf(0.0f);
        }
        uVar.f8257a.put("android:fade:transitionAlpha", f10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
    
        if (K(m(r3, false), q(r3, false)).f8218c != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e4  */
    @Override // l4.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator j(android.view.ViewGroup r24, l4.u r25, l4.u r26) {
        /*
            Method dump skipped, instructions count: 732
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.g.j(android.view.ViewGroup, l4.u, l4.u):android.animation.Animator");
    }

    @Override // l4.m
    public final String[] p() {
        return P;
    }

    @Override // l4.m
    public final boolean r(u uVar, u uVar2) {
        if (uVar == null && uVar2 == null) {
            return false;
        }
        if (uVar != null && uVar2 != null && uVar2.f8257a.containsKey("android:visibility:visibility") != uVar.f8257a.containsKey("android:visibility:visibility")) {
            return false;
        }
        f0 K = K(uVar, uVar2);
        if (K.f8218c) {
            return K.f8216a == 0 || K.f8217b == 0;
        }
        return false;
    }

    public g() {
        this.O = 3;
    }
}
