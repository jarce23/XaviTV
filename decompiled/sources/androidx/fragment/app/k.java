package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.WeakHashMap;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f718a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f719b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f720c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f721d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f722e;

    public k(ViewGroup viewGroup) {
        za.h.e("container", viewGroup);
        this.f718a = viewGroup;
        this.f719b = new ArrayList();
        this.f720c = new ArrayList();
    }

    public static final k f(ViewGroup viewGroup, i0 i0Var) {
        za.h.e("container", viewGroup);
        za.h.e("fragmentManager", i0Var);
        za.h.d("fragmentManager.specialEffectsControllerFactory", i0Var.D());
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof k) {
            return (k) tag;
        }
        k kVar = new k(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, kVar);
        return kVar;
    }

    public final void a(int i10, int i11, p0 p0Var) {
        synchronized (this.f719b) {
            i0.b bVar = new i0.b();
            s sVar = p0Var.f772c;
            za.h.d("fragmentStateManager.fragment", sVar);
            u0 d6 = d(sVar);
            if (d6 != null) {
                d6.c(i10, i11);
                return;
            }
            final u0 u0Var = new u0(i10, i11, p0Var, bVar);
            this.f719b.add(u0Var);
            final int i12 = 0;
            u0Var.f833d.add(new Runnable(this) { // from class: androidx.fragment.app.t0

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ k f823p;

                {
                    this.f823p = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i12) {
                        case 0:
                            ArrayList arrayList = this.f823p.f719b;
                            u0 u0Var2 = u0Var;
                            if (arrayList.contains(u0Var2)) {
                                int i13 = u0Var2.f830a;
                                View view = u0Var2.f832c.S;
                                za.h.d("operation.fragment.mView", view);
                                android.support.v4.media.d.b(view, i13);
                                break;
                            }
                            break;
                        default:
                            k kVar = this.f823p;
                            ArrayList arrayList2 = kVar.f719b;
                            u0 u0Var3 = u0Var;
                            arrayList2.remove(u0Var3);
                            kVar.f720c.remove(u0Var3);
                            break;
                    }
                }
            });
            final int i13 = 1;
            u0Var.f833d.add(new Runnable(this) { // from class: androidx.fragment.app.t0

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ k f823p;

                {
                    this.f823p = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i13) {
                        case 0:
                            ArrayList arrayList = this.f823p.f719b;
                            u0 u0Var2 = u0Var;
                            if (arrayList.contains(u0Var2)) {
                                int i132 = u0Var2.f830a;
                                View view = u0Var2.f832c.S;
                                za.h.d("operation.fragment.mView", view);
                                android.support.v4.media.d.b(view, i132);
                                break;
                            }
                            break;
                        default:
                            k kVar = this.f823p;
                            ArrayList arrayList2 = kVar.f719b;
                            u0 u0Var3 = u0Var;
                            arrayList2.remove(u0Var3);
                            kVar.f720c.remove(u0Var3);
                            break;
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x027c, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x027f, code lost:
    
        if (r3 == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0281, code lost:
    
        r11.remove(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0284, code lost:
    
        r2 = r1.S;
        r14.startViewTransition(r2);
        r26 = r6;
        r23 = r10;
        r1.addListener(new androidx.fragment.app.i(r25, r2, r3, r0, r4));
        r1.setTarget(r2);
        r1.start();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02b0, code lost:
    
        if (androidx.fragment.app.i0.F(2) == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02b2, code lost:
    
        android.util.Log.v("FragmentManager", "Animator from operation " + r0 + " has started.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02c6, code lost:
    
        ((i0.b) r4.f681b).a(new a7.g(r1, 1, r0));
        r6 = r26;
        r2 = r19;
        r4 = r20;
        r0 = r26;
        r10 = r23;
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x027e, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0251, code lost:
    
        if (androidx.fragment.app.i0.F(2) == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0253, code lost:
    
        android.util.Log.v("FragmentManager", "Ignoring Animator set on " + r1 + " as this Fragment was involved in a Transition.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0269, code lost:
    
        r4.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x026c, code lost:
    
        r0 = r26;
        r2 = r19;
        r4 = r20;
        r3 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x022d, code lost:
    
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0213, code lost:
    
        r26 = r0;
        r19 = r2;
        r21 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0223, code lost:
    
        r4.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0210, code lost:
    
        r4.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02e1, code lost:
    
        r22 = r0;
        r21 = r3;
        r2 = r22.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02ed, code lost:
    
        if (r3 >= r2) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02ef, code lost:
    
        r4 = r22;
        r5 = r4.get(r3);
        r3 = r3 + 1;
        r5 = (androidx.fragment.app.f) r5;
        r6 = (androidx.fragment.app.u0) r5.f680a;
        r26 = r2;
        r2 = r6.f832c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0305, code lost:
    
        if (r12 == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x032d, code lost:
    
        if (r21 == false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x034f, code lost:
    
        r2 = r2.S;
        za.h.d(r1, r15);
        r3 = r5.k(r15);
        r19 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x035c, code lost:
    
        if (r3 == null) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x035e, code lost:
    
        r3 = (android.view.animation.Animation) r3.f7114o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0362, code lost:
    
        if (r3 == null) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0364, code lost:
    
        r22 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0369, code lost:
    
        if (r6.f830a == 1) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x036b, code lost:
    
        r2.startAnimation(r3);
        r5.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x03a1, code lost:
    
        ((i0.b) r5.f681b).a(new androidx.fragment.app.e(r2, r25, r5, r6));
        r2 = r26;
        r3 = r3;
        r1 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0372, code lost:
    
        r14.startViewTransition(r2);
        r1 = new androidx.fragment.app.v(r3, r14, r2);
        r1.setAnimationListener(new androidx.fragment.app.j(r6, r25, r2, r5));
        r2.startAnimation(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x038b, code lost:
    
        if (androidx.fragment.app.i0.F(2) == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x038d, code lost:
    
        android.util.Log.v("FragmentManager", "Animation from operation " + r6 + " has started.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x03ba, code lost:
    
        throw new java.lang.IllegalStateException("Required value was null.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03c0, code lost:
    
        throw new java.lang.IllegalStateException("Required value was null.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0335, code lost:
    
        if (androidx.fragment.app.i0.F(2) == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0337, code lost:
    
        android.util.Log.v("FragmentManager", "Ignoring Animation set on " + r2 + " as Animations cannot run alongside Animators.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x034b, code lost:
    
        r5.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0326, code lost:
    
        r2 = r26;
        r3 = r3;
        r22 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        r13 = (androidx.fragment.app.u0) r13;
        r3 = r0.listIterator(r0.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x030d, code lost:
    
        if (androidx.fragment.app.i0.F(2) == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x030f, code lost:
    
        android.util.Log.v("FragmentManager", "Ignoring Animation set on " + r2 + " as Animations cannot run alongside Transitions.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0323, code lost:
    
        r5.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03c1, code lost:
    
        r1 = r11.size();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03c6, code lost:
    
        if (r6 >= r1) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03c8, code lost:
    
        r2 = r11.get(r6);
        r6 = r6 + 1;
        r2 = (androidx.fragment.app.u0) r2;
        r3 = r2.f832c.S;
        r2 = r2.f830a;
        za.h.d("view", r3);
        android.support.v4.media.d.b(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03df, code lost:
    
        r11.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03e8, code lost:
    
        if (androidx.fragment.app.i0.F(2) == false) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x03ea, code lost:
    
        android.util.Log.v("FragmentManager", "Completed executing operations from " + r13 + " to " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0401, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x007e, code lost:
    
        r15 = r15.getVisibility();
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0082, code lost:
    
        if (r15 == 0) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0084, code lost:
    
        if (r15 == 4) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0086, code lost:
    
        if (r15 != 8) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        if (r3.hasPrevious() == false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0092, code lost:
    
        throw new java.lang.IllegalArgumentException(android.support.v4.media.d.m(r15, "Unknown visibility "));
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        r4 = r3.previous();
        r14 = (androidx.fragment.app.u0) r4;
        r15 = r14.f832c.S;
        za.h.d("operation.fragment.mView", r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
    
        if (r15.getAlpha() != 0.0f) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        if (r15.getVisibility() != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0095, code lost:
    
        if (r14.f830a != 2) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0097, code lost:
    
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0098, code lost:
    
        r7 = (androidx.fragment.app.u0) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a3, code lost:
    
        if (androidx.fragment.app.i0.F(2) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a5, code lost:
    
        android.util.Log.v("FragmentManager", "Executing operations from " + r13 + " to " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bc, code lost:
    
        r10 = new java.util.ArrayList();
        r3 = new java.util.ArrayList();
        r11 = ma.j.K(r0);
        r4 = ((androidx.fragment.app.u0) ma.j.G(r0)).f832c;
        r5 = r0.size();
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d7, code lost:
    
        if (r14 >= r5) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d9, code lost:
    
        r15 = r0.get(r14);
        r14 = r14 + 1;
        r15 = ((androidx.fragment.app.u0) r15).f832c.V;
        r6 = r4.V;
        r15.f785b = r6.f785b;
        r15.f786c = r6.f786c;
        r15.f787d = r6.f787d;
        r15.f788e = r6.f788e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f9, code lost:
    
        r4 = r0.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fe, code lost:
    
        if (r5 >= r4) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0100, code lost:
    
        r12 = r0.get(r5);
        r5 = r5 + 1;
        r12 = (androidx.fragment.app.u0) r12;
        r14 = new i0.b();
        r12.d();
        r15 = r12.f834e;
        r15.add(r14);
        r10.add(new androidx.fragment.app.f(r12, r14, r27));
        r6 = new i0.b();
        r12.d();
        r15.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x012a, code lost:
    
        if (r27 == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x012c, code lost:
    
        if (r12 != r13) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x012e, code lost:
    
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0137, code lost:
    
        r15 = r12.f832c;
        r14 = new androidx.fragment.app.h(r12, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x013f, code lost:
    
        if (r12.f830a != 2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0141, code lost:
    
        if (r27 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0143, code lost:
    
        r0 = r15.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0155, code lost:
    
        if (r12.f830a != 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0157, code lost:
    
        if (r27 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0159, code lost:
    
        r0 = r15.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x015c, code lost:
    
        r0 = r15.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x015e, code lost:
    
        if (r18 == false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0160, code lost:
    
        if (r27 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0162, code lost:
    
        r0 = r15.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0168, code lost:
    
        r3.add(r14);
        r12.f833d.add(new androidx.fragment.app.d(r11, r12, r25));
        r0 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0165, code lost:
    
        r15.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0146, code lost:
    
        r15.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x014a, code lost:
    
        if (r27 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014c, code lost:
    
        r0 = r15.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x014f, code lost:
    
        r15.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0131, code lost:
    
        r18 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0134, code lost:
    
        if (r12 != r7) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0178, code lost:
    
        r6 = new java.util.LinkedHashMap();
        r0 = new java.util.ArrayList();
        r2 = r3.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0187, code lost:
    
        if (r4 >= r2) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0189, code lost:
    
        r5 = r3.get(r4);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0196, code lost:
    
        if (((androidx.fragment.app.h) r5).h() != false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0198, code lost:
    
        r0.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019c, code lost:
    
        r2 = new java.util.ArrayList();
        r4 = r0.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a6, code lost:
    
        if (r5 >= r4) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a8, code lost:
    
        r12 = r0.get(r5);
        r5 = r5 + 1;
        ((androidx.fragment.app.h) r12).getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01b4, code lost:
    
        r0 = r2.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01b9, code lost:
    
        if (r4 >= r0) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01bb, code lost:
    
        r5 = r2.get(r4);
        r4 = r4 + 1;
        ((androidx.fragment.app.h) r5).getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01c7, code lost:
    
        r0 = r3.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01cc, code lost:
    
        if (r2 >= r0) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01ce, code lost:
    
        r4 = r3.get(r2);
        r2 = r2 + 1;
        r4 = (androidx.fragment.app.h) r4;
        r6.put((androidx.fragment.app.u0) r4.f680a, java.lang.Boolean.FALSE);
        r4.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01e3, code lost:
    
        r12 = r6.containsValue(java.lang.Boolean.TRUE);
        r14 = r25.f718a;
        r15 = r14.getContext();
        r0 = new java.util.ArrayList();
        r2 = r10.size();
        r3 = false;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01fa, code lost:
    
        r1 = "context";
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01fe, code lost:
    
        if (r4 >= r2) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0200, code lost:
    
        r20 = r4 + 1;
        r4 = (androidx.fragment.app.f) r10.get(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x020e, code lost:
    
        if (r4.h() == false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x021a, code lost:
    
        za.h.d("context", r15);
        r1 = r4.k(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0221, code lost:
    
        if (r1 != null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0227, code lost:
    
        r1 = (android.animation.Animator) r1.f7115p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x022b, code lost:
    
        if (r1 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0231, code lost:
    
        r26 = r0;
        r0 = (androidx.fragment.app.u0) r4.f680a;
        r1 = r0.f832c;
        r19 = r2;
        r21 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0249, code lost:
    
        if (za.h.a(r6.get(r0), java.lang.Boolean.TRUE) == false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x027a, code lost:
    
        if (r0.f830a != 3) goto L109;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.ArrayList r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.k.b(java.util.ArrayList, boolean):void");
    }

    public final void c() {
        if (this.f722e) {
            return;
        }
        ViewGroup viewGroup = this.f718a;
        WeakHashMap weakHashMap = m0.k0.f8683a;
        if (!viewGroup.isAttachedToWindow()) {
            e();
            this.f721d = false;
            return;
        }
        synchronized (this.f719b) {
            try {
                if (!this.f719b.isEmpty()) {
                    ArrayList K = ma.j.K(this.f720c);
                    this.f720c.clear();
                    int size = K.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = K.get(i10);
                        i10++;
                        u0 u0Var = (u0) obj;
                        if (i0.F(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + u0Var);
                        }
                        u0Var.a();
                        if (!u0Var.g) {
                            this.f720c.add(u0Var);
                        }
                    }
                    g();
                    ArrayList K2 = ma.j.K(this.f719b);
                    this.f719b.clear();
                    this.f720c.addAll(K2);
                    if (i0.F(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    int size2 = K2.size();
                    int i11 = 0;
                    while (i11 < size2) {
                        Object obj2 = K2.get(i11);
                        i11++;
                        ((u0) obj2).d();
                    }
                    b(K2, this.f721d);
                    this.f721d = false;
                    if (i0.F(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final u0 d(s sVar) {
        Object obj;
        ArrayList arrayList = this.f719b;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i10);
            i10++;
            u0 u0Var = (u0) obj;
            if (za.h.a(u0Var.f832c, sVar) && !u0Var.f835f) {
                break;
            }
        }
        return (u0) obj;
    }

    public final void e() {
        String str;
        String str2;
        if (i0.F(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        ViewGroup viewGroup = this.f718a;
        WeakHashMap weakHashMap = m0.k0.f8683a;
        boolean isAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.f719b) {
            try {
                g();
                ArrayList arrayList = this.f719b;
                int size = arrayList.size();
                int i10 = 0;
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList.get(i11);
                    i11++;
                    ((u0) obj).d();
                }
                ArrayList K = ma.j.K(this.f720c);
                int size2 = K.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj2 = K.get(i12);
                    i12++;
                    u0 u0Var = (u0) obj2;
                    if (i0.F(2)) {
                        if (isAttachedToWindow) {
                            str2 = _UrlKt.FRAGMENT_ENCODE_SET;
                        } else {
                            str2 = "Container " + this.f718a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str2 + "Cancelling running operation " + u0Var);
                    }
                    u0Var.a();
                }
                ArrayList K2 = ma.j.K(this.f719b);
                int size3 = K2.size();
                while (i10 < size3) {
                    Object obj3 = K2.get(i10);
                    i10++;
                    u0 u0Var2 = (u0) obj3;
                    if (i0.F(2)) {
                        if (isAttachedToWindow) {
                            str = _UrlKt.FRAGMENT_ENCODE_SET;
                        } else {
                            str = "Container " + this.f718a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str + "Cancelling pending operation " + u0Var2);
                    }
                    u0Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.f719b;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            u0 u0Var = (u0) obj;
            int i11 = 2;
            if (u0Var.f831b == 2) {
                int visibility = u0Var.f832c.F().getVisibility();
                if (visibility != 0) {
                    i11 = 4;
                    if (visibility != 4) {
                        if (visibility != 8) {
                            throw new IllegalArgumentException(android.support.v4.media.d.m(visibility, "Unknown visibility "));
                        }
                        i11 = 3;
                    }
                }
                u0Var.c(i11, 1);
            }
        }
    }
}
