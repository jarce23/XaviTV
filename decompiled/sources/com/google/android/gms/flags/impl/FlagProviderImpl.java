package com.google.android.gms.flags.impl;

import a8.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.cast.n;
import z7.b;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@DynamiteApi
/* loaded from: classes.dex */
public class FlagProviderImpl extends b {

    /* renamed from: b, reason: collision with root package name */
    public boolean f3233b;

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f3234c;

    public FlagProviderImpl() {
        attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
        this.f3233b = false;
    }

    @Override // z7.c
    public boolean getBooleanFlagValue(String str, boolean z10, int i10) {
        if (!this.f3233b) {
            return z10;
        }
        SharedPreferences sharedPreferences = this.f3234c;
        Boolean valueOf = Boolean.valueOf(z10);
        try {
            valueOf = (Boolean) n.x(new a(sharedPreferences, str, valueOf, 0));
        } catch (Exception e7) {
            String valueOf2 = String.valueOf(e7.getMessage());
            Log.w("FlagDataUtils", valueOf2.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf2) : new String("Flag value not available, returning default: "));
        }
        return valueOf.booleanValue();
    }

    @Override // z7.c
    public int getIntFlagValue(String str, int i10, int i11) {
        if (!this.f3233b) {
            return i10;
        }
        SharedPreferences sharedPreferences = this.f3234c;
        Integer valueOf = Integer.valueOf(i10);
        try {
            valueOf = (Integer) n.x(new a(sharedPreferences, str, valueOf, 1));
        } catch (Exception e7) {
            String valueOf2 = String.valueOf(e7.getMessage());
            Log.w("FlagDataUtils", valueOf2.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf2) : new String("Flag value not available, returning default: "));
        }
        return valueOf.intValue();
    }

    @Override // z7.c
    public long getLongFlagValue(String str, long j10, int i10) {
        if (!this.f3233b) {
            return j10;
        }
        SharedPreferences sharedPreferences = this.f3234c;
        Long valueOf = Long.valueOf(j10);
        try {
            valueOf = (Long) n.x(new a(sharedPreferences, str, valueOf, 2));
        } catch (Exception e7) {
            String valueOf2 = String.valueOf(e7.getMessage());
            Log.w("FlagDataUtils", valueOf2.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf2) : new String("Flag value not available, returning default: "));
        }
        return valueOf.longValue();
    }

    @Override // z7.c
    public String getStringFlagValue(String str, String str2, int i10) {
        if (!this.f3233b) {
            return str2;
        }
        try {
            return (String) n.x(new a(this.f3234c, str, str2, 3));
        } catch (Exception e7) {
            String valueOf = String.valueOf(e7.getMessage());
            Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
            return str2;
        }
    }

    @Override // z7.c
    public void init(x7.a aVar) {
        Context context = (Context) x7.b.z0(aVar);
        if (this.f3233b) {
            return;
        }
        try {
            this.f3234c = a.a.v(context.createPackageContext("com.google.android.gms", 0));
            this.f3233b = true;
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e7) {
            String valueOf = String.valueOf(e7.getMessage());
            Log.w("FlagProviderImpl", valueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
        }
    }
}
