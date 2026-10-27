package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.SparseArray;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final int f1262a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1263b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MediaRouteButton f1264c;

    public a(MediaRouteButton mediaRouteButton, int i10, Context context) {
        this.f1264c = mediaRouteButton;
        this.f1262a = i10;
        this.f1263b = context;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        SparseArray sparseArray = MediaRouteButton.D;
        int i10 = this.f1262a;
        if (((Drawable.ConstantState) sparseArray.get(i10)) == null) {
            return n4.a.o(this.f1263b, i10);
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public final void onCancelled(Object obj) {
        Drawable drawable = (Drawable) obj;
        if (drawable != null) {
            MediaRouteButton.D.put(this.f1262a, drawable.getConstantState());
        }
        this.f1264c.f1244u = null;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Drawable drawable = (Drawable) obj;
        int i10 = this.f1262a;
        MediaRouteButton mediaRouteButton = this.f1264c;
        if (drawable != null) {
            MediaRouteButton.D.put(i10, drawable.getConstantState());
            mediaRouteButton.f1244u = null;
        } else {
            Drawable.ConstantState constantState = (Drawable.ConstantState) MediaRouteButton.D.get(i10);
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            mediaRouteButton.f1244u = null;
        }
        mediaRouteButton.setRemoteIndicatorDrawableInternal(drawable);
    }
}
