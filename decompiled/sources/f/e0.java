package f;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final View f4774o;

    /* renamed from: p, reason: collision with root package name */
    public final String f4775p;

    /* renamed from: q, reason: collision with root package name */
    public Method f4776q;

    /* renamed from: r, reason: collision with root package name */
    public Context f4777r;

    public e0(View view, String str) {
        this.f4774o = view;
        this.f4775p = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f4776q == null) {
            View view2 = this.f4774o;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f4775p;
                if (context == null) {
                    int id = view2.getId();
                    if (id == -1) {
                        str = _UrlKt.FRAGMENT_ENCODE_SET;
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    StringBuilder s10 = android.support.v4.media.d.s("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                    s10.append(view2.getClass());
                    s10.append(str);
                    throw new IllegalStateException(s10.toString());
                }
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.f4776q = method;
                        this.f4777r = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            this.f4776q.invoke(this.f4777r, view);
        } catch (IllegalAccessException e7) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e7);
        } catch (InvocationTargetException e8) {
            throw new IllegalStateException("Could not execute method for android:onClick", e8);
        }
    }
}
