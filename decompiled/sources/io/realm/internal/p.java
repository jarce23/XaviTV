package io.realm.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import io.realm.RealmFieldType;
import java.util.Iterator;
import java.util.List;
import m0.q1;
import m0.x0;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements z9.b {

    /* renamed from: o, reason: collision with root package name */
    public int f6755o;

    /* renamed from: p, reason: collision with root package name */
    public int f6756p;

    /* renamed from: q, reason: collision with root package name */
    public Object f6757q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f6758r;

    /* renamed from: s, reason: collision with root package name */
    public Object f6759s;

    public p(Context context) {
        this.f6755o = -1;
        this.f6756p = -1;
        RenderScript create = RenderScript.create(context);
        this.f6757q = create;
        this.f6758r = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
    }

    public void a(String str, RealmFieldType realmFieldType, boolean z10) {
        long nativeCreatePersistedProperty = Property.nativeCreatePersistedProperty(str, _UrlKt.FRAGMENT_ENCODE_SET, Property.a(realmFieldType, z10), false, false);
        long[] jArr = (long[]) this.f6758r;
        int i10 = this.f6755o;
        jArr[i10] = nativeCreatePersistedProperty;
        this.f6755o = i10 + 1;
    }

    public OsObjectSchemaInfo b() {
        if (this.f6755o == -1 || this.f6756p == -1) {
            throw new IllegalStateException("'OsObjectSchemaInfo.build()' has been called before on this object.");
        }
        OsObjectSchemaInfo osObjectSchemaInfo = new OsObjectSchemaInfo((String) this.f6757q);
        OsObjectSchemaInfo.nativeAddProperties(osObjectSchemaInfo.f6693o, (long[]) this.f6758r, (long[]) this.f6759s);
        this.f6755o = -1;
        this.f6756p = -1;
        return osObjectSchemaInfo;
    }

    public void c(q1 q1Var, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ((((x0) it.next()).f8738a.c() & 8) != 0) {
                ((View) this.f6758r).setTranslationY(k8.a.c(r3.f8738a.b(), this.f6756p, 0));
                return;
            }
        }
    }

    @Override // z9.b
    public void destroy() {
        ((ScriptIntrinsicBlur) this.f6758r).destroy();
        ((RenderScript) this.f6757q).destroy();
        Allocation allocation = (Allocation) this.f6759s;
        if (allocation != null) {
            allocation.destroy();
        }
    }

    @Override // z9.b
    public void r() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
    }

    @Override // z9.b
    public float u() {
        return 8.0f;
    }

    @Override // z9.b
    public Bitmap y(Bitmap bitmap, float f10) {
        ScriptIntrinsicBlur scriptIntrinsicBlur = (ScriptIntrinsicBlur) this.f6758r;
        RenderScript renderScript = (RenderScript) this.f6757q;
        Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap);
        if (bitmap.getHeight() != this.f6756p || bitmap.getWidth() != this.f6755o) {
            Allocation allocation = (Allocation) this.f6759s;
            if (allocation != null) {
                allocation.destroy();
            }
            this.f6759s = Allocation.createTyped(renderScript, createFromBitmap.getType());
            this.f6755o = bitmap.getWidth();
            this.f6756p = bitmap.getHeight();
        }
        scriptIntrinsicBlur.setRadius(f10);
        scriptIntrinsicBlur.setInput(createFromBitmap);
        scriptIntrinsicBlur.forEach((Allocation) this.f6759s);
        ((Allocation) this.f6759s).copyTo(bitmap);
        createFromBitmap.destroy();
        return bitmap;
    }

    public p(String str, int i10) {
        this.f6755o = 0;
        this.f6756p = 0;
        this.f6757q = str;
        this.f6758r = new long[i10];
        this.f6759s = new long[0];
    }

    public p(View view) {
        this.f6759s = new int[2];
        this.f6758r = view;
    }
}
