package x5;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements com.bumptech.glide.load.data.d {

    /* renamed from: o, reason: collision with root package name */
    public final Resources.Theme f13637o;

    /* renamed from: p, reason: collision with root package name */
    public final Resources f13638p;

    /* renamed from: q, reason: collision with root package name */
    public final g f13639q;

    /* renamed from: r, reason: collision with root package name */
    public final int f13640r;

    /* renamed from: s, reason: collision with root package name */
    public Object f13641s;

    public h(Resources.Theme theme, Resources resources, g gVar, int i10) {
        this.f13637o = theme;
        this.f13638p = resources;
        this.f13639q = gVar;
        this.f13640r = i10;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f13639q.f13633a) {
            case 0:
                return AssetFileDescriptor.class;
            case 1:
                return Drawable.class;
            default:
                return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        Object obj = this.f13641s;
        if (obj != null) {
            try {
                switch (this.f13639q.f13633a) {
                    case 0:
                        ((AssetFileDescriptor) obj).close();
                        break;
                    case 1:
                        break;
                    default:
                        ((InputStream) obj).close();
                        break;
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int c() {
        return 1;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(com.bumptech.glide.i iVar, com.bumptech.glide.load.data.c cVar) {
        Object openRawResourceFd;
        try {
            g gVar = this.f13639q;
            Resources.Theme theme = this.f13637o;
            Resources resources = this.f13638p;
            int i10 = this.f13640r;
            switch (gVar.f13633a) {
                case 0:
                    openRawResourceFd = resources.openRawResourceFd(i10);
                    break;
                case 1:
                    Context context = gVar.f13634b;
                    openRawResourceFd = a.a.l(context, context, i10, theme);
                    break;
                default:
                    openRawResourceFd = resources.openRawResource(i10);
                    break;
            }
            this.f13641s = openRawResourceFd;
            cVar.p(openRawResourceFd);
        } catch (Resources.NotFoundException e7) {
            cVar.l(e7);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
    }
}
