package app.shamel.tv;

import a6.h0;
import a6.n;
import android.graphics.Bitmap;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.View;
import android.widget.Toast;
import app.shamel.tv.activities.LiveActivity;
import app.shamel.tv.activities.MovieActivity;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.helper.s;
import app.shamel.tv.models.CategoryModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d5.x0;
import h5.g0;
import io.realm.n0;
import j9.j0;
import j9.p;
import j9.q0;
import j9.r0;
import j9.t0;
import j9.u0;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import k2.k;
import l1.t;
import n0.q;
import okhttp3.internal.url._UrlKt;
import r5.h;
import r7.r;
import t5.y;
import z1.v;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements g0, s, f6.b, t0, q, v {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2094o;

    /* renamed from: p, reason: collision with root package name */
    public int f2095p;

    /* renamed from: q, reason: collision with root package name */
    public Object f2096q;

    public /* synthetic */ b(int i10, int i11, Object obj) {
        this.f2094o = i11;
        this.f2096q = obj;
        this.f2095p = i10;
    }

    public void a(long j10) {
        int i10 = this.f2095p;
        long[] jArr = (long[]) this.f2096q;
        if (i10 == jArr.length) {
            this.f2096q = Arrays.copyOf(jArr, i10 * 2);
        }
        long[] jArr2 = (long[]) this.f2096q;
        int i11 = this.f2095p;
        this.f2095p = i11 + 1;
        jArr2[i11] = j10;
    }

    public void b(long[] jArr) {
        int length = this.f2095p + jArr.length;
        long[] jArr2 = (long[]) this.f2096q;
        if (length > jArr2.length) {
            this.f2096q = Arrays.copyOf(jArr2, Math.max(jArr2.length * 2, length));
        }
        System.arraycopy(jArr, 0, (long[]) this.f2096q, this.f2095p, jArr.length);
        this.f2095p = length;
    }

    @Override // j9.t0
    public Object c() {
        u0 u0Var = (u0) this.f2096q;
        int i10 = this.f2095p;
        r0 a10 = u0Var.a(i10);
        p pVar = u0Var.f7458a;
        int i11 = a10.f7425b;
        q0 q0Var = a10.f7426c;
        int i12 = q0Var.f7419d;
        long j10 = q0Var.f7417b;
        String str = q0Var.f7416a;
        if (i12 != 5 && i12 != 6 && i12 != 4) {
            throw new j0(String.format("Could not safely delete session %d because it is not in a terminal state.", Integer.valueOf(i10)), i10);
        }
        if (pVar.c(i11, str, j10).exists()) {
            p.f(pVar.c(i11, str, j10));
        }
        int i13 = q0Var.f7419d;
        if ((i13 != 5 && i13 != 6) || !pVar.h(i11, str, j10).exists()) {
            return null;
        }
        p.f(pVar.h(i11, str, j10));
        return null;
    }

    @Override // z1.v
    public MediaCodecInfo d(int i10) {
        if (((MediaCodecInfo[]) this.f2096q) == null) {
            this.f2096q = new MediaCodecList(this.f2095p).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f2096q)[i10];
    }

    public long e(int i10) {
        if (i10 >= 0 && i10 < this.f2095p) {
            return ((long[]) this.f2096q)[i10];
        }
        StringBuilder f10 = r.a.f("Invalid index ", i10, ", size is ");
        f10.append(this.f2095p);
        throw new IndexOutOfBoundsException(f10.toString());
    }

    @Override // n0.q
    public boolean f(View view) {
        ((BottomSheetBehavior) this.f2096q).B(this.f2095p);
        return true;
    }

    public long g(k kVar) {
        t tVar = (t) this.f2096q;
        int i10 = 0;
        kVar.m(tVar.f8129a, 0, 1, false);
        int i11 = tVar.f8129a[0] & 255;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int i12 = 128;
        int i13 = 0;
        while ((i11 & i12) == 0) {
            i12 >>= 1;
            i13++;
        }
        int i14 = i11 & (~i12);
        kVar.m(tVar.f8129a, 1, i13, false);
        while (i10 < i13) {
            i10++;
            i14 = (tVar.f8129a[i10] & 255) + (i14 << 8);
        }
        this.f2095p = i13 + 1 + this.f2095p;
        return i14;
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        LiveChannelMobileActivity liveChannelMobileActivity = (LiveChannelMobileActivity) this.f2096q;
        if (((CategoryModel) liveChannelMobileActivity.f1916b0.get(liveChannelMobileActivity.Q0)).getId().equalsIgnoreCase("lock_id")) {
            n0 w10 = n.K().w((CategoryModel) liveChannelMobileActivity.f1916b0.get(liveChannelMobileActivity.Q0), _UrlKt.FRAGMENT_ENCODE_SET, liveChannelMobileActivity.f1942v0.g(), liveChannelMobileActivity.f1942v0.o());
            liveChannelMobileActivity.f1928i0 = w10;
            liveChannelMobileActivity.f1918c0.q(0, w10);
        } else {
            liveChannelMobileActivity.f1918c0.e(this.f2095p);
        }
        liveChannelMobileActivity.f1942v0.T(n.K().x());
    }

    @Override // z1.v
    public boolean k(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // z1.v
    public int l() {
        if (((MediaCodecInfo[]) this.f2096q) == null) {
            this.f2096q = new MediaCodecList(this.f2095p).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f2096q).length;
    }

    @Override // f6.b
    public y r(y yVar, h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) yVar.get()).compress((Bitmap.CompressFormat) this.f2096q, this.f2095p, byteArrayOutputStream);
        yVar.e();
        return new h0(byteArrayOutputStream.toByteArray());
    }

    @Override // h5.g0
    public void t() {
        switch (this.f2094o) {
            case 1:
                LiveActivity liveActivity = (LiveActivity) this.f2096q;
                Toast.makeText(liveActivity, liveActivity.f1649b1.getPut_pin_code(), 0).show();
                break;
            default:
                MovieActivity movieActivity = (MovieActivity) this.f2096q;
                Toast.makeText(movieActivity, movieActivity.f1727e0.getPut_pin_code(), 0).show();
                break;
        }
    }

    @Override // h5.g0
    public void u() {
        switch (this.f2094o) {
            case 1:
                LiveActivity liveActivity = (LiveActivity) this.f2096q;
                Toast.makeText(liveActivity, liveActivity.f1649b1.getPin_incorrect(), 0).show();
                break;
            default:
                MovieActivity movieActivity = (MovieActivity) this.f2096q;
                Toast.makeText(movieActivity, movieActivity.f1727e0.getPin_incorrect(), 0).show();
                break;
        }
    }

    @Override // z1.v
    public boolean x(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // h5.g0
    public void y() {
        switch (this.f2094o) {
            case 1:
                LiveActivity liveActivity = (LiveActivity) this.f2096q;
                int i10 = this.f2095p;
                liveActivity.f1651c1 = i10;
                liveActivity.f1669m1 = (liveActivity.f1651c1 + 1) + " • Group : " + ((CategoryModel) liveActivity.Q.get(liveActivity.f1651c1)).getName();
                liveActivity.X = n.K().w((CategoryModel) liveActivity.Q.get(i10), _UrlKt.FRAGMENT_ENCODE_SET, liveActivity.f1682x0.g(), liveActivity.f1682x0.o());
                liveActivity.R.q(-1, liveActivity.X);
                liveActivity.f1684z0.setSelectedPosition(0);
                break;
            default:
                MovieActivity movieActivity = (MovieActivity) this.f2096q;
                int i11 = this.f2095p;
                movieActivity.f1729g0 = i11;
                movieActivity.O.setText(_UrlKt.FRAGMENT_ENCODE_SET);
                movieActivity.R = n.K().A((CategoryModel) movieActivity.N.get(i11), _UrlKt.FRAGMENT_ENCODE_SET, movieActivity.S.g(), movieActivity.h0);
                movieActivity.X.setText(((CategoryModel) movieActivity.N.get(i11)).getName() + "(" + movieActivity.R.size() + ")");
                movieActivity.f1726d0.p(movieActivity.R);
                x0 x0Var = movieActivity.f1726d0;
                int i12 = x0Var.f4219j;
                x0Var.f4219j = -1;
                x0Var.e(i12);
                x0Var.e(x0Var.f4219j);
                movieActivity.U.setSelectedPosition(0);
                break;
        }
    }

    @Override // z1.v
    public boolean z() {
        return true;
    }

    public b(n7.a aVar, int i10) {
        this.f2094o = 11;
        r.e(aVar);
        this.f2096q = aVar;
        this.f2095p = i10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(byte b2, int i10) {
        this(32);
        this.f2094o = i10;
        switch (i10) {
            case 5:
                this.f2096q = Bitmap.CompressFormat.JPEG;
                this.f2095p = 100;
                break;
            case 6:
            case 8:
            default:
                this.f2096q = new t(8);
                break;
            case 7:
                break;
            case 9:
                break;
        }
    }

    public b(int i10) {
        this.f2094o = 9;
        this.f2096q = new long[i10];
    }

    public b(boolean z10, boolean z11, boolean z12) {
        this.f2094o = 13;
        this.f2095p = (z10 || z11 || z12) ? 1 : 0;
    }
}
