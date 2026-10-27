package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.support.v4.media.d;
import com.bumptech.glide.e;
import d9.f;
import j9.i1;
import j9.n0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class bs {

    /* renamed from: a, reason: collision with root package name */
    public final String f3907a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3908b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3909c;

    /* renamed from: d, reason: collision with root package name */
    public final long f3910d;

    /* renamed from: e, reason: collision with root package name */
    public final long f3911e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3912f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final String f3913h;

    /* renamed from: i, reason: collision with root package name */
    public final String f3914i;

    public bs(String str, int i10, int i11, long j10, long j11, int i12, int i13, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.f3907a = str;
        this.f3908b = i10;
        this.f3909c = i11;
        this.f3910d = j10;
        this.f3911e = j11;
        this.f3912f = i12;
        this.g = i13;
        if (str2 == null) {
            throw new NullPointerException("Null availableVersionTag");
        }
        this.f3913h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null installedVersionTag");
        }
        this.f3914i = str3;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0014. Please report as an issue. */
    public static bs a(Bundle bundle, String str, n0 n0Var, i1 i1Var, f fVar) {
        double doubleValue;
        int i10;
        int i11;
        int i12 = bundle.getInt(e.a("status", str));
        switch (fVar.f4257o) {
        }
        int i13 = bundle.getInt(e.a("error_code", str));
        long j10 = bundle.getLong(e.a("bytes_downloaded", str));
        long j11 = bundle.getLong(e.a("total_bytes_to_download", str));
        synchronized (n0Var) {
            Double d6 = (Double) n0Var.f7391a.get(str);
            doubleValue = d6 == null ? 0.0d : d6.doubleValue();
        }
        long j12 = bundle.getLong(e.a("pack_version", str));
        long j13 = bundle.getLong(e.a("pack_base_version", str));
        int i14 = 1;
        if (i12 == 4) {
            if (j13 != 0 && j13 != j12) {
                i14 = 2;
            }
            i10 = i14;
            i11 = 4;
        } else {
            i10 = 1;
            i11 = i12;
        }
        return new bs(str, i11, i13, j10, j11, (int) Math.rint(doubleValue * 100.0d), i10, bundle.getString(e.a("pack_version_tag", str), String.valueOf(bundle.getInt("app_version_code"))), i1Var.a(str));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bs) {
            bs bsVar = (bs) obj;
            if (this.f3907a.equals(bsVar.f3907a) && this.f3908b == bsVar.f3908b && this.f3909c == bsVar.f3909c && this.f3910d == bsVar.f3910d && this.f3911e == bsVar.f3911e && this.f3912f == bsVar.f3912f && this.g == bsVar.g && this.f3913h.equals(bsVar.f3913h) && this.f3914i.equals(bsVar.f3914i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f3907a.hashCode() ^ 1000003;
        long j10 = this.f3911e;
        long j11 = j10 ^ (j10 >>> 32);
        long j12 = this.f3910d;
        return (((((((((((((((hashCode * 1000003) ^ this.f3908b) * 1000003) ^ this.f3909c) * 1000003) ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003) ^ ((int) j11)) * 1000003) ^ this.f3912f) * 1000003) ^ this.g) * 1000003) ^ this.f3913h.hashCode()) * 1000003) ^ this.f3914i.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AssetPackState{name=");
        sb2.append(this.f3907a);
        sb2.append(", status=");
        sb2.append(this.f3908b);
        sb2.append(", errorCode=");
        sb2.append(this.f3909c);
        sb2.append(", bytesDownloaded=");
        sb2.append(this.f3910d);
        sb2.append(", totalBytesToDownload=");
        sb2.append(this.f3911e);
        sb2.append(", transferProgressPercentage=");
        sb2.append(this.f3912f);
        sb2.append(", updateAvailability=");
        sb2.append(this.g);
        sb2.append(", availableVersionTag=");
        sb2.append(this.f3913h);
        sb2.append(", installedVersionTag=");
        return d.r(sb2, this.f3914i, "}");
    }
}
