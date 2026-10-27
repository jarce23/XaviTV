package b3;

import android.support.v4.media.d;
import com.bumptech.glide.c;
import com.google.android.gms.internal.cast.n;
import i1.c0;
import i1.e0;
import i1.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2167a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2168b;

    public a(String str, String str2) {
        this.f2167a = c.D(str);
        this.f2168b = str2;
    }

    @Override // i1.e0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // i1.e0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // i1.e0
    public final void c(c0 c0Var) {
        String str = this.f2167a;
        str.getClass();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1935137620:
                if (str.equals("TOTALTRACKS")) {
                    c10 = 0;
                    break;
                }
                break;
            case -215998278:
                if (str.equals("TOTALDISCS")) {
                    c10 = 1;
                    break;
                }
                break;
            case -113312716:
                if (str.equals("TRACKNUMBER")) {
                    c10 = 2;
                    break;
                }
                break;
            case 62359119:
                if (str.equals("ALBUM")) {
                    c10 = 3;
                    break;
                }
                break;
            case 67703139:
                if (str.equals("GENRE")) {
                    c10 = 4;
                    break;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c10 = 5;
                    break;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c10 = 6;
                    break;
                }
                break;
            case 993300766:
                if (str.equals("DISCNUMBER")) {
                    c10 = 7;
                    break;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c10 = '\b';
                    break;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c10 = '\t';
                    break;
                }
                break;
        }
        String str2 = this.f2168b;
        switch (c10) {
            case 0:
                Integer w10 = n.w(str2);
                if (w10 != null) {
                    c0Var.f5824i = w10;
                    break;
                }
                break;
            case 1:
                Integer w11 = n.w(str2);
                if (w11 != null) {
                    c0Var.f5837v = w11;
                    break;
                }
                break;
            case 2:
                Integer w12 = n.w(str2);
                if (w12 != null) {
                    c0Var.f5823h = w12;
                    break;
                }
                break;
            case 3:
                c0Var.f5819c = str2;
                break;
            case 4:
                c0Var.f5838w = str2;
                break;
            case 5:
                c0Var.f5817a = str2;
                break;
            case 6:
                c0Var.f5821e = str2;
                break;
            case 7:
                Integer w13 = n.w(str2);
                if (w13 != null) {
                    c0Var.f5836u = w13;
                    break;
                }
                break;
            case '\b':
                c0Var.f5820d = str2;
                break;
            case '\t':
                c0Var.f5818b = str2;
                break;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f2167a.equals(aVar.f2167a) && this.f2168b.equals(aVar.f2168b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2168b.hashCode() + d.g(this.f2167a, 527, 31);
    }

    public final String toString() {
        return "VC: " + this.f2167a + "=" + this.f2168b;
    }
}
