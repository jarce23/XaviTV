package w3;

import android.content.ComponentName;
import android.content.Context;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12967a;

    /* renamed from: b, reason: collision with root package name */
    public final p4.p f12968b;

    /* renamed from: c, reason: collision with root package name */
    public final android.support.v4.media.session.q f12969c = new android.support.v4.media.session.q(5, this);

    /* renamed from: d, reason: collision with root package name */
    public s f12970d;

    /* renamed from: e, reason: collision with root package name */
    public j f12971e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12972f;
    public ea.a g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12973h;

    public n(Context context, p4.p pVar) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        this.f12967a = context;
        if (pVar != null) {
            this.f12968b = pVar;
        } else {
            this.f12968b = new p4.p(26, new ComponentName(context, getClass()));
        }
    }

    public l c(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    public abstract m d(String str);

    public m e(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        }
        if (str2 != null) {
            return d(str);
        }
        throw new IllegalArgumentException("routeGroupId cannot be null");
    }

    public abstract void f(j jVar);

    public final void g(ea.a aVar) {
        b0.b();
        if (this.g != aVar) {
            this.g = aVar;
            if (this.f12973h) {
                return;
            }
            this.f12973h = true;
            this.f12969c.sendEmptyMessage(1);
        }
    }

    public final void h(j jVar) {
        b0.b();
        if (Objects.equals(this.f12971e, jVar)) {
            return;
        }
        this.f12971e = jVar;
        if (this.f12972f) {
            return;
        }
        this.f12972f = true;
        this.f12969c.sendEmptyMessage(2);
    }
}
