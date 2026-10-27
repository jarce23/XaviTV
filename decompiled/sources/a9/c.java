package a9;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends com.bumptech.glide.e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f156c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextPaint f157d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.bumptech.glide.e f158e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f159f;

    public c(d dVar, Context context, TextPaint textPaint, com.bumptech.glide.e eVar) {
        this.f159f = dVar;
        this.f156c = context;
        this.f157d = textPaint;
        this.f158e = eVar;
    }

    @Override // com.bumptech.glide.e
    public final void r(int i10) {
        this.f158e.r(i10);
    }

    @Override // com.bumptech.glide.e
    public final void s(Typeface typeface, boolean z10) {
        this.f159f.f(this.f156c, this.f157d, typeface);
        this.f158e.s(typeface, z10);
    }
}
