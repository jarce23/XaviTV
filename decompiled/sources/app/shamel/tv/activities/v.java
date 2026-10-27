package app.shamel.tv.activities;

import android.content.res.TypedArray;
import android.os.Handler;
import android.util.SparseArray;
import android.widget.Toast;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import app.shamel.tv.models.EPGChannel;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v implements h5.g0 {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2060o;

    /* renamed from: p, reason: collision with root package name */
    public int f2061p;

    /* renamed from: q, reason: collision with root package name */
    public int f2062q;

    /* renamed from: r, reason: collision with root package name */
    public Object f2063r;

    /* renamed from: s, reason: collision with root package name */
    public Object f2064s;

    public /* synthetic */ v(f.j jVar, int i10, int i11, EPGChannel ePGChannel, int i12) {
        this.f2060o = i12;
        this.f2064s = jVar;
        this.f2061p = i10;
        this.f2062q = i11;
        this.f2063r = ePGChannel;
    }

    public synchronized void a(long j10, Object obj) {
        if (this.f2062q > 0) {
            if (j10 <= ((long[]) this.f2063r)[((this.f2061p + r0) - 1) % ((Object[]) this.f2064s).length]) {
                b();
            }
        }
        c();
        int i10 = this.f2061p;
        int i11 = this.f2062q;
        Object[] objArr = (Object[]) this.f2064s;
        int length = (i10 + i11) % objArr.length;
        ((long[]) this.f2063r)[length] = j10;
        objArr[length] = obj;
        this.f2062q = i11 + 1;
    }

    public synchronized void b() {
        this.f2061p = 0;
        this.f2062q = 0;
        Arrays.fill((Object[]) this.f2064s, (Object) null);
    }

    public void c() {
        int length = ((Object[]) this.f2064s).length;
        if (this.f2062q < length) {
            return;
        }
        int i10 = length * 2;
        long[] jArr = new long[i10];
        Object[] objArr = new Object[i10];
        int i11 = this.f2061p;
        int i12 = length - i11;
        System.arraycopy((long[]) this.f2063r, i11, jArr, 0, i12);
        System.arraycopy((Object[]) this.f2064s, this.f2061p, objArr, 0, i12);
        int i13 = this.f2061p;
        if (i13 > 0) {
            System.arraycopy((long[]) this.f2063r, 0, jArr, i12, i13);
            System.arraycopy((Object[]) this.f2064s, 0, objArr, i12, this.f2061p);
        }
        this.f2063r = jArr;
        this.f2064s = objArr;
        this.f2061p = 0;
    }

    public Object d(long j10, boolean z10) {
        Object obj = null;
        long j11 = Long.MAX_VALUE;
        while (this.f2062q > 0) {
            long j12 = j10 - ((long[]) this.f2063r)[this.f2061p];
            if (j12 < 0 && (z10 || (-j12) >= j11)) {
                break;
            }
            obj = g();
            j11 = j12;
        }
        return obj;
    }

    public synchronized Object e() {
        return this.f2062q == 0 ? null : g();
    }

    public synchronized Object f(long j10) {
        return d(j10, true);
    }

    public Object g() {
        l1.d.g(this.f2062q > 0);
        Object[] objArr = (Object[]) this.f2064s;
        int i10 = this.f2061p;
        Object obj = objArr[i10];
        objArr[i10] = null;
        this.f2061p = (i10 + 1) % objArr.length;
        this.f2062q--;
        return obj;
    }

    public synchronized int h() {
        return this.f2062q;
    }

    @Override // h5.g0
    public void t() {
        switch (this.f2060o) {
            case 0:
                LiveActivity liveActivity = (LiveActivity) this.f2064s;
                Toast.makeText(liveActivity, liveActivity.f1649b1.getPut_pin_code(), 0).show();
                break;
            case 1:
                LiveChannelActivity liveChannelActivity = (LiveChannelActivity) this.f2064s;
                Toast.makeText(liveChannelActivity, liveChannelActivity.Z0.getPut_pin_code(), 0).show();
                break;
            case 2:
                LiveChannelMobileActivity liveChannelMobileActivity = (LiveChannelMobileActivity) this.f2064s;
                Toast.makeText(liveChannelMobileActivity, liveChannelMobileActivity.P0.getPut_pin_code(), 0).show();
                break;
            default:
                LiveMobileActivity liveMobileActivity = (LiveMobileActivity) this.f2064s;
                Toast.makeText(liveMobileActivity, liveMobileActivity.Q0.getPut_pin_code(), 0).show();
                break;
        }
    }

    @Override // h5.g0
    public void u() {
        switch (this.f2060o) {
            case 0:
                LiveActivity liveActivity = (LiveActivity) this.f2064s;
                Toast.makeText(liveActivity, liveActivity.f1649b1.getPin_incorrect(), 0).show();
                break;
            case 1:
                LiveChannelActivity liveChannelActivity = (LiveChannelActivity) this.f2064s;
                Toast.makeText(liveChannelActivity, liveChannelActivity.Z0.getPin_incorrect(), 0).show();
                break;
            case 2:
                LiveChannelMobileActivity liveChannelMobileActivity = (LiveChannelMobileActivity) this.f2064s;
                Toast.makeText(liveChannelMobileActivity, liveChannelMobileActivity.P0.getPin_incorrect(), 0).show();
                break;
            default:
                LiveMobileActivity liveMobileActivity = (LiveMobileActivity) this.f2064s;
                Toast.makeText(liveMobileActivity, liveMobileActivity.Q0.getPin_incorrect(), 0).show();
                break;
        }
    }

    @Override // h5.g0
    public void y() {
        switch (this.f2060o) {
            case 0:
                int i10 = this.f2062q;
                EPGChannel ePGChannel = (EPGChannel) this.f2063r;
                LiveActivity liveActivity = (LiveActivity) this.f2064s;
                Handler handler = liveActivity.f1667l1;
                int i11 = this.f2061p;
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 == 3) {
                                liveActivity.H((EPGChannel) liveActivity.X.get(liveActivity.f1653d1));
                                liveActivity.f1661i1 = ((EPGChannel) liveActivity.X.get(liveActivity.f1653d1)).getStream_id();
                                if (liveActivity.f1682x0.g()) {
                                    liveActivity.R(null);
                                } else {
                                    handler.removeCallbacks(liveActivity.Z);
                                    liveActivity.y(liveActivity.f1661i1);
                                }
                                liveActivity.S0.setText(liveActivity.T);
                                liveActivity.v(liveActivity.f1653d1);
                                liveActivity.f1684z0.requestFocus();
                                liveActivity.f1684z0.setSelectedPosition(liveActivity.f1653d1);
                                liveActivity.f1684z0.e0(liveActivity.f1653d1);
                                break;
                            } else if (i11 == 4) {
                                int i12 = LiveActivity.f1645p1;
                                liveActivity.x(ePGChannel, i10);
                                liveActivity.T(!ePGChannel.is_locked());
                                if (!ePGChannel.is_locked()) {
                                    Toast.makeText(liveActivity, liveActivity.f1649b1.getChannel_locked(), 0).show();
                                    break;
                                } else {
                                    Toast.makeText(liveActivity, liveActivity.f1649b1.getChannel_unlocked(), 0).show();
                                    break;
                                }
                            }
                        } else {
                            int i13 = LiveActivity.f1645p1;
                            liveActivity.H(ePGChannel);
                            liveActivity.f1684z0.setSelectedPosition(liveActivity.f1653d1);
                            handler.removeCallbacks(liveActivity.Z);
                            liveActivity.A(liveActivity.f1661i1);
                            liveActivity.v(liveActivity.f1653d1);
                            if (liveActivity.f1675q0.getVisibility() == 8 && liveActivity.f1665k1) {
                                liveActivity.f1675q0.setVisibility(0);
                            }
                            handler.removeCallbacks(liveActivity.f1650c0);
                            liveActivity.E();
                            break;
                        }
                    } else {
                        int i14 = LiveActivity.f1645p1;
                        liveActivity.H(ePGChannel);
                        if (liveActivity.f1682x0.g()) {
                            liveActivity.R(null);
                        } else {
                            handler.removeCallbacks(liveActivity.Z);
                            liveActivity.y(liveActivity.f1661i1);
                        }
                        liveActivity.v(liveActivity.f1653d1);
                        if (liveActivity.f1675q0.getVisibility() == 8) {
                            liveActivity.f1675q0.setVisibility(0);
                        }
                        handler.removeCallbacks(liveActivity.f1650c0);
                        liveActivity.E();
                        liveActivity.S0.setText(liveActivity.T);
                        liveActivity.f1684z0.setSelectedPosition(liveActivity.f1653d1);
                        break;
                    }
                } else {
                    liveActivity.f1653d1 = i10;
                    liveActivity.H(ePGChannel);
                    break;
                }
                break;
            case 1:
                int i15 = this.f2062q;
                EPGChannel ePGChannel2 = (EPGChannel) this.f2063r;
                LiveChannelActivity liveChannelActivity = (LiveChannelActivity) this.f2064s;
                Handler handler2 = liveChannelActivity.f1701i1;
                int i16 = this.f2061p;
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            liveChannelActivity.E(liveChannelActivity.f1708m0);
                            liveChannelActivity.f1719x0.setSelectedPosition(liveChannelActivity.f1689b1);
                            handler2.removeCallbacks(liveChannelActivity.Y);
                            liveChannelActivity.z(liveChannelActivity.f1697f1);
                            liveChannelActivity.u(liveChannelActivity.f1689b1);
                            if (liveChannelActivity.f1711p0.getVisibility() == 8 && liveChannelActivity.h1) {
                                liveChannelActivity.f1711p0.setVisibility(0);
                            }
                            handler2.removeCallbacks(liveChannelActivity.f1688b0);
                            liveChannelActivity.B();
                            break;
                        } else if (i16 == 3) {
                            int i17 = LiveChannelActivity.f1685m1;
                            liveChannelActivity.w(ePGChannel2, i15);
                            liveChannelActivity.P(!ePGChannel2.is_locked());
                            if (!ePGChannel2.is_locked()) {
                                Toast.makeText(liveChannelActivity, liveChannelActivity.Z0.getChannel_locked(), 0).show();
                                break;
                            } else {
                                Toast.makeText(liveChannelActivity, liveChannelActivity.Z0.getChannel_unlocked(), 0).show();
                                break;
                            }
                        }
                    } else {
                        int i18 = LiveChannelActivity.f1685m1;
                        liveChannelActivity.E(ePGChannel2);
                        if (liveChannelActivity.f1718w0.g()) {
                            liveChannelActivity.N(null);
                        } else {
                            handler2.removeCallbacks(liveChannelActivity.Y);
                            liveChannelActivity.x(liveChannelActivity.f1697f1);
                        }
                        liveChannelActivity.u(liveChannelActivity.f1689b1);
                        if (liveChannelActivity.f1711p0.getVisibility() == 8 && liveChannelActivity.h1) {
                            liveChannelActivity.f1711p0.setVisibility(0);
                        }
                        handler2.removeCallbacks(liveChannelActivity.f1688b0);
                        liveChannelActivity.B();
                        liveChannelActivity.Q0.setText(liveChannelActivity.S);
                        liveChannelActivity.f1719x0.setSelectedPosition(liveChannelActivity.f1689b1);
                        break;
                    }
                } else {
                    liveChannelActivity.f1689b1 = i15;
                    liveChannelActivity.E(ePGChannel2);
                    break;
                }
                break;
            case 2:
                int i19 = this.f2062q;
                EPGChannel ePGChannel3 = (EPGChannel) this.f2063r;
                LiveChannelMobileActivity liveChannelMobileActivity = (LiveChannelMobileActivity) this.f2064s;
                Handler handler3 = liveChannelMobileActivity.W0;
                int i20 = this.f2061p;
                if (i20 != 0) {
                    if (i20 != 1) {
                        if (i20 == 2) {
                            int i21 = LiveChannelMobileActivity.f1913j1;
                            liveChannelMobileActivity.F(ePGChannel3);
                            liveChannelMobileActivity.f1943w0.e0(liveChannelMobileActivity.R0);
                            handler3.removeCallbacks(liveChannelMobileActivity.f1931k0);
                            LiveChannelMobileActivity.u(liveChannelMobileActivity, liveChannelMobileActivity.U0);
                            liveChannelMobileActivity.x(liveChannelMobileActivity.R0);
                            if (liveChannelMobileActivity.f1937q0.getVisibility() == 8 && liveChannelMobileActivity.V0) {
                                liveChannelMobileActivity.f1937q0.setVisibility(0);
                            }
                            handler3.removeCallbacks(liveChannelMobileActivity.f1932l0);
                            liveChannelMobileActivity.E();
                            break;
                        } else if (i20 == 3) {
                            int i22 = LiveChannelMobileActivity.f1913j1;
                            liveChannelMobileActivity.z(ePGChannel3, i19);
                            liveChannelMobileActivity.O(!ePGChannel3.is_locked());
                            if (!ePGChannel3.is_locked()) {
                                Toast.makeText(liveChannelMobileActivity, liveChannelMobileActivity.P0.getChannel_locked(), 0).show();
                                break;
                            } else {
                                Toast.makeText(liveChannelMobileActivity, liveChannelMobileActivity.P0.getChannel_unlocked(), 0).show();
                                break;
                            }
                        }
                    } else {
                        liveChannelMobileActivity.F((EPGChannel) liveChannelMobileActivity.f1928i0.get(liveChannelMobileActivity.R0));
                        if (liveChannelMobileActivity.f1942v0.g()) {
                            liveChannelMobileActivity.M(null);
                        } else {
                            handler3.removeCallbacks(liveChannelMobileActivity.f1931k0);
                            liveChannelMobileActivity.A(liveChannelMobileActivity.U0);
                        }
                        liveChannelMobileActivity.x(liveChannelMobileActivity.R0);
                        liveChannelMobileActivity.J0.setText(liveChannelMobileActivity.f1922e0);
                        if (liveChannelMobileActivity.f1937q0.getVisibility() == 8) {
                            liveChannelMobileActivity.f1937q0.setVisibility(0);
                        }
                        handler3.removeCallbacks(liveChannelMobileActivity.f1932l0);
                        liveChannelMobileActivity.E();
                        liveChannelMobileActivity.f1943w0.e0(liveChannelMobileActivity.R0);
                        break;
                    }
                } else {
                    liveChannelMobileActivity.R0 = i19;
                    liveChannelMobileActivity.F(ePGChannel3);
                    if (liveChannelMobileActivity.f1942v0.g()) {
                        liveChannelMobileActivity.M(null);
                    } else {
                        handler3.removeCallbacks(liveChannelMobileActivity.f1931k0);
                        liveChannelMobileActivity.A(ePGChannel3.getStream_id());
                    }
                    String name = ePGChannel3.getName();
                    liveChannelMobileActivity.f1922e0 = name;
                    liveChannelMobileActivity.J0.setText(name);
                    liveChannelMobileActivity.N(ePGChannel3.is_favorite());
                    liveChannelMobileActivity.x(liveChannelMobileActivity.R0);
                    break;
                }
                break;
            default:
                int i23 = this.f2062q;
                EPGChannel ePGChannel4 = (EPGChannel) this.f2063r;
                LiveMobileActivity liveMobileActivity = (LiveMobileActivity) this.f2064s;
                Handler handler4 = liveMobileActivity.X0;
                int i24 = this.f2061p;
                if (i24 != 0) {
                    if (i24 != 1) {
                        if (i24 != 2) {
                            if (i24 == 3) {
                                liveMobileActivity.G((EPGChannel) liveMobileActivity.f1964j0.get(liveMobileActivity.S0));
                                liveMobileActivity.V0 = ((EPGChannel) liveMobileActivity.f1964j0.get(liveMobileActivity.S0)).getStream_id();
                                if (liveMobileActivity.f1978w0.g()) {
                                    liveMobileActivity.N(null);
                                } else {
                                    handler4.removeCallbacks(liveMobileActivity.f1967l0);
                                    liveMobileActivity.B(liveMobileActivity.V0);
                                }
                                liveMobileActivity.K0.setText(liveMobileActivity.f1958f0);
                                liveMobileActivity.y(liveMobileActivity.S0);
                                liveMobileActivity.f1980y0.requestFocus();
                                liveMobileActivity.f1980y0.e0(liveMobileActivity.S0);
                                break;
                            } else if (i24 == 4) {
                                int i25 = LiveMobileActivity.f1947k1;
                                liveMobileActivity.A(ePGChannel4, i23);
                                liveMobileActivity.P(!ePGChannel4.is_locked());
                                if (!ePGChannel4.is_locked()) {
                                    Toast.makeText(liveMobileActivity, liveMobileActivity.Q0.getChannel_locked(), 0).show();
                                    break;
                                } else {
                                    Toast.makeText(liveMobileActivity, liveMobileActivity.Q0.getChannel_unlocked(), 0).show();
                                    break;
                                }
                            }
                        } else {
                            int i26 = LiveMobileActivity.f1947k1;
                            liveMobileActivity.G(ePGChannel4);
                            liveMobileActivity.f1980y0.e0(liveMobileActivity.S0);
                            handler4.removeCallbacks(liveMobileActivity.f1967l0);
                            LiveMobileActivity.u(liveMobileActivity, liveMobileActivity.V0);
                            liveMobileActivity.y(liveMobileActivity.S0);
                            if (liveMobileActivity.f1973r0.getVisibility() == 8 && liveMobileActivity.W0) {
                                liveMobileActivity.f1973r0.setVisibility(0);
                            }
                            handler4.removeCallbacks(liveMobileActivity.f1970o0);
                            liveMobileActivity.F();
                            break;
                        }
                    } else {
                        liveMobileActivity.G((EPGChannel) liveMobileActivity.f1964j0.get(liveMobileActivity.S0));
                        if (liveMobileActivity.f1978w0.g()) {
                            liveMobileActivity.N(null);
                        } else {
                            handler4.removeCallbacks(liveMobileActivity.f1967l0);
                            liveMobileActivity.B(liveMobileActivity.V0);
                        }
                        liveMobileActivity.y(liveMobileActivity.S0);
                        if (liveMobileActivity.f1973r0.getVisibility() == 8) {
                            liveMobileActivity.f1973r0.setVisibility(0);
                        }
                        handler4.removeCallbacks(liveMobileActivity.f1970o0);
                        liveMobileActivity.F();
                        liveMobileActivity.K0.setText(liveMobileActivity.f1958f0);
                        liveMobileActivity.f1980y0.e0(liveMobileActivity.S0);
                        break;
                    }
                } else {
                    liveMobileActivity.S0 = i23;
                    liveMobileActivity.G(ePGChannel4);
                    if (liveMobileActivity.f1978w0.g()) {
                        liveMobileActivity.N(null);
                    } else {
                        handler4.removeCallbacks(liveMobileActivity.f1967l0);
                        liveMobileActivity.B(ePGChannel4.getStream_id());
                    }
                    String name2 = ePGChannel4.getName();
                    liveMobileActivity.f1958f0 = name2;
                    liveMobileActivity.K0.setText(name2);
                    liveMobileActivity.O(ePGChannel4.is_favorite());
                    liveMobileActivity.y(liveMobileActivity.S0);
                    break;
                }
                break;
        }
    }

    public v() {
        this.f2060o = 8;
        this.f2063r = new long[10];
        this.f2064s = new Object[10];
    }

    public v(int i10, float[] fArr, float[] fArr2, int i11) {
        this.f2060o = 6;
        this.f2061p = i10;
        l1.d.b(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
        this.f2063r = fArr;
        this.f2064s = fArr2;
        this.f2062q = i11;
    }

    public v(v vVar) {
        this.f2060o = 7;
        float[] fArr = (float[]) vVar.f2063r;
        this.f2061p = fArr.length / 3;
        this.f2063r = l1.b.e(fArr);
        this.f2064s = l1.b.e((float[]) vVar.f2064s);
        int i10 = vVar.f2062q;
        if (i10 == 1) {
            this.f2062q = 5;
        } else if (i10 != 2) {
            this.f2062q = 4;
        } else {
            this.f2062q = 6;
        }
    }

    public v(g9.p pVar, android.support.v4.media.session.a0 a0Var) {
        this.f2060o = 5;
        this.f2063r = new SparseArray();
        this.f2064s = pVar;
        TypedArray typedArray = (TypedArray) a0Var.f231q;
        this.f2061p = typedArray.getResourceId(28, 0);
        this.f2062q = typedArray.getResourceId(53, 0);
    }

    public v(int i10) {
        this.f2060o = 4;
        this.f2063r = new e3.r[i10];
        this.f2062q = 0;
    }
}
