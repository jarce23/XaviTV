package j9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Surface;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import m.h2;
import m.n2;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g1 implements k9.f {

    /* renamed from: o, reason: collision with root package name */
    public Object f7290o;

    /* renamed from: p, reason: collision with root package name */
    public Object f7291p;

    /* renamed from: q, reason: collision with root package name */
    public Object f7292q;

    /* renamed from: r, reason: collision with root package name */
    public Object f7293r;

    /* renamed from: s, reason: collision with root package name */
    public Object f7294s;

    /* renamed from: t, reason: collision with root package name */
    public Object f7295t;

    public g1(Set set, String str, String str2) {
        Set unmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f7290o = unmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.f7292q = str;
        this.f7293r = str2;
        this.f7294s = g8.a.f5323b;
        HashSet hashSet = new HashSet(unmodifiableSet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.d.l(it);
        }
        this.f7291p = Collections.unmodifiableSet(hashSet);
    }

    public static p1.o a(DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < readInt; i10++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 < 0) {
                throw new IOException(android.support.v4.media.d.m(readInt2, "Invalid value size: "));
            }
            int min = Math.min(readInt2, 10485760);
            byte[] bArr = l1.a0.f8069c;
            int i11 = 0;
            while (i11 != readInt2) {
                int i12 = i11 + min;
                bArr = Arrays.copyOf(bArr, i12);
                dataInputStream.readFully(bArr, i11, min);
                min = Math.min(readInt2 - i12, 10485760);
                i11 = i12;
            }
            hashMap.put(readUTF, bArr);
        }
        return new p1.o(hashMap);
    }

    public static void b(p1.o oVar, DataOutputStream dataOutputStream) {
        Set<Map.Entry> entrySet = oVar.f9861b.entrySet();
        dataOutputStream.writeInt(entrySet.size());
        for (Map.Entry entry : entrySet) {
            dataOutputStream.writeUTF((String) entry.getKey());
            byte[] bArr = (byte[]) entry.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public static boolean f(int[] iArr, int i10) {
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList h(Context context, int i10) {
        int c10 = n2.c(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{n2.f8491b, n2.f8493d, n2.f8492c, n2.f8495f}, new int[]{n2.b(context, R.attr.colorButtonNormal), e0.a.f(c10, i10), e0.a.f(c10, i10), i10});
    }

    public static c2.d0 i(i1.o0 o0Var, o9.g0 g0Var, c2.d0 d0Var, i1.r0 r0Var) {
        int b2;
        s1.a0 a0Var = (s1.a0) o0Var;
        i1.t0 A = a0Var.A();
        a0Var.f0();
        if (a0Var.f11203l0.f11493a.p()) {
            b2 = 0;
        } else {
            s1.y0 y0Var = a0Var.f11203l0;
            b2 = y0Var.f11493a.b(y0Var.f11494b.f2539a);
        }
        Object l10 = A.p() ? null : A.l(b2);
        int b10 = (a0Var.I() || A.p()) ? -1 : A.f(b2, r0Var, false).b(l1.a0.O(a0Var.y()) - r0Var.f6016e);
        for (int i10 = 0; i10 < g0Var.size(); i10++) {
            c2.d0 d0Var2 = (c2.d0) g0Var.get(i10);
            if (o(d0Var2, l10, a0Var.I(), a0Var.v(), a0Var.w(), b10)) {
                return d0Var2;
            }
        }
        if (g0Var.isEmpty() && d0Var != null && o(d0Var, l10, a0Var.I(), a0Var.v(), a0Var.w(), b10)) {
            return d0Var;
        }
        return null;
    }

    public static LayerDrawable l(h2 h2Var, Context context, int i10) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
        Drawable f10 = h2Var.f(context, R.drawable.abc_star_black_48dp);
        Drawable f11 = h2Var.f(context, R.drawable.abc_star_half_black_48dp);
        if ((f10 instanceof BitmapDrawable) && f10.getIntrinsicWidth() == dimensionPixelSize && f10.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) f10;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            f10.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            f10.draw(canvas);
            bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable2 = new BitmapDrawable(createBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((f11 instanceof BitmapDrawable) && f11.getIntrinsicWidth() == dimensionPixelSize && f11.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) f11;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            f11.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            f11.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static boolean o(c2.d0 d0Var, Object obj, boolean z10, int i10, int i11, int i12) {
        Object obj2 = d0Var.f2539a;
        int i13 = d0Var.f2540b;
        if (!obj2.equals(obj)) {
            return false;
        }
        if (z10 && i13 == i10 && d0Var.f2541c == i11) {
            return true;
        }
        return !z10 && i13 == -1 && d0Var.f2543e == i12;
    }

    public static void q(Drawable drawable, int i10, PorterDuff.Mode mode) {
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = m.r.f8527b;
        }
        mutate.setColorFilter(m.r.c(i10, mode));
    }

    @Override // k9.f
    public Object c() {
        Object c10 = ((k9.e) this.f7290o).c();
        k9.e eVar = new k9.e(new h5.i(12, (d1) this.f7295t));
        Object c11 = ((k9.e) this.f7291p).c();
        return new f1((p) c10, eVar, (u0) c11, new k9.e(new h5.i(12, (k9.e) this.f7292q)), (n0) ((k9.e) this.f7293r).c(), (i1) ((k9.e) this.f7294s).c());
    }

    public void d(String str, String str2) {
        HashMap hashMap = (HashMap) this.f7295t;
        if (hashMap == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap.put(str, str2);
    }

    public void e(c2.j1 j1Var, c2.d0 d0Var, i1.t0 t0Var) {
        if (d0Var == null) {
            return;
        }
        if (t0Var.b(d0Var.f2539a) != -1) {
            j1Var.q(d0Var, t0Var);
            return;
        }
        i1.t0 t0Var2 = (i1.t0) ((o9.b1) this.f7292q).get(d0Var);
        if (t0Var2 != null) {
            j1Var.q(d0Var, t0Var2);
        }
    }

    public s6.h g() {
        String str = ((String) this.f7290o) == null ? " transportName" : _UrlKt.FRAGMENT_ENCODE_SET;
        if (((s6.k) this.f7292q) == null) {
            str = str.concat(" encodedPayload");
        }
        if (((Long) this.f7293r) == null) {
            str = r.a.c(str, " eventMillis");
        }
        if (((Long) this.f7294s) == null) {
            str = r.a.c(str, " uptimeMillis");
        }
        if (((HashMap) this.f7295t) == null) {
            str = r.a.c(str, " autoMetadata");
        }
        if (str.isEmpty()) {
            return new s6.h((String) this.f7290o, (Integer) this.f7291p, (s6.k) this.f7292q, ((Long) this.f7293r).longValue(), ((Long) this.f7294s).longValue(), (HashMap) this.f7295t);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public p1.k j(String str) {
        return (p1.k) ((HashMap) this.f7290o).get(str);
    }

    public p1.k k(String str) {
        HashMap hashMap = (HashMap) this.f7290o;
        p1.k kVar = (p1.k) hashMap.get(str);
        if (kVar != null) {
            return kVar;
        }
        SparseArray sparseArray = (SparseArray) this.f7291p;
        int size = sparseArray.size();
        int i10 = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt < 0) {
            while (i10 < size && i10 == sparseArray.keyAt(i10)) {
                i10++;
            }
            keyAt = i10;
        }
        p1.k kVar2 = new p1.k(keyAt, str, p1.o.f9859c);
        hashMap.put(str, kVar2);
        sparseArray.put(keyAt, str);
        ((SparseBooleanArray) this.f7293r).put(keyAt, true);
        ((p1.m) this.f7294s).a(kVar2);
        return kVar2;
    }

    public ColorStateList m(Context context, int i10) {
        if (i10 == R.drawable.abc_edit_text_material) {
            return n4.a.n(context, R.color.abc_tint_edittext);
        }
        if (i10 == R.drawable.abc_switch_track_mtrl_alpha) {
            return n4.a.n(context, R.color.abc_tint_switch_track);
        }
        if (i10 != R.drawable.abc_switch_thumb_material) {
            if (i10 == R.drawable.abc_btn_default_mtrl_shape) {
                return h(context, n2.c(context, R.attr.colorButtonNormal));
            }
            if (i10 == R.drawable.abc_btn_borderless_material) {
                return h(context, 0);
            }
            if (i10 == R.drawable.abc_btn_colored_material) {
                return h(context, n2.c(context, R.attr.colorAccent));
            }
            if (i10 == R.drawable.abc_spinner_mtrl_am_alpha || i10 == R.drawable.abc_spinner_textfield_background_material) {
                return n4.a.n(context, R.color.abc_tint_spinner);
            }
            if (f((int[]) this.f7291p, i10)) {
                return n2.d(context, R.attr.colorControlNormal);
            }
            if (f((int[]) this.f7294s, i10)) {
                return n4.a.n(context, R.color.abc_tint_default);
            }
            if (f((int[]) this.f7295t, i10)) {
                return n4.a.n(context, R.color.abc_tint_btn_checkable);
            }
            if (i10 == R.drawable.abc_seekbar_thumb_material) {
                return n4.a.n(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList d6 = n2.d(context, R.attr.colorSwitchThumbNormal);
        if (d6 == null || !d6.isStateful()) {
            iArr[0] = n2.f8491b;
            iArr2[0] = n2.b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = n2.f8494e;
            iArr2[1] = n2.c(context, R.attr.colorControlActivated);
            iArr[2] = n2.f8495f;
            iArr2[2] = n2.c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = n2.f8491b;
            iArr[0] = iArr3;
            iArr2[0] = d6.getColorForState(iArr3, 0);
            iArr[1] = n2.f8494e;
            iArr2[1] = n2.c(context, R.attr.colorControlActivated);
            iArr[2] = n2.f8495f;
            iArr2[2] = d6.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public void n(long j10) {
        p1.m mVar;
        SparseArray sparseArray = (SparseArray) this.f7291p;
        HashMap hashMap = (HashMap) this.f7290o;
        p1.m mVar2 = (p1.m) this.f7294s;
        mVar2.f(j10);
        p1.m mVar3 = (p1.m) this.f7295t;
        if (mVar3 != null) {
            mVar3.f(j10);
        }
        if (mVar2.b() || (mVar = (p1.m) this.f7295t) == null || !mVar.b()) {
            mVar2.g(hashMap, sparseArray);
        } else {
            ((p1.m) this.f7295t).g(hashMap, sparseArray);
            mVar2.e(hashMap);
        }
        p1.m mVar4 = (p1.m) this.f7295t;
        if (mVar4 != null) {
            mVar4.h();
            this.f7295t = null;
        }
    }

    public void p(String str) {
        SparseArray sparseArray = (SparseArray) this.f7291p;
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.f7293r;
        HashMap hashMap = (HashMap) this.f7290o;
        p1.k kVar = (p1.k) hashMap.get(str);
        if (kVar != null && kVar.f9851c.isEmpty() && kVar.f9852d.isEmpty()) {
            hashMap.remove(str);
            int i10 = kVar.f9849a;
            boolean z10 = sparseBooleanArray.get(i10);
            ((p1.m) this.f7294s).c(kVar, z10);
            if (z10) {
                sparseArray.remove(i10);
                sparseBooleanArray.delete(i10);
            } else {
                sparseArray.put(i10, null);
                ((SparseBooleanArray) this.f7292q).put(i10, true);
            }
        }
    }

    public void r() {
        ((p1.m) this.f7294s).d((HashMap) this.f7290o);
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.f7292q;
        int size = sparseBooleanArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((SparseArray) this.f7291p).remove(sparseBooleanArray.keyAt(i10));
        }
        sparseBooleanArray.clear();
        ((SparseBooleanArray) this.f7293r).clear();
    }

    public void s(i1.t0 t0Var) {
        c2.j1 j1Var = new c2.j1(4);
        if (((o9.g0) this.f7291p).isEmpty()) {
            e(j1Var, (c2.d0) this.f7294s, t0Var);
            if (!Objects.equals((c2.d0) this.f7295t, (c2.d0) this.f7294s)) {
                e(j1Var, (c2.d0) this.f7295t, t0Var);
            }
            if (!Objects.equals((c2.d0) this.f7293r, (c2.d0) this.f7294s) && !Objects.equals((c2.d0) this.f7293r, (c2.d0) this.f7295t)) {
                e(j1Var, (c2.d0) this.f7293r, t0Var);
            }
        } else {
            for (int i10 = 0; i10 < ((o9.g0) this.f7291p).size(); i10++) {
                e(j1Var, (c2.d0) ((o9.g0) this.f7291p).get(i10), t0Var);
            }
            if (!((o9.g0) this.f7291p).contains((c2.d0) this.f7293r)) {
                e(j1Var, (c2.d0) this.f7293r, t0Var);
            }
        }
        this.f7292q = j1Var.c();
    }

    public g1(z1.p pVar, MediaFormat mediaFormat, i1.p pVar2, Surface surface, MediaCrypto mediaCrypto, z1.k kVar) {
        this.f7290o = pVar;
        this.f7291p = mediaFormat;
        this.f7292q = pVar2;
        this.f7293r = surface;
        this.f7294s = mediaCrypto;
        this.f7295t = kVar;
    }
}
